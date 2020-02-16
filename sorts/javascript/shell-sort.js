const shellSort = (array) => {
    let result = [...array];
    let outer, inner, temp, interval = Math.floor((result.length - 1) / 2);
    while (interval > 0) {
        for (outer = interval; outer < result.length; outer++) {
            inner = outer;
            temp = result[outer];
            while ((inner > interval - 1) && result[inner - interval] >= temp) {
                result[inner] = result[inner - interval];
                inner -= interval;
            }
            result[inner] = temp;
        }
        interval = (Math.floor(interval - 1)) / 2;
    }
    return result;
};

console.log(shellSort([6, 1, 3, 9, 10, 11, 4, 5]));
