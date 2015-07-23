package com.ofds.util;

import com.ofds.util.person.Person;
import com.ofds.entity.Activity;
import com.ofds.entity.Fundraiser;
import com.ofds.entity.Cause;
import com.ofds.entity.Charity;
import com.ofds.entity.Donation;
import com.ofds.entity.Groups;
import com.ofds.entity.base.BaseEntity;
import com.ofds.util.mapper.Mapper;
import com.ofds.util.mapper.MapperImpl;
import com.ofds.util.person.dto.ActivityDTO;
import com.ofds.util.person.dto.FundraiserDTO;
import com.ofds.util.person.dto.CharityDTO;
import com.ofds.util.person.dto.CauseDTO;
import com.ofds.util.person.dto.DonationDTO;
import com.ofds.util.person.dto.GroupsDTO;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public class AbstractMapperTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackage(Mapper.class.getPackage())
                .addPackage(AbstractMapperTest.class.getPackage())
                .addPackage(MapperImpl.class.getPackage())
                .addPackage(ActivityDTO.class.getPackage())
                .addPackage(FundraiserDTO.class.getPackage())
                .addPackage(CharityDTO.class.getPackage())
                .addPackage(CauseDTO.class.getPackage())
                .addPackage(DonationDTO.class.getPackage())
                .addPackage(GroupsDTO.class.getPackage())
                .addPackage(Activity.class.getPackage())
                .addPackage(Fundraiser.class.getPackage())
                .addPackage(Cause.class.getPackage())
                .addPackage(Charity.class.getPackage())
                .addPackage(Donation.class.getPackage())
                .addPackage(Groups.class.getPackage())
                .addPackage(BaseEntity.class.getPackage())
                .addPackage(Person.class.getPackage())
                .addPackages(true, "ma.glasnost")
                .addPackages(true, "com.thoughtworks")
                .addPackages(true, "com.googlecode")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
