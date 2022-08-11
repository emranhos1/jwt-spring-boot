package com.javainuse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javainuse.service.serviceImpl.IHelloService;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
@Service
public class HelloService implements IHelloService {

    @Override
    public Integer get() {
        return 1;
    }

    @Override
    public List<Integer> getAll() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        return list;
    }
}