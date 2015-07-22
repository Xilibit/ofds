package com.ofds.util.person.dto;

import java.util.List;
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

    private List<ActivityDTO> activityDTOCollection;
    private List<CauseDTO> causeDTOCollection;

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

    public List<ActivityDTO> getActivityDTOCollection() {
        return activityDTOCollection;
    }

    public void setActivityDTOCollection(List<ActivityDTO> activityDTOCollection) {
        this.activityDTOCollection = activityDTOCollection;
    }

    public List<CauseDTO> getCauseDTOCollection() {
        return causeDTOCollection;
    }

    public void setCauseDTOCollection(List<CauseDTO> causeDTOCollection) {
        this.causeDTOCollection = causeDTOCollection;
    }

    public FundraiserDTO getFundraiserFundraiserDTOEmail() {
        return fundraiserFundraiserDTOEmail;
    }

    public void setFundraiserFundraiserDTOEmail(FundraiserDTO fundraiserFundraiserDTOEmail) {
        this.fundraiserFundraiserDTOEmail = fundraiserFundraiserDTOEmail;
    }
}
