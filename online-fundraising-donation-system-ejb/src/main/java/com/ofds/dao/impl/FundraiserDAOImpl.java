package com.ofds.dao.impl;

import com.ofds.dao.FundraiserDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Fundraiser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FundraiserDAOImpl extends GenericDAOImpl<Fundraiser, String> implements FundraiserDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * The default constructor.
     */
    public FundraiserDAOImpl() {
        super(Fundraiser.class);
    }

    /**
     * The overridden method is to get EntityManager
     * @return - EntityManager object.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * The method is to get Fundraiser by fundraiser Email
     * @param fundraiserEmail - fundraiser Email
     * @return - Fundraiser object.
     */
    @Override
    public Fundraiser getFundraiserByFundraiserEmail(String fundraiserEmail) {
        return find(fundraiserEmail);
    }

    /**
     * The method is to create new Fundraiser.
     * @param fundraiser - new Fundraiser object.
     */
    @Override
    public void createFundraiser(Fundraiser fundraiser) {
        save(fundraiser);
    }
}
