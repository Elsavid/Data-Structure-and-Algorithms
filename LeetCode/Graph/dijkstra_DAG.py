#leetcode 734
#Dijkstra Algorithm for Direcred Graph
#times[i] = (ui, vi, wi)

'''
Dijkstra Algorithm
In details, the algorithm performs the repeated moving
operations from S to C as follows:
 Move one vertex from S to C. Let us refer to that vertex as X. This vertex, X, must
satisfy the following:
1) It is either directly connected to v or directly connected to another vertex that is
already in C
2) Has the smallest distance to v among all the potential vertices that are considered
for movement to C
 Whenever the vertex X is moved to C, its distance is the smallest distance
(shortest path) to v
 Additionally, once this vertex X is chosen, move it to C and recheck all distances
of all vertices that have direct connection to X and are NOT yet in C. If a smaller
value than what we already have is found, update this value
 In each step, we also update how to go to these vertices (that is, through which
vertex); we refer to this vertex as the prior function
 The steps are repeated until all the graph vertices are moved to C. The final
obtained distances represent the shortest paths, and the prior functions indicate
the direction from v (through which vertex) to obtain these shortest paths to
each of the other vertices in the graph

O((n + m) log n)
'''
  
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, start: int) -> int:
        weights = [[None for _ in range(n+1)] for _ in range(n+1)]
        adj = defaultdict(list)
        opt = [float('inf') for _ in range(n+1)]
        
        for u,v,w in times:
            weights[u][v] = w
            adj[u].append(v)

        #queue is a priority queue
        queue = []
        heapq.heappush(queue,(0,start))
        opt[start] = 0

        while queue:
            #u is the selected vetex to move to Cloud
            #minimal value for u is d, and is found, will not be changed
            d,u = heapq.heappop(queue)
            if u in adj:
                neighbours = adj[u]
                for v in neighbours:
                    total = weights[u][v] + opt[u]
                    #Add or update the so far minimal value for v
                    if total < opt[v]:
                        opt[v] = total
                        heapq.heappush(queue,(opt[v],v))
        
        res = max(opt[1:])
        return res if res != float('inf') else -1


