public class MergeTripletstoFormTargetTriplet {
    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxValues = new int[3];
        for (int[] tri : triplets) {
            if (tri[0] <= target[0] && tri[1] <= target[1] && tri[2] <= target[2]) {
                maxValues[0] = Math.max(maxValues[0], tri[0]);
                maxValues[1] = Math.max(maxValues[1], tri[1]);
                maxValues[2] = Math.max(maxValues[2], tri[2]);
            }
        }
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];
    }

    public static void main(String[] args) {
        int[][] triplets = {
                { 2, 5, 3 },
                { 1, 8, 4 },
                { 1, 7, 5 }
        };
        int[] target = { 2, 7, 5 };
        System.out.println(mergeTriplets(triplets, target));
    }

}
