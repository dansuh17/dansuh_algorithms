def troublesort(arr):
    done = False
    arrlen = len(arr)
    while not done:
        done = True
        for j in range(arrlen - 2):
            if arr[j] > arr[j + 2]:
                done = False
                arr[j], arr[j + 2] = arr[j + 2], arr[j]
    return arr


def find_wrong_idx(arr):
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            return i
    return -1


t = int(input())
for i in range(1, t + 1):
    num_elems = int(input())
    arr = [int(s) for s in input().split(' ')]
    sorted_arr = troublesort(arr)
    wrong_idx = find_wrong_idx(sorted_arr)
    if wrong_idx < 0:
        print('Case #{}: {}'.format(i, 'OK'))
    else:
        print('Case #{}: {}'.format(i, wrong_idx))
