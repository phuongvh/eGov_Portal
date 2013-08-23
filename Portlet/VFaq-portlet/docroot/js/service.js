Liferay.Service.register("Liferay.Service.vfaq", "com.vportal.portlet.vfaq.service", "VFaq-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vfaq, "FAQAnswer",
	{
		addAnswer: true,
		updateAnswer: true,
		deleteAnswer: true,
		approveAnswer: true,
		unapproveAnswer: true,
		getAnswer: true,
		countQuestion: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vfaq, "FAQCategory",
	{
		addCategory: true,
		updateCategory: true,
		updateImage: true,
		deleteCategory: true,
		getCategory: true,
		getCategoriesByG_L: true,
		findAll: true,
		findByPrimaryKey: true,
		findFirst: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vfaq, "FAQCategoryQuestion",
	{
		addCategoryQuestion: true,
		deleteByQuestionId: true,
		deleteByCategoryId: true,
		getAll: true,
		getQuestionsInCategory: true,
		getCategoriesOfQuestion: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vfaq, "FAQComment",
	{
		addComment: true,
		updateComment: true,
		getComment: true,
		removeComment: true,
		unapproved: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vfaq, "FAQQuestion",
	{
		addQuestion: true,
		updateQuestion: true,
		deleteQuestion: true,
		unapproveQuestion: true,
		approveQuestion: true,
		getQuestion: true,
		getQuestionApproveByCategory: true,
		countQuestionApproveByCategory: true,
		getQuestionByParam: true,
		getOrtherQuestionByParam: true,
		countQuestionByParam: true,
		getQuestionByG_L_S: true,
		countQuestionByG_L_S: true,
		findByPrimaryKey: true,
		reIndex: true,
		search: true,
		countQuestion: true
	}
);