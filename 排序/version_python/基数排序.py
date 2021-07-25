def get_char_index(string, k):
    """获取字符串第k位字符所对应的ascii码序号"""
    # 如果字符串长度小于k，直接返回0，相当于给不存在的位置补0
    return ord(string[k]) if len(string) > (k + 1) else 0

def radix_sort(array, max_len):
    """
    * 基数排序
         * 基于计数排序的基础进行排序，一次只比较一位，保持前面的排序结果，对第二位进行排序
         * 继而得到全局的排序
         * ["qd", "abc", "qwe", "hhh", "a", "cws", "ope"]
         * 通过倒数第一位进行排序
         * [qd, a, abc, qwe, ope, hhh, cws]
         * 通过倒数第二位进行排序
         * [a, abc, qd, hhh, ope, qwe, cws]
         * 倒数第三位进行排序
         * [a, abc, cws, hhh, ope, qd, qwe]
    """
    # 排序结果数组，用于存储每一次按位排序的临时结果
    sorted_array = [""] * len(array)
    # 从个位开始比较，一直比较到最高位
    for k in range(max_len - 1, -1, -1):
        # 计数排序的过程，分成三步：
        # 创建辅助排序的统计数组，并把待排序的字符对号入座
        # 这里为了代码简洁，直接使用ascii码范围作为数组长度
        count = [0] * (ord('z')+1)
        for i in range(len(array)):
            index = get_char_index(array[i], k)
            count[index] += 1
        
        # 统计数组做变形，后面的元素等于前面的元素之和
        for i in range(1, len(count)):
            count[i] = count[i] + count[i-1]

        # 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        for i in range(len(array)-1, -1, -1):
            index = get_char_index(array[i], k)
            sorted_index = count[index]-1
            sorted_array[sorted_index] = array[i]
            count[index] -= 1
        array = sorted_array.copy()
    return array

if __name__ == "__main__":
    array = ["qd", "abc", "qwe", "hhh", "a", "cws", "ope"]
    print(radix_sort(array, 3))