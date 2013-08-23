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

package com.vportal.portlet.vdoc.service.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.vdoc.model.vdocDocument;
import com.vportal.portlet.vdoc.service.persistence.vdocDocumentFinder;
import com.vportal.portlet.vdoc.model.impl.vdocDocumentImpl;

public class vdocDocumentFinderImpl extends vdocDocumentPersistenceImpl implements vdocDocumentFinder{
	
	public static String FIND_BY_D = vdocDocumentFinder.class.getName() + ".findDocument";
	public static String FIND_BY_D1 = "findDocument1";
	public static String COUNT_BY_D = vdocDocumentFinder.class.getName() + ".countDocument";
	public static String FIND_BY_PARAM = vdocDocumentFinder.class.getName() + ".findByParam";
	
	public List findDocumentByParams(long groupId, String language, String fieldId, String orgId, String title, int status) throws SystemException {

		Session session = null;

		try {
			session = openSession();
			String sql = "SELECT vdocDocument.* FROM vdocDocument";
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (!orgId.equals("0")) {
				query.append(" INNER JOIN vdocDORel ");
				query.append(" ON (vdocDocument.docId = vdocDORel.docId)");
			}
			query.append(" WHERE ");

			if (Validator.isNull(String.valueOf(groupId))) {
				return null;
			} else {
				query.append("(vdocDocument.groupId = ?) ");
			}

			if (Validator.isNull(language)) {
				return null;
			} else {
				query.append("AND ");
				query.append("(vdocDocument.language = ?) ");
			}
			
			if (Validator.isNotNull(fieldId) && !Validator.equals(fieldId, "0")) {
				query.append(" AND ");
				query.append("(vdocDocument.fieldId = ?) ");
			}

			if (Validator.isNotNull(orgId) && !Validator.equals(orgId, "0")) {
				query.append(" AND ");
				query.append("(vdocDORel.orgId = ?) ");
			}

			if (Validator.isNotNull(title)) {
				query.append(" AND ");
				query.append("(LOWER(vdocDocument.title) LIKE LOWER(?)) ");
			}

			if (status == 2 || status == 1 || status == 0) {
				query.append("AND ");
				query.append("(vdocDocument.statusDoc = ?) ");
			}
			
			if (status == 2) {
				query.append("ORDER BY ");
				query.append("vdocDocument.publishedDate DESC");
			} else if (status == 1) {
				query.append("ORDER BY ");
				query.append("vdocDocument.approvedDate DESC");
			} else if (status == 0) {
				query.append("ORDER BY ");
				query.append("vdocDocument.createdDate DESC");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("vdocDocument", vdocDocumentImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			
			if (Validator.isNotNull(fieldId) && !Validator.equals(fieldId, "0"))
				q.setString(queryPos++, fieldId);

			if (Validator.isNotNull(orgId) && !Validator.equals(orgId, "0")) {
				q.setString(queryPos++, orgId);
			}

			if (Validator.isNotNull(title))
				q.setString(queryPos++, "%" + title + "%");

			if (status == 2 || status == 1 || status == 0)
				q.setInteger(queryPos++, status);
			
			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<vdocDocument> findDocumentByParams(long groupId, String language, String fieldId, String orgId, String title, int status, int begin, int end) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT vdocDocument.* FROM vdocDocument";
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (!orgId.equals("0")) {
				query.append(" INNER JOIN vdocDORel ");
				query.append(" ON (vdocDocument.docId = vdocDORel.docId)");
			}
			query.append(" WHERE ");

			if (Validator.isNull(String.valueOf(groupId))) {
				return null;
			} else {
				query.append("(vdocDocument.groupId = ?) ");
			}

			if (Validator.isNull(language)) {
				return null;
			} else {
				query.append("AND ");
				query.append("(vdocDocument.language = ?) ");
			}
			
			if (Validator.isNotNull(fieldId) && !Validator.equals(fieldId, "0")) {
				query.append(" AND ");
				query.append("(vdocDocument.fieldId = ?) ");
			}

			if (Validator.isNotNull(orgId) && !Validator.equals(orgId, "0")) {
				query.append(" AND ");
				query.append("(vdocDORel.orgId = ?) ");
			}

			if (Validator.isNotNull(title)) {
				query.append(" AND ");
				query.append("(LOWER(vdocDocument.title) LIKE LOWER(?)) ");
			}

			if (status == 2 || status == 1 || status == 0) {
				query.append("AND ");
				query.append("(vdocDocument.statusDoc = ?) ");
			}
			
			if (status == 2) {
				query.append("ORDER BY ");
				query.append("vdocDocument.publishedDate DESC");
			} else if (status == 1) {
				query.append("ORDER BY ");
				query.append("vdocDocument.approvedDate DESC");
			} else if (status == 0) {
				query.append("ORDER BY ");
				query.append("vdocDocument.createdDate DESC");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("vdocDocument", vdocDocumentImpl.class);
			int queryPos = 0;
			
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			
			if (Validator.isNotNull(fieldId) && !Validator.equals(fieldId, "0"))
				q.setString(queryPos++, fieldId);

			if (Validator.isNotNull(orgId) && !Validator.equals(orgId, "0")) {
				q.setString(queryPos++, orgId);
			}

			if (Validator.isNotNull(title))
				q.setString(queryPos++, "%" + title + "%");

			if (status == 2 || status == 1 || status == 0)
				q.setInteger(queryPos++, status);
			
			return (List<vdocDocument>)QueryUtil.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List findDocsByPublishedDate(long groupId, String language,
			Date pubDateFrom, Date pubDateTo, int status, int quantity)
			throws SystemException {
		Session session = null;

		try {
			session = openSession();
			String sql = "SELECT * FROM vdocDocument";
			StringBuffer query = new StringBuffer();
			query.append(sql);
			query.append(" WHERE ");
			if (Validator.isNull(String.valueOf(groupId))) {
				return null;
			} else {
				query.append(" vdocDocument.groupId = ? ");
			}

			if (Validator.isNull(language)) {
				return null;
			} else {
				query.append(" AND ");
				query.append(" vdocDocument.language = ? ");
			}

			if (pubDateTo != null) {
				query.append(" AND ");
				query.append(" vdocDocument.publishedDate >= ? ");
			}

			if (pubDateFrom != null) {
				query.append(" AND ");
				query.append("vdocDocument.publishedDate <= ? ");
			}

			if (status == 2 || status == 1 || status == 0) {
				query.append(" AND ");
				query.append("vdocDocument.statusDoc = ? ");
			}

			query.append("ORDER BY ");
			query.append("vdocDocument.publishedDate DESC");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("vdocDocument", vdocDocumentImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (pubDateFrom != null)
				q
						.setTimestamp(queryPos++, new Timestamp(pubDateFrom
								.getTime()));
			if (pubDateTo != null)
				q.setTimestamp(queryPos++, new Timestamp(pubDateTo.getTime()));

			if (status == 2 || status == 1 || status == 0)
				q.setInteger(queryPos++, status);

			return QueryUtil.list(q, getDialect(), 0, quantity);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List findDocbyModifyDate(long groupId, String language,
			Date modiDateFrom, Date modiDateTo, int status)
			throws SystemException {
		Session session = null;

		try {
			session = openSession();
			String sql = "SELECT * FROM vdocDocument";
			StringBuffer query = new StringBuffer();
			query.append(sql);
			query.append(" WHERE ");
			if (Validator.isNull(String.valueOf(groupId))) {
				return null;
			} else {
				query.append(" vdocDocument.groupId = ? ");
			}

			if (Validator.isNull(language)) {
				return null;
			} else {
				query.append(" AND ");
				query.append(" vdocDocument.language = ? ");
			}

			if (modiDateTo != null) {
				query.append(" AND ");
				query.append(" vdocDocument.modifiedDate >= ? ");
			}

			if (modiDateFrom != null) {
				query.append(" AND ");
				query.append("vdocDocument.modifiedDate <= ? ");
			}

			if (status == 2 || status == 1 || status == 0) {
				query.append(" AND ");
				query.append("vdocDocument.statusDoc = ? ");
			}

			query.append("ORDER BY ");
			query.append("vdocDocument.modifiedDate DESC");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("vdocDocument", vdocDocumentImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (modiDateFrom != null)
				q
						.setTimestamp(queryPos++, new Timestamp(modiDateFrom
								.getTime()));
			if (modiDateTo != null)
				q.setTimestamp(queryPos++, new Timestamp(modiDateTo.getTime()));

			if (status == 2 || status == 1 || status == 0)
				q.setInteger(queryPos++, status);

			return q.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public String maxPositionDocument(long groupId, String language) throws SystemException{
//		Session session = null;
//		try {
//			session = openSession();
//			DynamicQuery dynamicquery = DynamicQueryFactoryUtil.forClass(vdocDocumentImpl.class, PortalClassLoaderUtil.getClassLoader());
//			dynamicquery.setProjection(ProjectionFactoryUtil.max("position"));
//			List<vdocDocument> results = vdocDocumentServiceUtil.dynamicQuery(dynamicquery);
//			String kq = results.toString();
//			kq.substring(1, kq.indexOf("]"));
//			return kq.substring(1, kq.indexOf("]"));
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new SystemException(e);
//		}
//		finally{
//			closeSession(session);
//		
		return null;
	}
	
	public List findOtherDoc(long groupId, String language,String Id, int status, 
			int begin, int end) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_D1);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			query.append(" WHERE ");
			
			query.append("vdocDocument.groupId = ? ");
			query.append("AND ");
			query.append("vdocDocument.language = ? ");
			
			if (Validator.isNotNull(String.valueOf(Id))) {
				query.append("AND ");
				query.append("vdocDocument.docId <> ? ");
			}

			if (status == 2 || status == 1 || status == 0) {
				query.append("AND ");
				query.append("(vdocDocument.statusDoc = ?) ");
			}
			
			if (status == 2) {
				query.append("ORDER BY ");
				query.append("vdocDocument.publishedDate DESC");
			} else if (status == 1) {
				query.append("ORDER BY ");
				query.append("vdocDocument.approvedDate DESC");
			} else if (status == 0) {
				query.append("ORDER BY ");
				query.append("vdocDocument.createdDate DESC");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("vdocDocument", vdocDocumentImpl.class);
			
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			if (Validator.isNotNull(String.valueOf(Id))) {
				q.setString(queryPos++, Id);
			}

			if (status == 2 || status == 1 || status == 0)
				q.setInteger(queryPos++, status);
			
			return  QueryUtil.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
		
	}
	
	public int  countDoc(long groupId, String language,String Id, int status, 
			int begin, int end) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_D);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			if (Validator.isNotNull(Id)) {
				q.setString(queryPos++, Id);
			}
			if (status == 2 || status == 1 || status == 0)
				q.setInteger(queryPos++, status);
			
			Long count = null;
			Iterator ite = q.list().iterator();
			while (ite.hasNext()) {
				count = (Long) ite.next();
			}
			if (count == null) {
				count = new Long(0);
			}
			return count.intValue();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
