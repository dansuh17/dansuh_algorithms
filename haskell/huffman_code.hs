import Data.List (insertBy, sortBy)
import Data.Ord (comparing)
-- huffman codes : a variable-length coding using prefix codes
-- 1. build a Huffman Tree
-- 2. draw the path using 0 / 1 bits
-- refer: https://mitpress.mit.edu/sicp/full-text/sicp/book/node41.html

-- define a tree
data HuffmanTree a = Leaf a | Branch (HuffmanTree a) (HuffmanTree a)
  deriving Show

-- insertBy :: (a -> a -> Ordering) -> a -> [a] -> [a]
-- sortBy :: (a -> a -> Ordering) -> [a] -> [a]
-- comparing :: Ord a => (b -> a) -> b -> b -> Ordering
huffman :: (Ord a, Ord w, Num w) => [(a, w)] -> [(a, [Char])]
huffman freq = sortBy (comparing fst) $ serialize $ htree
  $ sortBy (comparing fst) [(w, Leaf x) | (x, w) <- freq]
  where
    htree [(_, t)] = t
    htree ((w1, t1):(w2, t2):wts) = htree $ insertBy (comparing fst) (w1 + w2, Branch t1 t2) wts
    serialize (Branch l r) =
      [(x, '0':code) | (x, code) <- serialize l] ++ [(x, '1':code) | (x, code) <- serialize r]
    serialize (Leaf x) = [(x, "")]
