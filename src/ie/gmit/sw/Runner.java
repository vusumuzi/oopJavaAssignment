package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	private static final int MAX_QUEUE_SIZE = 1000;
	
	private String cypherText;
	private static Resultable rf;
	private static int j = 0;
	private static Map<String, Double> map = new ConcurrentHashMap<String, Double>();
	
	public static void main(String[] args) throws Exception{
		String s = new RailFence().encrypt("THEYAREATTACKINGFROMTHENORTH", 5);
		System.out.println(">" + s);
		
		FileParser fp = new FileParser();
		map = fp.parse("4grams.txt");
		TextScorer ts = new TextScorer(map);
		BlockingQueue<Resultable> queue = new ArrayBlockingQueue<Resultable>(s.length());
		
		//Start a load of producers
				for (int i = 2; i < s.length()/2; i++){
					new Thread(new Decryptor(queue, s, i)).start();
					j++;
				}
				
	Consumer con = new Consumer(queue, j);
	Thread c = new Thread(con);	
	c.start();
	c.join();
	rf = con.getrf();
	System.out.println(rf.getPlainText());
	}
}
