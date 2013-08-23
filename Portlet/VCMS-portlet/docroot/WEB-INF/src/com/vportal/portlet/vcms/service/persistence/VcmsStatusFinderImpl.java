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

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.vcms.model.impl.VcmsStatusImpl;

public class VcmsStatusFinderImpl extends BasePersistenceImpl implements
		VcmsStatusFinder {
	public static String UP_POSITION = VcmsStatusFinder.class.getName()
			+ ".upPosition";
	public static String DOWN_POSITION = VcmsStatusFinder.class.getName()
			+ ".downPosition";
	public static String UPDATE_PRIMARY = VcmsStatusFinder.class.getName()
			+ ".updatePrimary";
	public static String UPDATE_ACTIVE = VcmsStatusFinder.class.getName()
			+ ".updateActive";

	public static String SELECT_VCMSSTATUS = VcmsStatusFinder.class.getName()
			+ ".selectVcmsStatus";

	public void updatePostion(long statusId, long companyId, long groupId,
			long position, boolean flag) throws SystemException {
		Session session = null;
		try {
			session = openSession();			
			String sql = flag ? CustomSQLUtil.get(UP_POSITION) : CustomSQLUtil
					.get(DOWN_POSITION);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsStatus", VcmsStatusImpl.class);
			int queryPos = 0;
						if(flag){
				q.setLong(queryPos++,1);				
			}
			else{
				q.setLong(queryPos++,-1);
			}
			
			q.setLong(queryPos++, position);
			q.setLong(queryPos++, companyId);
			q.setLong(queryPos++, groupId);
			q.setLong(queryPos++, statusId);
			q.executeUpdate();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
//			session.close();
		}
	}

	public void updatePrimary(long statusId, long companyId, long groupId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(UPDATE_PRIMARY);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsStatus", VcmsStatusImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, companyId);
			q.setLong(queryPos++, groupId);
			q.setLong(queryPos++, statusId);
			q.executeUpdate();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public void updateActive(long statusId, long companyId, long groupId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(UPDATE_ACTIVE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsStatus", VcmsStatusImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, companyId);
			q.setLong(queryPos++, groupId);
			q.setLong(queryPos++, statusId);
			q.executeUpdate();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List selectStatusId(long position) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(SELECT_VCMSSTATUS);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsStatus", VcmsStatusImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, position);

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	protected void initDao() {
	}
}
