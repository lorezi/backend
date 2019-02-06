package com.learn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.web.CarController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarAppApplicationTests {
	
	@Autowired
	private CarController carController;

	@Test
	public void contextLoads() {
		assertThat(carController).isNotNull();
	}

}

