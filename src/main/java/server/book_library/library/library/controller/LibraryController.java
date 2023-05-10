package server.book_library.library.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.book_library.library.library.dto.LibraryDto;
import server.book_library.library.library.entity.Library;
import server.book_library.library.library.mapper.LibraryMapper;
import server.book_library.library.library.service.LibraryService;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {
    private LibraryService libraryService;
    private LibraryMapper libraryMapper;
    
    @PostMapping
    public ResponseEntity<?> createLibrary(@RequestBody LibraryDto.Post post) {
        Library library = libraryMapper.libraryPostToLibrary(post);
        Library createdLibrary = libraryService.createLibrary(library);
        LibraryDto.Response response = libraryMapper.libraryToLibraryResponse(createdLibrary);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
