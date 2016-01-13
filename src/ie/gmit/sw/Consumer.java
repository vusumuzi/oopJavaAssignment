package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Resultable> queue=new ArrayBlockingQueue<>(1000);//siz is 1000
	private int i;
	private int j;
	private volatile double hs = -1000;		
	private Resultable rf;
	
	//constructor
	public Consumer(BlockingQueue<Resultable> queue,int i){
		this.queue = queue;
		this.i = i;	
	}
	
	
	@Override
	public void run() {
		while(j<i){
			try {
				Resultable r = queue.take();
				double s = r.getScore();
				if(s>hs){
					hs = s;
					rf = r;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			j++;
		}
	}
	public Resultable getrf(){
		return rf;
	}
	
	
}
