package com.moneylion.usermanagement;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class User {

    private @Id @GeneratedValue Long id;
    private String featureName;
    private String email;
    private Boolean enable; 

  User() {}

  User(String featureName, String email, Boolean enable) {
      this.featureName = featureName;
      this.email = email;
      this.enable = enable;
  }

  public Long getId() {
    return this.id;
  }

  public String getFeatureName() {
    return this.featureName;
  }

  public String getEmail() {
    return this.email;
  }

  public Boolean getEnable() {
    return this.enable;
  }

  
  public void setId(Long id) {
    this.id = id;
  }

  public void setFeatureName(String featureName) {
    this.featureName = featureName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public Boolean valid(){
    if(this.getEmail() == null || this.getFeatureName() == null || this.getEnable() == null){
      return false;
    }
    return true;
  }


  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof User))
      return false;
      User user = (User) o;
    return Objects.equals(this.featureName, user.featureName) 
        && Objects.equals(this.email, user.email)
        && Objects.equals(this.enable, user.enable);
  }

  @Override
  public int hashCode() {
    return Objects.hash( this.featureName, this.email, this.enable);
  }

  @Override
  public String toString() {
    return "User{"+ ", featureName=" + this.featureName + ", email='" + this.email + '\'' + ", enable='" + this.enable + '\'' + '}';
  }
}