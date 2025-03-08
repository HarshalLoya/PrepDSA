
class FloorAndCeil {
    // This is same as finding lower and upper bounds for the given number
    public static int findCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        int arrr[] = {3, 4, 4, 7, 7, 8, 10};
        int x = 8;
        int floor = findFloor(arrr, x);
        int ceil = findCeil(arrr, x);
        System.out.println("Floor of " + x + " is " + floor);
        System.out.println("Ceil of " + x + " is " + ceil);
    }
}
