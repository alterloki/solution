package srm203div2;
// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 


You are developing the matchmaking component of an online dating site. Prospective
members must fill out a questionnaire consisting of
binary questions such as Do you prefer to vacation (a)
in the mountains or (b) at the seaside? and Would you rather 
travel (a) by plane or (b) by train?




You are to match up men with women by maximizing the number of answers
each couple has in common. A man and a woman have an answer in common
whenever they give the same answer to the same question. Conflicts
can easily arise due to numerical ties,
but you will be able to resolve all such conflicts using 
the following procedure. Note that there will be equal numbers of men and
women, with names being unique in each sex.




Take the woman whose name comes earliest
in lexicographic order, and consider the men with whom she has the greatest number of
answers in common. Among these men, pick the one whose name comes earliest in lexicographic
order. You have found the woman's best match. Remove this couple from
the dating pool, and repeat the matching procedure until there are no
more singles left. 




You are given a String[], namesWomen, containing
the names of single women, and another String[],
answersWomen, containing their answers. The kth
element of answersWomen lists the answers of the woman whose name
is the kth element of namesWomen. If there are n
questions in the questionnaire, then every element of answersWomen
consists of n characters, each of which is either 'a' or 
'b'. The answers are always given in the fixed questionnaire order. You
are similarly given the String[]s namesMen and
answersMen for the single men. Lastly, you are given
a String, queryWoman, containing the name of a woman.
Return the name of the man to whom she is matched after you have formed
all couples according to the above rules.




DEFINITION
Class:MatchMaking
Method:makeMatch
Parameters:String[], String[], String[], String[], String
Returns:String
Method signature:String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman)


NOTES
-Lexicographic order is like dictionary order, with the difference that case matters. All uppercase letters take precedence over all lowercase letters. Thus, "boolean" comes before "boot"; "boo" comes before "boolean"; "Boot" comes before "boo"; "Zoo" comes before "boo".


CONSTRAINTS
-namesWomen contains between 1 and 50 elements, inclusive
-if namesWomen consists of n elements, then answersWomen, namesMen, and answersMen consist of n elements each
-each element of namesWomen and each element of namesMen is between 1 and 50 characters long, inclusive
-the only characters that may appear in namesMen and namesWomen are 'a' to 'z' and 'A' to 'Z'
-no two elements of namesWomen are alike
-no two elements of namesMen are alike
-the first element of answersWomen is between 1 and 50 characters long, inclusive
-if the first element of answersWomen consists of m characters, then each element of answersWomen and of answersMen is m characters long
-the only characters that may appear in answersWomen and answersMen are 'a' and 'b'
-queryWoman is one of the Strings in namesWomen


EXAMPLES

0)
{"Constance", "Bertha", "Alice"}
{"aaba", "baab", "aaaa"}
{"Chip", "Biff", "Abe"}
{"bbaa", "baaa", "aaab"}
"Bertha"

Returns: "Biff"

Alice has two answers in common with Chip and three answers in common with both Abe and Biff; Abe gets lexicographic preference. Bertha also has two answers in common with Chip and three answers in common with both Abe and Biff. Since Abe has already been matched to Alice, Bertha lands Biff.

1)
{"Constance", "Bertha", "Alice"}
{"aaba", "baab", "aaaa"}
{"Chip", "Biff", "Abe"}
{"bbaa", "baaa", "aaab"}
"Constance"

Returns: "Chip"

We are dealing with the same names and answers as before. Constance is the last to go. Although she has two answers in common with Abe and Biff, they are both taken. She ends up with Chip, with whom she has only one answer in common.

2)
{"Constance", "Alice", "Bertha", "Delilah", "Emily"}
{"baabaa", "ababab", "aaabbb", "bababa", "baabba"}
{"Ed", "Duff", "Chip", "Abe", "Biff"}
{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"}
"Constance"

Returns: "Duff"

3)
{"Constance", "Alice", "Bertha", "Delilah", "Emily"}
{"baabaa", "ababab", "aaabbb", "bababa", "baabba"}
{"Ed", "Duff", "Chip", "Abe", "Biff"}
{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"}
"Delilah"

Returns: "Chip"

4)
{"Constance", "Alice", "Bertha", "Delilah", "Emily"}
{"baabaa", "ababab", "aaabbb", "bababa", "baabba"}
{"Ed", "Duff", "Chip", "Abe", "Biff"}
{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"}
"Emily"

Returns: "Ed"

5)
{"anne", "Zoe"}
{"a", "a"}
{"bob", "chuck"}
{"a", "a"}
"Zoe"

Returns: "bob"

6)
{"F", "M", "S", "h", "q", "g", "r", "N", "U", "x", "H", "P",
 "o", "E", "R", "z", "L", "m", "e", "u", "K", "A", "w", "Q",
 "O", "v", "j", "a", "t", "p", "C", "G", "k", "c", "V", "B",
 "D", "s", "n", "i", "f", "T", "I", "l", "d", "J", "y", "b"}
{"abaabbbb", "bbaabbbb", "aaabaaab", "aabbaaaa", "baabbaab",
 "aaababba", "bbabbbbb", "bbbabbba", "aaabbbba", "aabbbaaa",
 "abbabaaa", "babbabbb", "aaaaabba", "aaaabbaa", "abbbabaa",
 "babababa", "abbaaaaa", "bbababba", "baaaaaba", "baaaaabb",
 "bbbbabba", "ababbaaa", "abbbabab", "baabbbaa", "bbbaabbb",
 "aababbab", "ababbabb", "abbaabba", "baabbabb", "aaabaaab",
 "aabbbaba", "aabaaabb", "abababba", "aabbaaaa", "aabbabaa",
 "bababaaa", "aabaaaab", "bbbbaabb", "baaababb", "abaabbab",
 "aabbbaaa", "baabbaba", "bbabbbaa", "aabbbbaa", "abbbaaab",
 "abababbb", "ababaaba", "bababaaa"}
{"f", "C", "v", "g", "Q", "z", "n", "c", "B", "o", "M", "F",
 "u", "x", "I", "T", "K", "L", "E", "U", "w", "A", "d", "t",
 "e", "R", "D", "s", "p", "q", "m", "r", "H", "j", "J", "V",
 "l", "a", "k", "h", "G", "y", "i", "P", "O", "N", "b", "S"}
{"bbbaabab", "bbabaabb", "ababbbbb", "bbbababb", "baababaa",
 "bbaaabab", "abbabbaa", "bbbabbbb", "aabbabab", "abbababa",
 "aababbbb", "bababaab", "aaababbb", "baabbaba", "abaaaaab",
 "bbaababa", "babaabab", "abbabbba", "ababbbab", "baabbbab",
 "babbaaab", "abbbbaba", "bbabbbba", "baaabaab", "ababbabb",
 "abbbaabb", "bbbbaabb", "bbbaaabb", "baabbaba", "bbabaaab",
 "aabbbaab", "abbbbabb", "bbaaaaba", "bbbababa", "abbaabba",
 "bababbbb", "aabaaabb", "babbabab", "baaaabaa", "ababbaba",
 "aaabaabb", "bbaaabaa", "baaaaabb", "bbaabaab", "bbababab",
 "aabaaaab", "aaaaabab", "aabbaaba"}
"U"

Returns: "x"

7)
{"q", "M", "w", "y", "p", "N", "s", "r", "a", "H", "o", "n",
 "F", "m", "l", "b", "D", "j", "C", "u", "f", "I", "g", "L",
 "i", "x", "A", "G", "O", "k", "h", "d", "c", "E", "B", "v",
 "J", "z", "K", "e", "t"}
{"aabbaaabb", "baabababb", "bbaababba", "bbbaaaaaa", "abaaaabaa",
 "bababbbab", "abbaabbaa", "aabababbb", "bababaaaa", "abbababaa",
 "aabbbbbba", "bbabbabab", "babaabbba", "babbabbbb", "baaabbbbb",
 "baaabaaaa", "aaabbaaab", "abbaabbbb", "abbabbbab", "bbaaaabba",
 "babbaaabb", "aabbabbab", "baaababba", "ababaabab", "bbbaabbab",
 "aaaabbabb", "babaaaaaa", "abbbbaaab", "aabaaabba", "bbbaaaaba",
 "bbbbbbaab", "aabbaaabb", "aabaabbab", "aababaaba", "bbabbbbab",
 "abbabaaab", "babaaabbb", "bababbaaa", "aabbaabaa", "baaabbabb",
 "bbbbbbbbb"}
{"m", "k", "n", "q", "L", "E", "M", "l", "w", "x", "g", "e",
 "i", "z", "F", "r", "a", "h", "f", "D", "J", "K", "j", "v",
 "A", "t", "N", "y", "s", "c", "o", "p", "d", "b", "B", "G",
 "O", "I", "u", "C", "H"}
{"bbaaabbba", "bbaaaaaab", "abaaababb", "baaaabbbb", "abbbababa",
 "baaaaaaaa", "aabbbbbab", "aaaaabbba", "baabababb", "babaaabab",
 "baaababaa", "bbbbaabba", "bbaabbabb", "bbaaababb", "abbabbaba",
 "aababaaab", "abbbbbbaa", "aabbaabaa", "bbbaabbba", "abbabbaba",
 "aaabbbaaa", "bbaabaaaa", "aabababbb", "abbbbabab", "baaabbbba",
 "bababbbba", "aababbaab", "bbaabbaab", "bbbaaabbb", "babbbbabb",
 "ababababb", "babaaabab", "bbaaaaaba", "aaaaabaaa", "abbaaabbb",
 "bbbbababb", "baabababb", "bbaabaaaa", "aaababbbb", "abbbbbbba",
 "bbaabbaaa"}
"o"

Returns: "C"

*/
// END CUT HERE

import java.util.*;

//TESTED
public class MatchMaking {
    public String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman) {
        String res = "";
        SortedMap<String, Integer> womens = new TreeMap<>();
        for (int i = 0; i < namesWomen.length; i++) {
            String s = namesWomen[i];
            womens.put(s, i);
        }
        Set<String> removedMen = new HashSet<>();
        for (Map.Entry<String, Integer> entry : womens.entrySet()) {
            String womanAnswer = answersWomen[entry.getValue()];
            int min = answersWomen[0].length();
            int[] diffs = new int[answersMen.length];
            for (int i = 0; i < answersMen.length; i++) {
                String menAnswer = answersMen[i];
                if (!removedMen.contains(namesMen[i])) {
                    int curDiff = answerDiff(womanAnswer, menAnswer);
                    diffs[i] = curDiff;
                    if (min > curDiff) {
                        min = curDiff;
                    }
                }
            }
            SortedSet<String> minMenNames = new TreeSet<>();
            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                if (diff == min && !removedMen.contains(namesMen[i])) {
                    minMenNames.add(namesMen[i]);
                }
            }
            String menPair = minMenNames.iterator().next();
            removedMen.add(menPair);
            if (entry.getKey().equals(queryWoman)) {
                return menPair;
            }
        }
        return res;
    }

    private int answerDiff(String womanAnswer, String menAnswer) {
        int count = 0;
        char[] wca = womanAnswer.toCharArray();
        char[] mca = menAnswer.toCharArray();
        for (int i = 0; i < wca.length; i++) {
            if (wca[i] != mca[i]) {
                count++;
            }
        }
        return count;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new MatchMaking()).makeMatch(new String[]{"Constance", "Bertha", "Alice"}, new String[]{"aaba", "baab", "aaaa"}, new String[]{"Chip", "Biff", "Abe"}, new String[]{"bbaa", "baaa", "aaab"}, "Bertha"), "Biff");
            eq(1, (new MatchMaking()).makeMatch(new String[]{"Constance", "Bertha", "Alice"}, new String[]{"aaba", "baab", "aaaa"}, new String[]{"Chip", "Biff", "Abe"}, new String[]{"bbaa", "baaa", "aaab"}, "Constance"), "Chip");
            eq(2, (new MatchMaking()).makeMatch(new String[]{"Constance", "Alice", "Bertha", "Delilah", "Emily"}, new String[]{"baabaa", "ababab", "aaabbb", "bababa", "baabba"}, new String[]{"Ed", "Duff", "Chip", "Abe", "Biff"}, new String[]{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"}, "Constance"), "Duff");
            eq(3, (new MatchMaking()).makeMatch(new String[]{"Constance", "Alice", "Bertha", "Delilah", "Emily"}, new String[]{"baabaa", "ababab", "aaabbb", "bababa", "baabba"}, new String[]{"Ed", "Duff", "Chip", "Abe", "Biff"}, new String[]{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"}, "Delilah"), "Chip");
            eq(4, (new MatchMaking()).makeMatch(new String[]{"Constance", "Alice", "Bertha", "Delilah", "Emily"}, new String[]{"baabaa", "ababab", "aaabbb", "bababa", "baabba"}, new String[]{"Ed", "Duff", "Chip", "Abe", "Biff"}, new String[]{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"}, "Emily"), "Ed");
            eq(5, (new MatchMaking()).makeMatch(new String[]{"anne", "Zoe"}, new String[]{"a", "a"}, new String[]{"bob", "chuck"}, new String[]{"a", "a"}, "Zoe"), "bob");
            eq(6, (new MatchMaking()).makeMatch(new String[]{"F", "M", "S", "h", "q", "g", "r", "N", "U", "x", "H", "P",
                    "o", "E", "R", "z", "L", "m", "e", "u", "K", "A", "w", "Q",
                    "O", "v", "j", "a", "t", "p", "C", "G", "k", "c", "V", "B",
                    "D", "s", "n", "i", "f", "T", "I", "l", "d", "J", "y", "b"}, new String[]{"abaabbbb", "bbaabbbb", "aaabaaab", "aabbaaaa", "baabbaab",
                    "aaababba", "bbabbbbb", "bbbabbba", "aaabbbba", "aabbbaaa",
                    "abbabaaa", "babbabbb", "aaaaabba", "aaaabbaa", "abbbabaa",
                    "babababa", "abbaaaaa", "bbababba", "baaaaaba", "baaaaabb",
                    "bbbbabba", "ababbaaa", "abbbabab", "baabbbaa", "bbbaabbb",
                    "aababbab", "ababbabb", "abbaabba", "baabbabb", "aaabaaab",
                    "aabbbaba", "aabaaabb", "abababba", "aabbaaaa", "aabbabaa",
                    "bababaaa", "aabaaaab", "bbbbaabb", "baaababb", "abaabbab",
                    "aabbbaaa", "baabbaba", "bbabbbaa", "aabbbbaa", "abbbaaab",
                    "abababbb", "ababaaba", "bababaaa"}, new String[]{"f", "C", "v", "g", "Q", "z", "n", "c", "B", "o", "M", "F",
                    "u", "x", "I", "T", "K", "L", "E", "U", "w", "A", "d", "t",
                    "e", "R", "D", "s", "p", "q", "m", "r", "H", "j", "J", "V",
                    "l", "a", "k", "h", "G", "y", "i", "P", "O", "N", "b", "S"}, new String[]{"bbbaabab", "bbabaabb", "ababbbbb", "bbbababb", "baababaa",
                    "bbaaabab", "abbabbaa", "bbbabbbb", "aabbabab", "abbababa",
                    "aababbbb", "bababaab", "aaababbb", "baabbaba", "abaaaaab",
                    "bbaababa", "babaabab", "abbabbba", "ababbbab", "baabbbab",
                    "babbaaab", "abbbbaba", "bbabbbba", "baaabaab", "ababbabb",
                    "abbbaabb", "bbbbaabb", "bbbaaabb", "baabbaba", "bbabaaab",
                    "aabbbaab", "abbbbabb", "bbaaaaba", "bbbababa", "abbaabba",
                    "bababbbb", "aabaaabb", "babbabab", "baaaabaa", "ababbaba",
                    "aaabaabb", "bbaaabaa", "baaaaabb", "bbaabaab", "bbababab",
                    "aabaaaab", "aaaaabab", "aabbaaba"}, "U"), "x");
            eq(7, (new MatchMaking()).makeMatch(new String[]{"q", "M", "w", "y", "p", "N", "s", "r", "a", "H", "o", "n",
                    "F", "m", "l", "b", "D", "j", "C", "u", "f", "I", "g", "L",
                    "i", "x", "A", "G", "O", "k", "h", "d", "c", "E", "B", "v",
                    "J", "z", "K", "e", "t"}, new String[]{"aabbaaabb", "baabababb", "bbaababba", "bbbaaaaaa", "abaaaabaa",
                    "bababbbab", "abbaabbaa", "aabababbb", "bababaaaa", "abbababaa",
                    "aabbbbbba", "bbabbabab", "babaabbba", "babbabbbb", "baaabbbbb",
                    "baaabaaaa", "aaabbaaab", "abbaabbbb", "abbabbbab", "bbaaaabba",
                    "babbaaabb", "aabbabbab", "baaababba", "ababaabab", "bbbaabbab",
                    "aaaabbabb", "babaaaaaa", "abbbbaaab", "aabaaabba", "bbbaaaaba",
                    "bbbbbbaab", "aabbaaabb", "aabaabbab", "aababaaba", "bbabbbbab",
                    "abbabaaab", "babaaabbb", "bababbaaa", "aabbaabaa", "baaabbabb",
                    "bbbbbbbbb"}, new String[]{"m", "k", "n", "q", "L", "E", "M", "l", "w", "x", "g", "e",
                    "i", "z", "F", "r", "a", "h", "f", "D", "J", "K", "j", "v",
                    "A", "t", "N", "y", "s", "c", "o", "p", "d", "b", "B", "G",
                    "O", "I", "u", "C", "H"}, new String[]{"bbaaabbba", "bbaaaaaab", "abaaababb", "baaaabbbb", "abbbababa",
                    "baaaaaaaa", "aabbbbbab", "aaaaabbba", "baabababb", "babaaabab",
                    "baaababaa", "bbbbaabba", "bbaabbabb", "bbaaababb", "abbabbaba",
                    "aababaaab", "abbbbbbaa", "aabbaabaa", "bbbaabbba", "abbabbaba",
                    "aaabbbaaa", "bbaabaaaa", "aabababbb", "abbbbabab", "baaabbbba",
                    "bababbbba", "aababbaab", "bbaabbaab", "bbbaaabbb", "babbbbabb",
                    "ababababb", "babaaabab", "bbaaaaaba", "aaaaabaaa", "abbaaabbb",
                    "bbbbababb", "baabababb", "bbaabaaaa", "aaababbbb", "abbbbbbba",
                    "bbaabbaaa"}, "o"), "C");
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, char a, char b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
    }

    private static void eq(int n, long a, long b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b))
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(int a) {
        System.err.print(a + " ");
    }

    private static void print(long a) {
        System.err.print(a + "L ");
    }

    private static void print(String s) {
        System.err.print("\"" + s + "\" ");
    }

    private static void print(int[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
