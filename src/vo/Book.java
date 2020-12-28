package vo;

public class Book {
	
	private String title;
	private String author;
	private String publisher;
	private long price;
	private int stock;
	

	
	public Book(String title, String author, String publisher, long price, int stock) {
		this.title= title;
		this.author= author;
		this.publisher= publisher;
		this.price = price;
		this.stock = stock;
		System.out.println("[System: new book ]");
		System.out.println("[System: new book information: "+title + author + publisher + price + stock);
	}
	
	public String getInfo() {
		
		return "book Info   : "+title+"\t" + author+"\t"+ publisher+"\t" + price+"\t" + stock;
		
	}
	
//	public void setInfo() {
//		return "book Info: "setTitle"
//	}

	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public int isStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}

}
