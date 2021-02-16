package ru.bgpu.task.annotation.example;

import ru.bgpu.task.annotation.annotations.InjectProperty;

public class ClassWithAnnotatedFields {

    @InjectProperty(name = "loadName")
    public static String simpleName;

    @InjectProperty
    public static Integer size;
}
