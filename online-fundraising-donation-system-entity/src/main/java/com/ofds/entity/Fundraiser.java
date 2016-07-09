package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Access(AccessType.FIELD)
@Table(name = "fundraiser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fundraiser.findAll", query = "SELECT f FROM Fundraiser f"),
    @NamedQuery(name = "Fundraiser.findByFundraiserEmail", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserEmail = :fundraiserEmail"),
    @NamedQuery(name = "Fundraiser.findByFundraiserFirstName", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserFirstName = :fundraiserFirstName"),
    @NamedQuery(name = "Fundraiser.findByFundraiserLastName", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserLastName = :fundraiserLastName"),
    @NamedQuery(name = "Fundraiser.findByFundraiserDateOfBirth", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserDateOfBirth = :fundraiserDateOfBirth"),
    @NamedQuery(name = "Fundraiser.findByFundraiserIsAdmin", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserIsAdmin = :fundraiserIsAdmin"),
    @NamedQuery(name = "Fundraiser.findByFundraiserPassword", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserPassword = :fundraiserPassword"),
    @NamedQuery(name = "Fundraiser.findByFundraiserCountry", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserCountry = :fundraiserCountry"),
    @NamedQuery(name = "Fundraiser.findByFundraiserCity", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserCity = :fundraiserCity"),
    @NamedQuery(name = "Fundraiser.findByFundraiserStreet", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserStreet = :fundraiserStreet"),
    @NamedQuery(name = "Fundraiser.findByFundraiserIndex", query = "SELECT f FROM Fundraiser f " +
            "WHERE f.fundraiserIndex = :fundraiserIndex")})

public class Fundraiser implements BaseEntity, Serializable {

    private static final long serialVersionUID = 9123123123123124823L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FUNDRAISER_EMAIL")
    private String fundraiserEmail;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FUNDRAISER_FIRST_NAME")
    private String fundraiserFirstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FUNDRAISER_LAST_NAME")
    private String fundraiserLastName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNDRAISER_DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date fundraiserDateOfBirth;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNDRAISER_IS_ADMIN")
    private boolean fundraiserIsAdmin;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FUNDRAISER_PASSWORD")
    private String fundraiserPassword;

    @Size(max = 100)
    @Column(name = "FUNDRAISER_COUNTRY")
    private String fundraiserCountry;

    @Size(max = 100)
    @Column(name = "FUNDRAISER_CITY")
    private String fundraiserCity;

    @Size(max = 100)
    @Column(name = "FUNDRAISER_STREET")
    private String fundraiserStreet;

    @Size(max = 10)
    @Column(name = "FUNDRAISER_INDEX")
    private String fundraiserIndex;

    @Column(name = "FUNDRAISER_WALLET")
    private Double fundraiserWallet;

    @JoinTable(name = "fundraiser_has_groups", joinColumns = {
        @JoinColumn(name = "FUNDRAISER_FUNDRAISER_EMAIL", referencedColumnName = "FUNDRAISER_EMAIL")},
            inverseJoinColumns = {
        @JoinColumn(name = "GROUPS_GROUP_ID", referencedColumnName = "GROUP_ID")})
    @ManyToMany
    private Collection<Groups> groupsCollection;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fundraiserFundraiserEmail")
    private Collection<Donation> fundraisersDonationCollection;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fundraiserFundraiserEmail")
    private Collection<Activity> fundraisersActivityCollection;

    public Fundraiser() {
    }

    public Fundraiser(String fundraiserEmail) {
        this.fundraiserEmail = fundraiserEmail;
    }

    public Fundraiser(String fundraiserEmail, String fundraiserFirstName, String fundraiserLastName,
                      Date fundraiserDateOfBirth, boolean fundraiserIsAdmin, String fundraiserPassword) {
        this.fundraiserEmail = fundraiserEmail;
        this.fundraiserFirstName = fundraiserFirstName;
        this.fundraiserLastName = fundraiserLastName;
        this.fundraiserDateOfBirth = fundraiserDateOfBirth;
        this.fundraiserIsAdmin = fundraiserIsAdmin;
        this.fundraiserPassword = fundraiserPassword;
    }

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

    public boolean getFundraiserIsAdmin() {
        return fundraiserIsAdmin;
    }

    public void setFundraiserIsAdmin(boolean fundraiserIsAdmin) {
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

    public Double getFundraiserWallet() {
        return fundraiserWallet;
    }

    public void setFundraiserWallet(Double fundraiserWallet) {
        this.fundraiserWallet = fundraiserWallet;
    }    
    
    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Donation> getFundraisersDonationCollection() {
        return fundraisersDonationCollection;
    }

    public void setFundraisersDonationCollection(Collection<Donation> donationCollection) {
        this.fundraisersDonationCollection = donationCollection;
    }

    @XmlTransient
    public Collection<Activity> getFundraisersActivityCollection() {
        return fundraisersActivityCollection;
    }

    public void setFundraisersActivityCollection(Collection<Activity> activityCollection) {
        this.fundraisersActivityCollection = activityCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Fundraiser that = (Fundraiser) o;

        return getFundraiserEmail().equals(that.getFundraiserEmail())
                && !(getFundraiserFirstName() != null ? !getFundraiserFirstName().equals(that.getFundraiserFirstName())
                : that.getFundraiserFirstName() != null);
    }

    @Override
    public int hashCode() {
        int result = getFundraiserEmail().hashCode();
        result = 31 * result + (getFundraiserFirstName() != null ? getFundraiserFirstName().hashCode() : 0);
        result = 31 * result + (getFundraiserLastName() != null ? getFundraiserLastName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fundraiser{" +
                "fundraiserEmail='" + fundraiserEmail + '\'' +
                ", fundraiserFirstName='" + fundraiserFirstName + '\'' +
                ", fundraiserLastName='" + fundraiserLastName + '\'' +
                ", fundraiserDateOfBirth=" + fundraiserDateOfBirth +
                ", fundraiserIsAdmin=" + fundraiserIsAdmin +
                ", fundraiserCountry='" + fundraiserCountry + '\'' +
                ", fundraiserCity='" + fundraiserCity + '\'' +
                ", fundraiserStreet='" + fundraiserStreet + '\'' +
                ", fundraiserIndex='" + fundraiserIndex + '\'' +
                ", fundraiserWallet=" + fundraiserWallet +
                ", groupsCollection=" + groupsCollection +
                ", donationCollection=" + fundraisersDonationCollection +
                ", activityCollection=" + fundraisersActivityCollection +
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
