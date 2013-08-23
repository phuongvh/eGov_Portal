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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PollsQuestionExtService}.
 * </p>
 *
 * @author    DucNN
 * @see       PollsQuestionExtService
 * @generated
 */
public class PollsQuestionExtServiceWrapper implements PollsQuestionExtService,
	ServiceWrapper<PollsQuestionExtService> {
	public PollsQuestionExtServiceWrapper(
		PollsQuestionExtService pollsQuestionExtService) {
		_pollsQuestionExtService = pollsQuestionExtService;
	}

	public com.liferay.portlet.polls.model.PollsVote addVoteByPra(
		long questionId, long choiceId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionExtService.addVoteByPra(questionId, choiceId,
			serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PollsQuestionExtService getWrappedPollsQuestionExtService() {
		return _pollsQuestionExtService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPollsQuestionExtService(
		PollsQuestionExtService pollsQuestionExtService) {
		_pollsQuestionExtService = pollsQuestionExtService;
	}

	public PollsQuestionExtService getWrappedService() {
		return _pollsQuestionExtService;
	}

	public void setWrappedService(
		PollsQuestionExtService pollsQuestionExtService) {
		_pollsQuestionExtService = pollsQuestionExtService;
	}

	private PollsQuestionExtService _pollsQuestionExtService;
}