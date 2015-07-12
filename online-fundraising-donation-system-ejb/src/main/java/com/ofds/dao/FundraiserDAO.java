package com.ofds.dao;

import com.ofds.entity.Fundraiser;

public interface FundraiserDAO extends GenericDAO<Fundraiser, String> {

    /**
     * The method is to get Fundraiser by Fundraiser by email.
     * @param fundraiserEmail - the Fundraiser Email.
     * @return - the found Fundraiser.
     */
    Fundraiser getFundraiserByFundraiserEmail(String fundraiserEmail);

    /**
     * The method is to create Fundraiser.
     * @param fundraiser - The Fundraiser to create.
     */
    void createFundraiser(Fundraiser fundraiser);
}