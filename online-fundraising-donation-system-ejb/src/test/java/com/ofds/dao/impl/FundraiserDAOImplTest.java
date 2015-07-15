package com.ofds.dao.impl;

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
import java.util.Collections;
import java.util.Locale;

@RunWith(Arquillian.class)
public class FundraiserDAOImplTest extends AbstractDAOTest {

    @Inject
    private FundraiserDAOImpl fundraiserDAO;

    @Test
    public void getFundraiserByFundraiserEmail_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(fundraiserDAO, is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createFundraiser_newValidFundraiser_successFundraiser() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilix");
        fundraiser.setFundraiserEmail("Xilibit@tibilix.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1000.00);
        fundraiserDAO.createFundraiser(fundraiser);
        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilix.com"), is(notNullValue()));
    }

    @Test
    public void createFundraiser_newValidFundraiser_NotFoundFundraiser() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilix");
        fundraiser.setFundraiserEmail("Xilibit@tibilix.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1000.00);
        fundraiserDAO.createFundraiser(fundraiser);
        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@xilibit.com"), is(nullValue()));
    }

    @Test
    public void createFewFundraisers_newValidFundraisers_foundOneFundraiser() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibit@tibilic.com"), is(notNullValue()));
    }

    @Test
    public void editFundraisers_newValidTwoFundraisers_oneUpdatedFundraiser() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiserToUpdate = fundraiserDAO.getFundraiserByFundraiserEmail("Xilibix@tibilxx.com");
        fundraiserToUpdate.setFundraiserFirstName("Xibitli");
        fundraiserDAO.edit(fundraiserToUpdate);

        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibix@tibilxx.com"), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getFundraiserByFundraiserEmail("Xilibix@tibilxx.com").getFundraiserFirstName(),
                is("Xibitli"));
    }

    @Test
    public void remove_newValidFundraisers_foundOneFundraiser() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        fundraiserDAO.remove(fundraiser);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.loadAll(), is(not(empty())));
        Assert.assertThat(fundraiserDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void loadAll_newValidFundraisers_foundTwoFundraisers() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.loadAll(), is(not(empty())));
        Assert.assertThat(fundraiserDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void count_newValidFundraisers_countTwoFundraisers() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.loadAll(), is(not(empty())));
        Assert.assertThat(fundraiserDAO.count(), is(2));
    }

    @Test
    public void findRange_newValidFundraisers_foundTwoFundraisers() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiser2 = new Fundraiser();
        fundraiser2.setFundraiserFirstName("Xilicix");
        fundraiser2.setFundraiserLastName("Tibilic");
        fundraiser2.setFundraiserEmail("Xilibix@coml.com");
        fundraiser2.setFundraiserPassword("pass");
        fundraiser2.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser2.setFundraiserCountry("UA");
        fundraiser2.setFundraiserCity("KI");
        fundraiser2.setFundraiserIndex("9713");
        fundraiser2.setFundraiserStreet("Street");
        fundraiser2.setFundraiserIsAdmin(false);
        fundraiser2.setFundraiserWallet(1400.00);
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
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiser2 = new Fundraiser();
        fundraiser2.setFundraiserFirstName("Xilicix");
        fundraiser2.setFundraiserLastName("Tibilic");
        fundraiser2.setFundraiserEmail("Xilibix@coml.com");
        fundraiser2.setFundraiserPassword("pass");
        fundraiser2.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser2.setFundraiserCountry("UA");
        fundraiser2.setFundraiserCity("KI");
        fundraiser2.setFundraiserIndex("9713");
        fundraiser2.setFundraiserStreet("Street");
        fundraiser2.setFundraiserIsAdmin(false);
        fundraiser2.setFundraiserWallet(1400.00);
        fundraiserDAO.createFundraiser(fundraiser2);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getByEntityParameter("Email", "Xilibix@coml.com"), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getByEntityParameter("Email", "Xilibix@coml.com"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidFundraisers_foundTwoOfThreeFundraisersByEmail() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail("Xilibit@tibilic.com");
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(false);
        fundraiser.setFundraiserWallet(1010.00);
        fundraiserDAO.createFundraiser(fundraiser);

        Fundraiser fundraiser1 = new Fundraiser();
        fundraiser1.setFundraiserFirstName("Xilibix");
        fundraiser1.setFundraiserLastName("Tibilic");
        fundraiser1.setFundraiserEmail("Xilibix@tibilxx.com");
        fundraiser1.setFundraiserPassword("pass");
        fundraiser1.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser1.setFundraiserCountry("UA");
        fundraiser1.setFundraiserCity("KI");
        fundraiser1.setFundraiserIndex("9713");
        fundraiser1.setFundraiserStreet("Street");
        fundraiser1.setFundraiserIsAdmin(false);
        fundraiser1.setFundraiserWallet(1200.00);
        fundraiserDAO.createFundraiser(fundraiser1);

        Fundraiser fundraiser2 = new Fundraiser();
        fundraiser2.setFundraiserFirstName("Xilicix");
        fundraiser2.setFundraiserLastName("Tibilic");
        fundraiser2.setFundraiserEmail("Xilibix@coml.com");
        fundraiser2.setFundraiserPassword("pass");
        fundraiser2.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser2.setFundraiserCountry("UA");
        fundraiser2.setFundraiserCity("KI");
        fundraiser2.setFundraiserIndex("9713");
        fundraiser2.setFundraiserStreet("Street");
        fundraiser2.setFundraiserIsAdmin(false);
        fundraiser2.setFundraiserWallet(1400.00);
        fundraiserDAO.createFundraiser(fundraiser2);

        Assert.assertThat(fundraiserDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getAllByEntityExcludeParameter("Email", "Xilibix@coml.com"), is(notNullValue()));
        Assert.assertThat(fundraiserDAO.getAllByEntityExcludeParameter("Email", "Xilibix@coml.com"), is(hasSize(2)));
    }
}
