package com.cmrcet.bs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.SeatAllocation;

@Repository
public interface SeatAllocationInterface extends JpaRepository<SeatAllocation, String> {
	
	@Query("SELECT DISTINCT b.source FROM seatallocation b")
	List<String> getSources();
	
	@Query("SELECT DISTINCT b.destination FROM seatallocation b")
	List<String> getDestinations();
	
	@Query("SELECT s from seatallocation s where s.busService in (select sa.busService from seatallocation sa where sa.source = :source) and s.busService in (select sa1.busService from seatallocation sa1 where sa1.destination = :destination) and s.busService in (SELECT b FROM busservice b where b.date = :date)")
	List<SeatAllocation> getSeats(@Param("source") String source, @Param("destination") String destination, @Param("date") String date);
	
	@Query("select t from seatallocation t where t.busService = :service")
	List<SeatAllocation> checkSeats(@Param("service") BusDates busService);

	@Query("select distinct t.busService from seatallocation t where t.busService in (select s.busService from seatallocation s where s.source = :source) and t.busService in (select s.busService from seatallocation s where s.destination = :destination)")
	List<BusDates> getBusService(@Param("source") String source, @Param("destination") String destination);
	
}
