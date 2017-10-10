"""
Heap sort 기본 구현
root가 children보다 값이 큰 heap을 만들고 그 힙의 root을 차례대로 떼오면서 정렬.

time - O(n log n)
space - n
"""


def heapsort(arr):
    l = len(arr)
    heap = heapify(arr)

    # the root is the largest - move to end and
    # sift_down with smaller array
    for end in range(l - 1, -1, -1):
        sift_down(heap, 0, end)
        heap[0], heap[end] = heap[end], heap[0]
    return heap


def heapify(arr):
    """
    Create heap from unsorted array.
    The resulting heap's subtrees have root value
    larger than any of its children.
    """
    l = len(arr)
    end = l - 1
    for start in range(end, -1, -1):
        sift_down(arr, start, end)
    return arr


def sift_down(arr, start, end):
    """
    Move root element down the heap so that
    the largest value stays on the root.

    left child index : root * 2 + 1
    right child index : root * 2 + 2
    parent index : floor((root - 2) / 2)
    """
    root = start
    while (root * 2 + 1) <= end:
        left_child = root * 2 + 1
        right_child = root * 2 + 2
        swap = root

        if arr[root] < arr[left_child]:
            swap = left_child

        if right_child <= end and arr[swap] < arr[right_child]:
            swap = right_child

        if swap == root:
            return
        else:
            arr[swap], arr[root] = arr[root], arr[swap]
            root = swap


if __name__ == '__main__':
    print(heapsort([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66]))
