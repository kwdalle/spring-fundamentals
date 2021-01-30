package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Speaker;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

  public List<Speaker> findAll() {
    List<Speaker> speakers = new ArrayList<>();

    Speaker speaker = new Speaker();

    speaker.setFirstName("Kevin");
    speaker.setLastName("Dalle");

    speakers.add(speaker);

    return speakers;
  }
}
