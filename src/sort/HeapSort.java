package sort;

/**
 * 堆排序
 */
public class HeapSort extends BaseSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 testTime(new HeapSort());

		// testCorrect(new HeapSort());

//		int[] nums = { 5, 4, 3, 2, 1 };
//		nums = new HeapSort().sort(nums);
//		print(nums);

	}

	/**
	 * 堆排序
	 */
	@Override
	public int[] sort(int[] nums) {
		//建大根堆
		build(nums);
		int len = nums.length;
		int end = len - 1;
		//不断弹出最大元素(弹出的放到)
		for (int i = 0; i < len; i++)
			pop(nums, end--);
		return nums;
	}

	/**
	 * 建大根堆
	 * @param nums
	 */
	public void build(int[] nums) {
		int end = nums.length - 1;
		int start = parentIndex(end);

		// 最后一个非叶子节点开始
		for (int i = start; i >= 0; i--) {
			heapify(nums, i, end);
		}
	}

	
	/**
	 * 从上往下遍历, 保持父节点大于子节点
	 * @param nums
	 * @param i  当前元素
	 * @param end 结尾
	 */
	private void heapify(int[] nums, int i, int end) {
		int min = maxIndex(nums, i, end);
		// 交换
		if (min != i) {
			swap(nums, min, i);
			heapify(nums, min, end);
		}
	}

	/**
	 * 弹出最大元素
	 * @param nums
	 * @param end 结尾
	 * @return
	 */
	public int pop(int[] nums, int end) {
		// 弹出第一个
		int pop = nums[0];
		swap(nums, 0, end--);

		int curr = 0;
		int leftChild = leftChild(0);
		int min;
		// 从上往下
		while (leftChild <= end) {
			// 找到最小的
			min = maxIndex(nums, curr, end);
			if (min != curr) {
				swap(nums, min, curr);
				curr = min;
				leftChild = leftChild(curr);
			} else
				break;
		}
		return pop;
	}

	
	/**
	 * 找到最大元素的索引
	 * @param nums
	 * @param parent 父元素索引
	 * @param end  结尾
	 * @return
	 */
	public int maxIndex(int[] nums, int parent, int end) {
		int leftChild = leftChild(parent);
		int rightChild = leftChild + 1;
		int min;

		// 越界
		if (leftChild > end)
			return parent;
		// 找到最小的
		if (rightChild <= end)
			min = nums[leftChild] > nums[rightChild] ? leftChild : rightChild;
		else
			min = leftChild;
		min = nums[parent] > nums[min] ? parent : min;
		return min;
	}

	
	//获取父节点
	public int parentIndex(int left_child) {
		return (left_child - 1) >> 1;
	}

	//左孩子节点
	public int leftChild(int parent) {
		return (parent << 1) + 1;
	}
}
