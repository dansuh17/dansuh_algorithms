"""
Insertion sort 기본 구현
길이 1짜리 array부터 시작해서 뒤에 있는 원소를 점차 삽입해 나간다

time - O(n^2)
space - n
"""


def insertion_sort(arr):
    l = len(arr)
    for i in range(1, l):
        for j in range(i, 0, -1):
            if arr[j] < arr[j - 1]:
                arr[j], arr[j - 1] = arr[j - 1], arr[j]
            else:
                break
    return arr


if __name__ == '__main__':
    print(insertion_sort([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66]))
