/**
 * Programmer: Benjamin Krueper
 * Class: CS356
 * Project #: Design Pattern Demo
 * 
 * Purpose: this is a custom interface for sets
 */
package example;

public interface MySet <Type extends Comparable<Type>> extends Iterable<Type>{
    public void add(Type e);
    public void clear();
    public int size();
}
