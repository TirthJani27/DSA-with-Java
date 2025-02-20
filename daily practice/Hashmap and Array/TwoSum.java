class TwoSum{
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int [2];
        for(int i=0;i<numbers.length-1;i++){
            if (target >= numbers[i]) {
                ans[0] = i;
                int val = binarySearch(numbers, target - numbers[i], i+1);
                System.out.println();
                if (val != -1) {
                    ans[1] = val;
                    return ans;
                }
            }
        }
        return ans; 
    }
    public static int binarySearch(int[] arr, int tar, int idx){
        int left = idx;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == tar ){
                return mid;
            }else if(arr[mid] > tar){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int tar = 9;
        int[] num = {2,7,11,15};
        int[] arr = twoSum(num,tar);
        System.out.println(arr[0]+" "+arr[1]); 
    }
}