const towerOfHanoi = (n, fromRod, toRod, auxRod) => {
    if (n == 1) {
        console.log(`Moved disk 1 from rod ${fromRod} to rod ${toRod}`);
        return;
    }

    towerOfHanoi(n - 1, fromRod, auxRod, toRod);
    console.log(`Moved disk ${n} from rod ${fromRod} to rod ${toRod}`);
    towerOfHanoi(n - 1, auxRod, toRod, fromRod);
};

towerOfHanoi(4, 'A', 'B', 'C');
