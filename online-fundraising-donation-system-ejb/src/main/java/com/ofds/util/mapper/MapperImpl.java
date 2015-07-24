package com.ofds.util.mapper;

import java.io.Serializable;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Manage the default mapper operation realization.
 */
public abstract class MapperImpl<T extends Serializable, D extends Serializable> implements Mapper<T, D> {

    protected Class<T> entityClass;
    protected Class<D> dtoClass;
    protected Mapper<T, D> decoratedMapper;
    protected MapperFactory mapperFactory;

    /**
     * The default constructor.
     * @param entityClass - an Entity class.
     * @param dtoClass - the DTO class.
     * @param decoratedMapper - the decorated Mapper.
     */
    public MapperImpl(Class<T> entityClass, Class<D> dtoClass, Mapper<T, D> decoratedMapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.decoratedMapper = decoratedMapper;
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    /**
     * The method is to get MapperFactory
     * @return - the MapperFactory object.
     */
    @Override
    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    /**
     * Method is to get the customized MapperFactory for the mapping from an Entity to the DTO.
     * @param t - an Entity.
     * @param d - the DTO.
     */
    @Override
    public void customize(T t, Class<D> d) {
    }

    /**
     * Method is to get the customized MapperFactory for the mapping from the DTO to an Entity.
     * @param t - an Entity.
     * @param d - the DTO.
     */
    @Override
    public void customize(D d, T t) {
    }

    /**
     * The method is to get Mapper.
     * @return - the Mapper object.
     */
    public Mapper<T, D> getMapper() {
        return decoratedMapper;
    }

    /**
     * The method is to convert an Entity to the DTO.
     * @param t - an Entity.
     * @param d - the DTO.
     * @return - the converted DTO.
     */
    @Override
    public D fromEntityToDTO(T t, D d) {
        return getMapperFactory().getMapperFacade().map(entityClass, dtoClass);
    }

    /**
     * The method is to convert the DTO to an Entity.
     * @param d - the DTO.
     * @param t - an Entity.
     * @return - an converted Entity.
     */
    @Override
    public T fromDTOToEntity(D d, T t) {
        return getMapperFactory().getMapperFacade().map(dtoClass, entityClass);
    }
}
