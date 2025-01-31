
import java.util.*;
public class ComplexNumbers {
    static class Complex{
        int real;
        int imaginary;
        public Complex(int real,int imaginary){
            this.real=real;
            this.imaginary=imaginary;
        }
        public static void add(Complex a,Complex b){
            int ans_real=a.real+b.real;
            int ans_imaginary=a.imaginary+ b.imaginary;
            System.out.println(ans_real+" "+ans_imaginary);
        }
        public static void multiply(Complex a,Complex b){
            int ans_real=a.real*b.real;
            int ans_imaginary=a.imaginary* b.imaginary;
            System.out.println(ans_real+" "+ans_imaginary);
        }
        public static void subtract (Complex a,Complex b){
            int ans_real=a.real-b.real;
            int ans_imaginary=a.imaginary - b.imaginary;
            System.out.println(ans_real+" "+ans_imaginary);
        }
    }
    public static boolean canPair(int[] nums, int k){
        if(nums.length%2!=0){
            return false;
        }
        HashMap<Integer ,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i]%=k;
            if(map.containsKey(nums[i])){
                int a = map.get(nums[i])+1;
                map.replace(nums[i], a);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i=0; i<nums.length; i++){
            int b = k-nums[i];
            if((b == nums[i] || nums[i]==0)  && map.get(nums[i])>1){
                return true;
            }
            else if(map.containsKey(b) && b != k-nums[i] ){
                return true;
            }
        }
        if(map.containsKey(0)){
            if(map.get(0)>1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Complex newComplex1 =new Complex(5,7);
//        Complex newComplex2 = new Complex(3,5);
//        Complex.add(newComplex1,newComplex2);
//        Complex.multiply(newComplex1,newComplex2);
//        Complex.subtract(newComplex1,newComplex2);
        int[] nums = {};
        System.out.println(canPair(nums,796));
    }
}
