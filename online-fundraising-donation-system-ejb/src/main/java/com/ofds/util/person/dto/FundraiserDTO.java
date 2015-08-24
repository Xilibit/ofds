package com.ofds.util.person.dto;

import com.ofds.util.person.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * Manage the Fundraiser.
 */
public class FundraiserDTO implements Person, Serializable {

    private static final long serialVersionUID = 8877100666600177727L;

    @NotNull
    private String fundraiserDTOEmail;

    @NotNull
    private String fundraiserDTOFirstName;

    @NotNull
    private String fundraiserDTOLastName;

    @NotNull
    private Date fundraiserDTODateOfBirth;

    @NotNull
    private String fundraiserDTOIsAdmin;

    @NotNull
    private String fundraiserDTOPassword;

    @NotNull
    private String fundraiserDTOCountry;

    @NotNull
    private String fundraiserDTOCity;

    @NotNull
    private String fundraiserDTOStreet;

    @NotNull
    private String fundraiserDTOIndex;

    @NotNull
    private String fundraiserDTOWallet;

    @NotNull
    private Collection<GroupsDTO> groupsDTOCollection;

    private Collection<DonationDTO> donationDTOCollection;
    
    private Collection<ActivityDTO> activityDTOCollection;

    public String getFundraiserDTOEmail() {
        return fundraiserDTOEmail;
    }

    public void setFundraiserDTOEmail(String fundraiserDTOEmail) {
        this.fundraiserDTOEmail = fundraiserDTOEmail;
    }

    public String getFundraiserDTOFirstName() {
        return fundraiserDTOFirstName;
    }

    public void setFundraiserDTOFirstName(String fundraiserDTOFirstName) {
        this.fundraiserDTOFirstName = fundraiserDTOFirstName;
    }

    public String getFundraiserDTOLastName() {
        return fundraiserDTOLastName;
    }

    public void setFundraiserDTOLastName(String fundraiserDTOLastName) {
        this.fundraiserDTOLastName = fundraiserDTOLastName;
    }

    public Date getFundraiserDTODateOfBirth() {
        return fundraiserDTODateOfBirth;
    }

    public void setFundraiserDTODateOfBirth(Date fundraiserDTODateOfBirth) {
        this.fundraiserDTODateOfBirth = fundraiserDTODateOfBirth;
    }

    public String getFundraiserDTOIsAdmin() {
        return fundraiserDTOIsAdmin;
    }

    public void setFundraiserDTOIsAdmin(String fundraiserDTOIsAdmin) {
        this.fundraiserDTOIsAdmin = fundraiserDTOIsAdmin;
    }

    public String getFundraiserDTOPassword() {
        return fundraiserDTOPassword;
    }

    public void setFundraiserDTOPassword(String fundraiserDTOPassword) {
        this.fundraiserDTOPassword = fundraiserDTOPassword;
    }

    public String getFundraiserDTOCountry() {
        return fundraiserDTOCountry;
    }

    public void setFundraiserDTOCountry(String fundraiserDTOCountry) {
        this.fundraiserDTOCountry = fundraiserDTOCountry;
    }

    public String getFundraiserDTOCity() {
        return fundraiserDTOCity;
    }

    public void setFundraiserDTOCity(String fundraiserDTOCity) {
        this.fundraiserDTOCity = fundraiserDTOCity;
    }

    public String getFundraiserDTOStreet() {
        return fundraiserDTOStreet;
    }

    public void setFundraiserDTOStreet(String fundraiserDTOStreet) {
        this.fundraiserDTOStreet = fundraiserDTOStreet;
    }

    public String getFundraiserDTOIndex() {
        return fundraiserDTOIndex;
    }

    public void setFundraiserDTOIndex(String fundraiserDTOIndex) {
        this.fundraiserDTOIndex = fundraiserDTOIndex;
    }

    public String getFundraiserDTOWallet() {
        return fundraiserDTOWallet;
    }

    public void setFundraiserDTOWallet(String fundraiserDTOWallet) {
        this.fundraiserDTOWallet = fundraiserDTOWallet;
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
