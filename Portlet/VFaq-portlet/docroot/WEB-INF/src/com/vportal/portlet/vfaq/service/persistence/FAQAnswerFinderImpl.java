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

package com.vportal.portlet.vfaq.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.vfaq.model.impl.FAQAnswerImpl;
import com.vportal.portlet.vfaq.model.impl.FAQQuestionImpl;

public class FAQAnswerFinderImpl extends BasePersistenceImpl implements
		FAQAnswerFinder {

	public static String FIND_BY_G_ = FAQAnswerFinder.class.getName()
			+ ".findByGroupId";
	public static String COUNT_BY_G_ = FAQAnswerFinder.class.getName()
			+ ".countByGroupId";
	public static String FIND_BY_G_L = FAQAnswerFinder.class.getName()
			+ ".findByG_L";

	public static String FIND_BY_G_L_S = FAQAnswerFinder.class.getName()
			+ ".findByG_L_S";

	public static String COUNT_BY_G_L_S = FAQAnswerFinder.class.getName()
			+ ".countByG_L_S";

	public static String COUNT_BY_G_L_S_Q = FAQAnswerFinder.class.getName()
			+ ".countByG_L_S_Q";

	public static String FIND_BY_PARAM = FAQAnswerFinder.class.getName()
			+ ".findByParam";

	public static String COUNT_BY_PARAM = FAQAnswerFinder.class.getName()
			+ ".countByParam";

	public List findByGroupId(long groupId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FAQQuestion", FAQAnswerImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByGroupId(long groupId, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FAQQuestion", FAQAnswerImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByGroupId(long groupId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
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

	public List getByG_L_S(long groupId, String language, boolean approved,
			int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FAQAnswer", FAQAnswerImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setBoolean(queryPos++, approved);

			return QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}

	public int countByG_L_S(long groupId, String language, boolean approved)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setBoolean(queryPos++, approved);

			Iterator ite = q.list().iterator();
			Long count = null;
			while (ite.hasNext()) {
				count = (Long) ite.next();
			}
			if (count == null) {
				count = new Long(0);
			}
			return count.intValue();
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}

	public int countByG_L_S_Q(long groupId, String language, boolean approved,
			long questionId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G_L_S_Q);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setBoolean(queryPos++, approved);
			q.setLong(queryPos++, questionId);

			Iterator ite = q.list().iterator();
			Long count = null;
			while (ite.hasNext()) {
				count = (Long) ite.next();
			}
			if (count == null) {
				count = new Long(0);
			}
			return count.intValue();
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}

	// Find Anser by Param
	public List getByParam(long groupId, String language, boolean approved,
			String title, String sentByUser, long categoryId, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PARAM);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& categoryId != 0) {
				query.append(" INNER JOIN FAQCategoryQuestion ");
				query.append(" ON (FAQQuestion.Id_ = FAQCategoryQuestion.questionId)");
			}

			query.append(" WHERE ");

			query.append(" FAQQuestion.groupId = ? ");
			query.append(" AND ");
			query.append(" FAQAnswer.language = ? ");
			query.append(" AND ");
			query.append(" FAQAnswer.approved = ? ");

			if (Validator.isNotNull(title)) {
				query.append(" AND ");
				query.append(" FAQQuestion.title LIKE ? ");
			}
			
			//=======DucNN add search by sender's name 07.05.2013 Start ========
			if (Validator.isNotNull(sentByUser)) {
				query.append(" AND ");
				query.append(" FAQQuestion.sentByUser LIKE ? ");
			}
			//=======DucNN add search by sender's name 07.05.2013 End ========

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				query.append(" AND ");
				query.append(" FAQCategoryQuestion.categoryId = ? ");
			}

			query.append(" ORDER BY ");
			query.append(" FAQQuestion.sentDate DESC");

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("FAQAnswer", FAQAnswerImpl.class);

			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setBoolean(queryPos++, approved);
			if (Validator.isNotNull(title)) {
				q.setString(queryPos++, "%" + title + "%");
			}
			
			//=======DucNN add search by sender's name 07.05.2013 Start ========
			if (Validator.isNotNull(sentByUser)) {
				q.setString(queryPos++, "%" + sentByUser + "%");
			}
			//=======DucNN add search by sender's name 07.05.2013 End ========

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				q.setLong(queryPos++, categoryId);
			}

			return QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}

	public int countByParam(long groupId, String language, boolean approved,
			String title, String sentByUser, long categoryId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PARAM);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& categoryId != 0) {
				query.append(" INNER JOIN FAQCategoryQuestion ");
				query
						.append(" ON (FAQQuestion.Id_ = FAQCategoryQuestion.questionId)");
			}

			query.append(" WHERE ");

			query.append(" FAQQuestion.groupId = ? ");
			query.append(" AND ");
			query.append(" FAQAnswer.language = ? ");
			query.append(" AND ");
			query.append(" FAQAnswer.approved = ? ");
			if (Validator.isNotNull(title)) {
				query.append(" AND ");
				query.append(" FAQQuestion.title LIKE ? ");
			}
			
			//=======DucNN add search by sender's name 07.05.2013 Start ========
			if (Validator.isNotNull(sentByUser)) {
				query.append(" AND ");
				query.append(" FAQQuestion.sentByUser LIKE ? ");
			}
			//=======DucNN add search by sender's name 07.05.2013 End ========


			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				query.append(" AND ");
				query.append(" FAQCategoryQuestion.categoryId = ? ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);

			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setBoolean(queryPos++, approved);
			if (Validator.isNotNull(title)) {
				q.setString(queryPos++, "%" + title + "%");
			}
			
			//=======DucNN add search by sender's name 07.05.2013 Start ========
			if (Validator.isNotNull(sentByUser)) {
				q.setString(queryPos++, "%" + sentByUser + "%");
			}
			//=======DucNN add search by sender's name 07.05.2013 End ========

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				q.setLong(queryPos++, categoryId);
			}
			
			Iterator ite = q.list().iterator();

			Long count = null;
			while (ite.hasNext()) {
				count = (Long) ite.next();
			}
			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}

	// find other question CuongNV
	public List findByG_L(long groupId, String language) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G_L);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FAQQuestion", FAQAnswerImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			return q.list();
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}
	
	//get other answer by DucNN
	public List getAnswer(long groupId, String language, long categoryId, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PARAM);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& categoryId != 0) {
				query.append(" INNER JOIN FAQCategoryQuestion ");
				query.append(" ON (FAQQuestion.Id_ = FAQCategoryQuestion.questionId)");
			}

			query.append(" WHERE ");

			query.append(" FAQQuestion.groupId = ? ");
			query.append(" AND ");
			query.append(" FAQAnswer.language = ? ");		

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				query.append(" AND ");
				query.append(" FAQCategoryQuestion.categoryId = ? ");
			}

			query.append(" ORDER BY ");
			query.append(" FAQQuestion.sentDate DESC");

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("FAQAnswer", FAQAnswerImpl.class);

			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				q.setLong(queryPos++, categoryId);
			}

			return QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}
	
	public int countAnswer(long groupId, String language, long categoryId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PARAM);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& categoryId != 0) {
				query.append(" INNER JOIN FAQCategoryQuestion ");
				query
						.append(" ON (FAQQuestion.Id_ = FAQCategoryQuestion.questionId)");
			}

			query.append(" WHERE ");

			query.append(" FAQQuestion.groupId = ? ");
			query.append(" AND ");
			query.append(" FAQAnswer.language = ? ");

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				query.append(" AND ");
				query.append(" FAQCategoryQuestion.categoryId = ? ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);

			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(String.valueOf(categoryId))
					&& (categoryId != 0)) {
				q.setLong(queryPos++, categoryId);
			}
			
			Iterator ite = q.list().iterator();

			Long count = null;
			while (ite.hasNext()) {
				count = (Long) ite.next();
			}
			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}
	}
}
