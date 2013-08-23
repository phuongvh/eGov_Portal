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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.vportal.portlet.vcms.model.VcmsArticleClp;
import com.vportal.portlet.vcms.model.VcmsArticleStatusClp;
import com.vportal.portlet.vcms.model.VcmsArticleTypeClp;
import com.vportal.portlet.vcms.model.VcmsArticleVersionClp;
import com.vportal.portlet.vcms.model.VcmsAttachedMessageClp;
import com.vportal.portlet.vcms.model.VcmsCARelationClp;
import com.vportal.portlet.vcms.model.VcmsCategoryClp;
import com.vportal.portlet.vcms.model.VcmsDiscussionClp;
import com.vportal.portlet.vcms.model.VcmsLoggerClp;
import com.vportal.portlet.vcms.model.VcmsPARelationClp;
import com.vportal.portlet.vcms.model.VcmsPortionClp;
import com.vportal.portlet.vcms.model.VcmsStatusClp;
import com.vportal.portlet.vcms.model.VcmsTARelationClp;
import com.vportal.portlet.vcms.model.VcmsThreadClp;
import com.vportal.portlet.vcms.model.VcmsTypeClp;

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
						"VCMS-portlet-deployment-context");

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
							"VCMS-portlet-deployment-context");

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
				_servletContextName = "VCMS-portlet";
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

		if (oldModelClassName.equals(VcmsArticleClp.class.getName())) {
			return translateInputVcmsArticle(oldModel);
		}

		if (oldModelClassName.equals(VcmsArticleStatusClp.class.getName())) {
			return translateInputVcmsArticleStatus(oldModel);
		}

		if (oldModelClassName.equals(VcmsArticleTypeClp.class.getName())) {
			return translateInputVcmsArticleType(oldModel);
		}

		if (oldModelClassName.equals(VcmsArticleVersionClp.class.getName())) {
			return translateInputVcmsArticleVersion(oldModel);
		}

		if (oldModelClassName.equals(VcmsAttachedMessageClp.class.getName())) {
			return translateInputVcmsAttachedMessage(oldModel);
		}

		if (oldModelClassName.equals(VcmsCARelationClp.class.getName())) {
			return translateInputVcmsCARelation(oldModel);
		}

		if (oldModelClassName.equals(VcmsCategoryClp.class.getName())) {
			return translateInputVcmsCategory(oldModel);
		}

		if (oldModelClassName.equals(VcmsDiscussionClp.class.getName())) {
			return translateInputVcmsDiscussion(oldModel);
		}

		if (oldModelClassName.equals(VcmsLoggerClp.class.getName())) {
			return translateInputVcmsLogger(oldModel);
		}

		if (oldModelClassName.equals(VcmsPARelationClp.class.getName())) {
			return translateInputVcmsPARelation(oldModel);
		}

		if (oldModelClassName.equals(VcmsPortionClp.class.getName())) {
			return translateInputVcmsPortion(oldModel);
		}

		if (oldModelClassName.equals(VcmsStatusClp.class.getName())) {
			return translateInputVcmsStatus(oldModel);
		}

		if (oldModelClassName.equals(VcmsTARelationClp.class.getName())) {
			return translateInputVcmsTARelation(oldModel);
		}

		if (oldModelClassName.equals(VcmsThreadClp.class.getName())) {
			return translateInputVcmsThread(oldModel);
		}

		if (oldModelClassName.equals(VcmsTypeClp.class.getName())) {
			return translateInputVcmsType(oldModel);
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

	public static Object translateInputVcmsArticle(BaseModel<?> oldModel) {
		VcmsArticleClp oldCplModel = (VcmsArticleClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsArticleImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value0 = oldCplModel.getArticleId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value3 = oldCplModel.getCreatedByUser();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreatedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value5 = oldCplModel.getModifiedByUser();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getModifiedDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setApprovedByUser",
						new Class[] { String.class });

				String value7 = oldCplModel.getApprovedByUser();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setApprovedDate",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getApprovedDate();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPublishedByUser",
						new Class[] { String.class });

				String value9 = oldCplModel.getPublishedByUser();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setPublishedDate",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getPublishedDate();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setStatus",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getStatus());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value12 = oldCplModel.getTitle();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLead",
						new Class[] { String.class });

				String value13 = oldCplModel.getLead();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value14 = oldCplModel.getContent();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setHasImage",
						new Class[] { Boolean.TYPE });

				Boolean value15 = new Boolean(oldCplModel.getHasImage());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setImageTitle",
						new Class[] { String.class });

				String value16 = oldCplModel.getImageTitle();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value17 = oldCplModel.getImage();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setAuthor",
						new Class[] { String.class });

				String value18 = oldCplModel.getAuthor();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setSource",
						new Class[] { String.class });

				String value19 = oldCplModel.getSource();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value20 = oldCplModel.getLanguage();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setUserHit",
						new Class[] { Long.TYPE });

				Long value21 = new Long(oldCplModel.getUserHit());

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setDiscussible",
						new Class[] { Boolean.TYPE });

				Boolean value22 = new Boolean(oldCplModel.getDiscussible());

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setHasAttachment",
						new Class[] { Boolean.TYPE });

				Boolean value23 = new Boolean(oldCplModel.getHasAttachment());

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setHasPoll",
						new Class[] { Boolean.TYPE });

				Boolean value24 = new Boolean(oldCplModel.getHasPoll());

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setPollId",
						new Class[] { String.class });

				String value25 = oldCplModel.getPollId();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setEffectiveDate",
						new Class[] { Date.class });

				Date value26 = oldCplModel.getEffectiveDate();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setExpireDate",
						new Class[] { Date.class });

				Date value27 = oldCplModel.getExpireDate();

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setSticky",
						new Class[] { Boolean.TYPE });

				Boolean value28 = new Boolean(oldCplModel.getSticky());

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setStickyNeverExpired",
						new Class[] { Boolean.TYPE });

				Boolean value29 = new Boolean(oldCplModel.getStickyNeverExpired());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setStickyExpireDate",
						new Class[] { Date.class });

				Date value30 = oldCplModel.getStickyExpireDate();

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

	public static Object translateInputVcmsArticleStatus(BaseModel<?> oldModel) {
		VcmsArticleStatusClp oldCplModel = (VcmsArticleStatusClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsArticleStatusImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setStatusId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getStatusId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value2 = oldCplModel.getArticleId();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCategoryId",
						new Class[] { String.class });

				String value3 = oldCplModel.getCategoryId();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreatedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value5 = oldCplModel.getCreatedByUser();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setActive",
						new Class[] { Boolean.TYPE });

				Boolean value6 = new Boolean(oldCplModel.getActive());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setArticleVersionId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getArticleVersionId());

				method7.invoke(newModel, value7);

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

	public static Object translateInputVcmsArticleType(BaseModel<?> oldModel) {
		VcmsArticleTypeClp oldCplModel = (VcmsArticleTypeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsArticleTypeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setTypeId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getTypeId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value1 = oldCplModel.getArticleId();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setPosition",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getPosition());

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

	public static Object translateInputVcmsArticleVersion(BaseModel<?> oldModel) {
		VcmsArticleVersionClp oldCplModel = (VcmsArticleVersionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsArticleVersionImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setArticleVersionId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getArticleVersionId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value3 = oldCplModel.getArticleId();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getCreatedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTypeIds",
						new Class[] { String.class });

				String value6 = oldCplModel.getTypeIds();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setStatus",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getStatus());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setVersionName",
						new Class[] { String.class });

				String value8 = oldCplModel.getVersionName();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value9 = oldCplModel.getTitle();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setLead",
						new Class[] { String.class });

				String value10 = oldCplModel.getLead();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value11 = oldCplModel.getContent();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setHasImage",
						new Class[] { Boolean.TYPE });

				Boolean value12 = new Boolean(oldCplModel.getHasImage());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setImageTitle",
						new Class[] { String.class });

				String value13 = oldCplModel.getImageTitle();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value14 = oldCplModel.getImage();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value15 = oldCplModel.getLanguage();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setUserHit",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getUserHit());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setAuthor",
						new Class[] { String.class });

				String value17 = oldCplModel.getAuthor();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setSource",
						new Class[] { String.class });

				String value18 = oldCplModel.getSource();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setDiscussible",
						new Class[] { Boolean.TYPE });

				Boolean value19 = new Boolean(oldCplModel.getDiscussible());

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setHasAttachment",
						new Class[] { Boolean.TYPE });

				Boolean value20 = new Boolean(oldCplModel.getHasAttachment());

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setHasPoll",
						new Class[] { Boolean.TYPE });

				Boolean value21 = new Boolean(oldCplModel.getHasPoll());

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setPollId",
						new Class[] { String.class });

				String value22 = oldCplModel.getPollId();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setEffectiveDate",
						new Class[] { Date.class });

				Date value23 = oldCplModel.getEffectiveDate();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setExpireDate",
						new Class[] { Date.class });

				Date value24 = oldCplModel.getExpireDate();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setSticky",
						new Class[] { Boolean.TYPE });

				Boolean value25 = new Boolean(oldCplModel.getSticky());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setStickyNeverExpired",
						new Class[] { Boolean.TYPE });

				Boolean value26 = new Boolean(oldCplModel.getStickyNeverExpired());

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setStickyExpireDate",
						new Class[] { Date.class });

				Date value27 = oldCplModel.getStickyExpireDate();

				method27.invoke(newModel, value27);

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

	public static Object translateInputVcmsAttachedMessage(
		BaseModel<?> oldModel) {
		VcmsAttachedMessageClp oldCplModel = (VcmsAttachedMessageClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsAttachedMessageImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setMessageId",
						new Class[] { String.class });

				String value0 = oldCplModel.getMessageId();

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
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value5 = oldCplModel.getArticleId();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value6 = oldCplModel.getContent();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setReadMessage",
						new Class[] { Boolean.TYPE });

				Boolean value7 = new Boolean(oldCplModel.getReadMessage());

				method7.invoke(newModel, value7);

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

	public static Object translateInputVcmsCARelation(BaseModel<?> oldModel) {
		VcmsCARelationClp oldCplModel = (VcmsCARelationClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsCARelationImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryId",
						new Class[] { String.class });

				String value0 = oldCplModel.getCategoryId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value1 = oldCplModel.getArticleId();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getCreatedDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value3 = oldCplModel.getCreatedByUser();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setStatus",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getStatus());

				method4.invoke(newModel, value4);

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

	public static Object translateInputVcmsCategory(BaseModel<?> oldModel) {
		VcmsCategoryClp oldCplModel = (VcmsCategoryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsCategoryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryId",
						new Class[] { String.class });

				String value0 = oldCplModel.getCategoryId();

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
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value6 = oldCplModel.getModifiedByUser();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setPortionId",
						new Class[] { String.class });

				String value7 = oldCplModel.getPortionId();

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

				Method method11 = newModelClass.getMethod("setAnchored",
						new Class[] { Boolean.TYPE });

				Boolean value11 = new Boolean(oldCplModel.getAnchored());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setHref",
						new Class[] { String.class });

				String value12 = oldCplModel.getHref();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value13 = oldCplModel.getLanguage();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setHasImage",
						new Class[] { Boolean.TYPE });

				Boolean value14 = new Boolean(oldCplModel.getHasImage());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value15 = oldCplModel.getImage();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setPosition",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getPosition());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setUserHit",
						new Class[] { Long.TYPE });

				Long value17 = new Long(oldCplModel.getUserHit());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setRssable",
						new Class[] { Boolean.TYPE });

				Boolean value18 = new Boolean(oldCplModel.getRssable());

				method18.invoke(newModel, value18);

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

	public static Object translateInputVcmsDiscussion(BaseModel<?> oldModel) {
		VcmsDiscussionClp oldCplModel = (VcmsDiscussionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsDiscussionImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setDiscussionId",
						new Class[] { String.class });

				String value0 = oldCplModel.getDiscussionId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setVisitorName",
						new Class[] { String.class });

				String value3 = oldCplModel.getVisitorName();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setVisitorEmail",
						new Class[] { String.class });

				String value4 = oldCplModel.getVisitorEmail();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setVisitorPhone",
						new Class[] { String.class });

				String value5 = oldCplModel.getVisitorPhone();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setPostedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getPostedDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setApproved",
						new Class[] { Boolean.TYPE });

				Boolean value7 = new Boolean(oldCplModel.getApproved());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setApprovedByUser",
						new Class[] { String.class });

				String value8 = oldCplModel.getApprovedByUser();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setApprovedDate",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getApprovedDate();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value10 = oldCplModel.getArticleId();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value11 = oldCplModel.getTitle();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value12 = oldCplModel.getContent();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value13 = oldCplModel.getLanguage();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setHasAttachment",
						new Class[] { Boolean.TYPE });

				Boolean value14 = new Boolean(oldCplModel.getHasAttachment());

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

	public static Object translateInputVcmsLogger(BaseModel<?> oldModel) {
		VcmsLoggerClp oldCplModel = (VcmsLoggerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsLoggerImpl",
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

				Method method3 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreatedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value5 = oldCplModel.getContent();

				method5.invoke(newModel, value5);

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

	public static Object translateInputVcmsPARelation(BaseModel<?> oldModel) {
		VcmsPARelationClp oldCplModel = (VcmsPARelationClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsPARelationImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPortionId",
						new Class[] { String.class });

				String value0 = oldCplModel.getPortionId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value1 = oldCplModel.getArticleId();

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

	public static Object translateInputVcmsPortion(BaseModel<?> oldModel) {
		VcmsPortionClp oldCplModel = (VcmsPortionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsPortionImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPortionId",
						new Class[] { String.class });

				String value0 = oldCplModel.getPortionId();

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
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value6 = oldCplModel.getModifiedByUser();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCode",
						new Class[] { String.class });

				String value7 = oldCplModel.getCode();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value8 = oldCplModel.getName();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value9 = oldCplModel.getDescription();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setCategorizable",
						new Class[] { Boolean.TYPE });

				Boolean value10 = new Boolean(oldCplModel.getCategorizable());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value11 = oldCplModel.getLanguage();

				method11.invoke(newModel, value11);

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

	public static Object translateInputVcmsStatus(BaseModel<?> oldModel) {
		VcmsStatusClp oldCplModel = (VcmsStatusClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsStatusImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setStatusId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getStatusId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCompanyId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getGroupId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreatedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreatedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreatedByUser",
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value6 = oldCplModel.getModifiedByUser();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value7 = oldCplModel.getName();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value8 = oldCplModel.getDescription();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCssClass",
						new Class[] { String.class });

				String value9 = oldCplModel.getCssClass();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTextColor",
						new Class[] { String.class });

				String value10 = oldCplModel.getTextColor();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setPosition",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getPosition());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setIsPrimary",
						new Class[] { Boolean.TYPE });

				Boolean value12 = new Boolean(oldCplModel.getIsPrimary());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setActive",
						new Class[] { Boolean.TYPE });

				Boolean value13 = new Boolean(oldCplModel.getActive());

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

	public static Object translateInputVcmsTARelation(BaseModel<?> oldModel) {
		VcmsTARelationClp oldCplModel = (VcmsTARelationClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsTARelationImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setThreadId",
						new Class[] { String.class });

				String value0 = oldCplModel.getThreadId();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setArticleId",
						new Class[] { String.class });

				String value1 = oldCplModel.getArticleId();

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

	public static Object translateInputVcmsThread(BaseModel<?> oldModel) {
		VcmsThreadClp oldCplModel = (VcmsThreadClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsThreadImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setThreadId",
						new Class[] { String.class });

				String value0 = oldCplModel.getThreadId();

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
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value6 = oldCplModel.getModifiedByUser();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value7 = oldCplModel.getTitle();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value8 = oldCplModel.getDescription();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setHasImage",
						new Class[] { Boolean.TYPE });

				Boolean value9 = new Boolean(oldCplModel.getHasImage());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value10 = oldCplModel.getImage();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setLanguage",
						new Class[] { String.class });

				String value11 = oldCplModel.getLanguage();

				method11.invoke(newModel, value11);

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

	public static Object translateInputVcmsType(BaseModel<?> oldModel) {
		VcmsTypeClp oldCplModel = (VcmsTypeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.vportal.portlet.vcms.model.impl.VcmsTypeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setTypeId",
						new Class[] { String.class });

				String value0 = oldCplModel.getTypeId();

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
						new Class[] { String.class });

				String value4 = oldCplModel.getCreatedByUser();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedByUser",
						new Class[] { String.class });

				String value6 = oldCplModel.getModifiedByUser();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCode",
						new Class[] { String.class });

				String value7 = oldCplModel.getCode();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value8 = oldCplModel.getName();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value9 = oldCplModel.getDescription();

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
					"com.vportal.portlet.vcms.model.impl.VcmsArticleImpl")) {
			return translateOutputVcmsArticle(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsArticleStatusImpl")) {
			return translateOutputVcmsArticleStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsArticleTypeImpl")) {
			return translateOutputVcmsArticleType(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsArticleVersionImpl")) {
			return translateOutputVcmsArticleVersion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsAttachedMessageImpl")) {
			return translateOutputVcmsAttachedMessage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsCARelationImpl")) {
			return translateOutputVcmsCARelation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsCategoryImpl")) {
			return translateOutputVcmsCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsDiscussionImpl")) {
			return translateOutputVcmsDiscussion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsLoggerImpl")) {
			return translateOutputVcmsLogger(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsPARelationImpl")) {
			return translateOutputVcmsPARelation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsPortionImpl")) {
			return translateOutputVcmsPortion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsStatusImpl")) {
			return translateOutputVcmsStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsTARelationImpl")) {
			return translateOutputVcmsTARelation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsThreadImpl")) {
			return translateOutputVcmsThread(oldModel);
		}

		if (oldModelClassName.equals(
					"com.vportal.portlet.vcms.model.impl.VcmsTypeImpl")) {
			return translateOutputVcmsType(oldModel);
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

	public static Object translateOutputVcmsArticle(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsArticleClp newModel = new VcmsArticleClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getArticleId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getCreatedByUser");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value3);

				Method method4 = oldModelClass.getMethod("getCreatedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value4);

				Method method5 = oldModelClass.getMethod("getModifiedByUser");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value5);

				Method method6 = oldModelClass.getMethod("getModifiedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value6);

				Method method7 = oldModelClass.getMethod("getApprovedByUser");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setApprovedByUser(value7);

				Method method8 = oldModelClass.getMethod("getApprovedDate");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setApprovedDate(value8);

				Method method9 = oldModelClass.getMethod("getPublishedByUser");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setPublishedByUser(value9);

				Method method10 = oldModelClass.getMethod("getPublishedDate");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setPublishedDate(value10);

				Method method11 = oldModelClass.getMethod("getStatus");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setStatus(value11);

				Method method12 = oldModelClass.getMethod("getTitle");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setTitle(value12);

				Method method13 = oldModelClass.getMethod("getLead");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLead(value13);

				Method method14 = oldModelClass.getMethod("getContent");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setContent(value14);

				Method method15 = oldModelClass.getMethod("getHasImage");

				Boolean value15 = (Boolean)method15.invoke(oldModel,
						(Object[])null);

				newModel.setHasImage(value15);

				Method method16 = oldModelClass.getMethod("getImageTitle");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setImageTitle(value16);

				Method method17 = oldModelClass.getMethod("getImage");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setImage(value17);

				Method method18 = oldModelClass.getMethod("getAuthor");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setAuthor(value18);

				Method method19 = oldModelClass.getMethod("getSource");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setSource(value19);

				Method method20 = oldModelClass.getMethod("getLanguage");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value20);

				Method method21 = oldModelClass.getMethod("getUserHit");

				Long value21 = (Long)method21.invoke(oldModel, (Object[])null);

				newModel.setUserHit(value21);

				Method method22 = oldModelClass.getMethod("getDiscussible");

				Boolean value22 = (Boolean)method22.invoke(oldModel,
						(Object[])null);

				newModel.setDiscussible(value22);

				Method method23 = oldModelClass.getMethod("getHasAttachment");

				Boolean value23 = (Boolean)method23.invoke(oldModel,
						(Object[])null);

				newModel.setHasAttachment(value23);

				Method method24 = oldModelClass.getMethod("getHasPoll");

				Boolean value24 = (Boolean)method24.invoke(oldModel,
						(Object[])null);

				newModel.setHasPoll(value24);

				Method method25 = oldModelClass.getMethod("getPollId");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setPollId(value25);

				Method method26 = oldModelClass.getMethod("getEffectiveDate");

				Date value26 = (Date)method26.invoke(oldModel, (Object[])null);

				newModel.setEffectiveDate(value26);

				Method method27 = oldModelClass.getMethod("getExpireDate");

				Date value27 = (Date)method27.invoke(oldModel, (Object[])null);

				newModel.setExpireDate(value27);

				Method method28 = oldModelClass.getMethod("getSticky");

				Boolean value28 = (Boolean)method28.invoke(oldModel,
						(Object[])null);

				newModel.setSticky(value28);

				Method method29 = oldModelClass.getMethod(
						"getStickyNeverExpired");

				Boolean value29 = (Boolean)method29.invoke(oldModel,
						(Object[])null);

				newModel.setStickyNeverExpired(value29);

				Method method30 = oldModelClass.getMethod("getStickyExpireDate");

				Date value30 = (Date)method30.invoke(oldModel, (Object[])null);

				newModel.setStickyExpireDate(value30);

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

	public static Object translateOutputVcmsArticleStatus(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsArticleStatusClp newModel = new VcmsArticleStatusClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getStatusId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setStatusId(value1);

				Method method2 = oldModelClass.getMethod("getArticleId");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value2);

				Method method3 = oldModelClass.getMethod("getCategoryId");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value3);

				Method method4 = oldModelClass.getMethod("getCreatedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value4);

				Method method5 = oldModelClass.getMethod("getCreatedByUser");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value5);

				Method method6 = oldModelClass.getMethod("getActive");

				Boolean value6 = (Boolean)method6.invoke(oldModel,
						(Object[])null);

				newModel.setActive(value6);

				Method method7 = oldModelClass.getMethod("getArticleVersionId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setArticleVersionId(value7);

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

	public static Object translateOutputVcmsArticleType(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsArticleTypeClp newModel = new VcmsArticleTypeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getTypeId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setTypeId(value0);

				Method method1 = oldModelClass.getMethod("getArticleId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value1);

				Method method2 = oldModelClass.getMethod("getPosition");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setPosition(value2);

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

	public static Object translateOutputVcmsArticleVersion(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsArticleVersionClp newModel = new VcmsArticleVersionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getArticleVersionId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setArticleVersionId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getArticleId");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value3);

				Method method4 = oldModelClass.getMethod("getCreatedByUser");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getCreatedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value5);

				Method method6 = oldModelClass.getMethod("getTypeIds");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setTypeIds(value6);

				Method method7 = oldModelClass.getMethod("getStatus");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setStatus(value7);

				Method method8 = oldModelClass.getMethod("getVersionName");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setVersionName(value8);

				Method method9 = oldModelClass.getMethod("getTitle");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTitle(value9);

				Method method10 = oldModelClass.getMethod("getLead");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setLead(value10);

				Method method11 = oldModelClass.getMethod("getContent");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setContent(value11);

				Method method12 = oldModelClass.getMethod("getHasImage");

				Boolean value12 = (Boolean)method12.invoke(oldModel,
						(Object[])null);

				newModel.setHasImage(value12);

				Method method13 = oldModelClass.getMethod("getImageTitle");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setImageTitle(value13);

				Method method14 = oldModelClass.getMethod("getImage");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setImage(value14);

				Method method15 = oldModelClass.getMethod("getLanguage");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value15);

				Method method16 = oldModelClass.getMethod("getUserHit");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setUserHit(value16);

				Method method17 = oldModelClass.getMethod("getAuthor");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setAuthor(value17);

				Method method18 = oldModelClass.getMethod("getSource");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setSource(value18);

				Method method19 = oldModelClass.getMethod("getDiscussible");

				Boolean value19 = (Boolean)method19.invoke(oldModel,
						(Object[])null);

				newModel.setDiscussible(value19);

				Method method20 = oldModelClass.getMethod("getHasAttachment");

				Boolean value20 = (Boolean)method20.invoke(oldModel,
						(Object[])null);

				newModel.setHasAttachment(value20);

				Method method21 = oldModelClass.getMethod("getHasPoll");

				Boolean value21 = (Boolean)method21.invoke(oldModel,
						(Object[])null);

				newModel.setHasPoll(value21);

				Method method22 = oldModelClass.getMethod("getPollId");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setPollId(value22);

				Method method23 = oldModelClass.getMethod("getEffectiveDate");

				Date value23 = (Date)method23.invoke(oldModel, (Object[])null);

				newModel.setEffectiveDate(value23);

				Method method24 = oldModelClass.getMethod("getExpireDate");

				Date value24 = (Date)method24.invoke(oldModel, (Object[])null);

				newModel.setExpireDate(value24);

				Method method25 = oldModelClass.getMethod("getSticky");

				Boolean value25 = (Boolean)method25.invoke(oldModel,
						(Object[])null);

				newModel.setSticky(value25);

				Method method26 = oldModelClass.getMethod(
						"getStickyNeverExpired");

				Boolean value26 = (Boolean)method26.invoke(oldModel,
						(Object[])null);

				newModel.setStickyNeverExpired(value26);

				Method method27 = oldModelClass.getMethod("getStickyExpireDate");

				Date value27 = (Date)method27.invoke(oldModel, (Object[])null);

				newModel.setStickyExpireDate(value27);

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

	public static Object translateOutputVcmsAttachedMessage(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsAttachedMessageClp newModel = new VcmsAttachedMessageClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getMessageId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setMessageId(value0);

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

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getArticleId");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value5);

				Method method6 = oldModelClass.getMethod("getContent");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setContent(value6);

				Method method7 = oldModelClass.getMethod("getReadMessage");

				Boolean value7 = (Boolean)method7.invoke(oldModel,
						(Object[])null);

				newModel.setReadMessage(value7);

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

	public static Object translateOutputVcmsCARelation(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsCARelationClp newModel = new VcmsCARelationClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value0);

				Method method1 = oldModelClass.getMethod("getArticleId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value1);

				Method method2 = oldModelClass.getMethod("getCreatedDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value2);

				Method method3 = oldModelClass.getMethod("getCreatedByUser");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value3);

				Method method4 = oldModelClass.getMethod("getStatus");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setStatus(value4);

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

	public static Object translateOutputVcmsCategory(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsCategoryClp newModel = new VcmsCategoryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value0);

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

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedByUser");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value6);

				Method method7 = oldModelClass.getMethod("getPortionId");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setPortionId(value7);

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

				Method method11 = oldModelClass.getMethod("getAnchored");

				Boolean value11 = (Boolean)method11.invoke(oldModel,
						(Object[])null);

				newModel.setAnchored(value11);

				Method method12 = oldModelClass.getMethod("getHref");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setHref(value12);

				Method method13 = oldModelClass.getMethod("getLanguage");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value13);

				Method method14 = oldModelClass.getMethod("getHasImage");

				Boolean value14 = (Boolean)method14.invoke(oldModel,
						(Object[])null);

				newModel.setHasImage(value14);

				Method method15 = oldModelClass.getMethod("getImage");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setImage(value15);

				Method method16 = oldModelClass.getMethod("getPosition");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setPosition(value16);

				Method method17 = oldModelClass.getMethod("getUserHit");

				Long value17 = (Long)method17.invoke(oldModel, (Object[])null);

				newModel.setUserHit(value17);

				Method method18 = oldModelClass.getMethod("getRssable");

				Boolean value18 = (Boolean)method18.invoke(oldModel,
						(Object[])null);

				newModel.setRssable(value18);

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

	public static Object translateOutputVcmsDiscussion(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsDiscussionClp newModel = new VcmsDiscussionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getDiscussionId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setDiscussionId(value0);

				Method method1 = oldModelClass.getMethod("getGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getVisitorName");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setVisitorName(value3);

				Method method4 = oldModelClass.getMethod("getVisitorEmail");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setVisitorEmail(value4);

				Method method5 = oldModelClass.getMethod("getVisitorPhone");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setVisitorPhone(value5);

				Method method6 = oldModelClass.getMethod("getPostedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setPostedDate(value6);

				Method method7 = oldModelClass.getMethod("getApproved");

				Boolean value7 = (Boolean)method7.invoke(oldModel,
						(Object[])null);

				newModel.setApproved(value7);

				Method method8 = oldModelClass.getMethod("getApprovedByUser");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setApprovedByUser(value8);

				Method method9 = oldModelClass.getMethod("getApprovedDate");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setApprovedDate(value9);

				Method method10 = oldModelClass.getMethod("getArticleId");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setArticleId(value10);

				Method method11 = oldModelClass.getMethod("getTitle");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setTitle(value11);

				Method method12 = oldModelClass.getMethod("getContent");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setContent(value12);

				Method method13 = oldModelClass.getMethod("getLanguage");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value13);

				Method method14 = oldModelClass.getMethod("getHasAttachment");

				Boolean value14 = (Boolean)method14.invoke(oldModel,
						(Object[])null);

				newModel.setHasAttachment(value14);

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

	public static Object translateOutputVcmsLogger(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsLoggerClp newModel = new VcmsLoggerClp();

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

				Method method3 = oldModelClass.getMethod("getCreatedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value3);

				Method method4 = oldModelClass.getMethod("getCreatedByUser");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getContent");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setContent(value5);

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

	public static Object translateOutputVcmsPARelation(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsPARelationClp newModel = new VcmsPARelationClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPortionId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setPortionId(value0);

				Method method1 = oldModelClass.getMethod("getArticleId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value1);

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

	public static Object translateOutputVcmsPortion(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsPortionClp newModel = new VcmsPortionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPortionId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setPortionId(value0);

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

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedByUser");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value6);

				Method method7 = oldModelClass.getMethod("getCode");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setCode(value7);

				Method method8 = oldModelClass.getMethod("getName");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setName(value8);

				Method method9 = oldModelClass.getMethod("getDescription");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setDescription(value9);

				Method method10 = oldModelClass.getMethod("getCategorizable");

				Boolean value10 = (Boolean)method10.invoke(oldModel,
						(Object[])null);

				newModel.setCategorizable(value10);

				Method method11 = oldModelClass.getMethod("getLanguage");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value11);

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

	public static Object translateOutputVcmsStatus(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsStatusClp newModel = new VcmsStatusClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getStatusId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setStatusId(value0);

				Method method1 = oldModelClass.getMethod("getCompanyId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value1);

				Method method2 = oldModelClass.getMethod("getGroupId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value2);

				Method method3 = oldModelClass.getMethod("getCreatedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreatedDate(value3);

				Method method4 = oldModelClass.getMethod("getCreatedByUser");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedByUser");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value6);

				Method method7 = oldModelClass.getMethod("getName");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setName(value7);

				Method method8 = oldModelClass.getMethod("getDescription");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setDescription(value8);

				Method method9 = oldModelClass.getMethod("getCssClass");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setCssClass(value9);

				Method method10 = oldModelClass.getMethod("getTextColor");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setTextColor(value10);

				Method method11 = oldModelClass.getMethod("getPosition");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setPosition(value11);

				Method method12 = oldModelClass.getMethod("getIsPrimary");

				Boolean value12 = (Boolean)method12.invoke(oldModel,
						(Object[])null);

				newModel.setIsPrimary(value12);

				Method method13 = oldModelClass.getMethod("getActive");

				Boolean value13 = (Boolean)method13.invoke(oldModel,
						(Object[])null);

				newModel.setActive(value13);

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

	public static Object translateOutputVcmsTARelation(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsTARelationClp newModel = new VcmsTARelationClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getThreadId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setThreadId(value0);

				Method method1 = oldModelClass.getMethod("getArticleId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setArticleId(value1);

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

	public static Object translateOutputVcmsThread(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsThreadClp newModel = new VcmsThreadClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getThreadId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setThreadId(value0);

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

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedByUser");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value6);

				Method method7 = oldModelClass.getMethod("getTitle");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setTitle(value7);

				Method method8 = oldModelClass.getMethod("getDescription");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setDescription(value8);

				Method method9 = oldModelClass.getMethod("getHasImage");

				Boolean value9 = (Boolean)method9.invoke(oldModel,
						(Object[])null);

				newModel.setHasImage(value9);

				Method method10 = oldModelClass.getMethod("getImage");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setImage(value10);

				Method method11 = oldModelClass.getMethod("getLanguage");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setLanguage(value11);

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

	public static Object translateOutputVcmsType(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VcmsTypeClp newModel = new VcmsTypeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getTypeId");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setTypeId(value0);

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

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCreatedByUser(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedByUser");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedByUser(value6);

				Method method7 = oldModelClass.getMethod("getCode");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setCode(value7);

				Method method8 = oldModelClass.getMethod("getName");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setName(value8);

				Method method9 = oldModelClass.getMethod("getDescription");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setDescription(value9);

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