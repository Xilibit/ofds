package com.ofds.services;

import javax.ejb.Local;

/**
 * Mange the abstract user
 */

@Local
public interface UserService {

    /**
     * Register the specific User.
     */
    void register();

    /**
     * Check the account of the specific User.
     */
    void checkAccount();

}
