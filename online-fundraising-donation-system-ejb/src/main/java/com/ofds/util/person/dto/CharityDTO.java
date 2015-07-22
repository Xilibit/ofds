package com.ofds.util.person.dto;

import com.ofds.util.person.Person;

import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 * Manage the Charity.
 */
public class CharityDTO implements Person {

    @NotNull
    private String charityEmail;

    @NotNull
    private String charityName;

    @NotNull
    private String charityRegistryName;

    @NotNull
    @Past
    private Date charityDateOfEstablishment;

    @NotNull
    private String charityShortDescription;

    @NotNull
    private String charityPassword;

    @NotNull
    private String charityCountry;

    @NotNull
    private String charityCity;

    @NotNull
    private String charityStreet;

    @NotNull
    private String charityIndex;

    private Collection<GroupsDTO> groupsDTOCollection;
    private Collection<CauseDTO> causeDTOCollection;

    public String getCharityEmail() {
        return charityEmail;
    }

    public void setCharityEmail(String charityEmail) {
        this.charityEmail = charityEmail;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getCharityRegistryName() {
        return charityRegistryName;
    }

    public void setCharityRegistryName(String charityRegistryName) {
        this.charityRegistryName = charityRegistryName;
    }

    public Date getCharityDateOfEstablishment() {
        return charityDateOfEstablishment;
    }

    public void setCharityDateOfEstablishment(Date charityDateOfEstablishment) {
        this.charityDateOfEstablishment = charityDateOfEstablishment;
    }

    public String getCharityShortDescription() {
        return charityShortDescription;
    }

    public void setCharityShortDescription(String charityShortDescription) {
        this.charityShortDescription = charityShortDescription;
    }

    public String getCharityPassword() {
        return charityPassword;
    }

    public void setCharityPassword(String charityPassword) {
        this.charityPassword = charityPassword;
    }

    public String getCharityCountry() {
        return charityCountry;
    }

    public void setCharityCountry(String charityCountry) {
        this.charityCountry = charityCountry;
    }

    public String getCharityCity() {
        return charityCity;
    }

    public void setCharityCity(String charityCity) {
        this.charityCity = charityCity;
    }

    public String getCharityStreet() {
        return charityStreet;
    }

    public void setCharityStreet(String charityStreet) {
        this.charityStreet = charityStreet;
    }

    public String getCharityIndex() {
        return charityIndex;
    }

    public void setCharityIndex(String charityIndex) {
        this.charityIndex = charityIndex;
    }

    public Collection<GroupsDTO> getGroupsDTOCollection() {
        return groupsDTOCollection;
    }

    public void setGroupsDTOCollection(Collection<GroupsDTO> groupsDTOCollection) {
        this.groupsDTOCollection = groupsDTOCollection;
    }

    public Collection<CauseDTO> getCauseDTOCollection() {
        return causeDTOCollection;
    }

    public void setCauseDTOCollection(Collection<CauseDTO> causeDTOCollection) {
        this.causeDTOCollection = causeDTOCollection;
    }

    @Override
    public Person getPerson() {
        return this;
    }
}
