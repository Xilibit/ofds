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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "donation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donation.findAll", query = "SELECT d FROM Donation d"),
    @NamedQuery(name = "Donation.findByIdDONATION", query = "SELECT d FROM Donation d " +
            "WHERE d.idDONATION = :idDONATION"),
    @NamedQuery(name = "Donation.findByDonationAmount", query = "SELECT d FROM Donation d " +
            "WHERE d.donationAmount = :donationAmount"),
    @NamedQuery(name = "Donation.findByDonationDate", query = "SELECT d FROM Donation d " +
            "WHERE d.donationDate = :donationDate"),
    @NamedQuery(name = "Donation.findByFundraiserEmail", query = "SELECT d FROM Donation d " +
            "WHERE d.fundraiserFundraiserEmail.fundraiserEmail = :fundraiserEmail")})

public class Donation implements BaseEntity, Serializable {

    private static final long serialVersionUID = 9123123123666624823L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idDONATION")
    private Integer idDONATION;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DONATION_AMOUNT")
    private double donationAmount;

    @Column(name = "DONATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date donationDate;

    @Column(name = "DONATION_IS_ANONYM")
    private Boolean donationIsAnonym;

    @ManyToMany(mappedBy = "donationCollection")
    private Collection<Activity> activityCollection;

    @ManyToMany(mappedBy = "donationCollection")
    private Collection<Cause> causeCollection;

    @JoinColumn(name = "FUNDRAISER_FUNDRAISER_EMAIL", referencedColumnName = "FUNDRAISER_EMAIL")
    @ManyToOne(optional = false)
    private Fundraiser fundraiserFundraiserEmail;

    public Donation() {
    }

    public Donation(Integer idDONATION) {
        this.idDONATION = idDONATION;
    }

    public Donation(Integer idDONATION, double donationAmount) {
        this.idDONATION = idDONATION;
        this.donationAmount = donationAmount;
    }

    public Integer getIdDONATION() {
        return idDONATION;
    }

    public void setIdDONATION(Integer idDONATION) {
        this.idDONATION = idDONATION;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
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

    public Boolean getDonationIsAnonym() {
        return donationIsAnonym;
    }

    public void setDonationIsAnonym(Boolean donationIsAnonym) {
        this.donationIsAnonym = donationIsAnonym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donation donation = (Donation) o;

        return getIdDONATION().equals(donation.getIdDONATION())
                && getFundraiserFundraiserEmail().equals(donation.getFundraiserFundraiserEmail());

    }

    @Override
    public int hashCode() {
        int result = getDonationDate().hashCode();
        result = 31 * result + getDonationDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "idDONATION=" + idDONATION +
                ", donationAmount=" + donationAmount +
                ", donationDate=" + donationDate +
                ", donationIsAnonym=" + donationIsAnonym +
                ", activityCollection=" + activityCollection +
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
