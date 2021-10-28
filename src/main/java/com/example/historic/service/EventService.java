package com.example.historic.service;

import com.example.historic.model.Event;
import com.example.historic.repository.EventRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class EventService{

  private final EventRepo repo;

  public EventService(EventRepo repo) {
    this.repo = repo;
  }

  public  Event save(Event item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Event> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Event> findAll() {
    return repo.findAll();
  }

  public Page<Event> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
