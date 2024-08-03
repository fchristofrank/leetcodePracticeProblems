class Solution:

    def isSafe(self,matrix,i,j,n):
    
        #Check Horizontally
        if matrix[i].count("Q") > 0:
            return False
        
        #Check Vertically
        for col in range(n):
            if (matrix[col][j] == "Q"):
                return False
        
        #Diagonal1 (Left -> Go UP)
        itrRow = i
        itrCol = j
        while (itrRow>=0 and itrCol>=0):
            if matrix[itrRow][itrCol] == "Q":
                return False
            itrRow -= 1
            itrCol -= 1
        
        #Diagonal2 (Right -> Go Up)
        itrRow = i-1
        itrCol = j+1
        while (itrRow>=0 and itrCol<n):
            if matrix[itrRow][itrCol] == "Q":
                return False
            itrRow -= 1
            itrCol += 1
    
        return True

    def traverseMatrix(self,result,matrix,row,n,N):
        
        if N==0:
            
            result.append(["".join(row) for row in matrix])
            return
        
        for col in range(n):
            if (self.isSafe(matrix,row,col,n)):
                matrix[row][col] = "Q"
                self.traverseMatrix(result,matrix,row+1,n,N-1)
                matrix[row][col] = "."
        
        return result

    def solveNQueens(self, n: int):
        N = n #Number of Queens
        result = []
        matrix = [["."] * n for _ in range(n)]
        result = self.traverseMatrix(result,matrix,0,n,N)
        #print(result)
        return result
