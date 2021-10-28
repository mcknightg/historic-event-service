package com.example.historic.controller;

import com.example.historic.model.Event;
import com.example.historic.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class EventController {

  private final EventService service;

  public EventController(EventService service) {
    this.service = service;
  }

  @PostMapping(value="/event",produces = MediaType.APPLICATION_JSON_VALUE)
  public Event save(@RequestBody Map<String,Object> dto){
    ObjectMapper mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Event.class));
  }

  @GetMapping(value = "/event/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Event> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id));
  }

  @GetMapping(value = "/event",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Event> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/event/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(String.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/event/search"}, produces = { "application/json" })
  public Page<Event> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
