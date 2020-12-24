def solution(tickets):
    ticket_map = dict()
    for departure, arrival in tickets:
        if departure not in ticket_map:
            ticket_map[departure] = []
        ticket_map[departure].append(arrival)
    for departure in ticket_map:
        ticket_map[departure].sort(reverse=True)

    routes = []
    stack = ["ICN"]
    while stack:
        departure = stack[-1]
        if departure in ticket_map and len(ticket_map[departure]) != 0:
            stack.append(ticket_map[departure].pop())
        else:
            routes.append(stack.pop())
    routes.reverse()

    return routes


t1 = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]  # ICN - JFK - HND - IAD
t2 = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]  # ICN - ATL - ICN - SFO - ATL -SFO
t3 = [["ICN", "SFO"], ["SFO", "ATL"], ["SFO", "JFK"], ["JFK", "SFO"]]  # ICN - SFO - JFK - SFO - ATL
t4 = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "JFK"], ["JFK", "ICN"]]  # ICN - SFO - JFK - ICN - ATL
t5 = [["ICN", "HND"], ["ICN", "SFO"], ["ICN", "JFK"], ["JFK", "ICN"], ["HND", "ICN"]]  # ICN - HND - ICN - JFK - ICN - SFO
t6 = [["ICN", "JFK"], ["JFK", "ATL"], ["JFK", "IAD"], ["IAD", "HND"], ["HND", "JFK"]]  # ICN - JFK - IAD - HND - JFK - ATL
t7 = [["ICN", "JFK"], ["JFK", "ICN"], ["ICN", "JFK"], ["JFK", "ICN"]]  # ICN - JFK - ICN - JFK - ICN
t8 = [["ICN", "HND"], ["ICN", "IAD"], ["IAD", "JFK"], ["JFK", "IAD"], ["HND", "JFK"], ["JFK", "HND"], ["HND", "ICN"], ["IAD", "HND"]]  # ICN - HND - JFK - HND - ICN - IAD - HND - JFK - IAD

# print(solution(t1))
# print(solution(t2))
# print(solution(t3))
# print(solution(t4))
# print(solution(t5))
# print(solution(t6))
# print(solution(t7))
print(solution(t8))
