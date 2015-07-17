package com.ofds.dao.impl;

import static org.hamcrest.Matchers.*;
import com.ofds.dao.AbstractDAOTest;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class ActivityDAOImplTest extends AbstractDAOTest {

    @Inject
    private ActivityDAOImpl activityDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(activityDAO, is(notNullValue()));
        Assert.assertThat(activityDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createActivity_newValidActivity_successActivity() {}

    @Test
    public void getFundraiserActivitiesForDonation_newValidActivities_successActivitiesForDonation() {}

    @Test
    public void edit_newValidActivities_successActivityEdit() {}

    @Test
    public void remove_newValidActivities_successActivityRemove() {}

    @Test
    public void find_newValidActivities_successActivityFind() {}

    @Test
    public void loadAll_newValidActivities_successActivityLoad() {}

    @Test
    public void findRange_newValidActivities_successActivityRange() {}

    @Test
    public void count_newValidActivities_successActivityCount() {}

    @Test
    public void getByEntityParameter_newValidActivities_successActivityByParameter() {}

    @Test
    public void getAllByEntityExcludeParameter_newValidActivities_successActivityByExcludeParameter() {}

    @Test
    public void getByLinkedEntityParameter_newValidActivities_successActivityByLinkedParameter() {}

    @Test
    public void getByLinkedEntityParameter_newValidActivities_successActivityByLinkedParameterOverloaded() {}
}
