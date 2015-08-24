package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cause")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Cause.findAll", query = "SELECT c FROM Cause c"),
    @NamedQuery(name = "Cause.findByIdCAUSE", query = "SELECT c FROM Cause c WHERE c.idCAUSE = :idCAUSE"),
    @NamedQuery(name = "Cause.findByCauseName", query = "SELECT c FROM Cause c WHERE c.causeName = :causeName"),
    @NamedQuery(name = "Cause.findByCauseShortDescription", query = "SELECT c FROM Cause c " +
            "WHERE c.causeShortDescription = :causeShortDescription"),
    @NamedQuery(name = "Cause.findByCauseInsertTs", query = "SELECT c FROM Cause c " +
            "WHERE c.causeInsertTs = :causeInsertTs"),
    @NamedQuery(name = "Cause.findByCauseTerminationDate", query = "SELECT c FROM Cause c " +
            "WHERE c.causeTerminationDate = :causeTerminationDate")})

public class Cause extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 9113123123333124223L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idCAUSE")
    private Integer idCAUSE;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CAUSE_NAME")
    private String causeName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CAUSE_SHORT_DESCRIPTION")
    private String causeShortDescription;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CAUSE_INSERT_TS")
    @Temporal(TemporalType.DATE)
    private Date causeInsertTs;

    @Column(name = "CAUSE_TERMINATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date causeTerminationDate;

    @Column(name = "CAUSE_PERCENTAGE")
    private String causePercentage;

    @JoinTable(name = "cause_has_donation", joinColumns = {
        @JoinColumn(name = "CAUSE_idCAUSE", referencedColumnName = "idCAUSE")}, inverseJoinColumns = {
        @JoinColumn(name = "DONATION_idDONATION", referencedColumnName = "idDONATION")})
    @ManyToMany
    private Collection<Donation> donationCollection;

    @ManyToMany(mappedBy = "causeCollection", cascade = CascadeType.PERSIST)
    private Collection<Activity> activityCollection;

    @JoinColumn(name = "CHARITY_CHARITY_EMAIL", referencedColumnName = "CHARITY_EMAIL")
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private Charity charityCharityEmail;

    public Cause() {
    }

    public Cause(Integer idCAUSE) {
        this.idCAUSE = idCAUSE;
    }

    public Cause(Integer idCAUSE, String causeName, String causeShortDescription, Date causeInsertTs) {
        this.idCAUSE = idCAUSE;
        this.causeName = causeName;
        this.causeShortDescription = causeShortDescription;
        this.causeInsertTs = causeInsertTs;
    }

    public Integer getIdCAUSE() {
        return idCAUSE;
    }

    public void setIdCAUSE(Integer idCAUSE) {
        this.idCAUSE = idCAUSE;
    }

    public String getCauseName() {
        return causeName;
    }

    public void setCauseName(String causeName) {
        this.causeName = causeName;
    }

    public String getCauseShortDescription() {
        return causeShortDescription;
    }

    public void setCauseShortDescription(String causeShortDescription) {
        this.causeShortDescription = causeShortDescription;
    }

    public Date getCauseInsertTs() {
        return causeInsertTs;
    }

    public void setCauseInsertTs(Date causeInsertTs) {
        this.causeInsertTs = causeInsertTs;
    }

    public Date getCauseTerminationDate() {
        return causeTerminationDate;
    }

    public void setCauseTerminationDate(Date causeTerminationDate) {
        this.causeTerminationDate = causeTerminationDate;
    }

    @XmlTransient
    public Collection<Donation> getDonationCollection() {
        return donationCollection;
    }

    public void setDonationCollection(Collection<Donation> donationCollection) {
        this.donationCollection = donationCollection;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    public Charity getCharityCharityEmail() {
        return charityCharityEmail;
    }

    public void setCharityCharityEmail(Charity charityCharityEmail) {
        this.charityCharityEmail = charityCharityEmail;
    }

    public String getCausePercentage() {
        return causePercentage;
    }

    public void setCausePercentage(String causePercentage) {
        this.causePercentage = causePercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cause cause = (Cause) o;

        return getIdCAUSE().equals(cause.getIdCAUSE()) && getCauseName().equals(cause.getCauseName());

    }

    @Override
    public int hashCode() {
        int result = getIdCAUSE().hashCode();
        result = 31 * result + getCauseName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cause{" +
                "idCAUSE=" + idCAUSE +
                ", causeName='" + causeName + '\'' +
                ", causeShortDescription='" + causeShortDescription + '\'' +
                ", causeInsertTs=" + causeInsertTs +
                ", causeTerminationDate=" + causeTerminationDate +
                ", causePercentage='" + causePercentage + '\'' +
                ", donationCollection=" + donationCollection +
                ", activityCollection=" + activityCollection +
                ", charityCharityEmail=" + charityCharityEmail +
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
