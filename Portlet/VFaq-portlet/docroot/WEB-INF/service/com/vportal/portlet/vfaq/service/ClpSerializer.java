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

package com.vportal.portlet.vfaq.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vfaq.model.FAQAnswerClp;
import com.vportal.portlet.vfaq.model.FAQCategoryClp;
import com.vportal.portlet.vfaq.model.FAQCategoryQuestionClp;
import com.vportal.portlet.vfaq.model.FAQCommentClp;
import com.vportal.portlet.vfaq.model.FAQQuestionClp;

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
						"VFaq-portlet-deployment-context");

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
							"VFaq-portlet-deployment-context");

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
				_servletContextName = "VFaq-portlet";
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

		if (oldModelClassName.equals(FAQAnswerClp.class.getName())) {
			return translateInputFAQAnswer(oldModel);
		}

		if (oldModelClassName.equals(FAQCategoryClp.class.getName())) {
			return translateInputFAQCategory(oldModel);
		}

		if (oldModelClassName.equals(FAQCategoryQuestionClp.class.getName())) {
			return translateInputFAQCategoryQuestion(oldModel);
		}

		if (oldModelClassName.equals(FAQCommentClp.class.getName())) {
			return translateInputFAQComment(oldModel);
		}

		if (oldModelClassName.equals(FAQQuestionClp.class.getName())) {
			return translateInputFAQQuestion(oldModel);
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

	public static Object translateInputFAQAnswer(BaseModel<?> oldModel) {
		FAQAnswerClp oldCplModel = (FAQAnswerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vfaq.model.impl.FAQAnswerImpl",
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

				Method method2 = newModelClass.getMethod("setQuestionid",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getQuestionid());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value3 = oldCplModel.getContent();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setAnswerOrder",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getAnswerOrder());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setAnsweredByUser",
						new Class[] { String.class });

				String value5 = oldCplModel.getAnsweredByUser();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setAnsweredDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getAnsweredDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value7 = oldCplModel.getModifiedByUser();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value8 = oldCplModel.getLanguage();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getModifiedDate();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setApproved",
						new Class[] { Boolean.TYPE });

				Boolean value10 = new Boolean(oldCplModel.getApproved());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setApprovedByUser",
						new Class[] { String.class });

				String value11 = oldCplModel.getApprovedByUser();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setApprovedDate",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getApprovedDate();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getUserId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setAttachName",
						new Class[] { String.class });

				String value14 = oldCplModel.getAttachName();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setFolderId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getFolderId());

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

	public static Object translateInputFAQCategory(BaseModel<?> oldModel) {
		FAQCategoryClp oldCplModel = (FAQCategoryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vfaq.model.impl.FAQCategoryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value3 = oldCplModel.getLanguage();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setParent",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getParent());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCatorder",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCatorder());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCatlevel",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getCatlevel());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value7 = oldCplModel.getImage();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value8 = oldCplModel.getCreatedByUser();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getCreatedDate();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value10 = oldCplModel.getModifiedByUser();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getModifiedDate();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getGroupId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getUserId());

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

	public static Object translateInputFAQCategoryQuestion(
		BaseModel<?> oldModel) {
		FAQCategoryQuestionClp oldCplModel = (FAQCategoryQuestionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vfaq.model.impl.FAQCategoryQuestionImpl",
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

				Method method2 = newModelClass.getMethod("setQuestionId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getQuestionId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCategoryId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCategoryId());

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

	public static Object translateInputFAQComment(BaseModel<?> oldModel) {
		FAQCommentClp oldCplModel = (FAQCommentClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vfaq.model.impl.FAQCommentImpl",
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

				Method method2 = newModelClass.getMethod("setAnswerid",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getAnswerid());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value3 = oldCplModel.getContent();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCommName",
						new Class[] { String.class });

				String value4 = oldCplModel.getCommName();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCommEmail",
						new Class[] { String.class });

				String value5 = oldCplModel.getCommEmail();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setApproved",
						new Class[] { Boolean.TYPE });

				Boolean value6 = new Boolean(oldCplModel.getApproved());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setApproveByUser",
						new Class[] { String.class });

				String value7 = oldCplModel.getApproveByUser();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setApprovedDate",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getApprovedDate();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCommDate",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getCommDate();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getUserId());

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

	public static Object translateInputFAQQuestion(BaseModel<?> oldModel) {
		FAQQuestionClp oldCplModel = (FAQQuestionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vfaq.model.impl.FAQQuestionImpl",
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

				Method method2 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value2 = oldCplModel.getTitle();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value3 = oldCplModel.getContent();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value4 = oldCplModel.getLanguage();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setQuestionOrder",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getQuestionOrder());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setSentDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getSentDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setSentByUser",
						new Class[] { String.class });

				String value7 = oldCplModel.getSentByUser();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setSenderEmail",
						new Class[] { String.class });

				String value8 = oldCplModel.getSenderEmail();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setQuestionType",
						new Class[] { String.class });

				String value9 = oldCplModel.getQuestionType();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value10 = oldCplModel.getModifiedByUser();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getModifiedDate();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setHitCount",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getHitCount());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setApproved",
						new Class[] { Boolean.TYPE });

				Boolean value13 = new Boolean(oldCplModel.getApproved());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getGroupId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getUserId());

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
					"com.vportal.portlet.vfaq.model.impl.FAQAnswerImpl")) {
			return translateOutputFAQAnswer(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vfaq.model.impl.FAQCategoryImpl")) {
			return translateOutputFAQCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vfaq.model.impl.FAQCategoryQuestionImpl")) {
			return translateOutputFAQCategoryQuestion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vfaq.model.impl.FAQCommentImpl")) {
			return translateOutputFAQComment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vfaq.model.impl.FAQQuestionImpl")) {
			return translateOutputFAQQuestion(oldModel);
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

	public static Object translateOutputFAQAnswer(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FAQAnswerClp newModel = new FAQAnswerClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setId(value1);

				Method method2 = oldModelClass.getMethod("getQuestionid");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setQuestionid(value2);

				Method method3 = oldModelClass.getMethod("getContent");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setContent(value3);

				Method method4 = oldModelClass.getMethod("getAnswerOrder");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setAnswerOrder(value4);

				Method method5 = oldModelClass.getMethod("getAnsweredByUser");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setAnsweredByUser(value5);

				Method method6 = oldModelClass.getMethod("getAnsweredDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setAnsweredDate(value6);

				Method method7 = oldModelClass.getMethod("getModifiedByUser");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value7);

				Method method8 = oldModelClass.getMethod("getLanguage");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setLanguage(value8);

				Method method9 = oldModelClass.getMethod("getModifiedDate");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value9);

				Method method10 = oldModelClass.getMethod("getApproved");

				Boolean value10 = (Boolean)method10.invoke(oldModel,
						(Object[])null);

				newModel.setApproved(value10);

				Method method11 = oldModelClass.getMethod("getApprovedByUser");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setApprovedByUser(value11);

				Method method12 = oldModelClass.getMethod("getApprovedDate");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setApprovedDate(value12);

				Method method13 = oldModelClass.getMethod("getUserId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setUserId(value13);

				Method method14 = oldModelClass.getMethod("getAttachName");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setAttachName(value14);

				Method method15 = oldModelClass.getMethod("getFolderId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setFolderId(value15);

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

	public static Object translateOutputFAQCategory(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FAQCategoryClp newModel = new FAQCategoryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getLanguage");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setLanguage(value3);

				Method method4 = oldModelClass.getMethod("getParent");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setParent(value4);

				Method method5 = oldModelClass.getMethod("getCatorder");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCatorder(value5);

				Method method6 = oldModelClass.getMethod("getCatlevel");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setCatlevel(value6);

				Method method7 = oldModelClass.getMethod("getImage");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setImage(value7);

				Method method8 = oldModelClass.getMethod("getCreatedByUser");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value8);

				Method method9 = oldModelClass.getMethod("getCreatedDate");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value9);

				Method method10 = oldModelClass.getMethod("getModifiedByUser");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setModifiedByUser(value10);

				Method method11 = oldModelClass.getMethod("getModifiedDate");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value11);

				Method method12 = oldModelClass.getMethod("getGroupId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value12);

				Method method13 = oldModelClass.getMethod("getUserId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setUserId(value13);

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

	public static Object translateOutputFAQCategoryQuestion(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FAQCategoryQuestionClp newModel = new FAQCategoryQuestionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setId(value1);

				Method method2 = oldModelClass.getMethod("getQuestionId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setQuestionId(value2);

				Method method3 = oldModelClass.getMethod("getCategoryId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value3);

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

	public static Object translateOutputFAQComment(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FAQCommentClp newModel = new FAQCommentClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setId(value1);

				Method method2 = oldModelClass.getMethod("getAnswerid");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setAnswerid(value2);

				Method method3 = oldModelClass.getMethod("getContent");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setContent(value3);

				Method method4 = oldModelClass.getMethod("getCommName");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCommName(value4);

				Method method5 = oldModelClass.getMethod("getCommEmail");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setCommEmail(value5);

				Method method6 = oldModelClass.getMethod("getApproved");

				Boolean value6 = (Boolean)method6.invoke(oldModel,
						(Object[])null);

				newModel.setApproved(value6);

				Method method7 = oldModelClass.getMethod("getApproveByUser");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setApproveByUser(value7);

				Method method8 = oldModelClass.getMethod("getApprovedDate");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setApprovedDate(value8);

				Method method9 = oldModelClass.getMethod("getCommDate");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setCommDate(value9);

				Method method10 = oldModelClass.getMethod("getUserId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setUserId(value10);

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

	public static Object translateOutputFAQQuestion(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FAQQuestionClp newModel = new FAQQuestionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setId(value1);

				Method method2 = oldModelClass.getMethod("getTitle");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTitle(value2);

				Method method3 = oldModelClass.getMethod("getContent");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setContent(value3);

				Method method4 = oldModelClass.getMethod("getLanguage");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setLanguage(value4);

				Method method5 = oldModelClass.getMethod("getQuestionOrder");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setQuestionOrder(value5);

				Method method6 = oldModelClass.getMethod("getSentDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setSentDate(value6);

				Method method7 = oldModelClass.getMethod("getSentByUser");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setSentByUser(value7);

				Method method8 = oldModelClass.getMethod("getSenderEmail");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setSenderEmail(value8);

				Method method9 = oldModelClass.getMethod("getQuestionType");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setQuestionType(value9);

				Method method10 = oldModelClass.getMethod("getModifiedByUser");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setModifiedByUser(value10);

				Method method11 = oldModelClass.getMethod("getModifiedDate");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value11);

				Method method12 = oldModelClass.getMethod("getHitCount");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setHitCount(value12);

				Method method13 = oldModelClass.getMethod("getApproved");

				Boolean value13 = (Boolean)method13.invoke(oldModel,
						(Object[])null);

				newModel.setApproved(value13);

				Method method14 = oldModelClass.getMethod("getGroupId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value14);

				Method method15 = oldModelClass.getMethod("getUserId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setUserId(value15);

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