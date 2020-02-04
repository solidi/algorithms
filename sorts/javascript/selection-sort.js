const selectionSort = (array) => {
    let result = [...array];
    for (let i = 0; i < result.length; i++) {
        let min = i;
        for (let j = i; j < result.length; j++) {
            if (result[min] > result[j]) {
                min = j;
            }
        }
        let swap = result[min];
        result[min] = result[i];
        result[i] = swap;
    }
    return result;
};

let result = selectionSort([5, 7, 8, 1, 10, 12, 14]);
console.log(...result);
