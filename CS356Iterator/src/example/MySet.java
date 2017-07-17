package example;

public interface MySet <Type extends Comparable<Type>> extends Iterable<Type>{
    public void add(Type e);
    public void clear();
    public int size();
}
