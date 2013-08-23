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

package com.vportal.portlet.vcms.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.vportal.portlet.vcms.service.ClpSerializer;
import com.vportal.portlet.vcms.service.VcmsArticleLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleStatusServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleTypeServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleVersionLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsAttachedMessageLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCARelationLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsDiscussionLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPARelationLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPortionLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPortionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTARelationLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsThreadLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsThreadServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTypeServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			VcmsArticleLocalServiceUtil.clearService();

			VcmsArticleServiceUtil.clearService();
			VcmsArticleStatusLocalServiceUtil.clearService();

			VcmsArticleStatusServiceUtil.clearService();
			VcmsArticleTypeLocalServiceUtil.clearService();

			VcmsArticleTypeServiceUtil.clearService();
			VcmsArticleVersionLocalServiceUtil.clearService();

			VcmsArticleVersionServiceUtil.clearService();
			VcmsAttachedMessageLocalServiceUtil.clearService();

			VcmsAttachedMessageServiceUtil.clearService();
			VcmsCARelationLocalServiceUtil.clearService();

			VcmsCARelationServiceUtil.clearService();
			VcmsCategoryLocalServiceUtil.clearService();

			VcmsCategoryServiceUtil.clearService();
			VcmsDiscussionLocalServiceUtil.clearService();

			VcmsDiscussionServiceUtil.clearService();
			VcmsLoggerLocalServiceUtil.clearService();

			VcmsLoggerServiceUtil.clearService();
			VcmsPARelationLocalServiceUtil.clearService();

			VcmsPARelationServiceUtil.clearService();
			VcmsPortionLocalServiceUtil.clearService();

			VcmsPortionServiceUtil.clearService();
			VcmsStatusLocalServiceUtil.clearService();

			VcmsStatusServiceUtil.clearService();
			VcmsTARelationLocalServiceUtil.clearService();

			VcmsTARelationServiceUtil.clearService();
			VcmsThreadLocalServiceUtil.clearService();

			VcmsThreadServiceUtil.clearService();
			VcmsTypeLocalServiceUtil.clearService();

			VcmsTypeServiceUtil.clearService();
		}
	}
}