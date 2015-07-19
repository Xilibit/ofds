package com.ofds.dao.impl;

import com.ofds.dao.ActivityDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Activity;
import com.ofds.entity.Fundraiser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ActivityDAOImpl extends GenericDAOImpl<Activity, Integer> implements ActivityDAO {

    @PersistenceContext
    private EntityManager em;

    private static final String FUNDRAISER = "fundraiserFundraiserEmail";

    /**
     * The default constructor.
     */
    public ActivityDAOImpl() {
        super(Activity.class);
    }

    /**
     * Method to get Entity Manager.
     * @return - EntityManager object.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * The method is to create Activity.
     * @param activity - The Activity to create.
     */
    @Override
    public void createActivity(Activity activity) {
        save(activity);
    }

    /**
     * The method is to get Fundraiser Activities that Fundraiser can donate.
     * @param fundraiser - the Fundraiser Email.
     * @return - the list of Activities.
     */
    @Override
    public List<Activity> getFundraiserActivitiesForDonation(Fundraiser fundraiser) {
        return getAllByLinkedEntityExcludeParameter(FUNDRAISER, fundraiser);
    }

}
