package com.qd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.qd.dao.RegisterDao;
import com.qd.model.RegisterUser;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RegisterDaoTest {
	
	@Autowired
	private RegisterDao regdao;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateRegisterUser()
	{
		RegisterUser register = new RegisterUser ();
		
		register.setEmail("karan@gmail.com");
		register.setPassword("raja123");
		register.setFirtName("karan");
		register.setLastName("Rajadurai");
		
		RegisterUser savedRegister=regdao.save(register);
		
		RegisterUser exitRegister = entityManager.find(RegisterUser.class, savedRegister.getId());
		
		assertThat(exitRegister.getEmail()).isEqualTo(register.getEmail());
		
	}
	
	/*
	@Test
	public void testFindRegisterByEmail()
	{
		String email = "ragul@gmail.com";
		
		 RegisterUser register = regdao.findByEmail(email);
		 assertThat(register).isNotNull();
		
	}*/
}
