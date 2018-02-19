-- finding greatest common divisor using Euclidean method
myGcd :: Int -> Int -> Int
myGcd a b
  | b < 0 = myGcd a (abs b)
  | b == 0 = a  -- stopping condition
  | otherwise = myGcd b (a `mod` b)  -- recursive call using (a mod b) as next argument
