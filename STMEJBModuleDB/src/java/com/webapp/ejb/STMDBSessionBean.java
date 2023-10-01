
package com.webapp.ejb;

import com.webapp.entity.employee;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class STMDBSessionBean implements STMDBSessionBeanRemote {

    @PersistenceContext(unitName = "STMEJBModuleDBPU")
    private EntityManager em;
    
    @Resource
    UserTransaction ut;
    
    @Override
    public List<employee> getData() {
        List<employee> employees = em.createQuery("SELECT s FORM employee s", employee.class).getResultList();
        return employees;
    }

    @Override
    public void save(employee employee) {
        try {
            ut.begin();
        } catch (Exception e) {
        }
        try {
            ut.commit();
        } catch (Exception e) {
        }
    }
    
}
