package com.sonam.chophel.ttpl.service;

;
import com.sonam.chophel.ttpl.dao.ChargeAllocationDao;
import com.sonam.chophel.ttpl.dto.ChargeAllocationDTO;
import com.sonam.chophel.ttpl.entity.ChargeAllocation;
import com.sonam.chophel.enumeration.SystemDataInt;
import com.sonam.chophel.helper.BeanValidator;
import com.sonam.chophel.helper.CurrentUser;
import com.sonam.chophel.helper.DropdownDTO;
import com.sonam.chophel.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by USER on 9/5/2019.
 */
@Service
public class ChargeAllocationService {
    @Autowired
    protected BeanValidator beanValidator;
    @Autowired
    private ChargeAllocationDao chargeAllocationDao;

    public List<DropdownDTO> getServiceName() {
        return chargeAllocationDao.getServiceName();
    }

    public List<DropdownDTO> getDocumentList() {
        return chargeAllocationDao.getDocumentList();
    }

    public ResponseMessage getChargeList() {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ChargeAllocationDTO> chargeAllocationDTOs = chargeAllocationDao.getChargeList();
        if (chargeAllocationDTOs != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(chargeAllocationDTOs);
        }
        return responseMessage;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage saveChargeAllocation(CurrentUser currentUser, ChargeAllocationDTO chargeAllocationDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        beanValidator.Validate(chargeAllocationDTO, responseMessage);
        if (responseMessage.getResponseStatus() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
            return responseMessage;
        }
        Integer serviceChargeId = chargeAllocationDTO.getServiceChargeId();
        if (serviceChargeId == null) {
            Integer isExistSave = chargeAllocationDao.isExistSave(chargeAllocationDTO);
            if (isExistSave != null) {
                String documentName = chargeAllocationDao.getDocumentName(chargeAllocationDTO.getDocumentId());
                String serviceName = chargeAllocationDao.getServiceName(chargeAllocationDTO.getServiceId());
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("Charge for " + documentName + " under " + serviceName + " is already saved.");
                return responseMessage;
            }
            Integer LastServiceChargeId = chargeAllocationDao.getLastServiceChargeId();
            if (LastServiceChargeId == null) {
                LastServiceChargeId = 1;
            }
            chargeAllocationDTO.setServiceChargeId(LastServiceChargeId + 1);
            ChargeAllocation chargeAllocation = convertDtoToEntity(currentUser, chargeAllocationDTO);
            chargeAllocationDao.saveChargeAllocation(chargeAllocation);
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseText("Saved successfully.");
        } else {
            ChargeAllocationDTO chargeAllocationDetailDTO = chargeAllocationDao.getChargeDetail(serviceChargeId);
            chargeAllocationDTO.setServiceId(chargeAllocationDetailDTO.getServiceId());
            chargeAllocationDTO.setDocumentId(chargeAllocationDetailDTO.getDocumentId());

            ChargeAllocation chargeAllocation = convertDtoToEntity(currentUser, chargeAllocationDTO);
            chargeAllocationDao.saveChargeAllocation(chargeAllocation);
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseText("Updated successfully.");
        }
        return responseMessage;
    }

    private ChargeAllocation convertDtoToEntity(CurrentUser currentUser, ChargeAllocationDTO chargeAllocationDTO) {
        ChargeAllocation chargeAllocation = new ChargeAllocation();
        chargeAllocation.setServiceChargeId(chargeAllocationDTO.getServiceChargeId());
        chargeAllocation.setServiceId(chargeAllocationDTO.getServiceId());
        chargeAllocation.setChargeAmount(chargeAllocationDTO.getChargeAmount());
        chargeAllocation.setStatusTag(chargeAllocationDTO.getStatusTag());
        chargeAllocation.setUpdatedBy("aw");
        chargeAllocation.setUpdatedDate(new Date());
        return chargeAllocation;
    }

}
