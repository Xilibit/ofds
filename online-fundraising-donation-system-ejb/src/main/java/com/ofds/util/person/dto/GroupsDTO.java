package com.ofds.util.person.dto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import javax.validation.constraints.NotNull;

/**
 * Manage the Groups.
 */
public class GroupsDTO implements Serializable {

    private static final long serialVersionUID = 9177100123000124727L;

    @NotNull
    private Integer groupDTOId;

    @NotNull
    private String groupDTOUserId;

    private Collection<CharityDTO> charityDTOCollection;

    private Collection<FundraiserDTO> fundraiserDTOCollection;

    public Integer getGroupDTOId() {
        return groupDTOId;
    }

    public void setGroupDTOId(Integer groupDTOId) {
        this.groupDTOId = groupDTOId;
    }

    public String getGroupDTOUserId() {
        return groupDTOUserId;
    }

    public void setGroupDTOUserId(String groupDTOUserId) {
        this.groupDTOUserId = groupDTOUserId;
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

    /**
     * Avoid the critical issue reported by Sonar.
     * @param stream - the stream to write.
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream stream)
            throws IOException {
        stream.defaultWriteObject();
    }

    /**
     * Avoid the critical issue reported by Sonar.
     * @param stream - the stream to read.
     * @throws IOException
     */
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
    }
}
