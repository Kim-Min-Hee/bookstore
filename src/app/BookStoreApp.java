package app;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import service.BookService;
import service.RentBookService;
import service.UserService;
import vo.Book;
import vo.User;

public class BookStoreApp {


	public static void main(String[] args) {
		
		BookService service = new BookService();
		UserService userService = new UserService();
		RentBookService RentBookService = new RentBookService();
		while(true) {
			System.out.println("1.userManu, 2.bookManu 3. rentBook please check");
			
			Scanner scanner = new Scanner(System.in);
			
			int choose= scanner.nextInt();
			
			if(choose==1) {
				System.out.println("1.memberRegistration 2. memberOut 3.memberCheck");
				int userChoose= scanner.nextInt();
				if(userChoose==1) {
					System.out.println("memberRegistration");
					System.out.println("write userId");
					scanner.nextLine();
					String userId = scanner.nextLine();
					System.out.println("write your name");
					String userName = scanner.nextLine();
					System.out.println("write your contact");
					int contact = scanner.nextInt();
					User user = new User(userId, userName, contact);
					userService.insertUser(user);
				}else if(userChoose==2) {
					System.out.println("memberOut");
					scanner.nextLine();
					String mOut = scanner.nextLine();
					userService.memberOut(mOut, scanner);
				}else if(userChoose==3) {
					System.out.println("memberCheck");
					System.out.println("1. allcheck 2. conditionCheck");
					int check = scanner.nextInt();
					if(check==1) {
						userService.selectAllUsers();
					}else if(check==2) {
						System.out.println("condition search!!");
						System.out.println("1. userId 2. userName ");
						int userCondition = scanner.nextInt();
						userService.conditionUser(userCondition,scanner);
						
					}
					
				}
			}else if(choose==2) {
				System.out.println("1.bookRegistration 2. bookCheck 3.bookRevise");
				int bookChoose= scanner.nextInt();
				
				if(bookChoose==1) {
					System.out.println("enter the title of book");
					scanner.nextLine();
					String title = scanner.nextLine();
					System.out.println("enter the author of book");
					String author = scanner.nextLine();
					System.out.println("enter the publisher of book");
					String publisher = scanner. nextLine();
					System.out.println("enter the price of book");
					long price = scanner.nextLong();
					System.out.println("enter the stock of book");
					int stock = scanner.nextInt();
					Book book = new Book(title, author, publisher, price, stock);
					service.insertBook(book);
					
				}else if(bookChoose==2) {
					System.out.println("1. allSelect 2. conditionSelect 3. Revision inquiry ");
					int bookmenu = scanner.nextInt();
					if(bookmenu==1) {
						
						service.selectAllBooks();
						
						System.out.println();
					}else if(bookmenu==2) {
						//Book book = new Book("title", "author", "publisher", price, 3);
						System.out.println("1. title 2. author 3. publisher 4. range 5. stock");
						int condition = scanner.nextInt();
						service.conditionRead(condition, scanner);
					}else if(bookmenu==3){
						System.out.println("Revision inquiry");
						System.out.println("1. title 2. author 3. publisher");
						int pick= scanner.nextInt();
						service.pickRead(pick,scanner);
					}
					
				}
			}else if(choose==3){
				System.out.println("1. rent 2. return 3. search");
				int decision = scanner.nextInt();
				switch(decision) {
					case 1 : 
						System.out.println("???");
						RentBookService.rentBook(decision);
						
						
				}
					
				
			}else {
				System.out.println("The End");
				break;
			}
			
	}
		
			
		}
		
		
	}


