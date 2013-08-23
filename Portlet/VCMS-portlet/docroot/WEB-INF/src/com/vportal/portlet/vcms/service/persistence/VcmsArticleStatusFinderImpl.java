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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VcmsArticleStatusFinderImpl extends BasePersistenceImpl implements VcmsArticleStatusFinder {
	
	/*public static String COUNT_BY_C_L_S = VcmsArticleStatusFinder.class.getName()
	+ ".countByC_L_S";
	
	public int countByC_L_S(String categoryId, long groupId, String language,
			int status) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_C_L_S);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
			int queryPos = 0;

			q.setString(queryPos++, categoryId);
			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);
			q.setInteger(queryPos++, status);

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
	}*/
}
