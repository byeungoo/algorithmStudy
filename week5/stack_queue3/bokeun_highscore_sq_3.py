from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0

    waiting_trucks = deque(truck_weights)

    bridge = deque()
    times_on_bridge = deque()
    weight_on_bridge = 0

    passed_trucks = deque()

    idx = 0
    while True:
        if answer != 0:
            time = times_on_bridge.popleft()
            if answer - time >= bridge_length:
                off_truck = bridge.popleft()
                passed_trucks.appendleft(off_truck)
                weight_on_bridge -= off_truck
            else:
                times_on_bridge.appendleft(time)

        if len(waiting_trucks) != 0 and weight_on_bridge + truck_weights[idx] <= weight:
            on_truck = waiting_trucks.popleft()
            bridge.append(on_truck)
            times_on_bridge.append(answer)
            weight_on_bridge += on_truck
            idx += 1

        answer += 1

        if len(bridge) == 0:
            break

    return answer


bl1 = 2
w1 = 10
tw1 = [7, 4, 5, 6]

bl2 = 100
w2 = 100
tw2 = [10]

bl3 = 100
w3 = 100
tw3 = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]

bl4 = 1
w4 = 10
tw4 = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]

print(solution(bl1, w1, tw1))
print(solution(bl2, w2, tw2))
print(solution(bl3, w3, tw3))
print(solution(bl4, w4, tw4))
