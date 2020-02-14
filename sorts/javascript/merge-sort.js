const mergeSort = (array = [9, 8, 7], leftIndex = 0, rightIndex = 2) => {
    if (leftIndex >= rightIndex) {
        return;
    }

    let middleIndex = Math.floor((leftIndex + rightIndex) / 2);
    mergeSort(array, leftIndex, middleIndex);
    mergeSort(array, middleIndex + 1, rightIndex);

    let rightStartIndex = middleIndex + 1;
    let rightEndIndex = rightIndex;
    while (leftIndex <= rightStartIndex && leftIndex <= rightEndIndex && rightStartIndex <= rightEndIndex) {
        if (array[leftIndex] < array[rightStartIndex]) {
            leftIndex++;
        } else {
            let temp = array[rightStartIndex];

            for (let k = rightStartIndex; k > leftIndex; k--) {
                array[k] = array[k - 1];
            }

            array[leftIndex] = temp;
            leftIndex++;
            rightStartIndex++;
        }
    }

    return array;
};

let result = mergeSort();
console.log([...result]);
