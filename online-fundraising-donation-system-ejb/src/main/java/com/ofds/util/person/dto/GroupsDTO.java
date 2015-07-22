package com.ofds.util.person.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * Manage the Groups.
 */
public class GroupsDTO {

    @NotNull
    private Integer groupId;

    @NotNull
    private String groupUserId;

    private List<CharityDTO> charityDTOCollection;
    private List<FundraiserDTO> fundraiserDTOCollection;

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

    public List<CharityDTO> getCharityDTOCollection() {
        return charityDTOCollection;
    }

    public void setCharityDTOCollection(List<CharityDTO> charityDTOCollection) {
        this.charityDTOCollection = charityDTOCollection;
    }

    public List<FundraiserDTO> getFundraiserDTOCollection() {
        return fundraiserDTOCollection;
    }

    public void setFundraiserDTOCollection(List<FundraiserDTO> fundraiserDTOCollection) {
        this.fundraiserDTOCollection = fundraiserDTOCollection;
    }
}
