module EightyFour where

import Data.List (sortBy)
import Data.Maybe

-- construct the minimal spanning tree using Prim's algorithm
prim :: (Eq a) => [a] -> [(a, a, Int)] -> [(a, a, Int)]
prim nodes edges = snd $ primAux [head nodes] []
  where
    primAux ns es = case (fstMin, sndMin) of
                      (Nothing, Nothing) -> (ns, es)  -- cannot reach any further
                      (Just i, Nothing) -> primAux ((getTo i):ns) (i:es) -- add an edge that connects 'from' the tree 'to' yet unconnected node
                      (Nothing, Just j) -> primAux ((getFrom j):ns) (j:es) -- add an edge that connects 'from' outside node 'to' the tree
                      (Just i, Just j) ->  -- perform according to comparison results
                          if getLength i < getLength j
                          then primAux ((getTo i):ns) (i:es)
                          else primAux ((getFrom j):ns) (j:es)
      where fstMin = case length edgesTo of
                       0 -> Nothing  -- cannot find an edge
                       otherwise -> Just (head edgesTo)
            sndMin = case length edgesFrom of
                       0 -> Nothing  -- cannot find an edge
                       otherwise -> Just (head edgesFrom)
            sortF (_, _, a) (_, _, b) = compare a b
            -- find edges that connects 'to' or 'from' the building tree. sort by the edge value.
            edgesTo = sortBy sortF [ edge | n <- ns,
                                            edge <- edges,
                                            getFrom edge == n,  -- 'from' a node in tree...
                                            not ((getTo edge) `elem` ns),  -- and the 'to' cannot be currently in tree
                                            not (edge `elem` es)]  -- and edge does not already exist in tree
            edgesFrom = sortBy sortF [ edge | n <- ns,
                                              edge <- edges,
                                              getTo edge == n,
                                              not ((getFrom edge) `elem` ns),
                                              not (edge `elem` es)]
    -- edge parsing helpers
    getLength (_, _, l) = l
    getTo (_, to, _) = to
    getFrom (from, _, _) = from
