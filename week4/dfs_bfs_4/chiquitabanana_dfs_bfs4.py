from collections import defaultdict

def solution(tickets):
    routes = []
    route = ['ICN']

    # 현재 경로까지 사용된 ticket
    tickets_used = set()

    # 목적지 별 사용가능한 티켓 번호 리스트
    tickets_dict = defaultdict(list)
    for i, ticket in enumerate(tickets):
        tickets_dict[ticket[0]].append(i)
    
    # 굳이 nested function으로 구현할 필요는 없었는데..
    def dfs(next):
        nonlocal tickets_used
        nonlocal route
        
        # 티켓을 모두 사용한 경우 정답에 추가, 리턴
        if len(tickets_used) == len(tickets):
            routes.append(route)
            return
        
        for n in tickets_dict[next]:
            if n not in tickets_used:
                '''
                    공항(next)에서 사용할 수 있는 티켓 중
                    아직 사용하지 않은 티켓 사용
                    dfs 호출 후 사용 전 상태로 되돌려준다
                '''
                tickets_used.add(n)
                route.append(tickets[n][1])
                dfs(tickets[n][1])
                tickets_used.remove(n)
                route = route[:len(route)-1]
        return

    dfs('ICN')

    # 가능한 경로가 2개 이상인 경우 알파벳 순서가 앞서는 경로 반환
    return sorted(routes)[0]

if __name__ == '__main__':
    tickets = [['ICN', 'SFO'], ['ICN', 'ATL'], ['SFO', 'ATL'], ['ATL', 'ICN'], ['ATL','SFO']]

    print(f'answer ::: {solution(tickets)}')