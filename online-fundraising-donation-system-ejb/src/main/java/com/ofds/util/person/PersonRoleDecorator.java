package com.ofds.util.person;

/**
 * Manage the decorated Person.
 */
public abstract class PersonRoleDecorator implements Person {

    protected Person decoratedPerson;

    /**
     * The default constructor.
     * @param decoratedPerson - The person to decorate.
     */
    public PersonRoleDecorator (Person decoratedPerson) {
        this.decoratedPerson = decoratedPerson;
    }

    /**
     * The method is to return the Person.
     * @return - the decorated Person.
     */
    public Person getPerson() {
        return decoratedPerson;
    }
}
