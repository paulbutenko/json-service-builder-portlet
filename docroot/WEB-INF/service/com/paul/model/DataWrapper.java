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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Data}.
 * </p>
 *
 * @author Paul
 * @see Data
 * @generated
 */
public class DataWrapper implements Data, ModelWrapper<Data> {
	public DataWrapper(Data data) {
		_data = data;
	}

	@Override
	public Class<?> getModelClass() {
		return Data.class;
	}

	@Override
	public String getModelClassName() {
		return Data.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataId", getDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("information", getInformation());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataId = (Long)attributes.get("dataId");

		if (dataId != null) {
			setDataId(dataId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String information = (String)attributes.get("information");

		if (information != null) {
			setInformation(information);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}
	}

	/**
	* Returns the primary key of this data.
	*
	* @return the primary key of this data
	*/
	@Override
	public long getPrimaryKey() {
		return _data.getPrimaryKey();
	}

	/**
	* Sets the primary key of this data.
	*
	* @param primaryKey the primary key of this data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_data.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the data ID of this data.
	*
	* @return the data ID of this data
	*/
	@Override
	public long getDataId() {
		return _data.getDataId();
	}

	/**
	* Sets the data ID of this data.
	*
	* @param dataId the data ID of this data
	*/
	@Override
	public void setDataId(long dataId) {
		_data.setDataId(dataId);
	}

	/**
	* Returns the group ID of this data.
	*
	* @return the group ID of this data
	*/
	@Override
	public long getGroupId() {
		return _data.getGroupId();
	}

	/**
	* Sets the group ID of this data.
	*
	* @param groupId the group ID of this data
	*/
	@Override
	public void setGroupId(long groupId) {
		_data.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this data.
	*
	* @return the company ID of this data
	*/
	@Override
	public long getCompanyId() {
		return _data.getCompanyId();
	}

	/**
	* Sets the company ID of this data.
	*
	* @param companyId the company ID of this data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_data.setCompanyId(companyId);
	}

	/**
	* Returns the information of this data.
	*
	* @return the information of this data
	*/
	@Override
	public java.lang.String getInformation() {
		return _data.getInformation();
	}

	/**
	* Sets the information of this data.
	*
	* @param information the information of this data
	*/
	@Override
	public void setInformation(java.lang.String information) {
		_data.setInformation(information);
	}

	/**
	* Returns the first name of this data.
	*
	* @return the first name of this data
	*/
	@Override
	public java.lang.String getFirstName() {
		return _data.getFirstName();
	}

	/**
	* Sets the first name of this data.
	*
	* @param firstName the first name of this data
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_data.setFirstName(firstName);
	}

	/**
	* Returns the last name of this data.
	*
	* @return the last name of this data
	*/
	@Override
	public java.lang.String getLastName() {
		return _data.getLastName();
	}

	/**
	* Sets the last name of this data.
	*
	* @param lastName the last name of this data
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_data.setLastName(lastName);
	}

	@Override
	public boolean isNew() {
		return _data.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_data.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _data.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_data.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _data.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _data.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_data.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _data.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_data.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_data.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_data.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DataWrapper((Data)_data.clone());
	}

	@Override
	public int compareTo(com.paul.model.Data data) {
		return _data.compareTo(data);
	}

	@Override
	public int hashCode() {
		return _data.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.paul.model.Data> toCacheModel() {
		return _data.toCacheModel();
	}

	@Override
	public com.paul.model.Data toEscapedModel() {
		return new DataWrapper(_data.toEscapedModel());
	}

	@Override
	public com.paul.model.Data toUnescapedModel() {
		return new DataWrapper(_data.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _data.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _data.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_data.persist();
	}

	@Override
	public java.lang.String getFullName() {
		return _data.getFullName();
	}

	@Override
	public void setFullName(java.lang.String fullName) {
		_data.setFullName(fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataWrapper)) {
			return false;
		}

		DataWrapper dataWrapper = (DataWrapper)obj;

		if (Validator.equals(_data, dataWrapper._data)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Data getWrappedData() {
		return _data;
	}

	@Override
	public Data getWrappedModel() {
		return _data;
	}

	@Override
	public void resetOriginalValues() {
		_data.resetOriginalValues();
	}

	private Data _data;
}