<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fashi | Template</title>

    <%@ include file="../inc/header.jsp" %>
    <style>
    .loader {
		  border: 16px solid #f3f3f3;
		  border-radius: 50%;
		  border-top: 16px solid red;
		  border-bottom: 16px solid black;
		  border-left: 16px solid black;
		  border-right: 16px solid black;
		  width: 120px;
		  height: 120px;
		  -webkit-animation: spin 2s linear infinite; /* Safari */
		  animation: spin 2s linear infinite;
		  position: absolute;
		  left: 50%;
		  top: 50%;
		  margin-left:-60px;
		  margin-top:-60px;
		}
		
		/* Safari */
		@-webkit-keyframes spin {
		  0% { -webkit-transform: rotate(0deg); }
		  100% { -webkit-transform: rotate(360deg); }
		}
		
		@keyframes spin {
		  0% { transform: rotate(0deg); }
		  100% { transform: rotate(360deg); }
		}
		
		#overlay {
		  position: fixed; /* Sit on top of the page content */
		  display: none; /* Hidden by default */
		  width: 100%; /* Full width (cover the whole page) */
		  height: 100%; /* Full height (cover the whole page) */
		  top: 0;
		  left: 0;
		  right: 0;
		  bottom: 0;
		  background-color: rgba(0,0,0,0.5); /* Black background with opacity */
		  z-index: 2; /* Specify a stack order in case you're using a different order for other elements */
		  cursor: pointer; /* Add a pointer on hover */
		}
    </style>
    <script>
    	
	$("#user_id").blur(function() {
		// id = "id_reg" / name = "userId"
		var user_id = $('#user_id').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/user/idCheck?userId='+ user_id,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_id)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#id_check").text("사용 가능한 아이디입니다 :p");
							$("#id_check").css("color", "green");
							$("#reg_submit").attr("disabled", true);
				
						} else if(user_id == ""){
							
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
		$(function(){
			//회원가입 처리
			$("input[type='button']").click(function(){
				regist();
			});
		});
		//요청이 완료되는 시점에 프로그래스바를 감춘다!!
		function regist(){
			//로딩바 시작
			$("#loader").addClass("loader"); //class 동적 적용
			document.getElementById("overlay").style.display = "block";
			
			//data의 키 값으로 form태그의 파라미터들을 전송할 수 있는 상태로 둬야 data 키 값에 form 자체를 넣을 수 있다.
			var formData = $("#member_form").serialize(); //전부 문자열화 시킨다!!
			
			$.ajax({
				url:"/shop/member/regist",
				type:"post",
				data:formData,
				success:function(responseData){
					//서버로부터 완료 응답을 받으면 로딩바 효과를 중단!!
					$("#loader").removeClass("loader"); //class 동적 제거
					document.getElementById("overlay").style.display = "none";
					var json = JSON.parse(responseData);
					if(json.result == 1){
						alert(json.msg);
						location.href="/petshop"; //추후 로그인 페이지로 보낼예정
					}else{
						alert(json.msg);
					}
				}
			});
		}
</script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
	<%@include file="../inc/top.jsp" %>
    <!-- Header End -->

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Register</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Form Section Begin -->

    <!-- Register Section Begin -->
    <div class="register-login-section spad">
      	<div id="overlay">
 	  		<div id="loader"></div>
 	  	</div>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register-form">
                        <h2>Register</h2>
                        <form id="member_form">
                            <div class="group-input">
                                <label for="user_id">User ID *</label>
                                <input type="text" id="user_id" name="user_id">
	                            <!-- <button type="button" id="reg_submit" class="site-btn register-btn">중복체크</button> -->
                                <div id="id_check"></div>
                            </div>
                            <div class="group-input">
                                <label for="pass">Password *</label>
                                <input type="password" id="pass" name="password">
                            </div>
                            <div class="group-input">
                                <label for="con-pass">Confirm Password *</label>
                                <input type="password" id="con-pass">
                            </div>
                            <div class="group-input">
                                <label for="name">Name *</label>
                                <input type="text" id="name" name="name">
                            </div>
                            <div class="group-input">
                                <label for="phone">Phone *</label>
                                <input type="text" id="phone" name="phone">
                            </div>
                            <div class="group-input">
                                <label for="email_id">Email ID *</label>
                                <input type="text" id="email_id" name="email_id">
                                <label for="email_server">Email Server *</label>
	                            <select id="email_server" name="email_server" style="width:100%; height: 50px; border:1px solid; border-color:lightgray;">
									<option value="gmail.com">gmail.com</option>
									<option value="daum.net">daum.net</option>
									<option value="naver.com">naver.com</option>
								</select>
                            </div>
                            <div class="group-input">
                                <label for="zipCode">ZipCode *</label>
                                <input type="text" id="zipCode" name="zipcode">
                            </div>
                            <div class="group-input">
                                <label for="addr">Address *</label>
                                <input type="text" id="addr" name="addr">
                            </div>
                            <input type="button" class="site-btn register-btn" value="REGISTER">
                        </form>
                        <div class="switch-login">
                            <a href="./login.html" class="or-login">Or Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Form Section End -->
    
    <!-- Partner Logo Section Begin -->
    <div class="partner-logo">
        <div class="container">
            <div class="logo-carousel owl-carousel">
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-1.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-2.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-3.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-4.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-5.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Partner Logo Section End -->

    <!-- Footer Section Begin -->
	<%@ include file="../inc/footer.jsp" %>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
	<%@ include file="../inc/footerscript.jsp" %>
</body>

</html>