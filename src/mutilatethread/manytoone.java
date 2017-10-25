package mutilatethread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 多个运动员互相准备，等待，之后一起跑
 * @author zzz
 *
 */
public class manytoone {
	private static void runABCWhenAllReady() {
	    int runner = 3;
	    CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
	    final Random random = new Random();
	    for (char runnerName='A'; runnerName <= 'C'; runnerName++) {
	        final String rN = String.valueOf(runnerName);
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                long prepareTime = random.nextInt(10000) + 100;
	                System.out.println(rN + "is preparing for time:" + prepareTime);
	                try {
	                    Thread.sleep(prepareTime);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                try {
	                    System.out.println(rN + "is prepared, waiting for others");
	                    cyclicBarrier.await(); // 当前运动员准备完毕，等待别人准备好
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                } catch (BrokenBarrierException e) {
	                    e.printStackTrace();
	                }
	                System.out.println(rN + "starts running"); // 所有运动员都准备好了，一起开始跑
	            }
	        }).start();
	    }
	}
	
	public static void main(String[] args) {
		runABCWhenAllReady();
	}
}
