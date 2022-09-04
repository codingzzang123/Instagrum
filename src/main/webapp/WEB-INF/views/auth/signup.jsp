<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<%--    <style>--%>
<%--        .valid{--%>
<%--            font-size: 12px;--%>
<%--        }--%>
<%--    </style>--%>



</head>

<body>
    <div class="container">
        <main class="loginMain">
           <!--회원가입섹션-->
            <section class="login">
                <article class="login__form__container">
                  
                   <!--회원가입 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><img src="/images/logo.jpg" alt=""></h1>
                         <!--로고end-->
                         
                         <!--회원가입 인풋-->
                        <form class="login__input" name="signForm" action="/auth/signup" method="post" onsubmit="return allCheck();">
                            <input type="text" name="username" id="id" placeholder="id" required="required" oninput="checkId()"/>
                            <div class="valid" id="id_check"></div>
                            <input type="password" name="password" id="password" placeholder="password" required="required" oninput="checkPw()"/>
                            <div class="valid" id="password_check"></div>
                            <input type="email" name="email" id="email" placeholder="email" required="required" oninput="checkEmail()"/>
                            <div class="valid" id="email_check"></div>
                            <input type="text" name="name" id="name" placeholder="name" required="required" oninput="checkName()"/>
                            <div class="valid" id="name_check"></div>
                            <button>가입</button>
                        </form>
                        <!--회원가입 인풋end-->
                    </div>
                    <!--회원가입 폼end-->
                    
                    <!--계정이 있으신가요?-->
                    <div class="login__register">
                        <span>계정이 있으신가요?</span>
                        <a href="/auth/signin">로그인</a>
                    </div>
                    <!--계정이 있으신가요?end-->
                    
                </article>
            </section>
        </main>
    </div>
</body>


<script type="text/javascript">
    var id_check = false;
    var password_check = false;
    var email_check = false;
    var name_check = false;

    function allCheck(){

        if(id_check == true &&
            password_check == true &&
            name_check == true &&
            email_check == true){
            return true;
        }else{
            return false;
        }
    }

    function checkId(){
        var idReg = /^(?=.*[A-Za-z])[0-9a-zA-Z]{4,12}$/;
        var id = $('#id').val();
        $.ajax({
            url:'/auth/check', //Controller에서 인식할 주소
            type:'post', //POST 방식으로 전달
            data:{ id:id},
            success:function(data){
                if(!idReg.test(id) || id == null){
                    $("#id_check").text("영소문자와 숫자를 조합해 4~12자리로 이루어져야합니다.");
                    $("#id_check").css("color", "red");
                }else if(data == 1){
                    $("#id_check").text("사용중인 아이디 입니다.");
                    $("#id_check").css("color", "red");
                }else if(data == -1){
                    $("#id_check").text("사용가능한 아이디 입니다.");
                    $("#id_check").css("color", "green");
                    id_check = true;
                }
            },
        });
    }

    function checkPw(){
        var inputed = $('#password').val();
        var passReg = /^^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&~^])[A-Za-z\d@$!%*#?&~^]{7,13}$/;

        if(passReg.test(inputed)){
            $("#password_check").text("사용가능한 비밀번호 입니다.");
            $("#password_check").css("color", "green");
            password_check = true;

        }else if(!passReg.test(inputed)){
            $("#password_check").text("영소문자와 숫자,특수문자(@,$,!,%,*,#,?,&,~,<,^)를 조합해 7~14자리로 이루어져야 합니다.");
            $("#password_check").css("color", "red");
        }
    }

    function checkEmail(){
        var email = $('#email').val();
        var emailReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

        $("#email_check").css("font-size", "12px");

        if(emailReg.test(email)){
            $("#email_check").text("정상적인 이메일입니다.");
            $("#email_check").css("color", "green");
            email_check = true;
        }else if(!emailReg.test(email)){
            $("#email_check").text("올바른 이메일 형식이 아닙니다.");
            $("#email_check").css("color", "red");
        }
    }

    function checkName(){
        var nameReg = /^[가-힣]{2,4}$/;
        var name = $('#name').val();

        if(nameReg.test(name)){
            $("#name_check").text("정상적인 이름 형식입니다.");
            $("#name_check").css("color", "green");
            name_check = true;
        }else{
            $("#name_check").text("올바른 이름 형식이 아닙니다.");
            $("#name_check").css("color", "red");
        }
    }

</script>
</html>