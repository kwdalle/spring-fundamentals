package com.pluralsight.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("speakerService") // Does not mean web service or micro service, but rather where you put your
                           // business logic
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

  @Autowired
  private SpeakerRepository repository;

  public SpeakerServiceImpl() {
    System.out.println("SpeakerServiceImpl no args constructor");
  }

  // @Autowired // Constructor Injection through autowiring
  public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
    System.out.println("SpeakerServiceImpl repository constructor");
    this.repository = speakerRepository;
  }

  @PostConstruct
  private void initialize() {
    System.out.println("We're called after the constructors");
  }

  public List<Speaker> findAll() {
    return repository.findAll();
  }

  // This is used in the AppConfig to Inject the SpeakerRepository dependency into
  // the this class
  // @Autowired -> autowiring by default is done by TYPE
  public void setRepository(SpeakerRepository repository) {
    System.out.println("SpeakerServiceImpl setter");
    this.repository = repository;
  }
}
