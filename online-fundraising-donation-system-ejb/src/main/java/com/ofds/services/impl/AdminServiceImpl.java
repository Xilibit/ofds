package com.ofds.services.impl;

import com.ofds.services.AdminService;
import com.ofds.services.RoleDecoratorService;
import com.ofds.services.UserService;

/**
 * Manage the Admin.
 */

public class AdminServiceImpl extends RoleDecoratorService implements AdminService {

    public AdminServiceImpl(UserService decoratedUserService) {
        super(decoratedUserService);
    }

    @Override
    public void register() {

    }

    @Override
    public void checkAccount() {

    }
}
