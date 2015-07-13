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
}
