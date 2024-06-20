package org.example.com.main.books;

public class Fiksi extends Book{
    private String category = "Fiksi";
    public Fiksi(String bookId, String title, String author, int stock){
        super(bookId,title,author,stock);
        super.setCategory(category);
    }

    @Override
    public String getCategory() {
        return category;
    }
}