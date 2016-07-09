package com.fly.me.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fly.me.repositories.ImportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    protected ImportsRepository importsRepository;

    @Autowired
    public ScheduledTask(ImportsRepository importsRepository){
        this.importsRepository = importsRepository;
    }

    /**
     * @Scheduled triggers a task based on its parameters.
     * In this case: @Scheduled(fixedRate = 5000), every 5 seconds.
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
//        this.importsRepository.recordNewImport(new Date());
    }
}
