Liferay.Service.register("Liferay.Service.VDoc", "com.vportal.portlet.vdoc.service", "VDoc-portlet");

Liferay.Service.registerClass(
	Liferay.Service.VDoc, "vdocDocument",
	{
		getmaxPosition: true,
		updateDocument: true,
		deleteDocument: true,
		getDocument: true,
		getAllDoc: true,
		getDocByG_L_S: true,
		countDocByG_L_S: true,
		getDocByG_L_F: true,
		countDocByG_L_F: true,
		countDocByG_L_F_S: true,
		getDocByG_L_S_T: true,
		getDocbyModifyDate: true,
		countDocByG_L_S_T: true,
		getDocByG_L_S_F_T: true,
		countDocByG_L_S_F_T: true,
		getOtherDoc: true,
		countOtherDoc: true,
		addEntryResources: true,
		searchDocument: true,
		getDocByPublishDate: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.VDoc, "vdocDORel",
	{
		countCategory_approving: true,
		countCategory_public: true,
		countCategory_modify: true,
		addRelation: true,
		deleteRelation: true,
		deleteRelByDoc: true,
		getDORelByDoc: true,
		getDORelByOrg: true,
		getRelByDoc: true,
		getRelByField: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.VDoc, "vdocField",
	{
		updateField: true,
		deleteField: true,
		getField: true,
		getFieldByParentId: true,
		getFieldByG_L: true,
		getFieldByG_L_P: true,
		countFieldByG_L: true,
		countFieldByG_L_P: true,
		addEntryResources: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.VDoc, "vdocOrg",
	{
		updateOrg: true,
		deleteOrg: true,
		getOrg: true,
		getOrgByParentId: true,
		getOrgByG_L: true,
		getOrgByG_L_P: true,
		countOrgByG_L: true,
		countOrgByG_L_P: true,
		addEntryResources: true
	}
);