package com.comakeit.bs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comakeit.bs.bean.Buses;

public interface BusesInterface extends JpaRepository<Buses, String> {

}
