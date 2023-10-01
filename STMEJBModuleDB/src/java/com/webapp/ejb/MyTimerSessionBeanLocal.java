
package com.webapp.ejb;

import java.sql.Time;
import javax.ejb.Local;


@Local
public interface MyTimerSessionBeanLocal {
    public void myTimer(Time timer);
}
