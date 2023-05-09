function registerCheck() {
    if ($("#memberName").val() === "") {
        alert("이름을 입력해주세요.");
        $("#memberName").focus();
        return false;
    }

    if ($("#memberId").val() === "") {
        alert("아이디를 입력해주세요.");
        $("#memberId").focus();
        return false;
    }

    if ($("#memberPw").val() !== $("#check").val()) {
        alert("비밀번호가 일치하지 않습니다.");
        $("#memberPw").focus();
        return false;
    }

    if ($("#agreement").prop("checked") === false) {
        alert("개인정보 수집 및 이용에 동의해주세요.");
        return false;
    }

    return true;
}

function fn_idChk() {
    const email = $("#memberMail").val(); // 이메일 입력 필드 ID 확인
    if (!email) {
        alert("이메일을 입력해주세요.");
        return;
    }

    $.ajax({
        url: "/member/idChk", // 서버의 이메일 중복 체크 API
        type: "POST",
        contentType: "application/json; charset=utf-8", // JSON 요청 형식
        dataType: "json", // 서버 응답 형식
        data: JSON.stringify({ email }), // JSON 형식으로 데이터 전송
        success: function(data) {
            if (data === 1) {
                alert("중복된 이메일입니다.");
            } else if (data === 0) {
                alert("사용 가능한 이메일입니다.");
            }
        },
        error: function(xhr, status, error) {
            console.error("AJAX Error: ", status, error);
            alert("서버와의 통신에 실패했습니다.");
        }
    });
}


$('.mb_check').on('focusout', function() {
    const pwd1 = $("#memberPw").val();
    const pwd2 = $("#check").val();

    if (pwd1 === pwd2) {
        $("#checkPw").text("비밀번호가 일치합니다.").css("color", "green");
    } else {
        $("#checkPw").text("비밀번호가 일치하지 않습니다.").css("color", "red");
    }
});