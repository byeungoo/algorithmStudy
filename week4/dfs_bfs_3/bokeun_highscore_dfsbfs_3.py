from collections import deque


def solution(begin, target, words):
    if target not in words:
        return 0

    words.append(begin)
    convertible = find_convertible(words)

    visited = []
    queue = deque([(begin, 0)])
    while queue:
        node = queue.popleft()
        if node[0] == target:
            return node[1]
        visited.append(node[0])
        for next in convertible[node[0]]:
            if next not in visited:
                queue.append((next, node[1] + 1))

    return 0


def find_convertible(words):
    convertible = dict()

    for word in words:
        tmp = []
        for w in words:
            if w != word and is_convertible(w, word):
                tmp.append(w)
        convertible[word] = set(tmp)

    return convertible


def is_convertible(word1, word2):
    same_cnt = 0
    for i in range(len(word1)):
        if word1[i] == word2[i]:
            same_cnt += 1

    if same_cnt == len(word1) - 1:
        return True

    return False


b1 = "hit"
t1 = "cog"
w1 = ["hot", "dot", "dog", "lot", "log", "cog"]
b2 = "hit"
t2 = "cog"
w2 = ["hot", "dot", "dog", "lot", "log"]

print(solution(b1, t1, w1))
print(solution(b2, t2, w2))
