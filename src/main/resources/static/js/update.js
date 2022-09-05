// (1) 회원정보 수정
function update(userId,event) {

    event.preventDefault(); //폼 태그 액션 disable
    let data = $("#profileUpdate").serialize();

    console.log(data);

    $.ajax({
        type: 'put',
        url: '/api/user/'+userId,
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        dataType: 'json'
    }).done(res => {
        console.log("success");
        location.href = '/user/'+userId;
    }).fail(error => {
        console.log("fail");
    });

}