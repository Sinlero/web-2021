package ru.bgpu.task.annotation;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import ru.bgpu.task.annotation.annotations.ExampleAnnotation;
import ru.bgpu.task.annotation.annotations.InjectProperty;

import java.lang.reflect.Field;

public class AnnotationScanner {

    public static void scan() {
        System.out.println("Сканируем используя Reflection API:");
        Reflections ref = new Reflections("ru.bgpu.task.annotation");
        for (Class<?> cl : ref.getTypesAnnotatedWith(ExampleAnnotation.class)) {
            ExampleAnnotation findable = cl.getAnnotation(ExampleAnnotation.class);
            System.out.printf("Найден класс: %s, с именем в аннотации: %s%n",cl.getSimpleName(), findable.name());
        }

        Reflections fieldRef = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("ru.bgpu.task.annotation"))
                .setScanners(new FieldAnnotationsScanner()));
        for (Field field : fieldRef.getFieldsAnnotatedWith(InjectProperty.class)) {
            InjectProperty findable = field.getAnnotation(InjectProperty.class);
            System.out.printf("Найдено поле: %s, с именем в аннотации: %s%n",field.getName(), findable.name());
        }
    }
}
