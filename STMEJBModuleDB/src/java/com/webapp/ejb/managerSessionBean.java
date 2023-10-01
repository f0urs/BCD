package com.webapp.ejb;

import com.webapp.entity.manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Interceptors({MyInterceptor.class})
@Stateless
public class managerSessionBean implements managerSessionBeanRemote, managerSessionBeanLocal {

    @PersistenceContext(unitName = "STMEJBModuleDBPU")
    private EntityManager em;

    @Override
    public void save(manager manager) {
        em.persist(manager);
    }

    @Override
    public void update(manager manager) {
        em.merge(manager);
    }

    @Override
    public void delete(manager manager) {
        em.remove(manager);
    }

    @Override
    public manager findById(Integer managerId) {
        return em.find(manager.class, managerId);
    }

    @Override
    public manager findByEmail(String email) {
        TypedQuery<manager> query = em.createQuery("SELECT t FROM manager t WHERE t.email=:email",manager.class);
        query.setParameter("email", email);
        manager manager = query.getSingleResult();
        return manager;
    }

    @Override
    public List<manager> getAll() {
        return em.createQuery("SELECT t FROM manager t", manager.class).getResultList();
    }

}
