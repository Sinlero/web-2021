package ru.bgpu.task.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.TreeSet;

public class AnnotationPropertyInjector {

    private static final String PROPERTY_PATH = "tasks/task-annotation/src/main/resources/config.properties";

    public static void inject() {
        Properties props = load(PROPERTY_PATH);
        TreeSet<String> propertyNames = new TreeSet<>(props.stringPropertyNames());
        for (String propertyName : propertyNames) {
            System.out.printf("%s = %s\n", propertyName, props.getProperty(propertyName));
        }
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
