package com.comakeit.bs.restcalls;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.constants.URL;

@Service
public class BusRestCall {

	public List<Buses> getBuses(String path) {
		
		RestTemplate template = new RestTemplate();

		return template.exchange(URL.url + path, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Buses>>() {
				}).getBody();
		
	}

}
