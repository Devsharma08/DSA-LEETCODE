/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    let result = {} ;

    if (obj === null || typeof obj !== 'object') {
        return obj;
    }

    if(Array.isArray(obj)){
        return obj.map(compactObject).filter(Boolean);
    }

    for(const key in obj){
        let val = compactObject(obj[key]);
        if(Boolean(val)) {
            result[key] = val;
        }
    }
    return result;
};