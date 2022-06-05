package test;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.DataType;
import ai.djl.ndarray.types.Shape;

/**
 * 带有噪声的线性模型构造一个人造数据集
 * 使用这个有限样本的数据集来恢复这个模型的参数
 *
 * @author hyfly
 */
public class Test030201 {
    public static void main(String[] args) {
        NDManager manager = NDManager.newBaseManager();

        NDArray trueW = manager.create(new float[]{2, -3.4f});
        float trueB = 4.2f;

        DataPoints dp = syntheticData(manager, trueW, trueB, 1000);
        NDArray features = dp.getX();
        NDArray labels = dp.getY();

        System.out.printf("features: [%f, %f]\n", features.get(0).getFloat(0), features.get(0).getFloat(1));
        System.out.println("label: " + labels.getFloat(0));
    }

    public static DataPoints syntheticData(NDManager manager, NDArray w, float b, int numExamples) {
        NDArray X = manager.randomNormal(new Shape(numExamples, w.size()));
        NDArray y = X.dot(w).add(b);
        // Add noise
        y = y.add(manager.randomNormal(0, 0.01f, y.getShape(), DataType.FLOAT32));
        return new DataPoints(X, y);
    }

    static class DataPoints {
        private NDArray X;
        private NDArray y;

        public DataPoints(NDArray X, NDArray y) {
            this.X = X;
            this.y = y;
        }

        public NDArray getX() {
            return X;
        }

        public NDArray getY() {
            return y;
        }
    }
}
