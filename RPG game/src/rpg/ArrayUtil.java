/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg;

import java.util.Arrays;

/**
 *
 * @author edoua
 */
public class ArrayUtil {
    public static <T>T[] addElement(T[] array, T element){
    if(array!=null&&element!=null){
    array=Arrays.copyOf(array, array.length+1);
            array[array.length-1]=element;
            
    }
    return array;
    }
    public static <T>T[] removeElement(T[] array, int index){
    if (array!=null &&index>=0){
    array[index]=array[array.length-1];
    array=Arrays.copyOf(array, array.length-1);
    }
    return array;
    }
    
}
