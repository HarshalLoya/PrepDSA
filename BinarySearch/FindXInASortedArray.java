
class FindXInASortedArray {

    public static int findX(int[] arr, int x, int start, int end) {
        if (start > end) {
            return -1; // element not found
        }
        int mid = (start + end) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] < x) {
            return findX(arr, x, mid + 1, end);
        }
        return findX(arr, x, start, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int x = 13;
        int result = findX(arr, x, 0, arr.length - 1);
        System.out.println("Element is present at index " + result);
    }

}
