package com.epam.spring.bean;

import com.epam.spring.logger.ConsoleEventLogger;
import com.epam.spring.logger.EventLogger;
import com.epam.spring.logger.EventType;
import com.epam.spring.logger.FileEventLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.DateFormat;

@Configuration
@PropertySource("classpath:client.properties")
public class AppConfig {

    @Resource(name="consoleEventLogger")
    private ConsoleEventLogger consoleEventLogger;

    @Resource(name="fileEventLogger")
    private FileEventLogger fileEventLogger;


    @Resource(name = "date")
    private Date date;

    @Resource(name = "client")
    private Client client;

    public AppConfig() {
    }


    @Bean
    public Client client(){
        Client client = new Client();

        client.setFullName("Bob");
        client.setGreeting("Hi Hello");
        return client;
    }

//    @Bean
//    public App app(){
//        return new App(client,);
//    }


    @Bean
    public Map<EventType,EventLogger> loggerMap(){
        return new HashMap<EventType,EventLogger>(){
            {
                put(EventType.INFO,consoleEventLogger );
                put(EventType.INFO, fileEventLogger);
            }
        };

    }

    @Bean
    public Event event(){
        return new Event(date,DateFormat.getDateInstance());
    }

    @Bean
    public Date date(){
        return new Date (System.currentTimeMillis());
    }


}
