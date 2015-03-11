package sort;

/**
 * 插入排序
 * 
 */
public class InsertSort extends BaseSort {

	public static void main(String[] args) {
		testTime(new InsertSort());
//		testCorrect(new InsertSort());
	}

	public int[] sort(int[] nums) {
		// 数组长度
		int len = nums.length;

		if (len == 1)
			return nums;

		//创建长度相同的新数组
		int[] new_nums = new int[len];
		//初始化第一个数
		new_nums[0] = nums[0];

		int i, j;
		//nums[insert]为当前要插入的数
		for (int insert = 1; insert < len; insert++) {
			//找到插入的位置
			for (i = insert - 1; i >= 0; i--) {
				if (nums[insert] >= new_nums[i])
					break;
			}
			//把后面的数向后移一位,腾出空间让元素插入
			for (j = insert - 1; j > i; j--) {
				new_nums[j + 1] = new_nums[j];
			}
			new_nums[j + 1] = nums[insert];
		}
		
		return new_nums;
	}

}
