/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author kylegreenfield
 * 
 * implementation of a heap variation to return max_value; integer only 
 * 
 */
import java.util.ArrayList ;

public class MaxIntegerHeap {
    
    private static ArrayList<Integer> heapArray;
    
    
    public MaxIntegerHeap() {
        heapArray = new ArrayList() ;
    }
    
    public void insert(int number) {
        int index = heapArray.size() ;
        int parentIndex = getParentIndex( index ) ;
        heapArray.add(number);
        if ( heapArray.get(parentIndex) < heapArray.get(index) )
            bubbleUp( index ) ;
    }
    
    private void bubbleUp(int i){
        int parentIndex = getParentIndex(i) ;
        while ( heapArray.get(i) > heapArray.get(parentIndex) ) {
            swapElements(i, parentIndex) ;
            bubbleUp( parentIndex ) ;
        }
    }
    
    private void bubbleDown(int i) {
        if ( i < heapArray.size() - 1 ) {
            int child1 = i+1 ;
            int child2 = i+2 ;
            if ( heapArray.get(i) < heapArray.get(child1) ) {
                swapElements(i, child1) ;
                bubbleDown(child1) ;
            }
            else if ( heapArray.get(i) < heapArray.get(child2)) {
                swapElements(i, child2) ;
                bubbleDown(child2) ;
            }
        }
        else if ( i == heapArray.size() - 1 ) {
            int child1 = i+1 ;
            if ( heapArray.get(i) < heapArray.get(child1) ) {
                swapElements(i, child1) ;
            }
        }
    }
    
    private void swapElements( int first, int second ) {
        int tempValue = heapArray.get(second) ;
        heapArray.set(second, heapArray.get(first));
        heapArray.set(first, tempValue);
    }
    
    private int getParentIndex( int i ) {
        if ( i > 0 )
           return (i - 1)/2 ;
        else 
            return 0 ;
    }
    
    public int getMaxValue() {
        return heapArray.get(0);
    }
    
    public void deleteMaxValue() {
        int lastIndex = heapArray.size() - 1 ;
        heapArray.set(0, heapArray.get(lastIndex)) ;
        heapArray.remove(lastIndex);
        bubbleDown(0);
    }

}

