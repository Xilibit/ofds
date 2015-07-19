package com.ofds.dao.impl;

import static org.hamcrest.Matchers.*;
import com.ofds.dao.AbstractDAOTest;
import com.ofds.entity.Cause;
import com.ofds.entity.Charity;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Assert.assertThat(causeDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(causeDAO.loadAll(), is(not(empty())));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void getCauseByCauseName_newValidCauses_successCause() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(not(nullValue())));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(not(empty())));
        Assert.assertThat(causeDAO.getCauseByCauseName("Cause Name"), is(hasSize(1)));
    }

    @Test
    public void edit_newValidCauses_successCauseEdit() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
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
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        causeDAO.remove(causeDAO.getCauseByCauseName("Cause Name").get(0));

        Assert.assertThat(causeDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(causeDAO.loadAll(), is(not(empty())));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void find_newValidCauses_successCauseFind() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause causeToFind = causeDAO.getCauseByCauseName("Cause Name").get(0);

        Assert.assertThat(causeDAO.find(causeToFind.getIdCAUSE()), is(not(nullValue())));
        Assert.assertThat(causeDAO.find(causeToFind.getIdCAUSE()), is(causeToFind));
    }

    @Test
    public void loadAll_newValidCauses_successCausesLoad() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Assert.assertThat(causeDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(causeDAO.loadAll(), is(not(empty())));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void findRange_newValidCauses_successCausesRange() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = new Cause();
        cause2.setCauseName("Cause Name2");
        cause2.setCauseShortDescription("Cause Short Description2");
        cause2.setCausePercentage("25");
        cause2.setCauseInsertTs(new Date());
        cause2.setCauseTerminationDate(formatter.parse("2016-12-12"));
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
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = new Cause();
        cause2.setCauseName("Cause Name2");
        cause2.setCauseShortDescription("Cause Short Description2");
        cause2.setCausePercentage("25");
        cause2.setCauseInsertTs(new Date());
        cause2.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.count(), is(notNullValue()));
        Assert.assertThat(causeDAO.count(), is(3));
    }

    @Test
    public void getByEntityParameter_newValidCauses_successCauseByParameter() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = new Cause();
        cause2.setCauseName("Cause Name2");
        cause2.setCauseShortDescription("Cause Short Description2");
        cause2.setCausePercentage("25");
        cause2.setCauseInsertTs(new Date());
        cause2.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(causeDAO.getByEntityParameter("Percentage", "25"), is(notNullValue()));
        Assert.assertThat(causeDAO.getByEntityParameter("Percentage", "25"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidCause_successCauseByExcludeParameter() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = new Cause();
        cause2.setCauseName("Cause Name2");
        cause2.setCauseShortDescription("Cause Short Description2");
        cause2.setCausePercentage("25");
        cause2.setCauseInsertTs(new Date());
        cause2.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(causeDAO.getAllByEntityExcludeParameter("Percentage", "25"), is(notNullValue()));
        Assert.assertThat(causeDAO.getAllByEntityExcludeParameter("Percentage", "25"), is(hasSize(2)));
    }

    @Test
    public void getByLinkedEntityParameter_newValidCauses_successCauseByLinkedParameterOverloaded() throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

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

        charityDAO.createCharity(charity);
        charity = charityDAO.getCharityByCharityEmail("newCharity@new.com");

        Cause cause = new Cause();
        cause.setCauseName("Cause Name");
        cause.setCauseShortDescription("Cause Short Description");
        cause.setCausePercentage("10");
        cause.setCauseInsertTs(new Date());
        cause.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause.setCharityCharityEmail(charity);

        causeDAO.createCause(cause);

        Cause cause1 = new Cause();
        cause1.setCauseName("Cause Name1");
        cause1.setCauseShortDescription("Cause Short Description1");
        cause1.setCausePercentage("30");
        cause1.setCauseInsertTs(new Date());
        cause1.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause1.setCharityCharityEmail(charity);

        causeDAO.createCause(cause1);

        Cause cause2 = new Cause();
        cause2.setCauseName("Cause Name2");
        cause2.setCauseShortDescription("Cause Short Description2");
        cause2.setCausePercentage("25");
        cause2.setCauseInsertTs(new Date());
        cause2.setCauseTerminationDate(formatter.parse("2016-12-12"));
        cause2.setCharityCharityEmail(charity);

        causeDAO.createCause(cause2);

        Assert.assertThat(causeDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(causeDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(causeDAO.getByLinkedEntityParameter("charityCharityEmail", charity), is(hasSize(3)));
    }
}
