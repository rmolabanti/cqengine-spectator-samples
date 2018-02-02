package com.cqesamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CqeServiceTest {

    ObjectMapper mapper = new ObjectMapper();
    long conquerId  = 0;
    
    @Test
    public void simpleOne(){
        CqeService cqeService = new CqeService();
        JobAssignment assignment = new JobAssignment();
        assignment.setConquerJobId(1);
        assignment.setEarId(1);
        cqeService.loadJobs(Collections.singleton(assignment).stream());
        cqeService.query(1);
        MatricsManager.report();
    }
    
    
    @Test
    public void fromFile() throws IOException{
        Path path = Paths.get("/Users/rmolabanti/devhome/reputation/oneDayJobs.txt");
        Stream<JobAssignment> jobs = Files.lines(path).map(s -> s.replaceAll("\"\"", "\"").replaceAll("^\"", "").replaceAll("\"$", "")).filter(s -> s.length() > 0).map(s -> convert(s)).limit(1);
        CqeService cqeService = new CqeService();
        cqeService.loadJobs(jobs);
        System.out.println("index collection size :"+cqeService.size());
        IntStream.range(1, 100).forEach(i -> cqeService.query((long)(Math.random()*1000)));
        MatricsManager.report();
    }
    
    private JobAssignment convert(String s){
        try {
            Map<String,Object> map = mapper.readValue(s, Map.class);
            JobAssignment assignment = new JobAssignment();
            assignment.setConquerJobId(conquerId++);
            assignment.setEarId((long)(Math.random()*1000));
            return assignment;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
