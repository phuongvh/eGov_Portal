package com.vportal.portlet.vcontact.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.vcontact.model.VContact;
import com.vportal.portlet.vcontact.service.VContactServiceUtil;

public class VContactPermission {
	public static void check(PermissionChecker permissionChecker, VContact 
			contact, String actionId) throws PortalException, SystemException, 
				RemoteException {
			if( ! contains(permissionChecker, contact, actionId)){
				throw new PrincipalException();
			}
		}
		public static void check(PermissionChecker permissionChecker, long contactId,
			String actionId) throws PortalException, SystemException, RemoteException {

			if (!contains(permissionChecker, contactId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(PermissionChecker permissionChecker, long contactId,
			String actionId) throws PortalException, SystemException,RemoteException {
					
			VContact contact = VContactServiceUtil.getContact(contactId);
			return contains(permissionChecker, contact, actionId);
		}
		
		public static boolean contains(PermissionChecker permissionChecker, 
				VContact contact, String actionId) throws PortalException,
			SystemException,RemoteException {
			
			return permissionChecker.hasPermission(contact.getGroupId(), 
					VContact.class.getName(),	contact.getId(), actionId);
		}
}		
