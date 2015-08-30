package com.ofds.dao.impl;

import static org.hamcrest.Matchers.*;

import com.ofds.TestsUtil;
import com.ofds.dao.AbstractDAOTest;
import com.ofds.entity.Donation;
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
public class DonationDAOImplTest extends AbstractDAOTest {

    @Inject
    private DonationDAOImpl donationDAO;

    @Inject
    private FundraiserDAOImpl fundraiserDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(donationDAO, is(notNullValue()));
        Assert.assertThat(donationDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createDonation_newValidDonation_successDonation() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        fundraiserDAO.createFundraiser(fundraiser);

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Assert.assertThat(donationDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(donationDAO.loadAll(), is(not(empty())));
        Assert.assertThat(donationDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void getDonationsByFundraiserEmail_newValidDonations_successTwoDonations() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);


        donationDAO.createDonation(donation1);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(2)));
    }

    @Test
    public void edit_newValidDonation_successDonationEdit() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);
        Donation donationToEdit = donationDAO.loadAll().get(0);
        donationToEdit.setDonationAmount(500.00);
        donationDAO.edit(donationToEdit);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(2)));
        Assert.assertThat(donationDAO.loadAll().get(0).getDonationAmount(), is(500.00));
    }

    @Test
    public void remove_newValidDonation_successDonationRemove() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);
        Donation donationToRemove = donationDAO.loadAll().get(0);
        donationDAO.remove(donationToRemove);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(1)));
        Assert.assertThat(donationDAO.loadAll(), is(hasSize(1)));

    }

    @Test
    public void find_newValidDonation_successDonationFind() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);
        Donation donationToFind = donationDAO.loadAll().get(0);
        donationDAO.find(donationToFind.getIdDONATION());

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(2)));
        Assert.assertThat(donationDAO.find(donationToFind.getIdDONATION()), is(donationToFind));
    }

    @Test
    public void loadAll_newValidDonation_successDonationLoad() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(2)));
        Assert.assertThat(donationDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void findRange_newValidDonations_successDonationFindRange() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);

        Donation donation2 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation2.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation2);

        int[] range = new int[2];
        range[0] = 1;
        range[1] = 2;

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(3)));
        Assert.assertThat(donationDAO.findRange(range), is(hasSize(2)));

    }

    @Test
    public void count_newValidDonations_successDonationCount() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);

        Donation donation2 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation2.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation2);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(3)));
        Assert.assertThat(donationDAO.count(), is(3));

    }

    @Test
    public void getByEntityParameter_newValidDonations_successDonationByParameter() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);

        Donation donation2 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation2.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation2);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(3)));
        Assert.assertThat(donationDAO.getByEntityParameter("Amount", "200.00"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidDonations_successDonationExcludeByParameter()
            throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);

        Donation donation2 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation2.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation2);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(3)));
        Assert.assertThat(donationDAO.getAllByEntityExcludeParameter("Amount", "100.00"), is(hasSize(2)));
    }

    @Test
    public void getByLinkedEntityParameterOverloaded_newValidDonations_successDonation() throws ParseException {
        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);

        fundraiserDAO.createFundraiser(fundraiser);
        fundraiser = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com");

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation);

        Donation donation1 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation1.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation1);

        Donation donation2 = TestsUtil.getDonationForTest(TestsUtil.SECOND_DONATION_AMOUNT);
        donation2.setFundraiserFundraiserEmail(fundraiser);

        donationDAO.createDonation(donation2);

        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(nullValue())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(not(empty())));
        Assert.assertThat(donationDAO.getDonationsByFundraiser(fundraiser), is(hasSize(3)));
        Assert.assertThat(donationDAO.getByLinkedEntityParameter("fundraiserFundraiserEmail", fundraiser),
                is(hasSize(3)));
    }
}
