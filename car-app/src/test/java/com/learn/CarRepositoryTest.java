package com.learn;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.domain.Car;
import com.learn.domain.CarRepository;
import com.learn.domain.Owner;
import com.learn.domain.OwnerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Test
	public void saveCar() {
		Owner owner = new Owner("Lawrence", "Onaulogho");
		Car car = new Car("Tesla", "model X", "White", "ABC-124", 2017, 56000, owner);
		
		entityManager.persistAndFlush(owner);
		entityManager.persistAndFlush(car);
		
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteCars() {
		Owner owner = new Owner("Lawrence", "Onaulogho");
		Car car = new Car("Tesla", "model X", "White", "ABC-124", 2017, 56000, owner);
		
		entityManager.persistAndFlush(owner);
		entityManager.persistAndFlush(car);
		
		carRepository.deleteAll();
		assertThat(carRepository.findAll()).isEmpty();
	}

}
