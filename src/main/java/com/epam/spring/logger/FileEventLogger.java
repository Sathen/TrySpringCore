package com.epam.spring.logger;


import com.epam.spring.bean.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) throws IOException {

        File file = new File(fileName);

        FileUtils.writeStringToFile(file, event.getMsg(), true);


    }
    public void init() throws IOException{
        File file = new File(fileName);
        file.canWrite();
    }
}
