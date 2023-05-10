package server.book_library.library.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import server.book_library.book.dto.BookDto;
import server.book_library.library.inventory.entity.LibraryInventory;
import server.book_library.library.library.dto.LibraryDto;

public class LibraryInventoryDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        private long bookId;
        private long libraryId;
        private int totalQuantity;
    }
    @Getter
    @AllArgsConstructor
    public static class Response{
        private long id;
        private BookDto.Response book;
        private LibraryDto.Response library;
        private int totalQuantity;
        private int loanQuantity;
        private LibraryInventory.LoanStatus loanStatus;
    }
}
