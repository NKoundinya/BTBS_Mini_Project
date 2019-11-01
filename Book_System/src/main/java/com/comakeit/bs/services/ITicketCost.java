package com.comakeit.bs.services;

import java.util.List;
import java.util.Set;

import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;

public interface ITicketCost {
	
	List<TicketCost> getCost(UserBean bean, Set<String> buses);
	
	int getCost(UserBean bean);
	
}
