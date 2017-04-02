/**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 25.10.14
 * Time: 19:52
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author ashevenkov
 */
public class TravellingPlan {

    private static class Bus {
        private int stationFrom, timeFrom, stationTo, timeTo;
        private int time = Integer.MAX_VALUE;

        private Bus(int stationFrom, int stationTo, int timeFrom, int timeTo) {
            this.stationFrom = stationFrom;//from station
            this.timeFrom = timeFrom;//from time
            this.stationTo = stationTo;//to station
            this.timeTo = timeTo;//to time
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String[] parts = firstLine.split(" ");
        int n = Integer.parseInt(parts[0]);
        int t = Integer.parseInt(parts[1]);
        int m = Integer.parseInt(parts[2]);
        Map<Integer, List<Bus>> routes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            parts = line.split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            int e = Integer.parseInt(parts[3]);
            Bus bus = new Bus(u, v, s, e);
            List<Bus> uRoutes = routes.get(u);
            if (uRoutes == null) {
                uRoutes = new ArrayList<>();
                routes.put(u, uRoutes);
            }
            uRoutes.add(bus);
        }
        int result = new TravellingPlan().solve(n, t, m, routes);
        System.out.println(result);
    }

    private int solve(int n, int t, int m, Map<Integer, List<Bus>> routes) {
        Map<Bus, List<Bus>> realRoutes = new HashMap<>();
        Bus start = new Bus(-1, -1, 1, 0);
        start.time = 0;
        realRoutes.put(start, new ArrayList<Bus>());
        for (Map.Entry<Integer, List<Bus>> entry : routes.entrySet()) {
            List<Bus> buses = entry.getValue();
            for (Bus bus : buses) {
                if (bus.stationFrom == 1) {
                    realRoutes.get(start).add(bus);
                }
                ArrayList<Bus> list = new ArrayList<>();
                realRoutes.put(bus, list);
                List<Bus> tos = routes.get(bus.stationTo);
                if (tos != null) {
                    for (Bus to : tos) {
                        if (to.timeFrom >= bus.timeTo) {
                            list.add(to);
                        }
                    }
                }
            }
        }
        int minWaitTime = Integer.MAX_VALUE;
        Queue<Bus> queue = new LinkedList<>();
        queue.add(start);
        while (queue.size() > 0) {
            Bus bus = queue.remove();
            List<Bus> buses = realRoutes.get(bus);
            for (Bus dest : buses) {
                int curTime = dest.timeFrom - bus.timeTo;
                dest.time = Math.min(dest.time, Math.max(bus.time, curTime));
                if (dest.stationTo == n) {
                    if (bus.timeTo <= t && minWaitTime > dest.time) {
                        minWaitTime = dest.time;
                    }
                } else if (bus.timeTo <= t) {
                    queue.add(dest);
                }
            }
        }
        return minWaitTime == Integer.MAX_VALUE ? -1 : minWaitTime;
    }
}
