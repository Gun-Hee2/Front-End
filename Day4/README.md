# Day4

## XML

XML은 EXtensible Markup Language의 약자이며, XML은 HTML과 매우 비슷한 문자 기반의 마크업 언어(text-based markup language)이다.

사용하는 목적은 첫번째로 Data(공공의 데이터)를 공유하기 위한 목적이 있으며, 두번째로는 Setup을 하기 위한 목적이 있다.

XML의 형식은 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<고객들>
	<고객>
		<번호>1</번호>
		<이름>홍길동</이름>
		<주소>서울시</주소>
		<방문>2020/03/23</방문>
	</고객>
	<고객>
		<번호>2</번호>
		<이름>성춘향</이름>
		<주소>남원시</주소>
		<방문>2021/01/31</방문>
	</고객>
	<고객>
		<번호>3</번호>
		<이름>일지매</이름>
		<주소>부산시</주소>
		<방문>2019/07/11</방문>
	</고객>
</고객들>
```



### 자바스크립트를 이용한   XML 파싱

```javascript
<script type="text/javascript">
let xmltest = "<bookstore>" +   /* root 태그 */
                "<book>" +      /* node */
                  "<title>탈무드</title>" + /* childNode */
                  "<author>man</author>" +
                  "<year>2001</year>" +
                "</book>" + 
                "<book>" +      /* node */
                  "<title>이솝이야기</title>" +
                  "<author>woman</author>" +
                  "<year>2004</year>" +
                "</book>"
              "</bookstore>"; 
              
//alert(xmltest);           

let parser, xmlDoc;

parser = new DOMParser(); //DOMParser()는 DOM Document 문서에 맞는 XML 및 HTML 소스 코드를 해석할 수 있는 기반을 제공한다 .
xmlDoc = parser.parseFromString(xmltest, "text/html"); // 위에있는 xmltest의 문자열들을 xml파일로 바꿔주는 메소드이다
                            //  document,  mimeType인자
//alert(xmlDoc);

document.getElementById("demo").innerHTML 
//    = xmlDoc.getElementsByTagName("book")[0].childNodes[0].nodeName;   // 제목이 탈무드인 부분의 첫번째 태그 이름 
//    = xmlDoc.getElementsByTagName("book")[0].childNodes[1].nodeName;   // author

//    = xmlDoc.getElementsByTagName("book")[0].childNodes[0].childNodes[0].nodeValue; // 탈무드
//    = xmlDoc.getElementsByTagName("book").length; //2
    = xmlDoc.getElementsByTagName("book")[0].childNodes.length; //3
</script>
```



## JSON

JSON은 자바스크립트의 객체 표기법으로부터 파생된 부분 집합이다.

따라서 JSON 데이터는 다음과 같은 자바스크립트 객체 표기법에 따른 구조로 구성됩니다.

ex )

```json
[
	{
		"name":"정수동", // JSON
		"age":23,
		"address":"서울시",
		"height":181.1	
	},
	{
		"name":"심청이",
		"age":14,
		"address":"강원시",
		"height":165.3	
	},
	{
		"name":"향단이",
		"age":16,
		"address":"남원시",
		"height":157.9	
	},
	{
		"name":"이몽룡",
		"age":18,
		"address":"공주시",
		"height":173.7	
	}
]

```



### 자바스크립트를 이용한 JSON 파싱

```javascript
<script type="text/javascript">
let jsonData = [
	              {
	            	  "name":"홍길동",
	            	  "age":24,
	              },
	              {
	            	  "name":"성춘향",
	            	  "age":16,
	              }
	           
                ];
                
document.getElementById("demo").innerHTML = jsonData[1].name + " " + jsonData[1].age;  // 성춘향 16

let arrText = '{ "name":"홍길동", "age":24, "주소":"서울시" }';
//alert(arrText);

// String -> Json Object
let jsonObj = JSON.parse(arrText);
alert(jsonObj); // [object Object]

//Json Object -> String
let str = JSON.stringify(jsonObj);
alert(str); // {"name":"홍길동","age":24,"주소":"서울시"}

document.getElementById("demo").innerHTML = jsonObj.name + " " + jsonObj.age + " " + jsonObj.주소;// 홍길동 24 서울시
</script>
```

위에 나와 있던 JSON 데이터를 토대로 파싱을 하려면 다음과 같다.

```javascript
<script type="text/javascript">

let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function () {
	if(xhttp.readyState == 4 && xhttp.status == 200){ 
   /*
   readyState: 진행상태(순서)                 status 성공여부
   0번 -> open 메소드를 수행하기 전상태        200 -> success
   1번 -> loading 중...                      403 -> 접근 금지
   2번 -> loading 완료                       404 -> 없음, 못찾음
   3번 -> Server 처리중...                   500 -> 구문(문법) 에러
   4번 -> Server 처리 완료
   */
		jsonFunc(this);
	}
}
xhttp.open("GET", "data.json", true); // ("방식", "파일(경로)", 비동기처리)
xhttp.send();

function jsonFunc(xhttp) {
//	alert(xhttp.responseText);
	
	let str = xhttp.responseText;
	
	let json = JSON.parse(str);
//	alert(json);
//	alert(json.length); // 4

/*   
    console.log(json[0].name);  // 정수동
    console.log(json[0].age);   // 23
    console.log(json[0].address);  // 서울시
    console.log(json[0].height);   // 181.1
*/
    
    let txt = "";
    for(i = 0; i < json.length; i++){ //json.length == 4
    	txt += json[i].name + " " +   // 이름
    	        json[i].age + " " +   // 나이
    	        json[i].address + " " +   // 주소
    	        json[i].height + "<br>" ; // 키
    }
    
    document.getElementById("demo").innerHTML = txt; // 정수동 23 서울시 181.1
                                                     // 심청이 14 강원시 165.3
                                                     // 향단이 16 남원시 157.9
                                                     // 이몽룡 18 공주시 173.7
}
</script>
```

