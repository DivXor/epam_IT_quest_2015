var taskURL = "/task";
var errorResponce = "error";
var successResponce = "success";

jQuery(document).ready(function ($) {
    $("#close-button").click(function (){
        $("#error-message").addClass("hide");
    });

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

(function($){

    /**
     * Store scroll position for and set it after reload
     *
     * @return {boolean} [loacalStorage is available]
     */
    $.fn.scrollPosReaload = function(){
        if (localStorage) {
            var posReader = localStorage["posStorage"];
            if (posReader) {
                $(window).scrollTop(posReader);
                localStorage.removeItem("posStorage");
            }
            $(this).click(function(e) {
                localStorage["posStorage"] = $(window).scrollTop();
            });

            return true;
        }

        return false;
    };

    /* ================================================== */

    $(document).ready(function() {
        // Feel free to set it for any element who trigger the reload
        $('.save-position').scrollPosReaload();
    });

}(jQuery));
