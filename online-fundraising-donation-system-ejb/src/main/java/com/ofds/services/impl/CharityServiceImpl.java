package com.ofds.services.impl;

import com.ofds.services.CharityService;
import com.ofds.services.RoleDecoratorService;
import com.ofds.services.UserService;

/**
 * Manage the Charity
 */

public class CharityServiceImpl extends RoleDecoratorService implements CharityService {

    public CharityServiceImpl(UserService decoratedUserService) {
        super(decoratedUserService);
    }

    @Override
    public void register() {

    }

    @Override
    public void checkAccount() {

    }
}
