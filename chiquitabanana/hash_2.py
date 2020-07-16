def solution(phone_book):
    """
    phone_book.sort()

    d = []
    for num in phone_book:
        for dd in d:
            if num.startswith(dd):
                return False
        d.append(num)

    return True
    """

    d = {}

    for phone_num in phone_book:
        d[phone_num] = 1

    for phone_num in phone_book:
        for i in range(len(phone_num)):
            if phone_num[:i] in d:
                return False
    return True
