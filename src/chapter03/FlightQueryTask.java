package chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 用于到各大航空公司获取数据
 * @author gaomeiling
 *
 */
public class FlightQueryTask extends Thread implements FlightQuery{
	
	private final String origin; // 出发地
	
	private final String destination; // 目的地
	
	private final List<String> flightList = new ArrayList<>();
	
	public FlightQueryTask (String airline, String origin, String destination) {
		super("["+airline+"]");
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public void run() {
		System.out.printf("%s-query from %s to %s \n", getName(), origin, destination);
		int randomVal = ThreadLocalRandom.current().nextInt();
		try {
			TimeUnit.SECONDS.sleep(randomVal);
			this.flightList.add(getName() + "-" + randomVal);
			System.out.printf("The Fight:%s list query successful\n", getName());
		} catch (Exception e) {
		}
	}
	
	@Override
	public List<String> get() {
		return this.flightList;
	}

}
