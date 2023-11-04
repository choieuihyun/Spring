package project.projectspring.data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// @Entity 이거 무슨 jpa같은데
public class UserProfile {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가(auto-increment) 옵션
    private String id;
    private String name;
    private String phone;
    private String address;
    public UserProfile(String id, String name, String phone, String address) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }



}