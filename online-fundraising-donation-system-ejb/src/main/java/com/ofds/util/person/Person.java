package com.ofds.util.person;

import com.ofds.util.person.dto.GroupsDTO;

import java.util.List;

/**
 * Manage the person.
 */
public interface Person {

    /**
     * The method is to get the Person.
     * @return - the created Person.
     */
    Person getPerson();

    /**
     * Method is to set the relevant Group.
     * @param groupsDTOCollection - the collection of Group.
     */
    void setGroupsDTOCollection(List<GroupsDTO> groupsDTOCollection);

}
