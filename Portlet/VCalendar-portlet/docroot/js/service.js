Liferay.Service.register("Liferay.Service.VCalendar", "com.vportal.portlet.vcalendar.service", "VCalendar-portlet");

Liferay.Service.registerClass(
	Liferay.Service.VCalendar, "VCal",
	{
		addvCal: true,
		updatevCal: true,
		deletevCal: true,
		findByD_S_G: true,
		countByD_S_G: true,
		findByU_D_S: true,
		countByU_D_S: true,
		findByD_S: true,
		countByD_S: true,
		findById: true,
		findByUser: true,
		findByUserGroup: true,
		findByGroupOrg: true,
		findByF_D_G_T: true,
		findByF_D_G_U: true,
		findByF: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.VCalendar, "VFile",
	{
		addVFile: true,
		updateVFile: true,
		deleteVFile: true,
		findById: true,
		findByAll: true,
		countAll: true,
		findByGroupId: true,
		countByGroupId: true
	}
);