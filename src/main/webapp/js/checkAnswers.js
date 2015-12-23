var taskURL = "/task";
var errorResponce = "error";
var successResponce = "success";

jQuery(document).ready(function ($) {
    //$("#submit-button").click(function () {
    //    sendAnswers();
    //});

    $("#close-button").click(function (){
        $("#error-message").addClass("hide");
    })
});

function sendAnswers(url, formId) {
    $.post(url, $("#" + formId).serialize())
        .done(function (data) {
            console.log(data);
            if (data == errorResponce){
                $("#error-message").removeClass("hide");
                $('html, body').animate({scrollTop: 0}, 700);
            }
            if (data == successResponce){
                window.location.replace(taskURL);
            }
        })
}
