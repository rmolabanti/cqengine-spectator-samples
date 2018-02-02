package com.cqesamples;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.netflix.spectator.api.Clock;
import com.netflix.spectator.metrics3.MetricsRegistry;

public class MatricsManager {
    
    private static MetricsRegistry registry;
    private static ScheduledReporter reporter;
    
    private MatricsManager() {}
    
    public static MetricsRegistry registry(){
        if (registry==null) {
            MetricRegistry codaRegistry = new MetricRegistry();
            reporter = consoleReporter(codaRegistry);
            registry = new MetricsRegistry(Clock.SYSTEM,codaRegistry);
        }  
        return registry;
    }
    
    private static ConsoleReporter consoleReporter(MetricRegistry codaRegistry){
        ConsoleReporter reporter= ConsoleReporter.forRegistry(codaRegistry).build();
        //reporter.start(1000, TimeUnit.MILLISECONDS);
        return reporter;
    }
    
    public static void report(){
        if (reporter!=null) {
            reporter.report();
        }
    }
    
}
