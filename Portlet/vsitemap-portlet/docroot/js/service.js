Liferay.Service.register("Liferay.Service.vsitemap", "com.vportal.portlet.vsitemap.service", "vsitemap-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vsitemap, "VsmBranch",
	{
		addBranch: true,
		updateBranch: true,
		deleteBranch: true,
		getAll: true,
		getByG_L: true,
		countByG_L: true,
		getByG_L_P: true,
		countByG_L_P: true,
		getBranch: true,
		getAllByLanguage: true,
		getAllByHasicon: true,
		getAllByParent: true,
		addVsmBranchResources: true
	}
);