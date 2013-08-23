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

package com.vportal.portlet.edirectory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.edirectory.model.EDEmployee;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing EDEmployee in entity cache.
 *
 * @author HOAN
 * @see EDEmployee
 * @generated
 */
public class EDEmployeeCacheModel implements CacheModel<EDEmployee>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", name=");
		sb.append(name);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", homeSide=");
		sb.append(homeSide);
		sb.append(", family=");
		sb.append(family);
		sb.append(", race=");
		sb.append(race);
		sb.append(", home=");
		sb.append(home);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", workPhone=");
		sb.append(workPhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", majorLevel=");
		sb.append(majorLevel);
		sb.append(", philosophism=");
		sb.append(philosophism);
		sb.append(", foreignLanguage=");
		sb.append(foreignLanguage);
		sb.append(", joinDate=");
		sb.append(joinDate);
		sb.append(", image=");
		sb.append(image);
		sb.append(", isShowTree=");
		sb.append(isShowTree);
		sb.append(", otherInfo=");
		sb.append(otherInfo);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", status=");
		sb.append(status);
		sb.append(", show=");
		sb.append(show);
		sb.append("}");

		return sb.toString();
	}

	public EDEmployee toEntityModel() {
		EDEmployeeImpl edEmployeeImpl = new EDEmployeeImpl();

		if (uuid == null) {
			edEmployeeImpl.setUuid(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setUuid(uuid);
		}

		edEmployeeImpl.setId(id);

		if (createdDate == Long.MIN_VALUE) {
			edEmployeeImpl.setCreatedDate(null);
		}
		else {
			edEmployeeImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			edEmployeeImpl.setModifiedDate(null);
		}
		else {
			edEmployeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			edEmployeeImpl.setTitle(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setTitle(title);
		}

		if (name == null) {
			edEmployeeImpl.setName(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setName(name);
		}

		if (birthday == Long.MIN_VALUE) {
			edEmployeeImpl.setBirthday(null);
		}
		else {
			edEmployeeImpl.setBirthday(new Date(birthday));
		}

		if (homeSide == null) {
			edEmployeeImpl.setHomeSide(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setHomeSide(homeSide);
		}

		if (family == null) {
			edEmployeeImpl.setFamily(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setFamily(family);
		}

		if (race == null) {
			edEmployeeImpl.setRace(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setRace(race);
		}

		if (home == null) {
			edEmployeeImpl.setHome(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setHome(home);
		}

		if (homePhone == null) {
			edEmployeeImpl.setHomePhone(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setHomePhone(homePhone);
		}

		if (workPhone == null) {
			edEmployeeImpl.setWorkPhone(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setWorkPhone(workPhone);
		}

		if (mobilePhone == null) {
			edEmployeeImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			edEmployeeImpl.setEmail(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setEmail(email);
		}

		edEmployeeImpl.setDepartmentId(departmentId);

		if (majorLevel == null) {
			edEmployeeImpl.setMajorLevel(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setMajorLevel(majorLevel);
		}

		if (philosophism == null) {
			edEmployeeImpl.setPhilosophism(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setPhilosophism(philosophism);
		}

		if (foreignLanguage == null) {
			edEmployeeImpl.setForeignLanguage(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setForeignLanguage(foreignLanguage);
		}

		if (joinDate == Long.MIN_VALUE) {
			edEmployeeImpl.setJoinDate(null);
		}
		else {
			edEmployeeImpl.setJoinDate(new Date(joinDate));
		}

		if (image == null) {
			edEmployeeImpl.setImage(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setImage(image);
		}

		edEmployeeImpl.setIsShowTree(isShowTree);

		if (otherInfo == null) {
			edEmployeeImpl.setOtherInfo(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setOtherInfo(otherInfo);
		}

		edEmployeeImpl.setCompanyId(companyId);
		edEmployeeImpl.setGroupId(groupId);
		edEmployeeImpl.setUserId(userId);

		if (languageId == null) {
			edEmployeeImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setLanguageId(languageId);
		}

		edEmployeeImpl.setDisplayOrder(displayOrder);

		if (sex == null) {
			edEmployeeImpl.setSex(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setSex(sex);
		}

		edEmployeeImpl.setStatus(status);

		if (show == null) {
			edEmployeeImpl.setShow(StringPool.BLANK);
		}
		else {
			edEmployeeImpl.setShow(show);
		}

		edEmployeeImpl.resetOriginalValues();

		return edEmployeeImpl;
	}

	public String uuid;
	public long id;
	public long createdDate;
	public long modifiedDate;
	public String title;
	public String name;
	public long birthday;
	public String homeSide;
	public String family;
	public String race;
	public String home;
	public String homePhone;
	public String workPhone;
	public String mobilePhone;
	public String email;
	public long departmentId;
	public String majorLevel;
	public String philosophism;
	public String foreignLanguage;
	public long joinDate;
	public String image;
	public boolean isShowTree;
	public String otherInfo;
	public long companyId;
	public long groupId;
	public long userId;
	public String languageId;
	public long displayOrder;
	public String sex;
	public long status;
	public String show;
}