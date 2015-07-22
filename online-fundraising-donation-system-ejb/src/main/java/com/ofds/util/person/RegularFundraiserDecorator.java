package com.ofds.util.person;

import com.ofds.util.person.dto.GroupsDTO;
import com.ofds.util.person.emun.PersonRole;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Manage the Fundraiser.
 */
public class RegularFundraiserDecorator extends PersonRoleDecorator {

    /**
     * The default constructor.
     *
     * @param decoratedPerson - The person to decorate.
     */
    public RegularFundraiserDecorator(Person decoratedPerson) {
        super(decoratedPerson);
    }

    /**
     * The method is to get decorated Person.
     * @return - the decorated Person.
     */
    @Override
    public Person getPerson() {
        setRegularGroupsDTOCollection(createRegularGroupsDTOCollection());
        return decoratedPerson;
    }

    /**
     * Method is to set the relevant Group.
     * @param groupsDTOCollection - the collection of Group.
     */
    private void setRegularGroupsDTOCollection(Collection<GroupsDTO> groupsDTOCollection) {
        decoratedPerson.setGroupsDTOCollection(groupsDTOCollection);
    }

    /**
     * The method is to create Group collection for Regular Fundraiser.
     * @return  - the created collection of Groups.
     */
    private Collection<GroupsDTO> createRegularGroupsDTOCollection() {
        GroupsDTO groupsDTO = new GroupsDTO();
        Collection<GroupsDTO> groupsDTOCollection = new ArrayList<>();
        groupsDTO.setGroupId(PersonRole.FUNDRAISER.getId());
        groupsDTO.setGroupUserId(PersonRole.FUNDRAISER.getValue());
        groupsDTOCollection.add(groupsDTO);
        return groupsDTOCollection;
    }
}
