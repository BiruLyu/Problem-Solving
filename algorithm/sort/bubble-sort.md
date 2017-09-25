# Bubble Sort

The bubble sort makes multiple passes through a list. It compares adjacent items and exchanges those that are out of order. Each pass through the list places the next largest value in its proper place. In essence, each item “bubbles” up to the location where it belongs.

``` java
public int[] bubbleSortPro(int[] array){
        boolean isContinue=true;
        for(int i=0;i<array.length-1&&isContinue;i++){
            isContinue=false;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    isContinue=true;
                }
            }
        }
        return array;
    }
```