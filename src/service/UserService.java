package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.User;

public class UserService {
	
	private static final char[] UserService = null;
	private static final String User = null;
	private ArrayList<User> saveUser = new ArrayList<User>();

		public UserService() {
			User u1 = new User("me","kim min hee", 1234567890);
			User u2 = new User("ryu","ryu hyung taeck",1234534);
			User u3 = new User("kwon","kwon min seok",55555555);
			User u4 = new User("KKo","kko kko",11111111);
			saveUser.add(u1);
			saveUser.add(u2);
			saveUser.add(u3);
			saveUser.add(u4);
			
		}
		public void insertUser(User user) {
			System.out.println("saving user info....");
			System.out.println(user);
			saveUser.add(user);
			System.out.println("Success Saving Book info");
			
		}
		public void selectAllUsers() {
			System.out.println("[All user Searching Service]");
			System.out.println("Searching All User Info....");
			int a;
			for(a=0;a<saveUser.size();a++) {
				System.out.println(saveUser.get(a).getUserIdInfo());
			
			}
			System.out.println("Success Searching All User Info!");
		}
		
	
		public void conditionUser(int userCondition, Scanner scanner) {
			scanner.nextLine();
			String wjdqh = scanner.nextLine();
			if(userCondition==1) {
				for(User u: saveUser) {
					if(u.getUserId().contains(wjdqh)){
						System.out.println(u.getUserInfo());
					}
			}
			
			}else if(userCondition==2) {
				for(User u : saveUser) {
					if(u.getUserName().contains(wjdqh)) {
						System.out.println(u.getUserInfo());
					}
				}
			}
			
		}
		
		public void memberOut(String mOut, Scanner scanner) {
			for(User u : saveUser) {
					for(int i=0;i<saveUser.size();i++) {
						if(mOut.contains(u.getUserId())) {
							saveUser.remove(i);
							
						}
						
					}
					System.out.println(u.getUserInfo());
				}
				
				
			}
			
			
		}
		


