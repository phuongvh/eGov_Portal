/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.vdoc.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vdoc.model.vdocDORelClp;
import com.vportal.portlet.vdoc.model.vdocDocumentClp;
import com.vportal.portlet.vdoc.model.vdocFieldClp;
import com.vportal.portlet.vdoc.model.vdocLoggerClp;
import com.vportal.portlet.vdoc.model.vdocOrgClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"VDoc-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"VDoc-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "VDoc-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(vdocDocumentClp.class.getName())) {
			return translateInputvdocDocument(oldModel);
		}

		if (oldModelClassName.equals(vdocDORelClp.class.getName())) {
			return translateInputvdocDORel(oldModel);
		}

		if (oldModelClassName.equals(vdocFieldClp.class.getName())) {
			return translateInputvdocField(oldModel);
		}

		if (oldModelClassName.equals(vdocLoggerClp.class.getName())) {
			return translateInputvdocLogger(oldModel);
		}

		if (oldModelClassName.equals(vdocOrgClp.class.getName())) {
			return translateInputvdocOrg(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputvdocDocument(BaseModel<?> oldModel) {
		vdocDocumentClp oldCplModel = (vdocDocumentClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vdoc.model.impl.vdocDocumentImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setDocId",
						new Class[] { String.class });

				String value0 = oldCplModel.getDocId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value2 = oldCplModel.getLanguage();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCreatedByUser());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getCreatedDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getModifiedByUser());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getModifiedDate();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setApprovedByUser",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getApprovedByUser());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setApprovedDate",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getApprovedDate();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setPublishedByUser",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getPublishedByUser());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setPublishedDate",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getPublishedDate();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setPromulDate",
						new Class[] { Date.class });

				Date value13 = oldCplModel.getPromulDate();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setEffectivedDate",
						new Class[] { Date.class });

				Date value14 = oldCplModel.getEffectivedDate();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setExpiredDate",
						new Class[] { Date.class });

				Date value15 = oldCplModel.getExpiredDate();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setReplaceDoc",
						new Class[] { String.class });

				String value16 = oldCplModel.getReplaceDoc();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value17 = oldCplModel.getTitle();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value18 = oldCplModel.getContent();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setProcess",
						new Class[] { String.class });

				String value19 = oldCplModel.getProcess();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setBase",
						new Class[] { String.class });

				String value20 = oldCplModel.getBase();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setTime",
						new Class[] { String.class });

				String value21 = oldCplModel.getTime();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setCost",
						new Class[] { String.class });

				String value22 = oldCplModel.getCost();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setRequire",
						new Class[] { String.class });

				String value23 = oldCplModel.getRequire();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setResult",
						new Class[] { String.class });

				String value24 = oldCplModel.getResult();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setObjects",
						new Class[] { String.class });

				String value25 = oldCplModel.getObjects();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setStyle",
						new Class[] { String.class });

				String value26 = oldCplModel.getStyle();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setPosition",
						new Class[] { Integer.TYPE });

				Integer value27 = new Integer(oldCplModel.getPosition());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setNote",
						new Class[] { String.class });

				String value28 = oldCplModel.getNote();

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setUserHit",
						new Class[] { Integer.TYPE });

				Integer value29 = new Integer(oldCplModel.getUserHit());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setStatusDoc",
						new Class[] { Integer.TYPE });

				Integer value30 = new Integer(oldCplModel.getStatusDoc());

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setTypeDoc",
						new Class[] { Integer.TYPE });

				Integer value31 = new Integer(oldCplModel.getTypeDoc());

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setHasAttachment",
						new Class[] { Boolean.TYPE });

				Boolean value32 = new Boolean(oldCplModel.getHasAttachment());

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setFieldId",
						new Class[] { String.class });

				String value33 = oldCplModel.getFieldId();

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setOrgRels",
						new Class[] { String.class });

				String value34 = oldCplModel.getOrgRels();

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setFieldRels",
						new Class[] { String.class });

				String value35 = oldCplModel.getFieldRels();

				method35.invoke(newModel, value35);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputvdocDORel(BaseModel<?> oldModel) {
		vdocDORelClp oldCplModel = (vdocDORelClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vdoc.model.impl.vdocDORelImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setDocId",
						new Class[] { String.class });

				String value0 = oldCplModel.getDocId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setOrgId",
						new Class[] { String.class });

				String value1 = oldCplModel.getOrgId();

				method1.invoke(newModel, value1);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputvdocField(BaseModel<?> oldModel) {
		vdocFieldClp oldCplModel = (vdocFieldClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vdoc.model.impl.vdocFieldImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setFieldId",
						new Class[] { String.class });

				String value0 = oldCplModel.getFieldId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreatedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getCreatedByUser());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getModifiedByUser());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setParentId",
						new Class[] { String.class });

				String value8 = oldCplModel.getParentId();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value9 = oldCplModel.getName();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value10 = oldCplModel.getDescription();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value11 = oldCplModel.getLanguage();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setStatusField",
						new Class[] { Boolean.TYPE });

				Boolean value12 = new Boolean(oldCplModel.getStatusField());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setPosition",
						new Class[] { Integer.TYPE });

				Integer value13 = new Integer(oldCplModel.getPosition());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setListparent",
						new Class[] { String.class });

				String value14 = oldCplModel.getListparent();

				method14.invoke(newModel, value14);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputvdocLogger(BaseModel<?> oldModel) {
		vdocLoggerClp oldCplModel = (vdocLoggerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vdoc.model.impl.vdocLoggerImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setLoggerId",
						new Class[] { String.class });

				String value0 = oldCplModel.getLoggerId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreatedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCreatedByUser());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value6 = oldCplModel.getContent();

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputvdocOrg(BaseModel<?> oldModel) {
		vdocOrgClp oldCplModel = (vdocOrgClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vdoc.model.impl.vdocOrgImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setOrgId",
						new Class[] { String.class });

				String value0 = oldCplModel.getOrgId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreatedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getCreatedByUser());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getModifiedByUser());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setParentId",
						new Class[] { String.class });

				String value8 = oldCplModel.getParentId();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value9 = oldCplModel.getName();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value10 = oldCplModel.getDescription();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value11 = oldCplModel.getAddress();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setPhone",
						new Class[] { String.class });

				String value12 = oldCplModel.getPhone();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value13 = oldCplModel.getFax();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value14 = oldCplModel.getLanguage();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setStatusOrg",
						new Class[] { Boolean.TYPE });

				Boolean value15 = new Boolean(oldCplModel.getStatusOrg());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setPosition",
						new Class[] { Integer.TYPE });

				Integer value16 = new Integer(oldCplModel.getPosition());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setListparent",
						new Class[] { String.class });

				String value17 = oldCplModel.getListparent();

				method17.invoke(newModel, value17);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.vportal.portlet.vdoc.model.impl.vdocDocumentImpl")) {
			return translateOutputvdocDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vdoc.model.impl.vdocDORelImpl")) {
			return translateOutputvdocDORel(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vdoc.model.impl.vdocFieldImpl")) {
			return translateOutputvdocField(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vdoc.model.impl.vdocLoggerImpl")) {
			return translateOutputvdocLogger(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vdoc.model.impl.vdocOrgImpl")) {
			return translateOutputvdocOrg(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputvdocDocument(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				vdocDocumentClp newModel = new vdocDocumentClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getDocId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setDocId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getLanguage");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setLanguage(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				Method method5 = oldModelClass.getMethod("getCreatedByUser");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value5);

				Method method6 = oldModelClass.getMethod("getCreatedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value6);

				Method method7 = oldModelClass.getMethod("getModifiedByUser");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value7);

				Method method8 = oldModelClass.getMethod("getModifiedDate");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value8);

				Method method9 = oldModelClass.getMethod("getApprovedByUser");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setApprovedByUser(value9);

				Method method10 = oldModelClass.getMethod("getApprovedDate");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setApprovedDate(value10);

				Method method11 = oldModelClass.getMethod("getPublishedByUser");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setPublishedByUser(value11);

				Method method12 = oldModelClass.getMethod("getPublishedDate");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setPublishedDate(value12);

				Method method13 = oldModelClass.getMethod("getPromulDate");

				Date value13 = (Date)method13.invoke(oldModel, (Object[])null);

				newModel.setPromulDate(value13);

				Method method14 = oldModelClass.getMethod("getEffectivedDate");

				Date value14 = (Date)method14.invoke(oldModel, (Object[])null);

				newModel.setEffectivedDate(value14);

				Method method15 = oldModelClass.getMethod("getExpiredDate");

				Date value15 = (Date)method15.invoke(oldModel, (Object[])null);

				newModel.setExpiredDate(value15);

				Method method16 = oldModelClass.getMethod("getReplaceDoc");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setReplaceDoc(value16);

				Method method17 = oldModelClass.getMethod("getTitle");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setTitle(value17);

				Method method18 = oldModelClass.getMethod("getContent");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setContent(value18);

				Method method19 = oldModelClass.getMethod("getProcess");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setProcess(value19);

				Method method20 = oldModelClass.getMethod("getBase");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setBase(value20);

				Method method21 = oldModelClass.getMethod("getTime");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setTime(value21);

				Method method22 = oldModelClass.getMethod("getCost");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setCost(value22);

				Method method23 = oldModelClass.getMethod("getRequire");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setRequire(value23);

				Method method24 = oldModelClass.getMethod("getResult");

				String value24 = (String)method24.invoke(oldModel,
						(Object[])null);

				newModel.setResult(value24);

				Method method25 = oldModelClass.getMethod("getObjects");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setObjects(value25);

				Method method26 = oldModelClass.getMethod("getStyle");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setStyle(value26);

				Method method27 = oldModelClass.getMethod("getPosition");

				Integer value27 = (Integer)method27.invoke(oldModel,
						(Object[])null);

				newModel.setPosition(value27);

				Method method28 = oldModelClass.getMethod("getNote");

				String value28 = (String)method28.invoke(oldModel,
						(Object[])null);

				newModel.setNote(value28);

				Method method29 = oldModelClass.getMethod("getUserHit");

				Integer value29 = (Integer)method29.invoke(oldModel,
						(Object[])null);

				newModel.setUserHit(value29);

				Method method30 = oldModelClass.getMethod("getStatusDoc");

				Integer value30 = (Integer)method30.invoke(oldModel,
						(Object[])null);

				newModel.setStatusDoc(value30);

				Method method31 = oldModelClass.getMethod("getTypeDoc");

				Integer value31 = (Integer)method31.invoke(oldModel,
						(Object[])null);

				newModel.setTypeDoc(value31);

				Method method32 = oldModelClass.getMethod("getHasAttachment");

				Boolean value32 = (Boolean)method32.invoke(oldModel,
						(Object[])null);

				newModel.setHasAttachment(value32);

				Method method33 = oldModelClass.getMethod("getFieldId");

				String value33 = (String)method33.invoke(oldModel,
						(Object[])null);

				newModel.setFieldId(value33);

				Method method34 = oldModelClass.getMethod("getOrgRels");

				String value34 = (String)method34.invoke(oldModel,
						(Object[])null);

				newModel.setOrgRels(value34);

				Method method35 = oldModelClass.getMethod("getFieldRels");

				String value35 = (String)method35.invoke(oldModel,
						(Object[])null);

				newModel.setFieldRels(value35);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputvdocDORel(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				vdocDORelClp newModel = new vdocDORelClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getDocId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setDocId(value0);

				Method method1 = oldModelClass.getMethod("getOrgId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setOrgId(value1);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputvdocField(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				vdocFieldClp newModel = new vdocFieldClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getFieldId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setFieldId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getCreatedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getCreatedByUser");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value6);

				Method method7 = oldModelClass.getMethod("getModifiedByUser");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value7);

				Method method8 = oldModelClass.getMethod("getParentId");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setParentId(value8);

				Method method9 = oldModelClass.getMethod("getName");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setName(value9);

				Method method10 = oldModelClass.getMethod("getDescription");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDescription(value10);

				Method method11 = oldModelClass.getMethod("getLanguage");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value11);

				Method method12 = oldModelClass.getMethod("getStatusField");

				Boolean value12 = (Boolean)method12.invoke(oldModel,
						(Object[])null);

				newModel.setStatusField(value12);

				Method method13 = oldModelClass.getMethod("getPosition");

				Integer value13 = (Integer)method13.invoke(oldModel,
						(Object[])null);

				newModel.setPosition(value13);

				Method method14 = oldModelClass.getMethod("getListparent");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setListparent(value14);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputvdocLogger(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				vdocLoggerClp newModel = new vdocLoggerClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getLoggerId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setLoggerId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getCreatedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value4);

				Method method5 = oldModelClass.getMethod("getCreatedByUser");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value5);

				Method method6 = oldModelClass.getMethod("getContent");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setContent(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputvdocOrg(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				vdocOrgClp newModel = new vdocOrgClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getOrgId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setOrgId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getCreatedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getCreatedByUser");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value6);

				Method method7 = oldModelClass.getMethod("getModifiedByUser");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value7);

				Method method8 = oldModelClass.getMethod("getParentId");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setParentId(value8);

				Method method9 = oldModelClass.getMethod("getName");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setName(value9);

				Method method10 = oldModelClass.getMethod("getDescription");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDescription(value10);

				Method method11 = oldModelClass.getMethod("getAddress");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setAddress(value11);

				Method method12 = oldModelClass.getMethod("getPhone");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setPhone(value12);

				Method method13 = oldModelClass.getMethod("getFax");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setFax(value13);

				Method method14 = oldModelClass.getMethod("getLanguage");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value14);

				Method method15 = oldModelClass.getMethod("getStatusOrg");

				Boolean value15 = (Boolean)method15.invoke(oldModel,
						(Object[])null);

				newModel.setStatusOrg(value15);

				Method method16 = oldModelClass.getMethod("getPosition");

				Integer value16 = (Integer)method16.invoke(oldModel,
						(Object[])null);

				newModel.setPosition(value16);

				Method method17 = oldModelClass.getMethod("getListparent");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setListparent(value17);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}