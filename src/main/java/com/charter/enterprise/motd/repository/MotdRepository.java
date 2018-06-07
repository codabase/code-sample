package com.charter.enterprise.motd.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="motd", rel="motd")
public interface MotdRepository extends CrudRepository<MessageOfTheDay,Long>{

}
