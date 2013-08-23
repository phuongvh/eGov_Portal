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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.vportal.portlet.vdoc.model.vdocOrg;
import com.vportal.portlet.vdoc.model.vdocOrgModel;
import com.vportal.portlet.vdoc.model.vdocOrgSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the vdocOrg service. Represents a row in the &quot;vdocOrg&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.vportal.portlet.vdoc.model.vdocOrgModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vdocOrgImpl}.
 * </p>
 *
 * @author MrEn
 * @see vdocOrgImpl
 * @see com.vportal.portlet.vdoc.model.vdocOrg
 * @see com.vportal.portlet.vdoc.model.vdocOrgModel
 * @generated
 */
@JSON(strict = true)
public class vdocOrgModelImpl extends BaseModelImpl<vdocOrg>
	implements vdocOrgModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vdoc org model instance should use the {@link com.vportal.portlet.vdoc.model.vdocOrg} interface instead.
	 */
	public static final String TABLE_NAME = "vdocOrg";
	public static final Object[][] TABLE_COLUMNS = {
			{ "orgId", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "createdByUser", Types.BIGINT },
			{ "modifiedByUser", Types.BIGINT },
			{ "parentId", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "phone", Types.VARCHAR },
			{ "fax", Types.VARCHAR },
			{ "language", Types.VARCHAR },
			{ "statusOrg", Types.BOOLEAN },
			{ "position", Types.INTEGER },
			{ "listparent", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vdocOrg (orgId VARCHAR(75) not null primary key,groupId LONG,companyId LONG,userId LONG,createdDate DATE null,modifiedDate DATE null,createdByUser LONG,modifiedByUser LONG,parentId VARCHAR(500) null,name VARCHAR(500) null,description VARCHAR(1000) null,address VARCHAR(1000) null,phone VARCHAR(1000) null,fax VARCHAR(1000) null,language VARCHAR(1000) null,statusOrg BOOLEAN,position INTEGER,listparent VARCHAR(1000) null)";
	public static final String TABLE_SQL_DROP = "drop table vdocOrg";
	public static final String ORDER_BY_JPQL = " ORDER BY vdocOrg.position ASC";
	public static final String ORDER_BY_SQL = " ORDER BY vdocOrg.position ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vportal.portlet.vdoc.model.vdocOrg"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vportal.portlet.vdoc.model.vdocOrg"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.vportal.portlet.vdoc.model.vdocOrg"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long LANGUAGE_COLUMN_BITMASK = 2L;
	public static long PARENTID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static vdocOrg toModel(vdocOrgSoap soapModel) {
		vdocOrg model = new vdocOrgImpl();

		model.setOrgId(soapModel.getOrgId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCreatedByUser(soapModel.getCreatedByUser());
		model.setModifiedByUser(soapModel.getModifiedByUser());
		model.setParentId(soapModel.getParentId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setAddress(soapModel.getAddress());
		model.setPhone(soapModel.getPhone());
		model.setFax(soapModel.getFax());
		model.setLanguage(soapModel.getLanguage());
		model.setStatusOrg(soapModel.getStatusOrg());
		model.setPosition(soapModel.getPosition());
		model.setListparent(soapModel.getListparent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<vdocOrg> toModels(vdocOrgSoap[] soapModels) {
		List<vdocOrg> models = new ArrayList<vdocOrg>(soapModels.length);

		for (vdocOrgSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.vportal.portlet.vdoc.model.vdocOrg"));

	public vdocOrgModelImpl() {
	}

	public String getPrimaryKey() {
		return _orgId;
	}

	public void setPrimaryKey(String primaryKey) {
		setOrgId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return vdocOrg.class;
	}

	public String getModelClassName() {
		return vdocOrg.class.getName();
	}

	@JSON
	public String getOrgId() {
		if (_orgId == null) {
			return StringPool.BLANK;
		}
		else {
			return _orgId;
		}
	}

	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	@JSON
	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	@JSON
	public String getParentId() {
		if (_parentId == null) {
			return StringPool.BLANK;
		}
		else {
			return _parentId;
		}
	}

	public void setParentId(String parentId) {
		_columnBitmask |= PARENTID_COLUMN_BITMASK;

		if (_originalParentId == null) {
			_originalParentId = _parentId;
		}

		_parentId = parentId;
	}

	public String getOriginalParentId() {
		return GetterUtil.getString(_originalParentId);
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	public String getPhone() {
		if (_phone == null) {
			return StringPool.BLANK;
		}
		else {
			return _phone;
		}
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	@JSON
	public String getFax() {
		if (_fax == null) {
			return StringPool.BLANK;
		}
		else {
			return _fax;
		}
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	@JSON
	public String getLanguage() {
		if (_language == null) {
			return StringPool.BLANK;
		}
		else {
			return _language;
		}
	}

	public void setLanguage(String language) {
		_columnBitmask |= LANGUAGE_COLUMN_BITMASK;

		if (_originalLanguage == null) {
			_originalLanguage = _language;
		}

		_language = language;
	}

	public String getOriginalLanguage() {
		return GetterUtil.getString(_originalLanguage);
	}

	@JSON
	public boolean getStatusOrg() {
		return _statusOrg;
	}

	public boolean isStatusOrg() {
		return _statusOrg;
	}

	public void setStatusOrg(boolean statusOrg) {
		_statusOrg = statusOrg;
	}

	@JSON
	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_columnBitmask = -1L;

		_position = position;
	}

	@JSON
	public String getListparent() {
		if (_listparent == null) {
			return StringPool.BLANK;
		}
		else {
			return _listparent;
		}
	}

	public void setListparent(String listparent) {
		_listparent = listparent;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public vdocOrg toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (vdocOrg)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		vdocOrgImpl vdocOrgImpl = new vdocOrgImpl();

		vdocOrgImpl.setOrgId(getOrgId());
		vdocOrgImpl.setGroupId(getGroupId());
		vdocOrgImpl.setCompanyId(getCompanyId());
		vdocOrgImpl.setUserId(getUserId());
		vdocOrgImpl.setCreatedDate(getCreatedDate());
		vdocOrgImpl.setModifiedDate(getModifiedDate());
		vdocOrgImpl.setCreatedByUser(getCreatedByUser());
		vdocOrgImpl.setModifiedByUser(getModifiedByUser());
		vdocOrgImpl.setParentId(getParentId());
		vdocOrgImpl.setName(getName());
		vdocOrgImpl.setDescription(getDescription());
		vdocOrgImpl.setAddress(getAddress());
		vdocOrgImpl.setPhone(getPhone());
		vdocOrgImpl.setFax(getFax());
		vdocOrgImpl.setLanguage(getLanguage());
		vdocOrgImpl.setStatusOrg(getStatusOrg());
		vdocOrgImpl.setPosition(getPosition());
		vdocOrgImpl.setListparent(getListparent());

		vdocOrgImpl.resetOriginalValues();

		return vdocOrgImpl;
	}

	public int compareTo(vdocOrg vdocOrg) {
		int value = 0;

		if (getPosition() < vdocOrg.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vdocOrg.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		vdocOrg vdocOrg = null;

		try {
			vdocOrg = (vdocOrg)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vdocOrg.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		vdocOrgModelImpl vdocOrgModelImpl = this;

		vdocOrgModelImpl._originalGroupId = vdocOrgModelImpl._groupId;

		vdocOrgModelImpl._setOriginalGroupId = false;

		vdocOrgModelImpl._originalParentId = vdocOrgModelImpl._parentId;

		vdocOrgModelImpl._originalLanguage = vdocOrgModelImpl._language;

		vdocOrgModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<vdocOrg> toCacheModel() {
		vdocOrgCacheModel vdocOrgCacheModel = new vdocOrgCacheModel();

		vdocOrgCacheModel.orgId = getOrgId();

		String orgId = vdocOrgCacheModel.orgId;

		if ((orgId != null) && (orgId.length() == 0)) {
			vdocOrgCacheModel.orgId = null;
		}

		vdocOrgCacheModel.groupId = getGroupId();

		vdocOrgCacheModel.companyId = getCompanyId();

		vdocOrgCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			vdocOrgCacheModel.createdDate = createdDate.getTime();
		}
		else {
			vdocOrgCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vdocOrgCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vdocOrgCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vdocOrgCacheModel.createdByUser = getCreatedByUser();

		vdocOrgCacheModel.modifiedByUser = getModifiedByUser();

		vdocOrgCacheModel.parentId = getParentId();

		String parentId = vdocOrgCacheModel.parentId;

		if ((parentId != null) && (parentId.length() == 0)) {
			vdocOrgCacheModel.parentId = null;
		}

		vdocOrgCacheModel.name = getName();

		String name = vdocOrgCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			vdocOrgCacheModel.name = null;
		}

		vdocOrgCacheModel.description = getDescription();

		String description = vdocOrgCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			vdocOrgCacheModel.description = null;
		}

		vdocOrgCacheModel.address = getAddress();

		String address = vdocOrgCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			vdocOrgCacheModel.address = null;
		}

		vdocOrgCacheModel.phone = getPhone();

		String phone = vdocOrgCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			vdocOrgCacheModel.phone = null;
		}

		vdocOrgCacheModel.fax = getFax();

		String fax = vdocOrgCacheModel.fax;

		if ((fax != null) && (fax.length() == 0)) {
			vdocOrgCacheModel.fax = null;
		}

		vdocOrgCacheModel.language = getLanguage();

		String language = vdocOrgCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			vdocOrgCacheModel.language = null;
		}

		vdocOrgCacheModel.statusOrg = getStatusOrg();

		vdocOrgCacheModel.position = getPosition();

		vdocOrgCacheModel.listparent = getListparent();

		String listparent = vdocOrgCacheModel.listparent;

		if ((listparent != null) && (listparent.length() == 0)) {
			vdocOrgCacheModel.listparent = null;
		}

		return vdocOrgCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{orgId=");
		sb.append(getOrgId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", statusOrg=");
		sb.append(getStatusOrg());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", listparent=");
		sb.append(getListparent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vdoc.model.vdocOrg");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUser</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedByUser</column-name><column-value><![CDATA[");
		sb.append(getModifiedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusOrg</column-name><column-value><![CDATA[");
		sb.append(getStatusOrg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listparent</column-name><column-value><![CDATA[");
		sb.append(getListparent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = vdocOrg.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			vdocOrg.class
		};
	private String _orgId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _createdByUser;
	private long _modifiedByUser;
	private String _parentId;
	private String _originalParentId;
	private String _name;
	private String _description;
	private String _address;
	private String _phone;
	private String _fax;
	private String _language;
	private String _originalLanguage;
	private boolean _statusOrg;
	private int _position;
	private String _listparent;
	private long _columnBitmask;
	private vdocOrg _escapedModelProxy;
}