package ru.bgpu.task.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AnnotationPropertyInjector {

    private static final String PROPERTY_PATH = "src/main/resources/config.properties";

    public static void inject() {
        
    }

    private static Properties load(String path) {
        File config = new File(path);
        Properties props = new Properties();
        try (FileReader reader = new FileReader(config)) {
            props.load(reader);
        } catch (FileNotFoundException exception) {
            System.out.println("Properties not found");
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return props;
    }

}
