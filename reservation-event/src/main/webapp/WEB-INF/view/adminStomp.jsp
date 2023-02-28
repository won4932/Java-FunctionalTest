<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>웹소켓 테스트 페이지</title>
    <script type="text/javascript">
var g_webSocket = null;
window.onload = function() {
    // g_webSocket = new WebSocket("ws://localhost:8080/websocket");

    var sockJs = new SockJS("/ws-websocket")

    var stomp = Stomp.over(sockJs);

    stomp.connect({}, function () {
        console.log("STOMP Conection");
    })
}

/**
* 채팅 박스영역에 내용 한 줄 추가
*/
function addLineToChatBox(_line) {
    if (_line == null) {
        _line = "";
    }

    var chatBoxArea = document.getElementById("chatBoxArea");
    chatBoxArea.value += _line + "\n";
    chatBoxArea.scrollTop = chatBoxArea.scrollHeight;
}

/**
* Disconnect 버튼 클릭하는 경우 호출
*/
// function disconnectButton_onclick() {
//     if (g_webSocket != null) {
//         g_webSocket.close();
//     }
// }

/**
* inputMsgBox 키입력하는 경우 호출
*/
function inputMsgBox_onkeypress() {
    if (event == null) {
        return false;
    }

    // 엔터키 누를 경우 서버로 메시지 전송
    var keyCode = event.keyCode || event.which;
    if (keyCode == 13) {
        sendButton_onclick();
    }
}

function approve() {
    var checkSize = document.getElementsByName("member").length;

    for(var i = 0; i<checkSize; i++) {
        if(document.getElementsByName("member")[i].checked == true) {
            // g_webSocket.send(document.getElementsByName("member")[i].value);

            stomp.send('/publish/message', {}, JSON.stringify({type: 'test'
                , sender: 'admin'
                , receiver: document.getElementsByName("member")[i].value
                , roles: 'MEMBER'
                , data: document.getElementsByName("member")[i].value + 'Approve Complete!'}))
        }
    }
}
</script>
</head>
<body>
<%--<form method="POST" onsubmit="approve()">--%>
<%--    <input type="checkbox" name="admin"><br>--%>
<%--    <input type="checkbox" name="member1"><br>--%>
<%--    <input type="checkbox" name="member2"><br>--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<input type="checkbox" name="member" value="member1"> Member 1 Approve Request
<br>
<input type="checkbox" name="member" value="member2"> Member 2 Approve Request
<br>
<input type="checkbox" name="member" value="member3"> Member 3 Approve Request


<%--<input id="sendButton" value="Approve" type="button" onclick="sendButton_onclick()">--%>
<br>
<input id="sendButton" value="Approve" type="button" onclick="approve()">
<textarea id="chatBoxArea" style="width: 100%;" rows="10" cols="50" readonly="readonly"></textarea>
<br/>
</body>
</html>