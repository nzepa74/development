
chargeAllocation = (function () {
    "use strict";
    var form = $('#chargeAllocationFormId');
    var isSubmitted = false;


    function _baseURL() {
        return 'chargeAllocation/';
    }

    function validateFields() {
        var retval = true;
        var serviceId = $('#serviceId');
        if (serviceId.val() == "") {
            $('#serviceId').addClass('error');
            $('#serviceIdErrorMsg').html('Service type is required');
            retval = false;
        }
        if ((serviceId.val() == 311 || serviceId.val() == 312) && ($('#documentId').val() == "")) {
            $('#documentIdErrorMsg').html('Document type is required');
            $('#documentId').addClass('error');
            retval = false;
        }
        if ($('#chargeAmount').val() == "") {
            $('#chargeAmount').addClass('error');
            $('#chargeAmountErrorMsg').html('Charges (Nu) is required');
            retval = false;
        }
        return retval;
    }


    function removeErrorMsg() {
        $('#serviceId').on('change', function () {
            var serviceId = $(this).val();
            if (serviceId != '') {
                $('#serviceId').removeClass('error');
                $('#serviceIdErrorMsg').text('');
            }
        });
        $('#documentId').on('change', function () {
            var documentId = $(this).val();
            if (documentId != '') {
                $('#documentId').removeClass('error');
                $('#documentIdErrorMsg').text('');
            }
        });
        $('#chargeAmount').on('keyup blur', function () {
            var chargeAmount = $(this).val();
            if (chargeAmount != '') {
                $('#chargeAmount').removeClass('error');
                $('#chargeAmountErrorMsg').text('');
            }
        });
    }

    function saveChargeAllocation() {
        $('#btnSave').on('click', function () {
            form.validate({
                submitHandler: function (form) {
                    if (!validateFields()) {
                        return false;
                    }
                    var url = _baseURL() + 'saveChargeAllocation';
                    var data = $(form).serializeArray();
                    if (isSubmitted) {
                        errorMsg('Your request is processing. Please wait...');
                        return;
                    }
                    isSubmitted = true;
                    $('#btnSave').attr('disabled', true);
                    $.ajax({
                        url: url,
                        type: 'post',
                        data: data,
                        processData: true,
                        success: function (res) {
                            if (res.responseStatus == 1) {
                                getChargeList();
                                successMsg(res.responseText);
                                resetFields();
                            } else {
                                warningMsg(res.responseText);
                            }
                        }, complete: function () {
                            isSubmitted = false;
                            $('#btnSave').attr('disabled', false);
                        }
                    });
                }
            });
        });
    }

    function getChargeList() {
        var url = _baseURL() + 'getChargeList';
        $.ajax({
            url: url,
            type: 'GET',
            success: function (res) {
                if (res.responseStatus == 1) {
                    var data = res.responseDTO;
                    var dataTableDefinition = [
                        {"data": "serviceChargeId", class: "serviceChargeId hidden"}
                        , {"data": "serviceId", class: "serviceId hidden"}
                        , {"data": "documentId", class: "documentId hidden"}
                        , {"data": "statusTag", class: "statusTag hidden"}
                        , {
                            "mRender": function (data, type, row, meta) {
                                return meta.row + 1;
                            }
                        }
                        , {"data": "serviceName", class: "serviceName"}
                        , {"data": "documentName", class: "documentName"}
                        , {"data": "chargeAmount", class: "right-align chargeAmount"}
                        , {"data": "statusTagName", class: "statusTagName"}
                        , {
                            "data": "null", class: "btnEdit align-middle",
                            "mRender": function () {
                                return "<a id='btnEdit' class='btn btn-sm btn-info align-middle'>Edit</a>";
                            }
                        }
                    ];
                    $('#chargeListTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                        //, pageLength: 50
                    });
                }
            }
        });
    }

    function onChangeServiceId() {
        $('#serviceId').on('change', function () {
            var serviceId = $(this).val();
            var documentId = $('#documentId');
            $('#documentId').removeClass('error');
            $('#documentIdErrorMsg').html('');
            if (serviceId == 311 || serviceId == 312) {
                documentId.prop('disabled', false);
            } else {
                documentId.val('').prop('disabled', true);
            }
        });
    }

    function btnEdit() {
        $('#chargeListTableId tbody').on('click', 'tr #btnEdit', function () {
            $(':input').removeClass('error');
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var serviceChargeId = selectedRow.find('.serviceChargeId').text();
            var serviceId = selectedRow.find('.serviceId').text();
            var documentId = selectedRow.find('.documentId').text();
            var statusTag = selectedRow.find('.statusTag').text();
            var chargeAmount = selectedRow.find('.chargeAmount').text();
            selectedRow.removeClass('selected');
            $('#serviceChargeId').val(serviceChargeId);
            $('#serviceId').val(serviceId).prop('disabled', true);
            $('#documentId').val(documentId).prop('disabled', true);
            $('#chargeAmount').val(chargeAmount);
            $('.text-danger').text('');
            if (statusTag == 'Y') {
                $('#statusTagActive').prop('checked', true);
                $('#statusTagInactive').prop('checked', false);
            } else {
                $('#statusTagInactive').prop('checked', true);
                $('#statusTagActive').prop('checked', false);
            }
        });
    }

    function resetFields() {
        $('.field').val('');
        $('.text-danger').text('');
        $('#statusTagActive').prop('checked', false);
        $('#statusTagInactive').prop('checked', true);
        $('#serviceId').prop('disabled', false);
        $('#documentId').prop('disabled', false);
        $(':input').removeClass('error');
        getChargeList();
    }

    function btnReset() {
        $('#btnReset').on('click', function () {
            resetFields();
        });
    }

    return {
        getChargeList: getChargeList
        , onChangeServiceId: onChangeServiceId
        , removeErrorMsg: removeErrorMsg
        , btnEdit: btnEdit
        , btnReset: btnReset
        , saveChargeAllocation: saveChargeAllocation
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        chargeAllocation.getChargeList();
        chargeAllocation.onChangeServiceId();
        chargeAllocation.btnEdit();
        chargeAllocation.btnReset();
        chargeAllocation.removeErrorMsg();
        chargeAllocation.saveChargeAllocation();
    });
