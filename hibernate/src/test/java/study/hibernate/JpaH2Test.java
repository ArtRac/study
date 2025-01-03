package study.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.hibernate.model.Author;
import study.hibernate.model.Book;
import study.hibernate.model.Details;
import study.hibernate.model.Message;

import java.math.BigDecimal;
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
    void messageOneTableSetGet() {
        et.begin();
        Message message = new Message();
        message.setText("Działa!");
        em.persist(message);

        List<Message> messages = em.createQuery("select m from Message m").getResultList();
        assertEquals("Działa!", messages.getFirst().getText());

        messages.getFirst().setText("Nowy text.");
        et.commit();// Aktualizacja zmienionej wartości.

        List<Message> newMessages = em.createQuery("select m from Message m").getResultList();
        assertEquals("Nowy text.", newMessages.getFirst().getText());
    }

    @Test
    void authorAndBookWithDetailsType() {
        et.begin();

        Author author = new Author();

        author.setName("Jan Kowalski");
        em.persist(author);

        Book book = new Book("W pustyni i w paszczy.", author);

        Details details = new Details();
        details.setDescription("Słaba!");
        details.setPrice(BigDecimal.valueOf(1111.11));
        book.setDetails(details);

        author.getBooks().add(book);
        // Tablica BOOKS aktualizuje się kaskadowo bez użycia dodatkowych persist()
        et.commit();

        Author reult = em.createQuery("select a from Author a",Author.class).getResultList().getFirst();
        assertEquals("Słaba!", reult.getBooks().stream().findFirst().get().getDetails().getDescription());
    }
}