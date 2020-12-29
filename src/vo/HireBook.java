package vo;

public class HireBook {
	
	private String borrowBookT;
	private String bName;
	private String nTime;
	private String rTime;
	
	public HireBook(String borrowBookT, String bName , String nTime, String rTime) {
		this.borrowBookT=borrowBookT;
		this.bName=bName;
		this.nTime=nTime;
		this.rTime = rTime;
		System.out.println("[System: rental book information: "+borrowBookT + bName + nTime + rTime );
		
	}
	
	public String HireInfo() {
		return "information : "+bName+"\t"+borrowBookT+"\t"+nTime+"\t"+rTime;
	}
	
	public String getBorrowBookT() {
		return borrowBookT;
	}

	public void setbTitle(String bTitle) {
		this.borrowBookT = bTitle;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getnTime() {
		return nTime;
	}

	public void setnTime(String nTime) {
		this.nTime = nTime;
	}

	public String getrTime() {
		return rTime;
	}

	public void setrTime(String rTime) {
		this.rTime = rTime;
	}

}
