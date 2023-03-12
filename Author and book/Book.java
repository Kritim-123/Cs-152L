public class Book {
    private String title = AuthorBookConstants.UNSPECIFIED_TITLE;
    private int year = AuthorBookConstants.UNSPECIFIED_YEAR;
    private String isbn = AuthorBookConstants.UNSPECIFIED_ISBN;
    private Author author = AuthorBookConstants.UNSPECIFIED_AUTHOR;


    public Book(){

    }
    public Book(String title){
        if((title.equals(""))){
            System.out.println("Empty title");
        }
        else{
            this.title = title;
        }

    }
    public Book(String title, Author author){
        if(title.equals("")){
            System.out.println("Empty title");
        }
        else{
            this.title = title;
            this.author = author;
        }


    }

    /**
     *
     * @param title
     * title of author
     */
    public void setTitle( String title ){
        if (title.equals("")){
            System.out.println("Empty title");
        }
        else{
            this.title = title;
        }

    }

    /**
     *
     * @return title
     */
    public String getTitle(){
        return title;
    }

    /**
     *
     * @param author
     * class of author
     */

    public void setAuthor( Author author ){
        this.author = author;
    }

    /**
     *
     * @return author
     */

    public Author getAuthor(){
        return author;

    }

    /**
     *
     * @param year
     * year of publication
     */
    public void setPublicationYear( int year ){
        if (year>-2000 && year<2025 && year!=0){
            this.year = year;
        }

    }

    /**
     *
     * @return year
     */
    public int getPublicationYear(){
        return year;
    }

    /**
     *
     * @param isbn
     * isbn of book
     */
    public void setISBN( String isbn ){
        if(isbn.length()==13 || isbn.length()==10){
            this.isbn = isbn;
        }

    }

    /**
     *
     * @return isbn
     */
    public String getISBN(){
        return isbn;
    }

    /**
     *
     * @param other
     * other author
     * @return true if the author is same
     */
    public boolean hasSameAuthor( Book other ){
        if (author.hasSameName(other.author)){
            return true;
        }
        return false;

    }

    /**
     *
     * @param other
     * other book
     * @return true if book is same
     */
    public boolean isSame( Book other ){
        if(isbn.equals(other.isbn)){
            return true;
        }
        return false;
    }

    /**
     *
     * @return properly formatted book info based on info we have.
     */
    public String toString() {
        if (year == AuthorBookConstants.UNSPECIFIED_YEAR &&
                author == AuthorBookConstants.UNSPECIFIED_AUTHOR) {
            return title + ".";
        } else {
            if (year == AuthorBookConstants.UNSPECIFIED_YEAR) {
                return title + ". " + author.toString() + ".";
            } else {
                return title + " (" + year + "). " + author.toString() + ".";
            }
        }
    }
}



