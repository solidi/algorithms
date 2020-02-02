const fibonacci = function() {
    let memo = [0, 1]
    const fib = (n) => {
        var result = memo[n]
        if (typeof result !== 'number') {
            result = fibonacci(n - 1) + fibonacci(n - 2)
            memo[n] = result
        }
        return result
    }
    return fib
}();

function* range(start, end) {
    yield start;
    if (start === end) return;
    yield* range(start + 1, end);
}

for (i of range(0, 10)) {
    console.log(fibonacci(i));
}
