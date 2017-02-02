package com.epam.spring.logger;

import com.epam.spring.bean.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CombineEventLogger implements EventLogger {

    private List<EventLogger> loggerList;


    @Autowired
    public CombineEventLogger(List<EventLogger> loggerList) {
        this.loggerList = loggerList;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        for(EventLogger logger: loggerList){
            logger.logEvent(event);
        }
    }
}
