/**
 * Programmer: Benjamin Krueper
 * Class: CS356
 * Project #: Design Pattern Demo
 * 
 * Purpose: this is a custom interface for lists
 */
package example;

public interface MyList<Type> extends Iterable<Type>{
    public void add(Type e);
    public void clear();
    public int size();
    public Type get(int index);
    public void remove(int index);
}
