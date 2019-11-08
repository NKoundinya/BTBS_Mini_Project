package com.cmrcet.bs.services;

import java.util.List;
import java.util.Set;

import com.cmrcet.bs.bean.Buses;
import com.cmrcet.bs.bean.TicketCost;
import com.cmrcet.bs.bean.UserBean;

public interface ITicketCost {
	
	List<TicketCost> getCost(UserBean bean, Set<String> buses);
	
	int getCost(UserBean bean);
	
}
