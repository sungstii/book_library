package server.book_library.domain.library.inventory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import server.book_library.domain.library.inventory.dto.LibraryInventoryDto;
import server.book_library.domain.library.inventory.entity.LibraryInventory;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LibraryInventoryMapper {
    LibraryInventory LibraryInventoryPostToLibraryInventory(LibraryInventoryDto.Post post);
    LibraryInventoryDto.Response LibraryInventoryToLibraryInventoryResponse(LibraryInventory libraryInventory);
}