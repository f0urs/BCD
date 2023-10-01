
package com.webapp.ejb;

import com.webapp.entity.employee;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface employeeSessionBeanRemote {
    void save (employee employee);
    
    void update(employee employee);
    
    void delete (employee employee);
    
    employee findById(Integer employeeId);
    
    employee findByEmail(String email);
    
    List<employee> getAll();
}
