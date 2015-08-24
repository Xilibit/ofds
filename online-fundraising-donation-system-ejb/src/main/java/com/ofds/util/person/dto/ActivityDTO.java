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
 * Manage the Activity.
 */
public class ActivityDTO implements Serializable {

    private static final long serialVersionUID = 6654333665566133231L;

    @NotNull
    private Integer activityId;

    @NotNull
    private String activityDTOName;

    @NotNull
    private String activityDTOShortDescription;

    @NotNull
    private Date activityDTOInsertTs;

    @NotNull
    @Future
    private Date activityDTOTerminationDate;

    private Collection<DonationDTO> donationDTOCollection;

    private Collection<CauseDTO> causeDTOCollection;

    @NotNull
    private FundraiserDTO fundraiserFundraiserEmail;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityDTOName() {
        return activityDTOName;
    }

    public void setActivityDTOName(String activityDTOName) {
        this.activityDTOName = activityDTOName;
    }

    public String getActivityDTOShortDescription() {
        return activityDTOShortDescription;
    }

    public void setActivityDTOShortDescription(String activityDTOShortDescription) {
        this.activityDTOShortDescription = activityDTOShortDescription;
    }

    public Date getActivityDTOInsertTs() {
        return activityDTOInsertTs;
    }

    public void setActivityDTOInsertTs(Date activityDTOInsertTs) {
        this.activityDTOInsertTs = activityDTOInsertTs;
    }

    public Date getActivityDTOTerminationDate() {
        return activityDTOTerminationDate;
    }

    public void setActivityDTOTerminationDate(Date activityDTOTerminationDate) {
        this.activityDTOTerminationDate = activityDTOTerminationDate;
    }

    public Collection<DonationDTO> getDonationDTOCollection() {
        return donationDTOCollection;
    }

    public void setDonationDTOCollection(Collection<DonationDTO> donationDTOCollection) {
        this.donationDTOCollection = donationDTOCollection;
    }

    public Collection<CauseDTO> getCauseDTOCollection() {
        return causeDTOCollection;
    }

    public void setCauseDTOCollection(Collection<CauseDTO> causeDTOCollection) {
        this.causeDTOCollection = causeDTOCollection;
    }

    public FundraiserDTO getFundraiserFundraiserEmail() {
        return fundraiserFundraiserEmail;
    }

    public void setFundraiserFundraiserEmail(FundraiserDTO fundraiserFundraiserEmail) {
        this.fundraiserFundraiserEmail = fundraiserFundraiserEmail;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "activityId=" + activityId +
                ", activityDTOName='" + activityDTOName + '\'' +
                ", activityDTOShortDescription='" + activityDTOShortDescription + '\'' +
                ", activityDTOInsertTs=" + activityDTOInsertTs +
                ", activityDTOTerminationDate=" + activityDTOTerminationDate +
                ", donationDTOCollection=" + donationDTOCollection +
                ", causeDTOCollection=" + causeDTOCollection +
                ", fundraiserFundraiserEmail=" + fundraiserFundraiserEmail +
                '}';
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
