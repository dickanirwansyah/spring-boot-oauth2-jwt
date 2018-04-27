package com.jwt.oauth2.springbootoauth2jwt.repository;

import com.jwt.oauth2.springbootoauth2jwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, String>{

    @Query
    Users findByIdusers(String idusers);

    @Query("SELECT u FROM Users u WHERE LOWER(u.username) = LOWER(:username)")
    Users findByUsernameCaseSensitive(@Param("username") String username);

    @Query
    Users findByEmail(String emai);
}
