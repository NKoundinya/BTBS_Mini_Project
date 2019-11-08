package com.cmrcet.bs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Buses;

@Repository
public interface BusDatesInterface extends JpaRepository<BusDates, String>{

	@Query("select b from busservice b where b.date = :date")
	List<BusDates> findBuses(@Param("date") String date);

	@Query("select b from busservice b where b.date = :date and b.bus = :bus")
	BusDates getService(@Param("bus") Buses bus, @Param("date") String date);
	
}
