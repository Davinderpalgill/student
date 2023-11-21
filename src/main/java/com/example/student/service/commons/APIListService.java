package com.example.student.service.commons;

import org.springframework.data.domain.Pageable;

public interface APIListService {
    Pageable getPageable(int pageNo, int perPage, String sort);
}
