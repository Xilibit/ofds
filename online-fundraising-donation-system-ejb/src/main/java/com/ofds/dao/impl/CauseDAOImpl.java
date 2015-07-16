package com.ofds.dao.impl;

import com.ofds.dao.CauseDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Cause;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CauseDAOImpl extends GenericDAOImpl<Cause, Integer> implements CauseDAO {

    @PersistenceContext
    private EntityManager em;

    private static final String NAME = "Name";

    /**
     * The default constructor.
     */
    public CauseDAOImpl() {
        super(Cause.class);
    }

    /**
     * The method is to get EntityManager object.
     * @return - The EntityManager object.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * The method is to create Cause.
     * @param cause - The Cause to create.
     */
    @Override
    public void createCause(Cause cause) {
        save(cause);
    }

    /**
     * The method is to get Cause by Cause Name.
     * @param causeName - the  Cause Name.
     * @return - The found List of Cause.
     */
    @Override
    public List<Cause> getCauseByCauseName(String causeName) {
        return getByEntityParameter(NAME, causeName);
    }
}
