package com.ofds.util.person;

import com.ofds.util.person.dto.GroupsDTO;
import com.ofds.util.person.emun.PersonRole;

import java.util.ArrayList;
import java.util.Collection;

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
    private void setCharityGroupsDTOCollection(Collection<GroupsDTO> groupsDTOCollection) {
        decoratedPerson.setGroupsDTOCollection(groupsDTOCollection);
    }

    /**
     * The method is to create Group collection for Charity.
     * @return  - the created collection of Groups.
     */
    private Collection<GroupsDTO> createCharityGroupsDTOCollection() {
        GroupsDTO groupsDTO = new GroupsDTO();
        Collection<GroupsDTO> groupsDTOCollection = new ArrayList<>();
        groupsDTO.setGroupDTOId(PersonRole.CHARITY.getId());
        groupsDTO.setGroupDTOUserId(PersonRole.CHARITY.getValue());
        groupsDTOCollection.add(groupsDTO);
        return groupsDTOCollection;
    }
}
