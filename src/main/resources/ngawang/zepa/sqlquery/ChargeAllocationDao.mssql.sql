ChargeAllocationDao.getServiceName = SELECT S.SERVICE_ID AS valueInteger, S.SERVICE_NAME AS text FROM t_service_master S WHERE S.IS_ACTIVE ='Y'

ChargeAllocationDao.getDocumentList = SELECT D.DOCUMENT_ID AS valueInteger,D.DOCUMENT_NAME AS text FROM t_document_master D WHERE D.IS_ACTIVE = 'Y'

ChargeAllocationDao.getChargeList = SELECT S.SERVICE_CHARGE_ID AS serviceChargeId \
                                    ,S.SERVICE_SL_NO AS serviceId \
                                    ,M.SERVICE_NAME AS serviceName \
                                    ,S.DOCUMENT_ID AS documentId \
                                    ,D.DOCUMENT_NAME AS documentName \
                                    ,S.CHARGE_AMOUNT AS chargeAmount \
                                    ,S.IS_ACTIVE AS statusTag \
                                    ,IF(S.IS_ACTIVE = 'Y','Active','Inactive') AS statusTagName \
                                    FROM t_service_charge S INNER JOIN t_service_master M \
                                    ON S.SERVICE_SL_NO = M.SERVICE_SL_NO \
                                    LEFT JOIN t_document_master D ON D.DOCUMENT_ID = S.DOCUMENT_ID ORDER BY S.SERVICE_SL_NO

ChargeAllocationDao.isExistSave = SELECT SERVICE_CHARGE_ID FROM t_service_charge S \
                                  WHERE S.SERVICE_SL_NO =:serviceId AND (:documentId IS NULL OR S.DOCUMENT_ID =:documentId) LIMIT 1

ChargeAllocationDao.getLastServiceChargeId = SELECT S.SERVICE_CHARGE_ID FROM t_service_charge S ORDER BY S.SERVICE_CHARGE_ID DESC LIMIT 1

ChargeAllocationDao.getChargeDetail = SELECT S.SERVICE_SL_NO AS serviceId \
                                ,S.DOCUMENT_ID AS documentId \
                                ,S.CHARGE_AMOUNT AS chargeAmount \
                                ,S.IS_ACTIVE AS statusTag \
                                FROM t_service_charge S WHERE S.SERVICE_CHARGE_ID =:serviceChargeId

ChargeAllocationDao.getDocumentName = SELECT D.DOCUMENT_NAME FROM t_document_master D WHERE D.DOCUMENT_ID =:documentId

ChargeAllocationDao.getServiceNameByServiceId = SELECT S.SERVICE_NAME FROM t_service_master S WHERE S.SERVICE_ID =:serviceId
