package com.ofds.services.impl;

import com.ofds.services.FundraiserService;
import com.ofds.services.RoleDecoratorService;
import com.ofds.services.UserService;

/**
 * Manage the Fundraiser.
 */

public class FundraiserServiceImpl extends RoleDecoratorService implements FundraiserService {

    /**
     * The default constructor.
     * @param decoratedUserService - the decorated User service.
     */
    public FundraiserServiceImpl(UserService decoratedUserService) {
        super(decoratedUserService);
    }

    /**
     * Register the specific Fundraiser.
     */
    @Override
    public void register() {

    }

    /**
     * Check the account of the specific Fundraiser.
     */
    @Override
    public void checkAccount() {

    }
}
