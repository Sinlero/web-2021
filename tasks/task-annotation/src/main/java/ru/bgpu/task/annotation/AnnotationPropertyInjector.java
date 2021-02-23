package ru.bgpu.task.annotation;

import ru.bgpu.task.annotation.annotations.InjectProperty;
import ru.bgpu.task.annotation.example.ClassWithAnnotatedFields;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class AnnotationPropertyInjector {

    private static final String PROPERTY_PATH = "tasks/task-annotation/src/main/resources/config.properties";

    public static void inject() throws Exception {
        Properties props = load(PROPERTY_PATH);
        Class<?> clazz = ClassWithAnnotatedFields.class;
        Object object = clazz.newInstance();
        for (Field field : clazz.getFields()) {
            if (field.isAnnotationPresent(InjectProperty.class)) {
                String parameter = field.getAnnotation(InjectProperty.class).name();
                if (!parameter.isEmpty()) {
                    if (field.getType().equals(Integer.class)) {
                        field.set(object, Integer.parseInt(props.getProperty(parameter)));
                    }
                    if (field.getType().equals(Double.class)) {
                        field.set(object, Double.parseDouble(props.getProperty(parameter)));
                    }
                    if (field.getType().equals(String.class)) {
                        field.set(object, props.getProperty(parameter));
                    }
                } else {
                    if (field.getType().equals(Integer.class)) {
                        field.set(object, Integer.parseInt(props.getProperty(field.getName())));
                    }
                    if (field.getType().equals(Double.class)) {
                        field.set(object, Double.parseDouble(props.getProperty(field.getName())));
                    }
                    if (field.getType().equals(String.class)) {
                        field.set(object, props.getProperty(field.getName()));
                    }
                }
            }
        }
        for (Field field : object.getClass().getFields()) {
            System.out.println(field.get(object));
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
