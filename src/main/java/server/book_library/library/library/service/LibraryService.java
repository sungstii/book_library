package server.book_library.library.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.book_library.global.exception.BusinessLogicException;
import server.book_library.global.exception.ExceptionCode;
import server.book_library.library.library.entity.Library;
import server.book_library.library.library.repository.LibraryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public Library createLibrary(Library library) {

        return libraryRepository.save(library);
    }

    public Library findById(long id) {
        Optional<Library> optionalLibrary = libraryRepository.findById(id);

        return optionalLibrary.orElseThrow(() -> new BusinessLogicException(ExceptionCode.LIBRARY_NOT_FOUND));
    }
}
