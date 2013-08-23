Liferay.Service.register("Liferay.Service.poll", "com.vportal.portlet.polls.service", "VPolls-portlet");

Liferay.Service.registerClass(
	Liferay.Service.poll, "PollsQuestionExt",
	{
		addVoteByPra: true
	}
);