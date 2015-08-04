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

package com.paul.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.paul.NoSuchDataException;

import com.paul.model.Data;
import com.paul.model.impl.DataImpl;
import com.paul.model.impl.DataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul
 * @see DataPersistence
 * @see DataUtil
 * @generated
 */
public class DataPersistenceImpl extends BasePersistenceImpl<Data>
	implements DataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DataUtil} to access the data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataModelImpl.FINDER_CACHE_ENABLED, DataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataModelImpl.FINDER_CACHE_ENABLED, DataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DataPersistenceImpl() {
		setModelClass(Data.class);
	}

	/**
	 * Caches the data in the entity cache if it is enabled.
	 *
	 * @param data the data
	 */
	@Override
	public void cacheResult(Data data) {
		EntityCacheUtil.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataImpl.class, data.getPrimaryKey(), data);

		data.resetOriginalValues();
	}

	/**
	 * Caches the datas in the entity cache if it is enabled.
	 *
	 * @param datas the datas
	 */
	@Override
	public void cacheResult(List<Data> datas) {
		for (Data data : datas) {
			if (EntityCacheUtil.getResult(DataModelImpl.ENTITY_CACHE_ENABLED,
						DataImpl.class, data.getPrimaryKey()) == null) {
				cacheResult(data);
			}
			else {
				data.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Data data) {
		EntityCacheUtil.removeResult(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataImpl.class, data.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Data> datas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Data data : datas) {
			EntityCacheUtil.removeResult(DataModelImpl.ENTITY_CACHE_ENABLED,
				DataImpl.class, data.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data with the primary key. Does not add the data to the database.
	 *
	 * @param dataId the primary key for the new data
	 * @return the new data
	 */
	@Override
	public Data create(long dataId) {
		Data data = new DataImpl();

		data.setNew(true);
		data.setPrimaryKey(dataId);

		return data;
	}

	/**
	 * Removes the data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataId the primary key of the data
	 * @return the data that was removed
	 * @throws com.paul.NoSuchDataException if a data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Data remove(long dataId) throws NoSuchDataException, SystemException {
		return remove((Serializable)dataId);
	}

	/**
	 * Removes the data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data
	 * @return the data that was removed
	 * @throws com.paul.NoSuchDataException if a data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Data remove(Serializable primaryKey)
		throws NoSuchDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Data data = (Data)session.get(DataImpl.class, primaryKey);

			if (data == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(data);
		}
		catch (NoSuchDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Data removeImpl(Data data) throws SystemException {
		data = toUnwrappedModel(data);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(data)) {
				data = (Data)session.get(DataImpl.class, data.getPrimaryKeyObj());
			}

			if (data != null) {
				session.delete(data);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (data != null) {
			clearCache(data);
		}

		return data;
	}

	@Override
	public Data updateImpl(com.paul.model.Data data) throws SystemException {
		data = toUnwrappedModel(data);

		boolean isNew = data.isNew();

		Session session = null;

		try {
			session = openSession();

			if (data.isNew()) {
				session.save(data);

				data.setNew(false);
			}
			else {
				session.merge(data);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataImpl.class, data.getPrimaryKey(), data);

		return data;
	}

	protected Data toUnwrappedModel(Data data) {
		if (data instanceof DataImpl) {
			return data;
		}

		DataImpl dataImpl = new DataImpl();

		dataImpl.setNew(data.isNew());
		dataImpl.setPrimaryKey(data.getPrimaryKey());

		dataImpl.setDataId(data.getDataId());
		dataImpl.setGroupId(data.getGroupId());
		dataImpl.setCompanyId(data.getCompanyId());
		dataImpl.setInformation(data.getInformation());
		dataImpl.setFirstName(data.getFirstName());
		dataImpl.setLastName(data.getLastName());

		return dataImpl;
	}

	/**
	 * Returns the data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the data
	 * @return the data
	 * @throws com.paul.NoSuchDataException if a data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Data findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataException, SystemException {
		Data data = fetchByPrimaryKey(primaryKey);

		if (data == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return data;
	}

	/**
	 * Returns the data with the primary key or throws a {@link com.paul.NoSuchDataException} if it could not be found.
	 *
	 * @param dataId the primary key of the data
	 * @return the data
	 * @throws com.paul.NoSuchDataException if a data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Data findByPrimaryKey(long dataId)
		throws NoSuchDataException, SystemException {
		return findByPrimaryKey((Serializable)dataId);
	}

	/**
	 * Returns the data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data
	 * @return the data, or <code>null</code> if a data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Data fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Data data = (Data)EntityCacheUtil.getResult(DataModelImpl.ENTITY_CACHE_ENABLED,
				DataImpl.class, primaryKey);

		if (data == _nullData) {
			return null;
		}

		if (data == null) {
			Session session = null;

			try {
				session = openSession();

				data = (Data)session.get(DataImpl.class, primaryKey);

				if (data != null) {
					cacheResult(data);
				}
				else {
					EntityCacheUtil.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
						DataImpl.class, primaryKey, _nullData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DataModelImpl.ENTITY_CACHE_ENABLED,
					DataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return data;
	}

	/**
	 * Returns the data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataId the primary key of the data
	 * @return the data, or <code>null</code> if a data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Data fetchByPrimaryKey(long dataId) throws SystemException {
		return fetchByPrimaryKey((Serializable)dataId);
	}

	/**
	 * Returns all the datas.
	 *
	 * @return the datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Data> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.paul.model.impl.DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @return the range of datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Data> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.paul.model.impl.DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Data> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Data> list = (List<Data>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATA;

				if (pagination) {
					sql = sql.concat(DataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Data>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Data>(list);
				}
				else {
					list = (List<Data>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Data data : findAll()) {
			remove(data);
		}
	}

	/**
	 * Returns the number of datas.
	 *
	 * @return the number of datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATA);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.paul.model.Data")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Data>> listenersList = new ArrayList<ModelListener<Data>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Data>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DATA = "SELECT data FROM Data data";
	private static final String _SQL_COUNT_DATA = "SELECT COUNT(data) FROM Data data";
	private static final String _ORDER_BY_ENTITY_ALIAS = "data.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Data exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DataPersistenceImpl.class);
	private static Data _nullData = new DataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Data> toCacheModel() {
				return _nullDataCacheModel;
			}
		};

	private static CacheModel<Data> _nullDataCacheModel = new CacheModel<Data>() {
			@Override
			public Data toEntityModel() {
				return _nullData;
			}
		};
}