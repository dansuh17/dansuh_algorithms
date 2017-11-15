"""
백준 문제 2957번 '이진 탐색 트리'
https://www.acmicpc.net/problem/2957

각 insert()마다 얼마나 깊이 들어가는지를 계산하여 누적합을
출력하는 프로그램.
__파이썬으로 풀 수 없다!!__(시간초과)ㅠㅠㅠ느린파이썬
따라서 C++로 풀 수 있었는데, std::map 자료구조의 도움을 받았고,
코드는 http://vvshinevv.tistory.com/27 를 참고했다.


time - O(N log N)
space - O(N)
auxilliary space - O(N)
"""
def bst():
    n = int(input().strip())
    nums = []
    for _ in range(n):
        nums.append(int(input().strip()))

    root = TreeNode()
    counter = 0
    for num in nums:
        counter += insert(num, root, 0)
        print(counter)


def insert(x, node, counter):
    if node.data == None:  # root
        node.data = x
        return counter  # return 0

    counter += 1
    if node.data < x:
        if node.right is None:
            node.right = TreeNode(x)
            return counter
        else:
            return insert(x, node.right, counter)
    elif node.data > x:
        if node.left is None:
            node.left = TreeNode(x)
            return counter
        else:
            return insert(x, node.left, counter)


class TreeNode:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None


if __name__ == '__main__':
    bst()
