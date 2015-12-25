var taskURL = "/task";
var errorResponce = "error";
var successResponce = "success";

jQuery(document).ready(function ($) {
    $("#close-button").click(function (){
        $("#error-message").addClass("hide");
    });

    //$('.thumbnail').click(function(){
    //    var $pic = $('<div></div>');
    //    $pic.append(this.innerHTML);
    //
    //    BootstrapDialog.show({
    //        message: $pic
    //    });
    //});

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

function goToNextTask() {
    BootstrapDialog.show({
        title: 'Предупреждение!',
        message: 'Вы действительно уверены что хотите перейти к следующему заданию? \n' +
        'Вы уже не сможете вернуться к выполнению текущего задания.',
        buttons: [{
            label: 'OK',
            cssClass: 'btn-primary',
            action: function () {
                window.location = '/task/next';
            }
        }, {
            label: 'Cancel',
            action: function (dialogItself) {
                dialogItself.close();
            }
        }]
    });
}
