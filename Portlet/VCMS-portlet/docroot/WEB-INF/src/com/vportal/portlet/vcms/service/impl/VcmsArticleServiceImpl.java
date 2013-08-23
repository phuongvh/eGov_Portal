/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.vportal.portlet.vcms.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.vportal.portal.kernel.security.permission.ActionKeysExt;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portal.util.PropsUtilExt;
import com.vportal.portlet.vcms.InvalidArticleContentException;
import com.vportal.portlet.vcms.InvalidArticleTitleException;
import com.vportal.portlet.vcms.NoSuchVcmsArticleException;
import com.vportal.portlet.vcms.action.ActionUtil;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsArticleType;
import com.vportal.portlet.vcms.model.VcmsArticleVersion;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPortionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsArticleServiceBaseImpl;
import com.vportal.portlet.vcms.service.permission.VcmsArticlePermission;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleVersionUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsAttachedMessageUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsCARelationUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsDiscussionUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsPARelationUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsStatusUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsTARelationUtil;
import com.vportal.portlet.vcms.util.WebKeysExt;
import com.vportal.util.ImageUtilExt;

/**
 * The implementation of the vcms article remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsArticleService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsArticleServiceUtil} to access the
 * vcms article remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsArticleServiceUtil
 */
public class VcmsArticleServiceImpl extends VcmsArticleServiceBaseImpl {
	public static final int DRAFT_STATE = 0;

	public static final int APPROVAL_PENDING = 1;

	public static final int PUBLISH_PENDING = 2;

	public static final int PUBLISHED = 3;

	public List<VcmsArticle> getArticleByCompanyId(long companyId, int start,
			int end) throws SystemException {
		return vcmsArticlePersistence.findByCompany(companyId, start, end);
	}

	public List<VcmsArticle> getArticleByCompanyId(long companyId)
			throws SystemException {
		return vcmsArticlePersistence.findByCompany(companyId);
	}

	public int countArticleByCompanyId(long companyId) throws SystemException {
		return vcmsArticlePersistence.countByCompany(companyId);
	}

	public VcmsArticle addArticle(ActionRequest req,
			UploadPortletRequest upRequest, long groupId, long companyId,
			long plid, String title, String lead, String content,
			boolean hasImage, String imageTitle, String image, String language,
			boolean hasAttachment, boolean hasPoll, String pollId, long status,
			String author, String source, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		return addArticle(req, upRequest, groupId, companyId, plid, title,
				lead, content, hasImage, imageTitle, image, language,
				hasAttachment, hasPoll, pollId, status, author, source, null,
				null, communityPermissions, guestPermissions);

	}

	public VcmsArticle addArticle(ActionRequest req,
			UploadPortletRequest upRequest, long groupId, long companyId,
			long plid, String title, String lead, String content,
			boolean hasImage, String imageTitle, String image, String language,
			boolean hasAttachment, boolean hasPoll, String pollId, long status,
			String author, String source, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VCMS, ActionKeysExt.ADD_ARTICLE);

		_validate(title, content);

		String articleId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsArticle.class.getName()));

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		VcmsArticle article = VcmsArticleUtil.create(articleId);

		article.setGroupId(groupId);
		article.setCompanyId(companyId);

		article.setStatus(status);
		article.setTitle(title);
		article.setLead(lead);
		article.setContent(content);

		// Save Image
		try {
			if (Validator.isNotNull(image)) {
				saveImage(req, upRequest, article, image, imageTitle, companyId);
			} else {
				article.setImage(null);
				article.setImageTitle(null);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		article.setLanguage(language);
		article.setUserHit(0);
		article.setDiscussible(false);
		article.setHasAttachment(hasAttachment);
		article.setHasPoll(hasPoll);
		article.setPollId(pollId);
		article.setAuthor(author);
		article.setSource(source);
		article.setEffectiveDate(null);
		article.setExpireDate(null);
		article.setSticky(false);
		article.setStickyNeverExpired(false);
		article.setStickyExpireDate(null);

		article.setCreatedDate(now);
		article.setCreatedByUser(userId);

		article.setModifiedByUser(null);
		article.setModifiedDate(null);
		article.setApprovedDate(null);
		article.setApprovedByUser(null);
		article.setPublishedDate(null);
		article.setPublishedByUser(null);

		vcmsArticlePersistence.update(article, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addArticleResources(article,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addArticleResources(article, communityPermissions, guestPermissions);
		}

		// Logging...
		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - CREATE: vcms article [" + title + "] by " + userId);

		return article;
	}

	// Common Resources Utilities ...

	public void addArticleResources(String articleId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		VcmsArticle article = VcmsArticleUtil.findByPrimaryKey(articleId);

		addArticleResources(article, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addArticleResources(VcmsArticle article,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(article.getCompanyId(),
				article.getGroupId(), getUserId(), VcmsArticle.class.getName(),
				article.getPrimaryKey().toString(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addArticleResources(String articleId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		VcmsArticle article = VcmsArticleUtil.findByPrimaryKey(articleId);

		addArticleResources(article, communityPermissions, guestPermissions);
	}

	public void addArticleResources(VcmsArticle article,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(article.getCompanyId(),
				article.getGroupId(), getUserId(), VcmsArticle.class.getName(),
				article.getPrimaryKey().toString(), communityPermissions,
				guestPermissions);
	}

	public VcmsArticle updateArticle(ActionRequest req,
			UploadPortletRequest upRequest, long groupId, long companyId,
			String articleId, long status, String title, String lead,
			String content, boolean hasImage, String imageTitle, String image,
			String language, boolean discussible, boolean hasAttachment,
			boolean hasPoll, String pollId, boolean sticky,
			boolean stickyNeverExpired, Date stickyExpireDate)
			throws PortalException, SystemException, RemoteException {

		VcmsArticlePermission.check(getPermissionChecker(),
				Long.parseLong(articleId), ActionKeysExt.UPDATE);

		_validate(title, content);

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		VcmsArticle article = VcmsArticleUtil.findByPrimaryKey(articleId);

		List listTypes = (List) VcmsArticleTypeLocalServiceUtil
				.getByArticleId(articleId);

		String typeIds = "";

		if (Validator.isNotNull(listTypes) && listTypes.size() > 0) {
			for (int i = 0; i < listTypes.size(); i++) {
				VcmsArticleType vArticleType = (VcmsArticleType) listTypes
						.get(i);
				typeIds += String.valueOf(vArticleType.getTypeId())
						+ (i < listTypes.size() - 1 ? "," : "");
			}
		}

		/* --Add by VanVtk -- */

		long groupIdHistory = article.getGroupId();
		long companyIdHistory = article.getCompanyId();

		String titleHistory = article.getTitle();
		String leadHistory = article.getLead();
		String contentHistory = article.getContent();
		String author = article.getAuthor();
		String source = article.getSource();
		long statusHistory = article.getStatus();
		boolean hasImageHistory = article.getHasImage();
		String imageTitleHistory = article.getImageTitle();
		String imageHistory = article.getImage();
		String languageHistory = article.getLanguage();
		long userHitHistory = article.getUserHit();
		boolean discussibleHistory = article.getDiscussible();
		boolean hasAttachmentHistory = article.getHasAttachment();
		boolean hasPollHistory = article.getHasPoll();
		String pollIdHistory = article.getPollId();
		boolean stickyHistory = article.getSticky();
		boolean stickyNeverExpiredHistory = article.getStickyNeverExpired();
		Date stickyExpireDateHistory = article.getStickyExpireDate();
		Date effectiveDate = article.getEffectiveDate();
		Date expireDate = article.getExpireDate();

		int countVersion = vcmsArticleVersionPersistence
				.countByArticle(articleId);

		String versionName = "Verison" + countVersion + " ["
				+ now.toGMTString() + "]";

		VcmsArticleVersionServiceUtil.addVersion(groupIdHistory,
				languageHistory, companyIdHistory, articleId, typeIds,
				statusHistory, versionName, titleHistory, leadHistory,
				contentHistory, userHitHistory, hasImageHistory,
				imageTitleHistory, imageHistory, author, source,
				discussibleHistory, hasPollHistory, pollIdHistory,
				effectiveDate, expireDate, stickyHistory,
				stickyNeverExpiredHistory, stickyExpireDateHistory,
				hasAttachmentHistory);

		/* --End Add by VanVtk -- */

		article.setGroupId(groupId);
		article.setCompanyId(companyId);

		article.setTitle(title);
		article.setLead(lead);
		article.setContent(content);

		/*
		 * try { if (Validator.isNotNull(image) && Validator.isNotNull(req)) {
		 * saveImage(req, article, image, imageTitle, companyId); } else {
		 * article.setImage(article.getImage());
		 * article.setImageTitle(article.getImageTitle()); }
		 * 
		 * } catch (Exception e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		try {
			if (Validator.isNotNull(image) && Validator.isNotNull(req)) {
				saveImage(req, upRequest, article, image, imageTitle, companyId);
			} else {
				if (image.equals("delete_image")) {
					article.setImage(null);
					article.setImageTitle(null);
					article.setHasImage(false);
				} else {
					article.setImage(article.getImage());
					article.setImageTitle(article.getImageTitle());
				}
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		article.setLanguage(language);
		article.setUserHit(article.getUserHit());
		article.setDiscussible(discussible);
		article.setHasAttachment(hasAttachment);
		article.setHasPoll(hasPoll);
		article.setPollId(pollId);
		article.setSticky(sticky);
		article.setStickyNeverExpired(stickyNeverExpired);
		article.setStickyExpireDate(stickyExpireDate);

		if (status != 0) {
			VcmsStatus vStatus = VcmsStatusLocalServiceUtil
					.getVcmsStatus(status);
			if (vStatus.getIsPrimary()) {

				article.setModifiedByUser(userId);
				article.setModifiedDate(now);

				VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
						+ " - " + StringUtil.upperCase(vStatus.getName())
						+ ": VCMS article [" + title + "] by " + userId);

			} else if (vStatus.getActive()) {

				article.setPublishedByUser(userId);
				article.setPublishedDate(now);

				VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
						+ " - " + StringUtil.upperCase(vStatus.getName())
						+ ": VCMS article [" + title + "] by " + userId);

				/*
				 * try {
				 * 
				 * SearchIndexer.updateArticle(article.getCompanyId(), article
				 * .getGroupId(), article.getArticleId(), article .getTitle(),
				 * article.getLead(), article .getContent());
				 * 
				 * } catch (Exception e) { // TODO: handle exception }
				 */
				article.setPublishedDate(now);
				article.setPublishedByUser(userId);

				// Lucene

				VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
						+ " - PUBLISH: VCMS article [" + title + "] by "
						+ userId);

				Indexer indexer = IndexerRegistryUtil
						.getIndexer(VcmsArticle.class);
				indexer.reindex(article);

			} else {

				article.setModifiedByUser(userId);
				article.setModifiedDate(now);

				article.setPublishedByUser(null);
				article.setPublishedDate(null);

				VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
						+ " - " + StringUtil.upperCase(vStatus.getName())
						+ ": VCMS article [" + title + "] by " + userId);
			}

			article.setStatus(vStatus.getStatusId());

		} else {

			article.setStatus(0);

			VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
					+ " - WITHDRAW: VCMS article [" + title + "] by " + userId);

		}
		
		VcmsStatus vcmsStatus = null;
		
		if(article.getStatus() != 0){
		 vcmsStatus = VcmsStatusUtil.findByPrimaryKey(article
				.getStatus());
		}
		vcmsArticlePersistence.update(article, false);
		if (vcmsStatus == null) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(VcmsArticle.class);
			indexer.delete(article);
		}
		return article;
	}

	public VcmsArticle updateArticle(ActionRequest req,
			UploadPortletRequest upRequest, VcmsArticle article)
			throws PortalException, SystemException, RemoteException {

		return updateArticle(req, upRequest, article.getGroupId(),
				article.getCompanyId(), article.getArticleId(),
				article.getStatus(), article.getTitle(), article.getLead(),
				article.getContent(), article.getHasImage(),
				article.getImageTitle(), article.getImage(),
				article.getLanguage(), article.getDiscussible(),
				article.getHasAttachment(), article.getHasPoll(),
				article.getPollId(), article.getSticky(),
				article.getStickyNeverExpired(), article.getStickyExpireDate());
	}

	public VcmsArticle updateArticle(VcmsArticle article,
			UploadPortletRequest upRequest) throws PortalException,
			SystemException, RemoteException {

		return updateArticle(null, upRequest, article.getGroupId(),
				article.getCompanyId(), article.getArticleId(),
				article.getStatus(), article.getTitle(), article.getLead(),
				article.getContent(), article.getHasImage(),
				article.getImageTitle(), article.getImage(),
				article.getLanguage(), article.getDiscussible(),
				article.getHasAttachment(), article.getHasPoll(),
				article.getPollId(), article.getSticky(),
				article.getStickyNeverExpired(), article.getStickyExpireDate());
	}

	public void deleteArticle(String articleId) throws PortalException,
			SystemException, RemoteException {

		VcmsArticlePermission.check(getPermissionChecker(),
				Long.parseLong(articleId), ActionKeysExt.DELETE);

		if (Validator.isNull(articleId)) {
			throw new NoSuchVcmsArticleException();
		}

		VcmsArticle article = null;

		try {
			article = VcmsArticleUtil.findByPrimaryKey(articleId);
		} catch (Exception ex) {
			throw new NoSuchArticleException();
		}

		// 0. Remove resource article from system
		ResourceLocalServiceUtil.deleteResource(article.getCompanyId(),
				VcmsArticle.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, article.getArticleId());

		// 1. Remove all discussions

		VcmsDiscussionUtil.removeByArticle(articleId);

		// 2. Remove all attached messages

		VcmsAttachedMessageUtil.removeByArticle(articleId);

		// 3. Remove all relationships with threads

		VcmsTARelationUtil.removeByArticle(articleId);

		// 4. Remove all relationships with categories

		VcmsCARelationUtil.removeByArticle(articleId);

		// 5. Remove all relationships with portions

		VcmsPARelationUtil.removeByArticle(articleId);

		// 6. Remove the article itself

		VcmsArticleUtil.remove(articleId);

		// 7. Lucene

		/*
		 * try {
		 * 
		 * SearchIndexer.deleteArticle(article.getCompanyId(), article
		 * .getArticleId());
		 * 
		 * } catch (IOException e) { System.err.println(e.toString()); }
		 */

		// Logging...

		Indexer indexer = IndexerRegistryUtil.getIndexer(VcmsArticle.class);

		indexer.delete(article);

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
				+ " - DELETE: VCMS article [" + article.getTitle() + "] by "
				+ getUserId());

	}

	public void deleteArticles(String[] articleIds) throws PortalException,
			SystemException, RemoteException {

		if ((articleIds == null) || (articleIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < articleIds.length; i++) {
			deleteArticle(articleIds[i]);
		}

	}

	public VcmsArticle getArticle(String articleId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.findByPrimaryKey(articleId);

	}

	public List<VcmsArticle> getArticles(String[] articleIds)
			throws PortalException, SystemException, RemoteException {

		List articles = new ArrayList();

		if ((articleIds == null) || (articleIds.length <= 0)) {
			return articles;
		}

		for (int i = 0; i < articleIds.length; i++) {
			articles.add(getArticle(articleIds[i]));
		}

		return articles;
	}

	public List<VcmsArticle> getArticlesByU_L_S(long groupId, String userId,
			int status, String language) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.findByU_L_S(groupId, userId, language,
				status);
	}

	public List<VcmsArticle> getArticlesByU_L_S(long groupId, String userId,
			int status, String language, OrderByComparator obc)
			throws PortalException, SystemException, RemoteException {
		int count = vcmsArticlePersistence.countByU_L_S(groupId, userId,
				language, status);
		return vcmsArticlePersistence.findByU_L_S(groupId, userId, language,
				status, 0, count, obc);
	}

	public List<VcmsArticle> getArticlesByL_S(long groupId, String language,
			long statusId) throws PortalException, SystemException,
			RemoteException {
		return vcmsArticlePersistence.findByL_S(groupId, language, statusId);
	}

	public List<VcmsArticle> getArticlesByL_S(long groupId, String language,
			long statusId, int start, int end) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.findByL_S(groupId, language, statusId,
				start, end);
	}

	public int countArticlesByL_S(long groupId, String language, long statusId)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticlePersistence.countByL_S(groupId, language, statusId);
	}

	public List<VcmsArticle> getArticlesByG_L_S_U(long groupId,
			String language, long statusId, String createdByUser, int start,
			int end) throws PortalException, SystemException, RemoteException {
		return vcmsArticlePersistence.findByG_L_S_U(groupId, language,
				statusId, createdByUser, start, end);
	}

	public int countArticlesByG_L_S_U(long groupId, String language,
			long statusId, String createdByUser) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.countByG_L_S_U(groupId, language,
				statusId, createdByUser);
	}

	public List<VcmsArticle> getArticlesByL_S(long groupId, String language,
			int status, OrderByComparator obc) throws PortalException,
			SystemException, RemoteException {
		int count = vcmsArticlePersistence
				.countByL_S(groupId, language, status);
		return vcmsArticlePersistence.findByL_S(groupId, language, status, 0,
				count, obc);
	}

	public List<VcmsArticle> getArticlesByL_S_S(long groupId, String language,
			long statusId, boolean sticky) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.findByL_S_S(groupId, language, statusId,
				sticky);
	}

	public List<VcmsArticle> getArticlesNewByL_S_S(long groupId,
			String language, long statusId, boolean sticky, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticlePersistence.findByL_S_S(groupId, language, statusId,
				sticky, 0, end);
	}

	public int countArticlesByL_S_S(long groupId, String language,
			long statusId, boolean sticky) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.countByL_S_S(groupId, language, statusId,
				sticky);

	}

	public List<VcmsArticle> getArticlesByL_S_S(long groupId, String language,
			int statusId, boolean sticky, OrderByComparator obc)
			throws PortalException, SystemException, RemoteException {

		int count = vcmsArticlePersistence.countByL_S_S(groupId, language,
				statusId, sticky);

		return vcmsArticlePersistence.findByL_S_S(groupId, language, statusId,
				sticky, 0, count, obc);
	}

	public List<VcmsArticle> getArticleByP_L_S_D(long groupId, String language,
			long statusId, boolean discussible) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.findByP_L_S_D(groupId, language,
				statusId, discussible);
	}

	public List<VcmsArticle> getArticleByC_P_L_S(String categoryId,
			long groupId, String language, long statusId)
			throws PortalException, SystemException, RemoteException {

		return (List) vcmsArticleFinder.findByC_P_L_S(categoryId, groupId,
				language, statusId);
	}

	public List<VcmsArticle> getArticleByC_P_L_S(String categoryId,
			long groupId, String language, long statusId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return (List) vcmsArticleFinder.findByC_P_L_S(categoryId, groupId,

		language, statusId, start, end);
	}

	public int countArticleByC_P_L_S(String categoryId, long groupId,
			String language, long statusId) throws PortalException,
			SystemException, RemoteException {

		return vcmsArticleFinder.countByC_P_L_S(categoryId, groupId, language,
				statusId);

	}

	public List<VcmsArticle> getArticleByP_P_L_S(String portionId,
			long groupId, String language, long statusId)
			throws PortalException, SystemException, RemoteException {

		return (List) vcmsArticleFinder.findByP_P_L_S(portionId, groupId,
				language, statusId);
	}

	public int countArticleByP_P_L_S(String portionId, long groupId,
			String language, long statusId) throws PortalException,
			SystemException, RemoteException {

		return vcmsArticleFinder.countByP_P_L_S(portionId, groupId, language,
				statusId);

	}

	public List<VcmsArticle> getArticleByP_P_L_S(String portionId,
			long groupId,

			String language, long statusId, int start, int end)
			throws PortalException, SystemException, RemoteException {

		return (List) vcmsArticleFinder.findByP_P_L_S(portionId, groupId,

		language, statusId, start, end);

	}

	public List<VcmsArticle> getArticleByT_P_L_S(String threadId, long groupId,
			String language, long statusId) throws PortalException,
			SystemException, RemoteException {

		return (List) vcmsArticleFinder.findByT_P_L_S(threadId, groupId,
				language, statusId);
	}

	public List<VcmsArticle> getArticleByT_P_L_S(String threadId, long groupId,
			String language, long statusId, int start, int end)
			throws PortalException, SystemException, RemoteException {

		return (List) vcmsArticleFinder.findByT_P_L_S(threadId, groupId,
				language, statusId, start, end);

	}

	public int countArticleByT_P_L_S(String threadId, long groupId,
			String language, long statusId) throws PortalException,
			SystemException, RemoteException {

		return vcmsArticleFinder.countByT_P_L_S(threadId, groupId, language,
				statusId);
	}

	public int countByStatus(long groupId, String language, long statusId)

	throws PortalException, SystemException, RemoteException {
		return vcmsArticlePersistence.countByL_S(groupId, language, statusId);
	}

	public int countByStatus(long statusId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticlePersistence.countByStatus(statusId);
	}

	// Added APIs

	public List<VcmsArticle> getTopNewArticles(long groupId, String language,
			String portionId, String categoryId, long statusId, int quantity)
			throws PortalException, SystemException, RemoteException {
		String listCategoryId = ActionUtil.getListCategory(groupId, language,
				categoryId);
		if (Validator.isNull(categoryId) && Validator.isNotNull(portionId)) {
			return vcmsArticleFinder.findByP_S(groupId, language, portionId,
					statusId, quantity);
		} else if (Validator.isNull(portionId)
				&& Validator.isNotNull(categoryId)) {
			return vcmsArticleFinder.findByG_L_C_S(groupId, language,
					listCategoryId, statusId, quantity);
		} else {
			return new ArrayList();
		}
	}

	public List<VcmsArticle> getHotNewArticles(long groupId, String language,
			String portionId, String categoryId, long statusId, int quantity)
			throws SystemException {
		if (categoryId.equals("") && !portionId.equals("")) {
			return vcmsArticleFinder.findByP_S(groupId, language, portionId,
					statusId, quantity);
		} else if (!categoryId.equals("") && portionId.equals("")) {
			return vcmsArticleFinder.findByC_S(groupId, language, categoryId,
					statusId, quantity);
		} else {
			return new ArrayList();
		}

	}

	public List<VcmsArticle> getTopNewArticles(long groupId, String language,
			String portionId, String categoryId, long statusId, boolean sticky,
			int quantity) throws PortalException, SystemException,
			RemoteException {

		if (Validator.isNull(categoryId) && Validator.isNotNull(portionId)) {
			return vcmsArticleFinder.findByP_S_S(groupId, language, portionId,
					statusId, sticky, quantity);
		} else if (Validator.isNull(portionId)
				&& Validator.isNotNull(categoryId)) {
			return vcmsArticleFinder.findByC_S_S(groupId, language, categoryId,
					statusId, sticky, quantity);
		} else {
			return new ArrayList();
		}
	}

	public List<VcmsArticle> getTopNewArticles(long groupId, String language,
			long statusId, boolean sticky, int quantity)
			throws PortalException, SystemException, RemoteException {

		return getTopNewArticles(groupId, language, null, null, statusId,
				sticky, quantity);
		// }
	}

	public List<VcmsArticle> getTopNewArticles(long groupId, String language,
			String categoryId, long statusId, boolean sticky, int quantity)
			throws PortalException, SystemException, RemoteException {

		return getTopNewArticles(groupId, language, null, categoryId, statusId,
				sticky, quantity);
	}

	public List<VcmsArticle> getTopNewArticles(long groupId, String language,
			String categoryId, long statusId, int quantity,
			OrderByComparator obc) throws PortalException, SystemException,
			RemoteException {

		return vcmsArticleFinder.findByL_P_S_S(groupId, language, categoryId,
				statusId, 0, quantity, obc);
	}

	public List<VcmsArticle> getAllCategoryArticles(long groupId,
			String language, String categoryId, long statusId, int begin,
			int end) throws PortalException, SystemException, RemoteException {
		String listCategoryId = ActionUtil.getListCategory(groupId, language,
				categoryId);
		return vcmsArticleFinder.findByAllL_P_S_S(groupId, language,
				listCategoryId, statusId, begin, end);
	}

	public int countAllCategoryArticles(long groupId, String language,
			String categoryId, long statusId) throws PortalException,
			SystemException, RemoteException {
		String listCategoryId = ActionUtil.getListCategory(groupId, language,
				categoryId);
		return vcmsArticleFinder.countByAllL_P_S_S(groupId, language,
				listCategoryId, statusId);
	}

	public List<VcmsArticle> getArticlesInThread(long groupId, String language,
			String threadId, long statusId) throws SystemException,
			RemoteException {

		return vcmsArticleFinder.findByT_P_L_S(threadId, groupId, language,
				statusId);
	}

	public List<VcmsArticle> getArticlesInThread(long groupId, String language,
			String threadId, long statusId, int quantity)
			throws SystemException, RemoteException {
		return vcmsArticleFinder.findByT_P_L_S(groupId, language, threadId,
				statusId, quantity);
	}

	public List<VcmsArticle> getArticlesInThread(long groupId, String language,
			String[] threadIds, long statusId, int quantity)
			throws SystemException, RemoteException {
		return vcmsArticleFinder.findByT_P_L_S(groupId, language, threadIds,
				statusId, quantity);
	}

	public List<VcmsArticle> getOlderArticles(long groupId, String language,
			String portionId, String categoryId, String articleId,
			long statusId, int quantity) throws PortalException,
			SystemException, RemoteException {

		VcmsArticle article = null;
		if (Validator.isNull(articleId)) {
			return getTopNewArticles(groupId, language, portionId, categoryId,
					statusId, quantity);
		} else {
			article = vcmsArticlePersistence.findByPrimaryKey(articleId);
		}
		// if ((article == null)
		// || (article.getStatus() != VcmsArticleServiceImpl.PUBLISHED)) {
		// return this.getTopNewArticles(groupId, language, portionId,
		// categoryId, statusId, quantity);
		// }
		if (Validator.isNull(categoryId) && Validator.isNotNull(portionId)) {
			return vcmsArticleFinder.findByP_S_After(groupId, language,
					portionId, statusId, quantity, article.getPublishedDate());
		} else if (Validator.isNull(portionId)
				&& Validator.isNotNull(categoryId)) {
			String listCategoryId = ActionUtil.getListCategory(groupId,
					language, categoryId);
			return vcmsArticleFinder.findByG_L_C_S_After(groupId, language,
					listCategoryId, statusId, quantity,
					article.getPublishedDate());
		} else {
			return new ArrayList();
		}
	}

	public List<VcmsArticle> getNewArticles(long groupId, String language,
			String portionId, String categoryId, String articleId,
			long statusId, int quantity) throws PortalException,
			SystemException, RemoteException {
		VcmsArticle article = null;
		if (Validator.isNull(articleId)) {
			return getTopNewArticles(groupId, language, portionId, categoryId,
					statusId, quantity);
		} else {
			article = vcmsArticlePersistence.findByPrimaryKey(articleId);
		}
		// if ((article == null)
		// || (article.getStatus() != VcmsArticleServiceImpl.PUBLISHED)) {
		// return getTopNewArticles(groupId, language, portionId, categoryId,
		// statusId, quantity);
		// }
		if (Validator.isNull(categoryId) && Validator.isNotNull(portionId)) {
			return vcmsArticleFinder.findByG_L_P_S_Before(groupId, language,
					portionId, statusId, quantity, article.getPublishedDate());
		} else if (Validator.isNull(portionId)
				&& Validator.isNotNull(categoryId)) {
			String listCategoryId = ActionUtil.getListCategory(groupId,
					language, categoryId);
			return vcmsArticleFinder.findByG_L_C_S_Before(groupId, language,
					listCategoryId, statusId, quantity,
					article.getPublishedDate());
		} else {
			return new ArrayList();
		}
	}

	// report
	public int countByC_P_L_S_D(String categoryId, long groupId,
			String language, long statusId, Date fromDate, Date toDate,
			String byUser) throws SystemException {
		return vcmsArticleFinder.countByC_P_L_S_D(categoryId, groupId,
				language, statusId, fromDate, toDate, byUser);
	}

	public int countByP_L_S_D(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser) throws SystemException {
		return vcmsArticleFinder.countByP_L_S_D(groupId, language, statusId,
				fromDate, toDate, byUser);
	}

	// by date report
	public List<VcmsArticle> listReportByDate(long groupId, String language,
			long statusId, Date fromDate, Date toDate, String byUser,
			long typeId, int begin, int end) throws SystemException {
		return vcmsArticleFinder.findArticleByDate(groupId, language, statusId,
				fromDate, toDate, byUser, typeId, begin, end);
	}

	public List<VcmsArticle> listReportByDateNotType(long groupId,
			String language, long statusId, Date fromDate, Date toDate,
			String byUser, int begin, int end) throws SystemException {
		return vcmsArticleFinder.findArticleByDateNotType(groupId, language,
				statusId, fromDate, toDate, byUser, begin, end);
	}

	public int countByDate(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser, long typeId)
			throws SystemException {
		return vcmsArticleFinder.countArticleByDate(groupId, language,
				statusId, fromDate, toDate, byUser, typeId);
	}

	public int countByDateNotType(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser) throws SystemException {
		return vcmsArticleFinder.countArticleByDateNotType(groupId, language,
				statusId, fromDate, toDate, byUser);
	}

	public List<VcmsArticle> listArticleByDateTypes(long groupId,
			String language, long statusId, Date fromDate, Date toDate,
			String byUser, String[] strType, int begin, int end)
			throws SystemException {
		return vcmsArticleFinder.findArticleByDateTypes(groupId, language,
				statusId, fromDate, toDate, byUser, strType, begin, end);
	}

	public int countArticleByDateTypes(long groupId, String language,
			long statusId, Date fromDate, Date toDate, String byUser,
			String[] strType) throws SystemException {
		return vcmsArticleFinder.countArticleByDateTypes(groupId, language,
				statusId, fromDate, toDate, byUser, strType);
	}

	// by type report
	public int countByType(long groupId, String language, long statusId,
			long typeId, Date fromDate, Date toDate, String byUser)
			throws RemoteException, SystemException {
		return vcmsArticleFinder.countByType(groupId, language, statusId,
				typeId, fromDate, toDate, byUser);
	}

	public int countByUser(long groupId, String language, String categoryId,
			long statusId, long typeId, Date fromDate, Date toDate,
			String byUser) throws SystemException, RemoteException,
			PortalException {
		return vcmsArticleFinder.countByUser(groupId, language, categoryId,
				statusId, typeId, fromDate, toDate, byUser);
	}

	public int countArticleNotInType(long groupId, String language,
			String categoryId, long statusId, Date fromDate, Date toDate,
			String byUser) throws SystemException, RemoteException,
			PortalException {
		return vcmsArticleFinder.countArticleNotInType(groupId, language,
				categoryId, statusId, fromDate, toDate, byUser);
	}

	public int countArticleAllCatNotInType(long groupId, String language,
			long statusId, Date fromDate, Date toDate, String byUser)
			throws SystemException, RemoteException, PortalException {
		return vcmsArticleFinder.countArticleAllCatNotInType(groupId, language,
				statusId, fromDate, toDate, byUser);
	}

	// Search Article into Container - add By Donghh
	public List<VcmsArticle> getArticlesBySearchContainer(String keyword,
			long groupId, String language, String portionId, String parentId,
			boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
			Date fromDate, Date toDate, long statusId, String select)
			throws PortalException, SystemException, RemoteException {

		List lSearchArtilces = new ArrayList();
		if (Validator.isNotNull(portionId)) {
			VcmsPortion portion = VcmsPortionServiceUtil.getPortion(portionId);

			if (portion.getCategorizable() == false) {
				lSearchArtilces = vcmsArticleFinder.findBySearchContainer_P(
						keyword, groupId, language, portionId, isTitle, isLead,
						isContent, isDate, fromDate, toDate, statusId, select);

			} else if (Validator.isNotNull(parentId)
					&& !Validator.equals(parentId, "0")) {
				lSearchArtilces = (List) vcmsArticleFinder
						.findBySearchContainer_C(keyword, groupId, language,
								parentId, isTitle, isLead, isContent, isDate,
								fromDate, toDate, statusId, select);
			}
		} else if (Validator.isNull(portionId) && Validator.isNotNull(parentId)
				&& !Validator.equals(parentId, "0")) {

			lSearchArtilces = (List) vcmsArticleFinder.findBySearchContainer_C(
					keyword, groupId, language, parentId, isTitle, isLead,
					isContent, isDate, fromDate, toDate, statusId, select);

		} else if (Validator.isNull(portionId) && Validator.isNotNull(parentId)
				&& Validator.equals(parentId, "0")) {

			lSearchArtilces = (List) vcmsArticleFinder.findBySearchContainer_C(
					keyword, groupId, language, null, isTitle, isLead,
					isContent, isDate, fromDate, toDate, statusId, select);
		}

		return lSearchArtilces;
	}

	public List<VcmsArticle> getArticlesBySearchContainer(String keyword,
			long groupId, String language, String portionId, String parentId,
			long typeId, boolean isTitle, boolean isLead, boolean isContent,
			boolean isDate, Date fromDate, Date toDate, long statusId,
			String select, int start, int end) throws PortalException,
			SystemException, RemoteException {

		List lSearchArtilces = new ArrayList();
		if (Validator.isNotNull(portionId)) {

			VcmsPortion portion = VcmsPortionServiceUtil.getPortion(portionId);
			if (portion.getCategorizable() == false) {

				lSearchArtilces = vcmsArticleFinder.findBySearchContainer_P(
						keyword, groupId, language, portionId, isTitle, isLead,
						isContent, isDate, fromDate, toDate, statusId, select,
						start, end);
			} else if (Validator.isNotNull(parentId)) {

				lSearchArtilces = vcmsArticleFinder.findBySearchContainer_C(
						keyword, groupId, language, parentId, typeId, isTitle,
						isLead, isContent, isDate, fromDate, toDate, statusId,
						select, start, end);
			}
		} else if (Validator.isNull(portionId) && Validator.isNotNull(parentId)
				&& !Validator.equals(parentId, "0")) {

			lSearchArtilces = (List) vcmsArticleFinder.findBySearchContainer_C(
					keyword, groupId, language, parentId, typeId, isTitle,
					isLead, isContent, isDate, fromDate, toDate, statusId,
					select, start, end);

		} else if (Validator.isNull(portionId) && Validator.isNotNull(parentId)
				&& Validator.equals(parentId, "0")) {

			lSearchArtilces = (List) vcmsArticleFinder.findBySearchContainer_C(
					keyword, groupId, language, null, typeId, isTitle, isLead,
					isContent, isDate, fromDate, toDate, statusId, select,
					start, end);
		}

		return lSearchArtilces;
	}

	public int countArticlesBySearchContainer(String keyword, long groupId,
			String language, String portionId, String parentId, long typeId,
			boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
			Date fromDate, Date toDate, long statusId, String select)
			throws PortalException, SystemException, RemoteException {

		int countLSearchArtilces = 0;
		if (Validator.isNotNull(portionId)) {
			VcmsPortion portion = VcmsPortionServiceUtil.getPortion(portionId);

			if (portion.getCategorizable() == false) {
				countLSearchArtilces = vcmsArticleFinder
						.countBySearchContainer_P(keyword, groupId, language,
								portionId, isTitle, isLead, isContent, isDate,
								fromDate, toDate, statusId, select);
			} else if (Validator.isNotNull(parentId)) {
				countLSearchArtilces = vcmsArticleFinder
						.countBySearchContainer_C(keyword, groupId, language,
								parentId, typeId, isTitle, isLead, isContent,
								isDate, fromDate, toDate, statusId, select);
			}
		} else if (Validator.isNull(portionId) && Validator.isNotNull(parentId)
				&& !Validator.equals(parentId, "0")) {

			countLSearchArtilces = vcmsArticleFinder.countBySearchContainer_C(
					keyword, groupId, language, parentId, typeId, isTitle,
					isLead, isContent, isDate, fromDate, toDate, statusId,
					select);
		} else if (Validator.isNull(portionId) && Validator.isNotNull(parentId)
				&& Validator.equals(parentId, "0")) {

			countLSearchArtilces = vcmsArticleFinder.countBySearchContainer_C(
					keyword, groupId, language, null, typeId, isTitle, isLead,
					isContent, isDate, fromDate, toDate, statusId, select);
		}

		return countLSearchArtilces;
	}

	public List<VcmsArticle> getArticlesBySearchContainer_T(String categoryId,
			long typeId, String keyword, long groupId, String language,
			String threadId, boolean isTitle, boolean isLead,
			boolean isContent, boolean isDate, Date fromDate, Date toDate,
			long statusId, String select, int start, int end)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleFinder.findBySearchContainer_T(categoryId, typeId,
				keyword, groupId, language, threadId, isTitle, isLead,
				isContent, isDate, fromDate, toDate, statusId, select, start,
				end);
	}

	public int countArticlesBySearchContainer_T(String categoryId, long typeId,
			String keyword, long groupId, String language, String threadId,
			boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
			Date fromDate, Date toDate, long statusId, String select)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleFinder.countBySearchContainer_T(categoryId, typeId,
				keyword, groupId, language, threadId, isTitle, isLead,
				isContent, isDate, fromDate, toDate, statusId, select);
	}

	public List<VcmsArticle> getArticleByG_L_C_S_T(long groupId,
			String language, String categoryId, long statusId, long typeId,
			int begin, int end) throws PortalException, SystemException,
			RemoteException {
		return vcmsArticleFinder.findByG_L_C_S_T(groupId, language, categoryId,
				statusId, typeId, begin, end);

	}

	public int countArticleByG_L_C_S_T(long groupId, String language,
			String categoryId, long statusId, long typeId)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleFinder.countByG_L_C_S_T(groupId, language,
				categoryId, statusId, typeId);
	}

	public List<VcmsArticle> getArticleByG_L_S_T(long groupId, String language,
			long statusId, long typeId, int begin, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleFinder.findByG_L_S_T(groupId, language, statusId,
				typeId, begin, end);

	}

	public int countArticleByG_L_S_T(long groupId, String language,
			long statusId, long typeId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleFinder.countByG_L_S_T(groupId, language, statusId,
				typeId);
	}

	public int countArticleByG_L_S_C_D(long groupId, String language,
			long statusId, String categoryId, Date fromDate, Date toDate)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleFinder.countByG_L_S_C_D(groupId, language, statusId,
				categoryId, fromDate, toDate);
	}

	public List<VcmsArticle> getArticleByG_L_S_C_D(long groupId,
			String language, long statusId, String categoryId, Date fromDate,
			Date toDate, int begin, int end) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleFinder.findByG_L_S_C_D(groupId, language, statusId,
				categoryId, fromDate, toDate, begin, end);
	}

	public int countOtherArticle(long groupId, String language, long statusId,
			String categoryId, String articleId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleFinder.countOtherArticle(groupId, language, statusId,
				categoryId, articleId);
	}

	public List<VcmsArticle> getOtherArticle(long groupId, String language,
			long statusId, String categoryId, String articleId, int begin,
			int end) throws PortalException, SystemException, RemoteException {
		return vcmsArticleFinder.findOtherArticle(groupId, language, statusId,
				categoryId, articleId, begin, end);
	}

	public void removeExpiredStickyArticles(UploadPortletRequest upRequest)
			throws PortalException, SystemException, RemoteException {

		Date today = new Date();

		List tobeExpiredArticles = vcmsArticleFinder
				.getUpComingExpiredArticles(today);

		if ((tobeExpiredArticles == null) || (tobeExpiredArticles.size() <= 0)) {
			return;
		}

		for (int i = 0; i < tobeExpiredArticles.size(); i++) {
			VcmsArticle article = (VcmsArticle) tobeExpiredArticles.get(i);

			article.setSticky(false);

			updateArticle(article, upRequest);
		}
	}

	public void reIndex(String[] ids) throws PortalException, SystemException,
			RemoteException {

		long statusId = 0;
		try {
			statusId = getStatusIdOfPublishedArticles(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List articles = VcmsArticleUtil.findByStatus(statusId);

		if ((articles == null) || (articles.size() <= 0)) {
			return;
		}
		
//		  try {
//		  
//		  for (int i = 0; i < articles.size(); i++) { VcmsArticle article =
//		  (VcmsArticle) articles.get(i);
//		  
//		  SearchIndexer.updateArticle(article.getCompanyId(), article
//		  .getGroupId(), article.getArticleId(), article .getTitle(),
//		  article.getLead(), article.getContent()); }
//		  
//		  } catch (Exception ex) { // Ignore... }
		 
	}

	public Hits search(HttpServletRequest request, long companyId,
			long groupId, long userId, String keywords, int start, int end)
			throws SystemException {
		try {
			SearchContext searchContext = SearchContextFactory
					.getInstance(request);
			searchContext.setStart(start);
			searchContext.setEnd(end);
			BooleanQuery contextQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			//contextQuery.addRequiredTerm(Field.PORTLET_ID, PortletKeysExt.VCMS);

			if (groupId > 0) {
				contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);
			}

			if (userId > 0) {
				contextQuery.addRequiredTerm(Field.USER_ID, userId);
			}

			BooleanQuery searchQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			if (Validator.isNotNull(keywords)) {
				searchQuery.addTerm(Field.TITLE, keywords);
				// searchQuery.addTerm(Field.DESCRIPTION, keywords);
				searchQuery.addTerm(Field.CONTENT, keywords);
				/* searchQuery.addTerm(Field.TAGS_ENTRIES, keywords); */
				// searchQuery.addTerm(Field.ASSET_TAG_NAMES, keywords);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			if (searchQuery.clauses().size() > 0) {
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			}
			
			
		/*	Indexer indexer = IndexerRegistryUtil.getIndexer(VcmsArticle.class.getName()).search(searchContext);
			return indexer.search(companyId, fullQuery, start, end);*/
			
			Indexer indexer = IndexerRegistryUtil.getIndexer(VcmsArticle.class.getName());
			return indexer.search(searchContext);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	private void _validate(String title, String content)
			throws PortalException, SystemException {

		if (Validator.isNull(title) || title.length() > 200) {
			throw new InvalidArticleTitleException();
		}

		if (Validator.isNull(content)) {
			throw new InvalidArticleContentException();
		}
	}

	public void restoreArticleVersion(long articleVersionId)
			throws PortalException, SystemException, RemoteException {
		// TODO:
		// 1. Tao 1 articleVersion moi
		// 2. Cap nhat article tu thong tin articleVersion vua chon Restore
		// Buoc 1 va 2 thuc hien thong qua ham cap nhat
		// 3.Xoa articleVersion vua chon Restore

		// 1&2: Buoc 1 va 2 thuc hien thong qua ham cap nhat
		VcmsArticleVersion articleVersion = VcmsArticleVersionUtil
				.findByPrimaryKey(articleVersionId);

		String articleId = articleVersion.getArticleId();

		VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);

		article.setGroupId(articleVersion.getGroupId());
		article.setCompanyId(articleVersion.getCompanyId());

		article.setStatus(articleVersion.getStatus());
		article.setTitle(articleVersion.getTitle());
		article.setLead(articleVersion.getLead());
		article.setContent(articleVersion.getContent());

		article.setHasImage(articleVersion.getHasImage());
		article.setImageTitle(articleVersion.getImageTitle());
		article.setImage(articleVersion.getImage());

		article.setLanguage(articleVersion.getLanguage());
		article.setUserHit(0);
		article.setDiscussible(false);
		article.setHasAttachment(articleVersion.getHasAttachment());
		article.setHasPoll(articleVersion.getHasPoll());
		article.setPollId(articleVersion.getPollId());
		article.setAuthor(articleVersion.getAuthor());
		article.setSource(articleVersion.getSource());
		article.setEffectiveDate(null);
		article.setExpireDate(null);
		article.setSticky(false);
		article.setStickyNeverExpired(false);
		article.setStickyExpireDate(null);

		article.setCreatedDate(articleVersion.getCreatedDate());
		article.setCreatedByUser(articleVersion.getCreatedByUser());

		article.setModifiedByUser(null);
		article.setModifiedDate(null);
		article.setApprovedDate(null);
		article.setApprovedByUser(null);
		article.setPublishedDate(null);
		article.setPublishedByUser(null);

		vcmsArticlePersistence.update(article, false);

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
				+ " - RESTORE: vcms article [" + article.getTitle() + "] by "
				+ getUserId());

		// 3.Xoa articleVersion vua chon Restore
		try {
			VcmsArticleVersionUtil.remove(articleVersionId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getStatusIdOfPublishedArticles(long companyId, long groupId,
			boolean active) throws Exception {

		return VcmsStatusLocalServiceUtil
				.getByC_G_A(companyId, groupId, active).getStatusId();
	}

	public long getStatusIdOfPublishedArticles(boolean active)
			throws PortalException, SystemException, RemoteException {

		return VcmsStatusLocalServiceUtil.getByA(active).getStatusId();
	}

	public void saveImage(ActionRequest req, UploadPortletRequest uploadReq,
			VcmsArticle article, String image, String imageTitle, long companyId)
			throws Exception {

		/*
		 * UploadPortletRequest uploadReq = PortalUtil
		 * .getUploadPortletRequest(req);
		 */

		// Image...
		if ((article != null) && Validator.isNotNull(image)) {

			// Validate the image input
			String contentType = uploadReq.getContentType("image");
			if (ImageUtilExt.isImage(contentType)) {

				String imageKey = WebKeysExt.VCMS_ARTICLE_IMAGE_KEY
						+ article.getArticleId();
				String smallImageKey = WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY
						+ article.getArticleId();

				int thumbnailMaxWidth = GetterUtil.getInteger(PrefsPropsUtil
						.getString(companyId,
								PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_WIDTH),
						100);
				int thumbnailMaxHeight = GetterUtil.getInteger(PrefsPropsUtil
						.getString(companyId,
								PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_HEIGHT),
						100);

				File fileImage = uploadReq.getFile("image");

				if (fileImage != null) {

					byte[] photoBytes = FileUtil.getBytes(fileImage);
					ImageUtilExt.saveOriginalImage(Long.parseLong(imageKey),
							photoBytes);

					// Also, save a scaled version of the image
					ByteArrayInputStream bais = new ByteArrayInputStream(
							photoBytes);
					ImageUtilExt.saveThumbnail(Long.parseLong(smallImageKey),
							ImageIO.read(bais), contentType, thumbnailMaxWidth,
							thumbnailMaxHeight);

					// Update the article when the image is saved
					article.setHasImage(true);
					article.setImage(imageKey);
					article.setImageTitle(Validator.isNull(imageTitle) ? StringPool.BLANK
							: imageTitle);
				}
			}
		}
	}

}