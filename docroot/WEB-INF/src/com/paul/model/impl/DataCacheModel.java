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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.paul.model.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Data in entity cache.
 *
 * @author Paul
 * @see Data
 * @generated
 */
public class DataCacheModel implements CacheModel<Data>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{dataId=");
		sb.append(dataId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", information=");
		sb.append(information);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Data toEntityModel() {
		DataImpl dataImpl = new DataImpl();

		dataImpl.setDataId(dataId);
		dataImpl.setGroupId(groupId);
		dataImpl.setCompanyId(companyId);

		if (information == null) {
			dataImpl.setInformation(StringPool.BLANK);
		}
		else {
			dataImpl.setInformation(information);
		}

		if (firstName == null) {
			dataImpl.setFirstName(StringPool.BLANK);
		}
		else {
			dataImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			dataImpl.setLastName(StringPool.BLANK);
		}
		else {
			dataImpl.setLastName(lastName);
		}

		dataImpl.resetOriginalValues();

		return dataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		information = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dataId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (information == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(information);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}
	}

	public long dataId;
	public long groupId;
	public long companyId;
	public String information;
	public String firstName;
	public String lastName;
}