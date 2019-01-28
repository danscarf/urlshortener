package com.acme.urlshortener.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acme.urlshortener.ShortCode;

@Repository
public interface ShortcodeRepository extends CrudRepository<ShortCode, String>{

}
