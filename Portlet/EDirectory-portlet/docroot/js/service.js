Liferay.Service.register("Liferay.Service.edirectory", "com.vportal.portlet.edirectory.service", "EDirectory-portlet");

Liferay.Service.registerClass(
	Liferay.Service.edirectory, "EDEmployee",
	{
		addEmployee: true,
		addEmployeeResources: true,
		updateEmployee: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.edirectory, "EDFunction",
	{
		addFunction: true,
		updateFunction: true,
		removeFunction: true,
		addFunctionResources: true
	}
);