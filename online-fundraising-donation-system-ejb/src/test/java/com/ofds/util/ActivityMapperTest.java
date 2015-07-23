package com.ofds.util;

import static org.hamcrest.Matchers.*;
import com.ofds.util.mapper.ActivityMapper;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class ActivityMapperTest extends AbstractMapperTest {

    @Inject
    private ActivityMapper activityMapper;

    @Test
    public void getActivityMapper_existentActivityMapper_notNullMapperFactory() {
        Assert.assertThat(activityMapper, is(notNullValue()));
        Assert.assertThat(activityMapper.getMapperFactory(), is(notNullValue()));
    }

}
