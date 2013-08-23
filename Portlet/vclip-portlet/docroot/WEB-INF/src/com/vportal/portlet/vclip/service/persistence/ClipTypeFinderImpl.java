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
package com.vportal.portlet.vclip.service.persistence;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.vportal.portlet.vclip.model.ClipType;
import com.vportal.portlet.vclip.model.impl.ClipImpl;
import com.vportal.portlet.vclip.model.impl.ClipTypeImpl;

public class ClipTypeFinderImpl extends BasePersistenceImpl implements ClipTypeFinder{
	public List findClipType(ClipType clipType) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM ClipType ");
			String str="";
			// clip has id
			if ((clipType.getId() != null) && (!clipType.getId().trim().equals(""))) {
				str = str+"(AND id = ?) ";
			}
	
			//language
			if ((clipType.getLanguage() != null)
					&& (!clipType.getLanguage().trim().equals(""))) {
				str = str+"AND (language LIKE ?) ";
			}
			// Name		
			if ((clipType.getName() != null) && (!clipType.getName().trim().equals(""))) {
				str = str+"AND (name LIKE ?) ";
			}
	
			// createdDate
			if ((clipType.getCreatedDate() != null)
					&& (!clipType.getCreatedDate().toString().equals(""))) {
				str = str+"AND (createdDate = ?) ";
			}
	
			// modifiedDate
			if ((clipType.getModifiedDate() != null)
					&& (!clipType.getModifiedDate().toString().equals(""))) {
				str = str+"AND (modifiedDate = ?) ";
			}
	
			// description
			if ((clipType.getDescription() != null)
					&& (!clipType.getDescription().equals(""))) {
				str = str+"AND (description LIKE ?) ";
			}
			if(!str.equals("")){
				query.append("WHERE ");
				query.append(str);
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("ClipType",ClipTypeImpl.class);
			// clipType has id
			int queryPos = 0;
			if ((clipType.getId() != null) && (!clipType.getId().trim().equals(""))) {
				q.setString(queryPos++, clipType.getId());
			}
			//language
			if ((clipType.getLanguage() != null)
					&& (!clipType.getLanguage().trim().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getLanguage()+"%");
			}
			// Name		
			if ((clipType.getName() != null) && (!clipType.getName().trim().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getName()+"%");
			}
	
			// createdDate
			if ((clipType.getCreatedDate() != null)
					&& (!clipType.getCreatedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clipType.getCreatedDate().getTime()));
			}
	
			// modifiedDate
			if ((clipType.getModifiedDate() != null)
					&& (!clipType.getModifiedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clipType.getModifiedDate().getTime()));
			}
	
			// description
			if ((clipType.getDescription() != null)
					&& (!clipType.getDescription().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getDescription()+"%");
			}
			return q.list();
		}catch (Exception e) {
			// TODO: handle exception
			return new ArrayList();
		}finally{
			closeSession(session);
		}
	}
	public List findClipType(ClipType clipType,int start,int end) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM ClipType ");
			String str="";
			// clip has id
			if ((clipType.getId() != null) && (!clipType.getId().trim().equals(""))) {
				str = str+"(AND id = ?) ";
			}
	
			//language
			if ((clipType.getLanguage() != null)
					&& (!clipType.getLanguage().trim().equals(""))) {
				str = str+"AND (language LIKE ?) ";
			}
			// Name		
			if ((clipType.getName() != null) && (!clipType.getName().trim().equals(""))) {
				str = str+"AND (name LIKE ?) ";
			}
	
			// createdDate
			if ((clipType.getCreatedDate() != null)
					&& (!clipType.getCreatedDate().toString().equals(""))) {
				str = str+"AND (createdDate = ?) ";
			}
	
			// modifiedDate
			if ((clipType.getModifiedDate() != null)
					&& (!clipType.getModifiedDate().toString().equals(""))) {
				str = str+"AND (modifiedDate = ?) ";
			}
	
			// description
			if ((clipType.getDescription() != null)
					&& (!clipType.getDescription().equals(""))) {
				str = str+"AND (description LIKE ?) ";
			}
			if(!str.equals("")){
				query.append("WHERE ");
				query.append(str);
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("ClipType",ClipTypeImpl.class);
			// clipType has id
			int queryPos = 0;
			if ((clipType.getId() != null) && (!clipType.getId().trim().equals(""))) {
				q.setString(queryPos++, clipType.getId());
			}
			//language
			if ((clipType.getLanguage() != null)
					&& (!clipType.getLanguage().trim().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getLanguage()+"%");
			}
			// Name		
			if ((clipType.getName() != null) && (!clipType.getName().trim().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getName()+"%");
			}
	
			// createdDate
			if ((clipType.getCreatedDate() != null)
					&& (!clipType.getCreatedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clipType.getCreatedDate().getTime()));
			}
	
			// modifiedDate
			if ((clipType.getModifiedDate() != null)
					&& (!clipType.getModifiedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clipType.getModifiedDate().getTime()));
			}
	
			// description
			if ((clipType.getDescription() != null)
					&& (!clipType.getDescription().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getDescription()+"%");
			}
			return QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e) {
			// TODO: handle exception
			return new ArrayList();
		}finally{
			closeSession(session);
		}
	}
	public int countClipType(ClipType clipType) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT COUNT(*) as total FROM ClipType ");
			String str="";
			// clip has id
			if ((clipType.getId() != null) && (!clipType.getId().trim().equals(""))) {
				str = str+"(AND id = ?) ";
			}
	
			//language
			if ((clipType.getLanguage() != null)
					&& (!clipType.getLanguage().trim().equals(""))) {
				str = str+"AND (language LIKE ?) ";
			}
			// Name		
			if ((clipType.getName() != null) && (!clipType.getName().trim().equals(""))) {
				str = str+"AND (name LIKE ?) ";
			}
	
			// createdDate
			if ((clipType.getCreatedDate() != null)
					&& (!clipType.getCreatedDate().toString().equals(""))) {
				str = str+"AND (createdDate = ?) ";
			}
	
			// modifiedDate
			if ((clipType.getModifiedDate() != null)
					&& (!clipType.getModifiedDate().toString().equals(""))) {
				str = str+"AND (modifiedDate = ?) ";
			}
	
			// description
			if ((clipType.getDescription() != null)
					&& (!clipType.getDescription().equals(""))) {
				str = str+"AND (description LIKE ?) ";
			}
			if(!str.equals("")){
				query.append("WHERE ");
				query.append(str);
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);
			// clipType has id
			int queryPos = 0;
			if ((clipType.getId() != null) && (!clipType.getId().trim().equals(""))) {
				q.setString(queryPos++, clipType.getId());
			}
			//language
			if ((clipType.getLanguage() != null)
					&& (!clipType.getLanguage().trim().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getLanguage()+"%");
			}
			// Name		
			if ((clipType.getName() != null) && (!clipType.getName().trim().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getName()+"%");
			}
	
			// createdDate
			if ((clipType.getCreatedDate() != null)
					&& (!clipType.getCreatedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clipType.getCreatedDate().getTime()));
			}
	
			// modifiedDate
			if ((clipType.getModifiedDate() != null)
					&& (!clipType.getModifiedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clipType.getModifiedDate().getTime()));
			}
	
			// description
			if ((clipType.getDescription() != null)
					&& (!clipType.getDescription().equals(""))) {
				q.setString(queryPos++, "%"+clipType.getDescription()+"%");
			}
			Long count=null;
            Iterator<Long> ite= q.list().iterator();
            while (ite.hasNext()) {
				count = ite.next();
				
			}
            if (count == null) {
				count = new Long(0);
			}
			return count.intValue();
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}finally{
			closeSession(session);
		}
	}
}
