package volatiledemo;

public class TestVolatile {
	//成员变量
	int a=1;
	//
	int b=2; 
	public void change() throws InterruptedException{
		a=3;
		Thread.sleep(10);
		b=a;
	}
	public void print(){
		System.out.println("b="+b+";a="+a);
	}
	public static void main(String[] args) {
		while (true) {
			final TestVolatile test= new TestVolatile();
			//启动一个线程
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(10);
						test.change();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					test.print();
				}
			}).start();
			
		}
	}
}
