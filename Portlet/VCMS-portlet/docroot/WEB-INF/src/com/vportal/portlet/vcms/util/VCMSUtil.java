
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
 *
/**
 * 
 */
package com.vportal.portlet.vcms.util;

import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.vportal.portlet.vcms.util.comparator.VCMSArticleCreatedDateComparator;
import com.vportal.portlet.vcms.util.comparator.VCMSArticleModifiedDateComparator;
import com.vportal.portlet.vcms.util.comparator.VCMSArticlePublishedDateComparator;

/**
 * @author Nguyen Duy Nhat (nhatnd)
 * @since Jun 9, 2008
 */
public class VCMSUtil {

	/**
	 * 
	 * @param orderByCol
	 *            createdDate, modifiedDate or publishedDate
	 * @param orderByType
	 *            ASC or DESC
	 * @return
	 */
	public static OrderByComparator getArticleOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("createdDate")) {
			orderByComparator = new VCMSArticleCreatedDateComparator(orderByAsc);
		} else if (orderByCol.equals("modifiedDate")) {
			orderByComparator = new VCMSArticleModifiedDateComparator(
					orderByAsc);
		} else if (orderByCol.equals("publishedDate")) {
			orderByComparator = new VCMSArticlePublishedDateComparator(
					orderByAsc);
		}

		return orderByComparator;
	}
	
	public static String getPrefsPropsUtil(long  companyId, String key) throws Exception{
		MethodKey method = new MethodKey("com.liferay.portal.util.PrefsPropsUtil", "getString",long.class,String.class);
		Object[] args = new Object[]{companyId,key};
		Object returnObj = PortalClassInvoker.invoke(false, method, args) ;
		if (returnObj != null) {
			return (String) returnObj;
		}
		else {
			return null;
		}
	}
	
	public static boolean getBooleanPrefsPropsUtil(long  companyId, String key) throws Exception{
		MethodKey method = new MethodKey("com.liferay.portal.util.PrefsPropsUtil", "getString",long.class,String.class);
		Object[] args = new Object[]{companyId,key};
		Object returnObj = PortalClassInvoker.invoke(false, method, args) ;
		if (returnObj != null) {
			return Boolean.valueOf((String) returnObj) ;
		}
		else {
			return false;
		}
	}
	
	public static int getIntegerPrefsPropsUtil(long  companyId, String key) throws Exception{
		MethodKey method = new MethodKey("com.liferay.portal.util.PrefsPropsUtil", "getString",long.class,String.class);
		Object[] args = new Object[]{companyId,key};

			Object returnObj = PortalClassInvoker.invoke(false, method, args) ;
			if (returnObj != null) {
				return Integer.valueOf((String) returnObj) ;
			}
			else {
				return 0;
			}
	}
}
