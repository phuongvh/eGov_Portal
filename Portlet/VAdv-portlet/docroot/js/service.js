Liferay.Service.register("Liferay.Service.vadvman", "com.vportal.portlet.vadvman.service", "VAdv-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vadvman, "AdvItem",
	{
		addItem: true,
		updateItem: true,
		deleteItem: true,
		deleteItembyType: true,
		getItem: true,
		getAllbyType: true,
		getItemByG: true,
		countItemByG: true,
		getItemByG_S: true,
		countItemByG_S: true,
		countItemByG_T: true,
		getItemByParam: true,
		countItemByParam: true,
		addAdvItemResources: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vadvman, "AdvType",
	{
		addType: true,
		updateType: true,
		deleteType: true,
		getType: true,
		getItemCount: true,
		getTypeByG: true,
		countTypeByG: true,
		addAdvTypeResources: true
	}
);