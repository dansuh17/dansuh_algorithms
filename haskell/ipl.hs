-- determine the internal path length of a tree
data Tree a = Node a [Tree a] deriving (Show, Eq)

ipl :: Tree a -> Int
ipl = snd . aux
  where aux :: Tree a -> (Int, Int)  -- returns (num_nodes, internal_path_length)
        aux (Node a []) = (1, 0)
        -- internal path lengths is a sum of all internal path lengths of of subtrees
        -- plus the number of nodes of subtree
        aux (Node a forest) = (1 + nnodes, nnodes + acc)
          where
            nnodes = sum $ map (\x -> fst $ aux x) forest
            acc = sum $ map (\x -> snd $ aux x) forest

-- ipl tree5 == 9
tree5 = Node 'a' [
              Node 'f' [Node 'g' []],
              Node 'c' [],
              Node 'b' [Node 'd' [], Node 'e' []]
              ]

-- ipl tree4 == 2
tree4 = Node 'b' [Node 'd' [], Node 'e' []]
