import java.io.IOException;
import java.net.UnknownHostException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;



public class client_side {
	public static String LOCALHOST = "127.0.0.1";
	public static String BALDWIN = "174.77.62.250"; 
	public static int PORT = 8080;
	private static Scanner sc;

	static Socket establish_connection() throws UnknownHostException, IOException {
		System.out.println("Conneting to Network...");
		return new Socket(LOCALHOST, PORT);
	}
	
	static void close_connection(Socket s) throws IOException {
		System.out.println("Closing Connection...");
		s.close();
	}
	
	static void send_message(Socket s,int number)throws IOException{
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(number);
		
	}
	
	static void recieve_message(Scanner sc1) {
		int temp=sc1.nextInt();
		System.out.println(temp);
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		int number = 0;
		sc = new Scanner(System.in);
		
		Socket s = establish_connection();
		System.out.println("Connected");
		
		Scanner sc1 = new Scanner(s.getInputStream());
		
		while(true) {
			System.out.println("Enter any number");
			try {
				number = sc.nextInt();
				
			}
			catch(InputMismatchException e){
				close_connection(s);
				System.out.println("connection closed successfully");
				break;
			
				
			}
			send_message(s,number);
			
			recieve_message(sc1);
		}
		
	}

}