package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 02.04.17 21:28.
 */
public class Arithmetic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = Double.parseDouble(scan.next()); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        double sum = 0;
        sum += mealCost;
        sum += mealCost * tipPercent / 100;
        sum += mealCost * taxPercent / 100;

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(sum);

        System.out.println("The total meal cost is " + totalCost + " dollars.");
    }
}