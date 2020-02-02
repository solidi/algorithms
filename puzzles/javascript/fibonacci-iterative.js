// Iterative Fibonacci
// Shift values from z trough to x.
// x <- y <- z
// 0 <- 1 <- 1
// 1 <- 1 <- 2
// 1 <- 2 <- 3
// 2 <- 3 <- 5
// ...
const fibonacci = (seed) => {
    let x = 0, y = 1, z, next = 0;
    do {
        console.log(x);
        z = x + y;
        x = y;
        y = z;
        next += 1;
    } while (next <= seed)
};

fibonacci(10);
