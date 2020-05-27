class Solution {

    fun search(nums: IntArray, target: Int): Int {
        var pivot = getPivot(nums)
        if(nums.size != 0 && pivot != -1) when(target){
            in nums[0]..nums[pivot -1] -> return binarySearch(nums.copyOfRange(0, pivot), target)
            in nums[pivot]..nums[nums.lastIndex] -> {
                var t = binarySearch(nums.copyOfRange(pivot, nums.size), target)
                //println("printing t is ${t}")
                if(t != -1){
                    return pivot + t
                }
                else{
                    return t
                }
            }
        }
        if(nums.size!=0 && pivot == -1){
            return  binarySearch(nums, target)
        }
        return -1
    }

    fun getPivot(nums: IntArray):Int{
        //returns the index at which the sorted array is rotated, else -1
        if(nums.size == 0) return -1
        var prev: Int = nums[0]
        for(index in nums.indices){
            if (prev > nums[index]){
                return index
            }
            else{
                prev = nums[index]
            }
        }
        return -1
    }

    fun binarySearch(nums: IntArray, target: Int): Int{
        //returns the index of the target if found, else -1
        //expecting it will work with O(n) time complexity
        //println("performing binary search on" + nums.asList())
        if(nums.size > 1) {
            var split = nums.size / 2
            if (nums[split] == target){
                return split
            }
            if(nums[split] > target){
                var t = binarySearch(nums.copyOfRange(0,split), target)
                //println("printing t ${t} for ${nums.asList()}")
                if (t == -1) return  -1 else return t
            }
            if (nums[split] < target){
                var t = binarySearch(nums.copyOfRange(split , nums.size), target)
                //println("printing t ${t} for ${nums.asList()}")
                if(t == -1) return -1 else return split + t
            }
        }
        if(nums[0] == target) {
            return 0
        }
        return -1
    }
}