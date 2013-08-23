/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.polls.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.polls.model.PollsVote;
import com.liferay.portlet.polls.service.PollsVoteLocalServiceUtil;
import com.vportal.portlet.polls.service.base.PollsQuestionExtServiceBaseImpl;

/**
 * The implementation of the polls question ext remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.polls.service.PollsQuestionExtService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.polls.service.base.PollsQuestionExtServiceBaseImpl
 * @see com.vportal.portlet.polls.service.PollsQuestionExtServiceUtil
 */
public class PollsQuestionExtServiceImpl extends PollsQuestionExtServiceBaseImpl {
	
	public PollsVote addVoteByPra(long questionId, long choiceId, ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		long userId = 0;

		try {
			userId = getUserId();
		}
		catch (PrincipalException pe) {
			userId = counterLocalService.increment();
		}

		return PollsVoteLocalServiceUtil.addVote(
			userId, questionId, choiceId, serviceContext);
	}
}