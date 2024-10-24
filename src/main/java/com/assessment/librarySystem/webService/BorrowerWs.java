package com.assessment.librarySystem.webService;

import com.assessment.librarySystem.dto.BorrowerReqBean;
import com.assessment.librarySystem.dto.BorrowerRespBean;
import com.assessment.librarySystem.service.BorrowerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerWs {

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping
    @RequestMapping("/registerBorrower")
    public ResponseEntity<BorrowerRespBean> registerBorrower(@Valid @RequestBody BorrowerReqBean requestDTO) {
        BorrowerRespBean responseDTO = borrowerService.addBorrower(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
