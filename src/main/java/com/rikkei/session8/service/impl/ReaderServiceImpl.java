package com.rikkei.session8.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rikkei.session8.model.dto.request.ReaderCreateDTO;
import com.rikkei.session8.model.entity.Reader;
import com.rikkei.session8.repository.ReaderRepository;
import com.rikkei.session8.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;
    private final Cloudinary cloudinary;
    @Override
    public Reader createReader(ReaderCreateDTO readerCreateDTO) {
        if(readerRepository.existsByEmail(readerCreateDTO.getEmail())) {
            throw new IllegalStateException("Email already exists!");
        }
        MultipartFile file = readerCreateDTO.getAvatar();
        if(file == null||file.isEmpty()) {
            throw new IllegalStateException("File cannot be empty!");
        }
        String fileName = Objects
                .requireNonNull(file.getOriginalFilename())
                .toLowerCase();
        if(!fileName.endsWith(".png")
                && !fileName.endsWith(".jpg")
                && !fileName.endsWith(".jpeg")) {

            throw new IllegalStateException("File type not supported!");
        }

        try {
            Map<String, Object> uploadFile =
                    cloudinary.uploader()
                            .upload(file.getBytes(), ObjectUtils.emptyMap());

            String url=uploadFile.get("url").toString();
            Reader reader=Reader.builder()
                    .email(readerCreateDTO.getEmail())
                    .fullName(readerCreateDTO.getFullName())
                    .phone(readerCreateDTO.getPhone())
                    .address(readerCreateDTO.getAddress())
                    .avatar(url)
                    .build();
            return  readerRepository.save(reader);
        } catch (IOException e) {
            throw new RuntimeException("Upload file failed!",e);
        }
    }
}
