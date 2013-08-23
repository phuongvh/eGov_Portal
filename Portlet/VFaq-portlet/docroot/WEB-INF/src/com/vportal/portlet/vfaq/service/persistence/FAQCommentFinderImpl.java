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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.vfaq.model.impl.FAQCommentImpl;

public class FAQCommentFinderImpl extends BasePersistenceImpl implements FAQCommentFinder{
	public static String FIND_BY_G =
		FAQCommentFinder.class.getName() + ".findByGroupId";
	public static String COUNT_BY_G =
		FAQCommentFinder.class.getName() + ".countByGroupId";
	public List findByGroupId(long groupId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FAQQuestion", FAQCommentImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
	    	closeSession(session);
		}
	}
	public List findByGroupId(long groupId,int start,int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("FAQQuestion", FAQCommentImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
	    	closeSession(session);
		}
	}
	public int countByGroupId(long groupId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			Iterator ite = q.list().iterator();
			Long count =null;
			while(ite.hasNext()){
				count =(Long)ite.next();
			}
			if(count==null){
				count = new Long(0);
			}
			return count.intValue();
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
	    	closeSession(session);
		}
	}
	
	//DucNN add get comment by groupid , titleQuestion
	public List findByPara(long groupId, String title, int start,int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_G);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			
			if (Validator.isNotNull(title)) {
				query.append(" AND ");
				query.append(" FAQQuestion.title LIKE ? ");
			}
			query.append(" ORDER BY ");
			query.append(" FAQComment.commDate DESC");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("FAQQuestion", FAQCommentImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			if (Validator.isNotNull(title)) {
				q.setString(queryPos++, "%" + title + "%");
			}
			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
	    	closeSession(session);
		}
	}
	
	public int countByPara(long groupId,String title) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_G);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			
			if (Validator.isNotNull(title)) {
				query.append(" AND ");
				query.append(" FAQQuestion.title LIKE ? ");
			}		
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);
			int queryPos = 0;
			q.setLong(queryPos++, groupId);
			if (Validator.isNotNull(title)) {
				q.setString(queryPos++, "%" + title + "%");
			}
			Iterator ite = q.list().iterator();
			Long count =null;
			while(ite.hasNext()){
				count =(Long)ite.next();
			}
			if(count==null){
				count = new Long(0);
			}
			return count.intValue();
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
	    	closeSession(session);
		}
	}
}
