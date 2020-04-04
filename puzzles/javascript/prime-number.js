function isPrime(n) {
    if (n == 1) {
        process.stdout.write("Not prime\n");
        return;
    }

    if (n == 2) {
        process.stdout.write("Prime\n");
        return;
    }

    if (n % 2 == 0) {
        process.stdout.write("Not prime\n");
        return;
    }

    for (let i = 3; i * i <= n; i += 2) {
        if (n % i == 0) {
            process.stdout.write("Not prime\n");
            return;
        }
    }

    process.stdout.write("Prime\n");
}

function processData(input) {
    for (let n of input) {
        isPrime(n);
    }
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";

process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
    _input = _input.split("\n");
    _input.shift();
   processData(_input);
});
