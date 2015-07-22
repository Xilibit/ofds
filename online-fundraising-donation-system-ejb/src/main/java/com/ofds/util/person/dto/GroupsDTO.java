package com.ofds.util.person.dto;

import java.util.Collection;
import javax.validation.constraints.NotNull;

/**
 * Manage the Groups.
 */
public class GroupsDTO {

    @NotNull
    private Integer groupId;

    @NotNull
    private String groupUserId;

    private Collection<CharityDTO> charityDTOCollection;
    private Collection<FundraiserDTO> fundraiserDTOCollection;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(String groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Collection<CharityDTO> getCharityDTOCollection() {
        return charityDTOCollection;
    }

    public void setCharityDTOCollection(Collection<CharityDTO> charityDTOCollection) {
        this.charityDTOCollection = charityDTOCollection;
    }

    public Collection<FundraiserDTO> getFundraiserDTOCollection() {
        return fundraiserDTOCollection;
    }

    public void setFundraiserDTOCollection(Collection<FundraiserDTO> fundraiserDTOCollection) {
        this.fundraiserDTOCollection = fundraiserDTOCollection;
    }
}
