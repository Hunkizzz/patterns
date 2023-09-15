SegmentTree Class:
The SegmentTree class is responsible for building and querying a segment tree.

tree: An array that holds the segment tree structure and values.
n: The number of elements in the original array.
Constructor (SegmentTree) and buildTree Method:
The constructor takes an input array and initializes the segment tree. The buildTree method is a helper function that recursively builds the segment tree.

buildTree: This method constructs the segment tree using a recursive approach. It starts by defining the base case: when the left and right indices are equal, indicating a single element. In this case, the tree node is assigned the value of the corresponding element in the input array.
The method then calculates the middle index of the current range and recursively calls buildTree for the left and right subtrees.
After building the left and right subtrees, the values of these subtrees are combined to update the value of the current tree node.
Query Methods (query and query Overload):
The query methods are used to perform range queries on the segment tree.

query: The public method that initializes the range query and calls the overloaded private query method.
query (overload): This private method is responsible for executing the range query. It has similar logic to the buildTree method but adapted for querying.
The method checks three cases: if the query range is completely outside the current segment, if the query range fully covers the current segment, or if the query range partially overlaps with the current segment.
If the query range is outside the current segment, the method returns 0 (indicating no contribution to the query result).
If the query range fully covers the current segment, the method returns the value of the current tree node.
If the query range partially overlaps, the method recursively queries the left and right subtrees and combines their results.
Main Class (Main):
The Main class contains the main method where you can test the segment tree implementation.

The example input array is {1, 3, 5, 7, 9, 11}.
An instance of SegmentTree is created using the input array.
Example tasks are performed using the segment tree:
sumInRange: The sum of elements in the range [1, 4] (indices 1 to 4) is calculated using the query method and printed.
sumFromIndex: The sum of elements from index 2 to 5 is calculated using the query method and printed.
Remember that the segment tree implementation provided here is basic and mainly serves as an example. Depending on your specific use case and requirements, you might need to add more features or optimizations to the segment tree.