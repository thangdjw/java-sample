package user.model;


import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name =  "birth_day")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date birthDay;

    @Column(name = "location")
    private String location;

    @Column(name = "language", length = 2)
    private String language;

    @Column(name = "_is_active")
    private boolean isActive = true;

    @Column(name = "_trusty_score")
    private float trustyScore = 1;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {

        this.birthDay = birthDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public float getTrustyScore() {
        return trustyScore;
    }

    public void setTrustyScore(float trustyScore) {
        this.trustyScore = trustyScore;
    }

}
