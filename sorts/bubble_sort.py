def bubble_sort(input):
    for i in range(len(input)):
        for j in range(0, len(input)-i-1):
            if input[j] > input[j + 1]:
                input[j], input[j + 1] = input[j + 1], input[j]
    return input


print(bubble_sort([3, 4, 1, 2, 3, 10, 9, 7]))