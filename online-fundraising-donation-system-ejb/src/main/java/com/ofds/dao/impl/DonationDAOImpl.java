package com.ofds.dao.impl;

import com.ofds.dao.DonationDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Donation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DonationDAOImpl extends GenericDAOImpl<Donation, String> implements DonationDAO {

    @PersistenceContext(unitName = "onlineFundraisingDonationsPU")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public DonationDAOImpl() {
        super(Donation.class);
    }

    /**
     * The method is to get EntityManager.
     * @return - EntityManager.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * The method is to get all donations for Fundraiser by fundraiser Email.
     * @param fundraiserEmail - Fundraiser Email.
     * @return - list of the objects.
     */
    @Override
    public List<Donation> getDonationsByFundraiserEmail(String fundraiserEmail) {
        return getByEntityParameter(fundraiserEmail);
    }
}
