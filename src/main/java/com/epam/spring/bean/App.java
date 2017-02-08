package com.epam.spring.bean;

import com.epam.spring.MongoApp;
import com.epam.spring.config.AppConfig;
import com.epam.spring.logger.ConsoleEventLogger;
import com.epam.spring.logger.EventLogger;
import com.epam.spring.logger.EventType;
import com.epam.spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
@Component
public class App {

    @Resource(name = "client")
    private Client client;
    @Resource(name="combineEventLogger")
    private EventLogger eventLogger;
    @Resource(name = "loggerMap")
    private Map<EventType,EventLogger> loggers;

    @Autowired
    private ClientRepository clientRepository;



    public App(){

    }
    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.scan("com.epam.spring");
        ctx.refresh();
        App app = (App) ctx.getBean("app");

        SpringApplication.run(MongoApp.class,args);

        try {
            app.logEvent("Hi 1",ctx,EventType.INFO);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }


    }

    private void logEvent(String msg, ConfigurableApplicationContext ctx, EventType type) throws IOException {
        eventLogger = loggers.get(type);

        if(eventLogger == null){
            eventLogger = new ConsoleEventLogger();
        }

        Event event = (Event) ctx.getBean("event");
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
