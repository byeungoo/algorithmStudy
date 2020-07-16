def solution(participant, completion):
    answer = ''
    mapC = {}
    mapP = {}

    for c in completion:
        if c not in mapC:
            mapC[c] = 1
        else:
            mapC[c] += 1

    for p in participant:
        if p not in mapP:
            mapP[p] = 1
        else:
            mapP[p] += 1

    for k in mapP.keys():
        if k not in mapC or mapC[k] != mapP[k]:
            answer = k
            break

    return answer