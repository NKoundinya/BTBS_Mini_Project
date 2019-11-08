package com.cmrcet.bs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmrcet.bs.bean.Login;
import com.cmrcet.bs.repositories.LoginInterface;

@Service
public class LoginService implements ILogin {

	@Autowired
	LoginInterface crud;

	public Login validation(Login login) {

		login = crud.validate(login.getUsername(), login.getPassword());

		return login;

	}
}
