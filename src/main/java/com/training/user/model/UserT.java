package com.training.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity(name = "sys_user_t")
public class UserT {

	@Id
	@SequenceGenerator(name = "userid_sequence",sequenceName = "userid_sequence",allocationSize = 1)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "userid_sequence")
	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "first_name",length = 50)
	private String first_name;

	@Column(name = "last_name",length = 50)
	private String last_name;

	@Column(name = "email",length = 50)
	private String email;

	@Column(name = "status", nullable = false)
	private int status;

}
