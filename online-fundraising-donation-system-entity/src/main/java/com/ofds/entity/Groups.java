package com.ofds.entity;

import com.ofds.entity.base.BaseEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "groups")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByGroupId", query = "SELECT g FROM Groups g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groups.findByGroupUserId", query = "SELECT g FROM Groups g " +
            "WHERE g.groupUserId = :groupUserId")})

public class Groups extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GROUP_ID")
    @XmlAttribute(required=true)
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "GROUP_USER_ID")
    @XmlAttribute(required=true)
    private String groupUserId;
    @ManyToMany(mappedBy = "groupsCollection")    
    private Collection<Charity> charityCollection;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<Fundraiser> fundraiserCollection;

    public Groups() {

    }

    public Groups(Integer groupId) {
        this.groupId = groupId;
    }

    public Groups(Integer groupId, String groupUserId) {
        this.groupId = groupId;
        this.groupUserId = groupUserId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(String groupUserId) {
        this.groupUserId = groupUserId;
    }

    @XmlTransient
    public Collection<Charity> getCharityCollection() {
        return charityCollection;
    }

    public void setCharityCollection(Collection<Charity> charityCollection) {
        this.charityCollection = charityCollection;
    }

    @XmlTransient
    public Collection<Fundraiser> getFundraiserCollection() {
        return fundraiserCollection;
    }

    public void setFundraiserCollection(Collection<Fundraiser> fundraiserCollection) {
        this.fundraiserCollection = fundraiserCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Groups groups = (Groups) o;

        return getGroupId().equals(groups.getGroupId())
                && getGroupUserId().equals(groups.getGroupUserId())
                && getCharityCollection().equals(groups.getCharityCollection())
                && getFundraiserCollection().equals(groups.getFundraiserCollection());

    }

    @Override
    public int hashCode() {
        int result = getGroupId().hashCode();
        result = 31 * result + getGroupUserId().hashCode();
        result = 31 * result + getCharityCollection().hashCode();
        result = 31 * result + getFundraiserCollection().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "groupId=" + groupId +
                ", groupUserId='" + groupUserId + '\'' +
                ", charityCollection=" + charityCollection +
                ", fundraiserCollection=" + fundraiserCollection +
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
