package projecteuler; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 14.02.14
 * Time: 22:44
 */

import java.util.*;

/**
 *
 * @author ashevenkov
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<int[]> nList = new ArrayList<>();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            nList.add(new int[] {n, a0});
        }
        Collections.sort(nList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        long[] results = solve(nList);
        Collections.sort(nList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int[] pair : nList) {
            System.out.println(results[pair[1]]);
        }
    }

    private static long[] solve(List<int[]> nList) {
        long[] result = new long[nList.size()];
        long sum3 = 0;
        long sum5 = 0;
        long sum15 = 0;
        long ni3 = 3;
        long ni5 = 5;
        long ni15 = 15;
        for (int[] nPair : nList) {
            int n = nPair[0];
            while(ni3 < n) {
                sum3 += ni3;
                ni3 += 3;
            }
            while(ni5 < n) {
                sum5 += ni5;
                ni5 += 5;
            }
            while(ni15 < n) {
                sum15 += ni15;
                ni15 += 15;
            }
            result[nPair[1]] = sum3 + sum5 - sum15;
        }
        return result;
    }

}
