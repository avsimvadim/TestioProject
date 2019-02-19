package ua.artcode.testio.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import static java.util.Arrays.stream;

public class JPQLExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        //jpql (java persistence query language), hql, sql + oop
        Query query =
                manager.createQuery("SELECT u FROM Student AS u WHERE u.name=:inName");
        List list =
                query.setParameter("inName", "Serhii")
                .setFirstResult(0)
                .setMaxResults(2).getResultList();
        list.stream().forEach(System.out::println);
    }
}
