# 영상 템플릿 판매 및 수주 VPLAY - 권태혁
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/17e31643-47b3-4c55-a0a6-de77b84a1ab8" />

## 배포 :earth_asia:
- 배포 링크 : <link>http://vplay.cloud</link>
- TEST ID : HandsomeGwon
- TEST PWD : HandsomeGwon
<br>

## 수행 기간 :calendar:
- 2025.01.15~2025.03.26
<br>

## 팀 구성원 :family:
- 팀장 : 권태혁
- 팀원 : 안효빈, 손동준, 이상윤
<br>

## 개발 배경 :bulb:
- 대부분의 템플릿 플랫폼은 글로벌 서비스를 기반으로 하고 있어, 언어 장벽과 결제 시스템의 제약, 그리고 현지화된 콘텐츠 부족 등으로 인해 국내 사용자들에게는 불편하다고 생각했습니다.
- 또한 국내 시장에서는 소규모 창작자나 중소기업, 개인 사업자들이 간단하고 빠르게 영상을 제작하고자 하는 니즈가 꾸준히 증가하고 있음에도, 이들이 손쉽게 활용할 수 있는 로컬화 된 영상 템플릿 서비스는 거의 전무한 실정이라고 생각했습니다.
- 그래서 국내 이용자들이 쉽게 사용할 수 있도록 국내 템플릿 플랫폼을 개발하게 되었습니다.
<br>

## 프로젝트 주요 목표 :rocket:
1. 사용자 친화적인 템플릿 마켓 플레이스 구축
2. 안정적인 결제 및 라이선스 관리 시스템 개발
3. 크리에이터를 위한 판매 및 정산 시스템 제공
4. 마케팅 최적화로 트래픽 유입 극대화
<br>

## 사용기술 및 개발 환경 :computer:
- 운영체제 : Windows 10
- 사용언어 : Java, JavaScript, HTML5, CSS3, SQL
- FrameWork/Library : Spring Boot, jQuery, MyBatis, Ajax
- DB : Oracle, MYSQL(배포)
- Tool : Eclipse, Visual Studio Code
- WAS : Apache Tomcat
- Collaboration : GitHub
- CDN / 파일관리 : Cloudflare
- DesignPattern : MVC Model 2
- 배포 : AWS EC2 / Ubuntu / Linux
<br>

## 프로젝트 주요 기능 :heavy_exclamation_mark:
1. <b>회원 관리 기능</b>
    * 회원가입 및 로그인, 아이디/비밀번호 찾기, 로그아웃
<br/>

2. <b>회원 정보 관리</b>
    * 내 정보 관리, 내 활동 내역 열람
<br/>

3. <b>SNS 및 외부 연동 기능</b>
    * SNS 로그인 및 공유, 이벤트 기능
<br/>

4. <b>커뮤니케이션 기능</b>
    * 쪽지 기능, 문의 기능, 댓글 및 게시글 관리
<br/>

5. <b>콘텐츠 업로드 및 다운로드 기능</b>
    * 업로드, 다운로드, 구독자 기능, 즐겨찾기
<br/>

6. <b>장바구니 및 결제 기능</b>
    * 장바구니 담기, 플랜 결제 기능
<br/>

7. <b>관리자 기능</b>
    * 회원 상태관리, 관리자 권한 구분, 문의/게시글 관리
<br>

## 프로젝트 내 담당 역할 및 구현 파트 :bangbang:
### **1. 관리자 기능 (ID/PWD :** HandsomeGwon) 로 접속 후 확인

### **관리자 페이지**

**주소 : http://vplay.cloud/admin/dashboard**

<img width="1903" height="499" alt="image" src="https://github.com/user-attachments/assets/ee5858be-fb83-414d-af96-55ffbda9b188" />

**주요 구현 화면**

- 관리자 페이지에는 로고, 사이드 메뉴, 메뉴별 컨텐츠가 존재합니다
- Dashboard 화면에는 전체 회원 수, 총 결제 금액, 전체 다운로드 수, 전체 템플릿 수가 표시됩니다.
- 각 메뉴 클릭 시 해당 페이지로 이동할 수 있습니다.

**주요 구현 기능**

- 관리자 계정으로 로그인 시 관리자 페이지로 이동합니다.
- 로고 클릭 시 메인 화면으로 이동합니다.
- 회원 수, 전체 템플릿 수, 전체 다운로드 수는 각각 SELECT COUNT(*) FROM [TABLE] 쿼리를 통해 총 개수를 조회했습니다.
- 전체 템플릿 수 통계는 Google Chart API를 활용해 시각화 시켰으며, 데이터는 setOnLoadCallback를 이용해 Ajax로 비통기 통신으로 가져왔습니다.
- 일반 사용자의 접근 제어를 위해 WebMvcConfig에서 addPathPatterns("/admin/**")로 설정하고, addInterceptor()로 CheckAdminInterceptor를 등록했습니다.
해당 객체에서는 세션에 저장된 로그인 정보(loginUser)를 확인하여, null이거나 관리자가 아닐 경우 return false로 처리해 일반 사용자가 /admin/** 경로에 접근하지 못하도록 막아두었습니다.

---

### **회원 관리 페이지**

**주소 :  http://vplay.cloud/admin/users**

<img width="1901" height="861" alt="image" src="https://github.com/user-attachments/assets/2e41fb24-c12d-4fc7-ac48-2dcbc8ed681c" />

**주요 구현 화면**

- 사용자들의 번호, 아이디, 이름, 닉네임, 이메일 등 여러 정보를 한 눈에 볼 수 있습니다.

**주요 구현 기능**

- Status 컬럼은 Y/N 값으로 구성되며, 각각 사용자 상태 활성/비활성을 의미합니다.
잘못된 클릭을 방지하기 위해 confirm 창을 띄워 상태 변경 여부를 확인합니다. 
확인 시 비동기 처리로 Y → N, N → Y로 전환이 이루어집니다. 
Ajax를 사용해 비동기 요청을 보내고 DB에서 UPDATE를 수행하며, 성공 시 해당 element에 접근하여 active 또는 inactive 클래스를 적용시켜 변경했습니다.
- Action 메뉴(점3개) 클릭 시 관리자 등록/취소 텍스트가 나옵니다.
Status 전환과 동작 구조는 유사하지만, 이번에는 fetch를 적용시켰습니다.
Ajax는 XMLHttpRequest 방식으로 값을 전송하는 반면, fetch는 JSON 형식으로 값을 전송합니다. 처리 성공 시 해당 element의 innerText를 직접 변경했습니다.

---

### **문의/템플릿/의뢰 게시물 관리 페이지**

**주소 :** http://vplay.cloud/admin/inquiry http://vplay.cloud/admin/templates http://vplay.cloud/admin/request

<img width="1875" height="880" alt="image" src="https://github.com/user-attachments/assets/f3e65bc1-294e-466a-9604-a8b380954d12" />

**주요 구현 화면**

- 각 게시물 주요 정보를 한 눈에 확인할 수 있습니다.
- 템플릿 관리 화면에서 검은색 배경으로 표시된 상위 6개 글은 MD 추천이 적용된 게시물 입니다.

**주요 구현 기능**

- 문의, 템플릿, 의뢰 게시물 관리는 모두 게시물 형태로 구성되어 있으며, 클릭 시 해당 글 상세 페이지로 이동합니다.
- 문의 관리 페이지에서 관리자가 답변을 작성하면 Reply 상태가 대기 → 완료로 변경됩니다.
- 템플릿 관리 페이지에서 Action 메뉴(점3개) 클릭 시 해당 게시물의 MD 추천 여부를 확인할 수 있습니다.
이 기능은 fetch를 사용해 비동기 방식으로 값을 주고 받았습니다.
MD 추천은 최대 6개까지만 가능하므로, 먼저 전체 MD 추천 개수를 조회한 뒤 Controller에서 조건문으로 6개 이상이면 -1, 미만이면 1을 반환하여 UPDATE를 제한했습니다.
게시물 조희 시 CASE WHEN 구문을 활용하여 MD 추천 게시물을 상위 6개로 정렬했습니다.

---

### **2. 게시물 리스트, 카테고리**

### 전체 메뉴 페이지

**주소 : http://vplay.cloud/board/all_menu**

<img width="1887" height="981" alt="image" src="https://github.com/user-attachments/assets/99ab30e7-6570-417b-8f97-cedaae2354f6" />

**주요 구현 화면**

- 인덱스 메뉴에서 All Menu 클릭 시 해당 페이지로 이동합니다.
- 각 메뉴별 최신 영상들이 나열됩니다.

**주요 구현 기능**

- 각 요소 클릭 시 해당 글 상세 페이지로 이동합니다.
- 각 메뉴별 최신 영상들은 하나의 컨트롤러와 Mapper를 통해 조회했습니다.
컨트롤러에서는 각 메뉴 이름을 파라미터로 전달합니다.
Mapper에서는 choose-when 구문을 사용해 메뉴 이름에 따라 해당 글들을 LIMIT 개수만큼 조회하도록 구현했습니다.
- 요소 안에는 다운로드 수와 좋아요(하트) 정보가 표시됩니다.
로그아웃 상태에서 하트를 클릭하면 ‘로그인 후 이용해주세요’라는 alert 창이 뜹니다.
로그인 상태에서 하트를 클릭하면 좋아요가 등록되면서 하트가 빨간색으로 표시됩니다.
하트의 색상(빨간/흰색)은 페이지 로드 전에 request 영역에 좋아요 유무를 담아 전달하고, Thymeleaf if문으로 조건에 맞게 표시합니다.
하트 클릭 시, 현재 색상 상태를 기준으로 좋아요 유무를 판단하고, fetch를 통해 JSON 데이터를 Mapper에 전달해 DB 값을 수정합니다.
처리 결과를 비동기 통신으로 받아온 뒤, 좋아요 수를 즉시 갱신합니다.

---

### 메뉴별 리스트 페이지

**주소 : http://vplay.cloud/board/video-template-list**

<img width="1884" height="986" alt="image" src="https://github.com/user-attachments/assets/211420fb-98e3-48e7-a7a9-b1faf0b13524" />


**주요 구현 화면**

- 좌측에 카테고리 메뉴를 배치해, 원하는 카테고리를 클릭하면 해당 컨텐츠를 볼 수 있도록 구성했습니다.
- 선택된 메뉴의 컨텐츠 글들이 리스트 형식으로 나열됩니다.
- 컨텐츠 썸네일은 영상과 사진 두가지 형태로 구분됩니다.

**주요 구현 기능**

- TailwindCSS를 사용해서 창 크기에 따라 자동으로 레이아웃이 변경되도록 만들었습니다.
0 ~ 768 px → 1열 / 769 ~ 1400px → 2열 / 1401 ~ 1920px → 3열 / 1920px ~ → 4열
로 구성했습니다.
- 썸네일은 영상과 이미지로 나뉘는데, 영상 썸네일에 마우스를 올리면 img 태그를 제거하고 video 태그로 교체, 자동 재생되도록 구현했습니다. 이미지 썸네일 같은 경우에는 살짝 확대되는 효과를 넣어주었습니다.
- 카테고리를 클릭 시 해당 카테고리가 포함된 컨텐츠 글들이 fetch를 사용한 비동기 방식으로 나열됩니다. 여러 카테고리를 선택하면, 한 개라도 포함된 글이면 노출되도록 구현했습니다.
- URL 직관성을 강화하기 위해 사용자가 카테고리를 클릭했을 때, window.history.pushState를 사용해 새로고침 없이 URL만 변경되도록 구성했습니다.
- 다만, 뒤로 가기를 눌렀을 때는 동기 방식으로 처리되어 오류가 발생할 수 있기 때문에, 해당 URL로 들어올 경우를 대비한 Controller를 따로 만들어 대응했습니다.

---

### 3. **콘텐츠 업로드 및 다운로드 기능**

### 게시물 업로드

**주소 : http://vplay.cloud/board/writeContent**

<img width="1890" height="931" alt="image" src="https://github.com/user-attachments/assets/8f28aa5d-0ffc-4f22-9c8e-13a051c10ba0" />

**주요 구현 화면**

- 카테고리 선택, 제목, 내용 입력 등 글 작성을 위한 UI 요소들이 배치됩니다.
- 글 목록 확인과 작성하기 버튼이 함께 제공됩니다.

**주요 구현 기능**

- 메뉴를 선택하면, 해당 메뉴에 맞는 카테고리 선택 항목이 동적으로 등장합니다.
- 메뉴별로 영상 썸네일 또는 이미지 썸네일을 등록할 수 있습니다.
- 글 내용 작성은 Summernote 에디터를 사용해 풍부한 텍스트 편집 기능을 제공합니다.
- 사용자가 작성하기 버튼을 누르면 메뉴, 카테고리, 썸네일, 첨부 파일, 제목, 내용이 모두 DB에 저장됩니다.
파일 업로드는 form태그의 entype=”multipart/form-data” 속성을 이용하여 서버로 전달됩니다.
Controller에서는 MultipartFile 클래스로 받아 getOriginalFilename()을 통해 원본 파일명을 가져옵니다.
- 업로드 된 파일은 Cloudflare R2 Object Storage에 저장됩니다.
접근 키(accessKey)와 시크릿 키(secretKey)를 @Value로 주입받아 R2Service
클래스를 관리합니다.
uploadFile 메소드에서는 UUID,randomUUID()와 원본 파일명을 조합하여 고유한 파일명을 생성한 뒤, putObejct 메소드를 사용해 R2에 업로드합니다.
업로드가 완료되면 Cloudflare R2의 publicUrl, 파일명, 원본 파일명을 DB에 보내 저장됩니다.
이렇게 보내는 이유는 이후 글을 조회할 때 DB에 저장된 URL과 파일명을 활용하여 클라이언트에서 실제 파일들을 불러옵니다.

---

### 게시물 상세페이지(다운로드)

**주소 : http://vplay.cloud/board/video-templates/469**

<img width="1914" height="940" alt="image" src="https://github.com/user-attachments/assets/394cd289-acae-4912-891e-d8be1a0ec526" />

**주요 구현 화면**

- 컨텐츠 번호를 기반으로 불러온 글의 주요 정보가 화면에 표시됩니다.
- 우측에는 다운로드 버튼 또는 구매 버튼이 배치되어 있습니다.

**주요 구현 기능**

- 게시물 업로드에서 저장했던 썸네알 파일을 Cloudflare R2에서 불러옵니다.
DB에 저장된 파일 URL을 img 태그나 video 태그의 src 속성에 넣으면 Cloudflare에 저장된 파일이 화면에 표시됩니다.
- 비로그인 사용자거나 해당 플랜을 소유하지 않았을 경우 결제 버튼이 나와 결제창으로 이동하도록 처리했습니다.
로그인 상태이며 해당 플랜을 소유한 경우 다운로드 버튼이 보이도록 구성을했습니다.
이 분기는 Thymeleaf의 th:if 조건문을 사용하였습니다.
- 다운로드 버튼 클릭 시, R2 Service의 downloadFileStream 메소드가 실행됩니다.
이 메소드는 InputStream 클래스를 사용하여 파일을 전송하는데, 큰 파일을 한 번에 메모리에 올리면 OutOfMemery 에러가 발생할 수 있기 때문입니다.
따라서 데이터를 조각 단위(바이트)로 스트리밍하여 안정적으로 전송하도록 구현했습니다.
파일 이름을 키로 사용해 Cloudflare R2 Obejct Storage에서 해당 파일을 찾은 뒤, 서버에서 스트리밍 방식으로 내려줍니다.
클라이언트에서는 응답 헤더에 설정되어 있는 다운로드 파일명을 이용해, 사용자의 PC에 파일이 지정된 이름으로 저장됩니다
<br>

## 프로젝트 참여 소감 :smile:
조장이자 PL로서 소통의 중요성을 다시 한번 절실히 느꼈습니다.<br><br> 첫 번째 프로젝트와 달리 이번에는 UI/UX와 기능적인 측면에서 퀄리티를 높일 수 있었고,<br> 결과적으로 더 만족스러운 결과물을 얻을 수 있었습니다.<br> 또한, 버그가 발생했을 때도 이전보다 더 빠르게 원인을 파악하고 수정할 수 있어,<br> 개발 역량이 한층 성장했음을 체감할 수 있었습니다.<br><br> 특히 이번 프로젝트에서는 팀 운영 방식을 개선했습니다.<br> 이전에는 역할을 효율적으로 분배하는 데 중점을 두었다면, 이번에는 팀원들이 스스로 원하는 파트를 선택하도록 했습니다.<br> 이후 진행 과정에서 서로 피드백을 주고받으며 부족한 부분을 함께 보완해 나갔고, 그 과정에서 각자의 성장을 이끌어내며 더 높은 완성도의 결과물을 만들어낼 수 있었습니다.<br>
<br>또한 제가 맡은 주요 기능 중 하나는 Cloudflare를 활용한 파일 관리 및 다운로드 기능이었습니다.<br> 이전 프로젝트에서는 파일을 로컬에서 직접 관리했지만,<br> 이번에는 CDN 기반의 Cloudflare를 도입해 첨부파일과 썸네일을 효율적으로 관리할 수 있도록 구현했습니다.<br> 사용자가 글 작성 시 파일을 첨부하면 해당 파일이 Cloudflare에 업로드되고, 그 주소가 DB에 등록되도록 설계했습니다.<br> 이후 다른 사용자가 파일을 다운로드할 때는 DB에 저장된 주소를 기반으로 Cloudflare에 접근해 파일을 받을 수 있도록 처리했습니다.<br> 이 경험을 통해 단순한 기능 구현을 넘어 외부 서비스를 활용한 안정적이고 확장성 있는 구조 설계의 필요성을 배울 수 있었습니다.
<br>

## 요구사항 정의서
<link>https://docs.google.com/spreadsheets/d/10CiUG18fGrM2qKxKslMeXjslcGnF8abdkhVaAl-C9Gc/edit?gid=0#gid=0</link>
