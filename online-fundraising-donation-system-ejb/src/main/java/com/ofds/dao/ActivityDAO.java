package com.ofds.dao;

import com.ofds.entity.Activity;

import java.util.List;

public interface ActivityDAO extends GenericDAO<Activity, String> {

    /**
     * The method is to get Fundraiser Activities that Fundraiser can donate.
     * @return - the list of Activities.
     */
    List<Activity> getFundraiserActivitiesForDonation(String fundraiserEmail);
}
