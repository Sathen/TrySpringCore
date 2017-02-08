package com.epam.spring.config;

import com.epam.spring.bean.Client;
import com.epam.spring.bean.Event;
import com.epam.spring.logger.CombineEventLogger;
import com.epam.spring.logger.EventLogger;
import com.epam.spring.logger.EventType;
import com.epam.spring.logger.FileEventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.*;

@Configuration
@PropertySource(value = "classpath:client.properties")
public class AppConfig {

    @Resource(name ="сonsoleEventLogger" )
    private EventLogger consoleEventLogger;
    @Autowired
    private Environment environment;
    @Resource(name="fileEventLogger")
    private EventLogger fileEventLogger;
    @Autowired
    private Date date;


    public AppConfig() {
    }


    @Bean
    public Client client(){
        Client client = new Client();
        client.setFullName(environment.getProperty("name"));
        client.setGreeting("Hi Hello");

        return client;
    }



    @Bean
    public Map<EventType,EventLogger> loggerMap(){
        return new HashMap<EventType,EventLogger>(){
            {
                put(EventType.INFO,consoleEventLogger );
                put(EventType.ERROR, fileEventLogger);
            }
        };

    }

    @Bean
    public EventLogger fileEventLogger(){
        return new FileEventLogger("logger.txt");

    }
    @Bean
    public EventLogger combineEventLogger(){

        List<EventLogger> loggerList = new ArrayList<>();
        loggerList.add(consoleEventLogger);
        loggerList.add(fileEventLogger);

        return new CombineEventLogger(loggerList);


    }
    @Bean
    @Scope(scopeName = "prototype")
    public Event event(){
        return new Event(date,DateFormat.getDateInstance());
    }

    @Bean
    public Date date(){
        return new Date (System.currentTimeMillis());
    }


}
