package com.webapp.ejb;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Schedules;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timer;

@Stateless
public class MyTimerSessionBean implements MyTimerSessionBeanRemote, MyTimerSessionBeanLocal {
    
    @Resource
    private SessionContext context;
    
    
    @Schedules({
        @Schedule(persistent = false,dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*"),
        @Schedule(persistent = false,dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*"),
        @Schedule(persistent = false,dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*"),
    })

    @Override
    public void myTimer(Timer timer) {
        System.out.println("Timer event: " + new Date());
        timer.cancel();
    }

    @Override
    public void createTimer(long duration) {
        ScheduleExpression se = new ScheduleExpression();
        se.hour("*");
        se.minute("*");
        se.second("*/"+duration);
        Timer timer = context.getTimerService().createCalendarTimer(se);
    }

    @Override
    public void myTimer(Time timer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
