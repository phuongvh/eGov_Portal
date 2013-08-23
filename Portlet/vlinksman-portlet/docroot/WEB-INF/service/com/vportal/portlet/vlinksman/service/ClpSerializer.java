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

package com.vportal.portlet.vlinksman.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vlinksman.model.LinkGroupClp;
import com.vportal.portlet.vlinksman.model.LinksClp;

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
						"vlinksman-portlet-deployment-context");

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
							"vlinksman-portlet-deployment-context");

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
				_servletContextName = "vlinksman-portlet";
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

		if (oldModelClassName.equals(LinkGroupClp.class.getName())) {
			return translateInputLinkGroup(oldModel);
		}

		if (oldModelClassName.equals(LinksClp.class.getName())) {
			return translateInputLinks(oldModel);
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

	public static Object translateInputLinkGroup(BaseModel<?> oldModel) {
		LinkGroupClp oldCplModel = (LinkGroupClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vlinksman.model.impl.LinkGroupImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setLinkgroupId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getLinkgroupId());

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

				Method method4 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getModifiedDate();

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

	public static Object translateInputLinks(BaseModel<?> oldModel) {
		LinksClp oldCplModel = (LinksClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vlinksman.model.impl.LinksImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setLinkId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getLinkId());

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

				Method method4 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getModifiedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setLinkgroupId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getLinkgroupId());

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

				Method method9 = newModelClass.getMethod("setPosition",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getPosition());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setHasImage",
						new Class[] { Boolean.TYPE });

				Boolean value10 = new Boolean(oldCplModel.getHasImage());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setIsTargetBlank",
						new Class[] { Boolean.TYPE });

				Boolean value11 = new Boolean(oldCplModel.getIsTargetBlank());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setImageName",
						new Class[] { String.class });

				String value12 = oldCplModel.getImageName();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setFolderId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getFolderId());

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
					"com.vportal.portlet.vlinksman.model.impl.LinkGroupImpl")) {
			return translateOutputLinkGroup(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vlinksman.model.impl.LinksImpl")) {
			return translateOutputLinks(oldModel);
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

	public static Object translateOutputLinkGroup(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LinkGroupClp newModel = new LinkGroupClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getLinkgroupId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setLinkgroupId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getCreatedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value3);

				Method method4 = oldModelClass.getMethod("getModifiedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value4);

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

	public static Object translateOutputLinks(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LinksClp newModel = new LinksClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getLinkId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setLinkId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getCreatedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value3);

				Method method4 = oldModelClass.getMethod("getModifiedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value4);

				Method method5 = oldModelClass.getMethod("getLinkgroupId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setLinkgroupId(value5);

				Method method6 = oldModelClass.getMethod("getName");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setName(value6);

				Method method7 = oldModelClass.getMethod("getDescription");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setDescription(value7);

				Method method8 = oldModelClass.getMethod("getUrl");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setUrl(value8);

				Method method9 = oldModelClass.getMethod("getPosition");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setPosition(value9);

				Method method10 = oldModelClass.getMethod("getHasImage");

				Boolean value10 = (Boolean)method10.invoke(oldModel,
						(Object[])null);

				newModel.setHasImage(value10);

				Method method11 = oldModelClass.getMethod("getIsTargetBlank");

				Boolean value11 = (Boolean)method11.invoke(oldModel,
						(Object[])null);

				newModel.setIsTargetBlank(value11);

				Method method12 = oldModelClass.getMethod("getImageName");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setImageName(value12);

				Method method13 = oldModelClass.getMethod("getFolderId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setFolderId(value13);

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