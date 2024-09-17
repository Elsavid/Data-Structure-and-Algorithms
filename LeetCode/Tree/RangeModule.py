class TreeNode:
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.left = None
        self.right = None

    @classmethod
    def create(cls,start,end):
        if start<end:
            return cls(start,end)
        else:
            return None


class RangeModule:
    def __init__(self):
        self.root = None


    def addRange(self,start,end):
        if not self.root:
            self.root = TreeNode(start,end)
        else:
            self.root = self._addRange(self.root,start,end,False,[start,end])
    
    def _addRange(self, node, start, end, tag, range):
        if not node:
            return None
        
        if start >= node.start and end <= node.end:
            return node
        
        # If the range lies completely to the left
        if end < node.start:
            if node.left:
                node.left = self._addRange(node.left, start, end,tag,range)
            else:
                if not tag:
                    self.__addLeft(node,[start,end])
            return node
        
        # If the range lies completely to the right
        elif start > node.end:
            if node.right:
                node.right = self._addRange(node.right, start, end,tag,range)
            else:
                if not tag:
                    self.__addRight(node,[start,end])
            return node
        
        # If the range lies on the left side
        elif end <= node.end and start < node.start: 
            if not tag:
                tag = "left"
                node.left = self._addRange(node.left, start, end, tag, range)
                node.start = min(start,range[0])  
            else:
                #max found
                range[1] = node.end
                return node.right
            
        #If the range lies on the right side
        elif start >= node.start and end > node.end:
            if not tag:
                tag = "right"
                node.right = self._addRange(node.right, start, end, tag,range)
                node.end = max(end,range[1])
                
            else:
                #min found
                range[0] = node.start
                return node.left
        
        else:
            if not tag:
                node.left = self._addRange(node.left,start,end,"left",range)
                node.right = self._addRange(node.right,start,end,"right",range)
                node.start = min(range[0],node.start)
                node.end = max(range[1],node.end)

            if tag == "left":

                node = self._addRange(node.left,start,end,tag,range)

            if tag == "right":
                node = self._addRange(node.right,start,end,tag,range)
        # Overlapping or adjacent ranges, merge them
        # Remove any overlapping ranges in the children        
        return node


    def __addLeft(self,node,range):
        node.left = TreeNode(range[0],range[1])

    def __addRight(self,node,range):

        node.right = TreeNode(range[0],range[1])


    
    def _remove_range(self, node, start, end):
        if not node:
            return None
        
        # If the range lies completely to the left
        if end <= node.start:
            node.left = self._remove_range(node.left, start, end)
        
        # If the range lies completely to the right
        elif start >= node.end:
            node.right = self._remove_range(node.right, start, end)
        
        # Overlapping range, split the node if necessary
        else:
            left = TreeNode.create(node.start,start)
            right = TreeNode.create(end,node.end)
            #inner  
            if start > node.start and end < node.end:
                left.left = node.left
                right.right = node.right

            #remove the right
            if start > node.start and end >= node.end:
                right = self._remove_range(node.right,start,end)
                left.left = node.left
                left.end = start
                # node.left = self._add_range(node.left, node.start, start)
            
            #remove the left
            if start <= node.start and end < node.end:
                left = self._remove_range(node.left,start,end)
                right.start = end
                right.right  = node.right

            #remove the entire range 
            if start == node.start and end == node.end:
                left = node.left
                right = node.right
                # node.right = self._add_range(node.right, end, node.end)
            
            if start < node.start and end > node.end:
                left = self._remove_range(node.left,start,end)
                right = self._remove_range(node.right,start,end)

            return self._merge(left,right)
        
        return node

    def removeRange(self, start: int, end: int) -> None:
        """Remove a range [start, end) from the module."""
        self.root = self._remove_range(self.root, start, end)
        if self.root:
            self.addRange(self.root.start,self.root.end)

    def _query_range(self, node, start, end):
        if not node:
            return False
        
        # If the range lies completely to the left
        if end <= node.start:
            return self._query_range(node.left, start, end)
        
        # If the range lies completely to the right
        elif start >= node.end:
            return self._query_range(node.right, start, end)
        
        # If the range is covered by the current node
        elif start >= node.start and end <= node.end:
            return True
        
        return False

    def queryRange(self, start: int, end: int) -> bool:
        """Check if the range [start, end) is fully covered by the module."""
        return self._query_range(self.root, start, end)

    def _merge(self, left, right):
        """Helper function to merge two BST subtrees."""
        if not left:
            return right
        if not right:
            return left
        
        # Find the rightmost node of the left subtree
        node = left
        while node.right:
            node = node.right
        
        node.right = right
        return left
    
def print_inorder(root):
    if root:
        # Traverse the left subtree first
        print(root.start,root.end)
        print_inorder(root.left)
        # Print the root node value
        # Traverse the right subtree
        print_inorder(root.right)

obj = RangeModule()
operations = ["RangeModule","queryRange","queryRange","addRange","addRange","queryRange","queryRange","queryRange","removeRange","addRange","removeRange","addRange","removeRange","removeRange","queryRange","queryRange","queryRange","queryRange","removeRange","addRange","removeRange","queryRange","addRange","addRange","removeRange","queryRange","removeRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange","queryRange","queryRange","addRange","removeRange","addRange","addRange","addRange","queryRange","removeRange","addRange","queryRange","addRange","queryRange","removeRange","removeRange","addRange","addRange","queryRange","queryRange","addRange","addRange","removeRange","removeRange","removeRange","queryRange","removeRange","removeRange","addRange","queryRange","removeRange","addRange","addRange","queryRange","removeRange","queryRange","addRange","addRange","addRange","addRange","addRange","removeRange","removeRange","addRange","queryRange","queryRange","removeRange","removeRange","removeRange","addRange","queryRange","removeRange","queryRange","addRange","removeRange","removeRange","queryRange"]
parameters = [[],[21,34],[27,87],[44,53],[69,89],[23,26],[80,84],[11,12],[86,91],[87,94],[34,52],[1,59],[62,96],[34,83],[11,59],[59,79],[1,13],[21,23],[9,61],[17,21],[4,8],[19,25],[71,98],[23,94],[58,95],[12,78],[46,47],[50,70],[84,91],[51,63],[26,64],[38,87],[41,84],[19,21],[18,56],[23,39],[29,95],[79,100],[76,82],[37,55],[30,97],[1,36],[18,96],[45,86],[74,92],[27,78],[31,35],[87,91],[37,84],[26,57],[65,87],[76,91],[37,77],[18,66],[22,97],[2,91],[82,98],[41,46],[6,78],[44,80],[90,94],[37,88],[75,90],[23,37],[18,80],[92,93],[3,80],[68,86],[68,92],[52,91],[43,53],[36,37],[60,74],[4,9],[44,80],[85,93],[56,83],[9,26],[59,64],[16,66],[29,36],[51,96],[56,80],[13,87],[42,72],[6,56],[24,53],[43,71],[36,83],[15,45],[10,48]]
for op, params in zip(operations[1:], parameters[1:]):
    if op == "addRange":
        obj.addRange(*params)
        print(op,params)
        print("Tree:")
        print_inorder(obj.root)
        print("-------------------------------")

    elif op == "queryRange":
        print(obj.queryRange(*params))
    elif op == "removeRange":
        print(op,params)
        obj.removeRange(*params)

        print("Tree:")
        print_inorder(obj.root)
        print("-------------------------------")
