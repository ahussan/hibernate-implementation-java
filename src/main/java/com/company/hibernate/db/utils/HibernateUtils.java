package com.company.hibernate.db.utils;

import com.company.hibernate.enums.Schema;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.company.hibernate.enums.DataSource.AUTOMATION_SOURCE;
import static com.company.hibernate.enums.Schema.AUTOMATION;

/**
 * Created by anjalhussan on 10/25/16.
 */
public class HibernateUtils {

    private static final Map<Schema, SessionFactory> FACTORIES = Collections.unmodifiableMap((
            new HashMap<Schema, SessionFactory>() {
                {
                    put(AUTOMATION, configureSessionFactory(AUTOMATION_SOURCE.getSource()));
                }
            }));

    private HibernateUtils() {
    }

    private static SessionFactory configureSessionFactory(final String dataSource) {
        final Configuration configuration = new Configuration().configure(dataSource);
        final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(final Schema schema) {
        return FACTORIES.get(schema);
    }
}

