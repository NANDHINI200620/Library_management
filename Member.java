package librarymanagement.model;

public class Member {
	protected String name;
    protected int maxBooks = 3;

    public Member(String name) {
        this.name = name;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public String getName() {
        return name;
    }
}
