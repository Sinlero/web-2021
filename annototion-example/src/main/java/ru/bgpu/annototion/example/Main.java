

package ru.bgpu.annototion.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
   
    
    public static void main(String[] args)  {
        
        Class c = Example.class;
        
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        
        for (Field field: c.getFields()) {
            System.out.println(field.getName());
        }
        
        for(Field field: c.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        
        try {
            Object o = c.getConstructor(String.class).newInstance("Hello");
           
            for(Field field: c.getDeclaredFields()) {
                String name = field.getName();
                try {
                    Method setter = c.getDeclaredMethod(
                            "set"+name.substring(0, 1).toUpperCase()+
                            name.substring(1, name.length()),
                            Integer.class
                    );
                    setter.invoke(o, 100);
                } catch(NoSuchMethodException ignored) {}
                try {
                    Method setter = c.getDeclaredMethod(
                            "set"+name.substring(0, 1).toUpperCase()+
                            name.substring(1, name.length()),
                            int.class
                    );
                    setter.invoke(o, 100);
                } catch(NoSuchMethodException ignored) {}
            }
            
            System.out.println(o);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
