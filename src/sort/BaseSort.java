package sort;

import java.util.Random;

/**
 * 
 * 排序基类
 * 
 */
public abstract class BaseSort {
	private static final int default_len = 50000;

	// 测试性能
	public static void testTime(BaseSort baseSort, int len) {
		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
			nums[i] = new Random().nextInt(len);

		long curr = System.currentTimeMillis();
		baseSort.sort(nums);
		System.out.println("排序用时(未排序数组): " + (System.currentTimeMillis() - curr) + " , 排序正确:" + isCorrent(nums));

		for (int i = 0; i < len; i++)
			nums[i] = i;

		curr = System.currentTimeMillis();
		baseSort.sort(nums);
		System.out.println("排序用时(已排序数组): " + (System.currentTimeMillis() - curr) + " , 排序正确:" + isCorrent(nums));
	}

	public static int[] ascArray(int len) {
		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
			nums[i] = i;
		return nums;
	}

	public static void testTime(BaseSort baseSort) {
		testTime(baseSort, default_len);
	}

	// 测试正确性
	public static void testCorrect(BaseSort baseSort, int len) {
		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
			nums[i] = new Random().nextInt(len);

		nums = baseSort.sort(nums);

		System.out.println("排序正确:" + isCorrent(nums));
	}

	public static boolean isCorrent(int[] nums) {
		int len = nums.length;
		boolean correct = true;
		for (int i = 0; i < len - 1; i++) {
			if (nums[i + 1] < nums[i]) {
				correct = false;
				break;
			}
		}
		return correct;
	}

	public static void testCorrect(BaseSort baseSort) {
		testCorrect(baseSort, default_len);
	}

	// 排序方法
	public abstract int[] sort(int[] nums);

	// 交换
	public static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// 输出
	public static void print(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");

			if ((i + 1) % 100 == 0)
				System.out.println();
		}
	}
}
