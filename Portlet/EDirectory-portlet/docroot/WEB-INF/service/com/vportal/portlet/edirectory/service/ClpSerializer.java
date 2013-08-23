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

package com.vportal.portlet.edirectory.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.edirectory.model.EDDepartmentClp;
import com.vportal.portlet.edirectory.model.EDEmployeeClp;
import com.vportal.portlet.edirectory.model.EDFunctionClp;
import com.vportal.portlet.edirectory.model.EDFunctionDepartmentClp;
import com.vportal.portlet.edirectory.model.EDFunctionEmployeeClp;

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
						"EDirectory-portlet-deployment-context");

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
							"EDirectory-portlet-deployment-context");

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
				_servletContextName = "EDirectory-portlet";
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

		if (oldModelClassName.equals(EDDepartmentClp.class.getName())) {
			return translateInputEDDepartment(oldModel);
		}

		if (oldModelClassName.equals(EDEmployeeClp.class.getName())) {
			return translateInputEDEmployee(oldModel);
		}

		if (oldModelClassName.equals(EDFunctionClp.class.getName())) {
			return translateInputEDFunction(oldModel);
		}

		if (oldModelClassName.equals(EDFunctionDepartmentClp.class.getName())) {
			return translateInputEDFunctionDepartment(oldModel);
		}

		if (oldModelClassName.equals(EDFunctionEmployeeClp.class.getName())) {
			return translateInputEDFunctionEmployee(oldModel);
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

	public static Object translateInputEDDepartment(BaseModel<?> oldModel) {
		EDDepartmentClp oldCplModel = (EDDepartmentClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.edirectory.model.impl.EDDepartmentImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getCreatedDate();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value2 = oldCplModel.getName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setParent",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getParent());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setPhone",
						new Class[] { String.class });

				String value4 = oldCplModel.getPhone();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value5 = oldCplModel.getFax();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLevelEd",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getLevelEd());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value7 = oldCplModel.getEmail();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value8 = oldCplModel.getAddress();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value9 = oldCplModel.getDescription();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setWebsite",
						new Class[] { String.class });

				String value10 = oldCplModel.getWebsite();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setImgurl",
						new Class[] { String.class });

				String value11 = oldCplModel.getImgurl();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getCompanyId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getGroupId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getUserId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setLanguageId",
						new Class[] { String.class });

				String value15 = oldCplModel.getLanguageId();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setDomainId",
						new Class[] { String.class });

				String value16 = oldCplModel.getDomainId();

				method16.invoke(newModel, value16);

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

	public static Object translateInputEDEmployee(BaseModel<?> oldModel) {
		EDEmployeeClp oldCplModel = (EDEmployeeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.edirectory.model.impl.EDEmployeeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getCreatedDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getModifiedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value4 = oldCplModel.getTitle();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value5 = oldCplModel.getName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setBirthday",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getBirthday();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setHomeSide",
						new Class[] { String.class });

				String value7 = oldCplModel.getHomeSide();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setFamily",
						new Class[] { String.class });

				String value8 = oldCplModel.getFamily();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setRace",
						new Class[] { String.class });

				String value9 = oldCplModel.getRace();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setHome",
						new Class[] { String.class });

				String value10 = oldCplModel.getHome();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setHomePhone",
						new Class[] { String.class });

				String value11 = oldCplModel.getHomePhone();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setWorkPhone",
						new Class[] { String.class });

				String value12 = oldCplModel.getWorkPhone();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setMobilePhone",
						new Class[] { String.class });

				String value13 = oldCplModel.getMobilePhone();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value14 = oldCplModel.getEmail();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setDepartmentId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getDepartmentId());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setMajorLevel",
						new Class[] { String.class });

				String value16 = oldCplModel.getMajorLevel();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setPhilosophism",
						new Class[] { String.class });

				String value17 = oldCplModel.getPhilosophism();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setForeignLanguage",
						new Class[] { String.class });

				String value18 = oldCplModel.getForeignLanguage();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setJoinDate",
						new Class[] { Date.class });

				Date value19 = oldCplModel.getJoinDate();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value20 = oldCplModel.getImage();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setIsShowTree",
						new Class[] { Boolean.TYPE });

				Boolean value21 = new Boolean(oldCplModel.getIsShowTree());

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setOtherInfo",
						new Class[] { String.class });

				String value22 = oldCplModel.getOtherInfo();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value23 = new Long(oldCplModel.getCompanyId());

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value24 = new Long(oldCplModel.getGroupId());

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value25 = new Long(oldCplModel.getUserId());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setLanguageId",
						new Class[] { String.class });

				String value26 = oldCplModel.getLanguageId();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setDisplayOrder",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getDisplayOrder());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setSex",
						new Class[] { String.class });

				String value28 = oldCplModel.getSex();

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setStatus",
						new Class[] { Long.TYPE });

				Long value29 = new Long(oldCplModel.getStatus());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setShow",
						new Class[] { String.class });

				String value30 = oldCplModel.getShow();

				method30.invoke(newModel, value30);

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

	public static Object translateInputEDFunction(BaseModel<?> oldModel) {
		EDFunctionClp oldCplModel = (EDFunctionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.edirectory.model.impl.EDFunctionImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getCreatedDate();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value2 = oldCplModel.getName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setLevelEd",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getLevelEd());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setIsShowTree",
						new Class[] { Boolean.TYPE });

				Boolean value4 = new Boolean(oldCplModel.getIsShowTree());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value5 = oldCplModel.getDescription();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getGroupId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getUserId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getCompanyId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setLanguageId",
						new Class[] { String.class });

				String value9 = oldCplModel.getLanguageId();

				method9.invoke(newModel, value9);

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

	public static Object translateInputEDFunctionDepartment(
		BaseModel<?> oldModel) {
		EDFunctionDepartmentClp oldCplModel = (EDFunctionDepartmentClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.edirectory.model.impl.EDFunctionDepartmentImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setFunctionId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getFunctionId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDepartmentId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getDepartmentId());

				method2.invoke(newModel, value2);

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

	public static Object translateInputEDFunctionEmployee(BaseModel<?> oldModel) {
		EDFunctionEmployeeClp oldCplModel = (EDFunctionEmployeeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.edirectory.model.impl.EDFunctionEmployeeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setFunctionId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getFunctionId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setEmployeeId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getEmployeeId());

				method3.invoke(newModel, value3);

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
					"com.vportal.portlet.edirectory.model.impl.EDDepartmentImpl")) {
			return translateOutputEDDepartment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.edirectory.model.impl.EDEmployeeImpl")) {
			return translateOutputEDEmployee(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.edirectory.model.impl.EDFunctionImpl")) {
			return translateOutputEDFunction(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.edirectory.model.impl.EDFunctionDepartmentImpl")) {
			return translateOutputEDFunctionDepartment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.edirectory.model.impl.EDFunctionEmployeeImpl")) {
			return translateOutputEDFunctionEmployee(oldModel);
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

	public static Object translateOutputEDDepartment(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				EDDepartmentClp newModel = new EDDepartmentClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getCreatedDate");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value1);

				Method method2 = oldModelClass.getMethod("getName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setName(value2);

				Method method3 = oldModelClass.getMethod("getParent");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setParent(value3);

				Method method4 = oldModelClass.getMethod("getPhone");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setPhone(value4);

				Method method5 = oldModelClass.getMethod("getFax");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setFax(value5);

				Method method6 = oldModelClass.getMethod("getLevelEd");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setLevelEd(value6);

				Method method7 = oldModelClass.getMethod("getEmail");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setEmail(value7);

				Method method8 = oldModelClass.getMethod("getAddress");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setAddress(value8);

				Method method9 = oldModelClass.getMethod("getDescription");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setDescription(value9);

				Method method10 = oldModelClass.getMethod("getWebsite");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setWebsite(value10);

				Method method11 = oldModelClass.getMethod("getImgurl");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setImgurl(value11);

				Method method12 = oldModelClass.getMethod("getCompanyId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value12);

				Method method13 = oldModelClass.getMethod("getGroupId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value13);

				Method method14 = oldModelClass.getMethod("getUserId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setUserId(value14);

				Method method15 = oldModelClass.getMethod("getLanguageId");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setLanguageId(value15);

				Method method16 = oldModelClass.getMethod("getDomainId");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setDomainId(value16);

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

	public static Object translateOutputEDEmployee(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				EDEmployeeClp newModel = new EDEmployeeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setId(value1);

				Method method2 = oldModelClass.getMethod("getCreatedDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value2);

				Method method3 = oldModelClass.getMethod("getModifiedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value3);

				Method method4 = oldModelClass.getMethod("getTitle");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTitle(value4);

				Method method5 = oldModelClass.getMethod("getName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setName(value5);

				Method method6 = oldModelClass.getMethod("getBirthday");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setBirthday(value6);

				Method method7 = oldModelClass.getMethod("getHomeSide");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setHomeSide(value7);

				Method method8 = oldModelClass.getMethod("getFamily");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setFamily(value8);

				Method method9 = oldModelClass.getMethod("getRace");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setRace(value9);

				Method method10 = oldModelClass.getMethod("getHome");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setHome(value10);

				Method method11 = oldModelClass.getMethod("getHomePhone");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setHomePhone(value11);

				Method method12 = oldModelClass.getMethod("getWorkPhone");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setWorkPhone(value12);

				Method method13 = oldModelClass.getMethod("getMobilePhone");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setMobilePhone(value13);

				Method method14 = oldModelClass.getMethod("getEmail");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setEmail(value14);

				Method method15 = oldModelClass.getMethod("getDepartmentId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setDepartmentId(value15);

				Method method16 = oldModelClass.getMethod("getMajorLevel");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setMajorLevel(value16);

				Method method17 = oldModelClass.getMethod("getPhilosophism");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setPhilosophism(value17);

				Method method18 = oldModelClass.getMethod("getForeignLanguage");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setForeignLanguage(value18);

				Method method19 = oldModelClass.getMethod("getJoinDate");

				Date value19 = (Date)method19.invoke(oldModel, (Object[])null);

				newModel.setJoinDate(value19);

				Method method20 = oldModelClass.getMethod("getImage");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setImage(value20);

				Method method21 = oldModelClass.getMethod("getIsShowTree");

				Boolean value21 = (Boolean)method21.invoke(oldModel,
						(Object[])null);

				newModel.setIsShowTree(value21);

				Method method22 = oldModelClass.getMethod("getOtherInfo");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setOtherInfo(value22);

				Method method23 = oldModelClass.getMethod("getCompanyId");

				Long value23 = (Long)method23.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value23);

				Method method24 = oldModelClass.getMethod("getGroupId");

				Long value24 = (Long)method24.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value24);

				Method method25 = oldModelClass.getMethod("getUserId");

				Long value25 = (Long)method25.invoke(oldModel, (Object[])null);

				newModel.setUserId(value25);

				Method method26 = oldModelClass.getMethod("getLanguageId");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setLanguageId(value26);

				Method method27 = oldModelClass.getMethod("getDisplayOrder");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setDisplayOrder(value27);

				Method method28 = oldModelClass.getMethod("getSex");

				String value28 = (String)method28.invoke(oldModel,
						(Object[])null);

				newModel.setSex(value28);

				Method method29 = oldModelClass.getMethod("getStatus");

				Long value29 = (Long)method29.invoke(oldModel, (Object[])null);

				newModel.setStatus(value29);

				Method method30 = oldModelClass.getMethod("getShow");

				String value30 = (String)method30.invoke(oldModel,
						(Object[])null);

				newModel.setShow(value30);

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

	public static Object translateOutputEDFunction(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				EDFunctionClp newModel = new EDFunctionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getCreatedDate");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value1);

				Method method2 = oldModelClass.getMethod("getName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setName(value2);

				Method method3 = oldModelClass.getMethod("getLevelEd");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setLevelEd(value3);

				Method method4 = oldModelClass.getMethod("getIsShowTree");

				Boolean value4 = (Boolean)method4.invoke(oldModel,
						(Object[])null);

				newModel.setIsShowTree(value4);

				Method method5 = oldModelClass.getMethod("getDescription");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setDescription(value5);

				Method method6 = oldModelClass.getMethod("getGroupId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value6);

				Method method7 = oldModelClass.getMethod("getUserId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setUserId(value7);

				Method method8 = oldModelClass.getMethod("getCompanyId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value8);

				Method method9 = oldModelClass.getMethod("getLanguageId");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setLanguageId(value9);

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

	public static Object translateOutputEDFunctionDepartment(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				EDFunctionDepartmentClp newModel = new EDFunctionDepartmentClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getFunctionId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setFunctionId(value1);

				Method method2 = oldModelClass.getMethod("getDepartmentId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setDepartmentId(value2);

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

	public static Object translateOutputEDFunctionEmployee(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				EDFunctionEmployeeClp newModel = new EDFunctionEmployeeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setId(value1);

				Method method2 = oldModelClass.getMethod("getFunctionId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setFunctionId(value2);

				Method method3 = oldModelClass.getMethod("getEmployeeId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setEmployeeId(value3);

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