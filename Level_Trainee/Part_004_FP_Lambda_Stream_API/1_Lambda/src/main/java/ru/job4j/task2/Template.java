package ru.job4j.task2;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Template.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Template {

    /**
     * The useTransaction method.
     *
     * @param query to execute.
     * @param <R>   a result type.
     * @return a result of execution query in case of success.
     */
    public <R> Function<Session, Optional<R>> useTransaction(Function<Session, R> query) {
        return session -> {
            Transaction transaction = session.beginTransaction();
            R result = null;
            try {
                result = query.apply(session);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
            return Optional.ofNullable(result);
        };
    }

    /**
     * The method save.
     *
     * @param entity to be save.
     * @return id in db.
     */
    public Function<Session, Optional<Serializable>> save(Object entity) {
        return this.useTransaction(session -> session.save(entity));
    }

    /**
     * The method findBy.
     *
     * @param criteria to search.
     * @param <E> a entity type.
     * @return a list of all entity satisfying criteria.
     */
    public <E> Function<Session, Optional<List<E>>> findBy(String criteria) {
        return this.useTransaction(session -> session.createQuery(criteria).list());
    }

    /**
     * The method findAll.
     *
     * @param query       to execute.
     * @param entityClass class of entity.
     * @param <E>         a entity type.
     * @return a list af all entity in db.
     */
    public <E> Function<Session, Optional<List<E>>> findAll(String query, Class<E> entityClass) {
        return this.useTransaction(session -> session.createQuery(query, entityClass).list());
    }

    /**
     * The method update.
     *
     * @param entity to be refreshed.
     * @return true in case of success, or false - otherwise.
     */
    public Function<Session, Boolean> update(Object entity) {
        return this.useTransaction(session -> {
            session.update(entity);
            return true;
        }).andThen(Optional::isPresent);
    }

    /**
     * The method delete.
     * @param entity to be removed.
     * @return true in case of success, or false - otherwise.
     */
    public Function<Session, Boolean> delete(Object entity) {
        return this.useTransaction(session -> {
            session.delete(entity);
            return true;
        }).andThen(Optional::isPresent);
    }
}
