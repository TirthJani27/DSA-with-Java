public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalGas = 0;
        for (int i = 0; i < cost.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }
        int ans = -1;
        
        return ans;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
