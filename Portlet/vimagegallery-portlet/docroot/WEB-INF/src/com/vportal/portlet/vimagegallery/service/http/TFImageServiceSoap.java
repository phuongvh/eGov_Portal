/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vimagegallery.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vimagegallery.service.TFImageServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vimagegallery.service.TFImageServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vimagegallery.model.TFImageSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vimagegallery.model.TFImage}, that is translated to a
 * {@link com.vportal.portlet.vimagegallery.model.TFImageSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    DucNN
 * @see       TFImageServiceHttp
 * @see       com.vportal.portlet.vimagegallery.model.TFImageSoap
 * @see       com.vportal.portlet.vimagegallery.service.TFImageServiceUtil
 * @generated
 */
public class TFImageServiceSoap {
	public static com.vportal.portlet.vimagegallery.model.TFImageSoap addImage(
		long groupId, long companyId, long plid, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.addImage(groupId,
					companyId, plid, categoryId, name, description, image,
					isShow, communityPermissions, guestPermissions);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImageSoap addImage(
		long groupId, long companyId, long plid, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.addImage(groupId,
					companyId, plid, categoryId, name, description, image,
					isShow, addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImageSoap addImage(
		com.vportal.portlet.vimagegallery.model.TFImage image)
		throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.addImage(image);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImageSoap updateImage(
		long groupId, long companyId, long plid, long id, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.updateImage(groupId,
					companyId, plid, id, categoryId, name, description, image,
					isShow);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImageSoap updateImage(
		com.vportal.portlet.vimagegallery.model.TFImage image)
		throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.updateImage(image);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteImage(long id) throws RemoteException {
		try {
			TFImageServiceUtil.deleteImage(id);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImageSoap findImagebyID(
		long id) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.findImagebyID(id);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImageSoap getImage(
		long id) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFImage returnValue = TFImageServiceUtil.getImage(id);

			return com.vportal.portlet.vimagegallery.model.TFImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] findAll()
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.findAll();

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByGroupId(
		long groupId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByGroupId(groupId);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByGroupId(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByGroupId(groupId, start, end);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByGroupId(long groupId) throws RemoteException {
		try {
			int returnValue = TFImageServiceUtil.countByGroupId(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByG_C(
		long groupId, long categoryId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByG_C(groupId, categoryId, start, end);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByG_C(
		long groupId, long categoryId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByG_C(groupId, categoryId);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByG_I(
		long groupId, boolean isShow, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByG_I(groupId, isShow, start, end);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByG_I(long groupId, boolean isShow)
		throws RemoteException {
		try {
			int returnValue = TFImageServiceUtil.countByG_I(groupId, isShow);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByG_C(long groupId, long categoryId)
		throws RemoteException {
		try {
			int returnValue = TFImageServiceUtil.countByG_C(groupId, categoryId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByG_C_I(groupId, categoryId, isShow);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage[] getByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> returnValue =
				TFImageServiceUtil.getByG_C_I(groupId, categoryId, isShow,
					start, end);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFImage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByG_C_I(long groupId, long categoryId, boolean isShow)
		throws RemoteException {
		try {
			int returnValue = TFImageServiceUtil.countByG_C_I(groupId,
					categoryId, isShow);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFImageResources(long id,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			TFImageServiceUtil.addTFImageResources(id, addCommunityPermissions,
				addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFImageResources(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			TFImageServiceUtil.addTFImageResources(tfImage,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFImageResources(long id,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			TFImageServiceUtil.addTFImageResources(id, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFImageResources(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			TFImageServiceUtil.addTFImageResources(tfImage,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TFImageServiceSoap.class);
}