package com.javainuse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.helper.ApiResponse;
import com.javainuse.helper.constants.HelloConstants;
import com.javainuse.service.serviceImpl.IHelloService;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
@RestController
@CrossOrigin()
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    IHelloService iHelloService;

    @GetMapping(HelloConstants.TEST)
    @SuppressWarnings({ HelloConstants.UNCHECKED, HelloConstants.RAWTYPES })
    public ResponseEntity<?> getTest(){
        LOG.info(HelloConstants.TEST_API_CALLED);
        return new ResponseEntity(new ApiResponse(true, HelloConstants.SUCCESS), HttpStatus.OK);
    }

    /**
     * This api is for get single data
     *
     * @author Md. Emran Hossain
     * @since  11 Aug, 2022
     */
    @GetMapping(HelloConstants.GET)
    @SuppressWarnings({ HelloConstants.UNCHECKED, HelloConstants.RAWTYPES })
    public ResponseEntity<?> get(){
        Integer data = iHelloService.get();
        return new ResponseEntity(new ApiResponse(true, HelloConstants.DATA_FOUND, data), HttpStatus.OK);
    }

    /**
     * This api is for get list data
     *
     * @author Md. Emran Hossain
     * @since  11 Aug, 2022
     */
    @GetMapping(HelloConstants.GETALL)
    @SuppressWarnings({ HelloConstants.UNCHECKED, HelloConstants.RAWTYPES })
    public ResponseEntity<?> getAll(){
        List<Integer> data = iHelloService.getAll();
        return new ResponseEntity(new ApiResponse(true, HelloConstants.DATA_FOUND, data), HttpStatus.OK);
    }
}
