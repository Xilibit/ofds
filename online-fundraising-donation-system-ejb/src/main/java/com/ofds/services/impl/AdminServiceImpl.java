package com.ofds.services.impl;

import com.ofds.services.AdminService;
import com.ofds.services.RoleDecoratorService;
import com.ofds.services.UserService;

/**
 * Manage the Admin.
 */

public class AdminServiceImpl extends RoleDecoratorService implements AdminService {

    /**
     * The default constructor.
     * @param decoratedUserService - the decorated User service.
     */
    public AdminServiceImpl(UserService decoratedUserService) {
        super(decoratedUserService);
    }

    /**
     * Register the specific Admin.
     */
    @Override
    public void register() {

    }

    /**
     * Check the account of the specific Admin.
     */
    @Override
    public void checkAccount() {

    }
}
