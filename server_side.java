import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class server_side {
	private static Scanner sc;


	static ServerSocket establish_server() throws IOException {
		return new ServerSocket(8080);
	}
	
	static int get_number(Socket ss) throws IOException {
		sc = new Scanner(ss.getInputStream());
		int number = sc.nextInt();
		
		return number*6;
	}
	
	static void send_message(Socket ss, int temp) throws IOException {
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(temp);
	}
	
	
	public static void main(String[] args) throws IOException {
		int temp = 0;
		ServerSocket s1 = establish_server();
		while(true) {	
			Socket ss = s1.accept();
			while(true){
				try {
					temp = get_number(ss);	
				}
				catch(NoSuchElementException e) {
					break;
				}
				send_message(ss,temp);
				
				
				
			}
		}
	}
}
