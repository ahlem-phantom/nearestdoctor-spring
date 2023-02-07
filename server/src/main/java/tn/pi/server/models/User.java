package tn.pi.server.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Size;

 enum Gender {
 Female, Male, None
 }

 enum Status {
    Active, Pending, Inactive
 }

 enum Role {
   Doctor, Patient, Admin
 }

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    @Size(min = 8, message = "Minimum password length: 8 characters")
    @Column(length = 65555)
    private String password;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Enumerated(EnumType.STRING)
    private Gender gender; 
    private String phone;
    private String country;
    private String state;
    private String street;
    private String zip;
    @Column(name = "createdat", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdat;
    @Enumerated(EnumType.STRING)
    private Status status; 
    @Enumerated(EnumType.STRING)
    private Role role ;
    @Column(length = 65555)
    private String confirmationCode;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  	@JsonBackReference
    @ToString.Exclude
	  private Set<Chat> chat;
}
