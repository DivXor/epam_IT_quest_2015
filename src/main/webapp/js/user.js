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
