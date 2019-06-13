package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda表达式的基本用法
 * @author gaomeiling
 *
 */
public class BasicUsage {

	public static void main(String[] args) {
		String[] atp = {"str1","str2","str3","str4","str5","str6"};
		
		List<String> players = Arrays.asList(atp);
		
		// 以前的循环方式
		for(String player : players) {
			System.out.println(player+"; ");
		}
		
		System.out.println("###########################");
		
		// 使用Lambda表达式以及函数操作
		players.forEach((player) -> System.out.println(player +"; "));
		
		System.out.println("###########################");
		
		// 在Java8中使用双冒号操作符(流【Stream】如同迭代器，但附加了很多额外的功能)
		/*
		 * 双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下
		 */
		players.forEach(System.out :: println);
	}
}
