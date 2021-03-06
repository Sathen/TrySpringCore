package com.epam.spring.logger;


import com.epam.spring.bean.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize ;
    private List<Event> cache;

    @Autowired
    public CacheFileEventLogger(String fileName, int cacheSize) {

        super(fileName);
        this.cacheSize = cacheSize;
        cache =  new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() throws IOException{
       for(Event event:cache){
           super.logEvent(event);
       }
    }
    private void  destroy() throws IOException {
        writeEventsFromCache();
        cache.clear();
    }
}
