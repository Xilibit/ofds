package com.ofds.dao;

import com.ofds.dao.impl.FundraiserDAOImpl;
import com.ofds.entity.Activity;
import com.ofds.entity.Donation;
import com.ofds.entity.Fundraiser;
import com.ofds.entity.Groups;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;

import javax.transaction.UserTransaction;

public class AbstractDAOTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap
                .create(JavaArchive.class, "test.jar")
                .addAsResource("arquillian.xml")
                .addAsResource("log4j.xml")
                .addPackages(true, FundraiserDAOImpl.class.getPackage())
                .addPackage(FundraiserDAO.class.getPackage())
                .addPackage(Fundraiser.class.getPackage())
                .addPackage(Activity.class.getPackage())
                .addPackage(Donation.class.getPackage())
                .addPackage(Groups.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    protected UserTransaction userTransaction;

    public AbstractDAOTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        this.userTransaction.begin();
    }

    @After
    public void tearDown() throws Exception {
        try {
            this.userTransaction.rollback();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
