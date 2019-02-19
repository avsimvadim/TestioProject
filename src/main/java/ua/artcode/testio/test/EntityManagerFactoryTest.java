package ua.artcode.testio.test;

import ua.artcode.testio.model.Student;
import ua.artcode.testio.service.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class EntityManagerFactoryTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student("Serhii", StudentType.JUNIOR, new Date(), "bdbdb");

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

        entityManager = entityManagerFactory.createEntityManager();

        Student st1 = entityManager.find(Student.class, 1);

        System.out.println(st1);
    }
}
