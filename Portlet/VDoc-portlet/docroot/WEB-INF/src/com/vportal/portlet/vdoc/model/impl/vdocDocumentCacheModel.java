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

package com.vportal.portlet.vdoc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vdoc.model.vdocDocument;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing vdocDocument in entity cache.
 *
 * @author MrEn
 * @see vdocDocument
 * @generated
 */
public class vdocDocumentCacheModel implements CacheModel<vdocDocument>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", publishedByUser=");
		sb.append(publishedByUser);
		sb.append(", publishedDate=");
		sb.append(publishedDate);
		sb.append(", promulDate=");
		sb.append(promulDate);
		sb.append(", effectivedDate=");
		sb.append(effectivedDate);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", replaceDoc=");
		sb.append(replaceDoc);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", process=");
		sb.append(process);
		sb.append(", base=");
		sb.append(base);
		sb.append(", time=");
		sb.append(time);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", require=");
		sb.append(require);
		sb.append(", result=");
		sb.append(result);
		sb.append(", objects=");
		sb.append(objects);
		sb.append(", style=");
		sb.append(style);
		sb.append(", position=");
		sb.append(position);
		sb.append(", note=");
		sb.append(note);
		sb.append(", userHit=");
		sb.append(userHit);
		sb.append(", statusDoc=");
		sb.append(statusDoc);
		sb.append(", typeDoc=");
		sb.append(typeDoc);
		sb.append(", hasAttachment=");
		sb.append(hasAttachment);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", orgRels=");
		sb.append(orgRels);
		sb.append(", fieldRels=");
		sb.append(fieldRels);
		sb.append("}");

		return sb.toString();
	}

	public vdocDocument toEntityModel() {
		vdocDocumentImpl vdocDocumentImpl = new vdocDocumentImpl();

		if (docId == null) {
			vdocDocumentImpl.setDocId(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setDocId(docId);
		}

		vdocDocumentImpl.setGroupId(groupId);

		if (language == null) {
			vdocDocumentImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setLanguage(language);
		}

		vdocDocumentImpl.setCompanyId(companyId);
		vdocDocumentImpl.setUserId(userId);
		vdocDocumentImpl.setCreatedByUser(createdByUser);

		if (createdDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setCreatedDate(null);
		}
		else {
			vdocDocumentImpl.setCreatedDate(new Date(createdDate));
		}

		vdocDocumentImpl.setModifiedByUser(modifiedByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setModifiedDate(null);
		}
		else {
			vdocDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		vdocDocumentImpl.setApprovedByUser(approvedByUser);

		if (approvedDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setApprovedDate(null);
		}
		else {
			vdocDocumentImpl.setApprovedDate(new Date(approvedDate));
		}

		vdocDocumentImpl.setPublishedByUser(publishedByUser);

		if (publishedDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setPublishedDate(null);
		}
		else {
			vdocDocumentImpl.setPublishedDate(new Date(publishedDate));
		}

		if (promulDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setPromulDate(null);
		}
		else {
			vdocDocumentImpl.setPromulDate(new Date(promulDate));
		}

		if (effectivedDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setEffectivedDate(null);
		}
		else {
			vdocDocumentImpl.setEffectivedDate(new Date(effectivedDate));
		}

		if (expiredDate == Long.MIN_VALUE) {
			vdocDocumentImpl.setExpiredDate(null);
		}
		else {
			vdocDocumentImpl.setExpiredDate(new Date(expiredDate));
		}

		if (replaceDoc == null) {
			vdocDocumentImpl.setReplaceDoc(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setReplaceDoc(replaceDoc);
		}

		if (title == null) {
			vdocDocumentImpl.setTitle(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setTitle(title);
		}

		if (content == null) {
			vdocDocumentImpl.setContent(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setContent(content);
		}

		if (process == null) {
			vdocDocumentImpl.setProcess(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setProcess(process);
		}

		if (base == null) {
			vdocDocumentImpl.setBase(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setBase(base);
		}

		if (time == null) {
			vdocDocumentImpl.setTime(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setTime(time);
		}

		if (cost == null) {
			vdocDocumentImpl.setCost(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setCost(cost);
		}

		if (require == null) {
			vdocDocumentImpl.setRequire(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setRequire(require);
		}

		if (result == null) {
			vdocDocumentImpl.setResult(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setResult(result);
		}

		if (objects == null) {
			vdocDocumentImpl.setObjects(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setObjects(objects);
		}

		if (style == null) {
			vdocDocumentImpl.setStyle(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setStyle(style);
		}

		vdocDocumentImpl.setPosition(position);

		if (note == null) {
			vdocDocumentImpl.setNote(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setNote(note);
		}

		vdocDocumentImpl.setUserHit(userHit);
		vdocDocumentImpl.setStatusDoc(statusDoc);
		vdocDocumentImpl.setTypeDoc(typeDoc);
		vdocDocumentImpl.setHasAttachment(hasAttachment);

		if (fieldId == null) {
			vdocDocumentImpl.setFieldId(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setFieldId(fieldId);
		}

		if (orgRels == null) {
			vdocDocumentImpl.setOrgRels(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setOrgRels(orgRels);
		}

		if (fieldRels == null) {
			vdocDocumentImpl.setFieldRels(StringPool.BLANK);
		}
		else {
			vdocDocumentImpl.setFieldRels(fieldRels);
		}

		vdocDocumentImpl.resetOriginalValues();

		return vdocDocumentImpl;
	}

	public String docId;
	public long groupId;
	public String language;
	public long companyId;
	public long userId;
	public long createdByUser;
	public long createdDate;
	public long modifiedByUser;
	public long modifiedDate;
	public long approvedByUser;
	public long approvedDate;
	public long publishedByUser;
	public long publishedDate;
	public long promulDate;
	public long effectivedDate;
	public long expiredDate;
	public String replaceDoc;
	public String title;
	public String content;
	public String process;
	public String base;
	public String time;
	public String cost;
	public String require;
	public String result;
	public String objects;
	public String style;
	public int position;
	public String note;
	public int userHit;
	public int statusDoc;
	public int typeDoc;
	public boolean hasAttachment;
	public String fieldId;
	public String orgRels;
	public String fieldRels;
}