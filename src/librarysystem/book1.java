
package librarysystem;


public class book1 {
    
    
    private String ISBN;
    private String Author;
    private String releaseDate;
    private double price;
    private String title;

    public book1(String ISBN, String Author, String releaseDate, double price, String title) {
        this.ISBN = ISBN;//for this particular object(ISBN) set to parameter ISBN
        this.Author = Author;
        this.releaseDate = releaseDate;
        this.price = price;
        this.title = title;
    }

    
    public String toString(){
        return ISBN + ", " + Author + ", " + releaseDate + ", " + price + ", " + title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
   
    
}
