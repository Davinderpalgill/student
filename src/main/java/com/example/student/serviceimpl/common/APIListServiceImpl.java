package com.example.student.serviceimpl.common;

import com.example.student.exception.OSException;
import com.example.student.exception.enumexception.ErrorCode;
import com.example.student.service.commons.APIListService;
import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class APIListServiceImpl implements APIListService {
    public APIListServiceImpl() {
    }

    public Pageable getPageable(int pageNo, int perPage, String sort) {
        if (pageNo < 1) {
            throw new OSException(ErrorCode.INVALID_PAGE_REQUEST);
        } else {
            --pageNo;
            if (StringUtils.isNotEmpty(sort)) {
                List<Sort.Order> orders = this.getSortOrder(sort);
                if (!orders.isEmpty()) {
                    return PageRequest.of(pageNo, perPage, Sort.by(orders));
                }
            }

            return PageRequest.of(pageNo, perPage);
        }
    }

    private List<Sort.Order> getSortOrder(String sortStr) throws OSException {
        List<Sort.Order> ordersList = new ArrayList();
        String[] sortStrList = sortStr.trim().split(";");

        try {
            String[] var4 = sortStrList;
            int var5 = sortStrList.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String sortOrder = var4[var6];
                String[] sort = sortOrder.split(":");
                if (!sortOrder.contains("asc") && !sortOrder.contains("desc")) {
                    ordersList.add(new Sort.Order(this.getSortDirection(""), sort[0].trim()));
                } else {
                    ordersList.add(new Sort.Order(this.getSortDirection(sort[1].trim()), sort[0].trim()));
                }
            }

            return ordersList;
        } catch (Exception var9) {
            throw new OSException(ErrorCode.INVALID_SORT_ORDER_REQUEST);
        }
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Direction.ASC;
        } else {
            return direction.equals("desc") ? Direction.DESC : Direction.ASC;
        }
    }
}
