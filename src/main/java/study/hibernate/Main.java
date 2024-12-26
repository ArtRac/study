package study.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static void main(String[] args) {

        System.out.println("Hellow");

    }

}
