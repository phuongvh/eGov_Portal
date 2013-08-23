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

package com.vportal.portlet.vcms.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.vportal.portlet.vcms.model.VcmsArticleType;
import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTypeServiceUtil;

public class ReportUtil {
	
	public static void createCellNoBorder(HSSFRow row, short column, String value,
			HSSFWorkbook wb) {

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);		

		HSSFCell cell = row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		//cell.setEncoding(wb.ENCODING_UTF_16);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}	
	
	public static void createCell(HSSFRow row, short column, String value,
			HSSFWorkbook wb) {

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell cell = row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		//cell.setEncoding(wb.ENCODING_UTF_16);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	public static void createCellAlignLeft(HSSFRow row, short column, String value,
			HSSFWorkbook wb) {

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell cell = row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		//cell.setEncoding(wb.ENCODING_UTF_16);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	public static void createCellBold(HSSFRow row, short column, String value,
			HSSFWorkbook wb) {

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor((short) 0xc);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell cell = row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		//cell.setEncoding(wb.ENCODING_UTF_16);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	public static void createCell(HSSFRow row, short column, int value,
			HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell cell = row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}
	
	
	public static String getTypeNames(String articleId) throws Exception {

		String typeNames = "";
		List typeArticleList = (List) VcmsArticleTypeLocalServiceUtil
				.getByArticleId(articleId);

		for (int i = 0; i < typeArticleList.size(); i++) {
			
			VcmsArticleType vcmsArticleType = (VcmsArticleType) typeArticleList.get(i);
			VcmsType vcmsType = VcmsTypeServiceUtil.getType(
					String.valueOf(vcmsArticleType.getTypeId()));

			if (i == typeArticleList.size() - 1)
				typeNames += vcmsType.getName();
			else
				typeNames += vcmsType.getName() + ", ";

		}
		return typeNames;
	}
}
