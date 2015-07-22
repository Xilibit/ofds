package com.ofds.util.person;

import com.ofds.util.person.dto.GroupsDTO;
import com.ofds.util.person.emun.PersonRole;

import java.util.ArrayList;
import java.util.List;

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
        setAdminGroupsDTOCollection(createAdminGroupsDTOCollection());
        return decoratedPerson;
    }

    /**
     * Method is to set the relevant Group.
     * @param groupsDTOCollection - the collection of Group.
     */
    private void setAdminGroupsDTOCollection(List<GroupsDTO> groupsDTOCollection) {
        decoratedPerson.setGroupsDTOCollection(groupsDTOCollection);
    }

    /**
     * The method is to create Group collection for Admin.
     * @return  - the created collection of Groups.
     */
    private List<GroupsDTO> createAdminGroupsDTOCollection() {
        GroupsDTO groupsDTO = new GroupsDTO();
        List<GroupsDTO> groupsDTOCollection = new ArrayList<>();
        groupsDTO.setGroupId(PersonRole.ADMIN.getId());
        groupsDTO.setGroupUserId(PersonRole.ADMIN.getValue());
        groupsDTOCollection.add(groupsDTO);
        return groupsDTOCollection;
    }
}
