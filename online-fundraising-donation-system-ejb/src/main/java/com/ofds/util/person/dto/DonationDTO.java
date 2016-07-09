package com.ofds.util.person.dto;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Manage the Donation.
 */
public class DonationDTO implements Serializable {

    private static final long serialVersionUID = 8877105556600177727L;

    @NotNull
    private Integer donationDTOId;

    @NotNull
    private double donationDTOAmount;

    @NotNull
    private Date donationDTODate;

    @NotNull
    private Boolean donationDTOIsAnonym;

    private Collection<ActivityDTO> activityDTOCollection;
    
    private Collection<CauseDTO> causeDTOCollection;

    @NotNull
    private FundraiserDTO fundraiserFundraiserDTOEmail;

    public Integer getDonationDTOId() {
        return donationDTOId;
    }

    public void setDonationDTOId(Integer donationDTOId) {
        this.donationDTOId = donationDTOId;
    }

    public double getDonationDTOAmount() {
        return donationDTOAmount;
    }

    public void setDonationDTOAmount(double donationDTOAmount) {
        this.donationDTOAmount = donationDTOAmount;
    }

    public Date getDonationDTODate() {
        return donationDTODate;
    }

    public void setDonationDTODate(Date donationDTODate) {
        this.donationDTODate = donationDTODate;
    }

    public Boolean getDonationDTOIsAnonym() {
        return donationDTOIsAnonym;
    }

    public void setDonationDTOIsAnonym(Boolean donationDTOIsAnonym) {
        this.donationDTOIsAnonym = donationDTOIsAnonym;
    }

    public Collection<ActivityDTO> getActivityDTOCollection() {
        return activityDTOCollection;
    }

    public void setActivityDTOCollection(Collection<ActivityDTO> activityDTOCollection) {
        this.activityDTOCollection = activityDTOCollection;
    }

    public Collection<CauseDTO> getCauseDTOCollection() {
        return causeDTOCollection;
    }

    public void setCauseDTOCollection(Collection<CauseDTO> causeDTOCollection) {
        this.causeDTOCollection = causeDTOCollection;
    }

    public FundraiserDTO getFundraiserFundraiserDTOEmail() {
        return fundraiserFundraiserDTOEmail;
    }

    public void setFundraiserFundraiserDTOEmail(FundraiserDTO fundraiserFundraiserDTOEmail) {
        this.fundraiserFundraiserDTOEmail = fundraiserFundraiserDTOEmail;
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
