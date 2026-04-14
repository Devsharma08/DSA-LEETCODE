var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        if (functions.length === 0) {
            resolve([]);
            return;
        }


        let list = new Array(functions.length);
        let completeCount = 0;


        functions.forEach((fun, index) => {
            fun()
                .then((res) => {
                    list[index] = res;
                    completeCount++;


                    // resolve when the count matches the functions length
                    if (completeCount === functions.length) {
                        resolve(list);
                    }
                })
                .catch((err) => {
                    reject(err);
                });
        });
    });
};