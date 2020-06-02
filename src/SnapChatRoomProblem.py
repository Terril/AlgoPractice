def find_nr_rooms_fast(intervals):
    D = {}
    for v in intervals:
        D[v[0]] = D[v[0]]+1 if v[0] in D else 1
        D[v[1]] = D[v[1]]-1 if v[1] in D else -1
    sorted_events = sorted(D.items())# O(n.log(n))
    max_rooms = 0
    rooms = 0
    for k, v in sorted_events:
        rooms += v
        if rooms > max_rooms: max_rooms = rooms
    return max_rooms

def find_nr_rooms(intervals):
    max_rooms = 0
    for v in intervals:
        rooms=1
        for u in intervals:
            if u[0]>v[0] and u[0]<v[1]:
                rooms += 1
        if rooms > max_rooms: max_rooms = rooms
    return max_rooms

lectures = [(30, 75), (0, 50), (60, 150), (0, 500), (40, 70)]
print('Max Rooms', find_nr_rooms(lectures))
print('Max Rooms Fast', find_nr_rooms_fast(lectures))