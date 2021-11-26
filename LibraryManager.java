import java.util.Scanner;

public class LibraryManager {
    Books b = new Books();
    Map<Integer, Library.list<Books>> map = new HashMap<Integer, Library.list<Books>>();
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

    private static boolean bookFound(int id,String name, String book_author) {
        if (Library.count() > 0) {
            for (int i = 0; i < Library.count(); i++) {
                Books read = Library.read(i);
                if (id== read.getId() && name.equals(read.getName()) && book_author.equals(read.getAuthor_name())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the book id:");
        int id=scan.nextInt();
        System.out.println("enter the book name to search for:");
        String name = scan.next();
        System.out.println("enter the book_author to be searched for:");
        String book_author = scan.next();

        if (!(bookFound(id,name, book_author))) {
            b.setId(id);
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
        System.out.println("enter the book id:");
        int id=scan.nextInt();
        System.out.println("enter the book name to search for:");
        String name = scan.next();
        System.out.println("enter the book_author to be searched for:");
        String book_author = scan.next();
        deleteFromList(id,name, book_author);
    }


    private void deleteFromList(int id,String name, String book_author) {
        if (bookFound(id,name, book_author)) {
            Books b = new Books();
            b.setName(name);
            b.setAuthor_name(book_author);
            for (int i = 0; i < Library.count(); i++) {
                System.out.println(Library.read(i));
            }
            b.setId(id);
            Library.list.remove(b);
            for (int i = 0; i < Library.count(); i++) {
                System.out.println(Library.read(i));
            }
            System.out.println("book deleted");
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
        else{
            System.out.println("book name and author does not exist");
        }
    }

    public void update() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the book id:");
        int id=scan.nextInt();
        System.out.println("enter the book name to search for:");
        String name = scan.next();
        System.out.println("enter the book_author to be searched for:");
        String book_author = scan.next();
        if (!(bookFound(id,name, book_author))) {
            b.setId(id);
            b.setName(name);
            b.setAuthor_name(book_author);
            Library.list.add(b);
            System.out.println("Book is added");
            //Library.list.remove(b);
            //System.out.println("book deleted successfully!");


        } else {
            deleteFromList(name, book_author);
            System.out.println("enter the book id:");
            int id1=scan.nextInt();
            System.out.println("enter the new book name to be updated:");
            String name1 = scan.next();
            System.out.println("enter the new author name to be updated");
            String book_author2 = scan.next();
            b.setId(id1);
            b.setName(name1);
            b.setAuthor_name(book_author2);
            Library.list.add(b);

            System.out.println("updated successfully");
        }


    }

}

