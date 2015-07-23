package com.ofds.util.mapper;

import com.ofds.entity.Activity;
import com.ofds.util.person.dto.ActivityDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Mange the default Activity Mapper.
 */
public class ActivityMapper implements Mapper<Activity, ActivityDTO> {

    /**
     * The default Constructor.
     */
    public ActivityMapper() {
    }

    @Override
    public MapperFactory getMapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Override
    public ActivityDTO fromEntityToDTO(Activity activity, ActivityDTO activityDTO) {
        return getMapperFactory().getMapperFacade().map(Activity.class, ActivityDTO.class);
    }

    @Override
    public Activity fromDTOToEntity(ActivityDTO activityDTO, Activity activity) {
        return getMapperFactory().getMapperFacade().map(ActivityDTO.class, Activity.class);
    }
}
