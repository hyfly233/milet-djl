package test;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.Shape;

/**
 * @author hyfly
 */
public class Test0301 {

    public static void main(String[] args) {
        int n = 10000;
        NDManager manager = NDManager.newBaseManager();

        NDArray a = manager.ones(new Shape(n));
        NDArray b = manager.ones(new Shape(n));
        NDArray c = manager.ones(new Shape(n));
//
//        StopWatch stopWatch = new StopWatch();
//        for (int i = 0; i < n; i++) {
//            c.set(new NDIndex(i), a.getFloat(i) + b.getFloat(i));
//        }
//        String.format("%.5f sec", stopWatch.stop());
    }
}
