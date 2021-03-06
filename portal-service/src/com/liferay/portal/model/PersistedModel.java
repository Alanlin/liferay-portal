/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.model;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Connor McKay
 */
public interface PersistedModel {

	/**
	 * Updates this model instance in the database or adds it if it does not yet
	 * exist. Also notifies the appropriate model listeners.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void persist() throws SystemException;

}