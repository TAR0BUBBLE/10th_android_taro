# 📋 9주차 KEYWORD 📋

## 👩🏻‍💻 Side Effect

Side Effect는 Composable이 UI를 그리는 것 외에 외부 상태나 앱 동작에 영향을 주는 작업이다.
네트워크 요청, 타이머 실행, 로그 전송, 리스너 등록 등이 Side Effect에 해당한다.

<br>

## 👩🏻‍💻 Recomposition

Recomposition은 Compose에서 상태가 변경되었을 때 Composable 함수가 다시 실행되어 UI를 갱신하는 과정이다.
Composable 함수는 여러 번 다시 실행될 수 있기 때문에, 함수 본문에 네트워크 요청 같은 작업을 직접 작성하면 안 된다.

<br>

## 👩🏻‍💻 LaunchedEffect

LaunchedEffect는 Composable이 Composition에 들어왔을 때 코루틴을 실행하는 Side Effect API이다.
지정한 key가 변경되면 기존 코루틴을 취소하고 다시 실행한다.

<br>

## 👩🏻‍💻 Effect Key

Effect Key는 LaunchedEffect나 DisposableEffect가 다시 실행될 기준이 되는 값이다.
key가 바뀌면 기존 Effect가 취소되거나 정리되고 새로운 Effect가 실행된다.

<br>

## 👩🏻‍💻 DisposableEffect

DisposableEffect는 리스너, Observer, 브로드캐스트 수신기처럼 등록 후 해제가 필요한 작업에 사용하는 Side Effect API이다.
Composable이 사라지거나 key가 변경될 때 `onDispose` 블록이 실행된다.

<br>

## 👩🏻‍💻 onDispose

onDispose는 DisposableEffect가 종료될 때 실행되는 정리 블록이다.
리스너 해제, Observer 제거, 구독 취소처럼 반드시 정리해야 하는 코드를 작성한다.

<br>

## 👩🏻‍💻 SideEffect

SideEffect는 성공적인 Recomposition 이후 실행되는 API이다.
Compose 상태를 Analytics, 외부 SDK, 비Compose 객체와 동기화할 때 사용한다.

<br>

## 👩🏻‍💻 rememberCoroutineScope

rememberCoroutineScope는 Composable의 생명주기에 연결된 CoroutineScope를 생성하는 API이다.
버튼 클릭, 탭 클릭, 바텀시트 닫기처럼 사용자 이벤트 안에서 suspend 함수를 실행할 때 사용한다.

<br>

## 👩🏻‍💻 HorizontalPager

HorizontalPager는 여러 페이지를 가로 방향으로 스와이프할 수 있게 해주는 Compose 컴포넌트이다.
이미지 갤러리, 온보딩 화면, 탭 콘텐츠, 팔로잉 리스트 등에 사용할 수 있다.

<br>

## 👩🏻‍💻 VerticalPager

VerticalPager는 여러 페이지를 세로 방향으로 스와이프할 수 있게 해주는 Compose 컴포넌트이다.
HorizontalPager와 사용 방식은 거의 같고, 스와이프 방향만 세로이다.

<br>

## 👩🏻‍💻 PagerState

PagerState는 Pager의 현재 페이지, 스크롤 상태, 페이지 이동 동작을 관리하는 상태 객체이다.
`currentPage`로 현재 페이지를 확인하고, `animateScrollToPage()`로 특정 페이지로 이동할 수 있다.

<br>

## 👩🏻‍💻 TabRow

TabRow는 여러 탭을 가로로 배치하는 Compose 컴포넌트이다.
PagerState와 함께 사용하면 탭 클릭 시 페이지가 이동하고, 페이지 스와이프 시 선택된 탭도 함께 변경된다.

<br>

## 👩🏻‍💻 ModalBottomSheet

ModalBottomSheet는 화면 하단에서 올라오는 시트 형태의 UI이다.
필터, 정렬 옵션, 사이즈 선택, 메뉴 선택처럼 여러 선택지를 보여줄 때 자주 사용한다.

<br>

## 👩🏻‍💻 AlertDialog

AlertDialog는 사용자에게 중요한 선택이나 확인을 요구할 때 사용하는 다이얼로그 컴포넌트이다.
삭제 확인, 로그아웃 확인, 위시리스트 추가 확인 등에 사용할 수 있다.

<br>

## 👩🏻‍💻 Coil

Coil은 Kotlin Coroutine 기반의 이미지 로딩 라이브러리이다.
Compose에서는 `AsyncImage`를 사용해 네트워크 이미지를 비동기로 불러오고 화면에 표시할 수 있다.
