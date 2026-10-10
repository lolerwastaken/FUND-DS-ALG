import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BigO {
	public static boolean m1(int[] arr) { // O(n^2)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean m1Version2(int[] arr) { //O(n)
		Set<Integer> hashSet = new HashSet<>();
		for (int i : arr) {
			if (hashSet.contains(i)) {
				return true;
			} else {
				hashSet.add(i);
			}
		}
		return false;

		// Code Explanation
		// m1Version2 creates an empty hash set and checks through every element in the array.
		// In the for loop, it will check every element of the array and checks if the element (i) exists in the hash set.
		// If the element already exists in the hash set, it will stop by returning true.
		// If the element does not exist in the hash set, the element will be added into the hash set.
		// If no duplicate elements are found in the loop, it will stop and return false.

       }

	public static List<List<Integer>> m2(int[] nums) { //O(n^3)
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(triplet); // avoid duplicates
						if (!result.contains(triplet)) {
							result.add(triplet);
						}
					}
				}
			}
		}

		return result;
	}
	
	public static List<List<Integer>> m2Version2(int[] nums) { // O(n^2)
			List<List<Integer>> result = new ArrayList<>();
			int n = nums.length;
			Arrays.sort(nums);

			for (int i = 0; i < (n - 2); i++) {
				if (i > 0 && nums[i] == nums[i-1]) {
					continue; // Skip duplicates
				}

				int left = i + 1;
				int right = n - 1;
				int target = -nums[i];

				while (left < right) {
					int sum = nums[left] + nums[right];

					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[left], nums[right]));

						// Skip dupes for left pointer
						while (left < right && nums[left] == nums[left+1]) {
							left++;
						}

						// Skip dupes for right pointer
						while (left < right && nums[right] == nums[right-1]) {
							right--;
						}

						left++;
						right--;

					} else if (sum < target) {
						left++; // Larger sum
					} else {
						right--; // Smaller sum
					}
				}
			}
			return result;

			// An empty array list is created and the length of 'nums' array is declared.
			// The integers in the 'nums' value is then sorted from lowest to highest.
			// Cycle through every element (i) in the for loop to anchor the triplet (we need two more values so it loops up to n-2)
		    // If an element matches the previous one, skip the duplicate value
			// Two pointers, left and right are used to find triplets
			// In the while loop, it checks if:
			// 1. sum == target --> valid triplet found, add it to the array list
			// 2. sum < target --> sum is too small, so left is moved rightward to increase it.
			// 3. sum > target (else) --> sum is too big so right is moved leftward to decrease it.
			// Finally, return the array list of existing triplets.
        }
}
