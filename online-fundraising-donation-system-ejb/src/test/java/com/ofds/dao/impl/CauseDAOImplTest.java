package com.ofds.dao.impl;

import static org.hamcrest.Matchers.*;
import com.ofds.dao.AbstractDAOTest;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class CauseDAOImplTest extends AbstractDAOTest {

    @Inject
    private CauseDAOImpl causeDAO;

    @Test
    public void getEntityManager_existentEntityManager_notNullEntityManager() {
        Assert.assertThat(causeDAO, is(notNullValue()));
        Assert.assertThat(causeDAO.getEntityManager(), is(notNullValue()));
    }
}
