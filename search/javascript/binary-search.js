function binarySearchIterative(whatToSearch, findValue) {
    let startIndex = 0;
    let endIndex = whatToSearch.length - 1;
    let middleIndex = Math.trunc((startIndex + endIndex) / 2);

    while (startIndex <= endIndex) {
        if (findValue < whatToSearch[middleIndex]) {
            endIndex = middleIndex - 1;
        } else if (findValue > whatToSearch[middleIndex]) {
            startIndex = middleIndex + 1;
        } else {
            return 1;
        }
        middleIndex = Math.trunc((startIndex + endIndex) / 2);
    }

    return -1;
}

function binarySearchRecursive(whatToSearch, findValue, startIndex, endIndex) {
    let middleIndex = Math.trunc((startIndex + endIndex) / 2);

    if (startIndex <= endIndex) {
        if (findValue < whatToSearch[middleIndex]) {
            return binarySearchRecursive(whatToSearch, findValue, startIndex, middleIndex - 1);
        } else if (findValue > whatToSearch[middleIndex]) {
            return binarySearchRecursive(whatToSearch, findValue, middleIndex + 1, endIndex);
        } else {
            return middleIndex;
        }
    }

    return -1;
}

console.log(`${binarySearchIterative([5, 6, 9, 11, 13], 14)}`);
console.log(`${binarySearchRecursive([1, 5, 6, 8, 10, 12, 15], 10, 0, 6)}`);
