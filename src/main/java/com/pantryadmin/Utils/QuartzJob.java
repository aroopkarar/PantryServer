package com.pantryadmin.Utils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzJob implements Job {

    private Logger log = LoggerFactory.getLogger(QuartzJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        try {
            log.info("Running Quartz Job after each 1 second");
            //Task to be done
        } catch (Exception ex) {
            log.error("Exception in QuartzJob Scheduler class: " + ex);
        }
    }
}