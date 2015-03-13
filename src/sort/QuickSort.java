package sort;

/**
 * 快速排序
 */
public class QuickSort extends BaseSort {

	public static void main(String[] args) {
		 testTime(new QuickSort());
		// testCorrect(new QuickSort());

//		int[] nums = ascArray(50000);
//		new QuickSort().sort(nums);
//		print(nums);
	}

	@Override
	public int[] sort(int[] nums) {
		split(nums, 0, nums.length - 1);
		return nums;
	}

	public void split(int[] nums, int start, int end) {
		int t_start = start, t_end = end;

		// 一个元素
		if (start >= end)
			return;
		// 两个元素
		else if ((end - start) == 1) {
			if (nums[start] > nums[end])
				swap(nums, start, end);
			return;
		}

		// 随机选取基准
		int p = (int) (Math.random() * (end - start + 1)) + start;
		swap(nums, p, start);

		int pivot = start++;
		while (start <= end) {
			// 在左边找到大于基准的元素
			while (start < end && nums[start] <= nums[pivot])
				start++;

			// 在右边找到小于基准的元素
			while (start < end && nums[end] >= nums[pivot])
				end--;

			// 两个指针重合
			if (start == end)
				break;

			swap(nums, start, end);
		}

		// 基准元素归位
		if (nums[pivot] < nums[start]) {
			start--;
		}
		swap(nums, start, pivot);
		pivot = start;
		// 递归
		split(nums, t_start, pivot - 1);
		split(nums, pivot + 1, t_end);
	}

}
