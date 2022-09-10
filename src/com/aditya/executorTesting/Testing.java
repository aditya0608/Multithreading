package com.aditya.executorTesting;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
public class Testing {
static Logger logger= Logger.getLogger(String.valueOf(Testing.class));
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(()->{
        try
        {
            System.out.println(1/0);
        }
        catch(Exception exception)
        {
            logger.info(exception.getLocalizedMessage());
        }
        },1000l,3000l, TimeUnit.MILLISECONDS);
    }
}
