/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let obj = {}
for(const item of arr1){
    obj[item.id] = item;
}

for(const item of arr2){
    if(obj[item.id]==undefined){
        obj[item.id] = item;
    } else{
        for(const it of Object.keys(item)){
            // if(obj[item.id][it]!=it){
                obj[item.id][it] = item[it];
            // }
        }
    }
}

let result = [] ;
for(let item of Object.values(obj)){
    result.push(item);
}

return result
    
};