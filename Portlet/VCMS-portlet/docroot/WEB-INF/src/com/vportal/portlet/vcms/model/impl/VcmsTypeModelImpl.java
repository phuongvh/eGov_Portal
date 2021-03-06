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

package com.vportal.portlet.vcms.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.model.VcmsTypeModel;
import com.vportal.portlet.vcms.model.VcmsTypeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the VcmsType service. Represents a row in the &quot;VcmsType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.vportal.portlet.vcms.model.VcmsTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VcmsTypeImpl}.
 * </p>
 *
 * @author hai
 * @see VcmsTypeImpl
 * @see com.vportal.portlet.vcms.model.VcmsType
 * @see com.vportal.portlet.vcms.model.VcmsTypeModel
 * @generated
 */
@JSON(strict = true)
public class VcmsTypeModelImpl extends BaseModelImpl<VcmsType>
	implements VcmsTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vcms type model instance should use the {@link com.vportal.portlet.vcms.model.VcmsType} interface instead.
	 */
	public static final String TABLE_NAME = "VcmsType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "typeId", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "createdByUser", Types.VARCHAR },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedByUser", Types.VARCHAR },
			{ "code_", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "language", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table VcmsType (typeId VARCHAR(75) not null primary key,groupId LONG,companyId LONG,createdDate DATE null,createdByUser VARCHAR(75) null,modifiedDate DATE null,modifiedByUser VARCHAR(75) null,code_ VARCHAR(75) null,name VARCHAR(500) null,description VARCHAR(1000) null,language VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table VcmsType";
	public static final String ORDER_BY_JPQL = " ORDER BY vcmsType.createdDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY VcmsType.createdDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vportal.portlet.vcms.model.VcmsType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vportal.portlet.vcms.model.VcmsType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.vportal.portlet.vcms.model.VcmsType"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long LANGUAGE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VcmsType toModel(VcmsTypeSoap soapModel) {
		VcmsType model = new VcmsTypeImpl();

		model.setTypeId(soapModel.getTypeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setCreatedByUser(soapModel.getCreatedByUser());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModifiedByUser(soapModel.getModifiedByUser());
		model.setCode(soapModel.getCode());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setLanguage(soapModel.getLanguage());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VcmsType> toModels(VcmsTypeSoap[] soapModels) {
		List<VcmsType> models = new ArrayList<VcmsType>(soapModels.length);

		for (VcmsTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.vportal.portlet.vcms.model.VcmsType"));

	public VcmsTypeModelImpl() {
	}

	public String getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(String primaryKey) {
		setTypeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _typeId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return VcmsType.class;
	}

	public String getModelClassName() {
		return VcmsType.class.getName();
	}

	@JSON
	public String getTypeId() {
		if (_typeId == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeId;
		}
	}

	public void setTypeId(String typeId) {
		_typeId = typeId;
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
	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_columnBitmask = -1L;

		_createdDate = createdDate;
	}

	@JSON
	public String getCreatedByUser() {
		if (_createdByUser == null) {
			return StringPool.BLANK;
		}
		else {
			return _createdByUser;
		}
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getModifiedByUser() {
		if (_modifiedByUser == null) {
			return StringPool.BLANK;
		}
		else {
			return _modifiedByUser;
		}
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	@JSON
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	public void setCode(String code) {
		_columnBitmask |= CODE_COLUMN_BITMASK;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public VcmsType toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (VcmsType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		VcmsTypeImpl vcmsTypeImpl = new VcmsTypeImpl();

		vcmsTypeImpl.setTypeId(getTypeId());
		vcmsTypeImpl.setGroupId(getGroupId());
		vcmsTypeImpl.setCompanyId(getCompanyId());
		vcmsTypeImpl.setCreatedDate(getCreatedDate());
		vcmsTypeImpl.setCreatedByUser(getCreatedByUser());
		vcmsTypeImpl.setModifiedDate(getModifiedDate());
		vcmsTypeImpl.setModifiedByUser(getModifiedByUser());
		vcmsTypeImpl.setCode(getCode());
		vcmsTypeImpl.setName(getName());
		vcmsTypeImpl.setDescription(getDescription());
		vcmsTypeImpl.setLanguage(getLanguage());

		vcmsTypeImpl.resetOriginalValues();

		return vcmsTypeImpl;
	}

	public int compareTo(VcmsType vcmsType) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(), vcmsType.getCreatedDate());

		value = value * -1;

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

		VcmsType vcmsType = null;

		try {
			vcmsType = (VcmsType)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vcmsType.getPrimaryKey();

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
		VcmsTypeModelImpl vcmsTypeModelImpl = this;

		vcmsTypeModelImpl._originalGroupId = vcmsTypeModelImpl._groupId;

		vcmsTypeModelImpl._setOriginalGroupId = false;

		vcmsTypeModelImpl._originalCode = vcmsTypeModelImpl._code;

		vcmsTypeModelImpl._originalLanguage = vcmsTypeModelImpl._language;

		vcmsTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VcmsType> toCacheModel() {
		VcmsTypeCacheModel vcmsTypeCacheModel = new VcmsTypeCacheModel();

		vcmsTypeCacheModel.typeId = getTypeId();

		String typeId = vcmsTypeCacheModel.typeId;

		if ((typeId != null) && (typeId.length() == 0)) {
			vcmsTypeCacheModel.typeId = null;
		}

		vcmsTypeCacheModel.groupId = getGroupId();

		vcmsTypeCacheModel.companyId = getCompanyId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			vcmsTypeCacheModel.createdDate = createdDate.getTime();
		}
		else {
			vcmsTypeCacheModel.createdDate = Long.MIN_VALUE;
		}

		vcmsTypeCacheModel.createdByUser = getCreatedByUser();

		String createdByUser = vcmsTypeCacheModel.createdByUser;

		if ((createdByUser != null) && (createdByUser.length() == 0)) {
			vcmsTypeCacheModel.createdByUser = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vcmsTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vcmsTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vcmsTypeCacheModel.modifiedByUser = getModifiedByUser();

		String modifiedByUser = vcmsTypeCacheModel.modifiedByUser;

		if ((modifiedByUser != null) && (modifiedByUser.length() == 0)) {
			vcmsTypeCacheModel.modifiedByUser = null;
		}

		vcmsTypeCacheModel.code = getCode();

		String code = vcmsTypeCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			vcmsTypeCacheModel.code = null;
		}

		vcmsTypeCacheModel.name = getName();

		String name = vcmsTypeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			vcmsTypeCacheModel.name = null;
		}

		vcmsTypeCacheModel.description = getDescription();

		String description = vcmsTypeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			vcmsTypeCacheModel.description = null;
		}

		vcmsTypeCacheModel.language = getLanguage();

		String language = vcmsTypeCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			vcmsTypeCacheModel.language = null;
		}

		return vcmsTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{typeId=");
		sb.append(getTypeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
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
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUser</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedByUser</column-name><column-value><![CDATA[");
		sb.append(getModifiedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
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
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VcmsType.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			VcmsType.class
		};
	private String _typeId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _code;
	private String _originalCode;
	private String _name;
	private String _description;
	private String _language;
	private String _originalLanguage;
	private long _columnBitmask;
	private VcmsType _escapedModelProxy;
}