package com.cmrcet.bs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cmrcet.bs.bean.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	@Query("select pay from payment pay where pnrid = :pnr")
	Payment findPayment(@Param("pnr") String pnr);

}
