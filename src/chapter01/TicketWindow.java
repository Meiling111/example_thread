package chapter01;

public class TicketWindow extends Thread {

	// 柜台名称
	private final String name;
	
	// 最多受理50笔业务
	private static final int MAX = 50;
	
	private static int index = 1;
	
	public TicketWindow(String name) {
		this.name = name;
	}
	
	public void run() {
		while(index <= MAX) {
			System.out.println("柜台："+ name +"，当前的号码是："+ (index++));
		}
	}
	
	public static void main(String[] args) {
		TicketWindow ticketwindow1 = new TicketWindow("1号机");
		ticketwindow1.start();
		
		TicketWindow ticketWindow2 = new TicketWindow("2号机");
		ticketWindow2.start();
		
		TicketWindow ticketwindow3 = new TicketWindow("3号机");
		ticketwindow3.start();
		
		TicketWindow ticketWindow4 = new TicketWindow("4号机");
		ticketWindow4.start();
	}
}