package service;

import java.util.ArrayList;
import java.util.Scanner;
import service.BookService;

import vo.Book;
import vo.User;

public class RentBookService {
//	public ArrayList<BookService> book = new ArrayList<BookService>();
//	public ArrayList<Book> saveBook = new ArrayList<Book>();
//	private ArrayList<User> saveUser = new ArrayList<User>();
	BookService bookService = new BookService();
	Book book = new Book(null, null, null, 0, 0);
	
	
	
	
	public void rentBook(int decision) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the information of the book you want to borrow");
		System.out.println("the title");
		String borrowBookT= scanner.nextLine();
		System.out.println("the author");
		String borrowBookA = scanner.nextLine();
		System.out.println("the publisher");
		String borrowBookP = scanner.nextLine();
				System.out.println(book.getTitle());
			if(book.getTitle().contains(borrowBookT)&& book.getAuthor().contains(borrowBookA) && book.getPublisher().contains(borrowBookP)) {
				System.out.println("have the book you entered");
				System.out.println("Please enter your ID and name ");
				String bId = scanner.nextLine();
				String bName = scanner.nextLine();
//				for(User u : saveUser) {
//					if(u.getUserId().equals(bId) && u.getUserName().equals(bName)) {
//						System.out.println("You have succeeded in borrowing a book.");
//						
//					}
//				}
			}	
			
		
		
	}


}
