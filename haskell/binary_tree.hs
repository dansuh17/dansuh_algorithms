data Tree a = Empty | Branch a (Tree a) (Tree a)
  deriving (Show, Eq)

leaf x = Branch x Empty Empty

-- tree with only the root node
tree1 = Branch 'a' Empty Empty

-- binary tree of integers
tree2 = Branch 1 (Branch 2 Empty (Branch 4 Empty Empty)) (Branch 2 Empty Empty)
