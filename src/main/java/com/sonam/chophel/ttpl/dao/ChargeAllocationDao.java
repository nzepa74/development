package com.sonam.chophel.ttpl.dao;

import com.sonam.chophel.ttpl.dto.ChargeAllocationDTO;
import com.sonam.chophel.ttpl.entity.ChargeAllocation;
import com.sonam.chophel.helper.DropdownDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by USER on 9/5/2019.
 */
@Repository
public class ChargeAllocationDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<DropdownDTO> getServiceName() {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getServiceName");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getDocumentList() {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getDocumentList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ChargeAllocationDTO> getChargeList() {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getChargeList");
        Query hQuery = hibernateQuery(sqlQuery, ChargeAllocationDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public Integer isExistSave(ChargeAllocationDTO chargeAllocationDTO) {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.isExistSave");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("serviceId", chargeAllocationDTO.getServiceId())
                .setParameter("documentId", chargeAllocationDTO.getDocumentId());
        return (Integer) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public Integer getLastServiceChargeId() {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getLastServiceChargeId");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        return (Integer) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public ChargeAllocationDTO getChargeDetail(Integer serviceChargeId) {
        String query = properties.getProperty("ChargeAllocationDao.getChargeDetail");
        org.hibernate.Query hQuery = hibernateQuery(query, ChargeAllocationDTO.class);
        hQuery.setParameter("serviceChargeId", serviceChargeId);
        return (ChargeAllocationDTO) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public String getDocumentName(Integer documentId) {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getDocumentName");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("documentId", documentId);
        return (String) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public String getServiceName(Integer serviceId) {
        String sqlQuery = properties.getProperty("ChargeAllocationDao.getServiceNameByServiceId");
        org.hibernate.Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("serviceId", serviceId);
        return (String) hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void saveChargeAllocation(ChargeAllocation chargeAllocation) {
        getReportingSession().saveOrUpdate(chargeAllocation);
    }
}
