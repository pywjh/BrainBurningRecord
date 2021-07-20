def down_adjust(array, parent_index, length):
    """
    下沉函数
    """
    # 保存父节点值，用于最后的赋值
    parent_value = array[parent_index]
    child_index = 2 * parent_index + 1
    while child_index < length:
        # 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
        if (child_index + 1) < length and array[child_index + 1] > array[child_index]:
            child_index += 1
        # 如果父节点大于等于任何一个孩子的值，直接跳出
        if parent_value >= array[child_index]:
            break
        # 无需真正交换，单向赋值即可
        array[parent_index] = array[child_index]
        parent_index = child_index
        child_index = 2 * parent_index + 1
    array[parent_index] = parent_value


def heap_sort(array):
    # 1.把无序数组构建成最大堆。
    for i in range((len(array)-2) // 2, -1, -1):
        down_adjust(array, i, len(array))
    # 最大堆
    # [9, 6, 8, 5, 4]
    print(array)
    # 2.循环交换集合尾部元素到堆顶，并调节堆产生新的堆顶。
    for j in range(len(array)-1, 0, -1):
        array[0], array[j] = array[j], array[0]
        # 下沉调整最大堆
        down_adjust(array, 0, j)


if __name__ == '__main__':
    array = [4,6,8,5,9]
    heap_sort(array=array)
    # [4, 5, 6, 8, 9]
    print(array)
