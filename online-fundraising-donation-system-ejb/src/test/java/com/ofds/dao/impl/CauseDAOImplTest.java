package com.ofds.dao.impl;

import com.ofds.TestsUtil;
import com.ofds.dao.AbstractDAOTest;
import com.ofds.entity.Cause;
import com.ofds.entity.Charity;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.ParseException;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

@RunWith(Arquillian.class)
public class CauseDAOImplTest extends AbstractDAOTest {

    @Inject
    private CauseDAOImpl causeDAO;

    @Inject
    private CharityDAOImpl charityDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(causeDAO, is(notNullValue()));
        Assert.assertThat(causeDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createCause_newValidCause_successCause() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Assert.assertThat(causeDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(causeDAO.loadAll(), is(not(empty())));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void getCauseByCauseName_newValidCauses_successCause() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(not(nullValue())));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(not(empty())));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(hasSize(1)));
    }

    @Test
    public void edit_newValidCauses_successCauseEdit() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        List<Cause> causeToEditList = causeDAO.getCauseByCauseName("Cause Name");
        Cause causeToEdit = causeToEditList.get(0);
        causeToEdit.setCausePercentage("20");
        causeDAO.edit(causeToEdit);

        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(not(nullValue())));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(not(empty())));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(hasSize(1)));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name").get(0).getCausePercentage(), is("20"));
    }

    @Test
    public void remove_newValidCauses_successCausesRemove() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        causeDAO.remove(causeDAO.getCauseByCauseName("Cause Name").get(0));

        Assert.assertThat(causeDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(causeDAO.loadAll(), is(not(empty())));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void find_newValidCauses_successCauseFind() throws ParseException {
        Charity charity =TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause causeToFind = causeDAO.getCauseByCauseName("Cause Name").get(0);

        Assert.assertThat(causeDAO.find(causeToFind.getIdCAUSE()), is(not(nullValue())));
        Assert.assertThat(causeDAO.find(causeToFind.getIdCAUSE()), is(causeToFind));
    }

    @Test
    public void loadAll_newValidCauses_successCausesLoad() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Assert.assertThat(causeDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(causeDAO.loadAll(), is(not(empty())));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void findRange_newValidCauses_successCausesRange() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        int[] range = new int[2];
        range[0] = 1;
        range[1] = 2;

        Assert.assertThat(causeDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(causeDAO.findRange(range), is(not(empty())));
        Assert.assertThat(causeDAO.findRange(range), is(hasSize(2)));
    }

    @Test
    public void count_newValidCauses_successCausesCount() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.count(), is(notNullValue()));
        Assert.assertThat(causeDAO.count(), is(3));
    }

    @Test
    public void getByEntityParameter_newValidCauses_successCauseByParameter() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(causeDAO.getByEntityParameter("Percentage", "10"), is(notNullValue()));
        Assert.assertThat(causeDAO.getByEntityParameter("Percentage", "10"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidCause_successCauseByExcludeParameter() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(causeDAO.getAllByEntityExcludeParameter("Percentage", "30"), is(notNullValue()));
        Assert.assertThat(causeDAO.getAllByEntityExcludeParameter("Percentage", "30"), is(hasSize(2)));
    }

    @Test
    public void getByLinkedEntityParameter_newValidCauses_successCauseByLinkedParameterOverloaded() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = TestsUtil.getCauseForTest(TestsUtil.SECOND_CAUSE_NAME, TestsUtil.SECOND_CAUSE_PERSENTAGE);
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(causeDAO.getByLinkedEntityParameter("charityCharityEmail", charity), is(hasSize(3)));
    }
}
