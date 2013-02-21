/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBThreadModel;
import com.liferay.portlet.messageboards.model.MBThreadSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MBThread service. Represents a row in the &quot;MBThread&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.messageboards.model.MBThreadModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MBThreadImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBThreadImpl
 * @see com.liferay.portlet.messageboards.model.MBThread
 * @see com.liferay.portlet.messageboards.model.MBThreadModel
 * @generated
 */
@JSON(strict = true)
public class MBThreadModelImpl extends BaseModelImpl<MBThread>
	implements MBThreadModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message boards thread model instance should use the {@link com.liferay.portlet.messageboards.model.MBThread} interface instead.
	 */
	public static final String TABLE_NAME = "MBThread";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "threadId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "categoryId", Types.BIGINT },
			{ "rootMessageId", Types.BIGINT },
			{ "rootMessageUserId", Types.BIGINT },
			{ "messageCount", Types.INTEGER },
			{ "viewCount", Types.INTEGER },
			{ "lastPostByUserId", Types.BIGINT },
			{ "lastPostDate", Types.TIMESTAMP },
			{ "priority", Types.DOUBLE },
			{ "question", Types.BOOLEAN },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table MBThread (uuid_ VARCHAR(75) null,threadId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,rootMessageId LONG,rootMessageUserId LONG,messageCount INTEGER,viewCount INTEGER,lastPostByUserId LONG,lastPostDate DATE null,priority DOUBLE,question BOOLEAN,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table MBThread";
	public static final String ORDER_BY_JPQL = " ORDER BY mbThread.priority DESC, mbThread.lastPostDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY MBThread.priority DESC, MBThread.lastPostDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.messageboards.model.MBThread"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.messageboards.model.MBThread"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.messageboards.model.MBThread"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long LASTPOSTDATE_COLUMN_BITMASK = 8L;
	public static long PRIORITY_COLUMN_BITMASK = 16L;
	public static long ROOTMESSAGEID_COLUMN_BITMASK = 32L;
	public static long STATUS_COLUMN_BITMASK = 64L;
	public static long UUID_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MBThread toModel(MBThreadSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MBThread model = new MBThreadImpl();

		model.setUuid(soapModel.getUuid());
		model.setThreadId(soapModel.getThreadId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCategoryId(soapModel.getCategoryId());
		model.setRootMessageId(soapModel.getRootMessageId());
		model.setRootMessageUserId(soapModel.getRootMessageUserId());
		model.setMessageCount(soapModel.getMessageCount());
		model.setViewCount(soapModel.getViewCount());
		model.setLastPostByUserId(soapModel.getLastPostByUserId());
		model.setLastPostDate(soapModel.getLastPostDate());
		model.setPriority(soapModel.getPriority());
		model.setQuestion(soapModel.getQuestion());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MBThread> toModels(MBThreadSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MBThread> models = new ArrayList<MBThread>(soapModels.length);

		for (MBThreadSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.messageboards.model.MBThread"));

	public MBThreadModelImpl() {
	}

	public long getPrimaryKey() {
		return _threadId;
	}

	public void setPrimaryKey(long primaryKey) {
		setThreadId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _threadId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return MBThread.class;
	}

	public String getModelClassName() {
		return MBThread.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("threadId", getThreadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("rootMessageId", getRootMessageId());
		attributes.put("rootMessageUserId", getRootMessageUserId());
		attributes.put("messageCount", getMessageCount());
		attributes.put("viewCount", getViewCount());
		attributes.put("lastPostByUserId", getLastPostByUserId());
		attributes.put("lastPostDate", getLastPostDate());
		attributes.put("priority", getPriority());
		attributes.put("question", getQuestion());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long threadId = (Long)attributes.get("threadId");

		if (threadId != null) {
			setThreadId(threadId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long rootMessageId = (Long)attributes.get("rootMessageId");

		if (rootMessageId != null) {
			setRootMessageId(rootMessageId);
		}

		Long rootMessageUserId = (Long)attributes.get("rootMessageUserId");

		if (rootMessageUserId != null) {
			setRootMessageUserId(rootMessageUserId);
		}

		Integer messageCount = (Integer)attributes.get("messageCount");

		if (messageCount != null) {
			setMessageCount(messageCount);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Long lastPostByUserId = (Long)attributes.get("lastPostByUserId");

		if (lastPostByUserId != null) {
			setLastPostByUserId(lastPostByUserId);
		}

		Date lastPostDate = (Date)attributes.get("lastPostDate");

		if (lastPostDate != null) {
			setLastPostDate(lastPostDate);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Boolean question = (Boolean)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_threadId = threadId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@JSON
	public long getRootMessageId() {
		return _rootMessageId;
	}

	public void setRootMessageId(long rootMessageId) {
		_columnBitmask |= ROOTMESSAGEID_COLUMN_BITMASK;

		if (!_setOriginalRootMessageId) {
			_setOriginalRootMessageId = true;

			_originalRootMessageId = _rootMessageId;
		}

		_rootMessageId = rootMessageId;
	}

	public long getOriginalRootMessageId() {
		return _originalRootMessageId;
	}

	@JSON
	public long getRootMessageUserId() {
		return _rootMessageUserId;
	}

	public void setRootMessageUserId(long rootMessageUserId) {
		_rootMessageUserId = rootMessageUserId;
	}

	public String getRootMessageUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getRootMessageUserId(), "uuid",
			_rootMessageUserUuid);
	}

	public void setRootMessageUserUuid(String rootMessageUserUuid) {
		_rootMessageUserUuid = rootMessageUserUuid;
	}

	@JSON
	public int getMessageCount() {
		return _messageCount;
	}

	public void setMessageCount(int messageCount) {
		_messageCount = messageCount;
	}

	@JSON
	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	@JSON
	public long getLastPostByUserId() {
		return _lastPostByUserId;
	}

	public void setLastPostByUserId(long lastPostByUserId) {
		_lastPostByUserId = lastPostByUserId;
	}

	public String getLastPostByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getLastPostByUserId(), "uuid",
			_lastPostByUserUuid);
	}

	public void setLastPostByUserUuid(String lastPostByUserUuid) {
		_lastPostByUserUuid = lastPostByUserUuid;
	}

	@JSON
	public Date getLastPostDate() {
		return _lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		_columnBitmask = -1L;

		if (_originalLastPostDate == null) {
			_originalLastPostDate = _lastPostDate;
		}

		_lastPostDate = lastPostDate;
	}

	public Date getOriginalLastPostDate() {
		return _originalLastPostDate;
	}

	@JSON
	public double getPriority() {
		return _priority;
	}

	public void setPriority(double priority) {
		_columnBitmask = -1L;

		if (!_setOriginalPriority) {
			_setOriginalPriority = true;

			_originalPriority = _priority;
		}

		_priority = priority;
	}

	public double getOriginalPriority() {
		return _originalPriority;
	}

	@JSON
	public boolean getQuestion() {
		return _question;
	}

	public boolean isQuestion() {
		return _question;
	}

	public void setQuestion(boolean question) {
		_question = question;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getContainerModelId() {
		return getThreadId();
	}

	public void setContainerModelId(long containerModelId) {
		_threadId = containerModelId;
	}

	public long getParentContainerModelId() {
		return getCategoryId();
	}

	public void setParentContainerModelId(long parentContainerModelId) {
		_categoryId = parentContainerModelId;
	}

	public String getContainerModelName() {
		return String.valueOf(getContainerModelId());
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MBThread.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MBThread toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MBThread)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MBThreadImpl mbThreadImpl = new MBThreadImpl();

		mbThreadImpl.setUuid(getUuid());
		mbThreadImpl.setThreadId(getThreadId());
		mbThreadImpl.setGroupId(getGroupId());
		mbThreadImpl.setCompanyId(getCompanyId());
		mbThreadImpl.setUserId(getUserId());
		mbThreadImpl.setUserName(getUserName());
		mbThreadImpl.setCreateDate(getCreateDate());
		mbThreadImpl.setModifiedDate(getModifiedDate());
		mbThreadImpl.setCategoryId(getCategoryId());
		mbThreadImpl.setRootMessageId(getRootMessageId());
		mbThreadImpl.setRootMessageUserId(getRootMessageUserId());
		mbThreadImpl.setMessageCount(getMessageCount());
		mbThreadImpl.setViewCount(getViewCount());
		mbThreadImpl.setLastPostByUserId(getLastPostByUserId());
		mbThreadImpl.setLastPostDate(getLastPostDate());
		mbThreadImpl.setPriority(getPriority());
		mbThreadImpl.setQuestion(getQuestion());
		mbThreadImpl.setStatus(getStatus());
		mbThreadImpl.setStatusByUserId(getStatusByUserId());
		mbThreadImpl.setStatusByUserName(getStatusByUserName());
		mbThreadImpl.setStatusDate(getStatusDate());

		mbThreadImpl.resetOriginalValues();

		return mbThreadImpl;
	}

	public int compareTo(MBThread mbThread) {
		int value = 0;

		if (getPriority() < mbThread.getPriority()) {
			value = -1;
		}
		else if (getPriority() > mbThread.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getLastPostDate(), mbThread.getLastPostDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MBThread mbThread = null;

		try {
			mbThread = (MBThread)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = mbThread.getPrimaryKey();

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
		MBThreadModelImpl mbThreadModelImpl = this;

		mbThreadModelImpl._originalUuid = mbThreadModelImpl._uuid;

		mbThreadModelImpl._originalGroupId = mbThreadModelImpl._groupId;

		mbThreadModelImpl._setOriginalGroupId = false;

		mbThreadModelImpl._originalCompanyId = mbThreadModelImpl._companyId;

		mbThreadModelImpl._setOriginalCompanyId = false;

		mbThreadModelImpl._originalCategoryId = mbThreadModelImpl._categoryId;

		mbThreadModelImpl._setOriginalCategoryId = false;

		mbThreadModelImpl._originalRootMessageId = mbThreadModelImpl._rootMessageId;

		mbThreadModelImpl._setOriginalRootMessageId = false;

		mbThreadModelImpl._originalLastPostDate = mbThreadModelImpl._lastPostDate;

		mbThreadModelImpl._originalPriority = mbThreadModelImpl._priority;

		mbThreadModelImpl._setOriginalPriority = false;

		mbThreadModelImpl._originalStatus = mbThreadModelImpl._status;

		mbThreadModelImpl._setOriginalStatus = false;

		mbThreadModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MBThread> toCacheModel() {
		MBThreadCacheModel mbThreadCacheModel = new MBThreadCacheModel();

		mbThreadCacheModel.uuid = getUuid();

		String uuid = mbThreadCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			mbThreadCacheModel.uuid = null;
		}

		mbThreadCacheModel.threadId = getThreadId();

		mbThreadCacheModel.groupId = getGroupId();

		mbThreadCacheModel.companyId = getCompanyId();

		mbThreadCacheModel.userId = getUserId();

		mbThreadCacheModel.userName = getUserName();

		String userName = mbThreadCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			mbThreadCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			mbThreadCacheModel.createDate = createDate.getTime();
		}
		else {
			mbThreadCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			mbThreadCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			mbThreadCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		mbThreadCacheModel.categoryId = getCategoryId();

		mbThreadCacheModel.rootMessageId = getRootMessageId();

		mbThreadCacheModel.rootMessageUserId = getRootMessageUserId();

		mbThreadCacheModel.messageCount = getMessageCount();

		mbThreadCacheModel.viewCount = getViewCount();

		mbThreadCacheModel.lastPostByUserId = getLastPostByUserId();

		Date lastPostDate = getLastPostDate();

		if (lastPostDate != null) {
			mbThreadCacheModel.lastPostDate = lastPostDate.getTime();
		}
		else {
			mbThreadCacheModel.lastPostDate = Long.MIN_VALUE;
		}

		mbThreadCacheModel.priority = getPriority();

		mbThreadCacheModel.question = getQuestion();

		mbThreadCacheModel.status = getStatus();

		mbThreadCacheModel.statusByUserId = getStatusByUserId();

		mbThreadCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = mbThreadCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			mbThreadCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			mbThreadCacheModel.statusDate = statusDate.getTime();
		}
		else {
			mbThreadCacheModel.statusDate = Long.MIN_VALUE;
		}

		return mbThreadCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", threadId=");
		sb.append(getThreadId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", rootMessageId=");
		sb.append(getRootMessageId());
		sb.append(", rootMessageUserId=");
		sb.append(getRootMessageUserId());
		sb.append(", messageCount=");
		sb.append(getMessageCount());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", lastPostByUserId=");
		sb.append(getLastPostByUserId());
		sb.append(", lastPostDate=");
		sb.append(getLastPostDate());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", question=");
		sb.append(getQuestion());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.messageboards.model.MBThread");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootMessageId</column-name><column-value><![CDATA[");
		sb.append(getRootMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootMessageUserId</column-name><column-value><![CDATA[");
		sb.append(getRootMessageUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageCount</column-name><column-value><![CDATA[");
		sb.append(getMessageCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPostByUserId</column-name><column-value><![CDATA[");
		sb.append(getLastPostByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPostDate</column-name><column-value><![CDATA[");
		sb.append(getLastPostDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question</column-name><column-value><![CDATA[");
		sb.append(getQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MBThread.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MBThread.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _threadId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private long _rootMessageId;
	private long _originalRootMessageId;
	private boolean _setOriginalRootMessageId;
	private long _rootMessageUserId;
	private String _rootMessageUserUuid;
	private int _messageCount;
	private int _viewCount;
	private long _lastPostByUserId;
	private String _lastPostByUserUuid;
	private Date _lastPostDate;
	private Date _originalLastPostDate;
	private double _priority;
	private double _originalPriority;
	private boolean _setOriginalPriority;
	private boolean _question;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private MBThread _escapedModel;
}