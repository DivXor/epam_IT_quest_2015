$(document).ready(function(){
    $('.game-table-container .table-block table tr td').click(function(){
        if(!$(this).hasClass('active')) {
            $(this).addClass('active');
        } else {
            $(this).removeClass('active');
        }
    })
});