Liferay.Service.register("Liferay.Service.vcontact", "com.vportal.portlet.vcontact.service", "VContact-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vcontact, "VContact",
	{
		addContact: true,
		updateContact: true,
		deleteContact: true,
		getAll: true,
		getByStatus: true,
		getByG_S: true,
		getContact: true
	}
);