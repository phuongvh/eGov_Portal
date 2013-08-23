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

package com.vportal.portlet.polls.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the polls question ext remote service. This utility wraps {@link com.vportal.portlet.polls.service.impl.PollsQuestionExtServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see PollsQuestionExtService
 * @see com.vportal.portlet.polls.service.base.PollsQuestionExtServiceBaseImpl
 * @see com.vportal.portlet.polls.service.impl.PollsQuestionExtServiceImpl
 * @generated
 */
public class PollsQuestionExtServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.polls.service.impl.PollsQuestionExtServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.polls.model.PollsVote addVoteByPra(
		long questionId, long choiceId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addVoteByPra(questionId, choiceId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static PollsQuestionExtService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PollsQuestionExtService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					PollsQuestionExtService.class.getName(), portletClassLoader);

			_service = new PollsQuestionExtServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(PollsQuestionExtServiceUtil.class,
				"_service");
			MethodCache.remove(PollsQuestionExtService.class);
		}

		return _service;
	}

	public void setService(PollsQuestionExtService service) {
		MethodCache.remove(PollsQuestionExtService.class);

		_service = service;

		ReferenceRegistry.registerReference(PollsQuestionExtServiceUtil.class,
			"_service");
		MethodCache.remove(PollsQuestionExtService.class);
	}

	private static PollsQuestionExtService _service;
}