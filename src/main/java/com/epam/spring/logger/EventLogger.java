package com.epam.spring.logger;

import com.epam.spring.bean.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event) throws IOException;
}
