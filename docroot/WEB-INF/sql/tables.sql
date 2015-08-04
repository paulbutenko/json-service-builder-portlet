create table jsonservice_Data (
	dataId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	information VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null
);