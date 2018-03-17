module NinetyOne where

-- Solve knight's tour problem using Warnsdorff's algorithm
-- https://en.wikipedia.org/wiki/Knight%27s_tour
-- Warnsdorff algorithm is a heuristic.
-- The knight moves to the square from which the knight will have the fewest onward moves.
-- The number of possible onward moves from a square is called the 'degree' or 'entrance'.
-- This usually takes O(n) time, while Hamiltonian path problems, in general, are NP-hard.
type Square = (Int, Int)

-- Possible knight moves from a given square on an nxn board
knightMoves :: Int -> Square -> [Square]
knightMoves n (x, y) = filter (onBoard n)
        [(x+2, y+1), (x+2, y-1), (x+1, y+2), (x+1, y-2),
         (x-1, y+2), (x-1, y-2), (x-2, y+1), (x-2, y-1)]

-- Is the square within an nxn board?
onBoard :: Int -> Square -> Bool
onBoard n (x, y) = 1 <= x && x <= n && 1 <= y && y <= n

-- Knight's tours on an nxn board ending at the given square
knightsTo :: Int -> Square -> [[Square]]
knightsTo n finish = [pos:path | (pos, path) <- tour (n * n)]
  where tour 1 = [(finish, [])]
        tour k = [(pos', pos:path) |
                     (pos, path) <- tour (k - 1),
                     pos' <- sortImage (entrances path)  -- sort by positions with fewest onward moves
                             (filter (`notElem` path) (knightMoves n pos))]
        -- calculate the 'entrance' to (or from) a coordinate 'pos'
        entrances path pos =
                length (filter (`notElem` path) (knightMoves n pos))

-- Closed knight's tours on an nxn board
closedKnights :: Int -> [[Square]]
closedKnights n = [pos:path | (pos, path) <- tour (n*n), pos == start]
  where tour 1 = [(finish, [])]
        tour k = [(pos', pos:path) |
                (pos, path) <- tour (k-1),
                pos' <- sortImage (entrances path)
                        (filter (`notElem` path) (knightMoves n pos))]
        entrances path pos
          | pos == start = 100  -- don't visit start until there are no others
          | otherwise = length (filter (`notElem` path) (knightMoves n pos))
        start = (1,1)
        finish = (2,3)

-- Sort by comparing the image of list elements under a function f.
-- These images are saved to avoid recomputation.
sortImage :: Ord b => (a -> b) -> [a] -> [a]
sortImage f xs = map snd (sortBy cmpFst [(f x, x) | x <- xs])
  where cmpFst = comparing fst
