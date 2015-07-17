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

    @Test
    public void createCause_newValidCause_successCause() {}

    @Test
    public void getCauseByCauseName_newValidCauses_successCause() {}

    @Test
    public void edit_newValidCauses_successCauseEdit() {}

    @Test
    public void remove_newValidCauses_successCausesRemove() {}

    @Test
    public void find_newValidCauses_successCauseFind() {}

    @Test
    public void loadAll_newValidCauses_successCausesLoad() {}

    @Test
    public void findRange_newValidCauses_successCausesRange() {}

    @Test
    public void count_newValidCauses_successCausesCount() {}

    @Test
    public void getByEntityParameter_newValidCauses_successCauseByParameter() {}

    @Test
    public void getAllByEntityExcludeParameter_newValidCause_successCauseByExcludeParameter() {}

    @Test
    public void getByLinkedEntityParameter_newValidCauses_successCausesByLinkedParameter() {}

    @Test
    public void getByLinkedEntityParameter_newValidCauses_successCauseByLinkedParameterOverloaded() {}
}
