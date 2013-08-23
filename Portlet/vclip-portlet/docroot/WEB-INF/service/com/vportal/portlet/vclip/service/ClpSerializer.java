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

package com.vportal.portlet.vclip.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vclip.model.ClipClp;
import com.vportal.portlet.vclip.model.ClipTypeClp;

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
						"vclip-portlet-deployment-context");

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
							"vclip-portlet-deployment-context");

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
				_servletContextName = "vclip-portlet";
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

		if (oldModelClassName.equals(ClipClp.class.getName())) {
			return translateInputClip(oldModel);
		}

		if (oldModelClassName.equals(ClipTypeClp.class.getName())) {
			return translateInputClipType(oldModel);
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

	public static Object translateInputClip(BaseModel<?> oldModel) {
		ClipClp oldCplModel = (ClipClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vclip.model.impl.ClipImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { String.class });

				String value0 = oldCplModel.getId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setClipTypeId",
						new Class[] { String.class });

				String value1 = oldCplModel.getClipTypeId();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getGroupId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getCreatedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getModifiedDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setUrl",
						new Class[] { String.class });

				String value7 = oldCplModel.getUrl();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value8 = oldCplModel.getName();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value9 = oldCplModel.getTitle();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value10 = oldCplModel.getImage();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value11 = oldCplModel.getDescription();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setActive",
						new Class[] { Boolean.TYPE });

				Boolean value12 = new Boolean(oldCplModel.getActive());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value13 = oldCplModel.getLanguage();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setHitcount",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getHitcount());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setHitcountview",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getHitcountview());

				method15.invoke(newModel, value15);

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

	public static Object translateInputClipType(BaseModel<?> oldModel) {
		ClipTypeClp oldCplModel = (ClipTypeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vclip.model.impl.ClipTypeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { String.class });

				String value0 = oldCplModel.getId();

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

				Method method6 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value6 = oldCplModel.getTitle();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value7 = oldCplModel.getName();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value8 = oldCplModel.getDescription();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setActive",
						new Class[] { Boolean.TYPE });

				Boolean value9 = new Boolean(oldCplModel.getActive());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value10 = oldCplModel.getLanguage();

				method10.invoke(newModel, value10);

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
					"com.vportal.portlet.vclip.model.impl.ClipImpl")) {
			return translateOutputClip(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vclip.model.impl.ClipTypeImpl")) {
			return translateOutputClipType(oldModel);
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

	public static Object translateOutputClip(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ClipClp newModel = new ClipClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getClipTypeId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setClipTypeId(value1);

				Method method2 = oldModelClass.getMethod("getGroupId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				Method method5 = oldModelClass.getMethod("getCreatedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value6);

				Method method7 = oldModelClass.getMethod("getUrl");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setUrl(value7);

				Method method8 = oldModelClass.getMethod("getName");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setName(value8);

				Method method9 = oldModelClass.getMethod("getTitle");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTitle(value9);

				Method method10 = oldModelClass.getMethod("getImage");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setImage(value10);

				Method method11 = oldModelClass.getMethod("getDescription");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setDescription(value11);

				Method method12 = oldModelClass.getMethod("getActive");

				Boolean value12 = (Boolean)method12.invoke(oldModel,
						(Object[])null);

				newModel.setActive(value12);

				Method method13 = oldModelClass.getMethod("getLanguage");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value13);

				Method method14 = oldModelClass.getMethod("getHitcount");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setHitcount(value14);

				Method method15 = oldModelClass.getMethod("getHitcountview");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setHitcountview(value15);

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

	public static Object translateOutputClipType(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ClipTypeClp newModel = new ClipTypeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

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

				Method method6 = oldModelClass.getMethod("getTitle");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setTitle(value6);

				Method method7 = oldModelClass.getMethod("getName");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setName(value7);

				Method method8 = oldModelClass.getMethod("getDescription");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setDescription(value8);

				Method method9 = oldModelClass.getMethod("getActive");

				Boolean value9 = (Boolean)method9.invoke(oldModel,
						(Object[])null);

				newModel.setActive(value9);

				Method method10 = oldModelClass.getMethod("getLanguage");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value10);

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