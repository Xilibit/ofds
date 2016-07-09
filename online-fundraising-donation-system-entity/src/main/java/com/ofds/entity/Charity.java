package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@Table(name = "charity")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Charity.findAll", query = "SELECT c FROM Charity c"),
    @NamedQuery(name = "Charity.findByCharityEmail", query = "SELECT c FROM Charity c " +
            "WHERE c.charityEmail = :charityEmail"),
    @NamedQuery(name = "Charity.findByCharityName", query = "SELECT c FROM Charity c " +
            "WHERE c.charityName = :charityName"),
    @NamedQuery(name = "Charity.findByCharityRegistryName", query = "SELECT c FROM Charity c " +
            "WHERE c.charityRegistryName = :charityRegistryName"),
    @NamedQuery(name = "Charity.findByCharityDateOfEstablishment", query = "SELECT c FROM Charity c " +
            "WHERE c.charityDateOfEstablishment = :charityDateOfEstablishment"),
    @NamedQuery(name = "Charity.findByCharityShortDescription", query = "SELECT c FROM Charity c " +
            "WHERE c.charityShortDescription = :charityShortDescription"),
    @NamedQuery(name = "Charity.findByCharityPassword", query = "SELECT c FROM Charity c " +
            "WHERE c.charityPassword = :charityPassword"),
    @NamedQuery(name = "Charity.findByCharityCountry", query = "SELECT c FROM Charity c " +
            "WHERE c.charityCountry = :charityCountry"),
    @NamedQuery(name = "Charity.findByCharityCity", query = "SELECT c FROM Charity c " +
            "WHERE c.charityCity = :charityCity"),
    @NamedQuery(name = "Charity.findByCharityStreet", query = "SELECT c FROM Charity c " +
            "WHERE c.charityStreet = :charityStreet"),
    @NamedQuery(name = "Charity.findByCharityIndex", query = "SELECT c FROM Charity c " +
            "WHERE c.charityIndex = :charityIndex")})

public class Charity implements BaseEntity, Serializable {

    private static final long serialVersionUID = 9155523123123155823L;

    @Id    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CHARITY_EMAIL")
    @XmlAttribute(required=true)
    private String charityEmail;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CHARITY_NAME")
    @XmlElement(required=true)
    private String charityName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CHARITY_REGISTRY_NAME")
    @XmlElement(required=true)
    private String charityRegistryName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CHARITY_DATE_OF_ESTABLISHMENT")
    @Temporal(TemporalType.DATE)
    @XmlElement(required=true)
    private Date charityDateOfEstablishment;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CHARITY_SHORT_DESCRIPTION")
    @XmlElement(required=true)
    private String charityShortDescription;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CHARITY_PASSWORD")
    @XmlElement(required=true)
    private String charityPassword;

    @Size(max = 100)
    @Column(name = "CHARITY_COUNTRY")
    @XmlElement(required=true)
    private String charityCountry;

    @Size(max = 100)
    @Column(name = "CHARITY_CITY")
    @XmlElement(required=true)
    private String charityCity;

    @Size(max = 100)
    @Column(name = "CHARITY_STREET")
    @XmlElement(required=true)
    private String charityStreet;

    @Size(max = 10)
    @Column(name = "CHARITY_INDEX")
    @XmlElement(required=true)
    private String charityIndex;

    @JoinTable(name = "charity_has_groups", joinColumns = {
        @JoinColumn(name = "CHARITY_CHARITY_EMAIL", referencedColumnName = "CHARITY_EMAIL")}, inverseJoinColumns = {
        @JoinColumn(name = "GROUPS_GROUP_ID", referencedColumnName = "GROUP_ID")})
    @ManyToMany
    private Collection<Groups> groupsCollection;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "charityCharityEmail")    
    private Collection<Cause> causeCollection;

    public Charity() {
    }

    public Charity(String charityEmail) {
        this.charityEmail = charityEmail;
    }

    public Charity(String charityEmail, String charityName, String charityRegistryName, Date charityDateOfEstablishment,
                   String charityShortDescription, String charityPassword) {
        this.charityEmail = charityEmail;
        this.charityName = charityName;
        this.charityRegistryName = charityRegistryName;
        this.charityDateOfEstablishment = charityDateOfEstablishment;
        this.charityShortDescription = charityShortDescription;
        this.charityPassword = charityPassword;
    }

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

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Cause> getCauseCollection() {
        return causeCollection;
    }

    public void setCauseCollection(Collection<Cause> causeCollection) {
        this.causeCollection = causeCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Charity charity = (Charity) o;

        return getCharityEmail().equals(charity.getCharityEmail())
                && getCharityName().equals(charity.getCharityName())
                && getCharityRegistryName().equals(charity.getCharityRegistryName());

    }

    @Override
    public int hashCode() {
        int result = getCharityEmail().hashCode();
        result = 31 * result + getCharityName().hashCode();
        result = 31 * result + getCharityRegistryName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Charity{" +
                "charityEmail='" + charityEmail + '\'' +
                ", charityName='" + charityName + '\'' +
                ", charityRegistryName='" + charityRegistryName + '\'' +
                ", charityDateOfEstablishment=" + charityDateOfEstablishment +
                ", charityShortDescription='" + charityShortDescription + '\'' +
                ", charityCountry='" + charityCountry + '\'' +
                ", charityCity='" + charityCity + '\'' +
                ", charityStreet='" + charityStreet + '\'' +
                ", charityIndex='" + charityIndex + '\'' +
                ", groupsCollection=" + groupsCollection +
                ", causeCollection=" + causeCollection +
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
