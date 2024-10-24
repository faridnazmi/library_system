package com.assessment.librarySystem.service;

import com.assessment.librarySystem.dto.BorrowerReqBean;
import com.assessment.librarySystem.dto.BorrowerRespBean;
import com.assessment.librarySystem.entity.BorrowerEntity;
import com.assessment.librarySystem.repository.BorrowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerDao borrowerDao;

    public BorrowerRespBean addBorrower(BorrowerReqBean requestDTO) {
        BorrowerEntity borrower = new BorrowerEntity();
        borrower.setBorrowerName(requestDTO.getBorrowerName());
        borrower.setBorrowerEmail(requestDTO.getBorrowerEmail());

        BorrowerEntity savedBorrower = borrowerDao.save(borrower);

        BorrowerRespBean responseDTO = new BorrowerRespBean();
        responseDTO.setBorrowerId(savedBorrower.getBorrowerId());
        responseDTO.setBorrowerName(savedBorrower.getBorrowerName());
        responseDTO.setBorrowerEmail(savedBorrower.getBorrowerEmail());

        return responseDTO;
    }
}
