package com.ofds.dao.impl;

import com.ofds.dao.AbstractDAOTest;
import com.ofds.dao.FundraiserDAO;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class FundraiserDAOImplTest extends AbstractDAOTest {

    @Inject
    private FundraiserDAOImpl fundraiserDAO;

    @Test
    public void getFundraiserByFundraiserEmail_existentFundraiser_successfulFundraiser() {
        Assert.assertNotNull(fundraiserDAO);
    }
}
