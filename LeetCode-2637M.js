/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {

    return async function(...args) {
        const promise1 = new Promise((_,reject)=>{setTimeout(()=>reject("Time Limit Exceeded"),t)});
        // let funCall = fn(...args);
        return Promise.race([fn(...args),promise1]);
    };

};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */