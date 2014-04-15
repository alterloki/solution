/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 15.04.14
 * Time: 17:45
 */
package y2013.contest.r1a;

import common.ParseUtil;

import java.util.*;

/**
 * @author ashevenkov
 */
public class ProblemC {

    static String INPUT =
            "1\n" +
                    "2 3 4 4\n" +
                    "9 4 36 1\n" +
                    "1 1 1 1";

    public static void main(String[] args) {
        //new ProblemC().run(INPUT);
        new ProblemC().run(ParseUtil.parseFile("C-small-practice-2.in"));
    }

    private void run(String input) {
        String[] lines = input.split("\n");
        int ln = 0;
        int count = Integer.parseInt(lines[ln++]);
        for (int i = 0; i < count; i++) {
            String line = lines[ln++];
            String[] parts = line.split(" ");
            int r = Integer.parseInt(parts[0]);
            int n = Integer.parseInt(parts[1]);
            int m = Integer.parseInt(parts[2]);
            int k = Integer.parseInt(parts[3]);
            long[][] v = new long[r][];
            for (int j = 0; j < r; j++) {
                line = lines[ln++];
                v[j] = new long[k];
                parts = line.split(" ");
                for (int l = 0; l < parts.length; l++) {
                    String part = parts[l];
                    v[j][l] = Long.parseLong(part);
                }
            }
            System.out.println("Case #" + (i + 1) + ": \n" + solve(r, n, m, k, v));
        }
    }

    /**
     * For second small dataset on my notebook it works about 1-2 minutes (80 sec last time).
     * It is ok for 4 minutes timeout.
     *
     * @param r - experiment count
     * @param n - numbers in set
     * @param m - max number: [2, m]
     * @param k - product count
     * @param v - product values
     * @return
     */
    private String solve(int r, int n, int m, int k, long[][] v) {
        //1. generate all number and probabilities. length n.
        Map<String, Double> sets = generateAllSets(n, m);
        System.out.println("Sets generated. N = " + sets.size());
        Map<String, Map<Long, Double>> products = generateProducts(sets);
        System.out.println("Products generated");
        Map<Long, Map<String, Double>> productsMap = convertProducts(products);
        System.out.println("Products converted");
        String resString = "";
        for (int i = 0; i < v.length; i++) {
            long[] vector = v[i];
            Map<String, Double> strSets = null;
            for (int j = 0; j < vector.length; j++) {
                long prod = vector[j];
                Map<String, Double> map = productsMap.get(prod);
                if (strSets == null) {
                    strSets = new HashMap<String, Double>();
                    strSets.putAll(map);
                } else {
                    Iterator<Map.Entry<String, Double>> it = strSets.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Double> entry = it.next();
                        if (!map.containsKey(entry.getKey())) {
                            it.remove();
                        }
                    }
                    for (Map.Entry<String, Double> entry : map.entrySet()) {
                        if (strSets.containsKey(entry.getKey())) {
                            strSets.put(entry.getKey(), strSets.get(entry.getKey()) * entry.getValue());
                        }
                    }
                }
            }
            double maxProbability = 0;
            String result = "-";
            for (Map.Entry<String, Double> entry : strSets.entrySet()) {
                String set = entry.getKey();
                double wholeProb = entry.getValue() * sets.get(set);
                if (wholeProb > maxProbability) {
                    maxProbability = wholeProb;
                    result = set;
                }
            }
            resString += result + "\n";

        }
        return resString;
    }

    private Map<Long, Map<String, Double>> convertProducts(Map<String, Map<Long, Double>> products) {
        Map<Long, Map<String, Double>> result = new HashMap<Long, Map<String, Double>>();
        for (Map.Entry<String, Map<Long, Double>> entry : products.entrySet()) {
            String set = entry.getKey();
            Map<Long, Double> setProducts = entry.getValue();
            for (Map.Entry<Long, Double> entry1 : setProducts.entrySet()) {
                Map<String, Double> setMap = result.get(entry1.getKey());
                if (setMap == null) {
                    setMap = new HashMap<String, Double>();
                    result.put(entry1.getKey(), setMap);
                }
                setMap.put(set, entry1.getValue());
            }
        }
        return result;
    }

    private Map<String, Map<Long, Double>> generateProducts(Map<String, Double> sets) {
        Map<String, Map<Long, Double>> result = new HashMap<String, Map<Long, Double>>();
        int i = 0;
        for (Map.Entry<String, Double> entry : sets.entrySet()) {
            String set = entry.getKey();
            result.put(set, productsForSet(set));
        }
        return result;
    }

    private Map<Long, Double> productsForSet(String set) {
        Map<Long, Double> map = new HashMap<Long, Double>();
        List<Long> products = new ArrayList<Long>();
        products.add(1L);
        for (int i = 0; i < set.toCharArray().length; i++) {
            List<Long> newProducts = new ArrayList<Long>();
            char c = set.toCharArray()[i];
            long ci = c - '0';
            for (Long product : products) {
                newProducts.add(ci * product);
                newProducts.add(1 * product);
            }
            products = newProducts;
        }
        for (Long product : products) {
            Double prob = map.get(product);
            if (prob == null) {
                prob = 0.0;
            }
            prob += (double) 1 / Math.pow(2, set.length());
            map.put(product, prob);
        }
        return map;
    }

    private Map<String, Double> generateAllSets(int n, int m) {
        Set<String> sets = generateSetFromTo(2, m, n);
        Map<String, Double> result = new java.util.HashMap<String, Double>();
        for (String set : sets) {
            Map<Character, Integer> cmap = new HashMap<Character, Integer>();
            for (int i = 0; i < set.toCharArray().length; i++) {
                char c = set.toCharArray()[i];
                Integer num = cmap.get(c);
                if (num == null) {
                    num = 0;
                }
                num++;
                cmap.put(c, num);
            }
            double prob = multisetPermutationNum(cmap) / Math.pow(m - 1, n);
            result.put(set, prob);
        }
        return result;
    }

    private double multisetPermutationNum(Map<Character, Integer> cmap) {
        double niz = 1;
        int v = 0;
        for (Map.Entry<Character, Integer> entry : cmap.entrySet()) {
            niz *= factorial(entry.getValue());
            v += entry.getValue();
        }
        return factorial(v) / niz;
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private Set<String> generateSetFromTo(int from, int to, int length) {
        Set<String> result = new HashSet<String>();
        if (length == 1) {
            for (int i = from; i <= to; i++) {
                result.add(Integer.toString(i));
            }
        } else {
            for (int i = from; i <= to; i++) {
                Set<String> subset = generateSetFromTo(i, to, length - 1);
                for (String s : subset) {
                    result.add(i + s);
                }
            }
        }
        return result;
    }
}
