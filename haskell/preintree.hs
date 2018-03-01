-- preorder & inorder sequences of binary trees
data Tree a = Empty | Branch a (Tree a) (Tree a)
  deriving (Show)

-- print a tree in preorder sequence
treeToPreorder :: Tree Char -> String
treeToPreorder Empty = ""
treeToPreorder (Branch a l r) = [a] ++ treeToPreorder l ++ treeToPreorder r

-- print a tree in inorder sequence
treeToInorder :: Tree Char -> String
treeToInorder Empty = ""
treeToInorder (Branch a l r) = treeToInorder l ++ [a] ++ treeToInorder r

-- given a preorder and inorder string, produce a unique tree
preInTree :: Monad m => String -> String -> m (Tree Char)
preInTree preOrd inOrd = return $ fst $ makeTree preOrd inOrd

-- make a tree given a preorder and inorder strings, along with remainder characters
-- of preorder strings after using to make the subtree
makeTree :: String -> String -> (Tree Char, String)
makeTree preOrd "" = (Empty, preOrd)
makeTree preOrd inOrd = (Branch (head preOrd) leftTree rightTree, rightRem)
  where ls = takeWhile (\x -> x /= head preOrd) inOrd
        rs = tail $ dropWhile (\x -> x /= head preOrd) inOrd
        (leftTree, leftRem) = makeTree (tail preOrd) ls
        (rightTree, rightRem) = makeTree leftRem rs

-- preInTree "abdecfg" "dbeacgf" == Branch 'a' (Branch 'b' (Branch 'd' Empty Empty) (Branch 'e' Empty Empty)) (Branch 'c' Empty (Branch 'f' (Branch 'g' Empty Empty) Empty))
