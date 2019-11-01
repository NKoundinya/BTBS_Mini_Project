package com.comakeit.bs.restcalls;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.constants.URL;

@Service
public class TicketCostRestCall {
	
	public List<TicketCost> getCosts(String path, HttpEntity<UserBean> requestEntity) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.exchange(URL.url + path, HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<TicketCost>>() {
				}).getBody();

	}
}
