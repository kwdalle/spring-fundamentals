import com.pluralsight.service.SpeakerService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
  public static void main(String[] args) {
    // This creates the appContext based off the AppConfig.java class we created
    ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // SpeakerService service = new SpeakerServiceImpl(); <-- original way we
    // created the service

    SpeakerService service = appContext.getBean("speakerService", SpeakerService.class); // <-- new way we created the
                                                                                         // service

    System.out.println(service);
    System.out.println(service.findAll().get(0).getFirstName());
    System.out.println(service.findAll().get(0).getSeedNum());

    // Proving that the bean is a singleton
    SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
    System.out.println(service2);
  }
}
