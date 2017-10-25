package mutilatethread;

/**
 * �ֳ���ʾ
 * @author zzz
 *
 */
public class demo {
	//�߳�1��������ӡA
	private static void demo1() {
	    Thread A = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            printNumber("A");
	        }
	    });
	    Thread B = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            printNumber("B");
	        }
	    });
	    A.start();
	    B.start();
	}
	
	//�߳�2 ������ӡB
	private static void printNumber(String threadName) {
	    int i=0;
	    while (i++ < 3) {
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println(threadName + "print:" + i);
	    }
	}

	public static void main(String[] args) {
		demo1();
	}
}
