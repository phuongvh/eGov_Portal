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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.vcms.NoSuchVcmsLoggerException;
import com.vportal.portlet.vcms.model.VcmsLogger;
import com.vportal.portlet.vcms.model.impl.VcmsLoggerImpl;

public class VcmsLoggerFinderImpl extends BasePersistenceImpl implements
		VcmsLoggerFinder {
	private static Log _log = LogFactoryUtil.getLog(VcmsLoggerFinder.class);
	public static String FIND_BY_U = VcmsLoggerFinder.class.getName()
			+ ".findByUser";
	public static String FIND_BY_P = VcmsLoggerFinder.class.getName()
			+ ".findByPeriod";

	public List findByUser(String createdByUser) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_U);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsLogger", VcmsLoggerImpl.class);
			int queryPos = 0;

			if (createdByUser != null) {
				q.setString(queryPos++, createdByUser);
			}

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByPeriod(Date from, Date to) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_P);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("VcmsLogger", VcmsLoggerImpl.class);

			int queryPos = 0;
			q.setTimestamp(queryPos++, new Timestamp(from.getTime()));
			q.setTimestamp(queryPos++, new Timestamp(to.getTime()));

			return q.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByD_A_K(String keyword, int select, Date datePresent)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsLogger WHERE ");
			query.append(" LOWER(VcmsLogger.content) LIKE LOWER(?) ");
			query.append(" AND ");

			switch (select) {
			case 0:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms portion%' ");
				query.append(" AND ");
				break;
			case 1:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms category%'");
				query.append(" AND ");
				break;
			case 2:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms article%'");
				query.append(" AND ");
				break;
			case 3:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms discussion%'");
				query.append(" AND ");
				break;
			case 4:
				query.append(" LOWER(VcmsLogger.content) LIKE '%vcms thread%'");
				query.append(" AND ");
				break;
			}
			query.append(" VcmsLogger.createdDate >= ? ");
			query.append(" ");
			query.append("ORDER BY ");
			query.append("VcmsLogger.createdDate DESC");

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsLogger", VcmsLoggerImpl.class);

			int queryPos = 0;

			/*
			 * if (createdByUser != null) { q.setString(queryPos++,
			 * createdByUser); }
			 */
			q.setString(queryPos++, "%" + keyword + "%");
			q.setTimestamp(queryPos++, new Timestamp(datePresent.getTime()));

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List findByD_A_K(String keyword, int select, Date datePresent,
			int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM VcmsLogger WHERE ");
			query.append(" LOWER(VcmsLogger.content) LIKE LOWER(?) ");
			query.append(" AND ");

			switch (select) {
			case 0:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms portion%' ");
				query.append(" AND ");
				break;
			case 1:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms category%'");
				query.append(" AND ");
				break;
			case 2:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms article%'");
				query.append(" AND ");
				break;
			case 3:
				query
						.append(" LOWER(VcmsLogger.content) LIKE '%vcms discussion%'");
				query.append(" AND ");
				break;
			case 4:
				query.append(" LOWER(VcmsLogger.content) LIKE '%vcms thread%'");
				query.append(" AND ");
				break;
			}
			query.append(" VcmsLogger.createdDate >= ? ");
			query.append(" ");
			query.append("ORDER BY ");
			query.append("VcmsLogger.createdDate DESC");

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("VcmsLogger", VcmsLoggerImpl.class);

			int queryPos = 0;

			/*
			 * if (createdByUser != null) { q.setString(queryPos++,
			 * createdByUser); }
			 */
			q.setString(queryPos++, "%" + keyword + "%");
			q.setTimestamp(queryPos++, new Timestamp(datePresent.getTime()));

			return QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByD_A_K(String keyword, int select, Date datePresent)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuffer query = new StringBuffer();
			query.append("SELECT COUNT(*) FROM VcmsLogger ");
			query.append("WHERE ");
			query.append("(LOWER(content) LIKE LOWER(?)) ");
			query.append("AND ");
			switch (select) {
			case 0:
				query.append("(LOWER(content) LIKE '%vcms portion%') ");
				query.append("AND ");
				break;
			case 1:
				query.append("(LOWER(content) LIKE '%vcms category%') ");
				query.append("AND ");
				break;
			case 2:
				query.append("(LOWER(content) LIKE '%vcms article%') ");
				query.append("AND ");
				break;
			case 3:
				query.append("(LOWER(content) LIKE '%vcms discussion%') ");
				query.append("AND ");
				break;
			case 4:
				query.append("(LOWER(content) LIKE '%vcms thread%') ");
				query.append("AND ");
				break;
			}
			query.append("(createdDate >= ?)");
			SQLQuery q = session.createSQLQuery(query.toString());
			int queryPos = 0;
			q.setString(queryPos++, "%" + keyword + "%");
			q.setTimestamp(queryPos++, new Timestamp(datePresent.getTime()));
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

	public void removeByPeriod(Date from, Date to) throws SystemException {
		Iterator itr = findByPeriod(from, to).iterator();

		while (itr.hasNext()) {
			VcmsLogger vcmsLogger = (VcmsLogger) itr.next();
			//VcmsLoggerUtil.remove(vcmsLogger);
			try {
				VcmsLoggerUtil.remove(vcmsLogger.getLoggerId());
			} catch (NoSuchVcmsLoggerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
