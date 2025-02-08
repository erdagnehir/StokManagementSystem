package com.java.javaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.javaProject.Entity.*;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {
	long count();
}