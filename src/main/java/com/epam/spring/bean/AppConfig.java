package com.epam.spring.bean;

import com.epam.spring.logger.ConsoleEventLogger;
import com.epam.spring.logger.EventLogger;
import com.epam.spring.logger.EventType;
import com.epam.spring.logger.FileEventLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Resource(name="consoleEventLogger")
    private ConsoleEventLogger consoleEventLogger;
    @Resource(name="fileEventLogger")
    private FileEventLogger fileEventLogger;

    @Bean
    public Map<EventType,EventLogger> loggerMap(){
        return new HashMap<EventType,EventLogger>(){
            {
                put(EventType.INFO,consoleEventLogger );
                put(EventType.INFO, fileEventLogger);
            }
        };

    }

}
