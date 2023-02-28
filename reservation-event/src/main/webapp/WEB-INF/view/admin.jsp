<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>웹소켓 테스트 페이지</title>
    <script type="text/javascript">
var g_webSocket = null;
window.onload = function() {
    g_webSocket = new WebSocket("ws://localhost:8080/websocket");


    /**
     * 웹소켓 사용자 연결 성립하는 경우 호출
     */
    // g_webSocket.onopen = function(message) {
    //     addLineToChatBox("Server is connected.");
    // };


    /**
     * 웹소켓 메시지(From Server) 수신하는 경우 호출
     */
    g_webSocket.onmessage = function(message) {
        addLineToChatBox(message.data);
    };

    /**
     * 웹소켓 사용자 연결 해제하는 경우 호출
     */
    g_webSocket.onclose = function(message) {
        addLineToChatBox("Server is disconnected.");
    };

    /**
     * 웹소켓 에러 발생하는 경우 호출
     */
    g_webSocket.onerror = function(message) {
        addLineToChatBox("Error!");
    };
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
* Send 버튼 클릭하는 경우 호출 (서버로 메시지 전송)
*/
function sendButton_onclick() {
    var inputMsgBox = document.getElementById("inputMsgBox");
    if (inputMsgBox == null || inputMsgBox.value == null || inputMsgBox.value.length == 0) {
        return false;
    }

    var chatBoxArea = document.getElementById("chatBoxArea");

    if (g_webSocket == null || g_webSocket.readyState == 3) {
        chatBoxArea.value += "Server is disconnected.\n";
        return false;
    }

    // 서버로 메시지 전송
    g_webSocket.send(inputMsgBox.value);
    inputMsgBox.value = "";
    inputMsgBox.focus();

    return true;
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

// function approve() {
//     g_webSocket.send("test");
//
//     return true;
// }

function approve() {

    if(g_webSocket == null | g_webSocket == 3){
        return false;
    }

    var checkSize = document.getElementsByName("member").length;

    var memeberList = [];

    for(var i = 0; i<checkSize; i++) {
        if(document.getElementsByName("member")[i].checked == true) {
            g_webSocket.send(document.getElementsByName("member")[i].value);
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