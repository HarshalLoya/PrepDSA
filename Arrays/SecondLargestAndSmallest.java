
import java.util.Arrays;

class SecondLargestAndSmallest {

    public static void findElements(int[] nums) {
        if (nums.length < 2) {
            System.out.println("Array should have at least two elements");
            return;
        }
        int smallest = Integer.MAX_VALUE, secondsmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE, secondlargest = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i < smallest) {
                secondsmallest = smallest;
                smallest = i;
            } else if (i < secondsmallest && i != smallest) {
                secondsmallest = i;
            }

            if (i > largest) {
                secondlargest = largest;
                largest = i;
            } else if (i > secondlargest && i != largest) {
                secondlargest = i;
            }
        }

        System.out.printf("Second Largest: %d, Second Smallest: %d", secondlargest, secondsmallest);

    }

    public static void main(String[] args) {
        int[] nums = {-10, -20, 5, 3, 0, -1};
        System.out.println(Arrays.toString(nums));
        findElements(nums);
    }
}
