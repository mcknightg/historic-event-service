package com.example.historic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.historic.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends MongoRepository<Event, String> {
}