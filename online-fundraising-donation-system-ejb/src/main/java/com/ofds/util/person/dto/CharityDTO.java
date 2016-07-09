package com.ofds.util.person.dto;

import com.ofds.util.person.Person;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Manage the Charity.
 */
public class CharityDTO implements Person, Serializable {

    private static final long serialVersionUID = 8277100222200122227L;

    @NotNull
    private String charityDTOEmail;

    @NotNull
    private String charityDTOName;

    @NotNull
    private String charityDTORegistryName;

    @NotNull
    @Past
    private Date charityDTODateOfEstablishment;

    @NotNull
    private String charityDTOShortDescription;

    @NotNull
    private String charityDTOPassword;

    @NotNull
    private String charityDTOCountry;

    @NotNull
    private String charityDTOCity;

    @NotNull
    private String charityDTOStreet;

    @NotNull
    private String charityDTOIndex;

    private Collection<GroupsDTO> groupsDTOCollection;
    
    private Collection<CauseDTO> causeDTOCollection;

    public String getCharityDTOEmail() {
        return charityDTOEmail;
    }

    public void setCharityDTOEmail(String charityDTOEmail) {
        this.charityDTOEmail = charityDTOEmail;
    }

    public String getCharityDTOName() {
        return charityDTOName;
    }

    public void setCharityDTOName(String charityDTOName) {
        this.charityDTOName = charityDTOName;
    }

    public String getCharityDTORegistryName() {
        return charityDTORegistryName;
    }

    public void setCharityDTORegistryName(String charityDTORegistryName) {
        this.charityDTORegistryName = charityDTORegistryName;
    }

    public Date getCharityDTODateOfEstablishment() {
        return charityDTODateOfEstablishment;
    }

    public void setCharityDTODateOfEstablishment(Date charityDTODateOfEstablishment) {
        this.charityDTODateOfEstablishment = charityDTODateOfEstablishment;
    }

    public String getCharityDTOShortDescription() {
        return charityDTOShortDescription;
    }

    public void setCharityDTOShortDescription(String charityDTOShortDescription) {
        this.charityDTOShortDescription = charityDTOShortDescription;
    }

    public String getCharityDTOPassword() {
        return charityDTOPassword;
    }

    public void setCharityDTOPassword(String charityDTOPassword) {
        this.charityDTOPassword = charityDTOPassword;
    }

    public String getCharityDTOCountry() {
        return charityDTOCountry;
    }

    public void setCharityDTOCountry(String charityDTOCountry) {
        this.charityDTOCountry = charityDTOCountry;
    }

    public String getCharityDTOCity() {
        return charityDTOCity;
    }

    public void setCharityDTOCity(String charityDTOCity) {
        this.charityDTOCity = charityDTOCity;
    }

    public String getCharityDTOStreet() {
        return charityDTOStreet;
    }

    public void setCharityDTOStreet(String charityDTOStreet) {
        this.charityDTOStreet = charityDTOStreet;
    }

    public String getCharityDTOIndex() {
        return charityDTOIndex;
    }

    public void setCharityDTOIndex(String charityDTOIndex) {
        this.charityDTOIndex = charityDTOIndex;
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
