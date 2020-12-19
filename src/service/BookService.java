package service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import vo.Book;

public class BookService {
	
	private static final char[] BookService = null;
	private static final String Book = null;
	private ArrayList<Book> saveBook = new ArrayList<Book>();
	
	public BookService() {
		Book b1 = new Book("Java standard","NamGoong","Hanbit Media",35000,3);
		Book b2 = new Book("momo","Michael Ende","Flying dragon",15000,4);
		Book b3 = new Book("momo2","Michael Ende","Flying dragon",15000,4);
		Book b4 = new Book("Baekseok Authentic Poems","Hyungjin Ko","Creation and criticism",27000,7);
		
		saveBook.add(b1);
		saveBook.add(b2);
		saveBook.add(b3);
		saveBook.add(b4);
	}
	public void insertBook(Book book) {
		System.out.println("[book save service]");
		System.out.println("saving book info....");
		System.out.println(book);
		saveBook.add(book);
		System.out.println("Success Saving Book info");
	}
	
	public void selectAllBooks() {
		System.out.println("[All Book Searching Service]");
		System.out.println("Searching All Book Info....");
		int a;
		for(a=0;a<saveBook.size();a++) {
			System.out.println(saveBook.get(a).getInfo());
		
		}
		System.out.println("Success Searching All Book Info!");
	}
	public void conditionRead(int condition, Scanner scanner) {
		String searchKey=null;
		String minPrice=null;
		int maxPrice=0;
		if(condition<4) {
			System.out.println("write infomation");
		scanner.nextLine();
		searchKey = scanner.nextLine();
		}else {
			System.out.println("write min & max price");
			scanner.nextLine();
			minPrice=scanner.nextLine();
			System.out.println("write min & max price 1");
			maxPrice = scanner.nextInt();
			System.out.println("write min & max price 2");
			
		}
		
		int count = 0;
		for (Book c : saveBook) {
			
			switch(condition) {
				case 1:
					c.getTitle().contains(searchKey);
					if(c.getTitle().contains(searchKey)) {
						System.out.println(c.getInfo());
					}else {
							count++;
					}
					break;
				case 2 :
					c.getAuthor().contains(searchKey);
					if(c.getAuthor().contains(searchKey)) {
						System.out.println(c.getInfo());
					}else  {
						count++;
					}
					break;
				case 3 :
					
					c.getPublisher().contains(searchKey);
					if(c.getPublisher().contains(searchKey)) {
						System.out.println(c.getInfo());
					}else  {
						count++;
					}
					break;
					
				case 4 : 
					System.out.println("test :: "+minPrice==null);
					System.out.println("test2 :: "+minPrice.toString());
					System.out.println("test3 :: "+minPrice.equals(""));
					System.out.println("test4 :: "+minPrice.isEmpty());
					System.out.println("test5 :: "+minPrice==null);
					if(!minPrice.isEmpty()) {
						
						int min= Integer.parseInt(minPrice);
						if(c.getRange()>min && c.getRange()<=maxPrice) {
							System.out.println(c.getInfo());
					}					
					}else if(minPrice.isEmpty()){
						if(c.getRange()<=maxPrice) {
							System.out.println(c.getInfo());
					}					
						
					}
					
			
			
			
			if(count == saveBook.size()) {
				 System.out.println("uncollect!!");
			}
		
		
		}
		
		}
	
	}
	
	public void UpdateBookInfo(){
		System.out.println("[Book Info Modifying Service]");
		System.out.println("Modi");
		
		
		
		
	}
}
