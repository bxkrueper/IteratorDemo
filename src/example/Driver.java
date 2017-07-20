/**
 * Programmer: Benjamin Krueper
 * Class: CS356
 * Project #: Design Pattern Demo
 * 
 * Purpose: this class is the driver for testing
 */
package example;

import java.util.Iterator;

public class Driver {

    public static void main(String[] args) {
        testMyLinkedList(); 
//        testMyTreeSet();
    }
    
    private static void testMyLinkedList() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(10);
        
        
        /*
         * method 1 (naive)
         */
        int size = list.size();
        for(int i=0;i<size;i++){
            System.out.println(list.get(i));
        }
        
        /*
         * method 2 (iterator)
         */
//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()){
//            Integer number = it.next();
//            System.out.println(number);
//        }
        
    }

    private static void testMyTreeSet() {
        MySet<Double> set = new MyTreeSet<>();
        set.add(5.0);
        set.add(1.0);
        set.add(7.0);
        set.add(0.0);
        set.add(2.0);
        set.add(0.5);
        set.add(0.25);
        
        System.out.println(set);
        System.out.println();
        
        
        
        /*
         * method 1
         */
        Iterator<Double> iterator = set.iterator();
        while(iterator.hasNext()){
            Double number = iterator.next();
            System.out.println(number);
        }
        
        /*
         * method 2
         */
//        for(Double d: set){
//            System.out.println(d);
//        }
    }

    

}