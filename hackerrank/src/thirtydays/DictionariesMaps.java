package thirtydays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ashevenkov 03.04.17 17:26.
 */
public class DictionariesMaps {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            map.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            Integer phone = map.get(s);
            if(phone == null) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + phone.toString());
            }
        }
        in.close();
    }
}
