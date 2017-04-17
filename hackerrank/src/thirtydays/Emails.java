package thirtydays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ashevenkov 08.04.17 22:21.
 */
public class Emails {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        List<String> names = new ArrayList<>();
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            Matcher matcher = pattern.matcher(emailID);
            if(matcher.matches()) {
                names.add(firstName);
            }
        }
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
