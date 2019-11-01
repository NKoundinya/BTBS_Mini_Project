package com.comakeit.bs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comakeit.bs.bean.Login;

@Repository
public interface LoginInterface extends JpaRepository<Login, String>{

	@Query("select l from Login l where l.username = :username and l.password = :password")
	public Login validate(@Param("username") String username, @Param("password") String password);

}
