package com.ofds.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {

    /**
     * Method is to load all objects.
     * @return List of all objects specified by type.
     */
    List<T> loadAll();

    /**
     * Mathod is to save the specified entity.
     * @param entity - entity to save.
     */
    void save(T entity);

    /**
     * Method is edit the specified entity.
     * @param entity - entity to update.
     */
    void edit(T entity);

    /**
     * Method is to remove the specified entity.
     * @param entity - entity to delete.
     */
    void remove(T entity);

    /**
     * Method is to find an entity by id.
     * @param id - the entity id.
     * @return - Entity specified by Type.
     */
    T find(PK id);

    /**
     * Method is to find by range.
     * @param range - array of values.
     * @return - List of the objects with range range[1] - range[0] + 1.
     */
    List<T> findRange(int[] range);

    /**
     * Method is to count the specified objects.
     * @return - the count of the objects.
     */
    int count();

    /**
     * The method is to get the list of entities by Entity Parameter.
     * @return - the list of the objects.
     */
    List<T> getByEntityParameter(String entityParameter);

    /**
     * The method is to get the list of entities exclude parameter values.
     * @param entityParameter - the parameter to exclude.
     * @return - the list of the entities.
     */
    List<T> getAllByEntityExcludeParameter(String entityParameter);
}
