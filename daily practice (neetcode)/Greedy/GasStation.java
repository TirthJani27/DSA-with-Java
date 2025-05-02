public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumCost += cost[i];
            sumGas += gas[i];
        }
        if (sumCost > sumGas) {
            return -1;
        }
        int total = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] gas = { 5, 1, 2, 3, 4 };
        int[] cost = { 4, 4, 1, 5, 1 };
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
