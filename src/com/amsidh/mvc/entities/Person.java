package com.amsidh.mvc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Person {

	@Id
	private Integer personId;
	private String personName;

	/*
	 * @AttributeOverrides({ @AttributeOverride(name = "city", column
	 * = @Column(name = "HOME_CITY")),
	 * 
	 * @AttributeOverride(name = "state", column = @Column(name =
	 * "HOME_STATE")),
	 * 
	 * @AttributeOverride(name = "pincode", column = @Column(name =
	 * "HOME_PINCODE")) })
	 * 
	 * @Embedded private Address homeAddress;
	 * 
	 * @AttributeOverrides({ @AttributeOverride(name = "city", column
	 * = @Column(name = "OFFICE_CITY")),
	 * 
	 * @AttributeOverride(name = "state", column = @Column(name =
	 * "OFFICE_STATE")),
	 * 
	 * @AttributeOverride(name = "pincode", column = @Column(name =
	 * "OFFICE_PINCODE")) })
	 * 
	 * @Embedded private Address officeAddress;
	 */

	public Person() {
		super();
	}

	public Person(Integer personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;

	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/*
	 * public Address getHomeAddress() { return homeAddress; }
	 * 
	 * public void setHomeAddress(Address homeAddress) { this.homeAddress =
	 * homeAddress; }
	 * 
	 * public Address getOfficeAddress() { return officeAddress; }
	 * 
	 * public void setOfficeAddress(Address officeAddress) { this.officeAddress
	 * = officeAddress; }
	 */
	@Override
	public String toString() {
		return "Person ID: " + personId + "   Person Name: " + personName;
	}

	@ElementCollection(targetClass=Address.class,fetch=FetchType.EAGER)
	@JoinTable(name="ADDRESS",joinColumns={@JoinColumn(name="PERSONID")})
	@GenericGenerator(name="hilo-genrator", strategy="hilo")
	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator="hilo-genrator", type=@Type(type="long"))
	private List<Address> addresses = new ArrayList<>();

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
