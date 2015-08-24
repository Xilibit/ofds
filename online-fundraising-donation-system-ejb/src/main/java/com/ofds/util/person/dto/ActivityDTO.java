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
    private String activityName;

    @NotNull
    private String activityShortDescription;

    @NotNull
    private Date activityInsertTs;

    @NotNull
    @Future
    private Date activityTerminationDate;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityShortDescription() {
        return activityShortDescription;
    }

    public void setActivityShortDescription(String activityShortDescription) {
        this.activityShortDescription = activityShortDescription;
    }

    public Date getActivityInsertTs() {
        return activityInsertTs;
    }

    public void setActivityInsertTs(Date activityInsertTs) {
        this.activityInsertTs = activityInsertTs;
    }

    public Date getActivityTerminationDate() {
        return activityTerminationDate;
    }

    public void setActivityTerminationDate(Date activityTerminationDate) {
        this.activityTerminationDate = activityTerminationDate;
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
                ", activityName='" + activityName + '\'' +
                ", activityShortDescription='" + activityShortDescription + '\'' +
                ", activityInsertTs=" + activityInsertTs +
                ", activityTerminationDate=" + activityTerminationDate +
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
