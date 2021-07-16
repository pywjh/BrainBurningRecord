def main(ary, item):
    low = 0
    high = len(ary) - 1

    while low <= high:
        mid_index = (low+high) // 2  # 中间索引位
        mid_value = ary[mid_index]  # 中间值

        if mid_value == item:
            return mid_index
        elif mid_value < item:
            low = mid_index + 1
        else:  # mid_value > item:
            high = mid_index - 1
    return None

ary = [1, 3, 4, 56, 78, 99]
print(main(ary, 3)) # 1