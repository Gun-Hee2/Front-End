# Day2

## input

* text

디폴트 값. 한줄의 텍스트 필드이다. 새줄 문자는 입력값으로 부터 자동으로 제거된다.

```html
<input type="text" name="text" value="" placeholder="아이디입력"> <!-- placeholder는 양식 컨트롤에 입력된다.-->
<input type="text" name="pwd" value="">
```

name은 input양식 컨트롤의 이름, 이름/값 짝(name/value pair)의 일부로서 양식과 함께 전송된다.

value는 양식 컨트롤의 현재 값, 이름/값 짝(name/value pair)의 일부로서 양식과 함께 전송된다.

* file

파일을 지정할 수 있는 컨트롤. 보통 자료실 같은곳에서 자주 사용된다.

```html
<input type="file" name="file">
```

* checkbox

단일 값을 선택하거나 선택 해제할 수 있는 체크박스이다.

```html
<input type="checkbox" name="checkbox" value="checkbox">독서
```

* radio

같은 name값을 가진 여러개의 선택 중에서 하나의 값을 선택하게 하는 라디오 버튼이다.

```html
<input type="radio" name="radio" value="" checked="checked">볼보<br>
<input type="radio" name="radio" value="">아우디<br>
```

checked는 홈페이지를 처음 봤을때 이미 해당되는 버튼으로 선택되어 있게 만든다.

* button

기본 행동을 가지지 않으며 value를 레이블로 사용하는 푸쉬 버튼이다.

```html
<input type="button" value="button">
```

* reset

양식의 내용을 디폴트값(기본값)으로 초기화 하는 버튼이다.

```html
<input type="reset" value="reset">
```

* submit

양식을 전송하는 버튼

```html
<input type="submit" value="submit">
```

* image

src 특성에 지정한 이미지로 나타나는 시각적 제출 버튼.

이미지의 src를 누락한 경우 alt특성의 텍스트를 대신 보여줍니다.

```html
<input type="image" src="[이미지의 src]">
```

위의 유형들을 웹페이지에서 살펴보면 다음과 같다.

![image-20210923193304296](https://user-images.githubusercontent.com/87796075/134800209-0d55c5e6-1a1d-406f-b529-458523f768be.png)

## select

\<select\>요소는 옵션 메뉴를 제공하는 컨트롤을 나타낸다.

```html
<select>
<optgroup label="HTML5">  <!-- 옵션의 태그를 지정가능 -->
<option>Multimedia Tag</option>
<option>Connectivity</option>
<option>Device Access</option>
</optgroup>
    
<optgroup label="CSS">
<option>Animation</option>
<option>3D transform</option>
</optgroup>
</select>    
```

위의 코드는 일반적인 \<select\> 사용법이며, label을 통해 옵션의 태그를 지정할 수 있다.

메뉴의 각 옵션은 \<select\> 안에 있는 \<option\> 으로 정의한다.

\<optiongroup\> 요소를 사용하여 옵션을 두개의 분리된 그룹으로 나눌 수 있다.

![image-20210923200554129](https://user-images.githubusercontent.com/87796075/134800225-958166c1-9d2c-47bb-b4d1-790397de51e7.png)

## textarea

\<textarea\> 요소는 멀티라인 일반 텍스트 편집 컨트롤을 나타낸다.

```html
<textarea rows="10" cols="30">
여기에 입력...
</textarea>
```

![image-20210923201033206](https://user-images.githubusercontent.com/87796075/134800254-9fe1c567-c233-411e-864b-575fff14d898.png)

## CSS

CSS는 Cascading Style Sheet의 줄임말로, 문장의 컬러, 종류, 형태등을 지정할 수 있고, 테두리를 넣거나 각종 종류별 tag에 이미지 형태의 라인을 적용할 수 있다.

방식으로는 internal방식, external방식, inline방식이 있다.

### internal

HTML파일 내부 \<head\> 태그 안에 있는 \<style\>  태그를 이용하여 사용을 한다.

```html
<body>
<p id=idcss>애플이 2024년 접는(폴더블) 아이폰을 출시할 것이라는 전망이 나왔다.</p>

<h3 id=idcss>애플이 폴더블 아이폰을 내놓을 것이라는 예상은 지속적으로 제기되고 있다.</h3>

<p class="classcss">애플은 LG디스플레이와 폴더블 아이폰에 적용할 디스플레이를 개발 중인 것으로 알려졌다.</p>

<h3 class="classcss">크기는 7.5인치 내외로 안으로 접는 ‘인폴딩’ 방식이다.</h3>
</body>    
```

 위와 같이 \<body\> 안에 다음과 같은 코드가 있다고 할 때, \<head\> 안에 다음과 같이 internal방식을 사용한다.

```html
<!-- internal방식 -->
<style type="text/css">
h1{
color:red; /* color를 property*/
}
p{
color:#0000ff;
}

#idcss{  /* id는 #으로 */
font-size: 150%;
background-color: yellow;
color: green;

}

.classcss{  /* class는 .으로 */
background-color: red;
border: 1px solid;
}

</style>
```

### external

HTML파일 외부에 .css파일을 작성하고 link를 적용하는 방식이다.

\<head\> 태그 안에 있는 \<link\> 태그를 이용하여 .css파일을 적용한다.

```html
<head>
<!-- external 방식 -->
<link href="style.css" rel="stylesheet">
</head>

<body>
<p id=idcss>애플이 2024년 접는(폴더블) 아이폰을 출시할 것이라는 전망이 나왔다.</p>

<h3 id=idcss>애플이 폴더블 아이폰을 내놓을 것이라는 예상은 지속적으로 제기되고 있다.</h3>

<p class="classcss">애플은 LG디스플레이와 폴더블 아이폰에 적용할 디스플레이를 개발 중인 것으로 알려졌다.</p>

<h3 class="classcss">크기는 7.5인치 내외로 안으로 접는 ‘인폴딩’ 방식이다.</h3>
</body>    
```

위와 같이 HTML파일에 다음과 같은 코드가 있다고 할 때, HTML파일 외부에 다음과 같이 .css파일을 생성하여 exteranl방식을 사용한다.

```css
/* style.css */
@charset "UTF-8";

#idcss{  /* id는 #으로 */
font-size: 150%;
background-color: yellow;
color: green;
}

.classcss{  /* class는 .으로 */
background-color: red;
border: 1px solid;
}
```

### inline

적용하고자 하는 태그안에 style요소를 이용하여 CSS를 적용하는 방식이다.

```css
<!-- inline방식 -->
<p style="background-color: #0000ff; color: #ffff00">애플이 폴더블 아이폰을 내놓을 것이라는 예상은 지속적으로 제기되고 있다.</p>
```

