"""
Counting sort 기본 구현
등장하는 elem의 개수를 통해 정렬하는 방법.
등장하는 원소의 범위가 제한적일 경우에 유용하고 빠르다.

time - O(N)
space - O(N)

where
N = maximum possible number of available elements
"""


def counting_sort(arr):
    counts = [0] * 100  # assume max num is 99
    for elem in arr:
        counts[elem] += 1

    result = []
    for elem, count in enumerate(counts):
        if count > 0:
            for _ in range(count):
                result.append(elem)

    return result


if __name__ == '__main__':
    print(counting_sort([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, 6, 7, 81, 23, 15, 66]))