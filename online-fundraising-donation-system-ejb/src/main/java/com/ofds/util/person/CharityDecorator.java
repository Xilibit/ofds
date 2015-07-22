package com.ofds.util.person;

import com.ofds.util.person.dto.GroupsDTO;
import com.ofds.util.person.emun.PersonRole;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage the Charity.
 */
public class CharityDecorator extends PersonRoleDecorator {

    /**
     * The default constructor.
     *
     * @param decoratedPerson - The person to decorate.
     */
    public CharityDecorator(Person decoratedPerson) {
        super(decoratedPerson);
    }

    /**
     * The method is to get decorated Person.
     * @return - the decorated Person.
     */
    @Override
    public Person getPerson() {
        setCharityGroupsDTOCollection(createCharityGroupsDTOCollection());
        return decoratedPerson;
    }

    /**
     * Method is to set the relevant Group.
     * @param groupsDTOCollection - the collection of Group.
     */
    private void setCharityGroupsDTOCollection(List<GroupsDTO> groupsDTOCollection) {
        decoratedPerson.setGroupsDTOCollection(groupsDTOCollection);
    }

    /**
     * The method is to create Group collection for Charity.
     * @return  - the created collection of Groups.
     */
    private List<GroupsDTO> createCharityGroupsDTOCollection() {
        GroupsDTO groupsDTO = new GroupsDTO();
        List<GroupsDTO> groupsDTOCollection = new ArrayList<>();
        groupsDTO.setGroupId(PersonRole.CHARITY.getId());
        groupsDTO.setGroupUserId(PersonRole.CHARITY.getValue());
        groupsDTOCollection.add(groupsDTO);
        return groupsDTOCollection;
    }
}
