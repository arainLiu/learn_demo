package com.nirvana.travel.algorithm.a000_baseSort.heapsort;

public class HeapSort_01 {

    public static void main1(String[] args) {
        int[] arr = {3,2,1,6,7,8,5,1,9};
        MyMaxHeap heap = new MyMaxHeap(11);
        for (int i : arr) {
            heap.push(i);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.pop());
        }
    }

    public static class MyMaxHeap {
        //存放堆的数组
        private int[] heapArr;
        //堆大小
        private int limit;
        //堆中元素数
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.heapArr = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public boolean isEmpty() {return heapSize == 0; }

        public boolean isFull() { return heapSize == limit;}

        /**
         * 插入一个元素
         * @param value
         */
        public void push(int value) {
            //判断堆是否已经满了
            if (isFull()) {
                throw new RuntimeException("heap if full");
            }
            //将元素放到数组尾部,heapSize ++
            heapArr[heapSize ++] = value;
            //insert元素，传入待调整位置的元素的下标index
            heapInsert(heapArr, heapSize - 1);
        }

        /**
         * 弹出一个元素
         * @return
         */
        public int pop() {
            //需要pop的元素为数组第一个元素
            int ans = heapArr[0];
            //将最后一个元素和第一个交换,--heapSize既把size减一，同时也指向最后一个元素的index
            swap(heapArr, 0, --heapSize);
            //在[0...size]上重新进行堆化处理
            heapify(heapArr, 0, heapSize);
            return ans;
        }

        //位于index位置的元素进行插入操作
        private void heapInsert(int[] arr,int index) {
            //如果当前节点大于父节点的值，进行交换
            while (arr[index] > arr[(index - 1) / 2]) {
                //交换位置，并将index重置
                swap(arr, index, (index - 1) / 2);
                //index指向原节点的父节点
                index = (index - 1) / 2;
            }
        }

        //从index位置往下进行堆化处理，保证每一个位置的元素都满足大根堆要求
        private void heapify(int[] arr, int index, int heapSize) {
            //index的左子节点
            int left = 2 * index + 1; //数组下标从0开始
            while (left < heapSize) {//保证左子树不越界，就算是没有右子树，index也是要和index进行比较的
                //找到左、右子节点中较大的元素，记录下来，用来和index处的元素比较大小
                int largest = left;
                if (left + 1 < heapSize) {//右子节点不越界时
                    largest = arr[left] > arr[left+1] ? left : left + 1;
                }

                //当largest位置元素 > index位置，即子节点>父节点时，数据交换
                if (arr[largest] > arr[index]) {
                    swap(arr, index, largest);
                    //此时largest位置为待调整节点
                    index = largest;
                    //对while条件中left重新赋值
                    left = 2 * index + 1;
                } else {
                    //左右子树的值都比index小，直接return
                    break;
                }
            }
        }

        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }
    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");

    }
}
