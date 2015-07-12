package com.ofds.dao;

import com.ofds.entity.Charity;

public interface CharityDAO extends GenericDAO<Charity, String> {

    /**
     * The method is to get Charity by Charity Email.
     * @param charityEmail - the Charity Email.
     * @return - The found Charity.
     */
    Charity getCharityByCharityEmail(String charityEmail);
}
