
from collections import defaultdict

def solution(genres, plays):
    answer = []
    genre_sum = defaultdict(int)
    genre_plays = defaultdict(list)

    for i, g in enumerate(genres):
        genre_sum[g] += plays[i]
        genre_plays[g].append((plays[i], i))

    s = sorted(genre_sum.items(), key=lambda x: x[1], reverse=True)

    for g, _ in s:
        genre_plays[g].sort(key=lambda x: x[0], reverse=True)
        for _, i in genre_plays[g][:2]:
            answer.append(i)

    return answer
