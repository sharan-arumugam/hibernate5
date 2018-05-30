package io.hibernatelazy.util;

import static io.hibernatelazy.Constants.CONNECTION_URL;
import static io.hibernatelazy.Constants.DRIVER;
import static io.hibernatelazy.Constants.HBM2DDL_AUTO;
import static io.hibernatelazy.Constants.PASSWORD;
import static io.hibernatelazy.Constants.SHOW_SQL;
import static io.hibernatelazy.Constants.USERNAME;
import static java.util.Collections.unmodifiableMap;

import lombok.SneakyThrows;
import lombok.Synchronized;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

import io.hibernatelazy.entity.Address;
import io.hibernatelazy.entity.Student;

/**
 * Utility for Session Management
 * 
 * @author Sharan Arumugam
 * @version 1.0
 */
public class SessionUtil {

    private static SessionFactory sessionFactory;

    private SessionUtil() {
    }

    @Synchronized
    public static SessionFactory getSessionFactory() {
        return null != sessionFactory ? sessionFactory : initSessionFactory();
    }

    @SneakyThrows
    private static SessionFactory initSessionFactory() {

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        registryBuilder.applySettings(getSettings());

        sessionFactory = new MetadataSources(registryBuilder.build())
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .getMetadataBuilder()
                .build()
                .getSessionFactoryBuilder()
                .build();

        return sessionFactory;
    }

    private final static Map<String, String> getSettings() {

        Map<String, String> settings = new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;
            {
                put("hibernate.connection.driver_class", DRIVER);
                put("hibernate.connection.url", CONNECTION_URL);
                put("hibernate.connection.username", USERNAME);
                put("hibernate.connection.password", PASSWORD);
                put("hibernate.show_sql", SHOW_SQL);
                put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
            }
        };

        return unmodifiableMap(settings);
    }

}
