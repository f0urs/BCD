
package com.webapp.ejb;

import com.webapp.entity.employee;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface STMDBSessionBeanRemote {
    List<employee> getData();
    
    void save(employee employee);
}
