# Day5

## jQuery

제이쿼리(jQuery)는 자바스크립트 언어를 간편하게 사용할 수 있도록 단순화시킨 오픈 소스 기반의 자바스크립트 라이브러리이다.

### 제이쿼리 문법

```javascript
$(선택자).동작함수();
```

달러($)기호는 제이쿼리를 의미하고, 제이쿼리에 접근할 수 있게 해주는 식별자이다.

선택자를 이용하여 원하는 HTML 요소를 선택하고, 동작 함수를 정의하여 선택된 요소에 원하는 동작을 설정할 수 있다.

### Document 객체의 ready()메소드

```javascript
$(document).ready(function() {

    제이쿼리 코드;

});
```

자바스크립트 코드는 웹 브라우저가 문서의 모든 요소를 로드한 뒤에 실행되어야 한다.

보통은 별다른 문제가 발생하지 않지만, 다음과 같은 경우에는 오류가 발생한다.

- 아직 생성되지 않은 HTML요소에 속성을 추가하려고 할 경우
- 아직 로드되지 않은 이미지의 크기를 얻으려고 할 경우

### 일반 태그의 setter/getter

```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
// 위의 src의 값은 제이쿼리를 실행하기 위해 필요한 주소이다.(필수)
<script type="text/javascript">
 /* 
     형식 : $( tag명, id, class, name ).핸들러 함수(매개변수)  
           * JQuery
           innerHTML = html(), text()
           value = val()
 
 */
 </script>
 
 <p>여기가 p 태그입니다</p>
 
 <script type="text/javascript">
 // JQuery
 let pval = $("p").html(); // getter
 
 //$("p").html("Hello <b>p</b> tag"); // setter html()은 html태그 사용이 가능하다.
 
 $("p").text("Hello p tag text"); // setter html()과 동일하게 setter의 역할은 할 수 있지만 html태그는 문자열로 인식하여 사용할 수 없다.
 
 </script>
 
<p id="demo">p tag id demo</p>
 
<h3 class="cls">h3 tag class cls</h3>

<p class="cls">p tag class cls</p>

<script type="text/javascript">


$(document).ready(function(){ // document를 받고 준비되면 function()을 실행, 문서를 다읽고 실행되기 때문에 최종적으로 실행된다.
	
	// getter
	let demo = $("#demo").html(); // 위에서 <p>의 id가 demo이기 때문에 #을 붙여준다.
	console.log(demo);
	
	// setter
	$("#demo").text("p tag 입니다"); // id가 demo인 <p>의 문자열이 "p tag 입니다"로 변경된다.
	
	$(".cls").text("cls class 값입니다"); // class가 cls인 <p>의 문자열이 "p tag 입니다"로 변경된다.
	
	//func();
	
	// JQuery
	$("p").html("p 태그입니다!!!"); // <p>태그의 문자열이 "p 태그입니다!!!"로 변경된다.
});
```



### \<button\>  jQuery 함수

```javascript
<p id="demo">p tag</p>

<button type="button" id="btn">버튼</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$("button").click(function () { // <button>이 선택자로 들어가고 버튼이 클릭되면 제이쿼리 코드를 실행한다.
	alert('click'); // 확인을 위해 'click'을 알림창으로 확인함.
});

$("#btn").click(function () { // 선택자로 id가 btn인 <button>를 클릭할 때 제이쿼리 코드 실행.
	alert('id click');
});

$("#btn").on("click", function () {
	alert('on click');
});

</script>
```



### \<button\>  jQuery setter/getter

```javascript
<input type="text" id="text">
<br><br>

<button type="button" id="btn">버튼</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$("#btn").click(function () {
	//alert('click');
	
	// getter
	let value = $("#text").val(); // id가 text인 <input>의 값을  변수 value에 가져온다. 
	alert(value); // <input>에 값을 입력하고 버튼을 클릭하면 입력한 값이 알림창에 나타난다.
	
	
	// setter
	$("#text").val("Hello JQuery"); // 버튼을 누르면 id가 text인 <input>의 입력값이 "Hello JQuery"로 바뀐다.
	
	
});

</script>
```



### 일반태그의 문자열 클릭시 setter

```javascript
<p class="cls">p tag</p>

<h2 class="cls">h2 tag</h2>

<h3 class="cls">h3 tag</h3>

<div class="cls">div tag</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	
	$(".cls").click(function () { // class가 "cls"인 모든 태그들에 대해 클릭시 실행되는 함수
		//alert('cls click');
		
		$(this).text("여기를 클릭!"); // 클릭하는 태그의 문자열이 "여기를 클릭!"으로 바뀐다.
		
	})
	
});
</script>
```



### mouseover, mouseout함수(\<table\>)

```javascript
<table border="1">
<col width="50"><col width="200"><col width="150">

<tr>
<th>번호</th><th>이름</th><th>나이</th>
</tr>

<tr class="cls">
<th>1</th><<td>홍길동</<td><td>24</<td>
</tr>

<tr class="cls">
<th>2</th><<td>성춘향</<td><td>16</<td>
</tr>

<tr class="cls">
<th>3</th><<td>일지매</<td><td>22</<td>
</tr>

</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	
	$("tr.cls").mouseover(function () { // mouseover()함수, class가 "cls"인 <tr>에 마우스 커서를 올려놓으면 함수가 실행 
		$(this).css("background", "#00ff00"); // 올려놓은 해당되는 <tr>의 행의 background가 초록색으로 바뀐다.
	});
	
	$("tr.cls").mouseout(function () { // mouseover()함수, class가 "cls"인 <tr>에서 마우스 커서가 벗어나면 함수가 실행
		$(this).css("background", "#ffffff"); // <tr>의 행의 background가 다시 흰색으로 바뀐다.
	})
	
});
</script>
```



### \<button\>클릭을 통한 attribute(속성) 추가

```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style type="text/css">
.back{
    background-color: blue;
    color: #ffff00;
}

#demo{
    text-align: center;
}


</style>

</head>
<body>

<p>p tag</p>

<button type="button">버튼</button>

<script type="text/javascript">
$(document).ready(function () {
	
	$("button").click(function () {
		
		// attribute(속성) 추가
		
		// setter
		//$("p").css("background", "#ff0000"); // <p>에 #ff0000색상의 background특성을 추가한다.
		//          property명    property값
/*		$("p").css({"background":"#00ff00", "color":"#ffffff"}); 
         // <p>에 #ff0000색상의 background특성과 #ffffff색상의 color특성을 추가한다.
		$("p").text("여기가 p tag입니다");
		
		// getter
		let color = $("p").css("backgroundColor");
		//alert(color);
*/		
		$("p").attr("id", "demo"); //  버튼을 클릭시 <p>에 id명이 "demo"인 id속성을 추가한다. 
		
		let ptext = $("p").attr("id"); // <p> id속성의 속성값인 "demo"를 변수 ptext에 넣는다 
		//alert(ptext); // 알림창으로 <p>의 id속성값 "demo"를 가진 변수 ptext가 출력된다.
		
		$("p").attr("class", "back"); // 버튼을 클릭시 <p>에 class명이 "back"인 class속성을 추가한다.
		
		// html(), text(), val(), css(), attr(), prop()
		
	});
});
</script>
```



### radio, checkbox getter/setter

```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- radio -->
<ul>
    <li><input type="radio" name="radio_test" value="apple" checked="checked">사과</li> 
    <li><input type="radio" name="radio_test" value="pear">배</li> 
    <li><input type="radio" name="radio_test" value="banana">바나나</li> 
</ul>

<button type="button" id="choice">선택</button>
<script type="text/javascript">
$(function () {
	
	$("#choice").click(function () { // id가 choice인 <button>이 클릭되었을 때 함수 실행
		// getter
	//	let rVal = $("input[name='radio_test']:checked").val(); // <input>태그의 id나class가 없고 name일때
        // 체크된 name이 radio_test인 <input>의 value값을 변수 rVal에 넣는다.
	//	alert(rVal); // 변수 rVal의 value값이 알림창에 출력된다.
		
		// setter
		$("input[name='radio_test']").val(["banana"]); //value값이 banana이고 name이 radio_test인 <input>으로 체크됨
		
	});
	
});

</script>

<br><br>
<!-- checkbox -->

<input type="checkbox" id="ch" checked="checked">그림그리기
<br><br>
<button type="button" id="btn">체크</button> 

<script type="text/javascript">
$("#btn").click(function () { // id가 btn인 <button>이 클릭되었을 때 함수 실행
	
	// getter
	let check = $("#ch").is(":checked"); 
    // id가 ch인 <input>의 checked의 속성이 체크되면 true값을, 체크 x라면 false값을 변수 check에 넣는다.
//	let check = $("input:checkbox[id='ch']").is(":checked");
	alert(check); // 체크가 되어있다면 true를 체크가 안되어있다면 false를 알림창에 출력한다.
	
	// setter
	$("#ch").prop("checked", true); // 버튼을 누르면 체크가 되어진다.
	
	
});

</script>
```



### \<button\>을 사용하여 jQuery getter/setter(html 생성)

```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div id="demo"></div>

<button type="button">태그 추가</button>

<script type="text/javascript">
$(function () {
	
	$("button").click(function () {
		
		// html(text) 추가
//		let txt = "<p><b>html p tag Append</b></p>";
//		$("#demo").append(txt);
		
		// JavaScript 추가
//		let element = document.createElement("h3");
//		element.innerHTML = "JS h3 tag append";  // <h3>JS h3 tag append</h3>
//		$("#demo").append(element);
		
		// JQuery 추가
		let element = $("<p></p>").html("JQuery p tag append"); 
         // 문자열이 "JQuery p tag append"인 <p>태그를 변수 element에 넣는다.
		$("#demo").append(element); // id가 demo인 <div>에 문자열이 "JQuery p tag append"인 <p>를 추가한다.
	});
});
</script>
```



### Datepicker(달력에서 날짜 얻기)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!-- DatePicker UI를 사용하기 위해 https://jqueryui.com/datepicker/에서 링크를 받아옴 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- DatePicker UI를 사용하기 위해 https://jqueryui.com/datepicker/에서 코드를받아옴 -->

</head>
<body>

<h1>DatePicker</h1>

<p>선택일:<input type="text" id="date"></p>

연도:<input type="text" id="year"><br>
월:<input type="text" id="month"><br>
일:<input type="text" id="day"><br>
요일:<input type="text" id="week"><br>

<script type="text/javascript">
$(document).ready(function () {
	
	let week = [ '일', '월', '화', '수', '목', '금', '토'];
	
	$("#date").datepicker({
		dateFormat: "yy/mm/dd",
		dayNamesMin: week,
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		onSelect: function (d) {
		//	alert(d);
		
		    let arr = d.split("/");
		    
		    $("#year").val(arr[0].trim());
		    $("#month").val(arr[1]);
		    $("#day").val(arr[2]);
		    
		    let weekday = new Date($("#date").datepicker({ dateFormat: "yy/mm/dd"}).val());
		    alert(weekday.getDay()); // 0 ~ 6 일 ~ 토
		    
		    $("#week").val(week[weekday.getDay()]);
		}
	});
});
</script>
</body>
</html>
```

