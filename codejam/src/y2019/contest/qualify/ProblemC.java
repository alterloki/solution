package y2019.contest.qualify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * @author ashevenkov 08.04.17 10:42.
 */
public class ProblemC {

    private static BufferedReader in = testIn();
    private static BufferedWriter out = testOut();

    private static BufferedWriter testOut() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader testIn() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        new ProblemC().solve(in, out);
        out.flush();
        out.close();
    }

    //implement
    private void solve(BufferedReader in, BufferedWriter out) throws Exception {
        Scanner scanner = new Scanner(in);
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            BigInteger n = new BigInteger(scanner.next());
            int l = scanner.nextInt();
            BigInteger[] input = new BigInteger[l];
            for(int j = 0; j < l; j++) {
                input[j] = new BigInteger(scanner.next());
            }
            String result = solveCase(l, input);
            out.write("Case #" + (i + 1) + ": " + result + "\n");
        }
    }

    private String solveCase(int l, BigInteger[] input) {
        BigInteger[] primes = new BigInteger[l + 1];
        int base = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if(!input[i].equals(input[i + 1])) {
                primes[i + 1] = gcd(input[i], input[i + 1]);
                base = i + 1;
                break;
            }
        }
        for(int i = base; i < input.length; i++) {
            primes[i + 1] = input[i].divide(primes[i]);
        }
        for(int i = base - 1; i >= 0; i--) {
            primes[i] = input[i].divide(primes[i + 1]);
        }
        Set<BigInteger> uniqPrimes = new HashSet<>(Arrays.asList(primes));
        BigInteger[] alphabet = new BigInteger[uniqPrimes.size()];
        int counter = 0;
        for (BigInteger uniqPrime : uniqPrimes) {
            alphabet[counter++] = uniqPrime;
        }
        Arrays.sort(alphabet);
        Map<BigInteger, Character> alphabetMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetMap.put(alphabet[i], (char)('A' + i));
        }
        StringBuilder result = new StringBuilder();
        for (BigInteger prime : primes) {
            result.append(alphabetMap.get(prime));
        }
        return result.toString();
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) return a;
        return gcd(b, a.remainder(b));
    }

}