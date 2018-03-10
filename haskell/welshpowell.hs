module EightySix where

import Data.Ord (compare)
import Data.List (sortBy)

-- node degree and graph coloration
-- a) write a function degree that determines the degree of a given node
-- b) write a function that sorts all nodes in a graph in decreasing order by degree
-- c) use Welch-Powell's algorithm to color the graph
data Graph a = Graph [a] [(a, a)] deriving Show

-- nodes' degree
degree :: Eq a => Graph a -> [(a, Int)]
degree (Graph ns es) = foldl (\acc n -> (n, countEdge n):acc) [] ns
  where
    countEdge n = foldl (\cnt (from, to) -> countIfEqual from n + countIfEqual to n + cnt) 0 es
    countIfEqual x y = if x == y then 1 else 0

-- sort by degree in decreasing order
sortByDegree :: Eq a => [(a, Int)] -> [(a, Int)]
sortByDegree = reverse . sortBy (\(n1, deg1) (n2, deg2) -> compare deg1 deg2)

-- kColor algorithm using Welsh-Powell's Algorithm
welshPowell :: (Eq a) => Graph a -> [(a, Int)]
welshPowell g@(Graph ns es) = reverse $  -- just for easy reading
                              foldl (\accColored (n, _) -> colorNode n accColored) [] nodeDegrees
  where
    nodeDegrees = sortByDegree $ degree g  -- nodes with degrees in decreasing order
    colorNode n colored = (n, nextColor):colored  -- color node 'n' with [(node, color)] already colored nodes
      where
        connectedColored = filter isAdjacent colored  -- look only the adjacent nodes
        isAdjacent (x, col) = x `elem` (adjacents n)
        usedColor = foldl (\acc (x, col) -> col:acc) [] connectedColored
        nextColor = head $ dropWhile (\c -> c `elem` usedColor) colors  -- take the smallest unused color
    adjacents n = [y | (x, y) <- es, x == n] ++ [y | (y, x) <- es, x == n]  -- get all adjacent nodes of n
    colors = [1..]  -- different colors represented by different number

{-
degree (Graph ['a','b','c','d','e','f','g','h','i','j']
              [('a','b'),('a','e'),('a','f'),('b','c'),('b','g'),('c','d'),('c','h'),
               ('d','e'),('d','i'),('e','j'),('f','h'),('f','i'),('g','i'),('g','j'),('h','j')])
== [('j',3),('i',3),('h',3),('g',3),('f',3),('e',3),('d',3),('c',3),('b',3),('a',3)]
-}

{-
welshPowell (Graph ['a','b','c','d','e','f','g','h','i','j']
             [('a','b'),('a','e'),('a','f'),('b','c'),('b','g'),('c','d'),
              ('c','h'),('d','e'),('d','i'),('e','j'),('f','h'),('f','i'),('g','i'),('g','j'),('h','j')])
== [('a',1),('b',2),('c',1),('d',2),('e',3),('f',2),('g',1),('h',3),('i',3),('j',2)]
-}
