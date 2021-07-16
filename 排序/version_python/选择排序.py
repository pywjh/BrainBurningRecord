# 版本1
def main(ary):
    for i in range(len(ary)-1):  # 做第i趟排序
        k = i
        j = i + 1
        while j < len(ary):  # 选最小的记录
            if ary[j] < ary[k]:
                k = j  # 记下目前找到的最小值所在的位置
            j += 1
        # 在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
        if i != k:
            ary[i], ary[k] = ary[k], ary[i]  # 交换a[i]和a[k]
    return ary

# 版本2
# 这个版本比较容易理解
# 但是空间复杂度相比版本1
# 版本1：O(1)；版本2：O(n)
def main2(ary):
    def find_min(ary):
        min_num = float('inf')
        min_index = 0
        for i, v in enumerate(ary):
            if v < min_num:
                min_num = v
                min_index = i
        return min_index
    res = []
    while ary:
        min_index = find_min(ary)
        res.append(ary.pop(min_index))

    return res  
    
if "__main__" == __name__:
    ary = [1, 34, 22, 54, 66, 22, 91]
    print(main(ary))  # [1, 22, 22, 34, 54, 66, 91]
    print(main2(ary))  # [1, 22, 22, 34, 54, 66, 91]