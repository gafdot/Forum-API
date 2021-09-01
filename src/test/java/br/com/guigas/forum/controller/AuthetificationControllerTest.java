package br.com.guigas.forum.controller;

import java.net.URI;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import br.com.guigas.forum.model.User;
import br.com.guigas.forum.repository.UserRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
@ActiveProfiles("test")
public class AuthetificationControllerTest {

	@Autowired
	private MockMvc mock;
	@Autowired
	private UserRepository repo;

	@Test
	public void invalidRequestDueToUnregisteredUser() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"student@email.com\",\"password\":\"123456\"}";
		
		mock
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}

	@Test
	@Rollback
	public void return200SuccefulAuthetication() throws Exception {
		
		User user = new User();
		user.setEmail("student@email.com");
		user.setName("Student");
		user.setPassword("$2a$10$ThY1hrNjLXN/uu1.PwHL1OQBs7.tXX.lkEQrpwaslh62fZoo7mZhK");
		
		repo.save(user);
		
		URI uri = new URI("/auth");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("email", "student@email.com");
		jsonObj.put("password", "123456");
		String json = jsonObj.toString();
//		String json = "{\"email\":\"admin@email.com\",\"password\":\"123456\"}";
		
		mock
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

}
