package be.wyckd.sorting;

import be.wyckd.datastructures.Collection;

import java.util.function.Consumer;

public class Sorter{
    public static <T extends Collection<I>, I> void sort(T collection, Consumer<Collection<I>> alg) {
        alg.accept(collection);
    }


   public static <T extends Collection<I>, I> void InsertionSort(T collection){
       for(I item : collection){
           System.out.println(item);
       }
   }

}
