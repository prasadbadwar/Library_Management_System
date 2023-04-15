package com.hfdc.lms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfdc.lms.service.IUserService;

@SpringBootTest
class LibraryManagementSystemApplicationTests {

	@Autowired
	IUserService userservice;
	@Test
	void contextLoads() {
	}

	@Test
	void User() {
		
	}
}
