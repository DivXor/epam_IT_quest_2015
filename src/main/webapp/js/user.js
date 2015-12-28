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
            var responceData = JSON.parse(data);
            console.log(responceData);
            if (responceData.answerStatus == errorResponce){
                var score = responceData.score;
                switch (true){
                    case ((score < 1 && score > 0) || (score > 1 && score <= 4)):
                        score += ' балла';
                        break;
                    case (score == 1):
                        score += ' балл';
                        break;
                    case (score > 4):
                        score += ' баллов';
                        break;
                    default:
                        score += ' баллов';
                        break;
                }
                document.getElementById('score').innerHTML = score;
                $("#error-message").removeClass("hide");
                $('html, body').animate({scrollTop: 0}, 700);
            }
            if (responceData.answerStatus == successResponce){
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

function goNext(path) {
    BootstrapDialog.show({
        title: 'Предупреждение!',
        message: 'Вы действительно уверены что хотите перейти к следующему заданию? \n' +
        'Вы уже не сможете вернуться к выполнению текущего задания.',
        buttons: [{
            label: 'OK',
            cssClass: 'btn-primary',
            action: function () {
                window.location = '/'+ path +'/next';
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
