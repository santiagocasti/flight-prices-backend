package com.fly.me.tasks;

import com.fly.me.controllers.ImportsController;
import com.fly.me.repositories.ImportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    protected ImportsController importsController;

    /**
     * @Scheduled triggers a task based on its parameters.
     * In this case: @Scheduled(fixedRate = 5000), every 5 seconds.
     */
    @Scheduled(fixedRate = 3600000)
    public void triggerImport() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        this.importsController.tryApacheHttpClient();

    }
}
