
package com.webapp.ejb;

import com.webapp.entity.managerLogin;
import javax.ejb.Local;


@Local
public interface managerLoginSessionBeanLocal {
    void save(managerLogin managerLogin);
}
