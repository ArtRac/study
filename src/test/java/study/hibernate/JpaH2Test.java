package study.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.hibernate.model.Message;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaH2Test {

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("myPU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

    @Test
    void message_OneTableSetGet() {
        et.begin();
        Message message = new Message();
        message.setText("Działa!");
        em.persist(message);
        et.commit();

        et.begin();
        List<Message> messages = em.createQuery("select m from Message m").getResultList();
        assertEquals(messages.get(0).getText(), "Działa!");

        messages.get(0).setText("Nowy text.");
        et.commit();// Aktualizacja zmienionej wartości.

        List<Message> newMessages = em.createQuery("select m from Message m").getResultList();
        assertEquals(newMessages.get(0).getText(), "Nowy text.");
    }
}