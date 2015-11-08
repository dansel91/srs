/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BaseService<T> {
    private EntityManager em;

    public BaseService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("srsPU");
        em = emf.createEntityManager();
    }

    public T getById(String namedQuery, int id) {
        List<T> results = em.createNamedQuery(namedQuery).setParameter("id", id).getResultList();
        if (results == null || results.isEmpty()) return null;
        else return results.get(0);
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
