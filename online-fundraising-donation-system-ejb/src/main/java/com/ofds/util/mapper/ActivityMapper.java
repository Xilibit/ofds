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
                .field("causeCollection", "causeDTOCollection")
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
                .field("donationDTOCollection", "donationCollection")
                .field("causeDTOCollection", "causeCollection")
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
