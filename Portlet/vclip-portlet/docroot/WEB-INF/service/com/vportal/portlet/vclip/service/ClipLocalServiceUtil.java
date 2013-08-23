/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.vportal.portlet.vclip.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the clip local service. This utility wraps {@link com.vportal.portlet.vclip.service.impl.ClipLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HOAN
 * @see ClipLocalService
 * @see com.vportal.portlet.vclip.service.base.ClipLocalServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.impl.ClipLocalServiceImpl
 * @generated
 */
public class ClipLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vclip.service.impl.ClipLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the clip to the database. Also notifies the appropriate model listeners.
	*
	* @param clip the clip
	* @return the clip that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip addClip(
		com.vportal.portlet.vclip.model.Clip clip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addClip(clip);
	}

	/**
	* Creates a new clip with the primary key. Does not add the clip to the database.
	*
	* @param id the primary key for the new clip
	* @return the new clip
	*/
	public static com.vportal.portlet.vclip.model.Clip createClip(
		java.lang.String id) {
		return getService().createClip(id);
	}

	/**
	* Deletes the clip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the clip
	* @throws PortalException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteClip(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteClip(id);
	}

	/**
	* Deletes the clip from the database. Also notifies the appropriate model listeners.
	*
	* @param clip the clip
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteClip(com.vportal.portlet.vclip.model.Clip clip)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteClip(clip);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.vportal.portlet.vclip.model.Clip fetchClip(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClip(id);
	}

	/**
	* Returns the clip with the primary key.
	*
	* @param id the primary key of the clip
	* @return the clip
	* @throws PortalException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip getClip(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClip(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @return the range of clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> getClips(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClips(start, end);
	}

	/**
	* Returns the number of clips.
	*
	* @return the number of clips
	* @throws SystemException if a system exception occurred
	*/
	public static int getClipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClipsCount();
	}

	/**
	* Updates the clip in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param clip the clip
	* @return the clip that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip updateClip(
		com.vportal.portlet.vclip.model.Clip clip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClip(clip);
	}

	/**
	* Updates the clip in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param clip the clip
	* @param merge whether to merge the clip with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the clip that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip updateClip(
		com.vportal.portlet.vclip.model.Clip clip, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClip(clip, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static ClipLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClipLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ClipLocalService.class.getName(), portletClassLoader);

			_service = new ClipLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ClipLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ClipLocalService.class);
		}

		return _service;
	}

	public void setService(ClipLocalService service) {
		MethodCache.remove(ClipLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ClipLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ClipLocalService.class);
	}

	private static ClipLocalService _service;
}