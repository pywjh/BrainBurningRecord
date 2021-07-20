def down_adjust(array, parent_index, length):
    """
    下沉函数
    """
    parent_value = array[parent_index]
    child_index = 2 * parent_index + 1
    while child_index < length:
        if (child_index + 1) < length and array[child_index + 1] > array[child_index]:
            child_index += 1

        if parent_value >= array[child_index]:
            break

        array[parent_index] = array[child_index]
        parent_index = child_index
        child_index = 2 * parent_index + 1
    array[parent_index] = parent_value


def heap_sort(array):
    for i in range((len(array)-2) // 2, -1, -1):
        down_adjust(array, i, len(array))
    # 最大堆
    # [9, 6, 8, 5, 4]
    print(array)

    for j in range(len(array)-1, 0, -1):
        array[0], array[j] = array[j], array[0]
        down_adjust(array, 0, j)


if __name__ == '__main__':
    array = [4,6,8,5,9]
    heap_sort(array=array)
    # [4, 5, 6, 8, 9]
    print(array)
