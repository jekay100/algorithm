package sort;

/**
 * 选择排序
 *
 */
public class SelectionSort extends BaseSort{

	public static void main(String[] args) {
		testTime(new SelectionSort());
	}

	public int[] sort(int[] nums) {
		// 数组长度
		int len = nums.length;

		if (len == 1)
			return nums;

		// 当前索引
		int i;
		// 最小数索引
		int minIndex;

		// 从头遍历 start指向还未排序数组的第一个元素
		for (int start = 0; start < len - 1; start++) {
			// 找到最小元素的索引 与start交换
			for (minIndex = start, i = start + 1; i < len; i++) {
				if (nums[i] < nums[minIndex]) {
					minIndex = i;
				}
			}
			swap(nums, start, minIndex);
		}
		
		return nums;
	}

}
