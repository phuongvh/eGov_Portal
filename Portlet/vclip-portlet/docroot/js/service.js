Liferay.Service.register("Liferay.Service.vclip", "com.vportal.portlet.vclip.service", "vclip-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vclip, "Clip",
	{
		addClip: true,
		updateClip: true,
		deleteClip: true,
		increaseHitCount: true,
		increaseHitCountView: true,
		findById: true,
		findByClipTypeId: true,
		countByClipTypeId: true,
		findClip: true,
		countClip: true,
		searchClip: true,
		getAll: true,
		countAll: true,
		hasParent: true,
		getFirst: true,
		getByClipTypeId: true,
		addClipResources: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vclip, "ClipType",
	{
		addClipType: true,
		updateClipType: true,
		deleteClipType: true,
		findById: true,
		findAll: true,
		countAll: true,
		getLanguage: true,
		findClipType: true,
		countClipType: true,
		getFirst: true,
		addClipTypeResources: true
	}
);