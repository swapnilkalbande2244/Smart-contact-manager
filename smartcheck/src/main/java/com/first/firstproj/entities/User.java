package com.first.firstproj.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.GeneratedType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.NoArgsConstructor;

@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Name;
    public String email;
    private String Password;
    private String image;
    @Column(length = 500)
    private String about;
    private String role;
    private String enabled;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user", orphanRemoval = true)
    private List<contacts> list = new ArrayList<>();



    public User() {
    }


    


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }


    public String getemail() {
        return email;
    }


    public void setemail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return Password;
    }


    public void setPassword(String password) {
        Password = password;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public String getAbout() {
        return about;
    }


    public void setAbout(String about) {
        this.about = about;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public String getEnabled() {
        return enabled;
    }


    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public List<contacts> getcontacts() {
        return list;
    }


    public void setcontacts(List<contacts> list) {
        this.list = list;
    }


    


    public List<contacts> getList() {
        return list;
    }
    public void setList(List<contacts> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "user [id=" + id + ", name=" + Name + ", email=" + email + ", Password=" + Password + ", image=" + image
                + ", about=" + about + ", role=" + role + ", enabled=" + enabled + ", list=" + list + "]";
    }


    

}
