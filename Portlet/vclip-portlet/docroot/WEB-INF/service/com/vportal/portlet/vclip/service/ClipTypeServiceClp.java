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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author HOAN
 */
public class ClipTypeServiceClp implements ClipTypeService {
	public ClipTypeServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addClipTypeMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipType", long.class, long.class, long.class,
				com.vportal.portlet.vclip.model.ClipType.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateClipTypeMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateClipType", long.class, long.class,
				java.lang.String.class,
				com.vportal.portlet.vclip.model.ClipType.class);

		_deleteClipTypeMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteClipType", com.vportal.portlet.vclip.model.ClipType.class);

		_deleteClipTypeMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteClipType", java.lang.String.class);

		_findByIdMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"findById", java.lang.String.class);

		_findAllMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"findAll");

		_findAllMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"findAll", int.class, int.class);

		_countAllMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"countAll");

		_getLanguageMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLanguage", java.lang.String.class, boolean.class);

		_findClipTypeMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"findClipType", com.vportal.portlet.vclip.model.ClipType.class);

		_findClipTypeMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"findClipType", com.vportal.portlet.vclip.model.ClipType.class,
				int.class, int.class);

		_countClipTypeMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"countClipType", com.vportal.portlet.vclip.model.ClipType.class);

		_getFirstMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFirst");

		_addClipTypeResourcesMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipTypeResources", java.lang.String.class, boolean.class,
				boolean.class);

		_addClipTypeResourcesMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipTypeResources",
				com.vportal.portlet.vclip.model.ClipType.class, boolean.class,
				boolean.class);

		_addClipTypeResourcesMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipTypeResources", java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class);

		_addClipTypeResourcesMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipTypeResources",
				com.vportal.portlet.vclip.model.ClipType.class,
				java.lang.String[].class, java.lang.String[].class);
	}

	public com.vportal.portlet.vclip.model.ClipType addClipType(long groupId,
		long companyId, long plid,
		com.vportal.portlet.vclip.model.ClipType clipType,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addClipTypeMethodKey0,
				groupId, companyId, plid,
				ClpSerializer.translateInput(clipType),
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vclip.model.ClipType)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vclip.model.ClipType updateClipType(
		long groupId, long companyId, java.lang.String clipTypeId,
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateClipTypeMethodKey1,
				groupId, companyId, ClpSerializer.translateInput(clipTypeId),
				ClpSerializer.translateInput(clipType));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vclip.model.ClipType)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		MethodHandler methodHandler = new MethodHandler(_deleteClipTypeMethodKey2,
				ClpSerializer.translateInput(clipType));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteClipType(java.lang.String clipTypeId)
		throws java.lang.Exception {
		MethodHandler methodHandler = new MethodHandler(_deleteClipTypeMethodKey3,
				ClpSerializer.translateInput(clipTypeId));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.vportal.portlet.vclip.model.ClipType findById(
		java.lang.String clipTypeId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdMethodKey4,
				ClpSerializer.translateInput(clipTypeId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vclip.model.ClipType)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll()
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findAllMethodKey5);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vclip.model.ClipType>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int begin, int end) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findAllMethodKey6,
				begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vclip.model.ClipType>)ClpSerializer.translateOutput(returnObj);
	}

	public int countAll() throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countAllMethodKey7);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> getLanguage(
		java.lang.String language, boolean active) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLanguageMethodKey8,
				ClpSerializer.translateInput(language), active);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vclip.model.ClipType>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findClipTypeMethodKey9,
				ClpSerializer.translateInput(clipType));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vclip.model.ClipType>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findClipTypeMethodKey10,
				ClpSerializer.translateInput(clipType), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vclip.model.ClipType>)ClpSerializer.translateOutput(returnObj);
	}

	public int countClipType(com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countClipTypeMethodKey11,
				ClpSerializer.translateInput(clipType));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.vportal.portlet.vclip.model.ClipType getFirst()
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFirstMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vclip.model.ClipType)ClpSerializer.translateOutput(returnObj);
	}

	public void addClipTypeResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipTypeResourcesMethodKey13,
				ClpSerializer.translateInput(articleId),
				addCommunityPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipTypeResourcesMethodKey14,
				ClpSerializer.translateInput(article), addCommunityPermissions,
				addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addClipTypeResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipTypeResourcesMethodKey15,
				ClpSerializer.translateInput(articleId),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipTypeResourcesMethodKey16,
				ClpSerializer.translateInput(article),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addClipTypeMethodKey0;
	private MethodKey _updateClipTypeMethodKey1;
	private MethodKey _deleteClipTypeMethodKey2;
	private MethodKey _deleteClipTypeMethodKey3;
	private MethodKey _findByIdMethodKey4;
	private MethodKey _findAllMethodKey5;
	private MethodKey _findAllMethodKey6;
	private MethodKey _countAllMethodKey7;
	private MethodKey _getLanguageMethodKey8;
	private MethodKey _findClipTypeMethodKey9;
	private MethodKey _findClipTypeMethodKey10;
	private MethodKey _countClipTypeMethodKey11;
	private MethodKey _getFirstMethodKey12;
	private MethodKey _addClipTypeResourcesMethodKey13;
	private MethodKey _addClipTypeResourcesMethodKey14;
	private MethodKey _addClipTypeResourcesMethodKey15;
	private MethodKey _addClipTypeResourcesMethodKey16;
}