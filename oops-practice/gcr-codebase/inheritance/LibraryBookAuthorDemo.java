public class LibraryBookAuthorDemo {
    static class Book {
        private String title;
        private int publicationYear;

        Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        void displayInfo() {
            System.out.println("Title: " + title);
            System.out.println("Publication Year: " + publicationYear);
        }
    }

    static class Author extends Book {
        private String name;
        private String bio;

        Author(String title, int publicationYear, String name, String bio) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Author Name: " + name);
            System.out.println("Bio: " + bio);
        }
    }

    public static void main(String[] args) {
        Author author = new Author("Clean Code", 2008, "Robert C. Martin", "Software craftsmanship author");
        author.displayInfo();
    }
}
