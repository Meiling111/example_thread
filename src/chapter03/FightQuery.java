package chapter03;

import java.util.List;

/**
 * 不论是Thread的run方法，还是Runnable都是void返回类型，如果想通过
 * 某个线程的运行得到结果，就要自己定义一个返回的接口。
 * @author gaomeiling
 *
 */
public interface FightQuery {
	List<String> get();
}
