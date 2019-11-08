package com.cmrcet.bs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Reservation;

@Repository
public interface ReservationInterface extends JpaRepository<Reservation, String>{

	@Query("select r from reservation r where r.pnr = :pnr")
	Reservation findOne(@Param("pnr") String pnr);

	@Query("select r from reservation r where r.service = :service")
	List<Reservation> findAll(@Param("service") BusDates busService);

}
