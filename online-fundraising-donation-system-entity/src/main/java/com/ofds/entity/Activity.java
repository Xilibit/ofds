package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findByIdACTIVITY", query = "SELECT a FROM Activity a " +
            "WHERE a.idACTIVITY = :idACTIVITY"),
    @NamedQuery(name = "Activity.findByActivityName", query = "SELECT a FROM Activity a " +
            "WHERE a.activityName = :activityName"),
    @NamedQuery(name = "Activity.findByActivityShortDescription", query = "SELECT a FROM Activity a " +
            "WHERE a.activityShortDescription = :activityShortDescription"),
    @NamedQuery(name = "Activity.findByActivityInsertTs", query = "SELECT a FROM Activity a " +
            "WHERE a.activityInsertTs = :activityInsertTs"),
    @NamedQuery(name = "Activity.findByActivityTerminationDate", query = "SELECT a FROM Activity a " +
            "WHERE a.activityTerminationDate = :activityTerminationDate")})

public class Activity extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idACTIVITY")
    private Integer idACTIVITY;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ACTIVITY_NAME")
    private String activityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ACTIVITY_SHORT_DESCRIPTION")
    private String activityShortDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY_INSERT_TS")
    @Temporal(TemporalType.DATE)
    private Date activityInsertTs;
    @Column(name = "ACTIVITY_TERMINATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date activityTerminationDate;
    @JoinTable(name = "activity_has_donation", joinColumns = {
        @JoinColumn(name = "ACTIVITY_idACTIVITY", referencedColumnName = "idACTIVITY")}, inverseJoinColumns = {
        @JoinColumn(name = "DONATION_idDONATION", referencedColumnName = "idDONATION")})
    @ManyToMany
    private List<Donation> donationCollection;
    @JoinTable(name = "activity_has_cause", joinColumns = {
        @JoinColumn(name = "ACTIVITY_idACTIVITY", referencedColumnName = "idACTIVITY")}, inverseJoinColumns = {
        @JoinColumn(name = "CAUSE_idCAUSE", referencedColumnName = "idCAUSE")})
    @ManyToMany
    private List<Cause> causeCollection;
    @JoinColumn(name = "FUNDRAISER_FUNDRAISER_EMAIL", referencedColumnName = "FUNDRAISER_EMAIL")
    @ManyToOne(optional = false)
    private Fundraiser fundraiserFundraiserEmail;

    public Activity() {
    }

    public Activity(Integer idACTIVITY) {
        this.idACTIVITY = idACTIVITY;
    }

    public Activity(Integer idACTIVITY, String activityName, String activityShortDescription, Date activityInsertTs) {
        this.idACTIVITY = idACTIVITY;
        this.activityName = activityName;
        this.activityShortDescription = activityShortDescription;
        this.activityInsertTs = activityInsertTs;
    }

    public Integer getIdACTIVITY() {
        return idACTIVITY;
    }

    public void setIdACTIVITY(Integer idACTIVITY) {
        this.idACTIVITY = idACTIVITY;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityShortDescription() {
        return activityShortDescription;
    }

    public void setActivityShortDescription(String activityShortDescription) {
        this.activityShortDescription = activityShortDescription;
    }

    public Date getActivityInsertTs() {
        return activityInsertTs;
    }

    public void setActivityInsertTs(Date activityInsertTs) {
        this.activityInsertTs = activityInsertTs;
    }

    public Date getActivityTerminationDate() {
        return activityTerminationDate;
    }

    public void setActivityTerminationDate(Date activityTerminationDate) {
        this.activityTerminationDate = activityTerminationDate;
    }

    @XmlTransient
    public List<Donation> getDonationCollection() {
        return donationCollection;
    }

    public void setDonationCollection(List<Donation> donationCollection) {
        this.donationCollection = donationCollection;
    }

    @XmlTransient
    public List<Cause> getCauseCollection() {
        return causeCollection;
    }

    public void setCauseCollection(List<Cause> causeCollection) {
        this.causeCollection = causeCollection;
    }

    public Fundraiser getFundraiserFundraiserEmail() {
        return fundraiserFundraiserEmail;
    }

    public void setFundraiserFundraiserEmail(Fundraiser fundraiserFundraiserEmail) {
        this.fundraiserFundraiserEmail = fundraiserFundraiserEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idACTIVITY != null ? idACTIVITY.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        return !((this.idACTIVITY == null && other.idACTIVITY != null)
                || (this.idACTIVITY != null && !this.idACTIVITY.equals(other.idACTIVITY)));
    }

    @Override
    public String toString() {
        return "com.ofds.entity.Activity[ idACTIVITY=" + idACTIVITY + " ]";
    }
    
}
