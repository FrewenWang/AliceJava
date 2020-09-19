package com.frewen.algorithm.demo.array;

/**
 * https://mp.weixin.qq.com/s?__biz=MjM5MjAwODM4MA==&mid=2650731401&idx=3&sn=a4f2980764b5d247e5aebccb598ae45f&chksm=bea6825a89d10b4c936f67c203344adf753b24b1edf1e69b7e2ea9c07042f7b011e8a6828119&mpshare=1&scene=1&srcid=&sharer_sharetime=1572313570920&sharer_shareid=05b380c8ebc3fafea8d5f4c6cd79b840#rd
 */
public class RemoveIndexWithMaxProduct {


    public int findRemovedIndex(int[] array) {
        // 1.统计负元素的个数
        int negativeCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                ++negativeCount;
            }
        }
        // 2.根据不同情况，选择要删除的元素
        int resultIndex = 0;


        return resultIndex;
    }
}

