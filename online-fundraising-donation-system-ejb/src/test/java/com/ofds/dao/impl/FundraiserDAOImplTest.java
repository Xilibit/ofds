package com.ofds.dao.impl;

import com.ofds.TestsUtil;
import com.ofds.dao.AbstractDAOTest;
import static org.hamcrest.Matchers.*;

import com.ofds.entity.Fundraiser;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@RunWith(Arquillian.class)
public class FundraiserDAOImplTest extends AbstractDAOTest {

    @Inject
    private FundraiserDAOImpl fundraiserDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(fundraiserDAO, is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createFundraiser_newValidFundraiser_successFundraiser() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com"), is(notNullValue()));
    }

    @Test
    public void createFundraiser_newValidFundraiser_NotFoundFundraiser() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);
        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@xilibit.com"), is(nullValue()));
    }

    @Test
    public void createFewFundraisers_newValidFundraisers_foundOneFundraiser() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser1);

        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilsx.com"), is(notNullValue()));
    }

    @Test
    public void editFundraisers_newValidTwoFundraisers_oneUpdatedFundraiser() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiserToUpdate = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilsx.com");
        fundraiserToUpdate.setFundraiserFirstName("Xibitli");
        fundraiserDAO.edit(fundraiserToUpdate);

        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilsx.com"), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilsx.com").getFundraiserFirstName(),
                is("Xibitli"));
    }

    @Test
    public void remove_newValidFundraisers_foundOneFundraiser() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser1);

        fundraiserDAO.remove(fundraiser);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.loadAll(), is(not(empty())));
        Assert.assertThat(fundraiserDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void loadAll_newValidFundraisers_foundTwoFundraisers() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser1);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.loadAll(), is(not(empty())));
        Assert.assertThat(fundraiserDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void count_newValidFundraisers_countTwoFundraisers() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser1);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.loadAll(), is(not(empty())));
        Assert.assertThat(fundraiserDAO.count(), is(2));
    }

    @Test
    public void findRange_newValidFundraisers_foundTwoFundraisers() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiser1.setFundraiserEmail("xil@terr.com");
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiser2 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser2);

        int[] range = new int[2];
        range[0] = 1;
        range[1] = 2;

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.findRange(range), is(not(empty())));
        Assert.assertThat(fundraiserDAO.findRange(range), is(hasSize(2)));
    }

    @Test
    public void getByEntityParameter_newValidFundraisers_foundOneFundraiserByEmail() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiser1.setFundraiserEmail("xiasl@terar.com");
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiser2 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser2);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getByEntityParameter("Email", "Xilibit@tibilic.com"), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getByEntityParameter("Email", "Xilibit@tibilic.com"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidFundraisers_foundTwoOfThreeFundraisersByEmail() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiser1.setFundraiserEmail("poka@hole.com");
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiser2 = TestsUtil.getFundraiserForTest(TestsUtil.SECOND_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser2);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getAllByEntityExcludeParameter("Email", "Xilibit@tibilsx.com"), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getAllByEntityExcludeParameter("Email", "Xilibit@tibilsx.com"), is(hasSize(2)));
    }
}
