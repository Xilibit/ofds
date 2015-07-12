package com.ofds.dao.impl;

import com.ofds.dao.AbstractDAOTest;
import com.ofds.dao.FundraiserDAO;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class FundraiserDAOImplTest extends AbstractDAOTest {

    @Inject
    private FundraiserDAO fundraiserDAO;

    @Test
    public void getFundraiserByFundraiserEmail_existentFundraiser_successfulFundraiser() {

    }
}
