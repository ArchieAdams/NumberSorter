package numbersorter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> unsortedArray = new ArrayList<>();

    public static void main(String[] args) {
        numberOfNumbers();

        MergeSort mergeSort = new MergeSort(unsortedArray);

        System.out.println("Unsorted Array:");
        for (int i:unsortedArray){
            System.out.print(i+" ");
        }

        mergeSort.sort();
        System.out.println();

        System.out.println("Sorted Array:");
        for (int i:mergeSort.getSortedArray()){
            System.out.print(i+" ");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public static String getInputString(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static int getInputInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    // </editor-fold>

    public static void numberOfNumbers(){
        while (true) {
            System.out.print("How many numbers do you want to have? ");
            int loopNum = getInputInt();
            if (loopNum >=10) {
                looper(loopNum);
                break;
            }
            else {
                System.out.println("Minimum number of numbers is 10");
            }
        }
    }

    private static void looper(int loopNum){
        for (int i = 0; i < loopNum; i++) {
            System.out.print("Enter number "+(i+1)+": ");
            unsortedArray.add(getInputInt());
        }
    }
}
