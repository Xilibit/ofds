package com.ofds.util.person.dto;

import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * Manage the Donation.
 */
public class DonationDTO {

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
}
