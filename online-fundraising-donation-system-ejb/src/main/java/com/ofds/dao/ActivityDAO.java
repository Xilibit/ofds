package com.ofds.dao;

import com.ofds.entity.Activity;
import com.ofds.entity.Fundraiser;

import java.util.List;

public interface ActivityDAO extends GenericDAO<Activity, Integer> {

    /**
     * The method is to create Activity.
     * @param activity - The Activity to create.
     */
    void createActivity(Activity activity);

    /**
     * The method is to get Fundraiser Activities that Fundraiser can donate.
     * @param fundraiser - the Fundraiser.
     * @return - the list of Activities.
     */
    List<Activity> getFundraiserActivitiesForDonation(Fundraiser fundraiser);
}
