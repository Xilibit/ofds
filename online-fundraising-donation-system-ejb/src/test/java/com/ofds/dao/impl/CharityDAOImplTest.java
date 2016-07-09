package com.ofds.dao.impl;

import com.ofds.TestsUtil;
import com.ofds.dao.AbstractDAOTest;
import com.ofds.entity.Charity;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.ParseException;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

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
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Assert.assertThat(charityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void getCharityByCharityEmail_newValidCharity_successCharity() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Assert.assertThat(charityDAO.getCharityByCharityEmail("newCharity@new.com"), is(not(nullValue())));
    }

    @Test
    public void edit_newValidCharities_successCharityEdit() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

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
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

        charityDAO.createCharity(charity1);

        charityDAO.remove(charityDAO.getCharityByCharityEmail("newCharityName@new.com"));

        Assert.assertThat(charityDAO.loadAll(), is(not(nullValue())));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.loadAll(), is(hasSize(1)));
    }

    @Test
    public void find_newValidCharities_successCharityFind() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

        charityDAO.createCharity(charity1);

        Charity charityToFind = charityDAO.getCharityByCharityEmail("newCharityName@new.com");

        Assert.assertThat(charityDAO.find(charityToFind.getCharityEmail()), is(not(nullValue())));
        Assert.assertThat(charityDAO.find(charityToFind.getCharityEmail()).getCharityEmail(),
                is(charityToFind.getCharityEmail()));
    }

    @Test
    public void loadAll_newValidCharities_successCharityLoad() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

        charityDAO.createCharity(charity1);

        Assert.assertThat(charityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.loadAll(), is(hasSize(2)));
    }

    @Test
    public void findRange_newValidCharities_successCharityRange() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);
        charity1.setCharityEmail("dif@dif.com");

        charityDAO.createCharity(charity1);

        Charity charity2 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

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
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);
        charity1.setCharityEmail("cop@cop.com");


        charityDAO.createCharity(charity1);

        Charity charity2 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

        charityDAO.createCharity(charity2);

        Assert.assertThat(charityDAO.loadAll(), is(notNullValue()));
        Assert.assertThat(charityDAO.loadAll(), is(not(empty())));
        Assert.assertThat(charityDAO.count(), is(3));
    }

    @Test
    public void getByEntityParameter_newValidCharities_successCharityByParameter() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);
        charity1.setCharityEmail("zop@zop.com");

        charityDAO.createCharity(charity1);

        Charity charity2 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

        charityDAO.createCharity(charity2);

        Assert.assertThat(charityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(charityDAO.getByEntityParameter("Email", "newCharity@new.com"), is(notNullValue()));
        Assert.assertThat(charityDAO.getByEntityParameter("Email", "newCharity@new.com"), is(hasSize(1)));
    }

    @Test
    public void getAllByEntityExcludeParameter_newValidCharities_successCharityByExcludeParameter() throws ParseException {
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);

        charityDAO.createCharity(charity);

        Charity charity1 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);
        charity1.setCharityEmail("qwerty@fa.com");

        charityDAO.createCharity(charity1);

        Charity charity2 = TestsUtil.getCharityForTest(TestsUtil.SECOND_CHARITY_EMAIL, TestsUtil.SECOND_CHARITY_NAME);

        charityDAO.createCharity(charity2);

        Assert.assertThat(charityDAO.loadAll(), is(hasSize(3)));
        Assert.assertThat(charityDAO.getAllByEntityExcludeParameter("Email", "newCharity@new.com"),
                is(notNullValue()));
        Assert.assertThat(charityDAO.getAllByEntityExcludeParameter("Email", "newCharity@new.com"),
                is(hasSize(2)));
    }
}
