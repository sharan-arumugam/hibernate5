package io.hibernatelazy.util;

import static io.hibernatelazy.util.SessionUtil.getSessionFactory;

import org.hibernate.Session;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Utility for Querying
 * 
 * @author Sharan Arumugam
 * @version 1.0
 */
import io.hibernatelazy.entity.Student;

public final class QueryUtil {
    private static final Session currentSession = getSessionFactory().openSession();

    private QueryUtil() {
    }

    public static List<Student> findAllStudents() {

        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

        Root<Student> rootSelection = criteriaQuery.from(Student.class);
        criteriaQuery.select(rootSelection);

        return currentSession.createQuery(criteriaQuery).list();
    }
}
