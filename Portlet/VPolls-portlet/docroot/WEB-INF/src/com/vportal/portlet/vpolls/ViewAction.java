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

package com.vportal.portlet.vpolls;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.polls.DuplicateVoteException;
import com.liferay.portlet.polls.NoSuchChoiceException;
import com.liferay.portlet.polls.NoSuchQuestionException;
import com.liferay.portlet.polls.QuestionExpiredException;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.model.PollsVote;
import com.liferay.portlet.polls.service.PollsChoiceLocalServiceUtil;
import com.liferay.portlet.polls.service.PollsQuestionServiceUtil;
import com.liferay.portlet.polls.service.PollsVoteServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.polls.service.PollsQuestionExtServiceUtil;
import com.vportal.portlet.vpolls.util.WebKeysExt;
/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(request, Constants.CMD);
		//String session = themeDisplay.getSessionId();
		/*long userId = PortalUtilExt.getUserId(request);*/
		//long userId = themeDisplay.getUserId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					PollsVote.class.getName(), request);
			PortletPreferences prefs = request.getPreferences();

			long questionId = GetterUtil.getLong(prefs.getValue("question-id",
					StringPool.BLANK));

			PollsQuestion question = PollsQuestionServiceUtil
					.getQuestion(questionId);

			question = question.toEscapedModel();

			List choices = PollsChoiceLocalServiceUtil.getChoices(question
					.getQuestionId());
			request.setAttribute("choices", choices);

			if (cmd.equals(Constants.ADD)) {
				long choiceId = ParamUtil.getLong(request, "choiceId");

				request.setAttribute("choiceId", String.valueOf(choiceId));

				try {
					/*PollsVoteServiceUtil.addVote(question.getQuestionId(),
							choiceId,serviceContext);*/
					PollsQuestionExtServiceUtil.addVoteByPra(questionId, choiceId, serviceContext);
					saveVote(request, question.getQuestionId());

					SessionMessages.add(request, "vote_added");

				}

				catch (DuplicateVoteException dve) {
					SessionErrors.add(request, dve.getClass().getName());
				} catch (NoSuchChoiceException nsce) {
					SessionErrors.add(request, nsce.getClass().getName());
				} catch (QuestionExpiredException qee) {

				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute(WebKeysExt.POLLS_QUESTION, question);
		} catch (NoSuchQuestionException nsqe) {

			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(request, response);
	}
	
	public static void saveVote(ActionRequest actionRequest, long questionId) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		saveVote(request, questionId);
	}

	public static void saveVote(RenderRequest renderRequest, long questionId) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		saveVote(request, questionId);
	}

	public static void saveVote(HttpServletRequest request, long questionId) {
		HttpSession session = request.getSession();

		session.setAttribute(
			PollsQuestion.class.getName() + "." + questionId, Boolean.TRUE);
	}
	
	public void savePreferences(ActionRequest req, ActionResponse res) {
		try {
			String cmd = ParamUtil.getString(req, "cmd");
			if (!cmd.equals(Constants.UPDATE)) {
				return;
			}

			long questionId = ParamUtil.getLong(req, "questionId");

			String titlePortlet = ParamUtil.getString(req, "titlePortlet");

			String styleBorder = ParamUtil.getString(req, "styleBorder",
					StringPool.BLANK);
			String styleBullet = ParamUtil.getString(req, "styleBullet",
					StringPool.BLANK);
			String styleTitle = ParamUtil.getString(req, "styleTitle",
					StringPool.BLANK);
			String styleContent = ParamUtil.getString(req, "styleContent",
					StringPool.BLANK);
			PollsQuestionServiceUtil.getQuestion(questionId);

			boolean isBorder = ParamUtil.getBoolean(req, "isBorder");
			String bgcolor = ParamUtil.getString(req, "bgcolor");
			String themeType = ParamUtil.getString(req, "themeType");
			String themeSelected = ParamUtil.getString(req, "themeSelected");

			int paddingLeft = ParamUtil.getInteger(req, "paddingLeft");
			int paddingRight = ParamUtil.getInteger(req, "paddingRight");

			PortletPreferences prefs = req.getPreferences();

			prefs.setValue("paddingLeft", String.valueOf(paddingLeft));
			prefs.setValue("paddingRight", String.valueOf(paddingRight));

			prefs.setValue("bgcolor", bgcolor);
			prefs.setValue("isBorder", String.valueOf(isBorder));
			prefs.setValue("themeType", themeType);
			prefs.setValue("themeSelected", themeSelected);

			prefs.setValue("question-id", String.valueOf(questionId));
			prefs.setValue("titlePortlet", titlePortlet);
			prefs.setValue("styleBorder", styleBorder);
			prefs.setValue("styleBullet", styleBullet);
			prefs.setValue("styleTitle", styleTitle);
			prefs.setValue("styleContent", styleContent);
			prefs.store();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
