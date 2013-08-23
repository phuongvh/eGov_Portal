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
package com.vportal.portlet.vcms.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTypeServiceUtil;
import com.vportal.portlet.vcms.util.ReportUtil;

public class ReportAction {
	
	public void setReportByType(int y, int x, HSSFSheet sheet,
			HSSFWorkbook wb, long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser)
			throws Exception {
		
		HSSFRow row;		
		
		List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
		sheet.shiftRows(y, sheet.getLastRowNum(), 1);

		//date
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(fromDate)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(toDate), wb);
		
		row = sheet.createRow(y);

		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "Lo\u1ea1i tin", wb);
		ReportUtil.createCellBold(row, (short) (x + 2), "T\u00e1c ph\u1ea9m", wb);		
		
		int totalArticle = 0;
		int stt = 0;		
		for (int j = 0; j < listType.size(); j++) {			
			VcmsType vcmsType = (VcmsType) listType.get(j);
			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);
			
			int total = VcmsArticleServiceUtil.countByType(groupId, language,
					statusId, Long.valueOf(vcmsType.getTypeId()), fromDate, toDate, byUser);
			totalArticle += total;
			
			if (vcmsType.getTypeId() != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
				ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
						+ vcmsType.getName() + "", wb);
				ReportUtil.createCell(row, (short) (x + 2), total, wb);
			}

		}
		//total count
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(totalArticle), wb);
		
		FileOutputStream fileOut = null;		
		try {			
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir()
					+ "/VCMS-portlet/html/portlet/vcms/report/file/reportByType.xls");
			wb.write(fileOut);			
		
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}		
	}
	public void setCategoryReport(List portionResults, int y, int x,
			HSSFSheet sheet, HSSFWorkbook wb, long groupId, String language,
			String parentId, Date dateFrom, Date dateTo, String byUser)
			throws Exception {
		int totalStatus = VcmsStatusLocalServiceUtil.countByGroupId(groupId);
		List statusResults = VcmsStatusLocalServiceUtil.getByGroupId(groupId,
				0, totalStatus);

		HSSFRow row;
		HSSFCell cell;
		User userBean;

		sheet.shiftRows(y, sheet.getLastRowNum(), 1);
		
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);
		
		row = sheet.createRow(y);
		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "Chuy\u00ean m\u1ee5c", wb);
		
		for (int j = 0; j < totalStatus; j++) {
			VcmsStatus vcmsStatus = (VcmsStatus) statusResults.get(j);
			ReportUtil.createCellBold(row, (short) (x + 2 + j), "" + vcmsStatus.getName() + "", wb);
		}

		int stt = 0;
		int totalArticle=0;
		for (int i = portionResults.size() - 1; i >= 0; --i) {
			VcmsPortion vcmsPortion = (VcmsPortion) portionResults.get(i);
			List categoryByPortion = ActionUtil.getListCategoryReport(groupId,
					vcmsPortion.getPortionId(), parentId, language);

			for (int j = 0; j < categoryByPortion.size(); j++) {
				VcmsCategory vcmsCategory = (VcmsCategory) categoryByPortion
						.get(j);
				sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
				row = sheet.createRow(1 + y++);

				if (vcmsCategory.getName() != null) {
					ReportUtil.createCell(row, (short) (x), ++stt, wb);
				}
				if (vcmsCategory.getName() != null) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
							+ vcmsCategory.getName() + "", wb);
				}
				for (int k = 0; k < totalStatus; k++) {
					int countArticles = 0;
					VcmsStatus status = (VcmsStatus) statusResults.get(k);
					
					countArticles = VcmsArticleServiceUtil.countByC_P_L_S_D(
							vcmsCategory.getCategoryId(), groupId, language,
							status.getStatusId(), dateFrom, dateTo, byUser);					
					totalArticle += countArticles;
					
					ReportUtil.createCell(row, (short) (x + 2 + k), countArticles, wb);
				}
			}

		}
		
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(totalArticle), wb);
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir()
					+ "/VCMS-portlet/html/portlet/vcms/report/file/reportCategory.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}
	}

	public void setReportByDate(int y, int x, HSSFSheet sheet,
			HSSFWorkbook wb, long groupId, String language, long statusId,
			Date dateFrom, Date dateTo, String byUser, String[] strType, int begin, int end)
			throws Exception {
		
		List listNews = new ArrayList();		
					
		listNews = VcmsArticleServiceUtil.listArticleByDateTypes(groupId,
				language, statusId, dateFrom, dateTo, byUser, strType, begin, end);		
		
		HSSFRow row;
		HSSFCell cell;
		User userBean;
		
		VcmsStatus vcmsStatus = VcmsStatusLocalServiceUtil
				.getVcmsStatus(statusId);
		
		sheet.shiftRows(y, sheet.getLastRowNum(), 1);		
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);	
		
		row = sheet.createRow(y);

		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "Ti\u00eau \u0111\u1ec1", wb);
		ReportUtil.createCellBold(row, (short) (x + 2), "Ng\u00e0y \u0111\u0103ng", wb);
		ReportUtil.createCellBold(row, (short) (x + 3), "Ng\u01b0\u1eddi t\u1ea1o", wb);
		ReportUtil.createCellBold(row, (short) (x + 4), "Ng\u01b0\u1eddi duy\u1ec7t", wb);
		ReportUtil.createCellBold(row, (short) (x + 5), "Ng\u01b0\u1eddi xu\u1ea5t b\u1ea3n", wb);
		ReportUtil.createCellBold(row, (short) (x + 6), "Lo\u1ea1i tin", wb);
				
		int stt = 0;
		for (int j = 0; j < listNews.size(); j++) {
			VcmsArticle vcmsAr = (VcmsArticle) listNews.get(j);
			
			String typeNames ="";
			try{
				typeNames += ReportUtil.getTypeNames(vcmsAr.getArticleId());	
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);

			if (vcmsAr != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
				ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
						+ vcmsAr.getTitle() + "", wb);
				ReportUtil.createCell(row, (short) (x + 2), ActionUtil.dateParser(vcmsAr.getPublishedDate()), wb);
				
				try{
					User userCreate = UserServiceUtil.getUserById(Long.parseLong(vcmsAr
							.getCreatedByUser()));
					ReportUtil.createCellAlignLeft(row, (short) (x + 3), userCreate.getFullName(), wb);
				}catch(Exception ex){
					ReportUtil.createCellAlignLeft(row, (short) (x + 3), "User \u0111\u00e3 b\u1ecb x\u00f3a", wb);
				}
				
				try{
					User modifieddUser = UserServiceUtil.getUserById(Long.parseLong(vcmsAr
							.getModifiedByUser()));
					ReportUtil.createCellAlignLeft(row, (short) (x + 4), modifieddUser.getFullName(), wb);
				}catch(Exception ex){
					ReportUtil.createCellAlignLeft(row, (short) (x + 4), "User \u0111\u00e3 b\u1ecb x\u00f3a", wb);
				}
				
				try{
					User publishedUser = UserServiceUtil.getUserById(Long.parseLong(vcmsAr.getPublishedByUser()));
					ReportUtil.createCellAlignLeft(row, (short) (x + 5), publishedUser.getFullName(), wb);
				}catch(Exception ex){
					ReportUtil.createCellAlignLeft(row, (short) (x + 5), "User \u0111\u00e3 b\u1ecb x\u00f3a", wb);
				}
				
				ReportUtil.createCellAlignLeft(row, (short) (x + 6), typeNames, wb);
			}

		}
		
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(listNews.size()), wb);
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir()
					+ "/VCMS-portlet/html/portlet/vcms/report/file/reportByDate.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}
	}

	public void setUserReport(List userList, int y, int x, HSSFSheet sheet,
			HSSFWorkbook wb, long groupId, String language, String parentId,
			long statusId, Date dateFrom, Date dateTo) throws Exception {

		List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);

		HSSFRow row;
		User userBean;

		sheet.shiftRows(y, sheet.getLastRowNum(), 1);

		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);

		row = sheet.createRow(y);
		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "H\u1ecd T\u00ean", wb);

		for (int j = 0; j < listType.size(); j++) {
			VcmsType vcmsType = (VcmsType) listType.get(j);
			ReportUtil.createCellBold(row, (short) (x + 2 + j), ""
					+ vcmsType.getName() + "", wb);
		}
		ReportUtil.createCellBold(row, (short) (x + 2 + listType.size()),
				"C\u00e1c lo\u1ea1i tin kh\u00e1c", wb);
		
		int stt = 0;
		int totalArticle = 0;

		for (int i = userList.size() - 1; i >= 0; --i) {
			userBean = (User) userList.get(i);
			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);

			if (userBean != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
			}
			if (userBean != null) {
				ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
						+ userBean.getFullName() + "", wb);
			}
			
			for (int j = 0; j < listType.size(); j++) {
				VcmsType vcmsType = (VcmsType) listType.get(j);
				int countArticle = 0;
				if (!parentId.equals("0")) {
					countArticle = VcmsArticleServiceUtil.countByUser(groupId,
							language, parentId, statusId, Long.valueOf(vcmsType
									.getTypeId()), dateFrom, dateTo, String
									.valueOf(userBean.getUserId()));
				} else {

					countArticle = VcmsArticleServiceUtil.countByType(groupId,
							language, statusId, Long.valueOf(vcmsType
									.getTypeId()), dateFrom, dateTo, String
									.valueOf(userBean.getUserId()));
				}
				
				ReportUtil.createCell(row, (short) (x + 2 + j), countArticle,
						wb);
				totalArticle += countArticle;
			}

			//other type
			int countArticleAllCatNotInType =0;
			if (!parentId.equals("0")) {
				countArticleAllCatNotInType = VcmsArticleServiceUtil
						.countArticleNotInType(groupId, language, parentId,
								statusId, dateFrom, dateTo, String.valueOf(userBean.getUserId()));
			} else {
				countArticleAllCatNotInType = VcmsArticleServiceUtil
						.countArticleAllCatNotInType(groupId, language,
								statusId, dateFrom, dateTo, String
										.valueOf(userBean.getUserId()));
			}
			
			ReportUtil.createCell(row, (short) (x + 2 + listType.size()), countArticleAllCatNotInType,wb);
			totalArticle += countArticleAllCatNotInType;
		}
		
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(totalArticle), wb);
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir()
					+ "/VCMS-portlet/html/portlet/vcms/report/file/reportUser.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}

	}	

	public void getFile(HttpServletResponse response, String strDir)
			throws Exception {
		InputStream is = null;
		try {
			is = new FileInputStream(PortalUtil.getPortalWebDir() + strDir);
			ServletResponseUtil.sendFile(response, "report.xls", is);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			is.close();
		
		}
	}
}
