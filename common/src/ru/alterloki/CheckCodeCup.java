/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 25.04.14
 * Time: 0:10
 */
package ru.alterloki;

import ru.Check;
import ru.ifmo.testlib.Outcome;
import ru.ifmo.testlib.io.InputInStream;
import y2014.r1.ProblemB;
import y2014.r1.ProblemC;

import java.io.*;

/**
 * @author ashevenkov
 */
public class CheckCodeCup {

    public static void main(String[] args) throws IOException {
        //checkByFile("/home/ashevenkov/projects/solution/russian_code_cup_2014_qual1/timer/tests/");
        checkByChecker("/home/ashevenkov/projects/solution/russian_code_cup_2014_qual1/antilis/tests/", new Check());
    }

    private static void checkByChecker(String dir, Check check) throws IOException {
        File[] files = new File(dir).listFiles();
        for (int i = 1; i <= files.length / 2; i++) {
            String filename = i < 10 ? "0" + i : String.valueOf(i);
            String inFile = dir + filename;
            String answerFile = dir + filename + ".a";
            String myAnswerFile = dir + filename + ".my";
            BufferedOutputStream myBos = new BufferedOutputStream(new FileOutputStream(myAnswerFile));
            BufferedInputStream inBis = new BufferedInputStream(new FileInputStream(inFile));
            //RUN
            PrintStream oldOut = System.out;
            System.setOut(new PrintStream(myBos));
            new ProblemC().fire(inBis);
            //output
            myBos.flush();
            Outcome test = check.test(new InputInStream(new File(inFile)), new InputInStream(new File(myAnswerFile)), new InputInStream(new File(answerFile)));
            System.setOut(oldOut);
            System.out.println(test.getType() + " " + test.getComment());
        }
    }

    private static void checkByFile(String dir) throws IOException {
        File[] files = new File(dir).listFiles();
        for (int i = 1; i <= files.length / 2; i++) {
            String filename = i < 10 ? "0" + i : String.valueOf(i);
            String inFile = dir + filename;
            //RUN
            PrintStream oldOut = System.out;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(bos);
            System.setOut(new PrintStream(out));
            new ProblemB().fire(new FileInputStream(inFile));
            //output
            out.flush();
            byte[] result = bos.toByteArray();
            String myResult = new String(result);
            String outFile = dir + filename + ".a";
            String checkResult = readFile(outFile);
            System.setOut(oldOut);
            System.out.println("Test = " + i + " result = " + compare(myResult, checkResult));
        }

    }

    private static boolean compare(String myResult, String checkResult) {
        String[] p1 = myResult.split("\n");
        String[] p2 = checkResult.split("\n");
        for (int i = 0; i < p1.length; i++) {
            if (!p1[i].equals(p2[i])) {
                System.out.println("ERROR:" + i + " my = " + p1[i] + " check = " + p2[i]);
                return false;
            }
        }
        return true;
    }

    private static String readFile(String inFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        sb.append(line);
        while (line != null) {
            sb.append("\n");
            line = br.readLine();
            if (line != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
