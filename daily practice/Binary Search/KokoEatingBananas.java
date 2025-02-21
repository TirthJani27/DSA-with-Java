
import java.util.*;

class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int ans = 1;
        int time = 0;
        Arrays.sort(piles);
        for (int i = 0; i < piles.length / 2; i++) {
            int temp = piles[i];
            piles[i] = piles[piles.length - i - 1];
            piles[piles.length - i - 1] = temp;
        }
        
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] / ans;
            if(time > h){
                break;
            }
        }
        while (time > h) {
            time = 0;
            ans+=1;
            for (int i = 0; i < piles.length; i++) {
                time += Math.ceilDiv(piles[i] , ans);
                if(time > h){
                    break;
                }
               
            }
        }
        return ans;
    }


    public int minEatingSpeedOptimal(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        
        while (l <= r) {
            int mid = (l + r) / 2;
            int totalHours = 0;
            
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            
            if (totalHours > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }

    public static void main(String[] args) {
        int[] piles = { 3,6,7,11 };
        int h = 8;
        System.err.println(minEatingSpeed(piles, h));
    }
}
