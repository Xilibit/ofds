package com.ofds.services;

import javax.ejb.Local;

/**
 * Manage the Charity
 */
@Local
public interface CharityService {

    void registerTheCharity();

    void registerTheCauseForDonation();

    void checkAccount();
}
