def merge_sort(array, start, end):
    """
    归并排序
        [8, 4, 5, 7, 1, 3, 6, 2]
        ----------------------------------
        [4, 8]
        ----------------------------------
        [5, 7]
        ----------------------------------
        [4, 5, 7, 8]
        ----------------------------------
        [1, 3]
        ----------------------------------
        [2, 6]
        ----------------------------------
        [1, 2, 3, 6]
        ----------------------------------
        [1, 2, 3, 4, 5, 6, 7, 8]
    """
    if start < end:
        # 折半成两个小集合，分别进行递归
        mid = (start + end) // 2;
        merge_sort(array, start, mid)
        merge_sort(array, mid + 1, end)
        # 把两个有序小集合，归并成一个大集合
        merge(array, start, mid, end)


def merge(array, start, mid, end):
    temp_list = [0 for i in range(end - start + 1)]
    p1 = start
    p2 = mid + 1
    p = 0
    # 比较两个小集合的元素，依次放入大集合
    while p1 <= mid and p2 <= end:
        if array[p1] <= array[p2]:
            temp_list[p] = array[p1]
            p += 1
            p1 += 1
        else:
            temp_list[p] = array[p2]
            p += 1
            p2 += 1

    # 左侧小集合还有剩余，依次放入大集合尾部
    while (p1 <= mid):
        temp_list[p] = array[p1]
        p += 1
        p1 += 1
    # 右侧小集合还有剩余，依次放入大集合尾部
    while p2 <= end:
        temp_list[p] = array[p2]
        p += 1
        p2 += 1

    p = 0
    while start <= end:
        array[start] = temp_list[p]
        start += 1
        p += 1


if __name__ == '__main__':
    array = [8, 4, 5, 7, 1, 3, 6, 2]
    merge_sort(array, 0, len(array) - 1)
    print(array)

