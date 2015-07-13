package com.ofds.dao.impl;

import com.ofds.dao.CauseDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Cause;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CauseDAOImpl extends GenericDAOImpl<Cause, String> implements CauseDAO {

    @PersistenceContext
    private EntityManager em;

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
}
