package com.springapps.csp.service;

import com.springapps.csp.dto.SharedCodeRequestDTO;
import com.springapps.csp.dto.mapper.SharedCodeMapper;
import com.springapps.csp.model.SharedCode;
import com.springapps.csp.repository.SharedCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class ShareCodeService {

    SharedCodeRepository sharedCodeRepository;
    private SharedCodeMapper sharedCodeMapper;

    @Autowired
    public ShareCodeService(SharedCodeRepository sharedCodeRepository, SharedCodeMapper sharedCodeMapper) {
        this.sharedCodeRepository = sharedCodeRepository;
        this.sharedCodeMapper = sharedCodeMapper;
    }

    public SharedCode addSharedCode(SharedCodeRequestDTO sharedCodeRequestDTO) {
        SharedCode sharedCode = sharedCodeMapper.mapSharedCodeDTOtoSharedCode(sharedCodeRequestDTO);
        return sharedCodeRepository.save(sharedCode);
    }
    @Transactional
    public SharedCode getSharedCode(Long codeId) throws Exception {
        SharedCode sharedCode = sharedCodeRepository.findById(codeId).orElseThrow(() -> new Exception("shared code not found"));
        if (!sharedCode.isSecret()){
            //public
            return sharedCode;
        }
        if (!isValid(sharedCode)){
            sharedCodeRepository.delete(sharedCode);
            throw  new Exception("not valid animore");
        }
        sharedCode.setViews(sharedCode.getViews()-1);
        return sharedCodeRepository.save(sharedCode);
    }

    public boolean isValid(SharedCode sharedCode){
        return sharedCode.getViews()!= 0 && (ChronoUnit.SECONDS.between(sharedCode.getCreatedDate(), LocalDateTime.now()) < sharedCode.getViewTime());
    }


}
