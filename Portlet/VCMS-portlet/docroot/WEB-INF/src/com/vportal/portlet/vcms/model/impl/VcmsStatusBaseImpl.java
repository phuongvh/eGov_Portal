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

package com.vportal.portlet.vcms.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;

/**
 * The extended model base implementation for the VcmsStatus service. Represents a row in the &quot;VcmsStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VcmsStatusImpl}.
 * </p>
 *
 * @author hai
 * @see VcmsStatusImpl
 * @see com.vportal.portlet.vcms.model.VcmsStatus
 * @generated
 */
public abstract class VcmsStatusBaseImpl extends VcmsStatusModelImpl
	implements VcmsStatus {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vcms status model instance should use the {@link VcmsStatus} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsStatusLocalServiceUtil.addVcmsStatus(this);
		}
		else {
			VcmsStatusLocalServiceUtil.updateVcmsStatus(this);
		}
	}
}