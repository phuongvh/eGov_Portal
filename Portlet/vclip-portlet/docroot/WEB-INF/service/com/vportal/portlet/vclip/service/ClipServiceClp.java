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
public class ClipServiceClp implements ClipService {
	public ClipServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addClipMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClip", long.class, long.class, long.class,
				com.vportal.portlet.vclip.model.Clip.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateClipMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateClip", long.class, long.class, java.lang.String.class,
				com.vportal.portlet.vclip.model.Clip.class);

		_deleteClipMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteClip", com.vportal.portlet.vclip.model.Clip.class);

		_deleteClipMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteClip", java.lang.String.class);

		_increaseHitCountMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"increaseHitCount", java.lang.String.class);

		_increaseHitCountViewMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"increaseHitCountView", java.lang.String.class);

		_findByIdMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"findById", java.lang.String.class);

		_findByClipTypeIdMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByClipTypeId", java.lang.String.class);

		_findByClipTypeIdMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByClipTypeId", java.lang.String.class, int.class, int.class);

		_countByClipTypeIdMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByClipTypeId", java.lang.String.class);

		_findClipMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"findClip", com.vportal.portlet.vclip.model.Clip.class);

		_findClipMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"findClip", com.vportal.portlet.vclip.model.Clip.class,
				int.class, int.class);

		_countClipMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"countClip", com.vportal.portlet.vclip.model.Clip.class);

		_searchClipMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchClip", java.lang.String.class, java.lang.String.class);

		_getAllMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAll");

		_getAllMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAll", int.class, int.class);

		_countAllMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"countAll");

		_hasParentMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"hasParent", java.lang.String.class);

		_getFirstMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFirst");

		_getByClipTypeIdMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByClipTypeId", java.lang.String.class);

		_addClipResourcesMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipResources", java.lang.String.class, boolean.class,
				boolean.class);

		_addClipResourcesMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipResources", com.vportal.portlet.vclip.model.Clip.class,
				boolean.class, boolean.class);

		_addClipResourcesMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipResources", java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class);

		_addClipResourcesMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"addClipResources", com.vportal.portlet.vclip.model.Clip.class,
				java.lang.String[].class, java.lang.String[].class);
	}

	public com.vportal.portlet.vclip.model.Clip addClip(long groupId,
		long companyId, long plid, com.vportal.portlet.vclip.model.Clip clip,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addClipMethodKey0,
				groupId, companyId, plid, ClpSerializer.translateInput(clip),
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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vclip.model.Clip updateClip(long groupId,
		long companyId, java.lang.String clipId,
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateClipMethodKey1,
				groupId, companyId, ClpSerializer.translateInput(clipId),
				ClpSerializer.translateInput(clip));

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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		MethodHandler methodHandler = new MethodHandler(_deleteClipMethodKey2,
				ClpSerializer.translateInput(clip));

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

	public void deleteClip(java.lang.String clipId) throws java.lang.Exception {
		MethodHandler methodHandler = new MethodHandler(_deleteClipMethodKey3,
				ClpSerializer.translateInput(clipId));

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

	public com.vportal.portlet.vclip.model.Clip increaseHitCount(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_increaseHitCountMethodKey4,
				ClpSerializer.translateInput(clipId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vclip.model.Clip increaseHitCountView(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_increaseHitCountViewMethodKey5,
				ClpSerializer.translateInput(clipId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vclip.model.Clip findById(
		java.lang.String clipId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdMethodKey6,
				ClpSerializer.translateInput(clipId));

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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByClipTypeIdMethodKey7,
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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByClipTypeIdMethodKey8,
				ClpSerializer.translateInput(clipTypeId), start, end);

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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByClipTypeId(java.lang.String clipTypeId)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByClipTypeIdMethodKey9,
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findClipMethodKey10,
				ClpSerializer.translateInput(clip));

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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip, int start, int end)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findClipMethodKey11,
				ClpSerializer.translateInput(clip), start, end);

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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public int countClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countClipMethodKey12,
				ClpSerializer.translateInput(clip));

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

	public java.util.List<com.vportal.portlet.vclip.model.Clip> searchClip(
		java.lang.String textSearch, java.lang.String clipTypeId)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchClipMethodKey13,
				ClpSerializer.translateInput(textSearch),
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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> getAll()
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllMethodKey14);

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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> getAll(
		int begin, int end) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllMethodKey15,
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

		return (java.util.List<com.vportal.portlet.vclip.model.Clip>)ClpSerializer.translateOutput(returnObj);
	}

	public int countAll() throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countAllMethodKey16);

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

	public boolean hasParent(java.lang.String clipTypeId)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_hasParentMethodKey17,
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

		return ((Boolean)returnObj).booleanValue();
	}

	public com.vportal.portlet.vclip.model.Clip getFirst()
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFirstMethodKey18);

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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vclip.model.Clip getByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByClipTypeIdMethodKey19,
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

		return (com.vportal.portlet.vclip.model.Clip)ClpSerializer.translateOutput(returnObj);
	}

	public void addClipResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipResourcesMethodKey20,
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

	public void addClipResources(com.vportal.portlet.vclip.model.Clip article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipResourcesMethodKey21,
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

	public void addClipResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipResourcesMethodKey22,
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

	public void addClipResources(com.vportal.portlet.vclip.model.Clip article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addClipResourcesMethodKey23,
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
	private MethodKey _addClipMethodKey0;
	private MethodKey _updateClipMethodKey1;
	private MethodKey _deleteClipMethodKey2;
	private MethodKey _deleteClipMethodKey3;
	private MethodKey _increaseHitCountMethodKey4;
	private MethodKey _increaseHitCountViewMethodKey5;
	private MethodKey _findByIdMethodKey6;
	private MethodKey _findByClipTypeIdMethodKey7;
	private MethodKey _findByClipTypeIdMethodKey8;
	private MethodKey _countByClipTypeIdMethodKey9;
	private MethodKey _findClipMethodKey10;
	private MethodKey _findClipMethodKey11;
	private MethodKey _countClipMethodKey12;
	private MethodKey _searchClipMethodKey13;
	private MethodKey _getAllMethodKey14;
	private MethodKey _getAllMethodKey15;
	private MethodKey _countAllMethodKey16;
	private MethodKey _hasParentMethodKey17;
	private MethodKey _getFirstMethodKey18;
	private MethodKey _getByClipTypeIdMethodKey19;
	private MethodKey _addClipResourcesMethodKey20;
	private MethodKey _addClipResourcesMethodKey21;
	private MethodKey _addClipResourcesMethodKey22;
	private MethodKey _addClipResourcesMethodKey23;
}