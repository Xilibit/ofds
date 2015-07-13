package com.ofds.dao.impl;

import com.ofds.dao.CharityDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Charity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CharityDAOImpl extends GenericDAOImpl<Charity, String> implements CharityDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * The default constructor.
     */
    public CharityDAOImpl() {
        super(Charity.class);
    }

    /**
     * The method is to get EntityManager.
     * @return - the EntityManager object.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * The method is to get Charity by Charity Email.
     * @param charityEmail - the Charity Email.
     * @return - the found Charity.
     */
    @Override
    public Charity getCharityByCharityEmail(String charityEmail) {
        return find(charityEmail);
    }

}
