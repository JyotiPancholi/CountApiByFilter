package com.filter.count_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "FilterCounter")
public class ApiCounterEntity {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true)
	private String apiName;
	
	private int count ;

}
