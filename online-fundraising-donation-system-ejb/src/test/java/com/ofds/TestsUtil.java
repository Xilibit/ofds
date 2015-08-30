package com.ofds;

import com.ofds.entity.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestsUtil {

    public static final String FIRST_FUNDRAISER_EMAIL = "Xilibit@tibilic.com";
    public static final String SECOND_FUNDRAISER_EMAIL = "Xilibit@tibilsx.com";

    public static final String FIRST_CHARITY_EMAIL = "newCharity@new.com";
    public static final String SECOND_CHARITY_EMAIL = "newCharityName@new.com";
    public static final String FIRST_CHARITY_NAME = "New Charity";
    public static final String SECOND_CHARITY_NAME = "New Charity Name";


    private TestsUtil() {
    }

    private static DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    private static Fundraiser createRegularFundraiser(String fundraiserEmail) throws ParseException {
        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setFundraiserFirstName("Xilibit");
        fundraiser.setFundraiserLastName("Tibilic");
        fundraiser.setFundraiserEmail(fundraiserEmail);
        fundraiser.setFundraiserPassword("pass");
        fundraiser.setFundraiserDateOfBirth(formatter.parse("1991-12-12"));
        fundraiser.setFundraiserCountry("UA");
        fundraiser.setFundraiserCity("KI");
        fundraiser.setFundraiserIndex("9713");
        fundraiser.setFundraiserStreet("Street");
        fundraiser.setFundraiserIsAdmin(true);
        fundraiser.setFundraiserWallet(1010.00);
        return fundraiser;
    }

    private static Charity createRegularCharity(String charityEmail, String charityName) throws ParseException {
        Charity charity = new Charity();
        charity.setCharityName(charityName);
        charity.setCharityRegistryName("NC");
        charity.setCharityPassword("123");
        charity.setCharityEmail(charityEmail);
        charity.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity.setCharityCountry("USA");
        charity.setCharityCity("NY");
        charity.setCharityStreet("Bul");
        charity.setCharityIndex("021222");
        charity.setCharityShortDescription("The new Charity Description");
        return charity;
    }

    public static Fundraiser getFundraiserForTest(String fundraiserEmail) throws ParseException {
        return createRegularFundraiser(fundraiserEmail);
    }

    public static Charity getCharityForTest(String charityEmail, String charityName) throws ParseException {
        return createRegularCharity(charityEmail, charityName);
    }

    public static Donation getDonationForTest() throws ParseException {
        Donation donation = new Donation();
        donation.setDonationAmount(100.00);
        donation.setDonationDate(formatter.parse("2015-12-12"));
        donation.setDonationIsAnonym(Boolean.FALSE);
        return donation;
    }

    public static Donation getDonationSecForTest() throws ParseException {
        Donation donation = new Donation();
        donation.setDonationAmount(200.00);
        donation.setDonationDate(formatter.parse("2015-10-10"));
        donation.setDonationIsAnonym(Boolean.FALSE);
        return donation;
    }

    public static Cause getCauseForTest() throws ParseException {
        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        return cause;
    }

    public static Cause getCauseSecForTest() throws ParseException {
        Cause cause = new Cause();
        cause.setCauseName("Cause Name1");
        cause.setCauseShortDescription("Cause Short Description1");
        cause.setCausePercentage("30");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        return cause;
    }

    public static Activity getActivityForTest() throws ParseException {
        Activity activity = new Activity();
        activity.setActivityName("Activity Name");
        activity.setActivityShortDescription("Activity Short Description");
        activity.setActivityInsertTs(new Date());
        activity.setActivityTerminationDate(formatter.parse("2016-12-12"));
        return activity;
    }

    public static Activity getActivitySecForTest() throws ParseException {
        Activity activity = new Activity();
        activity.setActivityName("Activity Name1");
        activity.setActivityShortDescription("Activity Short Description1");
        activity.setActivityInsertTs(new Date());
        activity.setActivityTerminationDate(formatter.parse("2016-12-12"));
        return activity;
    }

}
