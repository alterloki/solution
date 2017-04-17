package thirtydays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * @author ashevenkov 06.04.17 11:19.
 */
public class CellTest {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/Users/ashevenkov/Downloads/tyres.tsv"));
        Map<Integer, Set<Integer>> shop2modelSet = new HashMap<>();
        Map<Integer, Set<Integer>> model2shopsSet = new HashMap<>();
        int modelsCount = model2shopsSet.size();
        br.readLine();
        String line = br.readLine();
        while(line != null) {
            String[] parts = line.split("\t");
            int modelId = Integer.parseInt(parts[0]);
            int shopId = Integer.parseInt(parts[1]);
            Set<Integer> modelSet = shop2modelSet.get(shopId);
            if(modelSet == null) {
                modelSet = new HashSet<>();
                shop2modelSet.put(shopId, modelSet);
            }
            Set<Integer> shopSet = model2shopsSet.get(modelId);
            if(shopSet == null) {
                shopSet = new HashSet<>();
                model2shopsSet.put(modelId, shopSet);
            }
            shopSet.add(shopId);
            modelSet.add(modelId);
            line = br.readLine();
        }
        System.out.println("Shops count = " + shop2modelSet.size());
        Set<Integer> set = new HashSet<>();
        for (Set<Integer> integers : shop2modelSet.values()) {
            set.addAll(integers);
        }
        System.out.println("Models count = " + set.size());
        Set<Integer> shops = new HashSet<>(shop2modelSet.keySet());
        Iterator<Integer> iterator = shops.iterator();
        while (iterator.hasNext()) {
            Integer shopId = iterator.next();
            boolean un = removeUnecessary(shopId, shop2modelSet, model2shopsSet);
            if(un)
            {
                System.out.println("Removing shop = " + shopId);
                iterator.remove();
                shop2modelSet.remove(shopId);
                for (Set<Integer> shopSet : model2shopsSet.values()) {
                    shopSet.remove(shopId);
                }
            }
        }
        System.out.println("Necessary shops 1 = " + shop2modelSet.size());
        Set<Integer> models = new HashSet<>(model2shopsSet.keySet());
        iterator = models.iterator();
        Set<Integer> modelsFrom = new HashSet<>();
        Set<Integer> uniqShops = new HashSet<>();
        while (iterator.hasNext()) {
            Integer modelId = iterator.next();
            Set<Integer> modelShops = model2shopsSet.get(modelId);
            if(modelShops.size() == 1) {
                modelsFrom.addAll(shop2modelSet.get(modelShops.iterator().next()));
                uniqShops.add(modelShops.iterator().next());
            }
        }
        System.out.println("Necessary models = " + modelsFrom.size() + " their shops = " + uniqShops.size());
    }

    private static boolean removeUnecessary(Integer shopId, Map<Integer, Set<Integer>> shop2modelSet) {

        return false;
    }

    private static boolean removeUnecessary(Integer shopId, Map<Integer, Set<Integer>> shop2modelSet,
                                         Map<Integer, Set<Integer>> model2shopsSet) {
        Set<Integer> models = shop2modelSet.get(shopId);
        Set<Integer> interception = model2shopsSet.get(models.iterator().next());
        for (Integer model : models) {
            Set<Integer> shops = model2shopsSet.get(model);
            interception.retainAll(shops);
        }
        if(interception.size() > 1) {
            return true;
        }
        return false;
    }
}
