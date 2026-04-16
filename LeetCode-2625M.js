/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
// var flat = function (arr, n) {
//     let result = [];
//     flatten(arr,n);
//     return result;
//   function flatten(arr,n){
//     for(let item of arr){
//         if(Array.isArray(item) && n>0){
//             flatten(item,n-1);
//         }else{
//             result.push(item);
//         }
//     }
//   }
// };

var flat = function(arr,n){
    if(n==0) return arr;
    return arr.reduce((result,curr)=>{
        
            if(Array.isArray(curr) && n>0){
                result.push(...flat(curr,n-1));
            }else{
                result.push(curr);
            }
            return result;

    },[])

    
}