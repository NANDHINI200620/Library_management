package librarymanagement.service;
import librarymanagement.model.*;
import java.util.*;
public class Library {
	private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> getAvailableBooks() {
        return books;
    }
}
