package com.epam.spring.bean;

import com.epam.spring.logger.ConsoleEventLogger;
import com.epam.spring.logger.EventLogger;
import com.epam.spring.logger.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType,EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        App app = (App) ctx.getBean("app");
        try {
            app.logEvent("Our client is 1",ctx, EventType.ERROR);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            ctx.close();
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
