package com.jwt.oauth2.springbootoauth2jwtresource.controller;

import com.jwt.oauth2.springbootoauth2jwtresource.entity.Barang;
import com.jwt.oauth2.springbootoauth2jwtresource.repository.RepositoryBarang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/barang")
public class ControllerBarang {

    @Autowired
    private RepositoryBarang repositoryBarang;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Barang>> listBarang(){
        return Optional.ofNullable(repositoryBarang.findAll())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Barang>>(HttpStatus.BAD_REQUEST));
    }
}
