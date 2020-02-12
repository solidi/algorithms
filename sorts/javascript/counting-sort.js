
const countingSort = (data, maxValue) => {
    let countArray = [];
    let resultArray = [];
    let sortIndex = 0;

    for (const number of data) {
        if (countArray[number] === undefined) {
            countArray[number] = 0;
        }
        countArray[number]++;
    }

    for (let number = 0; number < countArray.length; number++) {
        let count = countArray[number];
        for (let i = 0; i < count; i++) {
            resultArray[sortIndex] = number;
            sortIndex++;
        }
    }

    return resultArray;
}

const getMaxNumber = (data) => {
    let max = 0;
    for (const value of data) {
        if (max < value) {
            max = value;
        }
    }
    return max;
}

let data = [3, 4, 1, 2, 12, 11, 9, 10];
let max = getMaxNumber(data);
let result = countingSort(data, max);
console.log([...result]);
