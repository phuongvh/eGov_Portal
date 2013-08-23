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

package com.vportal.portlet.vdoc.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.vportal.portlet.vdoc.NoSuchvdocDocumentException;
import com.vportal.portlet.vdoc.model.vdocDocument;
import com.vportal.portlet.vdoc.service.vdocDORelServiceUtil;
import com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil;
import com.vportal.portlet.vdoc.service.base.vdocDocumentServiceBaseImpl;
import com.vportal.portlet.vdoc.service.persistence.vdocDocumentFinder;
import com.vportal.portlet.vdoc.service.persistence.vdocDocumentFinderUtil;

/**
 * The implementation of the vdoc document remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vdoc.service.vdocDocumentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see com.vportal.portlet.vdoc.service.base.vdocDocumentServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil
 */
public class vdocDocumentServiceImpl extends vdocDocumentServiceBaseImpl {
	
	public static final int APPROVAL_PENDING = 0;

	public static final int PUBLISH_PENDING = 1;

	public static final int PUBLISHED = 2;

	public static final int SINGLE = 0;

	public static final int MULTI = 1;

	/**
	 * 
	 * Add Document
	 * @throws SystemException
	 * @throws PortalException
	 */
	public String getmaxPosition (long groupId, String language) throws SystemException{
	
			return vdocDocumentFinder.maxPositionDocument(groupId, language);
	
		
	}
	public vdocDocument addDocument(String docId, long groupId,
			String language, long userId, String title, String content,
			String process, String base, String time, String cost,
			String result, String require, String objects, String style,
			String note, Date promulDate, Date effectivedDate,
			Date expiredDate, String fieldId, String orgRels, String fieldRels,
			boolean hasAttachment, int typeDoc, String[] communityPermissions,
			String[] guestPermissions, ThemeDisplay themeDisplay) throws SystemException, PortalException {

		return addDocument(docId, groupId, language, userId, title, content,
				process, base, time, cost, result, require, objects, style,
				note, promulDate, effectivedDate, expiredDate, fieldId,
				orgRels, fieldRels, hasAttachment, typeDoc, null, null,
				communityPermissions, guestPermissions, themeDisplay);
	}

	/**
	 * 
	 * Add Document
	 * @throws SystemException
	 * @throws PortalException
	 */
	public vdocDocument addDocument(String docId, long groupId, String language, long userId, 
			String title, String content, String process, String base, String time, String cost,
			String result, String require, String objects, String style, String note, Date promulDate, 
			Date effectivedDate, Date expiredDate, String fieldId, String orgRels, String fieldRels,
			boolean hasAttachment, int typeDoc, Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions,
			ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		Date now = new Date();
		
		int userHit = 0;
		
		User user = userPersistence.findByPrimaryKey(userId);
		vdocDocument doc = vdocDocumentPersistence.create(docId);
		
		doc.setCreatedDate(now);
		doc.setCreatedByUser(userId);
		doc.setGroupId(groupId);
		doc.setCompanyId(user.getCompanyId());
		doc.setLanguage(language);
		doc.setUserId(userId);
		
		doc.setFieldId(fieldId);
		doc.setFieldRels(fieldRels);
		doc.setOrgRels(orgRels);
		
		doc.setTitle(title);
		doc.setContent(content);
		doc.setProcess(process);
		doc.setBase(base);
		doc.setTime(time);
		doc.setCost(cost);
		doc.setResult(result);
		doc.setRequire(require);
		doc.setObjects(objects);
		doc.setStyle(style);
		doc.setNote(note);
		doc.setUserHit(userHit);
		doc.setHasAttachment(hasAttachment);
		doc.setTypeDoc(typeDoc);
		
		doc.setApprovedDate(null);
		doc.setApprovedByUser(0);
		doc.setPublishedDate(null);
		doc.setPublishedByUser(0);
		int position = 1;
		doc.setPosition(position);
		doc.setStatusDoc(vdocDocumentServiceImpl.APPROVAL_PENDING);
		
		vdocDocumentPersistence.update(doc, false);
		
		// add resource
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addEntryResources(doc, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addEntryResources(doc, communityPermissions, guestPermissions);
		}
		
		return doc;
	}
	
	public vdocDocument updateDocument(String docId, long groupId,
			String language, String title,long userId, String content, String process,
			String base, String time, String cost, String result,
			String require, String objects, String style, String note,
			Date promulDate, Date effectivedDate, Date expiredDate,
			String fieldId, String orgRels, String fieldRels,
			boolean hasAttachment, int typeDoc, String[] communityPermissions,
			String[] guestPermissions, ThemeDisplay themeDisplay)
			throws PortalException, SystemException, RemoteException {

		return updateDocument(docId, groupId, language, title, userId, content,
				process, base, time, cost, result, require, objects, style,
				note, promulDate, effectivedDate, expiredDate, fieldId,
				orgRels, fieldRels, hasAttachment, typeDoc, null, null,
				themeDisplay);

	}

	public vdocDocument updateDocument(String docId, long groupId,
			String language,long userId, String title, String content, String process,
			String base, String time, String cost, String result,
			String require, String objects, String style, String note,
			Date promulDate, Date effectivedDate, Date expiredDate,
			String fieldId, String orgRels, String fieldRels,
			boolean hasAttachment, int typeDoc,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions,
			ThemeDisplay themeDisplay) throws PortalException, SystemException,
			RemoteException {
		Date now = new Date();

		int userHit = 0;

//		User user = userPersistence.findByPrimaryKey(userId);
		vdocDocument vDoc = vdocDocumentPersistence.findByPrimaryKey(docId);

		vDoc.setCreatedDate(now);
		vDoc.setCreatedByUser(userId);
		vDoc.setGroupId(groupId);
		vDoc.setCompanyId(themeDisplay.getCompanyId());
		vDoc.setLanguage(language);

		vDoc.setFieldId(fieldId);
		vDoc.setFieldRels(fieldRels);
		vDoc.setOrgRels(orgRels);

		vDoc.setTitle(title);
		vDoc.setContent(content);
		vDoc.setProcess(process);
		vDoc.setBase(base);
		vDoc.setTime(time);
		vDoc.setCost(cost);
		vDoc.setResult(result);
		vDoc.setRequire(require);
		vDoc.setObjects(objects);
		vDoc.setStyle(style);
		vDoc.setNote(note);
		vDoc.setUserHit(userHit);
		vDoc.setHasAttachment(hasAttachment);
		vDoc.setTypeDoc(typeDoc);

		vDoc.setCreatedDate(now);
		vDoc.setCreatedByUser(userId);
		vDoc.setUserId(userId);

		vDoc.setApprovedDate(null);
		vDoc.setApprovedByUser(0);
		vDoc.setPublishedDate(null);
		vDoc.setPublishedByUser(0);

		vDoc.setStatusDoc(vdocDocumentServiceImpl.APPROVAL_PENDING);

		vdocDocumentPersistence.update(vDoc, false);

		// Resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
			addEntryResources(vDoc, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addEntryResources(vDoc, communityPermissions, guestPermissions);
		}

		return vDoc;
	}
	
	/**
	 * 
	 * Update Doc
	 * 
	 */
	public vdocDocument updateDocument(vdocDocument doc) throws NoSuchvdocDocumentException, NoSuchUserException, SystemException{
		
		return updateDocument(doc.getDocId(), doc.getGroupId(), doc.getLanguage(), doc.getUserId(), doc.getStatusDoc(), 
				doc.getTitle(), doc.getContent(), doc.getProcess(), doc.getBase(), doc.getTime(), doc.getCost(), 
				doc.getResult(), doc.getRequire(), doc.getObjects(), doc.getStyle(), doc.getNote(), doc.getPromulDate(), 
				doc.getEffectivedDate(), doc.getEffectivedDate(), doc.getFieldId(), doc.getOrgRels(), doc.getFieldRels(), 
				doc.getHasAttachment(), doc.getTypeDoc());
	}
	
	/**
	 * 
	 * Update Doc by param
	 * 
	 */
	public vdocDocument updateDocument(String docId, long groupId, String language, long userId, int status, String title, String content,
			String process, String base, String time, String cost, String result, String require, String objects, String style, String note,
			Date promulDate, Date effectivedDate, Date expiredDate, String fieldId, String orgRels, String fieldRels, boolean hasAttachment, int typeDoc) throws NoSuchvdocDocumentException, SystemException, NoSuchUserException{
		
		vdocDocument doc = vdocDocumentPersistence.findByPrimaryKey(docId);
		
		Date now = new Date();
//		User user = userPersistence.findByPrimaryKey(userId);
		
		doc.setGroupId(groupId);
		doc.setLanguage(language);
		
		doc.setPromulDate(promulDate);
		doc.setEffectivedDate(effectivedDate);
		doc.setExpiredDate(expiredDate);
		doc.setModifiedByUser(userId);
		doc.setModifiedDate(now);
		
		doc.setTitle(title);
		doc.setContent(content);
		doc.setProcess(process);
		doc.setBase(base);
		doc.setTime(time);
		doc.setCost(cost);
		doc.setResult(result);
		doc.setRequire(require);
		doc.setObjects(objects);
		doc.setStyle(style);
		doc.setNote(note);
		
		doc.setFieldId(fieldId);
		doc.setOrgRels(orgRels);
		doc.setFieldRels(fieldRels);
		
		doc.setHasAttachment(hasAttachment);
		doc.setTypeDoc(typeDoc);
		doc.setModifiedDate(now);
		doc.setModifiedByUser(userId);
		
		if(doc.getStatusDoc() != status){
			
			if(status == PUBLISH_PENDING){
				doc.setApprovedDate(now);
				doc.setApprovedByUser(userId);
				
				doc.setPublishedDate(null);
				doc.setPublishedByUser(0);
				
			}else if (status == PUBLISHED){
				doc.setPublishedDate(now);
				doc.setPublishedByUser(userId);
				
			}else if (status == APPROVAL_PENDING) {

				doc.setApprovedDate(null);
				doc.setApprovedByUser(0);

				doc.setPublishedDate(null);
				doc.setPublishedByUser(0);

			}
			doc.setStatusDoc(status);
		}
		vdocDocumentPersistence.update(doc, false);
		
		return doc;
	}
	
	/**
	 * Delete Document By Id
	 * 
	 */
	public void deleteDocument(String docId) throws PortalException, SystemException, RemoteException{
		vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
		deleteDocument(doc);
	}
	
	/**
	 * Delete Document By Object Doc
	 * 
	 */
	public void deleteDocument(vdocDocument doc) throws PortalException, SystemException, RemoteException{
		vdocDORelServiceUtil.deleteRelByDoc(doc.getDocId());
		vdocDocumentPersistence.remove(doc);
	}
	
	/**
	 * 
	 * Update Position Doc
	 * 
	 */
	public vdocDocument updateDocument(String docId, int position) throws SystemException, NoSuchvdocDocumentException{
		vdocDocument doc = vdocDocumentPersistence.findByPrimaryKey(docId);
		doc.setPosition(position);
		return vdocDocumentPersistence.update(doc, false);
	}
	
	public vdocDocument getDocument(String docId) throws SystemException,
			PortalException {
		return vdocDocumentPersistence.findByPrimaryKey(docId);
	}
	
	public List<vdocDocument> getAllDoc() throws SystemException{
		return vdocDocumentPersistence.findAll();
	}
	
	public List<vdocDocument> getAllDoc(int begin, int end) throws SystemException{
		return vdocDocumentPersistence.findAll(begin, end);
	}

	public List<vdocDocument> getDocByG_L_S(long groupId, String language,
			int status) throws SystemException {
		return vdocDocumentPersistence.findByG_L_S(groupId, language, status);
	}

	public List<vdocDocument> getDocByG_L_S(long groupId, String language,
			int status, int begin, int end) throws SystemException {
		return vdocDocumentPersistence.findByG_L_S(groupId, language, status,
				begin, end);
	}

	public int countDocByG_L_S(long groupId, String language, int status)
			throws SystemException, PortalException {

		return vdocDocumentPersistence.countByG_L_S(groupId, language, status);
	}

	public List<vdocDocument> getDocByG_L_F(long groupId, String language,
			String fieldId) throws SystemException, PortalException {

		return vdocDocumentPersistence.findByG_L_F(groupId, language, fieldId);
	}

	public int countDocByG_L_F(long groupId, String language, String fieldId)
			throws SystemException, PortalException {

		return vdocDocumentPersistence.countByG_L_F(groupId, language, fieldId);
	}

	public int countDocByG_L_F_S(long groupId, String language, String fieldId,
			int status) throws SystemException, PortalException {

		return vdocDocumentPersistence.countByG_L_F_S(groupId, language,
				fieldId, status);
	}

	public List<vdocDocument> getDocByG_L_S_T(long groupId, String language,
			int status, int type) throws SystemException, PortalException {
		return vdocDocumentPersistence.findByG_L_S_T(groupId, language, status,
				type);
	}
	public List<vdocDocument> getDocbyModifyDate(long groupId, String language,
			Date modiDateFrom, Date modiDateTo, int status) throws SystemException{
		return vdocDocumentFinder.findDocbyModifyDate(groupId,language,modiDateFrom,modiDateTo,status);
		
	}
	public List<vdocDocument> getDocByG_L_S_T(long groupId, String language,
			int status, int type, int start, int end) throws SystemException,
			PortalException {
		return vdocDocumentPersistence.findByG_L_S_T(groupId, language, status,
				type, start, end);
	}

	public int countDocByG_L_S_T(long groupId, String language, int status,
			int type) throws SystemException, PortalException {
		return vdocDocumentPersistence.countByG_L_S_T(groupId, language,
				status, type);
	}

	public List<vdocDocument> getDocByG_L_S_F_T(long groupId, String language,
			int status, String fieldId, int type) throws PortalException,
			SystemException, RemoteException {

		return vdocDocumentPersistence.findByG_L_S_F_T(groupId, language,
				status, fieldId, type);
	}

	public List<vdocDocument> getDocByG_L_S_F_T(long groupId, String language,
			int status, String fieldId, int type, int start, int end)
			throws PortalException, SystemException, RemoteException {

		return vdocDocumentPersistence.findByG_L_S_F_T(groupId, language,
				status, fieldId, type, start, end);
	}

	public int countDocByG_L_S_F_T(long groupId, String language, int status,
			String fieldId, int type) throws PortalException, SystemException,
			RemoteException {
		return vdocDocumentPersistence.countByG_L_S_F_T(groupId, language,
				status, fieldId, type);
	}
	public List<vdocDocument> getOtherDoc(long groupId, String language,String id,
			int status, int begin, int end) throws PortalException, SystemException,RemoteException{
		
		return vdocDocumentFinder.findOtherDoc(groupId, language, id, status, begin, end);
	}
	
	public int  countOtherDoc(long groupId, String language,String id,
			int status, int begin, int end) throws PortalException, SystemException,RemoteException{
		return vdocDocumentFinder.countDoc(groupId, language, id, status, begin, end);
	}
	/**
	 * 
	 * Add Resource
	 * 
	 */
	public void addEntryResources(long entryId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		vdocDocument entry = vdocDocumentPersistence.findByPrimaryKey(String
				.valueOf(entryId));

		addEntryResources(entry, addCommunityPermissions, addGuestPermissions);
	}

	public void addEntryResources(vdocDocument entry,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(entry.getCompanyId(), entry
				.getGroupId(), entry.getUserId(), vdocDocument.class.getName(),
				entry.getDocId(), false, addCommunityPermissions,
				addGuestPermissions);
	}
	
	public void addEntryResources(long entryId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		vdocDocument entry = vdocDocumentPersistence.findByPrimaryKey(String
				.valueOf(entryId));

		addEntryResources(entry, communityPermissions, guestPermissions);
	}

	public void addEntryResources(vdocDocument entry,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(entry.getCompanyId(), entry
				.getGroupId(), entry.getUserId(), vdocDocument.class.getName(),
				entry.getDocId(), communityPermissions, guestPermissions);
	}

	
//	public vdocDocument getByFieldAndDoc(String fieldId, String docId) throws NoSuchvdocDocumentException, SystemException{
//		return vdocDocumentPersistence.findByField_Doc(fieldId, docId);
//	}
//	
//	/**
//	 * 
//	 * Danh sách Thủ tục theo tiêu đ�?
//	 * 
//	 */
//	@SuppressWarnings("unchecked")
//	public List<vdocDocument> getByTitle(String title) throws SystemException{
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(vdocDocument.class, PortletClassLoaderUtil.getClassLoader());
//		query.add(RestrictionsFactoryUtil.ilike("title", "%"+title+"%"));
//		List<vdocDocument> docList = vdocDocumentServiceUtil.dynamicQuery(query);
//		return docList;
//	}
//	
//	/**
//	 * Danh sách Thủ tục theo lĩnh vực
//	 * 
//	 */
//	@SuppressWarnings("unchecked")
//	public List<vdocDocument> getByField(String fieldId) throws SystemException{
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(vdocDocument.class, PortletClassLoaderUtil.getClassLoader());
//		query.add(RestrictionsFactoryUtil.ilike("fieldId", fieldId));
//		List<vdocDocument> docList = vdocDocumentServiceUtil.dynamicQuery(query);
//		return docList;
//	}
//	
//	/**
//	 * Danh sách Thủ tục theo Organization
//	 * 
//	 */
//	public List<vdocDocument> getByOrg(String orgId) throws SystemException, PortalException{
//		List<vdocDocument> docList = new ArrayList<vdocDocument>();
//		List<vdocDORel> vdocDORelList = vdocDORelServiceUtil.getDORelByOrg(orgId);
//		for(vdocDORel vdocDORel : vdocDORelList){
//			String docId = vdocDORel.getDocId();
//			vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
//			docList.add(doc);
//		}
//		return docList;
//	}
//	
//	/**
//	 * Danh sách thủ tục theo Title và Field
//	 * 
//	 */
//	@SuppressWarnings("unchecked")
//	public List<vdocDocument> getByTitleAndField(String title, String field) throws SystemException{
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(vdocDocument.class, PortletClassLoaderUtil.getClassLoader());
//		query.add(RestrictionsFactoryUtil.ilike(title, "%"+title+"%"));
//		query.add(RestrictionsFactoryUtil.ilike(field, field));
//		
//		List<vdocDocument> docList = vdocDocumentServiceUtil.dynamicQuery(query);
//		return docList;
//	}
//	
//	/**
//	 * Danh sách Thủ tục theo Field và Org
//	 * 
//	 */
//	public List<vdocDocument> getByFieldAndOrg(String fieldId, String orgId) throws SystemException, NoSuchvdocDocumentException{
//		List<vdocDocument> docList = new ArrayList<vdocDocument>();
//		List<vdocDORel> vdocDORelList = vdocDORelServiceUtil.getDORelByOrg(orgId);
//		for(vdocDORel dorel : vdocDORelList){
//			String docId = dorel.getDocId();
//			vdocDocument doc = vdocDocumentServiceUtil.getByFieldAndDoc(fieldId, docId);
//			if(!doc.getDocId().equals("0")){
//				docList.add(doc);
//			}
//		}
//		return docList;
//	}
//	
//	/**
//	 * Danh sách Thủ tục theo Title và Org
//	 * 
//	 */
//	@SuppressWarnings("unchecked")
//	public List<vdocDocument> getByTitleAndOrg(String title, String orgId) throws SystemException{
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(vdocDocument.class, PortletClassLoaderUtil.getClassLoader());
//		List<vdocDocument> docList = new ArrayList<vdocDocument>();
//		List<vdocDORel> vdocDORelList = vdocDORelServiceUtil.getDORelByOrg(orgId);
//		
//		for(vdocDORel dorel : vdocDORelList){
//			query.add(PropertyFactoryUtil.forName("docId").eq(dorel.getDocId()));
//			query.add(RestrictionsFactoryUtil.ilike("title", "%"+title+"%"));
//			List<vdocDocument> docList2 = vdocDocumentServiceUtil.dynamicQuery(query);
//			if(!docList2.isEmpty()){
//				docList.add(docList2.get(0));
//			}
//		}
//		return docList;
//	}
//	
//	/**
//	 * Danh sách Thủ tục theo Title , Field và Org
//	 * 
//	 */
//	@SuppressWarnings("unchecked")
//	public List<vdocDocument> getByTitleAndFieldAndOrg(String title, String fieldId, String orgId) throws SystemException{
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(vdocDocument.class, PortletClassLoaderUtil.getClassLoader());
//		List<vdocDocument> docList = new ArrayList<vdocDocument>();
//		List<vdocDORel> vdocDORelList = vdocDORelServiceUtil.getDORelByOrg(orgId);
//		
//		for(vdocDORel dorel : vdocDORelList){
//			query.add(RestrictionsFactoryUtil.ilike("title", "%"+title+"%"));
//			query.add(RestrictionsFactoryUtil.ilike("fieldId", fieldId));
//			query.add(PropertyFactoryUtil.forName("docId").eq(dorel.getDocId()));
//			List<vdocDocument> docList2 = vdocDocumentServiceUtil.dynamicQuery(query);
//			if(!docList2.isEmpty()){
//				docList.add(docList2.get(0));
//			}
//		}
//		return docList;		
//	}
//	
//	public List<vdocDocument> searchDocByParams(String title, String fieldId, String orgId) throws SystemException{
//		List<vdocDocument> docList = new ArrayList<vdocDocument>();
//		
//		if((title.trim().length() == 0) && (fieldId.equals("0")) && (orgId.equals("0"))){
//			docList = vdocDocumentPersistence.findAll();
//		}
//		// By Title
//		if((title.trim().length() != 0) && (fieldId.equals("0")) && (orgId.equals("0"))){
//			docList = vdocDocumentServiceUtil.getByTitle(title);
//		}
//		// By Field
//		if((title.trim().length() == 0) && (!fieldId.equals("0")) && (orgId.equals("0"))){
//			docList = vdocDocumentServiceUtil.getByField(fieldId);
//		}
//		// By Org
//		if((title.trim().length() == 0) && (fieldId.equals("0")) && (!orgId.equals("0"))){
//			try {
//				docList = vdocDocumentServiceUtil.getByOrg(orgId);
//			} catch (PortalException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if((title.trim().length() != 0) && (!fieldId.equals("0")) && (orgId.equals("0"))){
//			docList = vdocDocumentServiceUtil.getByTitleAndField(title, fieldId);
//		}
//		
//		if((title.trim().length() != 0) && (fieldId.equals("0")) && (!orgId.equals("0"))){
//			docList = vdocDocumentServiceUtil.getByTitleAndOrg(title, orgId);
//		}
//		
//		if((title.trim().length() == 0) && (!fieldId.equals("0")) && (!orgId.equals("0"))){
//			try {
//				docList = vdocDocumentServiceUtil.getByFieldAndOrg(fieldId, orgId);
//			} catch (NoSuchvdocDocumentException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if((title.trim().length() != 0) && (!fieldId.equals("0")) && (!orgId.equals("0"))){
//			docList = vdocDocumentServiceUtil.getByTitleAndFieldAndOrg(title, fieldId, orgId);
//		}
//		return docList;
//	}
	
	@SuppressWarnings("unchecked")
	public List<vdocDocument> searchDocument(long groupId, String language, String fieldId, String orgId, String title, int status){
		List<vdocDocument> vdocList = null;
		try {
			vdocList =  vdocDocumentFinderUtil.findDocumentByParams(groupId, language, fieldId, orgId, title, status);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vdocList;
	}
	
	@SuppressWarnings("unchecked")
	public List<vdocDocument> searchDocument(long groupId, String language, String fieldId, String orgId,
			String title, int status, int begin, int end){
		
		List<vdocDocument> vdocList = null;
		try {
			vdocList =  vdocDocumentFinderUtil.findDocumentByParams(groupId, language,fieldId, orgId, title, status, begin, end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vdocList;
	}
	@SuppressWarnings("unchecked")
	public List<vdocDocument> getDocByPublishDate(long groupId, String language,
			Date pubDateFrom, Date pubDateTo, int status, int quantity)
			throws PortalException, SystemException {

		return vdocDocumentFinder.findDocsByPublishedDate(groupId, language,
				pubDateFrom, pubDateTo, status, quantity);
	}
	
	
}