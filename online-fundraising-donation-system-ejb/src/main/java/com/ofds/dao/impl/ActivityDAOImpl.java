package com.ofds.dao.impl;

import com.ofds.dao.ActivityDAO;
import com.ofds.dao.GenericDAOImpl;
import com.ofds.entity.Activity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ActivityDAOImpl extends GenericDAOImpl<Activity, String> implements ActivityDAO {

    @PersistenceContext(unitName = "onlineFundraisingDonationsPU")
    private EntityManager em;

    public ActivityDAOImpl() {
        super(Activity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Activity> getFundraiserActivitiesForDonation(String fundraisingEmail) {
        return getAllByEntityExcludeParameter(fundraisingEmail);
    }

}
