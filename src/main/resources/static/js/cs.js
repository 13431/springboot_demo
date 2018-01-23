$(function () {
    $("[data-action]").each(function () {
        $(this).on('click', function () {
            if (!window.confirm('您是否要' + $(this).data('action') + '？'))
                event.preventDefault();
        });
    })
});