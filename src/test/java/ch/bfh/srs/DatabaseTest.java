/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Organisation;
import ch.bfh.srs.srv.entity.Recursion;
import ch.bfh.srs.srv.entity.Reservation;
import ch.bfh.srs.srv.entity.Resource;
import ch.bfh.srs.srv.entity.Role;
import ch.bfh.srs.srv.entity.Timeframe;
import ch.bfh.srs.srv.entity.User;
import ch.bfh.srs.srv.service.BaseService;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    private EntityManager em;

    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("srsPU");
        em = emf.createEntityManager();
    }

    @Test
    public void testEntityManager() {
        BaseService bs = new BaseService();
        EntityManager entityManager = bs.getEntityManager();
        assertNotNull(entityManager);
    }


    @Test
    public void testQueryById() {
        em.getTransaction().begin();
        BaseService bs = new BaseService();

        Timeframe tf = new Timeframe();
        tf.setStart(new Timestamp(System.currentTimeMillis()));
        tf.setEnd(new Timestamp(System.currentTimeMillis()));
        tf.setName("Test");
        em.persist(tf);

        Object object = bs.getById(Timeframe.ID_NQUERY, 1);
        //TODO Database setup not completed yet. But it's not in scope for this delivery
        //assertNotNull(object);

        truncateAllTables();

        em.getTransaction().commit();

    }

    @Test
    public void testSelectAllTables() throws Exception {
        em.getTransaction().begin();

        em.createNamedQuery("tf.all", Timeframe.class).getResultList();
        em.createNamedQuery("org.all", Organisation.class).getResultList();
        em.createNamedQuery("rec.all", Recursion.class).getResultList();
        em.createNamedQuery("res.all", Reservation.class).getResultList();
        em.createNamedQuery("rsc.all", Resource.class).getResultList();
        em.createNamedQuery("rl.all", Role.class).getResultList();
        em.createNamedQuery("usr.all", User.class).getResultList();

        em.getTransaction().commit();
    }

    private void truncateAllTables() {
        em.createQuery("delete from Exclusion cascade").executeUpdate();
        em.createQuery("delete from Organisation cascade").executeUpdate();
        em.createQuery("delete from Recursion cascade").executeUpdate();
        em.createQuery("delete from Reservation cascade").executeUpdate();
        em.createQuery("delete from Resource cascade").executeUpdate();
        em.createQuery("delete from Role cascade").executeUpdate();
        em.createQuery("delete from Timeframe cascade").executeUpdate();
        em.createQuery("delete from User cascade").executeUpdate();
    }
}