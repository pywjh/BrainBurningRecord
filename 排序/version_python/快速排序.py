def partition_v1(start_index, end_index, array):
    """
    快速排序(双边循环法)
        ----------------------
        3, 4, 14, 1, 5, 6, 7
        标记索引开始位3
        ----------------------从右向左
        索引6的7＞3 and 索引6>索引0，跳过
        索引5的6＞3 and 索引5>索引0，跳过
        索引4的5＞3 and 索引4>索引0，跳过
        索引3的1＜3 and 索引3>索引0
        3, 4, 14,  , 5, 6, 7
                  1（索引3）
        ----------------------从左到右
        索引0的3=3 and 索引0 < 索引3，跳过
        索引1的4>3 and 索引1 < 索引3
        3,  , 14, 1, 5, 6, 7
           4（索引1）
        ----------------------索引1 < 索引3，交换
        3, 1, 14, 4, 5, 6, 7
        ----------------------因为索引1 != 索引3，重复
        接着从右到左
        索引3的4>3 and 索引3 > 索引1，跳过
        索引2的14>3 and 索引2 > 索引1，跳过
        右到左的索引1 = 左到右的索引1
        将开始标记的索引开始位3和索引1互换
        1, 3, 14, 4, 5, 6, 7
        ----------------------
        以索引1为截断点，将原来的数组一分为二
        一个0 - 索引点-1
        一个索引点+1 - end
        重复
    """
    # 取第一个位置的元素作为基准元素（也可以选择随机位置）
    pivot = array[start_index]
    left = start_index
    right = end_index
    while left != right:
        # 控制right指针比较并左移
        while left < right and array[right] > pivot:
            right -= 1
        # 控制left指针比较并右移
        while left < right and array[left] <= pivot:
            left += 1
        # 交换left和right指向的元素
        if left < right:
            array[left], array[right] = array[right], array[left]
    # pivot和指针重合点交换
    array[start_index] = array[left]
    array[left] = pivot
    return left

def partition_v2(start_index, end_index, array=[]):
    """
    快速排序(单边循环法)
        3, 4, 14, 1, 5, 6, 7
        记录索引0,值为3，并将索引0作为标记点
        -------------------------从索引0后一位开始遍历
        4 > 3, pass
        14 > 3, pass
        -------------------------
        1 < 3
        标记点右移再用标记点与1交换(标记点为1)
        3, 1, 14, 4, 5, 6, 7
        -------------------------
        4, 5, 6, 7 都 > 3, pass
        遍历完成后将索引0与标记点互换
        1, 3, 14, 4, 5, 6, 7
        返回标记点1
        -------------------------
        以标记点为截断点，将原来的数组一分为二
        一个0 - 标记点-1
        一个标记点+1 - end
        重复
    """
    # 取第一个位置的元素作为基准元素（也可以选择随机位置）
    pivot = array[start_index]
    mark = start_index
    for i in range(start_index+1, end_index+1):
        if array[i] < pivot:
            mark += 1
            array[mark], array[i] = array[i], array[mark]
    array[start_index] = array[mark]
    array[mark] = pivot
    return mark


def quick_sort(start_index, end_index, array=[]):
    # 递归结束条件：startIndex大等于endIndex的时候
    if start_index >= end_index:
        return
    # 得到基准元素位置
    pivot_index = partition_v2(start_index, end_index, array)
    # 根据基准元素，分成两部分递归排序
    quick_sort(start_index, pivot_index - 1, array)
    quick_sort(pivot_index + 1, end_index, array)

my_array = list([3, 4, 14, 1, 5, 6, 7])
quick_sort(0, len(my_array)-1, my_array)
print(my_array)
