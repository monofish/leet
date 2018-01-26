import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 134 Gas Station
 * <p/>
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * <p/>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p/>
 * Note:
 * The solution is guaranteed to be unique.
 *
 * @author Wei
 * @since 12/7/16
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n != cost.length) System.err.println("Input length ERROR!");
        int tank = 0;
        int index = 0;
        for (int j = 0; j < n; j++) {
            int i = j;
            tank = 0;
            do {
                tank = tank + gas[i] - cost[i];
                if (tank < 0) break;

                i++;
                if (i >= n) i = 0;
            } while (i != j);
            if (tank >= 0) {
                index = j;
                break;
            }
        }
        if (tank < 0) return -1;
        else return index;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        if (n != cost.length) System.err.println("Input length ERROR!");

        int start = 0;
        int end = 0;
        int tank = 0;
        do {
            if(tank >=0) {
                tank += gas[end] - cost[end];
                end++;
                if (end >= n) end = 0;
            } else {
                start--;
                if (start < 0) start = n - 1;
                tank += gas[start] - cost[start];
            }
        } while (start != end);

        if (tank >= 0) return start;
        else return -1;
    }

    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int n = gas.length;
        if (n != cost.length) System.err.println("Input length ERROR!");

        int tank = 0;
        int prevSum = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                prevSum = tank;
                tank = 0;
                index = i + 1;
            }
        }

        if (tank + prevSum >= 0) return index;
        else return -1;
    }

    public boolean isResultCorrect(int[] gas, int[] cost, int index) {
        // Verify the result:
        int tank = 0;
        int i = index;
        int N = gas.length;
        do {
            tank = tank + gas[i] - cost[i];
            System.out.println(i + ":\t" + tank);
            if (tank < 0) return false;

            i++;
            if (i >= N) i = 0;
        } while (i != index);
        return true;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{3, 2, 5, 1, 4};
        int[] cost = new int[]{3, 4, 2, 5, 1};

        GasStation obj = new GasStation();
        int index = obj.canCompleteCircuit3(gas, cost);

        if (index == -1) System.out.println("NO solution.");
        else System.out.println("You " + (obj.isResultCorrect(gas, cost, index) ? "can" : "CANNOT") + " travel around the circuit from Gas Station " + index + ".");
    }
}
