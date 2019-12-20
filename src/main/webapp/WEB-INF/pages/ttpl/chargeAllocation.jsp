 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Allocate Service Charges</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;SSS Service </b> >> Allocate Service Charges</span>

    <div class="col-12">
        <form class="card form-horizontal" id="chargeAllocationFormId" action="<c:url value='/chargeAllocation'/>"
              method="post">
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
            <input type="text" class="form-control hidden field" name="serviceChargeId" id="serviceChargeId">

            <div class="card-body">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-sm-3 required">
                                        Service Type:
                                        <a data-toggle="tooltip" data-placement="top"
                                           title='Select service type.'
                                           class="tooltipCSSSelector">
                                            <img src="/resources/images/questionMark.jpg" class="user-image"
                                                 width="20px">
                                            <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId"></i>
                                        </a>
                                    </label>

                                    <div class="col-sm-4">
                                        <form:select id="serviceId" name="serviceId" path="serviceList"
                                                     class="form-control field">
                                            <form:option value="" label="--SELECT--"></form:option>
                                            <form:options items="${serviceList}" itemValue="valueInteger"
                                                          itemLabel="text"></form:options>
                                        </form:select>
                                        <span id="serviceIdErrorMsg" class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 required"> Document Type:<a data-toggle="tooltip"
                                                                                       data-placement="top"
                                                                                       title='Please document type'
                                                                                       class="tooltipCSSSelector">
                                        <img src="/resources/images/questionMark.jpg" class="user-image"
                                             id="instrumentCountryimg" width="20px">
                                    </a>

                                    </label>

                                    <div class="col-sm-4">
                                        <form:select id="documentId" name="documentId" path="documentList"
                                                     class="form-control field">
                                            <form:option value="" label="--SELECT--"></form:option>
                                            <form:options items="${documentList}" itemValue="valueInteger"
                                                          itemLabel="text"></form:options>
                                        </form:select>
                                        <span id="documentIdErrorMsg" class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 required">Charges (Nu): <a data-toggle="tooltip"
                                                                                      data-placement="top"
                                                                                      title='Enter exam year.'
                                                                                      class="tooltipCSSSelector">
                                        <img src="/resources/images/questionMark.jpg" class="user-image"
                                             width="20px">
                                        <i class='fa fa-spinner fa-spin hidden'></i>
                                    </a></label>

                                    <div class="col-sm-4">
                                        <input type="text" class="form-control field numeric" name="chargeAmount"
                                               id="chargeAmount">
                                        <span class="text-danger" id="chargeAmountErrorMsg"></span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 right-label">Status:</label>

                                    <div class="col-md-4">
                                        <input type="radio" name="statusTag" class="statusTag" id="statusTagActive"
                                               value="Y"/>
                                        <label for="statusTagActive"/>Active</label>

                                        <input type="radio" name="statusTag" class="statusTag" id="statusTagInactive"
                                               value="N" checked/>
                                        <label for="statusTagInactive"/>Inactive</label>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <div class="col-md-2 col-md-offset-3">
                                            <input type="submit" class="btn btn-xs btn-info btn-block" value="Save"
                                                   id="btnSave">
                                        </div>
                                        <div class="col-md-2">
                                            <input type="reset" class="btn btn-xs btn-info btn-block" value="Reset"
                                                   id="btnReset">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--<div class="card-body">--%>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap table-bordered"
                                   id="chargeListTableId">
                                <thead>
                                <tr>
                                    <th class="hidden">serviceChargeId</th>
                                    <th class="hidden">service Id</th>
                                    <th class="hidden">documentId</th>
                                    <th class="hidden">StatusTag</th>
                                    <th>Sl. No</th>
                                    <th>Service Name</th>
                                    <th>Document Type</th>
                                    <th>Charges (Nu)</th>
                                    <th>Status</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <%--</div>--%>
        </form>
    </div>
</div>
</body>
</html>
