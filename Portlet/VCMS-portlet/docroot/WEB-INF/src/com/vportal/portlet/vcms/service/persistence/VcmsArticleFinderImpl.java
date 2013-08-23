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
package com.vportal.portlet.vcms.service.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.vcms.model.impl.VcmsArticleImpl;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;

public class VcmsArticleFinderImpl extends BasePersistenceImpl implements
		VcmsArticleFinder {
	public static String COUNT_BY_C_P_L_S_D = VcmsArticleFinder.class.getName()
			+ ".countByC_P_L_S_D";
	public static String COUNT_BY_P_L_S_D = VcmsArticleFinder.class.getName()
			+ ".countByP_L_S_D";
	public static String FIND_BY_C_S = VcmsArticleFinder.class.getName()
			+ ".findByC_S";
	public static String FIND_BY_C_S_S = VcmsArticleFinder.class.getName()
			+ ".findByC_S_S";
	public static String FIND_BY_P_S = VcmsArticleFinder.class.getName()
			+ ".findByP_S";
	public static String FIND_BY_P_S_S = VcmsArticleFinder.class.getName()
			+ ".findByP_S_S";
	public static String FIND_BY_L_P_S_S = VcmsArticleFinder.class.getName()
			+ ".findByL_P_S_S";
	public static String FIND_BY_ALL_L_P_S_S = VcmsArticleFinder.class
			.getName()
			+ ".findByAllL_P_S_S";
	public static String COUNT_BY_ALL_L_P_S_S = VcmsArticleFinder.class
			.getName()
			+ ".countByAllL_P_S_S";
	public static String FIND_BY_C_S_AFTER = VcmsArticleFinder.class.getName()
			+ ".findByC_S_After";
	public static String FIND_BY_P_S_AFTER = VcmsArticleFinder.class.getName()
			+ ".findByP_S_After";
	public static String FIND_BY_C_S_BEFORE = VcmsArticleFinder.class.getName()
			+ ".findByC_S_Before";
	public static String FIND_BY_P_S_BEFORE = VcmsArticleFinder.class.getName()
			+ ".findByP_S_Before";
	public static String FIND_BY_C_P_L_S = VcmsArticleFinder.class.getName()
			+ ".findByC_P_L_S";
	public static String COUNT_BY_C_P_L_S = VcmsArticleFinder.class.getName()
			+ ".countByC_P_L_S";
	public static String FIND_BY_P_P_L_S = VcmsArticleFinder.class.getName()
			+ ".findByP_P_L_S";
	public static String COUNT_BY_P_P_L_S = VcmsArticleFinder.class.getName()
			+ ".countByP_P_L_S";
	public static String FIND_BY_T_P_L_S = VcmsArticleFinder.class.getName()
			+ ".findByT_P_L_S";
	public static String COUNT_BY_T_P_L_S = VcmsArticleFinder.class.getName()
			+ ".countByT_P_L_S";
	public static String FIND_BY_TS_P_L_S = VcmsArticleFinder.class.getName()
			+ ".findByTS_P_L_S";
	public static String GET_UPCOMINGEXPRIRE = VcmsArticleFinder.class
			.getName()
			+ ".getUpComingExpiredArticles";

	public static String FIND_BY_G_L_S_T = VcmsArticleFinder.class.getName()
			+ ".findByG_L_S_T";
	public static String COUNT_BY_G_L_S_T = VcmsArticleFinder.class.getName()
			+ ".countByG_L_S_T";

	public static String FIND_BY_G_L_S_C_D = VcmsArticleFinder.class.getName()
			+ ".findByG_L_S_C_D";
	//	
	//

	public static String COUNT_BY_G_L_S_C_D = VcmsArticleFinder.class.getName()
			+ ".countByG_L_S_C_D";

	public static String COUNT_OTHER_ARTICLE = VcmsArticleFinder.class
			.getName()
			+ ".countOtherArticle";

	public static String FIND_OTHER_ARTICLE = VcmsArticleFinder.class.getName()
			+ ".findOtherArticle";

	public static String COUNT_BY_G_L_C_S_T = VcmsArticleFinder.class.getName()
			+ ".countByG_L_C_S_T";

	public static String FIND_BY_G_L_C_S_T = VcmsArticleFinder.class.getName()
			+ ".findByG_L_C_S_T";
	
	public static String COUNT_ARTICLE_NOT_IN_TYPE = VcmsArticleFinder.class
			.getName()+ ".countArticleNotInType";
	public static String COUNT_ARTICLE_ALL_CAT_NOT_IN_TYPE = VcmsArticleFinder.class
	.getName()+ ".countArticleAllCatNotInType";

	//report by date
	public static String FIND_ARTICLE_BY_DATE = VcmsArticleFinder.class.getName()
	+ ".findArticleByDate";
	public static String FIND_ARTICLE_BY_DATE_NOT_TYPE = VcmsArticleFinder.class.getName()
	+ ".findArticleByDateNotType";
	
	public static String COUNT_ARTICLE_BY_DATE = VcmsArticleFinder.class.getName()
	+ ".countArticleByDate";
	public static String COUNT_ARTICLE_BY_DATE_NOT_TYPE = VcmsArticleFinder.class.getName()
	+ ".countArticleByDateNotType";
	
	public static String FIND_ARTICLE_BY_DATE_TYPES = VcmsArticleFinder.class.getName()
	+ ".findArticleByDateTypes";
	public static String COUNT_ARTICLE_BY_DATE_TYPES = VcmsArticleFinder.class.getName()
	+ ".countArticleByDateTypes";
	
	public static String FIND_ARTICLE_BY_DATE_TYPES_NO_JOIN = VcmsArticleFinder.class.getName()
	+ ".findArticleByDateTypesNoJoin";
	public static String COUNT_ARTICLE_BY_DATE_TYPES_NO_JOIN = VcmsArticleFinder.class.getName()
	+ ".countArticleByDateTypesNoJoin";

	public int countOtherArticle(long groupId, String language, long statusId,
			String categoryId, String articleId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_OTHER_ARTICLE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setString(queryPos++, categoryId);
			q.setString(queryPos++, articleId);

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	public List findOtherArticle(long groupId, String language, long statusId,
			String categoryId, String articleId, int begin, int end)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_OTHER_ARTICLE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setString(queryPos++, categoryId);
			q.setString(queryPos++, articleId);

			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByG_L_S_C_D(long groupId, String language, long statusId,
			String categoryId, Date fromDate, Date toDate)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_S_C_D);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setString(queryPos++, categoryId);
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	public List findByG_L_S_C_D(long groupId, String language, long statusId,
			String categoryId, Date fromDate, Date toDate, int begin, int end)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_L_S_C_D);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setString(queryPos++, categoryId);
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));

			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// reportByDate
	public List findArticleByDate(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser, long typeId, int begin, int end)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ARTICLE_BY_DATE);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(byUser)) {
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");				
			}
			if(Validator.isNotNull(typeId) && typeId !=0){
				query.append(" AND ");
				query.append(" VcmsArticle.articleId = VcmsArticleType.articleId ");
				query.append(" AND ");
				query.append(" VcmsArticleType.typeId= ? ");
			}
			
			query.append(" ORDER BY VcmsArticle.publishedDate DESC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if(Validator.isNotNull(typeId) && typeId!=0){
				q.setLong(queryPos++, typeId);
			}

			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	// reportByDateNotType
	public List findArticleByDateNotType(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser, int begin, int end)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ARTICLE_BY_DATE_NOT_TYPE);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(byUser)) {
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");				
			}
			
			query.append(" ORDER BY VcmsArticle.publishedDate DESC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			
			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}	
	
	//report countByDate
	public int countArticleByDate(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser, long typeId)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_BY_DATE);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(byUser)) {
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");				
			}
			if(Validator.isNotNull(typeId) && typeId !=0){
				query.append(" AND ");
				query.append(" VcmsArticle.articleId = VcmsArticleType.articleId ");
				query.append(" AND ");
				query.append(" VcmsArticleType.typeId= ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if(Validator.isNotNull(typeId) && typeId!=0){
				q.setLong(queryPos++, typeId);
			}

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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
	
	//report countByDateNotType
	public int countArticleByDateNotType(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_BY_DATE_NOT_TYPE);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(byUser)) {
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");				
			}			
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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
	
	public List findArticleByDateTypes(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser, String[] strType, int begin, int end)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = "";
			if (Validator.isNotNull(strType)&&strType.length>0) {
				sql= CustomSQLUtil.get(FIND_ARTICLE_BY_DATE_TYPES);
			}else{
				sql = CustomSQLUtil.get(FIND_ARTICLE_BY_DATE_TYPES_NO_JOIN);
			}
			StringBuffer query = new StringBuffer();
			query.append(sql);
			
			if (Validator.isNotNull(strType)&&strType.length>0) {
				
				query.append("INNER JOIN VcmsArticleType ");
				query.append("ON VcmsArticle.articleId = VcmsArticleType.articleId ");
				
			}
			
			query.append("WHERE ");			
			query.append("VcmsArticle.groupId = ? ");
			query.append("AND ");
			
			query.append("VcmsArticle.language = ? ");
			query.append("AND ");
			
			query.append("VcmsArticle.status = ? ");
			query.append("AND ");
			
			query.append("VcmsArticle.publishedDate BETWEEN ? AND ? ");
			
			if (Validator.isNotNull(byUser)) {
				query.append("AND ");
				query.append("VcmsArticle.createdByUser = ? ");				
			}
			
			if(Validator.isNotNull(strType) && strType.length>0){
				StringBuffer str = new StringBuffer();
				str.append(strType[0]);
				for(int i =1; i < strType.length; i++){
					str.append(",");
					str.append(strType[i]);
				}
				
				query.append("AND ");
				query.append("VcmsArticleType.typeId IN ("+ str +")");				
			}			
			
			query.append("ORDER BY VcmsArticle.publishedDate DESC");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if(Validator.isNotNull(strType) && strType.length>0){
				
				//q.setString(queryPos++, String.valueOf(str));
			}
			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	public int countArticleByDateTypes(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser, String[] strType)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_BY_DATE_TYPES);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			
			if (Validator.isNotNull(strType)&&strType.length>0) {
				
				query.append("INNER JOIN VcmsArticleType ");
				query.append("ON VcmsArticle.articleId = VcmsArticleType.articleId ");
				
			}
			
			query.append("WHERE ");			
			query.append("VcmsArticle.groupId = ? ");
			query.append("AND ");
			
			query.append("VcmsArticle.language = ? ");
			query.append("AND ");
			
			query.append("VcmsArticle.status = ? ");
			query.append("AND ");
			
			query.append("VcmsArticle.publishedDate BETWEEN ? AND ? ");
			
			if (Validator.isNotNull(byUser)) {
				query.append("AND ");
				query.append("VcmsArticle.createdByUser = ? ");				
			}
			
			if(Validator.isNotNull(strType) && strType.length>0){
				StringBuffer str = new StringBuffer();
				str.append(strType[0]);
				for(int i =1; i < strType.length; i++){
					str.append(",");
					str.append(strType[i]);
				}
				
				query.append("AND ");
				query.append("VcmsArticleType.typeId IN ("+ str +")");				
			}	
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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
	
	//report By Type
	public int countByType(long groupId, String language, long statusId,
			long typeId, Date fromDate, Date toDate, String byUser) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_S_T);
			
			StringBuffer query = new StringBuffer();
			query.append(sql);
			if(Validator.isNotNull(byUser)){
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");
			}
			if(Validator.isNotNull("fromDate")&& Validator.isNotNull("toDate")){
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate > ? ");
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate < ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setLong(queryPos++, typeId);
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
				q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
				q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			}
			
			Long count = null;
			
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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
	
	//report not in type
	public int countArticleNotInType(long groupId, String language, String categoryId,
			long statusId, Date fromDate, Date toDate,
			String byUser) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_NOT_IN_TYPE);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			if(Validator.isNotNull(byUser)){
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");
			}
			if(Validator.isNotNull("fromDate")&& Validator.isNotNull("toDate")){
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate > ? ");
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate < ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, statusId);			
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
				q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
				q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			}
			
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	//not in type and all category
	public int countArticleAllCatNotInType(long groupId, String language,
			long statusId, Date fromDate, Date toDate,
			String byUser) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_ALL_CAT_NOT_IN_TYPE);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			if(Validator.isNotNull(byUser)){
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");
			}
			if(Validator.isNotNull("fromDate")&& Validator.isNotNull("toDate")){
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate > ? ");
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate < ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);			
			q.setLong(queryPos++, statusId);			
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
				q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
				q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			}
			
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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
	
	//reportByUser
	public int countByUser(long groupId, String language, String categoryId,
			long statusId, long typeId, Date fromDate, Date toDate,
			String byUser) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_C_S_T);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			if(Validator.isNotNull(byUser)){
				query.append(" AND ");
				query.append(" VcmsArticle.createdByUser = ? ");
			}
			if(Validator.isNotNull("fromDate")&& Validator.isNotNull("toDate")){
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate > ? ");
				query.append(" AND ");
				query.append(" VcmsArticle.publishedDate < ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, statusId);
			q.setLong(queryPos++, typeId);
			
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}
			if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
				q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
				q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
			}
			
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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
	
	public int countByG_L_C_S_T(long groupId, String language,
			String categoryId, long statusId, long typeId)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_C_S_T);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, statusId);
			q.setLong(queryPos++, typeId);

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	public List findByG_L_C_S_T(long groupId, String language,
			String categoryId, long statusId, long typeId, int begin, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_L_C_S_T);
			sql = StringUtil.replace(sql, "[$GROUP_IDS$]", categoryId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			//q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, statusId);
			q.setLong(queryPos++, typeId);
			
			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByG_L_S_T(long groupId, String language, long statusId,
			long typeId) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_S_T);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setLong(queryPos++, typeId);

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	public List findByG_L_S_T(long groupId, String language, long statusId,
			long typeId, int begin, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_L_S_T);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setLong(queryPos++, typeId);

			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByC_P_L_S_D(String categoryId, long groupId,
			String language, long statusId, Date fromDate, Date toDate,
			String byUser) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_C_P_L_S_D);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			if (fromDate != null && toDate != null) {
				if (statusId == 0) {
					query.append(" AND ");
					query.append(" VcmsArticle.createdDate < ?");
					query.append(" AND ");
					query.append(" VcmsArticle.createdDate > ?");
				} else {
					if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
							.getActive()) {
						query.append(" AND ");
						query.append(" VcmsArticle.publishedDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.publishedDate > ?");

					} else {
						query.append(" AND ");
						query.append(" VcmsArticle.modifiedDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.modifiedDate > ?");
					}
				}
			}
			if (Validator.isNotNull(byUser)) {
				/*if (statusId == 0) {
					query.append(" AND ");
					query.append(" VcmsArticle.createdByUser = ?");
				} else if (statusId == 1) {
					query.append(" AND ");
					query.append(" VcmsArticle.approvedByUser = ?");
				} else if (statusId == 2) {
					query.append(" AND ");
					query.append(" VcmsArticle.publishedByUser = ?");
				}*/

				if (statusId == 0) {
					query.append(" AND ");
					query.append(" VcmsArticle.createdByUser = ?");
				} else {
					if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
							.getActive()) {
						query.append(" AND ");
						query.append(" VcmsArticle.publishedByUser = ?");

					} else {
						query.append(" AND ");
						query.append(" VcmsArticle.modifiedByUser = ?");

					}
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			if (fromDate != null && toDate != null) {
				q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
				q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			}
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();
			}
			return count.intValue();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByP_L_S_D(long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_P_L_S_D);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (fromDate != null && toDate != null) {
				if (statusId == 0) {
					query.append(" AND ");
					query.append(" VcmsArticle.createdDate < ?");
					query.append(" AND ");
					query.append(" VcmsArticle.createdDate > ?");
				} else {
					if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
							.getActive()) {
						query.append(" AND ");
						query.append(" VcmsArticle.publishedDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.publishedDate > ?");

					} else {
						query.append(" AND ");
						query.append(" VcmsArticle.modifiedDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.modifiedDate > ?");
					}
				}
			}
			if (Validator.isNotNull(byUser)) {

				if (statusId == 0) {
					query.append(" AND ");
					query.append(" VcmsArticle.createdByUser = ?");
				} else {
					if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
							.getActive()) {
						query.append(" AND ");
						query.append(" VcmsArticle.publishedByUser = ?");

					} else {
						query.append(" AND ");
						query.append(" VcmsArticle.modifiedByUser = ?");

					}
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			if (fromDate != null && toDate != null) {
				q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
				q.setTimestamp(queryPos++, new Timestamp(fromDate.getTime()));
			}
			if (Validator.isNotNull(byUser)) {
				q.setString(queryPos++, byUser);
			}

			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();
			}
			return count.intValue();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByC_S(long groupId, String language, String categoryId,
			long statusId, int quantity) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_C_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByG_L_C_S(long groupId, String language, String categoryId,
			long statusId, int quantity) throws SystemException {
		Session session = null;
		//SessionFactory sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT VcmsArticle.* , VcmsCARelation.articleId as CA_articleId,VcmsCARelation.categoryId FROM VcmsArticle ");
			sql.append("INNER JOIN VcmsCARelation ");
			sql.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			sql.append("WHERE ");
			sql.append("(VcmsCARelation.categoryId in (" + categoryId
					+ ")) AND ");
			sql.append("(VcmsArticle.groupId =?) AND ");
			sql.append("(VcmsArticle.language = ?) AND ");
			sql.append("(VcmsArticle.status = ?) ");
			sql.append("ORDER BY ");
			sql.append("VcmsArticle.publishedDate DESC");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List findByC_S_S(long groupId, String language, String categoryId,
			long statusId, boolean sticky, int quantity) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_C_S_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setBoolean(queryPos++, sticky);
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByP_S(long groupId, String language, String portionId,
			long statusId, int quantity) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByP_S_S(long groupId, String language, String portionId,
			long statusId, boolean sticky, int quantity) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P_S_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setBoolean(queryPos++, sticky);

			return QueryUtil.list(q, getDialect(), 0, quantity);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByL_P_S_S(long groupId, String language, String categoryId,
			long statusId, int begin, int end, OrderByComparator obc)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_L_P_S_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			List list = QueryUtil.list(q, getDialect(), begin, end);
			return list;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByAllL_P_S_S(long groupId, String language,
			String categoryId, long statusId, int begin, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT VcmsArticle.* , VcmsCARelation.articleId as CA_articleId,VcmsCARelation.categoryId FROM VcmsArticle ");
			sql.append("INNER JOIN VcmsCARelation ");
			sql
					.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			sql.append("WHERE ");
			sql.append("(VcmsCARelation.categoryId in (" + categoryId
					+ ")) AND ");
			sql.append("(VcmsArticle.groupId =?) AND ");
			sql.append("(VcmsArticle.language = ?) AND ");
			sql.append("(VcmsArticle.status = ?) ");
			sql.append("ORDER BY ");
			sql.append("VcmsArticle.publishedDate DESC");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			return QueryUtil.list(q, getDialect(), begin, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByAllL_P_S_S(long groupId, String language,
			String categoryId, long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(*) as total FROM VcmsArticle ");
			sql.append("INNER JOIN VcmsCARelation ");
			sql
					.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			sql.append("WHERE ");
			sql.append("(VcmsCARelation.categoryId in (" + categoryId
					+ ")) AND ");
			sql.append("(VcmsArticle.groupId = ?) AND ");
			sql.append("(VcmsArticle.language = ?) AND ");
			sql.append("(VcmsArticle.status = ?) ");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("total", Type.LONG);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			Iterator ite = q.list().iterator();
			Long count = null;
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

	public List findByC_S_After(long groupId, String language,
			String categoryId, long statusId, int quantity, Date date)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_C_S_AFTER);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByG_L_C_S_After(long groupId, String language,
			String categoryId, long statusId, int quantity, Date date)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT VcmsArticle.* , VcmsCARelation.articleId as CA_articleId,VcmsCARelation.categoryId FROM VcmsArticle ");
			sql.append("INNER JOIN VcmsCARelation ");
			sql
					.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			sql.append("WHERE ");
			sql.append("(VcmsCARelation.categoryId in (" + categoryId
					+ ")) AND ");
			sql.append("(VcmsArticle.groupId = ?) AND ");
			sql.append("(VcmsArticle.language = ?) AND ");
			sql.append("(VcmsArticle.status = ?) AND ");
			sql.append("(VcmsArticle.publishedDate < ?) ");
			sql.append("ORDER BY ");
			sql.append("VcmsArticle.publishedDate DESC");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByP_S_After(long groupId, String language,
			String portionId, long statusId, int quantity, Date date)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P_S_AFTER);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));

			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByC_S_Before(long groupId, String language,
			String categoryId, long statusId, int quantity, Date date)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_C_S_BEFORE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByG_L_C_S_Before(long groupId, String language,
			String categoryId, long statusId, int quantity, Date date)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT VcmsArticle.* , VcmsCARelation.articleId as CA_articleId,VcmsCARelation.categoryId FROM VcmsArticle ");
			sql.append("INNER JOIN VcmsCARelation ");
			sql
					.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			sql.append("WHERE ");
			sql.append("(VcmsCARelation.categoryId in (" + categoryId
					+ ")) AND ");
			sql.append("(VcmsArticle.groupId = ?) AND ");
			sql.append("(VcmsArticle.language = ?) AND ");
			sql.append("(VcmsArticle.status = ?) AND ");
			sql.append("(VcmsArticle.publishedDate > ?) ");
			sql.append("ORDER BY ");
			sql.append("VcmsArticle.publishedDate DESC");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByG_L_P_S_Before(long groupId, String language,
			String portionId, long statusId, int quantity, Date date)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P_S_BEFORE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));

			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByC_P_L_S(String categoryId, long groupId, String language,
			long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_C_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByC_P_L_S(String categoryId, long groupId, String language,
			long statusId, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_C_P_L_S);
			sql = StringUtil.replace(sql, "[$GROUP_IDS$]", categoryId);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			//q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByC_P_L_S(String categoryId, long groupId, String language,
			long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_C_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();
			}
			return count.intValue();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByP_P_L_S(String portionId, long groupId, String language,
			long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return q.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByP_P_L_S(String portionId, long groupId, String language,
			long statusId, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByP_P_L_S(String portionId, long groupId, String language,
			long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_P_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();
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

	public List findByT_P_L_S(String threadId, long groupId, String language,
			long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_T_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, threadId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByT_P_L_S(String threadId, long groupId, String language,
			long statusId, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_T_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, threadId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByT_P_L_S(String threadId, long groupId, String language,
			long statusId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_T_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setString(queryPos++, threadId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	public List findByT_P_L_S(long groupId, String language, String threadId,
			long statusId, int quantity) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_T_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, threadId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByT_P_L_S(long groupId, String language,
			String[] threadIds, long statusId, int quantity)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_TS_P_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			StringBuffer threadIdBuff = new StringBuffer("");
			for (int i = 0; i < threadIds.length; i++) {
				threadIdBuff.append(threadIds[i]);
				if (i != threadIds.length - 1) {
					threadIdBuff.append(", ");
				}
			}
			int queryPos = 0;
			q.setString(queryPos++, threadIdBuff.toString());
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			return QueryUtil.list(q, getDialect(), 0, quantity);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List getUpComingExpiredArticles(Date date) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_UPCOMINGEXPRIRE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setTimestamp(queryPos++, new Timestamp(date.getTime()));
			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findBySearchContainer_C(String keyword, long groupId,
			String language, String parentId, boolean isTitle, boolean isLead,
			boolean isContent, boolean isDate, Date fromDate, Date toDate,
			long statusId, String select) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsArticle ");

			if (Validator.isNotNull(parentId)) {
				query.append(" INNER JOIN VcmsCARelation ");
				query
						.append(" ON VcmsArticle.articleId = VcmsCARelation.articleId ");
			}

			query.append(" WHERE ");

			if (Validator.isNotNull(parentId)) {
				query.append(" VcmsCARelation.categoryId = ? ");
				query.append(" AND ");
			}

			query.append(" VcmsArticle.groupId = ? ");

			query.append(" AND ");
			query.append(" VcmsArticle.language = ? ");

			query.append(" AND ");
			query.append(" VcmsArticle.status = ? ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append(" AND ");
						query.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");
					} else {
						query.append(" AND ");
						query.append(" ( ");
						if (isTitle) {
							query
									.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");

						}
						if (isLead) {
							query.append(" OR ");
							query
									.append(" LOWER(VcmsArticle.lead) LIKE LOWER(?)");

						}
						if (isContent) {
							query.append(" OR ");
							query
									.append(" LOWER(VcmsArticle.content) LIKE LOWER(?)");
						}
						query.append(" ) ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append(" AND ");
						query.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");
					} else {
						if (isTitle) {
							query.append(" AND ");
							query
									.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");

						}
						if (isLead) {
							query.append(" AND ");
							query
									.append(" LOWER(VcmsArticle.lead) LIKE LOWER(?)");

						}
						if (isContent) {
							query.append(" AND ");
							query
									.append(" LOWER(VcmsArticle.content) LIKE LOWER(?)");

						}
					}
				}
			}

			if (statusId == 0) {
				query.append(" ORDER BY VcmsArticle.createdDate DESC ");
			} else {
				if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
						.getActive()) {
					query.append(" ORDER BY VcmsArticle.publishedDate DESC ");
				} else {
					query.append(" ORDER BY VcmsArticle.modifiedDate DESC ");
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			if (Validator.isNotNull(parentId)) {
				q.setString(queryPos++, parentId);
			}

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findBySearchContainer_C(String keyword, long groupId,
			String language, String parentId, long typeId, boolean isTitle,
			boolean isLead, boolean isContent, boolean isDate, Date fromDate,
			Date toDate, long statusId, String select, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			
			/*query.append("SELECT * FROM VcmsArticle ");*/
			//hoan
			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
					query.append("SELECT VcmsArticle.*, VcmsCARelation.articleId as caArticleId, VcmsArticleType.articleId as atArticleId FROM VcmsArticle ");
				}else{
					query.append("SELECT VcmsArticle.*, VcmsCARelation.articleId as caArticleId FROM VcmsArticle ");
				}
			}else{
				if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
					query.append("SELECT VcmsArticle.*, VcmsArticleType.articleId as atArticleId FROM VcmsArticle ");
				}else{
					query.append("SELECT * FROM VcmsArticle ");
				}
			}
			//hoan

			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				query.append("INNER JOIN VcmsCARelation ");
				query
						.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("INNER JOIN VcmsArticleType ");
				query
						.append("ON (VcmsArticle.articleId = VcmsArticleType.articleId) ");
			}

			query.append("WHERE ");

			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				query.append("(VcmsCARelation.categoryId = ?) ");
				query.append("AND ");
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("(VcmsArticleType.typeId = ?) ");
				query.append("AND ");
			}

			query.append("(VcmsArticle.groupId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.language = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.status = ?) ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (fromDate != null && toDate != null) {
						if (statusId == 0) {
							query.append(" AND ");
							query.append(" VcmsArticle.createdDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.createdDate > ?");
						} else {
							if (VcmsStatusLocalServiceUtil.getVcmsStatus(
									statusId).getActive()) {
								query.append(" AND ");
								query.append(" VcmsArticle.publishedDate < ?");
								query.append(" AND ");
								query.append(" VcmsArticle.publishedDate > ?");

							} else {
								query.append(" AND ");
								query.append(" VcmsArticle.modifiedDate < ?");
								query.append(" AND ");
								query.append(" VcmsArticle.modifiedDate > ?");
							}
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

					} else {
						query.append("AND ");
						query.append("( ");
						if (isTitle) {
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");
						}
						query.append(") ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						if (isTitle) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");

						}
					}
				}
			}

			if (statusId == 0) {
				query.append(" ORDER BY VcmsArticle.createdDate DESC ");
			} else {
				if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
						.getActive()) {
					query.append(" ORDER BY VcmsArticle.publishedDate DESC ");
				} else {
					query.append(" ORDER BY VcmsArticle.modifiedDate DESC ");
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());

			System.out.println(query);

			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				q.setString(queryPos++, parentId);
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				q.setLong(queryPos++, typeId);
			}

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}

			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBySearchContainer_C(String keyword, long groupId,
			String language, String parentId, long typeId, boolean isTitle,
			boolean isLead, boolean isContent, boolean isDate, Date fromDate,
			Date toDate, long statusId, String select) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT COUNT(*) AS total FROM VcmsArticle ");

			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				query.append("INNER JOIN VcmsCARelation ");
				query
						.append("ON (VcmsArticle.articleId = VcmsCARelation.articleId) ");
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("INNER JOIN VcmsArticleType ");
				query
						.append("ON (VcmsArticle.articleId = VcmsArticleType.articleId) ");
			}

			query.append("WHERE ");

			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				query.append("(VcmsCARelation.categoryId = ?) ");
				query.append("AND ");
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("(VcmsArticleType.typeId = ?) ");
				query.append("AND ");
			}

			query.append("(VcmsArticle.groupId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.language = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.status = ?) ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						query.append("AND ");
						query.append("( ");
						if (isTitle) {
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");
						}
						query.append(") ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						if (isTitle) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");

						}
					}
				}
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
				q.setString(queryPos++, parentId);
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				q.setLong(queryPos++, typeId);
			}

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}
			Long count = null;
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
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

	public List findBySearchContainer_P(String keyword, long groupId,
			String language, String portionId, boolean isTitle, boolean isLead,
			boolean isContent, boolean isDate, Date fromDate, Date toDate,
			long statusId, String select) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsArticle ");

			query.append(" INNER JOIN VcmsPARelation ");
			query
					.append(" ON VcmsArticle.articleId = VcmsPARelation.articleId ");

			query.append(" WHERE ");

			query.append(" VcmsPARelation.portionId = ? ");

			query.append(" AND ");
			query.append(" VcmsArticle.groupId = ? ");

			query.append(" AND ");
			query.append(" VcmsArticle.language = ? ");

			query.append(" AND ");
			query.append(" VcmsArticle.status = ? ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append(" AND ");
						query.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");
					} else {
						query.append(" AND ");
						query.append(" ( ");
						if (isTitle) {
							query
									.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");

						}
						if (isLead) {
							query.append(" OR ");
							query
									.append(" LOWER(VcmsArticle.lead) LIKE LOWER(?)");

						}
						if (isContent) {
							query.append(" OR ");
							query
									.append(" LOWER(VcmsArticle.content) LIKE LOWER(?)");
						}
						query.append(" ) ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append(" AND ");
						query.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");
					} else {
						if (isTitle) {
							query.append(" AND ");
							query
									.append(" LOWER(VcmsArticle.title) LIKE LOWER(?)");

						}
						if (isLead) {
							query.append(" AND ");
							query
									.append(" LOWER(VcmsArticle.lead) LIKE LOWER(?)");

						}
						if (isContent) {
							query.append(" AND ");
							query
									.append(" LOWER(VcmsArticle.content) LIKE LOWER(?)");

						}
					}
				}
			}

			if (statusId == 0) {
				query.append(" ORDER BY VcmsArticle.createdDate DESC ");
			} else {
				if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
						.getActive()) {
					query.append(" ORDER BY VcmsArticle.publishedDate DESC ");

				} else {
					query.append(" ORDER BY VcmsArticle.modifiedDate DESC ");
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findBySearchContainer_P(String keyword, long groupId,
			String language, String portionId, boolean isTitle, boolean isLead,
			boolean isContent, boolean isDate, Date fromDate, Date toDate,
			long statusId, String select, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsArticle ");

			query.append("INNER JOIN VcmsPARelation ");
			query
					.append("(ON VcmsArticle.articleId = VcmsPARelation.articleId) ");

			query.append("WHERE ");

			query.append("(VcmsPARelation.portionId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.groupId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.language = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.status = ?) ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						query.append("AND ");
						query.append("( ");
						if (isTitle) {
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");
						}
						query.append(") ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						if (isTitle) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");

						}
					}
				}
			}

			if (statusId == 0) {
				query.append(" ORDER BY VcmsArticle.createdDate DESC ");
			} else {
				if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
						.getActive()) {
					query.append(" ORDER BY VcmsArticle.publishedDate DESC ");

				} else {
					query.append(" ORDER BY VcmsArticle.modifiedDate DESC ");
				}
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}

			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBySearchContainer_P(String keyword, long groupId,
			String language, String portionId, boolean isTitle, boolean isLead,
			boolean isContent, boolean isDate, Date fromDate, Date toDate,
			long statusId, String select) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT COUNT(*) as total FROM VcmsArticle ");

			query.append("INNER JOIN VcmsPARelation ");
			query
					.append("(ON VcmsArticle.articleId = VcmsPARelation.articleId) ");

			query.append("WHERE ");

			query.append("(VcmsPARelation.portionId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.groupId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.language = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.status = ?) ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						query.append("AND ");
						query.append("( ");
						if (isTitle) {
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");
						}
						query.append(") ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						if (isTitle) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");

						}
					}
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setString(queryPos++, portionId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);
			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}
			Long count = null;
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
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

	public List findBySearchContainer_T(String categoryId, long typeId,
			String keyword, long groupId, String language, String threadId,
			boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
			Date fromDate, Date toDate, long statusId, String select,
			int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsArticle ");

			query.append("INNER JOIN VcmsTARelation ");
			query
					.append("ON VcmsArticle.articleId = VcmsTARelation.articleId ");

			if (Validator.isNotNull(categoryId) && categoryId != "0") {
				query.append("INNER JOIN VcmsCARelation ");
				query
						.append("ON VcmsArticle.articleId = VcmsCARelation.articleId ");

			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("INNER JOIN VcmsArticleType ");
				query
						.append("ON (VcmsArticle.articleId = VcmsArticleType.articleId) ");
			}

			query.append("WHERE ");

			query.append("(VcmsTARelation.threadId = ?) ");

			if (Validator.isNotNull(categoryId) && categoryId != "0") {
				query.append("AND ");
				query.append("(VcmsCARelation.categoryId = ?) ");
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("AND ");
				query.append("(VcmsArticleType.typeId = ?) ");
			}

			query.append("AND ");
			query.append("(VcmsArticle.groupId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.language = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.status = ?) ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						query.append("AND ");
						query.append("( ");
						if (isTitle) {
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");
						}
						query.append(") ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						if (isTitle) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");

						}
					}
				}
			}

			if (statusId == 0) {
				query.append("ORDER BY VcmsArticle.createdDate DESC ");
			} else {
				if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
						.getActive()) {
					query.append("ORDER BY VcmsArticle.publishedDate DESC ");
				} else {
					query.append("ORDER BY VcmsArticle.modifiedDate DESC ");

				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsArticle", VcmsArticleImpl.class);
			int queryPos = 0;
			q.setString(queryPos++, threadId);

			if (Validator.isNotNull(categoryId) && categoryId != "0") {
				q.setString(queryPos++, categoryId);
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				q.setLong(queryPos++, typeId);
			}

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}

			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBySearchContainer_T(String categoryId, long typeId,
			String keyword, long groupId, String language, String threadId,
			boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
			Date fromDate, Date toDate, long statusId, String select)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT COUNT(*) as total FROM VcmsArticle ");

			query.append("INNER JOIN VcmsTARelation ");
			query
					.append("ON VcmsArticle.articleId = VcmsTARelation.articleId ");

			if (Validator.isNotNull(categoryId) && categoryId != "0") {
				query.append("INNER JOIN VcmsCARelation ");
				query
						.append("ON VcmsArticle.articleId = VcmsCARelation.articleId ");

			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("INNER JOIN VcmsArticleType ");
				query
						.append("ON (VcmsArticle.articleId = VcmsArticleType.articleId) ");
			}

			query.append("WHERE ");

			query.append("(VcmsTARelation.threadId = ?) ");

			if (Validator.isNotNull(categoryId) && categoryId != "0") {
				query.append("AND ");
				query.append("(VcmsCARelation.categoryId = ?) ");
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				query.append("AND ");
				query.append("(VcmsArticleType.typeId = ?) ");
			}

			query.append("AND ");
			query.append("(VcmsArticle.groupId = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.language = ?) ");

			query.append("AND ");
			query.append("(VcmsArticle.status = ?) ");

			if (isDate) {
				if (fromDate != null && toDate != null) {
					if (statusId == 0) {
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate < ?");
						query.append(" AND ");
						query.append(" VcmsArticle.createdDate > ?");
					} else {
						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.publishedDate > ?");

						} else {
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate < ?");
							query.append(" AND ");
							query.append(" VcmsArticle.modifiedDate > ?");
						}
					}
				}
			}

			if (Validator.isNotNull(keyword)) {
				if (Validator.isNotNull(select)
						&& Validator.equals(select, "0")) {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						query.append("AND ");
						query.append("( ");
						if (isTitle) {
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("OR ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");
						}
						query.append(") ");
					}

				} else {
					if (!isTitle && !isLead && !isContent) {
						query.append("AND ");
						query
								.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");
					} else {
						if (isTitle) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.title) LIKE LOWER(?)) ");

						}
						if (isLead) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.lead) LIKE LOWER(?)) ");

						}
						if (isContent) {
							query.append("AND ");
							query
									.append("(LOWER(VcmsArticle.content) LIKE LOWER(?)) ");

						}
					}
				}
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;
			q.setString(queryPos++, threadId);

			if (Validator.isNotNull(categoryId) && categoryId != "0") {
				q.setString(queryPos++, categoryId);
			}

			if (Validator.isNotNull(String.valueOf(typeId)) && typeId != 0) {
				q.setLong(queryPos++, typeId);
			}

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setLong(queryPos++, statusId);

			if (isDate) {
				if (fromDate != null && toDate != null) {
					q.setTimestamp(queryPos++, new Timestamp(toDate.getTime()));
					q.setTimestamp(queryPos++,
							new Timestamp(fromDate.getTime()));
				}
			}
			if (Validator.isNotNull(keyword)) {
				if (!isTitle && !isLead && !isContent) {
					q.setString(queryPos++, "%" + keyword + "%");
				} else {
					if (isTitle) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isLead) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
					if (isContent) {
						q.setString(queryPos++, "%" + keyword + "%");
					}
				}
			}
			Long count = null;
			Iterator<Long> ite = q.list().iterator();
			while (ite.hasNext()) {
				count = ite.next();

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

	protected void initDao() {
	}
}
