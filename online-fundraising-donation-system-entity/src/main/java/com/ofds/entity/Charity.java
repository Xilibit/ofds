package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
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

@Entity
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
public class Charity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private List<Groups> groupsCollection;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "charityCharityEmail")    
    private List<Cause> causeCollection;

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
    public List<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(List<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public List<Cause> getCauseCollection() {
        return causeCollection;
    }

    public void setCauseCollection(List<Cause> causeCollection) {
        this.causeCollection = causeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (charityEmail != null ? charityEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Charity)) {
            return false;
        }
        Charity other = (Charity) object;
        return !((this.charityEmail == null && other.charityEmail != null)
                || (this.charityEmail != null && !this.charityEmail.equals(other.charityEmail)));
    }

    @Override
    public String toString() {
        return "com.ofds.entity.Charity[ charityEmail=" + charityEmail + " ]";
    }
    
}
