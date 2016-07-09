package com.ofds;

import com.ofds.entity.Activity;
import com.ofds.entity.Cause;
import com.ofds.entity.Charity;
import com.ofds.entity.Donation;
import com.ofds.entity.Fundraiser;

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

    public static final String FIRST_CAUSE_NAME = "Cause Name";
    public static final String SECOND_CAUSE_NAME = "Cause Name1";
    public static final String FIRST_CAUSE_PERSENTAGE = "10";
    public static final String SECOND_CAUSE_PERSENTAGE = "30";

    public static final String FIRST_ACTIVITY_NAME = "Activity Name";
    public static final String SECOND_ACTIVITY_NAME = "Activity Name1";

    public static final double FIRST_DONATION_AMOUNT = 100.00;
    public static final double SECOND_DONATION_AMOUNT = 200.00;


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

    private static Donation createRegularDonation(double amount) throws ParseException {
        Donation donation = new Donation();
        donation.setDonationAmount(amount);
        donation.setDonationDate(formatter.parse("2015-12-12"));
        donation.setDonationIsAnonym(Boolean.FALSE);
        return donation;
    }

    private static Cause createRegularCause(String causeName, String causePercentage) throws ParseException {
        Cause cause = new Cause();
        cause.setCauseName(causeName);
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage(causePercentage);
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        return cause;
    }

    private static Activity createRegularActivity(String activityName) throws ParseException {
        Activity activity = new Activity();
        activity.setActivityName(activityName);
        activity.setActivityShortDescription("Activity Short Description");
        activity.setActivityInsertTs(new Date());
        activity.setActivityTerminationDate(formatter.parse("2016-12-12"));
        return activity;
    }

    public static Fundraiser getFundraiserForTest(String fundraiserEmail) throws ParseException {
        return createRegularFundraiser(fundraiserEmail);
    }

    public static Charity getCharityForTest(String charityEmail, String charityName) throws ParseException {
        return createRegularCharity(charityEmail, charityName);
    }

    public static Donation getDonationForTest(double amount) throws ParseException {
        return createRegularDonation(amount);
    }

    public static Cause getCauseForTest(String causeName, String causePercentage) throws ParseException {
        return createRegularCause(causeName, causePercentage);
    }

    public static Activity getActivityForTest(String activityName) throws ParseException {
        return createRegularActivity(activityName);
    }

}
