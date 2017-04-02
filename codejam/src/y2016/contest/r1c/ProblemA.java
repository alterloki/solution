package y2016.contest.r1c;

import java.io.*;
import java.util.*;

/**
 * //TESTED
 * @author ashevenkov 30.04.16 18:49.
 */
public class ProblemA {

    public static final String TITLE = "A-large";
    private static BufferedReader in = prodIn();
    private static BufferedWriter out = prodOut();

    private static BufferedWriter prodOut() {
        try {
            return new BufferedWriter(new FileWriter("codejam/output/" + TITLE + ".out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedReader prodIn() {
        try {
            return new BufferedReader(new FileReader("codejam/input/" + TITLE + ".in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static BufferedWriter testOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader testIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new ProblemA().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for(int j = 0; j < n; j++) {
                p[j] = scanner.nextInt();
            }
            out.write("Case #" + (i + 1) + ": " + solveCase(n, p));
            out.newLine();
        }
    }

    private class Party {
        public int count;
        public char name;

        public Party(int count, char name) {
            this.count = count;
            this.name = name;
        }
    }

    private String solveCase(int n, int[] p) {
        List<Party> pl = new ArrayList<>();
        Map<Character, Party> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int cnt = p[i];
            Party party = new Party(cnt, (char) ('A' + i));
            pl.add(party);
            map.put(party.name, party);
        }
        Collections.sort(pl, new Comparator<Party>() {
            @Override
            public int compare(Party o1, Party o2) {
                return Integer.compare(o1.count, o2.count);
            }
        });
        StringBuilder result = new StringBuilder();
        //exit last
        if(pl.get(pl.size() - 1).count > pl.get(pl.size() - 2).count) {
            int amount = pl.get(pl.size() - 1).count - pl.get(pl.size() - 2).count;
            for(int i = 0; i < amount; i++) {
                exit(result, map, pl.get(pl.size() - 1).name);
            }
        }
        //exit all before 2
        for(int i = 0; i < pl.size() - 2; i++) {
            int amount = pl.get(i).count;
            for(int j = 0; j < amount; j++) {
                exit(result, map, pl.get(i).name);
            }
        }
        //exit pairs
        int amount = pl.get(pl.size() - 1).count;
        for(int i = 0; i < amount; i++) {
            exit(result, map, pl.get(pl.size() - 2).name, pl.get(pl.size() - 1).name);
        }
        return result.toString().substring(1);
    }

    private void exit(StringBuilder result, Map<Character, Party> map, char name) {
        Party party = map.get(name);
        party.count--;
        result.append(" ");
        result.append(name);
    }

    private void exit(StringBuilder result, Map<Character, Party> map, char name1, char name2) {
        Party party1 = map.get(name1);
        Party party2 = map.get(name2);
        party1.count--;
        party2.count--;
        result.append(" ");
        result.append(name1);
        result.append(name2);
    }


}
