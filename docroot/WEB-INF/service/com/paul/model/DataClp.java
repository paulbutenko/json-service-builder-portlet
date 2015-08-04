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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.paul.service.ClpSerializer;
import com.paul.service.DataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul
 */
public class DataClp extends BaseModelImpl<Data> implements Data {
	public DataClp() {
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

	@Override
	public long getDataId() {
		return _dataId;
	}

	@Override
	public void setDataId(long dataId) {
		_dataId = dataId;

		if (_dataRemoteModel != null) {
			try {
				Class<?> clazz = _dataRemoteModel.getClass();

				Method method = clazz.getMethod("setDataId", long.class);

				method.invoke(_dataRemoteModel, dataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_dataRemoteModel != null) {
			try {
				Class<?> clazz = _dataRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dataRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_dataRemoteModel != null) {
			try {
				Class<?> clazz = _dataRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dataRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInformation() {
		return _information;
	}

	@Override
	public void setInformation(String information) {
		_information = information;

		if (_dataRemoteModel != null) {
			try {
				Class<?> clazz = _dataRemoteModel.getClass();

				Method method = clazz.getMethod("setInformation", String.class);

				method.invoke(_dataRemoteModel, information);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_dataRemoteModel != null) {
			try {
				Class<?> clazz = _dataRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_dataRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_dataRemoteModel != null) {
			try {
				Class<?> clazz = _dataRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_dataRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setFullName(java.lang.String fullName) {
		try {
			String methodName = "setFullName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { fullName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getFullName() {
		try {
			String methodName = "getFullName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getDataRemoteModel() {
		return _dataRemoteModel;
	}

	public void setDataRemoteModel(BaseModel<?> dataRemoteModel) {
		_dataRemoteModel = dataRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _dataRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_dataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DataLocalServiceUtil.addData(this);
		}
		else {
			DataLocalServiceUtil.updateData(this);
		}
	}

	@Override
	public Data toEscapedModel() {
		return (Data)ProxyUtil.newProxyInstance(Data.class.getClassLoader(),
			new Class[] { Data.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DataClp clone = new DataClp();

		clone.setDataId(getDataId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setInformation(getInformation());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());

		return clone;
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

		if (!(obj instanceof DataClp)) {
			return false;
		}

		DataClp data = (DataClp)obj;

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

	private long _dataId;
	private long _groupId;
	private long _companyId;
	private String _information;
	private String _firstName;
	private String _lastName;
	private BaseModel<?> _dataRemoteModel;
}