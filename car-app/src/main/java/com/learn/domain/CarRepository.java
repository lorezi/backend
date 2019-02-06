package com.learn.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Long> {
	
//	// Fetch cars by brand
//	List<Car> findByBrand(@Param("brand") String brand);
//	
//	// Fetch cars by color
//	List<Car> findByColor(@Param("color") String color);
//	
//	// Fetch cars by brand and sort by year
//	List<Car> findByBrandOrderByYearAsc(String brand);
	
	// Using a query annotation
//	@Query("select c from Car c where c.brand=?1")
//	List<Car> findByBrand(String brand);
	
	// Fetch cars by brand using SQL
//	@Query("select c from Car c where c.brand like %?1")
//	List<Car> findByBrandEndsWith(String brand);

}
