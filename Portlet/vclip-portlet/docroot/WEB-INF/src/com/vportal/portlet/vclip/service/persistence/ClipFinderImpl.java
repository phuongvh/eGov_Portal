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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.vportal.portlet.vclip.model.Clip;
import com.vportal.portlet.vclip.model.impl.ClipImpl;

public class ClipFinderImpl extends BasePersistenceImpl implements ClipFinder{
	public List findClip(Clip clip) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM Clip ");
			String str="";
			// clip has id
			if ((clip.getId() != null) && (!clip.getId().trim().equals(""))) {
				str = str+ "AND (id = ?) ";
			}
	
			// ClipTypeID
			if ((clip.getClipTypeId() != null)
					&& (!clip.getClipTypeId().trim().equals(""))) {
				str = str+ "AND (clipTypeId LIKE ?) ";
			}
			//language
			if ((clip.getLanguage() != null)
					&& (!clip.getLanguage().trim().equals(""))) {
				str = str+ "AND (language LIKE ?) ";
			}
			// Name		
			if ((clip.getName() != null) && (!clip.getName().trim().equals(""))) {
				str = str+ "AND (name LIKE ?) ";
			}
	
			// createdDate
			if ((clip.getCreatedDate() != null)
					&& (!clip.getCreatedDate().toString().equals(""))) {
				str = str+ "AND (createdDate = ?) ";
			}
	
			// modifiedDate
			if ((clip.getModifiedDate() != null)
					&& (!clip.getModifiedDate().toString().equals(""))) {
				str = str+ "AND (modifiedDate = ?) ";
			}
	
			// description
			if ((clip.getDescription() != null)
					&& (!clip.getDescription().equals(""))) {
				str = str+ "AND (description LIKE ?) ";
			}
			if(!str.equals("")){
				query.append("WHERE ");
				query.append(str);
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("Clip",ClipImpl.class);
			// clip has id
			int queryPos = 0;
			if ((clip.getId() != null) && (!clip.getId().trim().equals(""))) {
				q.setString(queryPos++, clip.getId());
			}
	
			// ClipTypeID
			if ((clip.getClipTypeId() != null)
					&& (!clip.getClipTypeId().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getClipTypeId()+"%");
			}
			//language
			if ((clip.getLanguage() != null)
					&& (!clip.getLanguage().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getLanguage()+"%");
			}
			// Name		
			if ((clip.getName() != null) && (!clip.getName().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getName()+"%");
			}
	
			// createdDate
			if ((clip.getCreatedDate() != null)
					&& (!clip.getCreatedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clip.getCreatedDate().getTime()));
			}
	
			// modifiedDate
			if ((clip.getModifiedDate() != null)
					&& (!clip.getModifiedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clip.getModifiedDate().getTime()));
			}
	
			// description
			if ((clip.getDescription() != null)
					&& (!clip.getDescription().equals(""))) {
				q.setString(queryPos++, "%"+clip.getDescription()+"%");
			}
			return q.list();
		}catch (Exception e) {
			// TODO: handle exception
			return new ArrayList();
		}finally{
			closeSession(session);
		}
	}
	public int countClip(Clip clip) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT COUNT(*) FROM Clip ");
			String str="";
			// clip has id
			if ((clip.getId() != null) && (!clip.getId().trim().equals(""))) {
				str = str+ "AND (id = ?) ";
			}
	
			// ClipTypeID
			if ((clip.getClipTypeId() != null)
					&& (!clip.getClipTypeId().trim().equals(""))) {
				str = str+ "AND (clipTypeId LIKE ?) ";
			}
			//language
			if ((clip.getLanguage() != null)
					&& (!clip.getLanguage().trim().equals(""))) {
				str = str+ "AND (language LIKE ?) ";
			}
			// Name		
			if ((clip.getName() != null) && (!clip.getName().trim().equals(""))) {
				str = str+ "AND (name LIKE ?) ";
			}
	
			// createdDate
			if ((clip.getCreatedDate() != null)
					&& (!clip.getCreatedDate().toString().equals(""))) {
				str = str+ "AND (createdDate = ?) ";
			}
	
			// modifiedDate
			if ((clip.getModifiedDate() != null)
					&& (!clip.getModifiedDate().toString().equals(""))) {
				str = str+ "AND (modifiedDate = ?) ";
			}
	
			// description
			if ((clip.getDescription() != null)
					&& (!clip.getDescription().equals(""))) {
				str = str+ "AND (description LIKE ?) ";
			}
			if(!str.equals("")){
				query.append("WHERE ");
				query.append(str);
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);
			// clip has id
			int queryPos = 0;
			if ((clip.getId() != null) && (!clip.getId().trim().equals(""))) {
				q.setString(queryPos++, clip.getId());
			}
	
			// ClipTypeID
			if ((clip.getClipTypeId() != null)
					&& (!clip.getClipTypeId().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getClipTypeId()+"%");
			}
			//language
			if ((clip.getLanguage() != null)
					&& (!clip.getLanguage().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getLanguage()+"%");
			}
			// Name		
			if ((clip.getName() != null) && (!clip.getName().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getName()+"%");
			}
	
			// createdDate
			if ((clip.getCreatedDate() != null)
					&& (!clip.getCreatedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clip.getCreatedDate().getTime()));
			}
	
			// modifiedDate
			if ((clip.getModifiedDate() != null)
					&& (!clip.getModifiedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clip.getModifiedDate().getTime()));
			}
	
			// description
			if ((clip.getDescription() != null)
					&& (!clip.getDescription().equals(""))) {
				q.setString(queryPos++, "%"+clip.getDescription()+"%");
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
	public List findClip(Clip clip,int start,int end) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT (Clip.*) FROM Clip ");
			String str="";
			// clip has id
			if ((clip.getId() != null) && (!clip.getId().trim().equals(""))) {
				str = str+ "AND (id = ?) ";
			}
	
			// ClipTypeID
			if ((clip.getClipTypeId() != null)
					&& (!clip.getClipTypeId().trim().equals(""))) {
				str = str+ "AND (clipTypeId LIKE ?) ";
			}
			//language
			if ((clip.getLanguage() != null)
					&& (!clip.getLanguage().trim().equals(""))) {
				str = str+ "AND (language LIKE ?) ";
			}
			// Name		
			if ((clip.getName() != null) && (!clip.getName().trim().equals(""))) {
				str = str+ "AND (name LIKE ?) ";
			}
	
			// createdDate
			if ((clip.getCreatedDate() != null)
					&& (!clip.getCreatedDate().toString().equals(""))) {
				str = str+ "AND (createdDate = ?) ";
			}
	
			// modifiedDate
			if ((clip.getModifiedDate() != null)
					&& (!clip.getModifiedDate().toString().equals(""))) {
				str = str+ "AND (modifiedDate = ?) ";
			}
	
			// description
			if ((clip.getDescription() != null)
					&& (!clip.getDescription().equals(""))) {
				str = str+ "AND (description LIKE ?) ";
			}
			if(!str.equals("")){
				query.append("WHERE ");
				query.append(str);
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("Clip",ClipImpl.class);
			// clip has id
			int queryPos = 0;
			if ((clip.getId() != null) && (!clip.getId().trim().equals(""))) {
				q.setString(queryPos++, clip.getId());
			}
	
			// ClipTypeID
			if ((clip.getClipTypeId() != null)
					&& (!clip.getClipTypeId().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getClipTypeId()+"%");
			}
			//language
			if ((clip.getLanguage() != null)
					&& (!clip.getLanguage().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getLanguage()+"%");
			}
			// Name		
			if ((clip.getName() != null) && (!clip.getName().trim().equals(""))) {
				q.setString(queryPos++, "%"+clip.getName()+"%");
			}
	
			// createdDate
			if ((clip.getCreatedDate() != null)
					&& (!clip.getCreatedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clip.getCreatedDate().getTime()));
			}
	
			// modifiedDate
			if ((clip.getModifiedDate() != null)
					&& (!clip.getModifiedDate().toString().equals(""))) {
				q.setTimestamp(queryPos++, new Timestamp(clip.getModifiedDate().getTime()));
			}
	
			// description
			if ((clip.getDescription() != null)
					&& (!clip.getDescription().equals(""))) {
				q.setString(queryPos++, "%"+clip.getDescription()+"%");
			}
			return QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e) {
			// TODO: handle exception
			return new ArrayList();
		}finally{
			closeSession(session);
		}		
	}
	
	public List searchClip(String textSearch,String clipTypeId) throws Exception {
		Session session=null; 
		try{
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM Clip");
			String str="";
			// ClipTypeID
			if (Validator.isNotNull(clipTypeId)) {
				str = str+ "(clipTypeId LIKE ?) ";
			}
			// clip has id
			if (Validator.isNotNull(textSearch)) {
				if(Validator.isNull(clipTypeId)){
					str = str+ " (name LIKE ?)";
				}else{
					str = str+ " AND (name LIKE ?)";
				}				
			}			
			if(!str.equals("")){
				query.append(" WHERE ");
				query.append(str);
			}
			query.append(" ORDER BY ");
			query.append(" Clip.createdDate DESC");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("Clip",ClipImpl.class);
			
			int queryPos = 0;
			// ClipTypeID
			if (Validator.isNotNull(clipTypeId)){
				q.setString(queryPos++, "%"+clipTypeId+"%");
			}
			// name
			if (Validator.isNotNull(textSearch)) {
				q.setString(queryPos++,"%"+textSearch+"%");
			}
	
			
			return q.list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return new ArrayList();			
		}finally{
			closeSession(session);
		}
	}
}
