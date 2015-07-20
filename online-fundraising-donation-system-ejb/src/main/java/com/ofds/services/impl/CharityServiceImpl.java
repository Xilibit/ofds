package com.ofds.services.impl;

import com.ofds.services.CharityService;
import com.ofds.services.RoleDecoratorService;
import com.ofds.services.UserService;

/**
 * Manage the Charity
 */

public class CharityServiceImpl extends RoleDecoratorService implements CharityService {

    /**
     * The default constructor.
     * @param decoratedUserService - the decorated User service.
     */
    public CharityServiceImpl(UserService decoratedUserService) {
        super(decoratedUserService);
    }

    /**
     * Register the specific Charity.
     */
    @Override
    public void register() {

    }

    /**
     * Check the account of the specific Charity.
     */
    @Override
    public void checkAccount() {

    }
}
