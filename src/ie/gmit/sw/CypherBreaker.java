package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker {
	//Final size of the queue
	private static final int MAX_QUEUE_SIZE = 1000;
	//creating the array blocking queue
	private BlockingQueue<Resultable> queue;
	//cypher text
	private String cypherText;
	
	public CypherBreaker(String cypherText){
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText = cypherText;
		init();
	}
	
	public void init(){
		//start a load of producers
		for (int i = 2; i <cypherText.length()/2; i++){
			new Thread(new Decryptor(queue, cypherText, i)).start();
		}//End for loop
		
		
	}
	
	/*
	 * volotile int counter =0;
	 * object lock= new object();
	 * public void increment(){
	 * synchronized (lock){
	 * counter ++;
	 * if(counter == 1000){
	 * queue.put (new PosinResult());
	 * }
	 * }
	 * 
	 */

}
