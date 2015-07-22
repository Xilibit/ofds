package com.ofds.util.person.dto;

import com.ofds.util.person.Person;

import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * Manage the Fundraiser.
 */
public class FundraiserDTO implements Person {

    @NotNull
    private String fundraiserEmail;

    @NotNull
    private String fundraiserFirstName;

    @NotNull
    private String fundraiserLastName;

    @NotNull
    private Date fundraiserDateOfBirth;

    @NotNull
    private String fundraiserIsAdmin;

    @NotNull
    private String fundraiserPassword;

    @NotNull
    private String fundraiserCountry;

    @NotNull
    private String fundraiserCity;

    @NotNull
    private String fundraiserStreet;

    @NotNull
    private String fundraiserIndex;

    @NotNull
    private String fundraiserWallet;

    @NotNull
    private Collection<GroupsDTO> groupsDTOCollection;

    private Collection<DonationDTO> donationDTOCollection;
    private Collection<ActivityDTO> activityDTOCollection;

    public String getFundraiserEmail() {
        return fundraiserEmail;
    }

    public void setFundraiserEmail(String fundraiserEmail) {
        this.fundraiserEmail = fundraiserEmail;
    }

    public String getFundraiserFirstName() {
        return fundraiserFirstName;
    }

    public void setFundraiserFirstName(String fundraiserFirstName) {
        this.fundraiserFirstName = fundraiserFirstName;
    }

    public String getFundraiserLastName() {
        return fundraiserLastName;
    }

    public void setFundraiserLastName(String fundraiserLastName) {
        this.fundraiserLastName = fundraiserLastName;
    }

    public Date getFundraiserDateOfBirth() {
        return fundraiserDateOfBirth;
    }

    public void setFundraiserDateOfBirth(Date fundraiserDateOfBirth) {
        this.fundraiserDateOfBirth = fundraiserDateOfBirth;
    }

    public String getFundraiserIsAdmin() {
        return fundraiserIsAdmin;
    }

    public void setFundraiserIsAdmin(String fundraiserIsAdmin) {
        this.fundraiserIsAdmin = fundraiserIsAdmin;
    }

    public String getFundraiserPassword() {
        return fundraiserPassword;
    }

    public void setFundraiserPassword(String fundraiserPassword) {
        this.fundraiserPassword = fundraiserPassword;
    }

    public String getFundraiserCountry() {
        return fundraiserCountry;
    }

    public void setFundraiserCountry(String fundraiserCountry) {
        this.fundraiserCountry = fundraiserCountry;
    }

    public String getFundraiserCity() {
        return fundraiserCity;
    }

    public void setFundraiserCity(String fundraiserCity) {
        this.fundraiserCity = fundraiserCity;
    }

    public String getFundraiserStreet() {
        return fundraiserStreet;
    }

    public void setFundraiserStreet(String fundraiserStreet) {
        this.fundraiserStreet = fundraiserStreet;
    }

    public String getFundraiserIndex() {
        return fundraiserIndex;
    }

    public void setFundraiserIndex(String fundraiserIndex) {
        this.fundraiserIndex = fundraiserIndex;
    }

    public String getFundraiserWallet() {
        return fundraiserWallet;
    }

    public void setFundraiserWallet(String fundraiserWallet) {
        this.fundraiserWallet = fundraiserWallet;
    }

    public Collection<GroupsDTO> getGroupsDTOCollection() {
        return groupsDTOCollection;
    }

    public void setGroupsDTOCollection(Collection<GroupsDTO> groupsDTOCollection) {
        this.groupsDTOCollection = groupsDTOCollection;
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

    @Override
    public Person getPerson() {
        return this;
    }
}
