public class LibraryManagementSystem {
    static abstract class LibraryItem {
        private int itemId;
        private String title;
        private String author;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

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

        abstract int getLoanDuration();

        void displayItemDetails() {
            System.out.println("Item ID: " + itemId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    static class Book extends LibraryItem {
        @Override
        int getLoanDuration() {
            return 14;
        }
    }

    static class Magazine extends LibraryItem {
        @Override
        int getLoanDuration() {
            return 7;
        }
    }

    static class DVD extends LibraryItem {
        @Override
        int getLoanDuration() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setItemId(1);
        book.setTitle("Java Basics");
        book.setAuthor("James");

        Magazine magazine = new Magazine();
        magazine.setItemId(2);
        magazine.setTitle("Tech Monthly");
        magazine.setAuthor("Editorial Team");

        DVD dvd = new DVD();
        dvd.setItemId(3);
        dvd.setTitle("OOP Tutorial");
        dvd.setAuthor("Training Team");

        LibraryItem[] items = {book, magazine, dvd};
        for (LibraryItem item : items) {
            item.displayItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
        }
    }
}
