-- completely balanced tree
data binarytree a = empty | branch a (binarytree a) (binarytree a)
  deriving (show, eq)

-- completely balanced tree has subtrees that differ in height by maximum 1
cbaltree :: int -> [binarytree char]
cbaltree 0 = [empty]
cbaltree n = [branch 'x' left right | m <- [q .. (q + r)],  -- will iterate twice if r == 1
                                      left <- cbaltree m,
                                      right <- cbaltree (n - m - 1)]
  where
    (q, r) = quotrem (n - 1) 2

-- efficient version - does not generate same tree twice
cbaltree2 :: int -> [binarytree char]
cbaltree2 0 = [empty]
cbaltree2 1 = [branch 'x' empty empty]
cbaltree2 n = if n `mod` 2 == 1
              then [branch 'x' l r | l <- lowertreenorm, r <- lowertreenorm]
              else concat [[branch 'x' l r, branch 'x' r l] | l <- lowertreenorm, r <- cbaltree2 (n `div` 2)]
                where lowertreenorm = cbaltree2 ((n - 1) `div` 2)
