package test;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.index.NDIndex;
import ai.djl.ndarray.types.Shape;

public class Operate {

    public static void main(String[] args) {

        try (NDManager manager = NDManager.newBaseManager()) {
            NDArray x = manager.create(new float[]{1f, 2f, 4f, 8f});
            NDArray y = manager.create(new float[]{2f, 2f, 2f, 2f});
            NDArray z = x.add(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.sub(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.mul(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.div(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.pow(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.exp();

            System.out.println(z);
            System.out.println(" --------------- ");

            // 沿着轴进行联结
            x = manager.arange(12f).reshape(3, 4);
            y = manager.create(new float[]{0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11}, new Shape(3, 4));
            // default axis = 0
            z = x.concat(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.concat(y, 1);

            System.out.println(z);
            System.out.println(" --------------- ");

            z = x.eq(y);

            System.out.println(z);
            System.out.println(" --------------- ");

            // 所有元素求和
            System.out.println(x.sum());

            System.out.println(" --------------- ");

            System.out.println(x);
            // 获取倒数的维度元素
            System.out.println(x.get(-1));

            // 最后一个元素 相当于 x.get("0:-1")
            System.out.println(x.get(":-1"));
            // 第二个（索引 1）和第三个（索引 2）元素  不包含 3 -> [1, 3)
            System.out.println(x.get("1:3"));

            System.out.println(" --------------- ");

            x.set(new NDIndex("1, 2"), 999);
            System.out.println(x);

            System.out.println(" --------------- ");

            y.set(new NDIndex("0:2, :"), 999);
            System.out.println(y);
        }
    }
}
