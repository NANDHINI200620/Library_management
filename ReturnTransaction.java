package librarymanagement.transaction;
import librarymanagement.model.Book;
import librarymanagement.model.Member;
public class ReturnTransaction {
	 private Book book;
	    private Member member;
	    private boolean lateReturn;

	    public ReturnTransaction(Book book, Member member, boolean lateReturn) {
	        this.book = book;
	        this.member = member;
	        this.lateReturn = lateReturn;
	    }

	    public void process() {
	        book.returnBook();
	        System.out.println("📘 " + member.getName() + " returned " + book.getTitle());
	        if (lateReturn) {
	            System.out.println("⚠️ Fine applied for late return!");
	        }
	    }
}
