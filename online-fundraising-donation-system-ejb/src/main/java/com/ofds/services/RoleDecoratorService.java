package com.ofds.services;

/**
 * Decorate the User's role.
 */

public abstract class RoleDecoratorService implements UserService {

    protected UserService decoratedUserService;

    public RoleDecoratorService(UserService decoratedUserService) {
        this.decoratedUserService = decoratedUserService;
    }

    public void register() {
        decoratedUserService.register();
    }

    public void checkAccount() {
        decoratedUserService.checkAccount();
    }
}
