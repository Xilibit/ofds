package com.ofds.util.mapper;

import com.ofds.entity.Activity;
import com.ofds.util.person.dto.ActivityDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Mange the default Activity Mapper.
 */
public class ActivityMapper implements Mapper<Activity, ActivityDTO> {

    private MapperFactory mapperFactory;

    /**
     * The default Constructor.
     */
    public ActivityMapper() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    @Override
    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    @Override
    public void customize(Activity activity, Class<ActivityDTO> activityDTOClass) {
        getMapperFactory().classMap(activity.getClass(), activityDTOClass)
                .mapNulls(true).mapNullsInReverse(true)
                .fieldMap("idACTIVITY", "activityId").mapNulls(true).mapNullsInReverse(true).add()
                .fieldMap("activityName", "activityDTOName").mapNulls(true).mapNullsInReverse(true).add()
                .fieldMap("activityShortDescription", "activityDTOShortDescription").mapNulls(true)
                .mapNullsInReverse(true).add()
                .fieldMap("activityInsertTs", "activityDTOInsertTs").mapNulls(true).mapNullsInReverse(true).add()
                .fieldMap("activityTerminationDate", "activityDTOTerminationDate").mapNulls(true)
                .mapNullsInReverse(true).add()
                .field("donationCollection", "donationDTOCollection")
                .field("causeCollection", "causeDTOCollection").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserEmail",
                        "fundraiserFundraiserEmail.fundraiserDTOEmail").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserFirstName",
                        "fundraiserFundraiserEmail.fundraiserDTOFirstName").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserLastName",
                        "fundraiserFundraiserEmail.fundraiserDTOLastName").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDateOfBirth",
                        "fundraiserFundraiserEmail.fundraiserDTODateOfBirth").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserIsAdmin",
                        "fundraiserFundraiserEmail.fundraiserDTOIsAdmin").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserPassword",
                        "fundraiserFundraiserEmail.fundraiserDTOPassword").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserCountry",
                        "fundraiserFundraiserEmail.fundraiserDTOCountry").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserCity",
                        "fundraiserFundraiserEmail.fundraiserDTOCity").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserStreet",
                        "fundraiserFundraiserEmail.fundraiserDTOStreet").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserIndex",
                        "fundraiserFundraiserEmail.fundraiserDTOIndex").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserWallet",
                        "fundraiserFundraiserEmail.fundraiserDTOWallet").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.groupsCollection",
                        "fundraiserFundraiserEmail.groupsDTOCollection").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraisersDonationCollection",
                        "fundraiserFundraiserEmail.donationDTOCollection").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraisersActivityCollection",
                        "fundraiserFundraiserEmail.activityDTOCollection").mapNulls(true).mapNullsInReverse(true)
                .byDefault()
                .register();
    }

    @Override
    public void customize(ActivityDTO activityDTO, Activity activity) {
        getMapperFactory().classMap(activityDTO.getClass(), activity.getClass())
                .mapNulls(true).mapNullsInReverse(true)
                .fieldMap("activityId", "idACTIVITY").mapNulls(true).mapNullsInReverse(true).add()
                .fieldMap("activityDTOName", "activityName").mapNulls(false).mapNullsInReverse(true).add()
                .fieldMap("activityDTOShortDescription", "activityShortDescription").mapNulls(true)
                .mapNullsInReverse(true).add()
                .fieldMap("activityDTOInsertTs", "activityInsertTs").mapNulls(true).mapNullsInReverse(true).add()
                .fieldMap("activityDTOTerminationDate", "activityTerminationDate").mapNulls(true)
                .mapNullsInReverse(true).add()
                .field("donationDTOCollection", "donationCollection").mapNulls(true).mapNullsInReverse(true)
                .field("causeDTOCollection", "causeCollection").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOEmail",
                       "fundraiserFundraiserEmail.fundraiserEmail").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOFirstName",
                       "fundraiserFundraiserEmail.fundraiserFirstName").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOLastName",
                       "fundraiserFundraiserEmail.fundraiserLastName").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTODateOfBirth",
                       "fundraiserFundraiserEmail.fundraiserDateOfBirth").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOIsAdmin",
                       "fundraiserFundraiserEmail.fundraiserIsAdmin").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOPassword",
                       "fundraiserFundraiserEmail.fundraiserPassword").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOCountry",
                       "fundraiserFundraiserEmail.fundraiserCountry").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOCity",
                       "fundraiserFundraiserEmail.fundraiserCity").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOStreet",
                       "fundraiserFundraiserEmail.fundraiserStreet").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOIndex",
                       "fundraiserFundraiserEmail.fundraiserIndex").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.fundraiserDTOWallet",
                       "fundraiserFundraiserEmail.fundraiserWallet").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.groupsDTOCollection",
                       "fundraiserFundraiserEmail.groupsCollection").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.donationDTOCollection",
                       "fundraiserFundraiserEmail.fundraisersDonationCollection").mapNulls(true).mapNullsInReverse(true)
                .field("fundraiserFundraiserEmail.activityDTOCollection",
                       "fundraiserFundraiserEmail.fundraisersActivityCollection").mapNulls(true).mapNullsInReverse(true)
                .byDefault()
                .register();
    }

    @Override
    public ActivityDTO fromEntityToDTO(Activity activity, ActivityDTO activityDTO) {
        return getMapperFactory().getMapperFacade().map(activity, ActivityDTO.class);
    }

    @Override
    public Activity fromDTOToEntity(ActivityDTO activityDTO, Activity activity) {
        return getMapperFactory().getMapperFacade().map(activityDTO, Activity.class);
    }
}
