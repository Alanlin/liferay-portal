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

package com.liferay.portlet.dynamicdatamapping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DDMContentLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DDMContentLocalService
 * @generated
 */
public class DDMContentLocalServiceWrapper implements DDMContentLocalService,
	ServiceWrapper<DDMContentLocalService> {
	public DDMContentLocalServiceWrapper(
		DDMContentLocalService ddmContentLocalService) {
		_ddmContentLocalService = ddmContentLocalService;
	}

	/**
	* Adds the d d m content to the database. Also notifies the appropriate model listeners.
	*
	* @param ddmContent the d d m content
	* @return the d d m content that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatamapping.model.DDMContent addDDMContent(
		com.liferay.portlet.dynamicdatamapping.model.DDMContent ddmContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.addDDMContent(ddmContent);
	}

	/**
	* Creates a new d d m content with the primary key. Does not add the d d m content to the database.
	*
	* @param contentId the primary key for the new d d m content
	* @return the new d d m content
	*/
	public com.liferay.portlet.dynamicdatamapping.model.DDMContent createDDMContent(
		long contentId) {
		return _ddmContentLocalService.createDDMContent(contentId);
	}

	/**
	* Deletes the d d m content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the d d m content
	* @throws PortalException if a d d m content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDDMContent(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ddmContentLocalService.deleteDDMContent(contentId);
	}

	/**
	* Deletes the d d m content from the database. Also notifies the appropriate model listeners.
	*
	* @param ddmContent the d d m content
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDDMContent(
		com.liferay.portlet.dynamicdatamapping.model.DDMContent ddmContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ddmContentLocalService.deleteDDMContent(ddmContent);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.portlet.dynamicdatamapping.model.DDMContent fetchDDMContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.fetchDDMContent(contentId);
	}

	/**
	* Returns the d d m content with the primary key.
	*
	* @param contentId the primary key of the d d m content
	* @return the d d m content
	* @throws PortalException if a d d m content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatamapping.model.DDMContent getDDMContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getDDMContent(contentId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the d d m content with the UUID in the group.
	*
	* @param uuid the UUID of d d m content
	* @param groupId the group id of the d d m content
	* @return the d d m content
	* @throws PortalException if a d d m content with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatamapping.model.DDMContent getDDMContentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getDDMContentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the d d m contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of d d m contents
	* @param end the upper bound of the range of d d m contents (not inclusive)
	* @return the range of d d m contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.dynamicdatamapping.model.DDMContent> getDDMContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getDDMContents(start, end);
	}

	/**
	* Returns the number of d d m contents.
	*
	* @return the number of d d m contents
	* @throws SystemException if a system exception occurred
	*/
	public int getDDMContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getDDMContentsCount();
	}

	/**
	* Updates the d d m content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ddmContent the d d m content
	* @return the d d m content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatamapping.model.DDMContent updateDDMContent(
		com.liferay.portlet.dynamicdatamapping.model.DDMContent ddmContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.updateDDMContent(ddmContent);
	}

	/**
	* Updates the d d m content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ddmContent the d d m content
	* @param merge whether to merge the d d m content with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the d d m content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatamapping.model.DDMContent updateDDMContent(
		com.liferay.portlet.dynamicdatamapping.model.DDMContent ddmContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.updateDDMContent(ddmContent, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ddmContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ddmContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.portlet.dynamicdatamapping.model.DDMContent addContent(
		long userId, long groupId, java.lang.String name,
		java.lang.String description, java.lang.String xml,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.addContent(userId, groupId, name,
			description, xml, serviceContext);
	}

	public void deleteContent(
		com.liferay.portlet.dynamicdatamapping.model.DDMContent content)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ddmContentLocalService.deleteContent(content);
	}

	public void deleteContents(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ddmContentLocalService.deleteContents(groupId);
	}

	public com.liferay.portlet.dynamicdatamapping.model.DDMContent getContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getContent(contentId);
	}

	public java.util.List<com.liferay.portlet.dynamicdatamapping.model.DDMContent> getContents()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getContents();
	}

	public java.util.List<com.liferay.portlet.dynamicdatamapping.model.DDMContent> getContents(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getContents(groupId);
	}

	public java.util.List<com.liferay.portlet.dynamicdatamapping.model.DDMContent> getContents(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getContents(groupId, start, end);
	}

	public int getContentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.getContentsCount(groupId);
	}

	public com.liferay.portlet.dynamicdatamapping.model.DDMContent updateContent(
		long contentId, java.lang.String name, java.lang.String description,
		java.lang.String xml,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddmContentLocalService.updateContent(contentId, name,
			description, xml, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DDMContentLocalService getWrappedDDMContentLocalService() {
		return _ddmContentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDDMContentLocalService(
		DDMContentLocalService ddmContentLocalService) {
		_ddmContentLocalService = ddmContentLocalService;
	}

	public DDMContentLocalService getWrappedService() {
		return _ddmContentLocalService;
	}

	public void setWrappedService(DDMContentLocalService ddmContentLocalService) {
		_ddmContentLocalService = ddmContentLocalService;
	}

	private DDMContentLocalService _ddmContentLocalService;
}