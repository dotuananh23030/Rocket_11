package com.etc.springbootmongodb.repository;

import com.etc.springbootmongodb.model.todoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface todoRepository extends MongoRepository<todoDTO, String> {

    @Query("{'notiMsg': ?0}")
    Optional<todoDTO> findByNotiMsg(String notiMsg);
}
