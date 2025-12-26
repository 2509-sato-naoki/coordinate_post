$(document).ready(function() {
    $('#follow-btn').on('click', function() {
        const $button = $(this);
        const userId = $button.attr('data-follow-id');
        const isFollowed = $button.hasClass('active');
        //クラスの有無で、ajaxのURLを変える
        const url = isFollowed ? "/follow/delete" : "/follow/add";
        $.ajax({
            type: 'POST',
            url: url,
            data: { userId:userId }
        }).done(function (response) {
            if (isFollowed) {
                //フォロー解除処理
                $button.removeClass('active');
                $button.text("フォローする");

            } else {
                //フォロー処理
                $button.addClass('active');
                $button.text("フォロー解除");
            }
        }).fail(function () {
                alert('データの読み込みに失敗しました。');
        });
    });
});