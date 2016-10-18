package com.nykko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes=MycustommoduleApplication.class)
@SpringBootTest
@WebAppConfiguration
public class MycustommoduleApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Test
	public void contextLoads() {

	}

}
