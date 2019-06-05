package chapter01;

public class TicketWindow extends Thread {

	// ��̨����
	private final String name;
	
	// �������50��ҵ��
	private static final int MAX = 50;
	
	private static int index = 1;
	
	public TicketWindow(String name) {
		this.name = name;
	}
	
	public void run() {
		while(index <= MAX) {
			System.out.println("��̨��"+ name +"����ǰ�ĺ����ǣ�"+ (index++));
		}
	}
	
	public static void main(String[] args) {
		TicketWindow ticketwindow1 = new TicketWindow("1�Ż�");
		ticketwindow1.start();
		
		TicketWindow ticketWindow2 = new TicketWindow("2�Ż�");
		ticketWindow2.start();
		
		TicketWindow ticketwindow3 = new TicketWindow("3�Ż�");
		ticketwindow3.start();
		
		TicketWindow ticketWindow4 = new TicketWindow("4�Ż�");
		ticketWindow4.start();
	}
}
