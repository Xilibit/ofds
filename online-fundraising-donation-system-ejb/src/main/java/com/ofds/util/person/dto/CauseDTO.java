package com.ofds.util.person.dto;

import java.util.List;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Future;

/**
 * Manage the Cause.
 */
public class CauseDTO {

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
    private List<DonationDTO> donationDTOCollection;
    private List<ActivityDTO> activityDTOCollection;

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

    public List<DonationDTO> getDonationDTOCollection() {
        return donationDTOCollection;
    }

    public void setDonationDTOCollection(List<DonationDTO> donationDTOCollection) {
        this.donationDTOCollection = donationDTOCollection;
    }

    public List<ActivityDTO> getActivityDTOCollection() {
        return activityDTOCollection;
    }

    public void setActivityDTOCollection(List<ActivityDTO> activityDTOCollection) {
        this.activityDTOCollection = activityDTOCollection;
    }

    public CharityDTO getCharityCharityEmail() {
        return charityCharityEmail;
    }

    public void setCharityCharityEmail(CharityDTO charityCharityEmail) {
        this.charityCharityEmail = charityCharityEmail;
    }
}
