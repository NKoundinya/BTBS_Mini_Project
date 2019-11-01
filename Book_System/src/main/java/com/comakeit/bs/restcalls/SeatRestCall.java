package com.comakeit.bs.restcalls;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.constants.URL;

@Service
public class SeatRestCall {

	public List<String> getSources(String path) {

		RestTemplate rest = new RestTemplate();

		return rest.exchange(URL.url + path, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
		}).getBody();

	}

	public Integer getDestinations(String path, HttpEntity<UserBean> requestEntity) {

		RestTemplate rest = new RestTemplate();

		return rest.exchange(URL.url + "checkSeats", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Integer>() {
				}).getBody();

	}

	public void setSeats(String path, Reservation reservation) {

		RestTemplate rest = new RestTemplate();

		rest.put(URL.url + path, reservation);

	}
}
