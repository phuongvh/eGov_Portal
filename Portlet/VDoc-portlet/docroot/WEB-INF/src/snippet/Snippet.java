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

package snippet;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.vportal.portlet.vdoc.service.persistence.vdocDocumentFinder;


public class Snippet {

	protected vdocDocumentFinder vdocDocumentFinder;
	public List getDocByPublishDate(long groupId, String language,
			Date pubDateFrom, Date pubDateTo, int status, int quantity)
			throws PortalException, SystemException {
	
		return vdocDocumentFinder.findDocsByPublishedDate(groupId, language,
				pubDateFrom, pubDateTo, status, quantity);
	}
}

