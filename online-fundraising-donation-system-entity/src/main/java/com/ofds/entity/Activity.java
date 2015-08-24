package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
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

public class Activity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 9177123123133124777L;

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
    private Collection<Donation> donationCollection;

    @JoinTable(name = "activity_has_cause", joinColumns = {
        @JoinColumn(name = "ACTIVITY_idACTIVITY", referencedColumnName = "idACTIVITY")}, inverseJoinColumns = {
        @JoinColumn(name = "CAUSE_idCAUSE", referencedColumnName = "idCAUSE")})
    @ManyToMany
    private Collection<Cause> causeCollection;

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
    public Collection<Donation> getDonationCollection() {
        return donationCollection;
    }

    public void setDonationCollection(Collection<Donation> donationCollection) {
        this.donationCollection = donationCollection;
    }

    @XmlTransient
    public Collection<Cause> getCauseCollection() {
        return causeCollection;
    }

    public void setCauseCollection(Collection<Cause> causeCollection) {
        this.causeCollection = causeCollection;
    }

    public Fundraiser getFundraiserFundraiserEmail() {
        return fundraiserFundraiserEmail;
    }

    public void setFundraiserFundraiserEmail(Fundraiser fundraiserFundraiserEmail) {
        this.fundraiserFundraiserEmail = fundraiserFundraiserEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        return getIdACTIVITY().equals(activity.getIdACTIVITY())
                && getActivityName().equals(activity.getActivityName());

    }

    @Override
    public int hashCode() {
        int result = getIdACTIVITY().hashCode();
        result = 31 * result + getActivityName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "idACTIVITY=" + idACTIVITY +
                ", activityName='" + activityName + '\'' +
                ", activityShortDescription='" + activityShortDescription + '\'' +
                ", activityInsertTs=" + activityInsertTs +
                ", activityTerminationDate=" + activityTerminationDate +
                ", donationCollection=" + donationCollection +
                ", causeCollection=" + causeCollection +
                ", fundraiserFundraiserEmail=" + fundraiserFundraiserEmail +
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
