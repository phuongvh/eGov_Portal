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

package com.vportal.portlet.vsitemap.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vsitemap.model.VsmBranch;
import com.vportal.portlet.vsitemap.model.impl.VsmBranchImpl;
public class SiteMapUtil {
	private static final String _DEFAULT_FILE_EXTENSION = "page";

	private static SiteMapUtil _instance = new SiteMapUtil();

	private Set _fileExtensions;
	
	private SiteMapUtil() {
		_fileExtensions = new HashSet<String>();

		String[] fileExtensions =
			PropsUtil.getArray(PropsKeys.DL_FILE_EXTENSIONS);

		for (int i = 0; i < fileExtensions.length; i++) {

			// Only process non wildcard extensions

			if (!StringPool.STAR.equals(fileExtensions[i])) {

				// Strip starting period

				String extension = fileExtensions[i];
				extension = extension.substring(1, extension.length());

				_fileExtensions.add(extension);
			}
		}
	}
	
	public static String getFileExtension(String name) {
		return _instance._getFileExtension(name);
	}
	
	private String _getFileExtension(String name) {
		String extension = StringPool.BLANK;

		int pos = name.lastIndexOf(StringPool.PERIOD);

		if (pos != -1) {
			extension = name.substring(pos + 1, name.length()).toLowerCase();
		}

		if (!_fileExtensions.contains(extension)) {
			extension = _DEFAULT_FILE_EXTENSION;
		}

		return extension;
	}
	
	/**
	 * Ham nhan vao mot list cac group, sau do sap xep chung theo thu tu
	 * cha-con.
	 * 
	 * @param listGroup
	 *            List cac group can truyen vao
	 * @return Tra ve mot List cac group da duoc sap xep, bo sung them group co
	 *         ten la ROOT
	 */
	public static List sort(List listGroup) {
		// add the root of category to the list
		VsmBranch branch = new VsmBranchImpl();
		branch.setBranchId(0);
		branch.setParentId(0);
		listGroup.add(0, branch);

		List sortedList = new ArrayList();
		int maxGroupId = 0;
		// sort the list
		for (int i = 0; i < listGroup.size(); i++) {
			VsmBranch node = (VsmBranch) listGroup.get(i);
			int groupItemId =(int) node.getBranchId();
			if (groupItemId > maxGroupId) {
				maxGroupId = groupItemId;
			}
		}
		String[] mark = new String[maxGroupId + 1];
		DFS(sortedList, mark, listGroup, 0);
		sortedList.remove(0);
		
		return sortedList;
	}

	/**
	 * Ham tim nut con cua mot nut
	 * 
	 * @param tree
	 *            Cay k-phan
	 * @param parentId
	 *            ID cua nut cha
	 * @return danh sach cac nut con cua nut cha
	 */
	private static List findChildNodes(List tree, long parentId) {
		List childNodes = new ArrayList();

		for (int i = 1; i < tree.size(); i++) {
			VsmBranch parent = (VsmBranch) tree.get(i);
			if (parent.getParentId() == parentId) {
				childNodes.add(tree.get(i));
			}
		}

		return childNodes;
	}

	/**
	 * Ham tim kiem theo chieu sau
	 * 
	 * @param result
	 *            ket qua tra ve cua ham
	 * @param mark
	 *            dung de danh dau, truyen vao 1 mang String binh thuong
	 * @param tree
	 *            cay K-phan
	 * @param u
	 *            chi so cua nut cha
	 */
	private static void DFS(List result, String[] mark, List tree, int u) {
		VsmBranch currentNode = findByGroupId(tree, u);
		List childNodes = findChildNodes(tree, currentNode.getBranchId());
		mark[u] = "grey";
		result.add(currentNode);

		for (int i = 0; i < childNodes.size(); i++) {
			VsmBranch node = (VsmBranch) childNodes.get(i);
			String currentColor = mark[(int)node.getBranchId()];
			if (currentColor == null) {
				DFS(result, mark, tree, (int)node.getBranchId());
			}
		}
		mark[u] = "black";
	}

	/**
	 * ham tim kiem group trong 1 tree dua theo group_id
	 * 
	 * @param tree
	 *            cay K-phan
	 * @param groupId
	 *            group_id cua group can tim
	 * @return tra ve group neu tim thay va tra ve null neu khong tim thay
	 */
	private static VsmBranch findByGroupId(List tree, int groupId) {
		for (int i = 0; i < tree.size(); i++) {
			VsmBranch node = (VsmBranch) tree.get(i);
			if ((int)node.getBranchId() == groupId) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Dinh dang hien thi giua parent-child. Cac group la child se thut vao so
	 * voi group la cha 1 don vi bang " - "
	 * 
	 * @param tree
	 *            danh sach group cha va con, da sap xep thu tu
	 * @return tra ve 1 danh sach da duoc dinh dang
	 */
	public static List formatByLevel(List tree) {
		int[] level = new int[tree.size()];
		List result = new ArrayList();
		for (int i = 0; i < tree.size() - 1; i++) {
			VsmBranch currentCategory = (VsmBranch) tree.get(i);
			for (int j = 0; j < tree.size(); j++) {
				VsmBranch testedCategory = (VsmBranch) tree.get(j);
				if (testedCategory.getParentId() == currentCategory.getBranchId()) {
					level[j] = level[i] + 1;
				}
			}
		}
		String minus = "--- ";
		for (int i = 0; i < tree.size(); i++) {
			String back = "";
			for (int j = 0; j < level[i]; j++) {
				back += minus;
			}
			VsmBranch dept = (VsmBranch) tree.get(i);
			String name = dept.getName();
			name = back + name;
			dept.setName(name);
			result.add(dept);
		}
		return result;
	}

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


}
