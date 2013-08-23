Liferay.Service.register("Liferay.Service.vcms", "com.vportal.portlet.vcms.service", "VCMS-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsArticle",
	{
		getArticleByCompanyId: true,
		countArticleByCompanyId: true,
		addArticle: true,
		addArticleResources: true,
		updateArticle: true,
		deleteArticle: true,
		deleteArticles: true,
		getArticle: true,
		getArticles: true,
		getArticlesByU_L_S: true,
		getArticlesByL_S: true,
		countArticlesByL_S: true,
		getArticlesByG_L_S_U: true,
		countArticlesByG_L_S_U: true,
		getArticlesByL_S_S: true,
		getArticlesNewByL_S_S: true,
		countArticlesByL_S_S: true,
		getArticleByP_L_S_D: true,
		getArticleByC_P_L_S: true,
		countArticleByC_P_L_S: true,
		getArticleByP_P_L_S: true,
		countArticleByP_P_L_S: true,
		getArticleByT_P_L_S: true,
		countArticleByT_P_L_S: true,
		countByStatus: true,
		getTopNewArticles: true,
		getHotNewArticles: true,
		getAllCategoryArticles: true,
		countAllCategoryArticles: true,
		getArticlesInThread: true,
		getOlderArticles: true,
		getNewArticles: true,
		countByC_P_L_S_D: true,
		countByP_L_S_D: true,
		listReportByDate: true,
		listReportByDateNotType: true,
		countByDate: true,
		countByDateNotType: true,
		listArticleByDateTypes: true,
		countArticleByDateTypes: true,
		countByType: true,
		countByUser: true,
		countArticleNotInType: true,
		countArticleAllCatNotInType: true,
		getArticlesBySearchContainer: true,
		countArticlesBySearchContainer: true,
		getArticlesBySearchContainer_T: true,
		countArticlesBySearchContainer_T: true,
		getArticleByG_L_C_S_T: true,
		countArticleByG_L_C_S_T: true,
		getArticleByG_L_S_T: true,
		countArticleByG_L_S_T: true,
		countArticleByG_L_S_C_D: true,
		getArticleByG_L_S_C_D: true,
		countOtherArticle: true,
		getOtherArticle: true,
		removeExpiredStickyArticles: true,
		reIndex: true,
		search: true,
		restoreArticleVersion: true,
		getStatusIdOfPublishedArticles: true,
		saveImage: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsArticleVersion",
	{
		addVersion: true,
		countVersionByArticleId: true,
		listVersionByArticleId: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsAttachedMessage",
	{
		addMessage: true,
		updateMessage: true,
		deleteMessage: true,
		deleteMessages: true,
		getMessage: true,
		getMessages: true,
		getByG_R: true,
		countByG_R: true,
		getMessagesUnread: true,
		count: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsCARelation",
	{
		addRelation: true,
		deleteRelation: true,
		deleteRelationsByCategory: true,
		deleteRelationsByArticle: true,
		getRelationsByCategory: true,
		getRelationsByArticle: true,
		countArticlesOfCategory: true,
		findRelationsByArticle: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsCategory",
	{
		addCategory: true,
		changePortion: true,
		addCategoryResources: true,
		updateCategory: true,
		deleteCategory: true,
		getCategory: true,
		getCategoriesByPortion: true,
		getCategoriesByParent: true,
		countCategoriesByParent: true,
		getCategoriesByP_P: true,
		countCategoriesByP_P: true,
		countByP_L: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsDiscussion",
	{
		addDiscussion: true,
		updateDiscussion: true,
		deleteDiscussion: true,
		deleteDiscussions: true,
		getDiscussion: true,
		getDiscussions: true,
		getDiscussionsByP_L: true,
		getDiscussionsByP_L_A: true,
		getDiscussionsByA_P_L_A: true,
		searchDiscussionByA_P_L_K: true,
		countByApproval: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsLogger",
	{
		log: true,
		findLogsByUser: true,
		findLogs: true,
		findLogersByD_A_K: true,
		countLogersByD_A_K: true,
		countLogs: true,
		removeLogs: true,
		removeLog: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsPARelation",
	{
		addRelation: true,
		deleteRelation: true,
		deleteRelationsByPortion: true,
		deleteRelationsByArticle: true,
		getRelationsByPortion: true,
		getRelationsByArticle: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsPortion",
	{
		addPortion: true,
		addPortionResources: true,
		updatePortion: true,
		deletePortion: true,
		deletePortions: true,
		getPortion: true,
		getPortionByS_C: true,
		getPortionsByS_L: true,
		countPortionsByS_L: true,
		countByCategorizable: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsTARelation",
	{
		addRelation: true,
		deleteRelation: true,
		deleteRelationsByArticle: true,
		deleteRelationsByThread: true,
		getRelationsByArticle: true,
		getRelationsByThread: true,
		countArticlesOfThread: true,
		countRelationByThread: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsThread",
	{
		addThread: true,
		addThreadResources: true,
		updateThread: true,
		deleteThread: true,
		getThread: true,
		getThreads: true,
		getThreadsByP_L: true,
		countThreadsByP_L: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vcms, "VcmsType",
	{
		addType: true,
		addTypeResources: true,
		updateType: true,
		deleteType: true,
		deleteTypes: true,
		getType: true,
		getTypeByS_C: true,
		getTypesByS_L: true,
		countTypesByS_L: true
	}
);