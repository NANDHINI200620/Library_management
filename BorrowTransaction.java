package librarymanagement.transaction;
import librarymanagement.model.Book;
import librarymanagement.model.Member;
public class BorrowTransaction {
	private Book book;
    private Member member;

    public BorrowTransaction(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    public void process() {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println("✅ " + member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("❌ Book not available!");
        }
    }
}
