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
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vdoc.model.vdocDORel;
import com.vportal.portlet.vdoc.model.vdocDocument;
import com.vportal.portlet.vdoc.service.vdocDORelServiceUtil;
import com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil;
import com.vportal.portlet.vdoc.service.base.vdocDORelServiceBaseImpl;
import com.vportal.portlet.vdoc.service.persistence.vdocDORelPK;
import com.vportal.portlet.vdoc.service.persistence.vdocDORelUtil;

/**
 * The implementation of the vdoc d o rel remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vdoc.service.vdocDORelService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see com.vportal.portlet.vdoc.service.base.vdocDORelServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.vdocDORelServiceUtil
 */
public class vdocDORelServiceImpl extends vdocDORelServiceBaseImpl {
	
	public int countCategory_approving(String categoryId)
			throws PortalException, RemoteException, SystemException {
		int count=0;
		List listVdocument = vdocDORelServiceUtil.getDORelByOrg(categoryId);
		for(int i=0;i<listVdocument.size();i++){
		vdocDORel dorel = (vdocDORel)listVdocument.get(i);
		try {
			vdocDocument document = vdocDocumentServiceUtil.getDocument(dorel.getDocId());
			
			if (Validator.isNotNull(document) && Validator.isNotNull(document.getApprovedDate())){
				count+=1;
				
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}}
		
		return count;
	}
	public int countCategory_public(String categoryId)
			throws PortalException, RemoteException, SystemException {
		int count=0;
		List listVdocument = vdocDORelServiceUtil.getDORelByOrg(categoryId);
		for(int i=0;i<listVdocument.size();i++){
			vdocDORel dorel = (vdocDORel)listVdocument.get(i);
			try {
				vdocDocument document = vdocDocumentServiceUtil.getDocument(dorel.getDocId());
				
				if (Validator.isNotNull(document) && Validator.isNotNull(document.getPublishedDate())){
					count+=1;
					
					}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
			
		return count;
	}
	public int countCategory_modify(String categoryId)
			throws PortalException, RemoteException, SystemException {
		int count=0;
		List listVdocument = vdocDORelServiceUtil.getDORelByOrg(categoryId);
		for(int i=0;i<listVdocument.size();i++){
			vdocDORel dorel = (vdocDORel)listVdocument.get(i);
			try {
				vdocDocument document = vdocDocumentServiceUtil.getDocument(dorel.getDocId());
				
				if (Validator.isNotNull(document) && Validator.isNotNull(document.getModifiedDate())){
					count+=1;
					
					}
				
			} catch (Exception e) {
				// TODO: handle exception
			}}
			
			return count;
	}

	
	public vdocDORel addRelation(String docId, String orgId)
			throws RemoteException, SystemException, PortalException {

		vdocDORel relation = null;

		vdocDORelPK pKey = new vdocDORelPK(docId, orgId);

		relation = vdocDORelUtil.create(pKey);

		return vdocDORelUtil.update(relation, false);

	}

	public void deleteRelation(String docId, String orgId)
			throws RemoteException, PortalException, SystemException {

		if (Validator.isNull(orgId) || Validator.isNull(docId)) {
			return;
		}

		vdocDORelPK pKey = new vdocDORelPK(docId, orgId);

		vdocDORelUtil.remove(pKey);
	}

	public void deleteRelByDoc(String docId) throws RemoteException,
			PortalException, SystemException {

		if (Validator.isNull(docId)) {
			return;
		}
		vdocDORelUtil.removeByDocument(docId);
	}

	public List<vdocDORel> getDORelByDoc(String docId) throws SystemException {
		return vdocDORelPersistence.findByDocument(docId);
	}

	public List<vdocDORel> getDORelByOrg(String orgId) throws SystemException {
		return vdocDORelPersistence.findByOrg(orgId);
	}

	public List<vdocDORel> getRelByDoc(String docId) throws RemoteException,
			SystemException, PortalException {

		List<vdocDORel> rels = new ArrayList();

		if (Validator.isNull(docId)) {
			return rels;
		}

		rels = vdocDORelUtil.findByDocument(docId);

		return rels;

	}

	public List<vdocDORel> getRelByField(String orgId) throws RemoteException,
			SystemException, PortalException {

		List<vdocDORel> rels = new ArrayList();

		if (Validator.isNull(orgId)) {
			return rels;
		}

		rels = vdocDORelUtil.findByOrg(orgId);
		return rels;
	}
}