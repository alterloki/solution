package y2010.africa.qualify;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 16.02.14
 * Time: 12:45
 */

import common.ParseUtil;

import java.util.Map;

/**
 * https://code.google.com/codejam/contest/dashboard?c=351101
 *
 * @author ashevenkov
 */
public class ProblemA {

    static String INPUT = "3\n" +
            "100\n" +
            "3\n" +
            "5 75 25\n" +
            "200\n" +
            "7\n" +
            "150 24 79 50 88 345 3\n" +
            "8\n" +
            "8\n" +
            "2 1 9 4 4 56 90 3\n";

    public static void main(String[] args) {
        //new ProblemA().run(INPUT);
        new ProblemA().run(ParseUtil.parseFile("A-large-practice.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int n = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < n; i++) {
            int credit = Integer.parseInt(lines[ln++]);
            String line = lines[ln++];
            String itemsPriceS = lines[ln++];
            String[] itemPriceSArr = itemsPriceS.split(" ");
            int[] prices = new int[itemPriceSArr.length];
            for (int j = 0; j < itemPriceSArr.length; j++) {
                prices[j] = Integer.parseInt(itemPriceSArr[j]);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(credit, prices));
        }
    }

    private String solve(int credit, int[] prices) {
        Map<Integer, Integer> priceMap = new java.util.HashMap<Integer, Integer>();
        for (int price : prices) {
            Integer count = priceMap.get(price);
            if (count == null) {
                count = 0;
            }
            count++;
            priceMap.put(price, count);
        }
        int firstI = 0;
        int ap = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int addPrice = credit - price;
            if (priceMap.keySet().contains(addPrice)) {
                firstI = i;
                if (addPrice == price) {
                    if(priceMap.get(price) > 1) {
                        ap = addPrice;
                        break;
                    }
                } else {
                    ap = addPrice;
                    break;
                }
            }
        }
        int secondI = 0;
        for (int i = firstI + 1; i < prices.length; i++) {
            int price = prices[i];
            if (price == ap) {
                secondI = i;
            }
        }
        return Integer.toString(firstI + 1) + " " + Integer.toString(secondI + 1);
    }
}
