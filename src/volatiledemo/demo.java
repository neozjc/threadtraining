package volatiledemo;

public class demo {
	//�̹߳������
	private volatile boolean tag = false;
	
	public void testVolatile() throws InterruptedException{
		//�����̵߳��߼�
		Thread threadA =new Thread(new Runnable(){
			//�����̵߳��߼�
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(!tag){
					
					System.out.println("...  print a ...");
				}
				System.out.println("over...");
			}
			
		});
		Thread threadB = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("b is coming ");
				// TODO Auto-generated method stub
				tag=true;
			}
			
			
		});
		//�����߳�
		threadA.start();
		
		Thread.sleep(1000);
		
		threadB.start();
	}
	
	public static void main(String[] args) throws InterruptedException {
		demo demo = new demo();
		demo.testVolatile();
	}
	
}
