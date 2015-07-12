package com.ofds.dao;

import com.ofds.entity.Donation;

import java.util.List;

public interface DonationDAO extends GenericDAO<Donation, String> {

    /**
     * The method is to get Donations by Fundraiser Email.
     * @param fundraiserEmail - the Fundraiser Email.
     * @return - The list of the Donations.
     */
    List<Donation> getDonationsByFundraiserEmail(String fundraiserEmail);
}
