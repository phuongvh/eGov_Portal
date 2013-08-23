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

package com.vportal.portlet.vcalendar.service.impl;

import com.vportal.portlet.vcalendar.model.VFile;
import com.vportal.portlet.vcalendar.service.base.VFileServiceBaseImpl;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.vportal.portlet.vcalendar.NoSuchVFileException;
/**
 * The implementation of the v file remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vcalendar.service.VFileService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see com.vportal.portlet.vcalendar.service.base.VFileServiceBaseImpl
 * @see com.vportal.portlet.vcalendar.service.VFileServiceUtil
 */
public class VFileServiceImpl extends VFileServiceBaseImpl {
	public VFile addVFile(String fullname,String phone,String address,String position,Date birthday,int status) throws SystemException{
		long id = counterLocalService.increment();
		VFile vFile = vFilePersistence.create(id);
		vFile.setFullname(fullname);
		vFile.setPhone(phone);
		vFile.setAddress(address);
		vFile.setPosition(position);
		vFile.setBirthday(birthday);
		vFile.setStatus(status);
		return vFilePersistence.update(vFile,false);
	}
	public VFile updateVFile(long fileId,String fullname,String phone,String address,String position,Date birthday,int status) throws SystemException, NoSuchVFileException{
		VFile vFile = vFilePersistence.findByPrimaryKey(fileId);
		vFile.setFullname(fullname);
		vFile.setPhone(phone);
		vFile.setAddress(address);
		vFile.setPosition(position);
		vFile.setBirthday(birthday);
		vFile.setStatus(status);
		return vFilePersistence.update(vFile,false);
	}
	public VFile deleteVFile(long fileId) throws SystemException, NoSuchVFileException{
		return vFilePersistence.remove(fileId);
	}
	public VFile findById(long fileId) throws SystemException, NoSuchVFileException{
		return vFilePersistence.findByPrimaryKey(fileId);
	}
	public List<VFile> findByAll()throws SystemException{
		return vFilePersistence.findAll();
	}
	public List<VFile> findByAll(int begin,int end)throws SystemException{
		return vFilePersistence.findAll(begin,end);
	}
	public int countAll()throws SystemException{
		return vFilePersistence.countAll();
	}
	public List<VFile> findByGroupId(int status) throws SystemException{
		return vFilePersistence.findByGroupID(status);
	}
	public List<VFile> findByGroupId(int status,int begin,int end) throws SystemException{
		return vFilePersistence.findByGroupID(status);
	}
	public int countByGroupId(int status) throws SystemException{
		return vFilePersistence.countByGroupID(status);
	}
}