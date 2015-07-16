package com.ofds.dao;

import com.ofds.entity.Cause;

import java.util.List;

public interface CauseDAO extends GenericDAO<Cause, Integer> {

    /**
     * The method is to create Cause.
     * @param cause - The Cause to create.
     */
    void createCause(Cause cause);

    /**
     * The method is to get Cause by Cause Name.
     * @param causeName - the  Cause Name.
     * @return - The found List of Cause.
     */
    List<Cause> getCauseByCauseName(String causeName);
}
