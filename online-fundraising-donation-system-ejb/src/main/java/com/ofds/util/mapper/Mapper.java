package com.ofds.util.mapper;

import ma.glasnost.orika.MapperFactory;

import java.io.Serializable;

/**
 * Manage the basic mapper operations.
 */
public interface Mapper<T extends Serializable, D extends Serializable> {

    /**
     * Method is to get the MapperFactory.
     * @return - the MapperFactory.
     */
    MapperFactory getMapperFactory();

    /**
     * Method is to get the customized MapperFactory for the mapping from an Entity to the DTO.
     * @param t - an Entity.
     * @param d - the DTO.
     */
    void customize(T t, Class<D> d);

    /**
     * Method is to get the customized MapperFactory for the mapping from the DTO to an Entity.
     * @param t - an Entity.
     * @param d - the DTO.
     */
    void customize(D d, T t);


    /**
     * The method is to convert an Entity to the DTO.
     * @param t - an Entity.
     * @param d - the DTO.
     * @return - the converted DTO.
     */
    D fromEntityToDTO(T t, D d);

    /**
     * The method is to convert the DTO to an Entity.
     * @param d - the DTO.
     * @param t - an Entity.
     * @return - an converted Entity.
     */
    T fromDTOToEntity(D d, T t);

}
