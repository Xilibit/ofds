package com.ofds.util;

import static org.hamcrest.Matchers.*;

import com.ofds.entity.*;
import com.ofds.util.mapper.ActivityMapper;
import com.ofds.util.person.dto.ActivityDTO;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@RunWith(Arquillian.class)
public class ActivityMapperTest extends AbstractMapperTest {

    @Inject
    private ActivityMapper activityMapper;

    @Test
    public void getActivityMapper_existentActivityMapper_notNullMapperFactory() {
        Assert.assertThat(activityMapper, is(notNullValue()));
        Assert.assertThat(activityMapper.getMapperFactory(), is(notNullValue()));
    }

    @Test
    public void fromEntityToDTO_existentEntityAndDTO_ValidDTOresult() throws ParseException {
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

        Charity charity = new Charity();
        charity.setCharityName("New Charity");
        charity.setCharityRegistryName("NC");
        charity.setCharityPassword("123");
        charity.setCharityEmail("newCharity@new.com");
        charity.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity.setCharityCountry("USA");
        charity.setCharityCity("NY");
        charity.setCharityStreet("Bul");
        charity.setCharityIndex("021222");
        charity.setCharityShortDescription("The new Charity Description");

        Cause cause = new Cause();
        cause.setIdCAUSE(200);
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        Donation donation = new Donation();
        donation.setIdDONATION(400);
        donation.setFundraiserFundraiserEmail(fundraiser);
        donation.setDonationAmount(100.00);
        donation.setDonationDate(formatter.parse("2015-12-12"));
        donation.setDonationIsAnonym(Boolean.FALSE);

        Collection<Donation> donations = new ArrayList<Donation>();
        donations.add(donation);

        Activity activity = new Activity();
        activity.setIdACTIVITY(100);
        activity.setActivityName("Activity Name");
        activity.setActivityShortDescription("Activity Short Description");
        activity.setActivityInsertTs(new Date());
        activity.setActivityTerminationDate(formatter.parse("2016-12-12"));
        activity.setFundraiserFundraiserEmail(fundraiser);
        Collection<Cause> causes = new ArrayList<Cause>();
        causes.add(cause);
        activity.setCauseCollection(causes);
        activity.setDonationCollection(donations);

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO = activityMapper.fromEntityToDTO(activity, activityDTO);

        Assert.assertThat(activityDTO, is(notNullValue()));
        System.out.println(activityDTO.toString());
    }

}
