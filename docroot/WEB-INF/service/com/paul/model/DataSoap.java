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

package com.paul.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.paul.service.http.DataServiceSoap}.
 *
 * @author Paul
 * @see com.paul.service.http.DataServiceSoap
 * @generated
 */
public class DataSoap implements Serializable {
	public static DataSoap toSoapModel(Data model) {
		DataSoap soapModel = new DataSoap();

		soapModel.setDataId(model.getDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setInformation(model.getInformation());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());

		return soapModel;
	}

	public static DataSoap[] toSoapModels(Data[] models) {
		DataSoap[] soapModels = new DataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataSoap[][] toSoapModels(Data[][] models) {
		DataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataSoap[] toSoapModels(List<Data> models) {
		List<DataSoap> soapModels = new ArrayList<DataSoap>(models.size());

		for (Data model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataSoap[soapModels.size()]);
	}

	public DataSoap() {
	}

	public long getPrimaryKey() {
		return _dataId;
	}

	public void setPrimaryKey(long pk) {
		setDataId(pk);
	}

	public long getDataId() {
		return _dataId;
	}

	public void setDataId(long dataId) {
		_dataId = dataId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getInformation() {
		return _information;
	}

	public void setInformation(String information) {
		_information = information;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	private long _dataId;
	private long _groupId;
	private long _companyId;
	private String _information;
	private String _firstName;
	private String _lastName;
}