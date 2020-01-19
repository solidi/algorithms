const bubbleSort = (array) => {
    let result = [...array];
    for (let i = result.length - 1; i > 0; i--) {
        for (let j = 0; j < i; j++) {
            if (result[j] > result[j + 1]) {
                let swap = result[j];
                result[j] = result[j + 1];
                result[j + 1] = swap;
            }
        }
    }
    return result;
};

let output = bubbleSort([5, 7, 1, 19, 10, 2, 3]);
console.log([...output]);
