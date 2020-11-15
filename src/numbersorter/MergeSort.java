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

        if(min<max && (max-min)>=1){ //Loops till 1 item between min and max

            int mid = (max + min)/2;

            splitter(min, mid); //Halves it (lower)
            splitter(mid+1, max); //Halves it (higher)

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

        for(leftIndex=leftIndex;leftIndex<=mid;leftIndex++){
            mergedSortedArray.add(inputArray.get(leftIndex));
        }

        for (rightIndex=rightIndex;rightIndex<=max;rightIndex++){
            mergedSortedArray.add(inputArray.get(rightIndex));
        }

        int j = min;

        for(int i=0;i<mergedSortedArray.size();i++){
            inputArray.set(j, mergedSortedArray.get(i));
            j++;
        }
    }
}
