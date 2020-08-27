def solution(triangle):
    for i, li in enumerate(triangle[1:], 1):
        for j in range(i + 1):
            if j == 0: 
                triangle[i][j] += triangle[i-1][j]
            elif j == i: 
                triangle[i][j] += triangle[i-1][j-1]
            else: 
                triangle[i][j] += triangle[i-1][j] if triangle[i-1][j] > triangle[i-1][j-1] else triangle[i-1][j-1]
    return max(triangle[i])

if __name__ == '__main__':
    triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
    
    print(solution(triangle))