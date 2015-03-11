package sort;

import java.util.Random;

/**
 * 
 * 排序基类
 *
 */
public abstract class BaseSort {
	//测试性能
	public static void test(BaseSort baseSort) {
		int[] nums = new int[50000];
		for (int i = 0; i < nums.length; i++)
			nums[i] = new Random().nextInt();

		long curr = System.currentTimeMillis();
		baseSort.sort(nums);
		System.out.println("随机数时间: " + (System.currentTimeMillis() - curr));

		for (int i = 0; i < nums.length; i++)
			nums[i] = i;

		curr = System.currentTimeMillis();
		baseSort.sort(nums);
		System.out.println("已排序数时间: " + (System.currentTimeMillis() - curr));
	}

	//排序方法
	public abstract void sort(int[] nums);

	//交换
	public static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	//输出
	public static void print(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
}
