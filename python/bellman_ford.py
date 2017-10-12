import math


def bellman_ford(start, num_nodes, edges):
    dist = [math.inf] * num_nodes
    dist[start] = 0  # starting point

    # Iterate through all edges N - 1 times.
    # This comes from the fact that maximum possible number of edges
    # required to reach the furthest node is N - 1.
    for _ in range(num_nodes - 1):
        for from_node, to_node, length in edges:
            if dist[from_node] is not math.inf and dist[from_node] + length < dist[to_node]:
                dist[to_node] = dist[from_node] + length

    # Now dist[] contains distances from start.

    # Run once more to detect any negative cycles
    # If another iteration updates the distance, it means there is a negative cycle.
    for _ in range(num_nodes - 1):
        for from_node, to_node, length in edges:
            if dist[from_node] is not math.inf and dist[from_node] + length < dist[to_node]:
                raise Exception('Negative cycle exists!')

    return dist


if __name__ == '__main__':
    edges = ((0, 1, 9), (0, 2, 4), (1, 2, 3), (1, 4, 2), (1, 3, 2), (4, 1, 1), (4, 3, 5), (5, 4, -3))
    print(bellman_ford(0, 6, edges))
