package numbersorter;

import java.util.ArrayList;

public class MergeSort {

    private ArrayList<Integer> inputArray;

    public MergeSort(ArrayList<Integer> inputArray){
        this.inputArray = inputArray;
    }

    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    public void sort(){
        splitter(0, inputArray.size()-1);
    }

    public void splitter(int min, int max){

        if(min<max && (max-min)>=1){

            int mid = (max + min)/2;

            splitter(min, mid);
            splitter(mid+1, max);

            merger(min,mid,max);
        }
    }

    public void merger(int min,int mid,int max){

        ArrayList<Integer> mergedSortedArray = new ArrayList<>();

        int leftIndex = min;
        int rightIndex = mid+1;

        while(leftIndex<=mid && rightIndex<=max){
            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        while(leftIndex<=mid){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=max){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = min;

        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}
