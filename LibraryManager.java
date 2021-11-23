import java.util.Scanner;

public class LibraryManager {
    Books b = new Books();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LibraryManager lb = new LibraryManager();
        int ch;
        do {
            System.out.println("enter the value of ch");
            ch = scan.nextInt();

            switch (ch) {
                case 1:
                    lb.add();
                    break;

                case 2:
                    lb.delete();
                    break;
                case 3:
                    lb.update();
                    break;

                default:
                    System.out.println("enter the valid ch");
            }
        } while (ch != 0);
    }

    private static boolean bookFound(String name, String book_author) {
        if (Library.count() > 0) {
            for (int i = 0; i < Library.count(); i++) {
                Books read = Library.read(i);
                if (name.equals(read.getName()) && book_author.equals(read.getAuthor_name())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the book name to search for:");
        String name = scan.next();
        System.out.println("enter the book_author to be searched for:");
        String book_author = scan.next();

        if (!(bookFound(name, book_author))) {
            b.setName(name);
            b.setAuthor_name(book_author);
            Library.list.add(b);
            System.out.println("Book is added");

        } else {
            System.out.println("The book id and book author already exist");
        }
    }

    public void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the book name to search for:");
        String name = scan.next();
        System.out.println("enter the book_author to be searched for:");
        String book_author = scan.next();
        deleteFromList(name, book_author);
    }


    private void deleteFromList(String name, String book_author) {
        if (bookFound(name, book_author)) {
            Books b = new Books();
            b.setName(name);
            b.setAuthor_name(book_author);
            for (int i = 0; i < Library.count(); i++) {
                System.out.println(Library.read(i));
            }
            b.setId(0);
            Library.list.remove(b);
            for (int i = 0; i < Library.count(); i++) {
                System.out.println(Library.read(i));
            }
            /**
             boolean a = Library.list.removeIf(book -> book.getName().equals(name) && book.getAuthor_name().equals(book_author));
             if (a) {
             System.out.println("book deleted successfully!");
             } else {
             System.out.println("the book id and book author not found!");
             }
             }
             */
        }
    }

    public void update() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the book name to search for:");
        String name = scan.next();
        System.out.println("enter the book_author to be searched for:");
        String book_author = scan.next();
        if (!(bookFound(name, book_author))) {
            b.setName(name);
            b.setAuthor_name(book_author);
            Library.list.add(b);
            System.out.println("Book is added");
            //Library.list.remove(b);
            //System.out.println("book deleted successfully!");


        } else {
            deleteFromList(name, book_author);
            System.out.println("enter the new book name to be updated:");
            String name1 = scan.next();
            System.out.println("enter the new author name to be updated");
            String book_author2 = scan.next();
            b.setName(name1);
            b.setAuthor_name(book_author2);
            //b.setName(name1);
            //b.setAuthor_name(book_author2);
            Library.list.add(b);

            System.out.println("updated successfully");
        }


    }

}

