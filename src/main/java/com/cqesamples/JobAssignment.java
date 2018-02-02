package com.cqesamples;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobAssignment {
	private static final Logger logger = LoggerFactory.getLogger(JobAssignment.class);
	private static final long START_TIME = System.currentTimeMillis();
	private long conquerJobId;
	private int priority;
	private String jobJson;
	private long earId;
	private long nodeId;
	private StatusCode statusCode;
	private int dateScheduled;
	private String externalJobId;
	private String channelKey;
	private long preDeterminedExecTime;
	private String createdBy;
	private boolean execOnTime;
	private int jobsCount;
	private int maxAssignment;
	private long actualDateScheduled;
	private long timeout;

	public JobAssignment() {

	}

	public JobAssignment(long conquerJobId, long earId, Integer priority, String jobJson, StatusCode statusCode,
			Date dateScheduled, String channelKey, Long preDeterminedExecTime, String createdBy, boolean execOnTime,
			long timeout) {
		super();
		try {
			this.conquerJobId = conquerJobId;
			this.jobJson = jobJson;
			this.earId = earId;
			this.statusCode = statusCode;
			this.dateScheduled = Math
					.toIntExact(dateScheduled != null ? (dateScheduled.getTime() - START_TIME) / 600_000L : 0L); // sliced
																													// by
																													// 10minutes
																													// since
																													// server
																													// start.
																													// --Aug/07/2017
			this.actualDateScheduled = dateScheduled.getTime();
			this.priority = priority != null ? priority : 0;
			this.channelKey = channelKey;
			if (preDeterminedExecTime != null) {
				this.preDeterminedExecTime = preDeterminedExecTime;
			} else {
				this.preDeterminedExecTime = 0l;
			}
			this.createdBy = createdBy;
			this.execOnTime = execOnTime;
			this.timeout = timeout;
		} catch (Exception e) {
			logger.error("Exception at job assignment constructor", e);
			throw new RuntimeException(e);
		}
	}

	public JobAssignment(long conquerJobId, long earId, Integer priority, StatusCode statusCode, Date dateScheduled,
			String channelKey, Long preDeterminedExecTime, String createdBy, boolean execOnTime, long timeout) {
		super();
		try {
			this.conquerJobId = conquerJobId;
			this.earId = earId;
			this.statusCode = statusCode;
			this.dateScheduled = Math
					.toIntExact(dateScheduled != null ? (dateScheduled.getTime() - START_TIME) / 600_000L : 0L); // sliced
																													// by
																													// 10minutes
																													// since
																													// server
																													// start.
																													// --Aug/07/2017
			this.actualDateScheduled = dateScheduled.getTime();
			this.priority = priority != null ? priority : 0;
			this.channelKey = channelKey;
			if (preDeterminedExecTime != null) {
				this.preDeterminedExecTime = preDeterminedExecTime;
			} else {
				this.preDeterminedExecTime = 0l;
			}
			this.createdBy = createdBy;
			this.execOnTime = execOnTime;
			this.timeout = timeout;
		} catch (Exception e) {
			logger.error("Exception at job assignment constructor", e);
			throw new RuntimeException(e);
		}
	}

	public JobAssignment(long conquerJobId, long earId, Integer priority, String jobJson, StatusCode statusCode,
			Date dateScheduled, String externalId, String channelKey, Long preDeterminedExecTime, String createdBy,
			boolean execOnTime, long timeout) {
		this(conquerJobId, earId, priority, jobJson, statusCode, dateScheduled, channelKey, preDeterminedExecTime,
				createdBy, execOnTime, timeout);
		this.externalJobId = externalId;
	}

	public JobAssignment(long conquerJobId, long earId, Integer priority, StatusCode statusCode, Date dateScheduled,
			String externalId, String channelKey, Long preDeterminedExecTime, String createdBy, boolean execOnTime,
			long timeout) {
		this(conquerJobId, earId, priority, statusCode, dateScheduled, channelKey, preDeterminedExecTime, createdBy,
				execOnTime, timeout);
		this.externalJobId = externalId;
	}

	public long getConquerJobId() {
		return conquerJobId;
	}

	public void setConquerJobId(long conquerJobId) {
		this.conquerJobId = conquerJobId;
	}

	public long getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(int dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getJobJson() {
		return jobJson;
	}

	public void setJobJson(String jobJson) {
		this.jobJson = jobJson;
	}

	public long getEarId() {
		return earId;
	}

	public void setEarId(long earId) {
		this.earId = earId;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getExternalJobId() {
		return externalJobId;
	}

	public void setExternalJobId(String externalJobId) {
		this.externalJobId = externalJobId;
	}

	public String getChannelKey() {
		return channelKey;
	}

	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

	public long getPreDeterminedExecTime() {
		return preDeterminedExecTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setPreDeterminedExecTime(long preDeterminedExecTime) {
		this.preDeterminedExecTime = preDeterminedExecTime;
	}

	public boolean isExecOnTime() {
		return execOnTime;
	}

	public void setExecOnTime(boolean execOnTime) {
		this.execOnTime = execOnTime;
	}

	public int getJobsCount() {
		return jobsCount;
	}

	public void setJobsCount(int jobsCount) {
		this.jobsCount = jobsCount;
	}

	public int getMaxAssignment() {
		return maxAssignment;
	}

	public void setMaxAssignment(int maxAssignment) {
		this.maxAssignment = maxAssignment;
	}

	public long getActualDateScheduled() {
		return actualDateScheduled;
	}

	public void setActualDateScheduled(long actualDateScheduled) {
		this.actualDateScheduled = actualDateScheduled;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (conquerJobId ^ (conquerJobId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobAssignment other = (JobAssignment) obj;
		if (conquerJobId != other.conquerJobId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JobAssignment [conquerJobId=" + conquerJobId + ", priority=" + priority + ",  earId=" + earId
				+ ", nodeId=" + nodeId + ", statusCode=" + String.valueOf(statusCode) + ", dateScheduled="
				+ dateScheduled + ", externalJobId=" + String.valueOf(externalJobId) + ", channelKey=" + channelKey
				+ "]";
	}
}
