
/**
Author = Kritim Bastola
Library project
 */
public class Library {

    /** Unique books in the library. */
    private Book[] books;

    /** Number of copies for each book. */
    private int[] copies;

    /** Number of copies currently on the shelf (checked in) for each book. */
    private int[] checkedIn;

    /** Number of unique books in the library. */
    private int numBooks;

    /** Construct a new empty Library. */
    public Library(int librarySize) {
        books = new Book[librarySize];
        copies = new int[librarySize];
        checkedIn = new int[librarySize];
        numBooks = 0;
    }

    /**
     * Get the number of total copies of all books that exist in the
     * library.
     * @return Total number of copies in the library.
     */
    public int getTotalCopies() {
        int totalCopies =0;
        for (int i=0; i<numBooks; i++){
            totalCopies+=copies[i];

        }
        return totalCopies;
    }

    /**
     * Get the number of copies currently checked out.
     * @return Total number of copies checked out.
     */
    public int getTotalCheckedOut() {
        int totalCheckedIn = 0;
        for (int i=0; i<checkedIn.length-1; i++){
            totalCheckedIn+=checkedIn[i];
        }
        return getTotalCopies()-totalCheckedIn;
    }

    /**
     * Get a String representing the status of the library.
     * @return Status string.
     */
    public String getStatus() {
        String returnString1 = "Total unique books: "+numBooks;
        String returnString2 = "Total number of copies: "+ getTotalCopies();
        String returnString3 = "Total checked out: "+ getTotalCheckedOut();
        String finalReturn = returnString1 +"\n"+ returnString2 +
                "\n"+returnString3;



        return finalReturn;
    }

    /**
     * Add a single book to the library, on the shelf.

     * If the book is already present, adds another copy.
     * If the book is new, add it after the existing books.
     * @param b Book to add.
     */
    public void addBook( Book b ) {

        for (int i=0; i<numBooks; i++){
            if (books[i].isSame(b)){
                copies[i]+=1;
                checkedIn[i]+=1;
                return;
            }
        }
        books[numBooks] = b;
        copies[numBooks] = 1;
        checkedIn[numBooks] = 1;
        numBooks+=1;


    }

    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks( Book[] newBooks ) {
        for (int i=0; i<newBooks.length; i++){
            addBook(newBooks[i]);
        }


    }

    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOut ( Book b ) {
        for (int i=0; i<numBooks; i++){
            if (books[i].isSame(b)){
                if(checkedIn[i]==0){
                    return "All of our copies are already checked out.";
                }
                else if(checkedIn[i]>0){
                    checkedIn[i]-=1;
                    return "Checked out!";
                }
            }

        }
        return "Book not known in library.";
    }

    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkIn ( Book b ) {
        int index = -1;
        boolean isThere = false;

        for (int i=0; i<numBooks; i++){
            if (books[i]==b){
                index = i;
                isThere = true;
                break;
            }
        }
        if (index!=-1){
            if(copies[index]==0){
                numBooks+=1;
                copies[index]+=1;
            }

        }

        if(!isThere){
            System.out.println("Book not known in library.");
            return "Book not known in library.";

        }
        else if (checkedIn[index]==copies[index]){
            System.out.println("All of our copies are already checked in");
            return "All of our copies are already checked in.";
        }
        else{
            checkedIn[index]+=1;
            System.out.println("Checked in!");
            return"Checked in!";
        }


    }



    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
         String returnStatement= "";

        for (int i=0; i<numBooks; i++){
            returnStatement += i+". "+ books[i].getTitle()+". "+
                    books[i].getAuthor()+". : "+checkedIn[i] +"/"+ copies[i]
                    +"\n";
        }
        returnStatement+="\n";

        returnStatement+= getStatus();
        System.out.println(returnStatement);
        return returnStatement;

    }

    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor( Author a ) {
        int uniqueBook = 0;
        for(int i=0; i<numBooks; i++){
            if(books[i].getAuthor().hasSameName(a)){

                    uniqueBook+=1;

            }
        }
        return uniqueBook;
    }

    /**
     * Returns a String that lists the unique books which exist for a
     * given author, in standard book format, with a newline after
     * each.  If no books are found for the author, returns string
     * that says so.
     *
     * @param a The author in question.
     * @return String listing books by the author.
     */
    public String listBooksByAuthor( Author a ) {
        String bookOfAuthor ="";

        for(int i=0; i<numBooks; i++){
            if(books[i].getAuthor().hasSameName(a)){
                bookOfAuthor += books[i].getTitle()+". "
                        +books[i].getAuthor()+"."+'\n';
            }
        }
        if(numBooksByAuthor(a)!=0){

            return bookOfAuthor;

        }
        else{

            return "No books by "+ a.toString()+".";

        }

    }

    /**
     * Returns string that lists the unique books with contain the
     * given string within their titles, without regard for case, with
     * a newline after each.  If no books are found containing the
     * string, returns string that says so.
     * @param s The string to look for in the titles.
     * @return String listing books that contain given string in titles.
     */
    public String listBooksByTitle( String s ) {


        String bookTitle ="";

        for (int i=0; i<numBooks; i++){
            if(books[i].getTitle().toLowerCase().contains(s.toLowerCase())){
                bookTitle +=  books[i].getTitle()+". "
                        +books[i].getAuthor()+"."+"\n";

            }
        }
        if(bookTitle!=""){
            return (bookTitle);
        }
        else{
            return "No books with \""+s+"\" in the title.";
        }



    }

    /**
     * Deletes book entirely from the library.
     * @param b Book to remove.
     * @return String denoting success or failure.
     */
    public String deleteBook( Book b ) {
        boolean isThere = false;
        int index =-1;
        for(int i=0; i<numBooks; i++){
            if(b.equals(books[i])){
                isThere=true;
                index = i;
                break;
            }
        }
        if(!isThere){
            return"Book not known in library.";
        }
        else{
            System.out.println(index);

            for(int i=index; i<numBooks; i++){
                books[i] = books[i+1];
                copies[i] = copies[i+1];
                checkedIn[i] = checkedIn[i+1];
            }
            numBooks-=1;


            return "Book removed.";

        }
    }

}
