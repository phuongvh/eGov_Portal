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

package com.vportal.portlet.vfaq.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.vportal.portlet.vfaq.model.FAQComment;
import com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil;

/**
 * The extended model base implementation for the FAQComment service. Represents a row in the &quot;FAQComment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FAQCommentImpl}.
 * </p>
 *
 * @author DucNN
 * @see FAQCommentImpl
 * @see com.vportal.portlet.vfaq.model.FAQComment
 * @generated
 */
public abstract class FAQCommentBaseImpl extends FAQCommentModelImpl
	implements FAQComment {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a f a q comment model instance should use the {@link FAQComment} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQCommentLocalServiceUtil.addFAQComment(this);
		}
		else {
			FAQCommentLocalServiceUtil.updateFAQComment(this);
		}
	}
}