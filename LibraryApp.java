package librarymanagement.main;
import librarymanagement.model.*;
import librarymanagement.transaction.*;
import librarymanagement.service.*;
import java.util.*;
public class LibraryApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library library = new Library();
		while (true) { 
			System.out.println("\n--- 📚 Library Menu ---"); 
			System.out.println("1. Add Book"); 
			System.out.println("2. Add Member"); 
			System.out.println("3. Borrow Book");
			System.out.println("4. Return Book"); 
			System.out.println("5. Display Available Books"); 
			System.out.println("6. Exit"); 
			System.out.print("Enter choice: "); 
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1 -> { 
				System.out.print("Enter book title: ");
				String title = sc.nextLine();
				System.out.print("Enter author: "); 
				String author = sc.nextLine();
				System.out.print("Enter stock: "); 
				int stock = sc.nextInt();
				library.addBook(new Book(title, author, stock)); }
			case 2 -> { 
				System.out.print("Enter member name: ");
				String name = sc.nextLine(); 
				System.out.print("Premium? (yes/no): "); 
				String type = sc.nextLine(); 
				if (type.equalsIgnoreCase("yes")){ 
					library.addMember(new PremiumMember(name));
					} else { library.addMember(new Member(name)); } 
				} case 3 -> {
					System.out.print("Enter book title to borrow: "); 
					String borrowTitle = sc.nextLine();
					System.out.print("Enter member name: ");
					String borrower = sc.nextLine();
					Book bookToBorrow = library.getAvailableBooks().stream() .filter(b -> b.getTitle().equalsIgnoreCase(borrowTitle)) .findFirst().orElse(null);
					if (bookToBorrow != null) {
						BorrowTransaction bt = new BorrowTransaction(bookToBorrow, new Member(borrower));
						bt.process(); }
					else { System.out.println("❌ Book not found!"); } } 
				case 4 -> { System.out.print("Enter book title to return: ");
				String returnTitle = sc.nextLine();
				System.out.print("Enter member name: "); 
				String returner = sc.nextLine();
				System.out.print("Was it late? (yes/no): ");
				String late = sc.nextLine(); Book bookToReturn = library.getAvailableBooks().stream() .filter(b -> b.getTitle().equalsIgnoreCase(returnTitle)) .findFirst().orElse(null);
				if (bookToReturn != null) { 
					ReturnTransaction rt = new ReturnTransaction(bookToReturn, new Member(returner), late.equalsIgnoreCase("yes")); rt.process(); } else 
					{ System.out.println("❌ Book not found!"); } } 
				case 5 -> { 
					for (Book book : library.getAvailableBooks()) {
						System.out.println(book); } } 
				case 6 -> {
					System.out.println("👋 Exiting...");
					sc.close(); return;
					} 
				default -> System.out.println("Invalid choice!"); } }
	}
}
