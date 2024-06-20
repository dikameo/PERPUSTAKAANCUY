package org.example.com.main.books;

public class NonFiksi extends Book{
    private String category = "NonFiksi";
    public NonFiksi(String bookId, String title, String author, int stock){
        super(bookId,title,author,stock);
        super.setCategory(category);
    }

    @Override
    public String getCategory() {
        return category;
    }
}