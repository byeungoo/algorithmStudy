import collections

def solution(participant, completion):
    p = collections.Counter(participant)
    c = collections.Counter(completion)
                
    s = p - c
    answer = ''
                            
    for el, _ in s.items():
        answer = el             
                                                
    return answer
