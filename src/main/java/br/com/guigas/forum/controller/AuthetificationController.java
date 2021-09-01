package br.com.guigas.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guigas.forum.controller.dto.TokenDto;
import br.com.guigas.forum.controller.form.LoginForm;
import br.com.guigas.forum.service.TokenService;

@RestController
@RequestMapping("/auth")
@Profile(value={"prod", "test"})
public class AuthetificationController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken objectToBeAutheticated = form.convert();
		try {
			// calls AutheticationService and throws an exception if the authentication
			// fails
			Authentication authenticatedUser = authManager.authenticate(objectToBeAutheticated);
			String token = tokenService.generateToken(authenticatedUser);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}
}
