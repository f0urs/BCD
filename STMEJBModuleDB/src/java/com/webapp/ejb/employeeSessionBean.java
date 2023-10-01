
package com.webapp.ejb;

import com.webapp.entity.employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Interceptors({MyInterceptor.class})
@Stateless
public class employeeSessionBean implements employeeSessionBeanRemote, employeeSessionBeanLocal {

    @PersistenceContext(unitName = "STMEJBModuleDBPU")
    private EntityManager em;
            
    @Override
    public void save(employee employee) {
        em.persist(employee);
    }

    @Override
    public void update(employee employee) {
        em.merge(employee);
    }

    @Override
    public void delete(employee employee) {
        em.remove(employee);
    }

    @Override
    public employee findById(Integer employeeId) {
        return em.find(employee.class, employeeId);
    }

    @Override
    public employee findByEmail(String email) {
        TypedQuery<employee> query = em.createQuery("SELECT s FROM employee s WHERE s.email=:email",employee.class);
        query.setParameter("email", email);
        employee employee = query.getSingleResult();
        return employee;
    }

    @Override
    public List<employee> getAll() {
        return em.createQuery("SELECT s FROM employee s", employee.class).getResultList();
    }

    
   
}
