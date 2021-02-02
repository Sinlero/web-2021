
package ru.bgpu.annototion.example;

public class Example {
    
    public static String VALUE = "SET";
    
    private int first = 0;
    private Integer second;
    
    private String name;
    
    public Example(String name) {
        this.name = name;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" -> "+name+" {"+first+", "+second+"}";
    }
        
}
