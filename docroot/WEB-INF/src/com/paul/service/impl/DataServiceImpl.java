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

package com.paul.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;
import com.paul.model.Data;
import com.paul.service.DataLocalServiceUtil;
import com.paul.service.base.DataServiceBaseImpl;
import com.paul.service.persistence.DataUtil;

/**
 * The implementation of the data remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.paul.service.DataService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Paul
 * @see com.paul.service.base.DataServiceBaseImpl
 * @see com.paul.service.DataServiceUtil
 */
public class DataServiceImpl extends DataServiceBaseImpl {
	private static final Logger LOGGER = Logger.getLogger(DataServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.paul.service.DataServiceUtil} to access the data remote service.
	 */

	public void addData(long groupId, long companyId, String information, String firstName, String lastName) throws SystemException {
		long dataId = CounterLocalServiceUtil.increment(Data.class.getName());
		Data data = DataLocalServiceUtil.createData(dataId);

		data.setGroupId(groupId);
		data.setCompanyId(companyId);

		data.setInformation(information);
		data.setFirstName(firstName);
		data.setLastName(lastName);

		DataLocalServiceUtil.addData(data);

		LOGGER.info("Data: " + information + " has been created.");
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<Data> getAllData() throws SystemException {
		return DataUtil.findAll();
	}

}