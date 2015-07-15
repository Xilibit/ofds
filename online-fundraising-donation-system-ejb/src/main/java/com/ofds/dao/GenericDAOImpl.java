package com.ofds.dao;

import com.sun.deploy.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

    protected Class<T> entityClass;

    /**
     * Class constructor.
     * @param entityClass - Class type of the entity.
     */
    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Method to get Entity Manager.
     * @return - EntityManager object.
     */
    protected abstract EntityManager getEntityManager();

    /**
     * The method is to load all entities.
     * @return - List of the entities.
     */
    @Override
    public List<T> loadAll() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();
    }

    /**
     * The method is to save the entity.
     * @param entity - entity to save.
     */
    @Override
    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * The method is to edit the entity.
     * @param entity - entity to update.
     */
    @Override
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * The method is to remove the entity.
     * @param entity - entity to delete.
     */
    @Override
    public void remove(T entity) {
        getEntityManager().remove(entity);
    }

    /**
     * The method is to find the entity by id.
     * @param id - the entity id.
     * @return - The found entity.
     */
    @Override
    public T find(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * The method is to find entities by range criteria.
     * @param range - array of values.
     * @return List of the entities.
     */
    @Override
    public List<T> findRange(int[] range) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> typedQuery = getEntityManager().createQuery(all);
        typedQuery.setMaxResults(range[1] - range[0] + 1);
        typedQuery.setFirstResult(range[0]);
        return typedQuery.getResultList();
    }

    /**
     * The method is to count the entities.
     * @return The count.
     */
    @Override
    public int count() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        CriteriaQuery<Long> all = criteriaQuery.select(getEntityManager().getCriteriaBuilder().count(rootEntry));
        TypedQuery<Long> allQuery = getEntityManager().createQuery(all);
        return allQuery.getSingleResult().intValue();
    }

    /**
     * The method is to get entities by parameter.
     * @param entityParameter - the parameter. Example: column name - fundraiserEmail, entityParameter will be Email.
     * @return - the list of the entities.
     */
    @Override
    public List<T> getByEntityParameter(String entityParameter, String parameterValue) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        Predicate predicate = criteriaBuilder.equal(rootEntry.get(entityClass.getSimpleName().toLowerCase()
                + entityParameter), parameterValue);
        criteriaQuery.where(predicate);
        TypedQuery<T> typedQuery = getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    /**
     * The method is to get the list of entities exclude parameter values.
     * @param entityParameter - the parameter to exclude.
     *                        Example: column name - fundraiserEmail, entityParameter will be Email.
     * @return - the list of the entities.
     */
    @Override
    public List<T> getAllByEntityExcludeParameter(String entityParameter, String parameterValue) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        Predicate predicate = criteriaBuilder.notEqual(rootEntry.get(entityClass.getSimpleName().toLowerCase()
                + entityParameter), parameterValue);
        criteriaQuery.where(predicate);
        TypedQuery<T> typedQuery = getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
