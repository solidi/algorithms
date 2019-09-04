def insertion_sort(input):
    for i in range(len(input)):
        insertValue = input[i]
        j = i
        while ((j > 0) and input[j - 1] > insertValue):
            input[j] = input[j - 1]
            j -= 1
        input[j] = insertValue
    return input


print(insertion_sort([3, 4, 1, 2, 3, 10, 9, 7]))
