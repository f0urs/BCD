
package com.webapp.ejb;

import com.webapp.entity.managerLogin;
import javax.ejb.Remote;


@Remote
public interface managerLoginSessionBeanRemote {
    void save(managerLogin managerLogin);
}
