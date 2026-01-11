/**
 * @param {number[]} nums
 * @return {number[]}
 */
var runningSum = function(nums) {
    nums.reduce((acc,curr,index,arr)=>{
       arr[index] = arr[index] + acc;
       return arr[index];
    },0)
    return nums;
};