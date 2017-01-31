package com.epam.spring.logger;

import com.epam.spring.bean.Event;

import java.io.IOException;
import java.util.List;


public class CombineEventLogger implements EventLogger {

    private List<EventLogger> loggerList;


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
