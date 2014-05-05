// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Shiny has a company.
There are N employees in her company.
The employees are numbered 0 through N-1 in order in which they joined the company.



Employee 0 is the only employee with no boss.
Every other employee has precisely one direct boss in the company.
You are given a int[] superior with N elements.
Element 0 of superior will be -1 to denote that employee 0 has no boss.
For each i between 1 and N-1, inclusive, element i of superior will be the number of the boss of employee i.



For each employee, their boss joined the company before them.
Formally, for each i between 1 and N-1, inclusive, superior[i] will be between 0 and i-1, inclusive.



Each employee only does one type of work.
You are given a int[] workType with N elements.
(Different integers represent different types of work.)



Each employee of the company has their own department.
The department of employee x is formed by employee x and all the employees such that x is their boss.
Formally, for any y different from x, employee y belongs into the department of employee x if and only if superior[y]=x.
Note that if superior[z]=y and superior[y]=x, employee z does not belong into the department of employee x.



A department is called diverse if no two employees in the department do the same type of work.
Compute and return the number of diverse departments in Shiny's company.


DEFINITION
Class:GoodCompanyDivTwo
Method:countGood
Parameters:int[], int[]
Returns:int
Method signature:int countGood(int[] superior, int[] workType)


CONSTRAINTS
-superior will contain between 1 and 100 elements, inclusive.
-workType will contain the same number of elements as superior.
-Each element of workType will be between 1 and 100, inclusive.
-superior[0] will be -1.
-For each valid i>0, superior[i] will be between 0 and i-1, inclusive.


EXAMPLES

0)
{-1, 0}
{1, 2}

Returns: 2

The department of employee 0 contains employees 0 and 1.
The department of employee 1 contains employee 1 only.
Both departments are diverse.

1)
{-1, 0}
{1, 1}

Returns: 1

The departments are the same as in Example 0.
However, now the department of employee 0 is not diverse: it contains two employees who do the same type of work.
Only the department of employee 1 is now diverse.

2)
{-1, 0, 1, 1}
{1, 4, 3, 2}

Returns: 4

Note that in this test case the department of employee 0 contains only employees 0 and 1. Employees 2 and 3 do not belong into the department of employee 0.

3)
{-1, 0, 1, 0, 0}
{3, 3, 5, 2, 2}

Returns: 4



4)
{-1, 0, 1, 1, 1, 0, 2, 5}
{1, 1, 2, 3, 4, 5, 3, 3}

Returns: 7



5)
{-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4}
{4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8}

Returns: 27



*/
// END CUT HERE

import java.util.*;

public class GoodCompanyDivTwo {
    public int countGood(int[] superior, int[] workType) {
        int res = 0;
        Map<Integer, List<Integer>> superiorEmployees = new HashMap<Integer, List<Integer>>();
        for(int empId = 1; empId < superior.length; empId++) {
            int supId = superior[empId];
            List<Integer> empList = superiorEmployees.get(supId);
            if(empList == null) {
                empList = new ArrayList<Integer>();
                superiorEmployees.put(supId, empList);
            }
            empList.add(empId);
        }
        for(int i = 0; i < superior.length; i++) {
            if(!superiorEmployees.containsKey(i)) {
                superiorEmployees.put(i, new ArrayList<Integer>());
            }
        }
        int notDiverse = 0;
        for(Map.Entry<Integer, List<Integer>> entry : superiorEmployees.entrySet()) {
            Integer supId = entry.getKey();
            List<Integer> employees = entry.getValue();
            Set<Integer> works = new HashSet<Integer>();
            works.add(workType[supId]);
            for(Integer employee : employees) {
                int eWork = workType[employee];
                if(works.contains(eWork)) {
                    notDiverse++;
                    break;
                } else {
                    works.add(eWork);
                }
            }
        }
        res = superiorEmployees.size() - notDiverse;
        return res;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new GoodCompanyDivTwo()).countGood(new int[]{-1, 0}, new int[]{1, 2}), 2);
            eq(1, (new GoodCompanyDivTwo()).countGood(new int[]{-1, 0}, new int[]{1, 1}), 1);
            eq(2, (new GoodCompanyDivTwo()).countGood(new int[]{-1, 0, 1, 1}, new int[]{1, 4, 3, 2}), 4);
            eq(3, (new GoodCompanyDivTwo()).countGood(new int[]{-1, 0, 1, 0, 0}, new int[]{3, 3, 5, 2, 2}), 4);
            eq(4, (new GoodCompanyDivTwo()).countGood(new int[]{-1, 0, 1, 1, 1, 0, 2, 5}, new int[]{1, 1, 2, 3, 4, 5, 3, 3}), 7);
            eq(5, (new GoodCompanyDivTwo()).countGood(new int[]{-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4}, new int[]{4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8}), 27);
        } catch(Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, char a, char b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
    }

    private static void eq(int n, long a, long b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
    }

    private static void eq(int n, boolean a, boolean b) {
        if(a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, String a, String b) {
        if(a != null && a.equals(b))
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
    }

    private static void eq(int n, int[] a, int[] b) {
        if(a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if(a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if(a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for(int i = 0; i < a.length; i++)
            if(!a[i].equals(b[i])) {
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
        if(rs == null) return;
        System.err.print('{');
        for(int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if(i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if(rs == null) return;
        System.err.print('{');
        for(int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if(i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if(rs == null) return;
        System.err.print('{');
        for(int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if(i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
