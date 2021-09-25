# Day3

## Java Script

자바스크립트는 객체 기반의 스크립트 언어이다.

HTML로는 웹의 내용을 작성하고, CSS로는 웹을 디자인한다면, 자바스크립트로는 웹의 동작을 구현할 수 있다.

자바스크립트는 주로 웹 브라우저에서 사용되나, Node.js와 같은 프레임워크를 사용하면 서버 측 프로그래밍에서도 사용할 수 있다.

### console.log()

console.log()메소드는 웹 브라우저의 콘솔을 통해 데이터를 출력해 준다.

대부분의 주요 웹 브라우저에서는 F12를 누른 후 메뉴에서 콘솔을 클릭하면 콘솔 화면을 사용할 수 있다.

디버깅하는데 많은 도움을 준다.

```html
<!-- ex) -->
<p>F12를 눌러서 콘솔 화면을 열면 결과를 확인할 수 있습니다.</p>
<script type="text/javascript">
// 여기가 JS영역이다.
console.log('Java Script가 실행되었음')
 
</script>
```

위와 같은 코드를 실행 시켜주면 다음과 같은 결과를 웹 브라우저를 통해 확인할 수 있다.

![img](../../Users/alg75/OneDrive/%EB%B0%94%ED%83%95%20%ED%99%94%EB%A9%B4/%EA%B1%B4%ED%9D%AC/images/img.png)

### Variable(변수)

자바 스크립트의 변수 선언은 var로만 가능했으나, ES6부터 let과 const가 추가 되었다.

var은 const와 let과는 다르게 중복 선언이 된다.

```javascript
// 첫번째 변수 선언+초기화 
var a = 10; 
console.log(a); // 10 
// 두번째 변수 선언+초기화 
var a = 20; 
console.log(a); // 20 
// 세번째 변수 선언(초기화X) 
var a; 
console.log(a); // 20
```

이는 기존의 Java나 Python같은 언어에 익숙한 경우는 의아해 할 수 있다.

따라서 기존에 선언해둔 변수의 존재를 잊고, 값을 재할당하게 되는 등의 실수를 범할 수 있다.

이러한 점들 때문에, 중복선언이 불가능한 let을 많이 쓰는 추세이다.

또한, let은 var과 더불어서 값의 재할당이 가능하다.

```javascript
var a = 10; 
a = 20; 
console.log(a); // 20 

let b = 111; 
b = 222; 
console.log(b); // 222
```

### Object(객체)

자바스크립트에서 원시 타입을 제외한 모든 데이터 타입(객체, 함수, 배열, 정규표현식 등)은 객체다

객체는 여러가지 값을 가질 수 있으며, 함수도 가질 수 있다.

객체가 보유한 값을 '프로퍼티'라고 하며, 객체가 보유한 함수를 '메소드'라고 한다.(둘다 프로퍼티라고 하기도 한다.)

객체의 프로퍼티와 메소드들은 '키값'으로 구분된다.

### 객체 생성 방식

* 객체 리터럴 방식

**var obj = { key: value, ... }**

```javascript
let obj = {
		   firstname: '길동',  // key:value -> java의 hashmap과 유사 
		   lastname: '홍',
		   age:24,
		   func:function(){
			   console.log("func 함수호출")
			   console.log(this.lastname + this.firstname); // 홍길동
		   },
		   method:function(a, b){
			   this.age = a;
		   }	   
   }
```

* 생성자 방식

**new 사용자 정의 생성자()**

```javascript
   class Person{
	   constructor(name, age){
		   this.name = name; // this는 자신이 속한 객체를 참조하는 '자기 참조 변수'다.
		   this.age = age;
	   }
	   
	   allprint(){
		   console.log(this.name + " " + this.age);
	   }
   }
   
   let pobj = new Person('홍길동', 22);
   console.log(pobj.name); // 홍길동
   console.log(pobj.age); // 22
   console.log(pobj.allprint()); // 홍길동 22
```

### 프로퍼티/메소드 접근 방법

```javascript
let myObj = { 
    name: '홍길동', 
    age: 25, 
    hello: function(){ 
        return `이름은 ${this.name}이고, 나이는 ${this.age}입니다.`; 
    } 
}; 
```

위와 같이 myobj객체를 생성해줬다.

* 객체.key

마침표(Dot Notation)로 프로퍼티에 접근한다.

```javascript
myObj.name; // '홍길동' 
myObj.age; // 25 
myObj.hello(); // '이름은 홍길동이고, 나이는 25입니다.' 메소드(함수)는 마지막에 괄호를 꼭 붙여서 호출해야한다.
```

* 객체['key']

대괄호[] 사이에 키값을 '문자열'로 넣어서 접근한다.

```javascript
myObj['name']; // '홍길동' 
myObj['age']; // 25 
myObj['hello'](); // '이름은 홍길동이고, 나이는 25입니다.'  메소드(함수)는 마지막에 괄호를 꼭 붙여서 호출해야한다.
```

### getter/setter

* gettter

**document.getElementById("아이디명").innerHTML**

**document.getElementById("아이디명").value**

innerHTML: 문자열 등을 출력하는 태그의 값을 가져올 때 사용

value: input 태그 등 입력값이 있는 태그의 값을 가져올 때 사용

ex )

다음과 같이 HTML코드가 있을 때,

```html
<p id="demo">p 태그입니다</p>
```

아래와 같이 getter를 사용할 수 있다.

```javascript
let v = document.getElementById("demo").innerHTML;  // getter
```

아이디가 "demo"인 \<p\>태그의 문자열 값인 "p 태그입니다"를 변수 v에 가져올 수 있다. 

* setter

**document.getElementById("아이디명").innerHTML = "수정"**

ex )

setter는 다음과 같이 사용할 수 있다.

```javascript
document.getElementById("demo").innerHTML = "p tag id demo"; // setter
```

아이디가 "demo"인 \<p\>태그의 기존 문자열 값인 "p 태그입니다"를 "p tag id demo"로 수정할 수 있다.

### 날짜/시간 설정

* 현재 날짜, 시간 설정

```
<p id="demo"></p>

<script type="text/javascript">
function displayDate() {
	document.getElementById("demo").innerHTML = Date();
}

//displayDate(); // 현재날짜와 시간을 알려준다. // ex) Sat Sep 25 2021 18:56:14 GMT+0900 (한국 표준시)

//setInterval("displayDate()", 1000); // 시간이 1초씩 증가한다.


</script>
```

* 원하는 날짜, 시간 설정

```
<p id="date"></p>
<script type="text/javascript">
let date = new Date(); // 현재 날짜 시간

// setter
//date = new Date(2021, 12 - 1, 3, 6, 25, 10, 0);
date = new Date("October 12, 2021 12:35:35");  // 2021/10/12

document.getElementById("date").innerHTML = date;

*원하는 날짜, 시간의 데이터 값*
/* document.getElementById("date").innerHTML = date.getDay(); // 요일(0(일요일) ~ 6(토요일))
document.getElementById("date").innerHTML = date.getFullYear(); // 년도
document.getElementById("date").innerHTML = date.getMonth() + 1; // 월
document.getElementById("date").innerHTML = date.getDate(); // 날짜
document.getElementById("date").innerHTML = date.getHours(); // 시
document.getElementById("date").innerHTML = date.getMinutes(); // 분
document.getElementById("date").innerHTML = date.getSeconds(); // 초 */

</script>
```

