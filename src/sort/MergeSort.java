package sort;

/**
 * 归并排序
 * 
 */
public class MergeSort extends BaseSort {

	public static void main(String[] args) {
		testTime(new MergeSort());
		// testCorrect(new MergeSort());
	}

	/**
	 * 归并排序
	 */
	public int[] sort(int[] nums) {
		int len = nums.length;
		int start = 0;
		int end = len - 1;

		sort(nums, start, end);
		return nums;
	}

	/**
	 * 归并排序递归
	 * 
	 * @param nums
	 *            数组
	 * @param start
	 *            开始index
	 * @param end
	 *            结束index
	 */
	public void sort(int[] nums, int start, int end) {
		// 只有一个元素
		if (start == end)
			return;
		// 两个元素
		else if ((end - start) == 1) {
			// 交换
			if (nums[start] > nums[end])
				swap(nums, start, end);
			else
				return;
		}
		// 两个以上元素
		else {
			// 递归
			int mid = (end + start) / 2;
			sort(nums, start, mid);
			sort(nums, mid + 1, end);

			merge(nums, start, mid, end);

		}
	}

	/**
	 * 归并
	 * 
	 * @param nums
	 * @param start
	 * @param mid
	 * @param end
	 */
	private void merge(int[] nums, int start, int mid, int end) {
		int len = end - start + 1;
		// 新建相同长度数组
		int[] temps = new int[len];

		int i = 0, left = start, right = mid + 1;

		// 选择最小的加入
		while (left <= mid && right <= end) {
			if (nums[left] <= nums[right]) {
				temps[i++] = nums[left++];
			} else {
				temps[i++] = nums[right++];
			}
		}

		// 剩下的加入
		while (left <= mid) {
			temps[i++] = nums[left++];
		}

		// 剩下的加入
		while (right <= end) {
			temps[i++] = nums[right++];
		}

		// 赋值回去
		for (i = 0; start <= end; start++) {
			nums[start] = temps[i++];
		}
	}
}
