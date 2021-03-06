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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Data service. Represents a row in the &quot;jsonservice_Data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.paul.model.impl.DataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.paul.model.impl.DataImpl}.
 * </p>
 *
 * @author Paul
 * @see Data
 * @see com.paul.model.impl.DataImpl
 * @see com.paul.model.impl.DataModelImpl
 * @generated
 */
public interface DataModel extends BaseModel<Data> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a data model instance should use the {@link Data} interface instead.
	 */

	/**
	 * Returns the primary key of this data.
	 *
	 * @return the primary key of this data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this data.
	 *
	 * @param primaryKey the primary key of this data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the data ID of this data.
	 *
	 * @return the data ID of this data
	 */
	public long getDataId();

	/**
	 * Sets the data ID of this data.
	 *
	 * @param dataId the data ID of this data
	 */
	public void setDataId(long dataId);

	/**
	 * Returns the group ID of this data.
	 *
	 * @return the group ID of this data
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this data.
	 *
	 * @param groupId the group ID of this data
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this data.
	 *
	 * @return the company ID of this data
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this data.
	 *
	 * @param companyId the company ID of this data
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the information of this data.
	 *
	 * @return the information of this data
	 */
	@AutoEscape
	public String getInformation();

	/**
	 * Sets the information of this data.
	 *
	 * @param information the information of this data
	 */
	public void setInformation(String information);

	/**
	 * Returns the first name of this data.
	 *
	 * @return the first name of this data
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this data.
	 *
	 * @param firstName the first name of this data
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this data.
	 *
	 * @return the last name of this data
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this data.
	 *
	 * @param lastName the last name of this data
	 */
	public void setLastName(String lastName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Data data);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Data> toCacheModel();

	@Override
	public Data toEscapedModel();

	@Override
	public Data toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}