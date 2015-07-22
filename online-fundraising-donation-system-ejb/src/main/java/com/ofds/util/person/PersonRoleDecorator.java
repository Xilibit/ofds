package com.ofds.util.person;

import com.ofds.util.person.dto.GroupsDTO;

import java.util.List;

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
    @Override
    public Person getPerson() {
        return decoratedPerson;
    }

    /**
     * Method is to set the relevant Group.
     * @param groupsDTOCollection - the collection of Group.
     */
    @Override
    public void setGroupsDTOCollection(List<GroupsDTO> groupsDTOCollection) {
        decoratedPerson.setGroupsDTOCollection(groupsDTOCollection);
    }
}
