var timesCalled = 0

const fibonacci = (n) => {
    timesCalled += 1

    if (n < 2) {
        return n;
    }

    return fibonacci(n - 1) + fibonacci(n - 2)
};

for (var i = 0; i <= 10; i++) {
    console.log(fibonacci(i))
}

console.log("Times called: " + timesCalled)
