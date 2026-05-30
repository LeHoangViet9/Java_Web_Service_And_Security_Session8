package com.rikkei.session8.service.impl;

import com.rikkei.session8.exception.ResourceNotFoundException;
import com.rikkei.session8.exception.ImageFileEmptyException;
import com.rikkei.session8.model.dto.request.BookCreateDTO;
import com.rikkei.session8.model.dto.request.BookUpdateDTO;
import com.rikkei.session8.model.entity.Book;
import com.rikkei.session8.repository.BookRepository;
import com.rikkei.session8.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Override
    public Book createBookDTO(BookCreateDTO bookCreateDTO) {
        if(bookCreateDTO.getCoverImage() == null || bookCreateDTO.getCoverImage().isEmpty()) {
            throw new ImageFileEmptyException("Cover image is empty");
        }
        MultipartFile coverImage = bookCreateDTO.getCoverImage();
        String fileName= UUID.randomUUID().toString()+"_"+coverImage.getOriginalFilename();
        File uploadFolder=new File(UPLOAD_DIR);
        if(!uploadFolder.exists()){
            uploadFolder.mkdirs();
        }
        File file = new File(UPLOAD_DIR+fileName);
        try {
            coverImage.transferTo(file);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        Book book=Book.builder()
                .title(bookCreateDTO.getTitle())
                .author(bookCreateDTO.getAuthor())
                .stock(bookCreateDTO.getStock())
                .coverUrl(fileName)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id,BookUpdateDTO bookUpdateDTO) {
        Book book=bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found"));
        book.setStock(bookUpdateDTO.getStock());
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return  bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Book "+id+" not found"));
    }
}
