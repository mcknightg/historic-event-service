package com.example.historic.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class EventTest {

  @Test
  void shouldCreateEvent(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Event.class));
  }

  @Test
  void shouldBuildEvent(){
    Assertions.assertNotNull(Event.builder().build());
  }
}
