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
                .mapNulls(false).mapNullsInReverse(false)
                .fieldMap("idACTIVITY", "activityId").mapNulls(false).mapNullsInReverse(false).add()
                .field("donationCollection", "donationDTOCollection")
                .field("causeCollection", "causeDTOCollection")
                .byDefault()
                .register();
    }

    @Override
    public void customize(ActivityDTO activityDTO, Activity activity) {
        getMapperFactory().classMap(activityDTO.getClass(), activity.getClass())
                .mapNulls(false).mapNullsInReverse(false)
                .fieldMap("activityId", "idACTIVITY").mapNulls(false).mapNullsInReverse(false).add()
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
        return getMapperFactory().getMapperFacade().map(ActivityDTO.class, Activity.class);
    }
}
