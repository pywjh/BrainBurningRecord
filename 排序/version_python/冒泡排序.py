def bubble_sort(array=[]):
    """
    冒泡排序

    遍历，索引i值与索引i+1值相比，大于就交换

        第一次遍历
        6, 7, 8, 1, -1
        ------------------一次大小交换
        6, 7, 8, -1, 1
        ------------------第二次遍历
        6, 7, -1, 8, 1
        ------------------
        6, 7, -1, 1, 8
        ------------------第三次遍历
        6, -1, 7, 1, 8
        ------------------
        6, -1, 1, 7, 8
        ------------------第四次遍历
        -1, 6, 1, 7, 8
        ------------------
        -1, 1, 6, 7, 8
        is_sorted = True 
        结束
    """
    # 无序数列的边界，每次比较只需要比到这里为止
    sort_border = len(array)-1
    for i in range(len(array)-1):
        # 有序标记，每一轮的初始是true
        is_sorted = True
        for j in range(sort_border):
            if array[j] > array[j+1]:
                array[j], array[j+1] = array[j+1], array[j]
                # 有元素交换，所以不是有序，标记变为false
                is_sorted = False
                # 把无序数列的边界更新为最后一次交换元素的位置
                sort_border = j
        if is_sorted:
            break


my_array = list([3, 4, 14, 1, 5, 6, 7, 8, 1, -1, 0, 9, 11])
bubble_sort(my_array)
print(my_array)