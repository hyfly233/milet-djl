package test;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.DataType;
import ai.djl.ndarray.types.Shape;

public class Basic {
    public static void main(String[] args) {

        try (NDManager manager = NDManager.newBaseManager()) {
            // 创建行向量 一维数组
            NDArray x = manager.arange(12);

            System.out.println(x);
            // 获取 NDArray 的维度信息 （每个轴的长度）
            System.out.println(x.getShape());

            System.out.println(" --------------- ");

            // 稳定的改变维度  元素个数不变  相当于 shape(1, 12) -> shape(3, 4)
            // NDArray b = manager.arange(3f).reshape(1, 2); 报错 因为3个元素无法组成 1 * 2 的二维数组
            x = x.reshape(3, 4);

            System.out.println(x);
            System.out.println(" --------------- ");

            // 创建指定维度的N维数组，值随机
            x = manager.create(new Shape(3, 4));

            // 创建指定维度的N维数组，值为 0.0
            x = manager.zeros(new Shape(2, 3, 4));
            x = manager.ones(new Shape(2, 3, 4));

            System.out.println(x);
            System.out.println(" --------------- ");

            // 随机 manager.randomNormal(new Shape(3, 4))
            x = manager.randomNormal(0f, 1f, new Shape(3, 4), DataType.FLOAT32);

            System.out.println(x);
            System.out.println(" --------------- ");

            x = manager.create(new float[]{2, 1, 4, 3, 1, 2, 3, 4, 4, 3, 2, 1}, new Shape(3, 4));

            System.out.println(x);
            System.out.println(" --------------- ");
        }
    }
}
