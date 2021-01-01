package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.HireBook;
public class RentBookService {
	
	public ArrayList<HireBook> hb = new ArrayList<HireBook>();
	private static final char[] RentBookService = null;
	private static final String HireBook = null;
	
	public RentBookService() {
		HireBook hb1 = new HireBook( "HarryPotter", "kim" ,"2020-12-29", "2021-01-03");
		HireBook hb2 = new HireBook( "momo", "minhee" ,"2020-11-20", "2020-11-25");
		hb.add(hb1);
		hb.add(hb2);
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
	public void infoCk(String ifm){
		for(HireBook h : hb) {
			if(h.getbName().contains(ifm) || h.getBorrowBookT().contains(ifm)) {
				System.out.println(h.HireInfo());
			}else {
				System.out.println("Less information and no matching information");
			}
		}
		
		
	}
		
		}
	
	
				




