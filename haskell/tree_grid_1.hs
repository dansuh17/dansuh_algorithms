import Data.List (elemIndex)
import Data.Maybe (fromJust)
-- annotate a tree's nodes with its position in a grid
-- the tree to be drawn should follow two rules:
-- 1. x(v) is equal to the position of the node v in the inorder seuqence
-- 2. y(v) is equal to the depth of the node v in the tree
-- see problem 64 in https://wiki.haskell.org/99_questions/61_to_69
data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show)
-- make the tree mappable
instance Functor Tree where
  fmap f Empty = Empty
  fmap f (Branch a l r) = Branch (f a) (fmap f l) (fmap f r)
type Pos = (Int, Int) -- (y, x) coordinate in the grid

layout :: Tree Char -> Tree (Char, Pos)
layout t = fmap (\(x, h) -> (x, (h, fromJust $ elemIndex x nodeList))) $ annotateHeight t 1
  where nodeList = orderNodes t

-- annotate tree nodes with its height - the root is 1 and height increments by 1 as it goes deeper
annotateHeight :: Tree Char -> Int -> Tree (Char, Int)
annotateHeight Empty _ = Empty
annotateHeight (Branch x l r) h = Branch (x, h) (annotateHeight l (h + 1)) (annotateHeight r (h + 1))

-- horizontally order the nodes that follow the two rules
orderNodes :: Tree Char -> [Char]
orderNodes Empty = []
orderNodes (Branch x l r) = (orderNodes l) ++ [x] ++ (orderNodes r)

-- example tree to test with
-- see the diagram in https://wiki.haskell.org/99_questions/Solutions/64
tree64 = Branch 'n'
              (Branch 'k'
                      (Branch 'c'
                              (Branch 'a' Empty Empty)
                              (Branch 'h'
                                      (Branch 'g'
                                              (Branch 'e' Empty Empty)
                                              Empty
                                      )
                                      Empty
                              )
                      )
                      (Branch 'm' Empty Empty)
              )
              (Branch 'u'
                      (Branch 'p'
                              Empty
                              (Branch 's'
                                      (Branch 'q' Empty Empty)
                                      Empty
                              )
                      )
                      Empty
              )
