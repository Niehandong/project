package com.cy.store.service;

import com.cy.store.entity.Order;

import java.nio.file.AccessDeniedException;

public interface OrderService {

    Order create(Integer aid, Integer uid, String username, Integer[] cids) throws AccessDeniedException;
}
