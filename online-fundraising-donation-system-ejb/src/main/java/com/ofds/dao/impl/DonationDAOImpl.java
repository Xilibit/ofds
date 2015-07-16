package com.ofds.dao.impl;

import com.ofds.dao.DonationDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Donation;
import com.ofds.entity.Fundraiser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DonationDAOImpl extends GenericDAOImpl<Donation, Integer> implements DonationDAO {

    @PersistenceContext
    private EntityManager em;

    private static final String FUNDRAISER_EMAIL = "fundraiserFundraiserEmail";

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
     * The method is to create Donation.
     * @param donation - The Donation to create.
     */
    @Override
    public void createDonation(Donation donation) {
        save(donation);
    }

    /**
     * The method is to get all donations for Fundraiser by fundraiser Email.
     * @param fundraiser - Fundraiser.
     * @return - list of the objects.
     */
    @Override
    public List<Donation> getDonationsByFundraiser(Fundraiser fundraiser) {
        return getByLinkedEntityParameter(FUNDRAISER_EMAIL, fundraiser);
    }
}
