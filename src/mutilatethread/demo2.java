package mutilatethread;

public class demo2 {
	//线程1，用来打印A
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
	        	try {
					A.join();//在这里把等待A结束才能往下走
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            printNumber("B");
	        }
	    });
	    A.start();
	    B.start();
	}
	
	//线程2 用来打印B
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

