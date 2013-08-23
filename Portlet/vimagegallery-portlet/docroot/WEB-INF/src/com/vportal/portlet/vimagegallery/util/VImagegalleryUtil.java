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

package com.vportal.portlet.vimagegallery.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
//import com.vportal.portlet.vfaq.model.FAQCategory;

public class VImagegalleryUtil {

		/**
	 * Ham tim nut con cua mot nut
	 * 
	 * @param tree
	 *            Cay k-phan
	 * @param parentId
	 *            ID cua nut cha
	 * @return danh sach cac nut con cua nut cha
	 */
/*	private static List findChildNodes(List tree, int parentId) {
		List childNodes = new ArrayList();

		for (int i = 1; i < tree.size(); i++) {
			FAQCategory parent = (FAQCategory) tree.get(i);
			if (parent.getParent() == parentId) {
				childNodes.add(tree.get(i));
			}
		}

		return childNodes;
	}*/



	/**
	 * Generate the random prefix.<br />
	 * Copied from: com.vportal.portlet.newsadmin.utils.NewsUtils
	 * 
	 * @return The random prefix
	 */

	public static String getRandPrefix() {
		Calendar c = Calendar.getInstance();
		String curTime = String.valueOf(c.getTimeInMillis());
		if (Validator.isNotNull(curTime) && curTime.length() > 23) {
			curTime = curTime.substring(10, 23);
		}
		return curTime;
	}

	/**
	 * Ham phan tich ngay thang<br />
	 * Copied from com.vportal.portlet.edirectory.util.EDirectoryUtil
	 * 
	 * @param date
	 *            Ngay thang can phan tich
	 * @return Dang dd/MM/yyyy cua ngay thang nhap vao
	 */
	public static String dateParser(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		dateStr = day + "/" + month + "/" + year;
		return dateStr;
	}

	/**
	 * Ham chuyen 1 xau sang ngay thang<br />
	 * Copied from com.vportal.portlet.edirectory.util.EDirectoryUtil
	 * 
	 * @param date
	 *            Xau chua ngay thang, co dang: dd/MM/yyyy
	 * @return Doi tuong ngay thang
	 */
	public static Date dateParser(String date) {
		try {
			SimpleDateFormat result = new SimpleDateFormat("dd/MM/yyyy");
			Date newDate = result.parse(date);
			return newDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	public static String trimString(String str, int length) {
		try {
			StringBuffer buff = new StringBuffer();
			int index = str.indexOf(" ", length);
			buff.append(str.substring(0, index));
			buff.append("...");
			return buff.toString();
		} catch (StringIndexOutOfBoundsException e) {
			return str;
		}
	}

}
