package com.cmrcet.bs.restcalls;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.constants.URL;

@Service
public class UserBeanRestCall {

	public List<UserBean> getUsers(String path) {

		RestTemplate rest = new RestTemplate();

		return rest.exchange(URL.url + path, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserBean>>() {
		}).getBody();
	}

	public UserBean getUser(String path) {

		RestTemplate rest = new RestTemplate();

		return rest.exchange(URL.url + path, HttpMethod.GET, null, new ParameterizedTypeReference<UserBean>() {
		}).getBody();
	}

	public UserBean getUser(String path, HttpEntity<UserBean> requestEntity) {

		RestTemplate rest = new RestTemplate();

		return rest
				.exchange(URL.url + path, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<UserBean>() {
				}).getBody();

	}

	public UserBean getReservation(String path, String pnr) throws Exception {

		RestTemplate rest = new RestTemplate();
		return rest.postForObject(URL.url + path, pnr, UserBean.class);

	}

	public Reservation book(String path, Reservation reservation) {
		RestTemplate rest = new RestTemplate();

		return rest.postForObject(URL.url + path, reservation, Reservation.class);
	}

	public void delete(String path) {

		RestTemplate rest = new RestTemplate();

		rest.delete(URL.url + path);
	}
}
