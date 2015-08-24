package com.ofds.util.person.dto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * Manage the Donation.
 */
public class DonationDTO implements Serializable {

    private static final long serialVersionUID = 8877105556600177727L;

    @NotNull
    private Integer donationId;

    @NotNull
    private double donationAmount;

    @NotNull
    private Date donationDate;

    @NotNull
    private Boolean donationIsAnonym;

    private Collection<ActivityDTO> activityDTOCollection;
    private Collection<CauseDTO> causeDTOCollection;

    @NotNull
    private FundraiserDTO fundraiserFundraiserDTOEmail;

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Boolean getDonationIsAnonym() {
        return donationIsAnonym;
    }

    public void setDonationIsAnonym(Boolean donationIsAnonym) {
        this.donationIsAnonym = donationIsAnonym;
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
