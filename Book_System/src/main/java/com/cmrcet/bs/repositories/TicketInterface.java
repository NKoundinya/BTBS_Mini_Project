package com.cmrcet.bs.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmrcet.bs.bean.Buses;
import com.cmrcet.bs.bean.TicketCost;

@Repository
public interface TicketInterface extends JpaRepository<TicketCost, String> {

	@Query("select t from ticketcost t where t.busId in (select b from bus b where b.busid in :busList)")
	List<TicketCost> getCost(@Param("busList") Set<String> bus);

	@Query("select t from ticketcost t where t.busId = :bus")
	List<TicketCost> getCost(@Param("bus") Buses bus);

}
