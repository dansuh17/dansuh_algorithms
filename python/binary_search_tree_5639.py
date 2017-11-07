class Tree:
    def __init__(self):
        self.root = None


class TreeNode:
    def __init__(self, data):
        self.data = data
        self.parent = None
        self.left = None
        self.right = None

    def attach_left(self, node):
        self.left = node
        node.parent = self

    def attach_right(self, node):
        self.right = node
        node.parent = self


def post_order(node):
    if node is None:
        return

    post_order(node.left)
    post_order(node.right)
    print(node.data)


def search_tree():
    tree = Tree()
    curr_node = tree.root

    while True:
        try:
            in_str = input().strip()
        except EOFError:
            break

        elem_val = int(in_str)
        if curr_node is None:
            tree.root = TreeNode(elem_val)
            curr_node = tree.root
        else:
            new_node = TreeNode(elem_val)
            done = False
            while True:
                if curr_node.left is None and elem_val < curr_node.data:
                    curr_node.attach_left(new_node)
                    curr_node = new_node
                    break
                elif curr_node.parent is None:
                    curr_node.attach_right(new_node)
                    curr_node = new_node
                    break
                elif curr_node.right is None and elem_val > curr_node.data and elem_val < curr_node.parent.data:
                    curr_node.attach_right(new_node)
                    curr_node = new_node
                    break
                elif curr_node.left is not None and curr_node.right is not None:
                    curr_node = curr_node.parent
                elif elem_val > curr_node.parent.data:
                    curr_node = curr_node.parent

    post_order(tree.root)

if __name__ == '__main__':
    search_tree()
