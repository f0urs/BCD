
package com.webapp.ejb;


import com.webapp.entity.manager;
import java.util.List;
import javax.ejb.Local;


@Local
public interface managerSessionBeanLocal {
    void save (manager manager);
    
    void update(manager manager);
    
    void delete (manager manager);
    
    manager findById(Integer managerId);
    
    manager findByEmail(String email);
    
    List<manager> getAll();
}
