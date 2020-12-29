package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.HireBook;
public class RentBookService {
	
	public ArrayList<HireBook> hb = new ArrayList<HireBook>();
	private static final char[] RentBookService = null;
	private static final String HireBook = null;
	
	public void RentBookService() {
		
		HireBook hb1 = new HireBook( "HarryPotter", "kim" ,"2020-12-29", "2021-01-03");
		hb.add(hb1);
	}
	public void insertHireBook(HireBook hireBook) {
		System.out.println("[RentalBook save service]");
		System.out.println("saving RentalBook info....");
		System.out.println(hireBook);
		hb.add(hireBook);
		System.out.println("Success Saving HireBook info");
	}
	
	public void rentBook(int decision,String nTime,String rTime) {
		System.out.println("lend book"+"\n"+"Today : "+nTime+"\n"+"Expected return date : "+rTime);
			
		}
	public void backBook(String rName,String rTitle,String toDay) {
		System.out.println(hb);
			for(HireBook h : hb) {
				if(rName.contains(h.getbName())&& rTitle.contains(h.getBorrowBookT())) {
					System.out.println("Return is possible"+"\n"+ "check if there is a late fee");
						int compare = h.getrTime().compareTo(toDay);
							if(compare>=0) {
								System.out.println("No late fee");
							}else {
								int fee = 500;
								int sum = (fee*compare)*-1;
								System.out.println("you pay late fee"+"\n"+"Money to pay : "+sum);
								
							}
				}
			}
	}
	public void infoCk(int ck){
		Scanner scanner = new Scanner(System.in);
		switch(ck) {
		case 1:
			System.out.println("Search by user information"+"\n"+"write userName");
			String un = scanner.nextLine();
			for(int i=0;i<hb.size();i++) {
				if(hb.get(i).getbName().contains(un)) {
					System.out.println(hb.get(i).HireInfo());
				}else {
					System.out.println("There are no books I borrowed for the contents you wrote down");
				}
			}
			break;
		case 2 : 
			System.out.println("Search by bookTitle information"+"\n"+"write bookTitle");
			String bt = scanner.nextLine();
			for(int i=0;i<hb.size();i++) {
				if(hb.get(i).getBorrowBookT().contains(bt)) {
					System.out.println(hb.get(i).HireInfo());
				}else {
					System.out.println("There are no books I borrowed for the contents you wrote down");
				}
			}
			break;
			
			}
		
		
	}
		
		}
	
	
				
	
	
	
			

		
		
	
		
		
	

			
	
		




