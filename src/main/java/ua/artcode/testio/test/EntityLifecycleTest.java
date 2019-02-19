package ua.artcode.testio.test;

import ua.artcode.testio.model.Student;
import ua.artcode.testio.service.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class EntityLifecycleTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Student student = new Student("Serhii", StudentType.JUNIOR, new Date(), "bdbdb");

        //delete
        manager.getTransaction().begin();
        Student student1 = manager.find(Student.class, 1);
        manager.remove(student1);
        manager.getTransaction().commit();
    }
}
