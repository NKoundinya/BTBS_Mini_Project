package com.cmrcet.bs.restcalls;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.constants.URL;

@Service
public class BusDatesRestCall {

	public List<BusDates> getServices(String path) {
		
		RestTemplate rest = new RestTemplate();
		
		return rest.exchange(URL.url + path, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<BusDates>>() {
				}).getBody();
	}
	
}
