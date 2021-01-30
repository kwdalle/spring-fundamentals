import java.util.Calendar;

import com.pluralsight.util.CalendarFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.pluralsight" })
public class AppConfig {

  @Bean(name = "cal")
  public CalendarFactory calFactory() {
    CalendarFactory factory = new CalendarFactory();
    factory.addDays(2);
    return factory;
  }

  @Bean
  public Calendar cal() throws Exception {
    return calFactory().getObject();
  }

  /*
   * @Bean(name = "speakerService")
   * 
   * @Scope(value = BeanDefinition.SCOPE_SINGLETON) // Example of HOW to configure
   * scope public SpeakerService getSpeakerService() { // SpeakerServiceImpl
   * service = new SpeakerServiceImpl(getSpeakerRepository()); SpeakerServiceImpl
   * service = new SpeakerServiceImpl(); //
   * service.setRepository(getSpeakerRepository()); <-- setter injection return
   * service; }
   */

  /*
   * // You want to create this as a bean, because all beans are SINGLETON objects
   * by // default
   * 
   * @Bean(name = "speakerRepository") public SpeakerRepository
   * getSpeakerRepository() { return new HibernateSpeakerRepositoryImpl(); }
   */
}
