function solution(record) {
    const idMap = new Map();

    record.forEach((v) => {
        const [action, id, name] = v.split(" ");
        if (action !== "Leave") {
            idMap.set(id, name);
        }
    });

    return record
        .map((v) => {
            const [action, id, name] = v.split(" ");
            if (action === "Enter") {
                return `${idMap.get(id)}님이 들어왔습니다.`;
            } else if (action === "Leave") {
                return `${idMap.get(id)}님이 나갔습니다.`;
            } else {
                return;
            }
        })
        .filter((v) => v !== undefined);
}

console.log(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]));
