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
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class DatabaseTest {

    private EntityManager em;

    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("srsPU");
        em = emf.createEntityManager();
    }

    @Test
    public void testName() throws Exception {
        em.getTransaction().begin();

        Timeframe tf = new Timeframe();
        tf.setStart(new Timestamp(System.currentTimeMillis()));
        tf.setEnd(new Timestamp(System.currentTimeMillis()));
        tf.setName("Test");
        em.persist(tf);

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
        em.createNativeQuery("select truncate_tables('postgres')").getSingleResult();
    }
}
