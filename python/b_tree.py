"""
Simple B-Tree implementation.

Tutorial:
http://www.geeksforgeeks.org/b-tree-set-1-introduction-2/
"""
class BTree:
    def __init__(self, t):
        self.root = BTreeNode()
        self.min_node_size = t - 1
        self.max_node_size = 2 * t - 1
        self.height = 1

    def insert(self, e: int):
        pass

    def to_be_inserted(self):

    def delete(self, e: int):
        pass

    def search(self, e: int):
        depth = 1
        next_node = self.root
        while depth <= self.height:  # search until deepest height
            found = next_node.contains(e)
            if found:
                return True, next_node
            depth += 1
            next_node = next_node.next_node(e)
        return False, next_node


class BTreeNode:
    def __init__(self):
        self.elements = []
        self.children = []

    def contains(self, e):
        return e in self.elements

    def next_node(self, e):
        for idx, elem in enumerate(self.elements):
            if elem < e:
                return self.children[idx - 1]
        return self.children[-1]
