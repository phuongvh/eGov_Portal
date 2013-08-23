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

package com.vportal.portlet.vadvman.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vadvman.model.AdvItemClp;
import com.vportal.portlet.vadvman.model.AdvTypeClp;

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
						"VAdv-portlet-deployment-context");

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
							"VAdv-portlet-deployment-context");

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
				_servletContextName = "VAdv-portlet";
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

		if (oldModelClassName.equals(AdvItemClp.class.getName())) {
			return translateInputAdvItem(oldModel);
		}

		if (oldModelClassName.equals(AdvTypeClp.class.getName())) {
			return translateInputAdvType(oldModel);
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

	public static Object translateInputAdvItem(BaseModel<?> oldModel) {
		AdvItemClp oldCplModel = (AdvItemClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vadvman.model.impl.AdvItemImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setItemId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getItemId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getCreateDate();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getModifiedDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setExpriedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getExpriedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getGroupId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCompanyId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value6 = oldCplModel.getName();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value7 = oldCplModel.getDescription();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setUrl",
						new Class[] { String.class });

				String value8 = oldCplModel.getUrl();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setIsTargetBlank",
						new Class[] { Boolean.TYPE });

				Boolean value9 = new Boolean(oldCplModel.getIsTargetBlank());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTxtMouseOver",
						new Class[] { String.class });

				String value10 = oldCplModel.getTxtMouseOver();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setFolderId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getFolderId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setStatus",
						new Class[] { Boolean.TYPE });

				Boolean value12 = new Boolean(oldCplModel.getStatus());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setTypeId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getTypeId());

				method13.invoke(newModel, value13);

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

	public static Object translateInputAdvType(BaseModel<?> oldModel) {
		AdvTypeClp oldCplModel = (AdvTypeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vadvman.model.impl.AdvTypeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setTypeId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getTypeId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getCreateDate();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getModifiedDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getGroupId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getCompanyId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value5 = oldCplModel.getName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value6 = oldCplModel.getDescription();

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
					"com.vportal.portlet.vadvman.model.impl.AdvItemImpl")) {
			return translateOutputAdvItem(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vadvman.model.impl.AdvTypeImpl")) {
			return translateOutputAdvType(oldModel);
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

	public static Object translateOutputAdvItem(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AdvItemClp newModel = new AdvItemClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getItemId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setItemId(value0);

				Method method1 = oldModelClass.getMethod("getCreateDate");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value1);

				Method method2 = oldModelClass.getMethod("getModifiedDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value2);

				Method method3 = oldModelClass.getMethod("getExpriedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setExpriedDate(value3);

				Method method4 = oldModelClass.getMethod("getGroupId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value4);

				Method method5 = oldModelClass.getMethod("getCompanyId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value5);

				Method method6 = oldModelClass.getMethod("getName");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setName(value6);

				Method method7 = oldModelClass.getMethod("getDescription");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setDescription(value7);

				Method method8 = oldModelClass.getMethod("getUrl");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setUrl(value8);

				Method method9 = oldModelClass.getMethod("getIsTargetBlank");

				Boolean value9 = (Boolean)method9.invoke(oldModel,
						(Object[])null);

				newModel.setIsTargetBlank(value9);

				Method method10 = oldModelClass.getMethod("getTxtMouseOver");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setTxtMouseOver(value10);

				Method method11 = oldModelClass.getMethod("getFolderId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setFolderId(value11);

				Method method12 = oldModelClass.getMethod("getStatus");

				Boolean value12 = (Boolean)method12.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value12);

				Method method13 = oldModelClass.getMethod("getTypeId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setTypeId(value13);

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

	public static Object translateOutputAdvType(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AdvTypeClp newModel = new AdvTypeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getTypeId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setTypeId(value0);

				Method method1 = oldModelClass.getMethod("getCreateDate");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value1);

				Method method2 = oldModelClass.getMethod("getModifiedDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value2);

				Method method3 = oldModelClass.getMethod("getGroupId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value3);

				Method method4 = oldModelClass.getMethod("getCompanyId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value4);

				Method method5 = oldModelClass.getMethod("getName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setName(value5);

				Method method6 = oldModelClass.getMethod("getDescription");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setDescription(value6);

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