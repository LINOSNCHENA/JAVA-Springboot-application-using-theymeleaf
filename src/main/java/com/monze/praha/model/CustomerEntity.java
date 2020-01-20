package com.monze.praha.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD

// HIBERNATE STAFFS!
@Entity
@Table(name="pemba1")
public class CustomerEntity {
    @Id
    //  @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY)
=======
// HIBERNATE STAFFS!
@Entity
@Table(name="partx")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY)
>>>>>>> ef2fb1bad39714d1526eafd537bff11cf94edd8b
    private Long id;    
    @Column(name="first_name")
    private String firstName;    
    @Column(name="last_name", nullable=false, length=60)
    private String lastName;    
    @Column(name="email", nullable=false, length=60)
    private String email;
<<<<<<< HEAD
    	    
=======
    
	    
>>>>>>> ef2fb1bad39714d1526eafd537bff11cf94edd8b
    public Long getId() 			{return id;	   }
	public void setId(Long id)	    {this.id = id; }

	public String getFirstName() 				{return firstName;			 }
	public void setFirstName(String firstName)  {this.firstName = firstName; }

	public String getLastName() 			 {	return lastName;	      }
	public void setLastName(String lastName) {	this.lastName = lastName; }

	public String getEmail() 				 {	return email;		}
	public void setEmail(String email)		 {	this.email = email;	}
}