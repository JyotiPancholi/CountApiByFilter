package com.filter.count_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filter.count_api.entity.ApiCounterEntity;

@Repository
public interface ApiCounterRepository extends JpaRepository<ApiCounterEntity, Integer>{
	
public ApiCounterEntity findByApiName(String name);
}
