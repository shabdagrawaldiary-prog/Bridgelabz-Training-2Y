class Book {
    int id;
    String title;
    double price;

    Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}

public class LibraryManagement{

    // 1. Remove duplicates
    static int removeDuplicates(Book[] b, int n) {
        int j = 1;

        for (int i = 1; i < n; i++) {
            if (b[i].id != b[i - 1].id) {
                b[j++] = b[i];
            }
        }
        return j;
    }

    // 2. Search by title
    static void searchByTitle(Book[] b, int n, String key) {
        for (int i = 0; i < n; i++) {
            if (b[i].title.toLowerCase().contains(key.toLowerCase()))
                System.out.println(b[i].title);
        }
    }

    // 3. Sort by price
    static void sortByPrice(Book[] b, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++)
                if (b[j].price < b[min].price)
                    min = j;

            Book temp = b[i];
            b[i] = b[min];
            b[min] = temp;
        }
    }

    // 4. Binary search by price
    static int searchByPrice(Book[] b, int n, double price) {
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (b[m].price == price) return m;
            if (b[m].price < price) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    // 5. Minimum consecutive books
    static int minBooksForTargetCost(Book[] b, int n, double target) {
        int left = 0, ans = n + 1;
        double sum = 0;

        for (int right = 0; right < n; right++) {
            sum += b[right].price;

            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= b[left++].price;
            }
        }

        return ans == n + 1 ? 0 : ans;
    }

    public static void main(String[] args) {

        Book[] books = {
            new Book(101, "Data Structures", 400),
            new Book(101, "Data Structures", 400),
            new Book(102, "Java Basics", 300),
            new Book(103, "Python Guide", 600),
            new Book(104, "Database Systems", 500),
            new Book(105, "Computer Networks", 700)
        };

        int n = removeDuplicates(books, books.length);

        System.out.println("Search:");
        searchByTitle(books, n, "data");

        sortByPrice(books, n);

        System.out.println("Price Search: " +
                searchByPrice(books, n, 500));

        System.out.println("Minimum Books: " +
                minBooksForTargetCost(books, n, 1000));
    }
}