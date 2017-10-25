package mutilatethread;

public class demo4 {
	private static void demo3() {
	    Object lock = new Object();
	    Thread A = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("INFO: A �ȴ���");
	            synchronized (lock) {
	                System.out.println("INFO: A �õ����� lock");
	                System.out.println("A 1");
	                try {
	                    System.out.println("INFO: A ׼������ȴ�״̬�������� lock �Ŀ���Ȩ");
	                    lock.wait();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("INFO: ���˻����� A, A ���»���� lock");
	                System.out.println("A 2");
	                System.out.println("A 3");
	            }
	        }
	    });
	    Thread B = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("INFO: B �ȴ���");
	            synchronized (lock) {
	                System.out.println("INFO: B �õ����� lock");
	                System.out.println("B 1");
	                System.out.println("B 2");
	                System.out.println("B 3");
	                System.out.println("INFO: B ��ӡ��ϣ����� notify ����");
	                lock.notify();
	            }
	        }
	    });
	    A.start();
	    B.start();
	}
	public static void main(String[] args) {
		demo3();
	}
}
