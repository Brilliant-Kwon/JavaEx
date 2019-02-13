package JavaStudy.Fab_08.YSH.multhEx;

public class SynchronizedEx {
	public static void main(String[] args) {
		SyncObject obj=new SyncObject();
		Thread th1=new WorkerThread("승훈",obj);
		Thread th2=new WorkerThread("찬근",obj);
		th1.start();
		th2.start();
	}
}
class SyncObject{
	int sum=0;
	 void add() {
		int n=sum;
//		Thread.yield();
		n+=10;
		sum=n;
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
	int getSum() {
		return sum;
	}
}
class WorkerThread extends Thread{
	SyncObject sObj;
	WorkerThread(String name,SyncObject sObj){
		super(name);
		this.sObj=sObj;
	}
	public void run() {
		int i=0;
		while(i<10) {
			sObj.add();
			i++;
			try {
				sleep(1000); //1초마다 찍기 
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}