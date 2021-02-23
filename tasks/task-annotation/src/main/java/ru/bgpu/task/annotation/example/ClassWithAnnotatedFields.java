package ru.bgpu.task.annotation.example;

import ru.bgpu.task.annotation.annotations.InjectProperty;

public class ClassWithAnnotatedFields {

    @InjectProperty(name = "loadName")
    public static String simpleName;

    @InjectProperty
    public static Integer size;

    @InjectProperty(name = "int")
    public static Integer intField;

    @InjectProperty
    public static Double aDouble;
}
