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

package com.vportal.portlet.vsitemap.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.vportal.portlet.vsitemap.model.VsmBranch;
import com.vportal.portlet.vsitemap.model.VsmBranchModel;
import com.vportal.portlet.vsitemap.model.VsmBranchSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the VsmBranch service. Represents a row in the &quot;VsmBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.vportal.portlet.vsitemap.model.VsmBranchModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VsmBranchImpl}.
 * </p>
 *
 * @author LongLH
 * @see VsmBranchImpl
 * @see com.vportal.portlet.vsitemap.model.VsmBranch
 * @see com.vportal.portlet.vsitemap.model.VsmBranchModel
 * @generated
 */
@JSON(strict = true)
public class VsmBranchModelImpl extends BaseModelImpl<VsmBranch>
	implements VsmBranchModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vsm branch model instance should use the {@link com.vportal.portlet.vsitemap.model.VsmBranch} interface instead.
	 */
	public static final String TABLE_NAME = "VsmBranch";
	public static final Object[][] TABLE_COLUMNS = {
			{ "branchId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "createdByUser", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedByUser", Types.BIGINT },
			{ "parentId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "anchored", Types.BOOLEAN },
			{ "href", Types.VARCHAR },
			{ "language", Types.VARCHAR },
			{ "hasIcon", Types.BOOLEAN },
			{ "icon", Types.VARCHAR },
			{ "position", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table VsmBranch (branchId LONG not null primary key,groupId LONG,companyId LONG,createdDate DATE null,createdByUser LONG,modifiedDate DATE null,modifiedByUser LONG,parentId LONG,name VARCHAR(250) null,description VARCHAR(550) null,anchored BOOLEAN,href VARCHAR(75) null,language VARCHAR(75) null,hasIcon BOOLEAN,icon VARCHAR(75) null,position LONG)";
	public static final String TABLE_SQL_DROP = "drop table VsmBranch";
	public static final String ORDER_BY_JPQL = " ORDER BY vsmBranch.position ASC";
	public static final String ORDER_BY_SQL = " ORDER BY VsmBranch.position ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vportal.portlet.vsitemap.model.VsmBranch"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vportal.portlet.vsitemap.model.VsmBranch"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.vportal.portlet.vsitemap.model.VsmBranch"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long HASICON_COLUMN_BITMASK = 2L;
	public static long LANGUAGE_COLUMN_BITMASK = 4L;
	public static long PARENTID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VsmBranch toModel(VsmBranchSoap soapModel) {
		VsmBranch model = new VsmBranchImpl();

		model.setBranchId(soapModel.getBranchId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setCreatedByUser(soapModel.getCreatedByUser());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModifiedByUser(soapModel.getModifiedByUser());
		model.setParentId(soapModel.getParentId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setAnchored(soapModel.getAnchored());
		model.setHref(soapModel.getHref());
		model.setLanguage(soapModel.getLanguage());
		model.setHasIcon(soapModel.getHasIcon());
		model.setIcon(soapModel.getIcon());
		model.setPosition(soapModel.getPosition());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VsmBranch> toModels(VsmBranchSoap[] soapModels) {
		List<VsmBranch> models = new ArrayList<VsmBranch>(soapModels.length);

		for (VsmBranchSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.vportal.portlet.vsitemap.model.VsmBranch"));

	public VsmBranchModelImpl() {
	}

	public long getPrimaryKey() {
		return _branchId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBranchId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_branchId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return VsmBranch.class;
	}

	public String getModelClassName() {
		return VsmBranch.class.getName();
	}

	@JSON
	public long getBranchId() {
		return _branchId;
	}

	public void setBranchId(long branchId) {
		_branchId = branchId;
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
		_createdDate = createdDate;
	}

	@JSON
	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
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
	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	@JSON
	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_columnBitmask |= PARENTID_COLUMN_BITMASK;

		if (!_setOriginalParentId) {
			_setOriginalParentId = true;

			_originalParentId = _parentId;
		}

		_parentId = parentId;
	}

	public long getOriginalParentId() {
		return _originalParentId;
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
	public boolean getAnchored() {
		return _anchored;
	}

	public boolean isAnchored() {
		return _anchored;
	}

	public void setAnchored(boolean anchored) {
		_anchored = anchored;
	}

	@JSON
	public String getHref() {
		if (_href == null) {
			return StringPool.BLANK;
		}
		else {
			return _href;
		}
	}

	public void setHref(String href) {
		_href = href;
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
	public boolean getHasIcon() {
		return _hasIcon;
	}

	public boolean isHasIcon() {
		return _hasIcon;
	}

	public void setHasIcon(boolean hasIcon) {
		_columnBitmask |= HASICON_COLUMN_BITMASK;

		if (!_setOriginalHasIcon) {
			_setOriginalHasIcon = true;

			_originalHasIcon = _hasIcon;
		}

		_hasIcon = hasIcon;
	}

	public boolean getOriginalHasIcon() {
		return _originalHasIcon;
	}

	@JSON
	public String getIcon() {
		if (_icon == null) {
			return StringPool.BLANK;
		}
		else {
			return _icon;
		}
	}

	public void setIcon(String icon) {
		_icon = icon;
	}

	@JSON
	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_columnBitmask = -1L;

		_position = position;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public VsmBranch toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (VsmBranch)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					VsmBranch.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		VsmBranchImpl vsmBranchImpl = new VsmBranchImpl();

		vsmBranchImpl.setBranchId(getBranchId());
		vsmBranchImpl.setGroupId(getGroupId());
		vsmBranchImpl.setCompanyId(getCompanyId());
		vsmBranchImpl.setCreatedDate(getCreatedDate());
		vsmBranchImpl.setCreatedByUser(getCreatedByUser());
		vsmBranchImpl.setModifiedDate(getModifiedDate());
		vsmBranchImpl.setModifiedByUser(getModifiedByUser());
		vsmBranchImpl.setParentId(getParentId());
		vsmBranchImpl.setName(getName());
		vsmBranchImpl.setDescription(getDescription());
		vsmBranchImpl.setAnchored(getAnchored());
		vsmBranchImpl.setHref(getHref());
		vsmBranchImpl.setLanguage(getLanguage());
		vsmBranchImpl.setHasIcon(getHasIcon());
		vsmBranchImpl.setIcon(getIcon());
		vsmBranchImpl.setPosition(getPosition());

		vsmBranchImpl.resetOriginalValues();

		return vsmBranchImpl;
	}

	public int compareTo(VsmBranch vsmBranch) {
		int value = 0;

		if (getPosition() < vsmBranch.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vsmBranch.getPosition()) {
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

		VsmBranch vsmBranch = null;

		try {
			vsmBranch = (VsmBranch)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vsmBranch.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		VsmBranchModelImpl vsmBranchModelImpl = this;

		vsmBranchModelImpl._originalGroupId = vsmBranchModelImpl._groupId;

		vsmBranchModelImpl._setOriginalGroupId = false;

		vsmBranchModelImpl._originalParentId = vsmBranchModelImpl._parentId;

		vsmBranchModelImpl._setOriginalParentId = false;

		vsmBranchModelImpl._originalLanguage = vsmBranchModelImpl._language;

		vsmBranchModelImpl._originalHasIcon = vsmBranchModelImpl._hasIcon;

		vsmBranchModelImpl._setOriginalHasIcon = false;

		vsmBranchModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VsmBranch> toCacheModel() {
		VsmBranchCacheModel vsmBranchCacheModel = new VsmBranchCacheModel();

		vsmBranchCacheModel.branchId = getBranchId();

		vsmBranchCacheModel.groupId = getGroupId();

		vsmBranchCacheModel.companyId = getCompanyId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			vsmBranchCacheModel.createdDate = createdDate.getTime();
		}
		else {
			vsmBranchCacheModel.createdDate = Long.MIN_VALUE;
		}

		vsmBranchCacheModel.createdByUser = getCreatedByUser();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vsmBranchCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vsmBranchCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vsmBranchCacheModel.modifiedByUser = getModifiedByUser();

		vsmBranchCacheModel.parentId = getParentId();

		vsmBranchCacheModel.name = getName();

		String name = vsmBranchCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			vsmBranchCacheModel.name = null;
		}

		vsmBranchCacheModel.description = getDescription();

		String description = vsmBranchCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			vsmBranchCacheModel.description = null;
		}

		vsmBranchCacheModel.anchored = getAnchored();

		vsmBranchCacheModel.href = getHref();

		String href = vsmBranchCacheModel.href;

		if ((href != null) && (href.length() == 0)) {
			vsmBranchCacheModel.href = null;
		}

		vsmBranchCacheModel.language = getLanguage();

		String language = vsmBranchCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			vsmBranchCacheModel.language = null;
		}

		vsmBranchCacheModel.hasIcon = getHasIcon();

		vsmBranchCacheModel.icon = getIcon();

		String icon = vsmBranchCacheModel.icon;

		if ((icon != null) && (icon.length() == 0)) {
			vsmBranchCacheModel.icon = null;
		}

		vsmBranchCacheModel.position = getPosition();

		return vsmBranchCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{branchId=");
		sb.append(getBranchId());
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
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", anchored=");
		sb.append(getAnchored());
		sb.append(", href=");
		sb.append(getHref());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", hasIcon=");
		sb.append(getHasIcon());
		sb.append(", icon=");
		sb.append(getIcon());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vsitemap.model.VsmBranch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>branchId</column-name><column-value><![CDATA[");
		sb.append(getBranchId());
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
			"<column><column-name>anchored</column-name><column-value><![CDATA[");
		sb.append(getAnchored());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>href</column-name><column-value><![CDATA[");
		sb.append(getHref());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasIcon</column-name><column-value><![CDATA[");
		sb.append(getHasIcon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icon</column-name><column-value><![CDATA[");
		sb.append(getIcon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VsmBranch.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			VsmBranch.class
		};
	private long _branchId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private Date _createdDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private long _parentId;
	private long _originalParentId;
	private boolean _setOriginalParentId;
	private String _name;
	private String _description;
	private boolean _anchored;
	private String _href;
	private String _language;
	private String _originalLanguage;
	private boolean _hasIcon;
	private boolean _originalHasIcon;
	private boolean _setOriginalHasIcon;
	private String _icon;
	private long _position;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private VsmBranch _escapedModelProxy;
}