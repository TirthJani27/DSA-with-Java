public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ad", "aaasasdfasfac"));
    }

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static boolean isEqual(int arr1[], int arr2[]) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] m1 = new int[26];
        int[] m2 = new int[26];
        if(s2.length() < s1.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            m1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            m2[s2.charAt(i) - 'a']++;
        }
        int i = s1.length() - 1;
        int j = 0;
        while (i <= s2.length() - 1) {
            print(m1);
            System.out.print("-----");
            print(m2);
            System.out.println("");
            if (isEqual(m1, m2)) {
                return true;
            }
            if(i == s2.length()-1){
                return false;
            }
            i++;
            m2[s2.charAt(i) - 'a']++;
            m2[s2.charAt(j) - 'a']--;
            j++;
        }
        return false;
    }

}
