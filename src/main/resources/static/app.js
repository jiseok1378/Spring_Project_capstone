var stompClient = null;
//var isRun = false;

if(userId!=null){
	connect();
}

//function notClick(){
//	if(isRun == true){
//		console.log("끝");
//		return;
//	}
//
//	isRun = true;
//	location.href = '/chat/idMake';
//}

function connect() {
	var socket = new SockJS('/websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		console.log('Connected: ' + frame);
		if(sender > 100){
		LoadingWithMask();}
		// topic 뒤에 식별번호 sender (보내는 사람)
		stompClient.subscribe('/topic/'+ sender, function (chatLog) {
			//보낼때말고 받을 때도 시간필요
			d = serverToday();
			time = moment(d).format('h:mm a | MMMM DD');
			showChat(JSON.parse(chatLog.body));
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	console.log("Disconnected");
}

/* Chat과 관련된 메서드 추가 */
function sendChat() {
	// /app/hello로 JSON 파라미터를 메세지 body로 전송.
	d = serverToday();
	time = moment(d).format('h:mm a | MMMM DD');
	data = {'userId':receiver, 'conId':sender,/*'receiver':receiver,'sender':sender,*/'sendTime':d,'content':$("#Q").val(),'who':who};
	stompClient.send("/app/chat/send", {}, JSON.stringify(data));
	showMe(); 
}
function sendBye() {
	d = serverToday();
	time = moment(d).format('h:mm a | MMMM DD');
	data = {'content':'사용자가 채팅을 종료하였습니다.'};
	stompClient.send("/app/chat/send", {}, JSON.stringify(data));
}
function showChat(chatLog) {
	receiver = chatLog.conId;/*parseInt(chatLog.conId);*/
	if(receiver<100){
		closeLoadingWithMask();
	}
	$("#QnA").append("<div class='received-chats'>"
			+ "<div class='received-chats-img'>"
			+ "<img src='user.jpg'>"
			+ "</div>"
			+ "<div class='received-msg'>"
			+ "<div class='received-msg-inbox'>"
			+ "<p>"
			+ chatLog.content
			+ "</p>"
			+ "<span class='time'>"+ time +"</span>"
			+ "</div>" + "</div>"
			+ "</div>");
}
function showMe() {
	$('#QnA').append(
			"<div class='outgoing-chats'>"
			+ "<div class='outgoing-chats-msg'>"
			+ "<p>" + $('#Q').val() + "</p>"
			+ "<span class='time'>" + time
			+ "</span>" + "</div>"
			+ "<div class='outgoing-chats-img'>"
			+ "<img src='AI_img.jpg'>"
			+ "</div></div>")
}

$(function () {
//	$("form").on('submit', function (e) {
//		e.preventDefault();
//	});
	$( "#help" ).click(function(e) {
		if(userId!=null){
			e.preventDefault();}
	});
	$( "#back" ).click(function(e) { 
		$( "#help" ).unbind();
		sendBye();
		disconnect();});
	$( "#chatSend" ).click(function(){ 
		if($('#Q').val().trim()==""){
			alert("입력해주세요"); return;
			} 
		sendChat(); $('#Q').val(""); });
});