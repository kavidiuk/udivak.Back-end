<<<<<<< Updated upstream
package capstone.udivak;

import java.util.Date;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class UdivakApplication implements ApplicationListener
        <ApplicationReadyEvent> {

    public static void main(String[] args) {
        SpringApplication.run(UdivakApplication.class, args);
        log.debug("##########################################");
        log.info("##########################################");
        log.info("Start Application Udivak");
        log.info("##########################################");
    }
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent e) {
        log.info("---STARTUP CODE---");
    }
    
    @Bean
    public RestTemplate rest() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //METODI ESEGUITO OGNI SECONDO TRAMITE ESPRESSIONE CRON
    //@Scheduled(cron = "* * *  * * ? ")
    public void repeated() {
        log.info("///REPEATED///");
    }

    //METODO ESEGUITO OGNI 300000ms QUINDI OGNI 5 MINUTI
    //@Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        log.info("The time is now {}" + new Date());
    }

}
=======
package capstone.udivak;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class UdivakApplication implements ApplicationListener
        <ApplicationReadyEvent> {

    public static void main(String[] args) {
        SpringApplication.run(UdivakApplication.class, args);
        log.debug("##########################################");
        log.info("##########################################");
        log.info("Start Application Udivak");
        log.info("##########################################");
    }
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent e) {
        log.info("---STARTUP CODE---");
    }
    
    @Bean
    public RestTemplate rest() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //METODI ESEGUITO OGNI SECONDO TRAMITE ESPRESSIONE CRON
    //@Scheduled(cron = "* * *  * * ? ")
    public void repeated() {
        log.info("///REPEATED///");
    }

    //METODO ESEGUITO OGNI 300000ms QUINDI OGNI 5 MINUTI
    //@Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        log.info("The time is now {}" + new Date());
    }

}
>>>>>>> Stashed changes
