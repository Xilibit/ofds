package com.ofds.util.mapper;

import com.ofds.TestsUtil;
import com.ofds.entity.Activity;
import com.ofds.entity.Cause;
import com.ofds.entity.Charity;
import com.ofds.entity.Donation;
import com.ofds.entity.Fundraiser;
import com.ofds.util.AbstractMapperTest;
import com.ofds.util.person.dto.ActivityDTO;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

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

        Fundraiser fundraiser = TestsUtil.getFundraiserForTest(TestsUtil.FIRST_FUNDRAISER_EMAIL);
        Charity charity = TestsUtil.getCharityForTest(TestsUtil.FIRST_CHARITY_EMAIL, TestsUtil.FIRST_CHARITY_NAME);;

        Cause cause = TestsUtil.getCauseForTest(TestsUtil.FIRST_CAUSE_NAME, TestsUtil.FIRST_CAUSE_PERSENTAGE);
        cause.setCharityCharityEmail(charity);

        Donation donation = TestsUtil.getDonationForTest(TestsUtil.FIRST_DONATION_AMOUNT);
        donation.setFundraiserFundraiserEmail(fundraiser);
        Collection<Donation> donations = new ArrayList<Donation>();
        donations.add(donation);

        Activity activity = TestsUtil.getActivityForTest(TestsUtil.FIRST_ACTIVITY_NAME);
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
