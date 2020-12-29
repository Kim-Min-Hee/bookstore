package app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import service.BookService;
import service.RentBookService;
import service.UserService;
import vo.Book;
import vo.HireBook;
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
				String borrowBookA;
				String borrowBookT = null;
				String borrowBookP;
				String bId ;
				String bName=null;
				Calendar  cal = Calendar.getInstance();
				cal.setTime(new Date());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				switch(decision) {
					case 1 : 
						System.out.println("Please Enter the book you want to borrow and your ID name");
						System.out.println("the title");
						scanner.nextLine();
						borrowBookT= scanner.nextLine();
						System.out.println("the author");
						borrowBookA = scanner.nextLine();
						System.out.println("the publisher");
						borrowBookP = scanner.nextLine();
						System.out.println("your Id");
						bId = scanner.nextLine();
						System.out.println("your name");
						bName = scanner.nextLine();
						System.out.println("your enter : "+"Title : "+borrowBookT+"\t"+"Author : "+borrowBookA+"\t"+
						"publisher : "+borrowBookP+"\t"+"your Id : "+bId +"\t"+"your name : "+bName);
						int collect=0;
						int noBook=0;
						int noUser=0;
						for(int b=0; b<userService.saveUser.size();b++) {
							if(userService.saveUser.get(b).getUserId().contains(bId) && userService.saveUser.get(b).getUserName().contains(bName)) {
								System.out.println("You are a member");
								for(int a = 0; a<service.saveBook.size();a++) {
									if(service.saveBook.get(a).getTitle().contains(borrowBookT)&& service.saveBook.get(a).getAuthor().contains(borrowBookA)
											&& service.saveBook.get(a).getPublisher().contains(borrowBookP)) {
										System.out.println("There are matching book");
												collect++;
										if(service.saveBook.get(a).isStock()>0) {
											
											String title = borrowBookT;
											String author =borrowBookA;
											String publisher = borrowBookP;
											long price = service.saveBook.get(a).getPrice();
											int stock = service.saveBook.get(a).isStock();
											service.saveBook.remove(a);
											Book book = new Book(title, author, publisher, price, stock-1);
											service.insertBook(book);
											
										}else {
											System.out.println("This book is out of stock");
										}
								collect++;
							}else {
								noBook++;
							}
						}
							}else {
								noUser++;
							}
							
						}
						
						if(collect==2) {
							String nTime =df.format(cal.getTime());
							cal.add(Calendar.DATE, 5);
							String rTime= df.format(cal.getTime());
							HireBook hb = new HireBook( borrowBookT,bName,nTime,rTime);
							System.out.println(borrowBookT+"\n"+bName+"\n"+nTime+"\n"+rTime);
							RentBookService.insertHireBook(hb);
							RentBookService.rentBook(decision,nTime,rTime);
							
							
						}else if(noBook>0) {
							System.out.println("There are no matching books");
						}else if(noUser>0) {
							System.out.println("There are no matching user");
						}
						break;
					case 2 : 
						System.out.println("Return Book"+"\t"+"write your name & return Book Title");
						System.out.println("your name");
						scanner.nextLine();
						String rName = scanner.nextLine();
						System.out.println("return Book name");
						String rTitle = scanner.nextLine();
						String toDay= df.format(cal.getTime());
						RentBookService.backBook(rName, rTitle,toDay);
						
					case 3 : 
						System.out.println("Retrieving return information");
						System.out.println("1. User infomation 2. Book information");
						int ck = scanner.nextInt();
						RentBookService.infoCk(ck);
				}
			}else {
					System.out.println("The End");
					break;
			}
			
	}
		
			
		
	}

	}	
		
	


