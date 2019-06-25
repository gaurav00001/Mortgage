package com.ing.mortgage.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="Customer")
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long customerId;
    private String loginId;
    
    private String password;
    
    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    private Set<Account> account;
	

}
