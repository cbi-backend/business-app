package com.business.card.usercapability.model;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document("user")
public class User {
    @Id
    private String id; // auto generated 
    private Name name; // editable - {"firstName":"Jhon","lastName":"Smith"}
    private Phone phone; // editable - {"countryCode":"+91","number":"9876543210"}
    private Address address; // editable - { "addressLine1":"123/45", "addressLine2":"ABC Streat, DEF", "city":"HIJK", "state":"LMNOP", "country":"QRSTUV", "postalCode":"600000" }
    private Social social; // editable - {"email":"abc@def.hij"}
    private Date dateOfBirth; // editable
    private String gender; // editable
    private String image; // editable
    private Set<Role> roles; // auto generated - USER
    private String status;  // auto generated 
    transient private String password; // READ ONLY & ENCRIPTED 
    private Date createdAt; // auto generated 
    private Date updatedAt; // auto generated 
    private String userId; // auto generated 
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Social getSocial() {
        return social;
    }
    public void setSocial(Social social) {
        this.social = social;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @JsonIgnore
	@JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", social=" + social
                + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", image=" + image + ", roles=" + roles
                + ", status=" + status + ", password=" + password + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + ", userId=" + userId + "]";
    }
    public User() {
    }
    public User(String id, Name name, Phone phone, Address address, Social social, Date dateOfBirth, String gender,
            String image, Set<Role> roles, String status, String password, Date createdAt, Date updatedAt,
            String userId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.social = social;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.image = image;
        this.roles = roles;
        this.status = status;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }
    
}
