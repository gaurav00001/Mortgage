package com.ing.mortgage.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="Mortgage")
public class Mortgage {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mortgageId;
    private String operationType;
    private Long propertyCost;
    private Long deposit;
    private String employmentStatus;
    private String occupation;
    private String contractType;
    private Date jobStartDate;
    private String title;
    private String firstName;
    private String middleName;
    private String surname;
    private Date dob;
    private int phoneNumber;
    private String email;
    
   

}
