Liferay.Service.register("Liferay.Service.vlinksman", "com.vportal.portlet.vlinksman.service", "vlinksman-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vlinksman, "LinkGroup",
	{
		addLinkGroup: true,
		updateLinkGroup: true,
		deleteLinkGroup: true,
		getAll: true,
		getByGroupId: true,
		getLinkGroup: true,
		addLinkGroupResources: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vlinksman, "Links",
	{
		addLinks: true,
		updateLinks: true,
		updateLink: true,
		updateLink2: true,
		updateLink3: true,
		deleteLink: true,
		getAll: true,
		getByLinkGroupId: true,
		getByGroupId: true,
		countByGroupId: true,
		getByLinkG_GL: true,
		getLinks: true,
		addLinksResources: true,
		_validate: true
	}
);