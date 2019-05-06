The problem boils down to this: given a sequence of strictly positive and non zero integers (generally unordered and possibly with duplicates), find the highest number of elements we can take such  that their sum does NOT fall into class of remainder zero mod k.

My first solution was to compute each sum from the combinations of the initial array, take its remainder mod k and inserting the proper elements in the non divisible subset, then counting the elements of the set. It worked with the simplest test cases but it turned out to be highly inefficient when the quantities grew high.

A more efficient approach comes from considering the cyclic group of the classes of remainder mod k. If we take two arbitrary elements from the starting array, say s_i and s_j, they respectively belong to the classes [s_i mod k] and [s_j mod k]. For brevity, we shall just say that every element in the starting array belongs to one of the classes [0], [1], [2], ..., [k-1] , depending of the value of s mod k.

Now, by the properties of this quotient group, [i] + [j] = [i+j]. This means that if we take two arbitrary integers from any two classes (not necessarily distinct), then their sum falls into the class that is the sum of the classes the integers are coming from. This result allows us to work only with the classes and not with the single integers.

No matter the size of the starting array, the key step is to "project" the starting array in the quotient group defined by the integer k.

We end up with an array of length k where the index is the actual class of remainder mod k and the value is the number of integers from the initial array which falls into that class.

Such array can be represented as `F = [ f_0  f_1  f_2 ... f_(k-1) ]` . `f_0` is the number of integers `s ` in `S` for which `s mod k = 0` , `f_1` is the number of integers `s ` in `S` for which `s mod k = 1`, and so on.

To compute the set required we must take into account at least two things:
1. we can take AT MOST one element from class 0 (if we took two, their sum would be divisible by k)
2. if we take an element from `[f_1]` we must exclude every element from `[f_(k-1)]`. If not, their sum would fall into `[0]`, which is not allowed.

Actually, point (2) is the key to speed up the selection of the elements of the required maximal subset. Once dealed with `[0]`, we only have to scan the `F` array starting from index 1, selecting the maximum value between `f_i` and its "specular" `f_(k-i)`.

Some attention has to be paid to the fact that this approach has a slight divergence when we reach the "middle" of the `F` array.