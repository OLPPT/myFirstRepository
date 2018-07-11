package com.example.demo.quartz;

import org.quartz.*;

/**
 * Created by OL-PC on 2018/07/04.
 */
public class HelloJob implements org.quartz.Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz"+System.currentTimeMillis());
    }
}
