/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let id;
    return function(...args) {
        return new Promise((resolve,reject)=>{
            
            clearTimeout(id);
            
            id = setTimeout(()=>{
                return resolve(fn(...args));
            },t)

          
        })
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */