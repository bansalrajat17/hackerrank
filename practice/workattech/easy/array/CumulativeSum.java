class Solution {
	int[] getCumulativeSum (int[] arr) {
		// add your logic here
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(i - 1 >= 0)
			{
				arr[i] += arr[i - 1];
			}
		}
		return arr;
	}
}