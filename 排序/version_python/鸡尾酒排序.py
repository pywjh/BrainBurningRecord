def cock_tail__sort(array=[]):
    """
    鸡尾酒排序

    一次大的遍历
    - 从左到右一遍
    - 从右到左一遍
        遍历第一次
        6, 7, 8, 1, -1
        ----------------从左到右，从小到大依次交换
        6, 7, 8, -1, 1
        ----------------从右到左，从小到大一次交换
        6, 7, -1, 8, 1
        ----------------
        -1, 6, 7, 8, 1
        ----------------
        遍历第二次       从左到右，从小到大依次交换
        -1, 6, 7, 1, 8
        ----------------从右到左，从小到大一次交换
        -1, 6, 1, 7, 8
        ----------------
        -1, 1, 6, 7, 8
        遍历第三次
        is_sorted = True
        结束
    """
    for i in range(len(array) // 2):
        # 有序标记，每一轮的初始是true
        is_sorted = True
        # 奇数轮，从左向右比较和交换
        for j in range(i, len(array)-i-1):
            if array[j] > array[j+1]:
                array[j], array[j+1] = array[j+1], array[j]
                # 有元素交换，所以不是有序，标记变为false
                is_sorted = False
        if is_sorted:
            break
        # 偶数轮之前，重新标记为true
        is_sorted = True
        # 偶数轮，从右向左比较和交换
        for j in range(len(array)-i-1, i, -1):
            if array[j] < array[j-1]:
                array[j], array[j-1] = array[j-1], array[j]
                # 有元素交换，所以不是有序，标记变为false
                is_sorted = False
        if is_sorted:
            break


my_array = list([3, 4, 14, 1, 5, 6, 7, 8, 1, -1, 0, 9, 11])
cock_tail__sort(my_array)
print(my_array)

# [-1, 0, 1, 1, 3, 4, 5, 6, 7, 8, 9, 11, 14]