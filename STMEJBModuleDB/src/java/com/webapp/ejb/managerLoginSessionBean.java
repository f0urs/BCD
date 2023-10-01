
package com.webapp.ejb;

import com.webapp.entity.managerLogin;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class managerLoginSessionBean implements managerLoginSessionBeanRemote, managerLoginSessionBeanLocal {

    @PersistenceContext(unitName = "STMEJBModuleDBPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void save(managerLogin managerLogin) {
        System.out.println(em);
        em.persist(managerLogin);
    }
}
