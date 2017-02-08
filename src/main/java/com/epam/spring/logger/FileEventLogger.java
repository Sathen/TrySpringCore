package com.epam.spring.logger;


import com.epam.spring.bean.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
@Component
public class FileEventLogger implements EventLogger {
    private String fileName;

    @Autowired
    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) throws IOException {

        File file = new File(fileName);

        FileUtils.writeStringToFile(file, event.getMsg(), true);


    }
    @PostConstruct
    public void init() throws IOException{
        File file = new File(fileName);
        file.canWrite();
    }
}
