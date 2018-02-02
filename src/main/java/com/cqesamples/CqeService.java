package com.cqesamples;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.persistence.disk.DiskPersistence;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.resultset.ResultSet;
import com.netflix.spectator.api.Counter;
import com.netflix.spectator.api.Timer;
import com.netflix.spectator.metrics3.MetricsRegistry;

public class CqeService {
    
    private static MetricsRegistry REGISTRY = MatricsManager.registry();
    private static Timer queryTimer = REGISTRY.timer("query.timer");
    private static Timer loadTimer = REGISTRY.timer("load.timer");
    private static Counter jobsCounter = REGISTRY.counter("jobs.counter");
    private ConcurrentIndexedCollection<JobAssignment> indexedCollection;
    private QueryOptions orderByOption;
    
    public CqeService() {
        File file = new File("test.db");
        indexedCollection  = new ConcurrentIndexedCollection<JobAssignment>(DiskPersistence.onPrimaryKeyInFile(Attributes.CONQUER_JOB_ID, file));
        indexedCollection.addIndex(HashIndex.onAttribute(Attributes.EAR_ID));
        indexedCollection.addIndex(NavigableIndex.onAttribute(Attributes.DATE_SCHEDULED));
        
        orderByOption = QueryFactory.queryOptions(QueryFactory.orderBy(QueryFactory.ascending(Attributes.DATE_SCHEDULED)));
    }
    
    public void loadJobs(Stream<JobAssignment> assignments){
        loadTimer.record(() -> {
            assignments.forEach(ja -> indexedCollection.add(ja));
        });
    }
    
    public List<JobAssignment> query(final long earId){
        final long start = REGISTRY.clock().monotonicTime();
        try {
            Query<JobAssignment> jobAssignmentsQuery = QueryFactory.equal(Attributes.EAR_ID, earId);
            ResultSet<JobAssignment> result = indexedCollection.retrieve(jobAssignmentsQuery, orderByOption);
            List<JobAssignment> list = new LinkedList<>();
            result.forEach(list::add);
            return list;
        } finally{
            final long end = REGISTRY.clock().monotonicTime();
            queryTimer.record(end - start, TimeUnit.NANOSECONDS);
        }
    }
    
    public int size(){
        return indexedCollection.size();
    }
}
