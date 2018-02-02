package com.cqesamples;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class Attributes {

    public static final SimpleAttribute<JobAssignment, Long> CONQUER_JOB_ID = new SimpleAttribute<JobAssignment, Long>(
        "CONQUER_JOB_ID") {
        @Override
        public Long getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getConquerJobId();
        }

    };

    public static final Attribute<JobAssignment, Long> NODE_ID = new SimpleAttribute<JobAssignment, Long>("NODE_ID") {
        @Override
        public Long getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getNodeId();
        }

    };

    public static final Attribute<JobAssignment, String> EXTERNAL_JOB_ID = new SimpleAttribute<JobAssignment, String>(
        "EXTERNAL_JOB_ID") {
        @Override
        public String getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getExternalJobId();
        }

    };

    public static final Attribute<JobAssignment, Long> EAR_ID = new SimpleAttribute<JobAssignment, Long>("EAR_ID") {
        @Override
        public Long getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getEarId();
        }
    };

    public static final Attribute<JobAssignment, StatusCode> STATUS_CODE = new SimpleAttribute<JobAssignment, StatusCode>(
        "STATUS_CODE") {
        @Override
        public StatusCode getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getStatusCode();
        }
    };

    public static final Attribute<JobAssignment, Integer> PRIORITY = new SimpleAttribute<JobAssignment, Integer>(
        "PRIORITY") {
        @Override
        public Integer getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getPriority();
        }
    };

    public static final Attribute<JobAssignment, Long> DATE_SCHEDULED = new SimpleAttribute<JobAssignment, Long>(
        "DATE_SCHEDULED") {
        @Override
        public Long getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getDateScheduled();
        }
    };

    public static final Attribute<JobAssignment, Long> PRE_DETERMINED_EXEC_TIME = new SimpleAttribute<JobAssignment, Long>(
        "PRE_DETERMINED_EXEC_TIME") {
        @Override
        public Long getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.getPreDeterminedExecTime();
        }
    };

    public static final Attribute<JobAssignment, Boolean> EXEC_ON_TIME = new SimpleAttribute<JobAssignment, Boolean>(
        "EXEC_ON_TIME") {
        @Override
        public Boolean getValue(JobAssignment jobAssignment, QueryOptions queryOptions) {
            return jobAssignment.isExecOnTime();
        }
    };
}
