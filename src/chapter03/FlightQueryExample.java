package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightQueryExample {
	
	// 合作的各大航空公司
	private static List<String> flightCompany = Arrays.asList("CSA", "CEA", "HNA");
	
	public static void main(String[] args) {
		List<String> results = search("SH","BJ");
		System.out.println("===============result=============");
		results.forEach(System.out::println);
	}
	
	private static List<String> search(String original, String dest){
		final List<String> result = new ArrayList<>();
		
		// 创建查询航班信息的线程列表
		List<FlightQueryTask> tasks = flightCompany.stream().map( f-> createSearchTask(f, original, dest)).collect(Collectors.toList());
		
		// 分别启动这几个线程
		tasks.forEach(Thread :: start);
		
		// 分别调用每一个线程的join方法，阻塞当前线程
		tasks.forEach( t-> {
			try {
				t.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		
		// 在此之前，当前线程会阻塞住，获取每一个查询线程的结果，并且加入到result中
		tasks.stream().map(FlightQuery :: get).forEach(result :: addAll);
		
		return result;
	}

	private static FlightQueryTask createSearchTask(String flight, String original, String dest) {
		return new FlightQueryTask(flight, original, dest);
	}
}
