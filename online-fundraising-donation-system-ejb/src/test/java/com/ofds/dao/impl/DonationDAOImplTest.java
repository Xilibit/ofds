package com.ofds.dao.impl;

import static org.hamcrest.Matchers.*;
import com.ofds.dao.AbstractDAOTest;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class DonationDAOImplTest extends AbstractDAOTest {

    @Inject
    private DonationDAOImpl donationDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(donationDAO, is(notNullValue()));
        Assert.assertThat(donationDAO.getEntityManager(), is(notNullValue()));
    }
}
