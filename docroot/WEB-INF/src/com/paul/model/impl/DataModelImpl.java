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

package com.paul.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.paul.model.Data;
import com.paul.model.DataModel;
import com.paul.model.DataSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Data service. Represents a row in the &quot;jsonservice_Data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.paul.model.DataModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataImpl}.
 * </p>
 *
 * @author Paul
 * @see DataImpl
 * @see com.paul.model.Data
 * @see com.paul.model.DataModel
 * @generated
 */
@JSON(strict = true)
public class DataModelImpl extends BaseModelImpl<Data> implements DataModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data model instance should use the {@link com.paul.model.Data} interface instead.
	 */
	public static final String TABLE_NAME = "jsonservice_Data";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dataId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "information", Types.VARCHAR },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table jsonservice_Data (dataId LONG not null primary key,groupId LONG,companyId LONG,information VARCHAR(75) null,firstName VARCHAR(75) null,lastName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table jsonservice_Data";
	public static final String ORDER_BY_JPQL = " ORDER BY data.dataId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY jsonservice_Data.dataId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.paul.model.Data"), true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.paul.model.Data"), true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Data toModel(DataSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Data model = new DataImpl();

		model.setDataId(soapModel.getDataId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setInformation(soapModel.getInformation());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Data> toModels(DataSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Data> models = new ArrayList<Data>(soapModels.length);

		for (DataSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.paul.model.Data"));

	public DataModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@JSON
	@Override
	public long getDataId() {
		return _dataId;
	}

	@Override
	public void setDataId(long dataId) {
		_dataId = dataId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public String getInformation() {
		if (_information == null) {
			return StringPool.BLANK;
		}
		else {
			return _information;
		}
	}

	@Override
	public void setInformation(String information) {
		_information = information;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Data.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Data toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Data)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataImpl dataImpl = new DataImpl();

		dataImpl.setDataId(getDataId());
		dataImpl.setGroupId(getGroupId());
		dataImpl.setCompanyId(getCompanyId());
		dataImpl.setInformation(getInformation());
		dataImpl.setFirstName(getFirstName());
		dataImpl.setLastName(getLastName());

		dataImpl.resetOriginalValues();

		return dataImpl;
	}

	@Override
	public int compareTo(Data data) {
		int value = 0;

		if (getDataId() < data.getDataId()) {
			value = -1;
		}
		else if (getDataId() > data.getDataId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Data)) {
			return false;
		}

		Data data = (Data)obj;

		long primaryKey = data.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Data> toCacheModel() {
		DataCacheModel dataCacheModel = new DataCacheModel();

		dataCacheModel.dataId = getDataId();

		dataCacheModel.groupId = getGroupId();

		dataCacheModel.companyId = getCompanyId();

		dataCacheModel.information = getInformation();

		String information = dataCacheModel.information;

		if ((information != null) && (information.length() == 0)) {
			dataCacheModel.information = null;
		}

		dataCacheModel.firstName = getFirstName();

		String firstName = dataCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			dataCacheModel.firstName = null;
		}

		dataCacheModel.lastName = getLastName();

		String lastName = dataCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			dataCacheModel.lastName = null;
		}

		return dataCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{dataId=");
		sb.append(getDataId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", information=");
		sb.append(getInformation());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.paul.model.Data");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dataId</column-name><column-value><![CDATA[");
		sb.append(getDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>information</column-name><column-value><![CDATA[");
		sb.append(getInformation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Data.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Data.class };
	private long _dataId;
	private long _groupId;
	private long _companyId;
	private String _information;
	private String _firstName;
	private String _lastName;
	private Data _escapedModel;
}