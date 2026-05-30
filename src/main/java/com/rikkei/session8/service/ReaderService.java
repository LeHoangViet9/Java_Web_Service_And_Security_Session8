package com.rikkei.session8.service;

import com.rikkei.session8.model.dto.request.ReaderCreateDTO;
import com.rikkei.session8.model.entity.Reader;

public interface ReaderService {
    Reader createReader(ReaderCreateDTO readerCreateDTO);
}
