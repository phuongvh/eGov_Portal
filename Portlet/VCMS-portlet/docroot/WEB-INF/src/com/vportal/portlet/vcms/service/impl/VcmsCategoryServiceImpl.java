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

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.RSSUtil;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.vportal.portal.kernel.security.permission.ActionKeysExt;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vcms.DeleteCategoryException;
import com.vportal.portlet.vcms.InvalidCategoryHrefException;
import com.vportal.portlet.vcms.InvalidCategoryNameException;
import com.vportal.portlet.vcms.InvalidCategoryPortionException;
import com.vportal.portlet.vcms.NoSuchVcmsCategoryException;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsCategoryServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsCategoryUtil;

/**
 * The implementation of the vcms category remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsCategoryService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil} to access
 * the vcms category remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsCategoryServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil
 */
public class VcmsCategoryServiceImpl extends VcmsCategoryServiceBaseImpl {
	public VcmsCategory addCategory(long groupId, long companyId, long plid,
			String portionId, String parentId, String name, String description,
			boolean anchored, String href, String language, boolean hasImage,
			String image, boolean rssable, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {
		return addCategory(groupId, companyId, plid, portionId, parentId, name,
				description, anchored, href, language, hasImage, image,
				rssable, null, null, communityPermissions, guestPermissions);
	}

	public VcmsCategory addCategory(long groupId, long companyId, long plid,
			String portionId, String parentId, String name, String description,
			boolean anchored, String href, String language, boolean hasImage,
			String image, boolean rssable, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VCMS, ActionKeysExt.ADD_CATEGORY);

		_validate(portionId, name, anchored, href);

		String categoryId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsCategory.class.getName()));

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		VcmsCategory category = vcmsCategoryPersistence.create(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);

		category.setPortionId(portionId);
		category.setParentId(parentId);
		category.setName(name);
		category.setDescription(description);
		category.setAnchored(anchored);
		category.setHref(href);
		category.setLanguage(language);
		category.setHasImage(hasImage);
		category.setImage(image);

		// set position
		int total = VcmsCategoryServiceUtil.countCategoriesByP_P(groupId,
				portionId, parentId, language);
		category.setPosition(total + 1);

		category.setUserHit(0);
		category.setRssable(rssable);

		category.setCreatedDate(now);
		category.setCreatedByUser(userId);

		category.setModifiedDate(now);
		category.setModifiedByUser(userId);

		VcmsCategoryUtil.update(category, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addCategoryResources(category,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addCategoryResources(category, communityPermissions,
					guestPermissions);
		}

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - CREATE: vcms category [" + name + "] by " + userId);

		return category;
	}

	// change portion
	public void changePortion(String parentId, long groupId, String portionId,
			String language) throws SystemException {
		List list = vcmsCategoryPersistence.findByParent_Language(groupId,
				parentId, language);
		for (int i = 0; i < list.size(); i++) {
			VcmsCategory vcmsCategory = (VcmsCategory) list.get(i);
			vcmsCategory.setPortionId(portionId);
			vcmsCategoryPersistence.update(vcmsCategory, false);
			changePortion(vcmsCategory.getCategoryId(), groupId, portionId,
					language);
		}
	}

	// Common Resources Utilities ...

	public void addCategoryResources(String categoryId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		VcmsCategory category = vcmsCategoryPersistence
				.findByPrimaryKey(categoryId);

		addCategoryResources(category, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addCategoryResources(VcmsCategory category,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(category.getCompanyId(), 0,
				getUserId(), VcmsCategory.class.getName(), category
						.getPrimaryKey().toString(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(String categoryId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		VcmsCategory category = vcmsCategoryPersistence
				.findByPrimaryKey(categoryId);

		addCategoryResources(category, communityPermissions, guestPermissions);
	}

	public void addCategoryResources(VcmsCategory category,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(category.getCompanyId(), 0,
				getUserId(), VcmsCategory.class.getName(), category
						.getPrimaryKey().toString(), communityPermissions,
				guestPermissions);
	}

	public VcmsCategory updateCategory(long groupId, long companyId,
			String categoryId, String portionId, String parentId, String name,
			String description, boolean anchored, String href, String language,
			boolean hasImage, String image, long position, long userHit,
			boolean rssable) throws PortalException, SystemException,
			RemoteException {

		_validate(portionId, name, anchored, href);

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		VcmsCategory category = vcmsCategoryPersistence
				.findByPrimaryKey(categoryId);

		category.setGroupId(groupId);
		category.setCompanyId(companyId);

		category.setPortionId(portionId);
		category.setParentId(parentId);
		category.setName(name);
		category.setDescription(description);
		category.setAnchored(anchored);
		category.setHref(href);
		category.setLanguage(language);
		category.setHasImage(hasImage);
		category.setImage(image);
		category.setPosition(position);
		category.setUserHit(userHit);
		category.setRssable(rssable);

		category.setModifiedDate(now);
		category.setModifiedByUser(userId);

		vcmsCategoryPersistence.update(category, false);

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - UPDATE: vcms category [" + name + "] by " + userId);

		return category;
	}

	public VcmsCategory updateCategory(VcmsCategory category)
			throws PortalException, SystemException, RemoteException {

		return updateCategory(category.getGroupId(), category.getCompanyId(),
				category.getCategoryId(), category.getPortionId(),
				category.getParentId(), category.getName(),
				category.getDescription(), category.getAnchored(),
				category.getHref(), category.getLanguage(),
				category.getHasImage(), category.getImage(),
				category.getPosition(), category.getUserHit(),
				category.getRssable());

	}

	public void deleteCategory(String categoryId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(categoryId)) {
			throw new NoSuchVcmsCategoryException();
		}

		VcmsCategory category = null;

		try {
			category = vcmsCategoryPersistence.findByPrimaryKey(categoryId);

			// The category can only be deleted when it has no children

			List relations = VcmsCARelationServiceUtil
					.getRelationsByCategory(categoryId);

			List categories = vcmsCategoryPersistence.findByParent_Language(
					category.getGroupId(), category.getCategoryId(),
					category.getLanguage());

			if (((relations != null) && (relations.size() > 0))
					|| ((categories != null) && (categories.size() > 0))) {
				throw new DeleteCategoryException();

			}

			// Remove resources
			ResourceLocalServiceUtil.deleteResource(category.getCompanyId(),
					VcmsCategory.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					category.getCategoryId());

			// Remove category
			vcmsCategoryPersistence.remove(categoryId);

			// Logging...

			VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
					+ " - DELETE: vcms category [" + category.getName()
					+ "] by " + getUserId());

		} catch (Exception ex) {
			// throw new NoSuchVcmsCategoryException();
			throw new DeleteCategoryException();
		}

	}

	public VcmsCategory getCategory(String categoryId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(categoryId)) {
			throw new NoSuchVcmsCategoryException();
		}

		return vcmsCategoryPersistence.findByPrimaryKey(categoryId);
	}

	public String getCategoriesByRSS(String categoryId, int max, String type,
			double version, String displayStyle, String feedURL,
			String entryURL, int quantity, ThemeDisplay themeDisplay)
			throws PortalException, SystemException, RemoteException {

		VcmsCategory category = vcmsCategoryPersistence
				.findByPrimaryKey(categoryId);

		long companyId = category.getCompanyId();
		long groupId = category.getGroupId();

		long statusId = VcmsStatusLocalServiceUtil.getByC_G_A(companyId,
				groupId, true).getStatusId();

		String name = category.getName();
		String description = category.getDescription();
		List listArticleByRSS = (List) VcmsArticleServiceUtil
				.getTopNewArticles(category.getGroupId(),
						category.getLanguage(), null, categoryId, statusId,
						quantity);
		return exportToRSS(name, description, type, version, displayStyle,
				feedURL, entryURL, listArticleByRSS, themeDisplay);
	}

	protected String exportToRSS(String name, String description, String type,
			double version, String displayStyle, String feedURL,
			String entryURL, List<VcmsArticle> vcmsArticle,
			ThemeDisplay themeDisplay) throws SystemException {

		SyndFeed syndFeed = new SyndFeedImpl();

		syndFeed.setFeedType(RSSUtil.getFeedType(type, version));
		syndFeed.setTitle(name);
		syndFeed.setLink(feedURL);
		syndFeed.setDescription(description);

		List<SyndEntry> entries = new ArrayList<SyndEntry>();

		syndFeed.setEntries(entries);

		for (VcmsArticle entry : vcmsArticle) {
			String author = "";
			try {
				author = UserServiceUtil.getUserById(
						Long.parseLong(entry.getPublishedByUser()))
						.getFullName();
			} catch (Exception e) {
				// TODO: handle exception
			}
			String link = entryURL;
			link += "&articleId=" + entry.getArticleId();

			String value = null;

			if (displayStyle.equals(RSSUtil.DISPLAY_STYLE_ABSTRACT)) {
				value = StringUtil.shorten(
						HtmlUtil.extractText(entry.getContent()),
						_RSS_ABSTRACT_LENGTH, StringPool.BLANK);
			} else if (displayStyle.equals(RSSUtil.DISPLAY_STYLE_TITLE)) {
				value = StringPool.BLANK;
			} else {
				value = StringUtil.replace(entry.getContent(), new String[] {
						"href=\"/", "src=\"/" }, new String[] {
						"href=\"" + themeDisplay.getURLPortal() + "/",
						"src=\"" + themeDisplay.getURLPortal() + "/" });
			}

			SyndEntry syndEntry = new SyndEntryImpl();

			syndEntry.setAuthor(author);
			syndEntry.setTitle(entry.getTitle());
			syndEntry.setLink(link);
			syndEntry.setPublishedDate(entry.getCreatedDate());

			SyndContent syndContent = new SyndContentImpl();

			syndContent.setType(RSSUtil.ENTRY_TYPE_DEFAULT);
			syndContent.setValue(value);

			syndEntry.setDescription(syndContent);

			entries.add(syndEntry);
		}

		try {
			return RSSUtil.export(syndFeed);
		} catch (FeedException fe) {
			throw new SystemException(fe);
		}
	}

	public List<VcmsCategory> getCategoriesByPortion(long groupId,
			String portionId, String language) throws PortalException,
			SystemException, RemoteException {
		return vcmsCategoryPersistence.findByPortion_Language(groupId,
				portionId, language);
	}

	public List<VcmsCategory> getCategoriesByParent(long groupId,
			String parentId, String language) throws PortalException,
			SystemException, RemoteException {
		return vcmsCategoryPersistence.findByParent_Language(groupId, parentId,
				language);

	}

	public List<VcmsCategory> getCategoriesByParent(long groupId,
			String parentId, String language, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsCategoryPersistence.findByParent_Language(groupId, parentId,
				language, start, end);

	}

	public int countCategoriesByParent(long groupId, String parentId,
			String language) throws PortalException, SystemException,
			RemoteException {
		return vcmsCategoryPersistence.countByParent_Language(groupId,
				parentId, language);
	}

	public List<VcmsCategory> getCategoriesByP_P(long groupId,
			String portionId, String parentId, String language)
			throws PortalException, SystemException, RemoteException {
		return vcmsCategoryPersistence.findByP_P_L(groupId, portionId,
				parentId, language);
	}

	public List<VcmsCategory> getCategoriesByP_P(long groupId,
			String portionId, String parentId, String language, int start,
			int end) throws PortalException, SystemException, RemoteException {
		return vcmsCategoryPersistence.findByP_P_L(groupId, portionId,
				parentId, language, start, end);
	}

	public int countCategoriesByP_P(long groupId, String portionId,
			String parentId, String language) throws PortalException,
			SystemException, RemoteException {
		return vcmsCategoryPersistence.countByP_P_L(groupId, portionId,
				parentId, language);
	}

	public int countByP_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {

		return vcmsCategoryPersistence.countByLanguage(groupId, language);
	}

	private void _validate(String portionId, String name, boolean anchored,
			String href) throws PortalException, SystemException {

		if (Validator.isNull(portionId)) {
			throw new InvalidCategoryPortionException();
		}

		if (Validator.isNull(name)) {
			throw new InvalidCategoryNameException();
		}

		if (anchored && Validator.isNull(href)) {
			throw new InvalidCategoryHrefException();
		}
	}

	private static final int _RSS_ABSTRACT_LENGTH = GetterUtil
			.getInteger(PropsUtil
					.get(PropsKeys.MESSAGE_BOARDS_RSS_ABSTRACT_LENGTH));

}