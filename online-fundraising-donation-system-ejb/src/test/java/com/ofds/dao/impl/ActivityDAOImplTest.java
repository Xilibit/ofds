package com.ofds.dao.impl;

import com.ofds.TestsUtil;
import com.ofds.dao.AbstractDAOTest;
import com.ofds.entity.Activity;
import com.ofds.entity.Fundraiser;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.ParseException;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

@RunWith(Arquillian.class)
public class ActivityDAOImplTest extends AbstractDAOTest {

    @Inject
    private ActivityDAOImpl activityDAO;

    @Inject
    private FundraiserDAOImpl fundraiserDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(activityDAO, is(notNullValue()));
        Assert.assertThat(activityDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createActivity_newValidActivity_successActivity() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Assert.assertThat(activityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void getFundraiserActivitiesForDonation_newValidActivities_successActivitiesForDonation() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser1);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activity2 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity2.setFundraiserFundraiserEmail(fundraiser1);

        activityDAO.createActivity(activity2);

        Assert.assertThat(activityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(activityDAO.getFundraiserActivitiesForDonation(fundraiser1), is(hasSize(2)));
    }

    @Test
    public void edit_newValidActivities_successActivityEdit() throws ParseException {

        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activityToEdit = activityDAO.loadAll().get(0);
        activityToEdit.setActivityShortDescription("New Description");

        activityDAO.edit(activityToEdit);

        Assert.assertThat(activityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(1)));
        Assert.assertThat(activityDAO.loadAll().get(0).getActivityShortDescription(), is("New Description"));
    }

    @Test
    public void remove_newValidActivities_successActivityRemove() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activityToRemove = activityDAO.loadAll().get(0);

        activityDAO.remove(activityToRemove);

        Assert.assertThat(activityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void find_newValidActivities_successActivityFind() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activityToFind = activityDAO.loadAll().get(0);

        Assert.assertThat(activityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(2)));
        Assert.assertThat(activityDAO.find(activityToFind.getIdACTIVITY()), is(activityToFind));
    }

    @Test
    public void loadAll_newValidActivities_successActivityLoad() throws ParseException {

        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Assert.assertThat(activityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void findRange_newValidActivities_successActivityRange() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activity2 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity2.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity2);

        int[] range = new int[2];
        range[0] = 1;
        range[1] = 2;

        Assert.assertThat(activityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(activityDAO.findRange(range), is(not(empty())));
        Assert.assertThat(activityDAO.findRange(range), is(hasSize(2)));
    }

    @Test
    public void count_newValidActivities_successActivityCount() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activity2 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity2.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity2);

        Assert.assertThat(activityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(activityDAO.count(), is(3));
    }

    @Test
    public void getByEntityParameter_newValidActivities_successActivityByParameter() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activity2 = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity2.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity2);

        Assert.assertThat(activityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(activityDAO.getByEntityParameter("Name", "Activity Name1"), is(notNullValue()));
        Assert.assertThat(activityDAO.getByEntityParameter("Name", "Activity Name1"), is(not(empty())));
        Assert.assertThat(activityDAO.getByEntityParameter("Name", "Activity Name1"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidActivities_successActivityByExcludeParameter() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activity2 = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity2.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity2);

        Assert.assertThat(activityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(activityDAO.getAllByEntityExcludeParameter("Name", "Activity Name1"), is(notNullValue()));
        Assert.assertThat(activityDAO.getAllByEntityExcludeParameter("Name", "Activity Name1"), is(not(empty())));
        Assert.assertThat(activityDAO.getAllByEntityExcludeParameter("Name", "Activity Name1"), is(hasSize(2)));
    }

    @Test
    public void getByLinkedEntityParameter_newValidActivities_successActivityByLinkedParameter() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
        activity.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity);

        Activity activity1 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity1.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity1);

        Activity activity2 = TestsUtil.getActivityForTest(TestsUtil.SECOND_ACTIVITY_NAME);
        activity2.setFundraiserFundraiserEmail(fundraiser);

        activityDAO.createActivity(activity2);

        Assert.assertThat(activityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(activityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(activityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(activityDAO.getByLinkedEntityParameter("fundraiserFundraiserEmail", fundraiser),
                is(notNullValue()));
        Assert.assertThat(activityDAO.getByLinkedEntityParameter("fundraiserFundraiserEmail", fundraiser),
                is(not(empty())));
        Assert.assertThat(activityDAO.getByLinkedEntityParameter("fundraiserFundraiserEmail", fundraiser),
                is(hasSize(3)));
    }
}
