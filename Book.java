package librarymanagement.model;
public class Book {
	 private String title;
	    private String author;
	    private int stock;

	    public Book(String title, String author, int stock) {
	        this.title = title;
	        this.author = author;
	        this.stock = stock;
	    }

	    public boolean isAvailable() {
	        return stock > 0;
	    }

	    public void borrowBook() {
	        if (stock > 0) stock--;
	    }

	    public void returnBook() {
	        stock++;
	    }

	    public String getTitle() {
	        return title;
	    }

	    @Override
	    public String toString() {
	        return title + " by " + author + " (Available: " + stock + ")";
	    }
}
