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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.vportal.portlet.vcms.model.impl.VcmsDiscussionImpl;

public class VcmsDiscussionFinderImpl extends BasePersistenceImpl implements  VcmsDiscussionFinder{
	public List searchDiscussionByA_P_L_K(String articleId 
			, long groupId , String language
			,String keyword, boolean approved 
			,boolean isTitle , boolean isContent
			, String select)throws SystemException{
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsDiscussion ");
			
			query.append(" WHERE ");
			
			if(Validator.isNotNull(articleId)){
				query.append(" VcmsDiscussion.articleId = ?");
				query.append(" AND ");
			}
			 
			query.append(" VcmsDiscussion.groupId = ?");
			query.append(" AND ");
			
			query.append(" VcmsDiscussion.language = ?");
			query.append(" AND ");
			
			query.append(" VcmsDiscussion.approved = ?");
			query.append(" AND ");
			
			if(!isTitle && !isContent){
				query.append(" LOWER(VcmsDiscussion.title) LIKE LOWER(?)");
			}else{
				if(isTitle && !isContent){
					query.append(" LOWER(VcmsDiscussion.title) LIKE LOWER(?)");
				}
				if(!isTitle && isContent){
					query.append(" LOWER(VcmsDiscussion.content) LIKE LOWER(?)");
				}
				if(isTitle && isContent){
					if(Validator.equals(select,"0")){
						query.append(" ( ");
						query.append(" LOWER(VcmsDiscussion.title) LIKE LOWER(?)");
						query.append(" OR ");
						query.append(" LOWER(VcmsDiscussion.content) LIKE LOWER(?)");
						query.append(" ) ");
					}else if(Validator.equals(select, "1")){
						query.append(" LOWER(VcmsDiscussion.title) LIKE LOWER(?)");
						query.append(" AND ");
						query.append(" LOWER(VcmsDiscussion.content) LIKE LOWER(?)");
					}
				}
			}
			
			if(approved == true){
				query.append(" ORDER BY ");
				query.append(" VcmsDiscussion.approvedDate DESC ");
			}else{
				query.append(" ORDER BY ");
				query.append(" VcmsDiscussion.postedDate DESC ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsDiscussion", VcmsDiscussionImpl.class);
			int queryPos = 0;
			if(Validator.isNotNull(articleId)){
				q.setString(queryPos++, articleId);
			}
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setBoolean(queryPos++, approved);
			if(isTitle && isContent){
				q.setString(queryPos++, "%" + keyword + "%");
				q.setString(queryPos++, "%" + keyword + "%");
			}else{
				q.setString(queryPos++, "%" + keyword + "%");
			}
			
			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
	    	closeSession(session);
		}
	}
}
