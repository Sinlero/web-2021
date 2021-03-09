package ru.bgpu.lec.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.bgpu.lec.hibernate.models.User;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        // Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);
        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
        // Create SessionFactory
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        EntityManager manager = sessionFactory.createEntityManager();

        manager.getTransaction().begin();
        User user1 = new User();
//        user1.setId(1L);
        user1.setName("Вася");
        manager.persist(user1);
        manager.getTransaction().commit();

        User f = manager.find(User.class, 1L);
//        manager.find(User.class, 2L);

        System.out.println(f.getName());

    }
}
