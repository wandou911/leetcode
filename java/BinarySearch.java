
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] {1,3,4,5,7,9};
        int target = 7;
        int l = 0;
        int r = a.length - 1;
        int binarySearch = solution.binarySearch(a, l, r, target);
        int i = binarySearch;
        System.out.println(i);
    }

}

class Solution {

    public int binarySearch(int[] arr, int l, int r, int target) {

    while(l <= r) {
    int mid = l + (r - l) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] > target) r = mid - 1;
    else l = mid + 1;
    }

    return -1;

    }

    public int binarySearch2(int[] arr, int l, int r, int target) {

        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, l, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, r, target);
        }

    }
    
}