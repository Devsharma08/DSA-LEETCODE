// let currentTime = Date.now();
// let this.map ;
// let count = 0 ;
var TimeLimitedCache = function() {
    // at key index we'll store value and duration
    this.map = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */



TimeLimitedCache.prototype.set = function(key, value, duration) {
    let currentTime = Date.now();
    const exists = this.map.has(key) && this.map.get(key).duration > currentTime ;

    this.map.set(
        key,{
            "duration":duration+currentTime,
            "value":value
        }
    )

    return exists; 

};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    let currentTime = Date.now();

    if(this.map.has(key) && this.map.get(key).duration > currentTime){
        return this.map.get(key).value;
    } else{ 
    if(this.map.has(key)) this.map.delete(key);
    return -1
    }
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let currentTime = Date.now();
    let count = 0 ;
    let iterator = this.map.values();

    for(let [key,value ] of this.map){
        if(value.duration > currentTime)
            count++;
        else
        this.map.delete(key);
    }
    return count;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */