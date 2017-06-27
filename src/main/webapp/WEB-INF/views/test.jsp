<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<fieldset style="width: 300px;">
		<legend>납품자정보</legend>
			<p>1.납품자명:<input type="text" placeholder="name"></p>
			<p>2.email:<input type="email" placeholder="answs@naver.com"></p>
			<p>3.홈페이지:<input type="url" placeholder="http://"></p>
		</fieldset>
		
		<fieldset style="width: 300px;">
		<legend>납품정보</legend>
			<ul>
				<li>상품명:<select >
					<option>dog1004</option>
					<option>catchicken</option>
					<option>milk</option>
				</select> </li>
				<li>납품수량:<input type="number" placeholder="최소10이상" min="10"></li>
				<li>납품등급:<input type="range" value="6" min="0" max="10"></li>
				<li>기타사항:<textarea rows="" cols=""></textarea> </li>
			</ul>
		</fieldset>
		<p><button>send message</button></p>
	
</body>
</html>