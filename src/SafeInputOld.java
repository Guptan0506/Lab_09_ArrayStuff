import java.util.Random;
import java.util.Scanner;

public class SafeInputOld {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int[] dataPoints = new int[100];

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        for (int i = 0; i < dataPoints.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            System.out.print(dataPoints[i]);
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++ ){
            sum += dataPoints[i];
        }

        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array is "+ sum);
        System.out.println("The average of the random array is "+ average);

        int value = SafeInput.getRangedInt(in, "Enter a value in between 1 and 100", 1, 100);

        int count = 0;
        for (int i = 0; i < dataPoints.length; i ++){
            if (dataPoints[i] == value) {
                count++;
            }
        }
        System.out.println("The value " + value + " was found "+ count + " times.");

        int userValue = SafeInput.getRangedInt(in, "Enter another value between 1 and 100", 1 , 100);
        boolean foundItem = false;
        for (int i = 0; i < dataPoints.length; i++){
            if(dataPoints[i] == userValue) {
                System.out.println("Item found at index "+ i);
                foundItem = true;
                break;
            }
        }
        if (!foundItem){
            System.out.println("Sorry, Item was not found");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 0; i < dataPoints.length; i++){
            if (dataPoints[i] < min ){
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum is " + min);
        System.out.println("The maximum is " + max);

        System.out.println("Average of data points is: "+ getAverage(dataPoints));
    }
    public static double getAverage(int values[]){
        int sum = 0;
        for (int i = 0; i < values.length; i++){
            sum += values[i];
        }
        return (double) sum / values.length;
    }
}