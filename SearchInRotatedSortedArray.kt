fun main(args: Array<String>){
    val solution: Solution = Solution()
    println(solution.search(intArrayOf(0, 1, 2, 4, 5, 6, 7), 0))
}


class Solution {

    fun search(nums: IntArray, target: Int): Int {
        var index: Int = -1
        for (i in nums.indices) {
            if(nums[i] == target){
                index = i
            }
        }
        return index
    }
}