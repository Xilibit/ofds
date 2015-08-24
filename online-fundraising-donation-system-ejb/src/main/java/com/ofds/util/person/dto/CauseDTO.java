package com.ofds.util.person.dto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Future;

/**
 * Manage the Cause.
 */
public class CauseDTO implements Serializable {

    private static final long serialVersionUID = 7677333664500133327L;

    @NotNull
    private Integer causeId;

    @NotNull
    private String causeDTOName;

    @NotNull
    private String causeDTOShortDescription;

    @NotNull
    private Date causeDTOInsertTs;

    @NotNull
    @Future
    private Date causeDTOTerminationDate;

    @NotNull
    private String causeDTOPercentage;

    private Collection<DonationDTO> donationDTOCollection;

    private Collection<ActivityDTO> activityDTOCollection;

    @NotNull
    private CharityDTO charityCharityEmail;

    public Integer getCauseId() {
        return causeId;
    }

    public void setCauseId(Integer causeId) {
        this.causeId = causeId;
    }

    public String getCauseDTOName() {
        return causeDTOName;
    }

    public void setCauseDTOName(String causeDTOName) {
        this.causeDTOName = causeDTOName;
    }

    public String getCauseDTOShortDescription() {
        return causeDTOShortDescription;
    }

    public void setCauseDTOShortDescription(String causeDTOShortDescription) {
        this.causeDTOShortDescription = causeDTOShortDescription;
    }

    public Date getCauseDTOInsertTs() {
        return causeDTOInsertTs;
    }

    public void setCauseDTOInsertTs(Date causeDTOInsertTs) {
        this.causeDTOInsertTs = causeDTOInsertTs;
    }

    public Date getCauseDTOTerminationDate() {
        return causeDTOTerminationDate;
    }

    public void setCauseDTOTerminationDate(Date causeDTOTerminationDate) {
        this.causeDTOTerminationDate = causeDTOTerminationDate;
    }

    public String getCauseDTOPercentage() {
        return causeDTOPercentage;
    }

    public void setCauseDTOPercentage(String causeDTOPercentage) {
        this.causeDTOPercentage = causeDTOPercentage;
    }

    public Collection<DonationDTO> getDonationDTOCollection() {
        return donationDTOCollection;
    }

    public void setDonationDTOCollection(Collection<DonationDTO> donationDTOCollection) {
        this.donationDTOCollection = donationDTOCollection;
    }

    public Collection<ActivityDTO> getActivityDTOCollection() {
        return activityDTOCollection;
    }

    public void setActivityDTOCollection(Collection<ActivityDTO> activityDTOCollection) {
        this.activityDTOCollection = activityDTOCollection;
    }

    public CharityDTO getCharityCharityEmail() {
        return charityCharityEmail;
    }

    public void setCharityCharityEmail(CharityDTO charityCharityEmail) {
        this.charityCharityEmail = charityCharityEmail;
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
