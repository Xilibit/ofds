package com.ofds.dao.impl;

import static org.hamcrest.Matchers.*;
import com.ofds.dao.AbstractDAOTest;
import com.ofds.entity.Charity;
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
public class CharityDAOImplTest extends AbstractDAOTest {

    @Inject
    private CharityDAOImpl charityDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(charityDAO, is(notNullValue()));
        Assert.assertThat(charityDAO.getEntityManager(), is(notNullValue()));
    }

    @Test
    public void createCharity_newValidCharity_successCharity() throws ParseException {
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

        Assert.assertThat(charityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void getCharityByCharityEmail_newValidCharity_successCharity() throws ParseException {
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

        Assert.assertThat(charityDAO.getCharityByCharityEmail("newCharity@new.com"), is(not(nullValue())));
    }

    @Test
    public void edit_newValidCharities_successCharityEdit() throws ParseException {
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

        Charity charityToEdit = charityDAO.getCharityByCharityEmail("newCharity@new.com");
        charityToEdit.setCharityShortDescription("Changed Description");

        charityDAO.edit(charityToEdit);

        Assert.assertThat(charityDAO.getCharityByCharityEmail("newCharity@new.com"), is(not(nullValue())));
        Assert.assertThat(charityDAO.getCharityByCharityEmail("newCharity@new.com").getCharityShortDescription(),
                is("Changed Description"));
    }

    @Test
    public void remove_newValidCharities_successCharityRemove() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        charityDAO.remove(charityDAO.getCharityByCharityEmail("newCharityName@new.com"));

        Assert.assertThat(charityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void find_newValidCharities_successCharityFind() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        Charity charityToFind = charityDAO.getCharityByCharityEmail("newCharityName@new.com");

        Assert.assertThat(charityDAO.find(charityToFind.getCharityEmail()), is(not(nullValue())));
        Assert.assertThat(charityDAO.find(charityToFind.getCharityEmail()).getCharityEmail(),
                is(charityToFind.getCharityEmail()));
    }

    @Test
    public void loadAll_newValidCharities_successCharityLoad() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        Assert.assertThat(charityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void findRange_newValidCharities_successCharityRange() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        Charity charity2 = new Charity();
        charity2.setCharityName("New Charity Name2");
        charity2.setCharityRegistryName("NC");
        charity2.setCharityPassword("123");
        charity2.setCharityEmail("newCharityName2@new.com");
        charity2.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity2.setCharityCountry("IT");
        charity2.setCharityCity("MI");
        charity2.setCharityStreet("Street");
        charity2.setCharityIndex("021222");
        charity2.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity2);

        int[] range = new int[2];
        range[0] = 1;
        range[1] = 2;

        Assert.assertThat(charityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(charityDAO.findRange(range), is(not(empty())));
        Assert.assertThat(charityDAO.findRange(range), is(hasSize(2)));
    }

    @Test
    public void count_newValidCharities_successCharityCount() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        Charity charity2 = new Charity();
        charity2.setCharityName("New Charity Name2");
        charity2.setCharityRegistryName("NC");
        charity2.setCharityPassword("123");
        charity2.setCharityEmail("newCharityName2@new.com");
        charity2.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity2.setCharityCountry("IT");
        charity2.setCharityCity("MI");
        charity2.setCharityStreet("Street");
        charity2.setCharityIndex("021222");
        charity2.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity2);

        Assert.assertThat(charityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.count(), is(3));
    }

    @Test
    public void getByEntityParameter_newValidCharities_successCharityByParameter() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        Charity charity2 = new Charity();
        charity2.setCharityName("New Charity Name2");
        charity2.setCharityRegistryName("NC");
        charity2.setCharityPassword("123");
        charity2.setCharityEmail("newCharityName2@new.com");
        charity2.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity2.setCharityCountry("IT");
        charity2.setCharityCity("MI");
        charity2.setCharityStreet("Street");
        charity2.setCharityIndex("021222");
        charity2.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity2);

        Assert.assertThat(charityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(charityDAO.getByEntityParameter("Email", "newCharityName2@new.com"), is(notNullValue()));
        Assert.assertThat(charityDAO.getByEntityParameter("Email", "newCharityName2@new.com"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidCharities_successCharityByExcludeParameter() throws ParseException {
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

        Charity charity1 = new Charity();
        charity1.setCharityName("New Charity Name");
        charity1.setCharityRegistryName("NC");
        charity1.setCharityPassword("123");
        charity1.setCharityEmail("newCharityName@new.com");
        charity1.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity1.setCharityCountry("IT");
        charity1.setCharityCity("MI");
        charity1.setCharityStreet("Street");
        charity1.setCharityIndex("021222");
        charity1.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity1);

        Charity charity2 = new Charity();
        charity2.setCharityName("New Charity Name2");
        charity2.setCharityRegistryName("NC");
        charity2.setCharityPassword("123");
        charity2.setCharityEmail("newCharityName2@new.com");
        charity2.setCharityDateOfEstablishment(formatter.parse("1991-12-12"));
        charity2.setCharityCountry("IT");
        charity2.setCharityCity("MI");
        charity2.setCharityStreet("Street");
        charity2.setCharityIndex("021222");
        charity2.setCharityShortDescription("The new Charity Description");

        charityDAO.createCharity(charity2);

        Assert.assertThat(charityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(charityDAO.getAllByEntityExcludeParameter("Email", "newCharityName2@new.com"),
                is(notNullValue()));
        Assert.assertThat(charityDAO.getAllByEntityExcludeParameter("Email", "newCharityName2@new.com"),
                is(hasSize(2)));
    }

    @Test
    public void getByLinkedEntityParameter_newValidCharities_successCharityByLinkedParameter() {}

    @Test
    public void getByLinkedEntityParameter_newValidCharities_successCharityByLinkedParameterOverloaded() {}
}
