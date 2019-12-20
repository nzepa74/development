$(document).ready(function () {

    if (document.URL.search("chargeAllocation") > 1)
        scriptLoader("/resources/js/ttpl/chargeAllocation.js");

});

var scriptLoader = function (url) {
    $.ajax(
        {
            type: "GET",
            url: url,
            dataType: "script",
            cache: false
        });
};

