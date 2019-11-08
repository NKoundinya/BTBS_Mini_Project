package com.cmrcet.bs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmrcet.bs.bean.Buses;

public interface BusesInterface extends JpaRepository<Buses, String> {

}
