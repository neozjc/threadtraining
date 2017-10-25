package volatiledemo;

public class demo {
	//线程共享变量
	private volatile boolean tag = false;
	
	public void testVolatile() throws InterruptedException{
		//定义线程的逻辑
		Thread threadA =new Thread(new Runnable(){
			//具体线程的逻辑
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
		//启动线程
		threadA.start();
		
		Thread.sleep(1000);
		
		threadB.start();
	}
	
	public static void main(String[] args) throws InterruptedException {
		demo demo = new demo();
		demo.testVolatile();
	}
	
}
