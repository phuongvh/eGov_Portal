Liferay.Service.register("Liferay.Service.vimagegallery", "com.vportal.portlet.vimagegallery.service", "vimagegallery-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vimagegallery, "TFCategory",
	{
		addCategory: true,
		updateCategory: true,
		deleteCategory: true,
		getCategory: true,
		getByGroupId: true,
		countByGroupId: true,
		findCategory: true,
		addTFCategoryResources: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.vimagegallery, "TFImage",
	{
		addImage: true,
		updateImage: true,
		deleteImage: true,
		findImagebyID: true,
		getImage: true,
		findAll: true,
		getByGroupId: true,
		countByGroupId: true,
		getByG_C: true,
		getByG_I: true,
		countByG_I: true,
		countByG_C: true,
		getByG_C_I: true,
		countByG_C_I: true,
		addTFImageResources: true
	}
);