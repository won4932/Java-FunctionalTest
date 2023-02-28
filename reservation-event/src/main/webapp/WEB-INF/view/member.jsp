<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Member Page</title>
    <script type="text/javascript">
    var g_webSocket = null;
    window.onload = function() {
    g_webSocket = new WebSocket("ws://localhost:8080/websocket");

    /**
     * 웹소켓 메시지(From Server) 수신하는 경우 호출
     */
    g_webSocket.onmessage = function(message) {
        addLineToChatBox(message.data);
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

    var chatBoxArea = document.getElementById("chatBoxArea");

    if (g_webSocket == null || g_webSocket.readyState == 3) {
        chatBoxArea.value += "Server is disconnected.\n";
        return false;
    }

    // 서버로 메시지 전송
    g_webSocket.send("Member to Request Approve");

    return true;
}

</script>
</head>
<body>
<%--<input id="inputMsgBox" style="width: 250px;" type="text" onkeypress="inputMsgBox_onkeypress()">--%>
<input id="sendButton" value="Approve Request" type="button" onclick="sendButton_onclick()">
<%--<input id="disconnectButton" value="Disconnect" type="button" onclick="disconnectButton_onclick()">--%>
<%--<br/>--%>
<textarea id="chatBoxArea" style="width: 100%;" rows="10" cols="50" readonly="readonly"></textarea>
</body>
</html>