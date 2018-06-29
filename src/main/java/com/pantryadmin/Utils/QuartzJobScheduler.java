package com.pantryadmin.Utils;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class QuartzJobScheduler {
    private Logger log = LoggerFactory.getLogger(QuartzJobScheduler.class);

    @PostConstruct
    private void runSchedulingJob()
    {
        try {
            //Creating scheduler factory and scheduler
            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();

            //Creating Job and link to our Job class
            JobDetailImpl jobDetail = new JobDetailImpl();
            jobDetail.setName("Map Caching Job");
            jobDetail.setJobClass(QuartzJob.class);

            //Creating schedule time with trigger
            SimpleTriggerImpl trigger = new SimpleTriggerImpl();
            trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
            trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
            trigger.setRepeatInterval(1000*1); //for 1 sec
            trigger.setName("Map Caching Trigger");

            //Start scheduler
            scheduler.start();
            log.info("Quartz Scheduler Started.");
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch(SchedulerException se) {
            log.error("Exception in Scheduling Quartz Job: ",se);
        }
        catch (Exception e) {
            log.error("Exception in Scheduling Quartz Job: ",e);
        }
    }
}
