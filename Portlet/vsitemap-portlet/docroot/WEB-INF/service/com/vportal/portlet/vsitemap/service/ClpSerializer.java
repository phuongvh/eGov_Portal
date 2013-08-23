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

package com.vportal.portlet.vsitemap.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vsitemap.model.VsmBranchClp;

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
						"vsitemap-portlet-deployment-context");

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
							"vsitemap-portlet-deployment-context");

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
				_servletContextName = "vsitemap-portlet";
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

		if (oldModelClassName.equals(VsmBranchClp.class.getName())) {
			return translateInputVsmBranch(oldModel);
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

	public static Object translateInputVsmBranch(BaseModel<?> oldModel) {
		VsmBranchClp oldCplModel = (VsmBranchClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vsitemap.model.impl.VsmBranchImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setBranchId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getBranchId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreatedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getCreatedByUser());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getModifiedByUser());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setParentId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getParentId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value8 = oldCplModel.getName();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value9 = oldCplModel.getDescription();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setAnchored",
						new Class[] { Boolean.TYPE });

				Boolean value10 = new Boolean(oldCplModel.getAnchored());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setHref",
						new Class[] { String.class });

				String value11 = oldCplModel.getHref();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value12 = oldCplModel.getLanguage();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setHasIcon",
						new Class[] { Boolean.TYPE });

				Boolean value13 = new Boolean(oldCplModel.getHasIcon());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setIcon",
						new Class[] { String.class });

				String value14 = oldCplModel.getIcon();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setPosition",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getPosition());

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
					"com.vportal.portlet.vsitemap.model.impl.VsmBranchImpl")) {
			return translateOutputVsmBranch(oldModel);
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

	public static Object translateOutputVsmBranch(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VsmBranchClp newModel = new VsmBranchClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getBranchId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setBranchId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getCreatedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value3);

				Method method4 = oldModelClass.getMethod("getCreatedByUser");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedByUser");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value6);

				Method method7 = oldModelClass.getMethod("getParentId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setParentId(value7);

				Method method8 = oldModelClass.getMethod("getName");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setName(value8);

				Method method9 = oldModelClass.getMethod("getDescription");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setDescription(value9);

				Method method10 = oldModelClass.getMethod("getAnchored");

				Boolean value10 = (Boolean)method10.invoke(oldModel,
						(Object[])null);

				newModel.setAnchored(value10);

				Method method11 = oldModelClass.getMethod("getHref");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setHref(value11);

				Method method12 = oldModelClass.getMethod("getLanguage");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value12);

				Method method13 = oldModelClass.getMethod("getHasIcon");

				Boolean value13 = (Boolean)method13.invoke(oldModel,
						(Object[])null);

				newModel.setHasIcon(value13);

				Method method14 = oldModelClass.getMethod("getIcon");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setIcon(value14);

				Method method15 = oldModelClass.getMethod("getPosition");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setPosition(value15);

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