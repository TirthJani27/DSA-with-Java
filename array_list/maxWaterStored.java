package array_list;

import java.util.*;

public class maxWaterStored {
    public static int maxWaterStored1(ArrayList<Integer> height) {
        int lp = 0;
        int rp = height.size() - 1;
        int maxwater = 0;
        while (lp < rp) {
            if (height.get(rp) > height.get(lp)) {
                int hw = Math.min(height.get(rp), height.get(lp));
                int ww = rp - lp;
                int currwater = hw * ww;
                if (currwater >= maxwater) {
                    maxwater = currwater;
                }
                lp++;
            } else {
                int hw = Math.min(height.get(rp), height.get(lp));
                int ww = rp - lp;
                int currwater = hw * ww;
                if (currwater >= maxwater) {
                    maxwater = currwater;
                }
                rp--;
            }

        }
        return maxwater;
    }

    public static void main(String args[]) {
        ArrayList<Integer> heigth = new ArrayList<>();
        heigth.add(1);
        heigth.add(8);
        heigth.add(6);
        heigth.add(2);
        heigth.add(5);
        heigth.add(4);
        heigth.add(8);
        heigth.add(3);
        heigth.add(7);
        // maxWaterStored1( heigth);
        System.out.print(maxWaterStored1(heigth));
    }
}
