package com.ofds.util.person;

/**
 * Manage the Admin.
 */
public class AdminDecorator extends PersonRoleDecorator {

    /**
     * The default constructor.
     *
     * @param decoratedPerson - The person to decorate.
     */
    public AdminDecorator(Person decoratedPerson) {
        super(decoratedPerson);
    }

    /**
     * The method is to get decorated Person.
     * @return - the decorated Person.
     */
    @Override
    public Person getPerson() {
        return decoratedPerson;
    }
}
