package ru.bgpu.task.annotation;

import org.reflections.Reflections;
import ru.bgpu.task.annotation.annotations.ExampleAnnotation;

public class AnnotationScanner {

    public static void scan() {
        System.out.println("Сканируем используя Reflection API:");
        Reflections ref = new Reflections("ru.bgpu.task.annotation");
        for (Class<?> cl : ref.getTypesAnnotatedWith(ExampleAnnotation.class)) {
            ExampleAnnotation findable = cl.getAnnotation(ExampleAnnotation.class);
            System.out.printf("Найден класс: %s, с именем в аннотации: %s%n",cl.getSimpleName(), findable.name());
        }
    }
}
