-- define binary tree
data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Eq, Show)

-- utility for constructing leaf
leaf x = Branch x Empty Empty

-- tree with only the root node
tree1 = Branch 'a' Empty Empty

-- binary tree of integers
tree2 = Branch 1 (Branch 2 Empty (Branch 4 Empty Empty)) (Branch 2 Empty Empty)

-- given a list of integers, construct a binary search tree
construct :: [Int] -> Tree Int
construct xs = foldl (flip addElemTree) Empty xs  -- note the use of 'flip'

addElemTree :: Int -> Tree Int -> Tree Int
addElemTree x Empty = leaf x
addElemTree x (Branch y t1 t2)
  | x < y = Branch y (addElemTree x t1) t2
  | otherwise = Branch y t1 (addElemTree x t2)

-- more elegant solution of addElemTree
addElemTree2 :: Ord a => a -> Tree a -> Tree a
addElemTree2 x Empty = leaf x
addElemTree2 x t@(Branch y l r) = case compare x y of  -- @ notation can be used in this case also
                                   LT -> Branch y (addElemTree2 x l) r
                                   GT -> Branch y l (addElemTree2 x r)
                                   EQ -> t  -- handles equality case

test :: [Bool]
test = [
  (construct [3, 2, 5, 7, 1]) == (Branch 3 (Branch 2 (Branch 1 Empty Empty) Empty) (Branch 5 Empty (Branch 7 Empty Empty))),
  (construct [1, 2, 3]) == (Branch 1 (Branch 2 (Branch 3 Empty Empty) Empty) Empty)]
