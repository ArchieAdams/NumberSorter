package numbersorter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> unsortedArray = new ArrayList<>();

    public static void main(String[] args) {
        numberOfNumbers();

        MergeSort mergeSort = new MergeSort(unsortedArray);

        System.out.println("Unsorted Array: ");
        unsortedArray.forEach(i -> System.out.print(i + " "));
        System.out.println();

        mergeSort.sort();
        ArrayList<Integer> sortedArray = mergeSort.getSortedArray();

        System.out.println("Sorted Array: ");
        sortedArray.forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Min : " + sortedArray.get(0));
        System.out.println("Max : " + sortedArray.get(sortedArray.size()-1));

        int total=0;
        for (int i:sortedArray){
            total+=i;
        }
        System.out.println("Avg : "+total/sortedArray.size());

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
        int loopNum;
        while (true) {
            while (true) {
                try {
                    System.out.print("How many numbers do you want to have? ");
                    loopNum = getInputInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter an int!");
                }
            }


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
            while (true) {
                try {
                    System.out.print("Enter number "+(i+1)+": ");
                    unsortedArray.add(getInputInt());
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter an int!");
                }
            }
        }
    }
}
