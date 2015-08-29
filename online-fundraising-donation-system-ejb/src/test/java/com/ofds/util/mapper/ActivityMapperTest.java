package com.ofds.util.mapper;

import static org.hamcrest.Matchers.*;

import com.ofds.TestsUtil;
import com.ofds.entity.*;
import com.ofds.util.AbstractMapperTest;
import com.ofds.util.person.dto.ActivityDTO;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@RunWith(Arquillian.class)
public class ActivityMapperTest extends AbstractMapperTest {

    @Inject
    private ActivityMapper activityMapper;

    @Test
    public void getActivityMapper_existentActivityMapper_notNullMapperFactory() {
        Assert.assertThat(activityMapper, is(notNullValue()));
        Assert.assertThat(activityMapper.getMapperFactory(), is(notNullValue()));
    }

    @Test
    public void fromEntityToDTO_existentEntityAndDTO_ValidDTOresult() throws ParseException {

        Fundraiser fundraiser = TestsUtil.getFundraiserForTest();
        Charity charity = TestsUtil.getCharityForTest();

        Cause cause = TestsUtil.getCauseForTest();
        cause.setCharityCharityEmail(charity);

        Donation donation = TestsUtil.getDonationForTest();
        donation.setFundraiserFundraiserEmail(fundraiser);
        Collection<Donation> donations = new ArrayList<Donation>();
        donations.add(donation);

        Activity activity = TestsUtil.getActivityForTest();
        activity.setFundraiserFundraiserEmail(fundraiser);
        Collection<Cause> causes = new ArrayList<Cause>();
        causes.add(cause);
        activity.setCauseCollection(causes);
        activity.setDonationCollection(donations);

        ActivityDTO activityDTO = new ActivityDTO();
        activityMapper.customize(activity, ActivityDTO.class);
        activityDTO = activityMapper.fromEntityToDTO(activity, activityDTO);

        Assert.assertThat(activityDTO, is(notNullValue()));
        Assert.assertThat(activityDTO.getActivityId(), is(activity.getIdACTIVITY()));
        Assert.assertThat(activityDTO.getCauseDTOCollection().size(), is(1));
        Assert.assertThat(activityDTO.getDonationDTOCollection().size(), is(1));
        Assert.assertThat(activityDTO.getFundraiserFundraiserEmail().getFundraiserDTOCity(),
                is(activity.getFundraiserFundraiserEmail().getFundraiserCity()));
    }

}
