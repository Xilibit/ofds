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

    @NotNull
    private Integer causeId;

    @NotNull
    private String causeName;

    @NotNull
    private String causeShortDescription;

    @NotNull
    private Date causeInsertTs;

    @NotNull
    @Future
    private Date causeTerminationDate;

    @NotNull
    private String causePercentage;
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

    public String getCauseName() {
        return causeName;
    }

    public void setCauseName(String causeName) {
        this.causeName = causeName;
    }

    public String getCauseShortDescription() {
        return causeShortDescription;
    }

    public void setCauseShortDescription(String causeShortDescription) {
        this.causeShortDescription = causeShortDescription;
    }

    public Date getCauseInsertTs() {
        return causeInsertTs;
    }

    public void setCauseInsertTs(Date causeInsertTs) {
        this.causeInsertTs = causeInsertTs;
    }

    public Date getCauseTerminationDate() {
        return causeTerminationDate;
    }

    public void setCauseTerminationDate(Date causeTerminationDate) {
        this.causeTerminationDate = causeTerminationDate;
    }

    public String getCausePercentage() {
        return causePercentage;
    }

    public void setCausePercentage(String causePercentage) {
        this.causePercentage = causePercentage;
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
