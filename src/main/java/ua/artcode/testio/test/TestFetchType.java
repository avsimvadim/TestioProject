package ua.artcode.testio.test;

import ua.artcode.testio.model.Course;
import ua.artcode.testio.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFetchType {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Teacher teacher1 = new Teacher("Bloch",5);
        for (int i = 0; i < 1000; i++) {
            teacher1.getCourse().add(new Course(String.valueOf(i), "descripton", teacher1));
        }

        manager.getTransaction().begin();
        manager.persist(teacher1);
        manager.getTransaction().commit();

        manager.clear();

        Teacher teacher = (Teacher) manager.createQuery("SELECT t FROM Teacher t WHERE t.name=:name")
                .setParameter("name","Bloch").getSingleResult();
    }
}
