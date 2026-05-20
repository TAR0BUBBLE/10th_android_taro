# 📋 8주차 KEYWORD 📋

## 👩🏻‍💻 LazyColumn
LazyColumn은 Compose에서 세로 방향 리스트를 구현할 때 사용하는 Lazy 레이아웃이다. 화면에 보이는 아이템을 중심으로 구성되기 때문에 많은 데이터를 효율적으로 표시할 수 있다.

<br>

## 👩🏻‍💻 LazyRow
LazyRow는 Compose에서 가로 방향 리스트를 구현할 때 사용하는 Lazy 레이아웃이다. 카테고리, 칩, 배너처럼 가로로 스크롤되는 UI를 만들 때 사용한다.

<br>

## 👩🏻‍💻 LazyListScope
LazyListScope는 LazyColumn이나 LazyRow 안에서 아이템을 추가하고 구성하기 위한 DSL 영역이다. item(), items(), itemsIndexed() 등을 사용해 리스트의 내용을 설명한다.

<br>

## 👩🏻‍💻 item()
item()은 Lazy 리스트 안에 단일 아이템을 추가할 때 사용하는 함수이다. 헤더, 푸터, 배너, 안내 문구처럼 하나만 들어가는 UI에 주로 사용한다.

<br>

## 👩🏻‍💻 items()
items()는 리스트 데이터를 기반으로 여러 개의 아이템을 추가할 때 사용하는 함수이다. 기존 RecyclerView의 Adapter에서 데이터를 바인딩하던 역할을 Compose에서는 items()로 간단히 처리할 수 있다.

<br>

## 👩🏻‍💻 itemsIndexed()
itemsIndexed()는 아이템 데이터와 함께 인덱스가 필요할 때 사용하는 함수이다. 순위 표시나 특정 위치의 아이템을 다르게 처리할 때 유용하다.

<br>

## 👩🏻‍💻 contentPadding
contentPadding은 LazyColumn이나 LazyRow의 스크롤 가능한 콘텐츠 내부에 여백을 주는 속성이다. Modifier.padding()과 달리 리스트 자체가 아니라 아이템들이 배치되는 콘텐츠 영역에 패딩이 적용된다.

<br>

## 👩🏻‍💻 Arrangement.spacedBy()
Arrangement.spacedBy()는 Lazy 리스트나 Grid에서 아이템 사이의 간격을 설정할 때 사용하는 함수이다. LazyColumn에서는 verticalArrangement, LazyRow에서는 horizontalArrangement와 함께 사용한다.

<br>

## 👩🏻‍💻 Item Key
Item Key는 Lazy 리스트에서 각 아이템을 고유하게 식별하기 위한 값이다. 아이템의 순서가 변경되거나 추가, 삭제될 때 상태가 꼬이지 않도록 안정적이고 고유한 key를 지정해야 한다.

<br>

## 👩🏻‍💻 Sticky Header
Sticky Header는 스크롤 중에도 화면 상단에 고정되는 헤더이다. 연락처 목록처럼 데이터를 그룹별로 나누어 보여줄 때 유용하게 사용된다.

<br>

## 👩🏻‍💻 LazyVerticalGrid
LazyVerticalGrid는 Compose에서 세로 방향으로 스크롤되는 격자형 리스트를 구현할 때 사용하는 Lazy 레이아웃이다. 사진 목록이나 카드형 UI를 구성할 때 사용한다.

<br>

## 👩🏻‍💻 GridCells.Fixed
GridCells.Fixed는 Grid의 열 개수를 고정할 때 사용하는 설정이다. 예를 들어 GridCells.Fixed(2)를 사용하면 화면 크기와 관계없이 항상 2열로 아이템이 배치된다.

<br>

## 👩🏻‍💻 GridCells.Adaptive
GridCells.Adaptive는 각 아이템의 최소 크기를 기준으로 화면 크기에 맞게 열 개수를 자동으로 조절하는 설정이다. 다양한 화면 크기에 대응할 때 유용하다.

<br>

## 👩🏻‍💻 LazyVerticalStaggeredGrid
LazyVerticalStaggeredGrid는 아이템마다 높이가 다른 격자형 UI를 만들 때 사용하는 Lazy 레이아웃이다. Pinterest 스타일의 이미지 목록처럼 크기가 다양한 아이템을 배치할 때 적합하다.

<br>

## 👩🏻‍💻 LazyListState
LazyListState는 Lazy 리스트의 스크롤 상태를 읽거나 제어하기 위한 상태 객체이다. firstVisibleItemIndex로 현재 보이는 아이템 위치를 확인하고, scrollToItem()이나 animateScrollToItem()으로 특정 위치로 이동할 수 있다.

<br>