package com.first.firstproj.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String Name;
    private String nickName;
    private String Emailids;
    private String Image;
    @Column(length = 500)
    private String Description;
    private String Phone;

    @ManyToOne
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // public contacts() {
    // }

    

    // public contacts(int cid, String name, String nickName, String email, String image, String description, String phone,
    //         user user) {
    //     this.cid = cid;
    //     this.Name = name;
    //     this.nickName = nickName;
    //     this.Emailids = email;
    //     this.Image = image;
    //     this.Description = description;
    //     this.Phone = phone;
    //     this.User = user;
    // }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return Emailids;
    }

    public void setEmail(String Emailidss) {
        Emailids = Emailidss;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "contacts [cid=" + cid + ", Name=" + Name + ", nickName=" + nickName + ", Email=" + Emailids + ", Image="
                + Image + ", Description=" + Description + ", Phone=" + Phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.cid==((contacts)obj).getCid();
    }
    

    
}
