package com.cmrcet.bs.restcalls;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmrcet.bs.bean.Login;
import com.cmrcet.bs.constants.URL;

@Service
public class LoginRestCall {

	public Login validate(String path, Login login) throws Exception {

		RestTemplate template = new RestTemplate();
		
		login = template.postForObject(URL.url + path, login, login.getClass());
		
		return login;
	}

}
