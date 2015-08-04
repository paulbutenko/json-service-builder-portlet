/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.paul.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataService}.
 *
 * @author Paul
 * @see DataService
 * @generated
 */
public class DataServiceWrapper implements DataService,
	ServiceWrapper<DataService> {
	public DataServiceWrapper(DataService dataService) {
		_dataService = dataService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dataService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dataService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dataService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addData(long groupId, long companyId,
		java.lang.String information, java.lang.String firstName,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dataService.addData(groupId, companyId, information, firstName,
			lastName);
	}

	@Override
	public java.util.List<com.paul.model.Data> getAllData()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataService.getAllData();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DataService getWrappedDataService() {
		return _dataService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDataService(DataService dataService) {
		_dataService = dataService;
	}

	@Override
	public DataService getWrappedService() {
		return _dataService;
	}

	@Override
	public void setWrappedService(DataService dataService) {
		_dataService = dataService;
	}

	private DataService _dataService;
}