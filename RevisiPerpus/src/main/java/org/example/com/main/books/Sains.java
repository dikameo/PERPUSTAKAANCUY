package org.example.com.main.books;

public class Sains extends Book{
    private String category = "Sains";
    public Sains(String bookId, String title, String author, int stock){
        super(bookId,title,author,stock);
        super.setCategory(category);
    }

    @Override
    public String getCategory() {
        return category;
    }
}