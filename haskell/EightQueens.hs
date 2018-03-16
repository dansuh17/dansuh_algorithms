module Ninety where

import Data.List (nub)

-- eight queens problem
queens :: Int -> [[Int]]
queens n
  | n < 1 = error "cannot be less than 1"
  | otherwise = filter (\ perm -> isBanned perm) $ permutation n

-- find whether the list of queens is banned (doesn't satisfy the condition)
isBanned :: [Int] -> Bool
isBanned queenlist = snd
  $ foldl
    (\ (queenlistProgress, isOk) x
      -> (queenlistProgress ++ [x],
          (not . elem x $ newBanned queenlistProgress) && isOk))  -- find whether it is banned
    ([], True) queenlist

-- find the row numbers of chess board where the 'next' queen is NOT allowed to be in
newBanned :: [Int] -> [Int]
newBanned [] = []
newBanned queenlist = nub
  $ concatMap (\ (queenpos, offset)
                -> [queenpos, queenpos - offset, queenpos + offset])
  $ zip queenlist (enumFromThen (length queenlist) (length queenlist - 1))

-- find all permutations of numbers 1 .. n
-- can be replaced with Data.List.permutations
permutation :: Int -> [[Int]]
permutation 1 = [[1]]
permutation n = [take m perm ++ [n] ++ drop m perm | perm <- permutation (n - 1), m <- [0..(n - 1)]]

-- alternative solution - very slow
queens_slow :: Int -> [[Int]]
queens_slow n = filter test (generate n)
    where generate 0      = [[]]
          generate k      = [q : qs | q <- [1..n], qs <- generate (k-1)]
          test []         = True
          test (q:qs)     = isSafe q qs && test qs
          isSafe   try qs = not (try `elem` qs || sameDiag try qs)
          sameDiag try qs = any (\(colDist,q) -> abs (try - q) == colDist) $ zip [1..] qs

queens'' :: Int -> [[Int]]
queens'' n = map reverse $ queens' n
    where queens' 0 = [[]]
          queens' k = [q:qs | qs <- queens' (k - 1), q <- [1..n], isSafe q qs]  -- test 'isSafe' as early as possible
          isSafe try qs = not (try `elem` qs || sameDiag try qs)
          sameDiag try qs = any (\(colDist,q) -> abs (try - q) == colDist) $ zip [1..] qs
