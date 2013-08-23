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

package com.vportal.portlet.vcalendar.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vcalendar.model.VCalClp;
import com.vportal.portlet.vcalendar.model.VFileClp;

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
						"VCalendar-portlet-deployment-context");

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
							"VCalendar-portlet-deployment-context");

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
				_servletContextName = "VCalendar-portlet";
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

		if (oldModelClassName.equals(VCalClp.class.getName())) {
			return translateInputVCal(oldModel);
		}

		if (oldModelClassName.equals(VFileClp.class.getName())) {
			return translateInputVFile(oldModel);
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

	public static Object translateInputVCal(BaseModel<?> oldModel) {
		VCalClp oldCplModel = (VCalClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcalendar.model.impl.VCalImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCalId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCalId());

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

				Method method4 = newModelClass.getMethod("setUserName",
						new Class[] { String.class });

				String value4 = oldCplModel.getUserName();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getCreateDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getModifiedDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLanguageId",
						new Class[] { String.class });

				String value7 = oldCplModel.getLanguageId();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setFileId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getFileId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value9 = oldCplModel.getTitle();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value10 = oldCplModel.getDescription();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setGuest",
						new Class[] { String.class });

				String value11 = oldCplModel.getGuest();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setLocation",
						new Class[] { String.class });

				String value12 = oldCplModel.getLocation();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setTime",
						new Class[] { String.class });

				String value13 = oldCplModel.getTime();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setStartDate",
						new Class[] { Date.class });

				Date value14 = oldCplModel.getStartDate();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setEndDate",
						new Class[] { Date.class });

				Date value15 = oldCplModel.getEndDate();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setStatus",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getStatus());

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

	public static Object translateInputVFile(BaseModel<?> oldModel) {
		VFileClp oldCplModel = (VFileClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcalendar.model.impl.VFileImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setFileId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getFileId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setFullname",
						new Class[] { String.class });

				String value1 = oldCplModel.getFullname();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setPhone",
						new Class[] { String.class });

				String value2 = oldCplModel.getPhone();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value3 = oldCplModel.getAddress();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setBirthday",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getBirthday();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setPosition",
						new Class[] { String.class });

				String value5 = oldCplModel.getPosition();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setStatus",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getStatus());

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
					"com.vportal.portlet.vcalendar.model.impl.VCalImpl")) {
			return translateOutputVCal(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcalendar.model.impl.VFileImpl")) {
			return translateOutputVFile(oldModel);
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

	public static Object translateOutputVCal(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VCalClp newModel = new VCalClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCalId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCalId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getUserName");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setUserName(value4);

				Method method5 = oldModelClass.getMethod("getCreateDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value6);

				Method method7 = oldModelClass.getMethod("getLanguageId");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setLanguageId(value7);

				Method method8 = oldModelClass.getMethod("getFileId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setFileId(value8);

				Method method9 = oldModelClass.getMethod("getTitle");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTitle(value9);

				Method method10 = oldModelClass.getMethod("getDescription");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDescription(value10);

				Method method11 = oldModelClass.getMethod("getGuest");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setGuest(value11);

				Method method12 = oldModelClass.getMethod("getLocation");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setLocation(value12);

				Method method13 = oldModelClass.getMethod("getTime");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setTime(value13);

				Method method14 = oldModelClass.getMethod("getStartDate");

				Date value14 = (Date)method14.invoke(oldModel, (Object[])null);

				newModel.setStartDate(value14);

				Method method15 = oldModelClass.getMethod("getEndDate");

				Date value15 = (Date)method15.invoke(oldModel, (Object[])null);

				newModel.setEndDate(value15);

				Method method16 = oldModelClass.getMethod("getStatus");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setStatus(value16);

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

	public static Object translateOutputVFile(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VFileClp newModel = new VFileClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getFileId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setFileId(value0);

				Method method1 = oldModelClass.getMethod("getFullname");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setFullname(value1);

				Method method2 = oldModelClass.getMethod("getPhone");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setPhone(value2);

				Method method3 = oldModelClass.getMethod("getAddress");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setAddress(value3);

				Method method4 = oldModelClass.getMethod("getBirthday");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setBirthday(value4);

				Method method5 = oldModelClass.getMethod("getPosition");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setPosition(value5);

				Method method6 = oldModelClass.getMethod("getStatus");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setStatus(value6);

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