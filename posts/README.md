# 6. 생에 최초 배포 준비하기

- 배포란 무엇인가, 어떤 준비가 필요한가
- 스프링 서버 실행 시 설정을 코드 변경 없이 제어하는 방법
- Git, GitHub 차이, 기초적인 사용법
- AWS EC2란 무엇인가? 어떻게 사용하는가?

## 37. 배포란 무엇인가?

- 배포란 사용자에게 프로그램을 제공하는 방법
- 서버용 컴퓨터를 구성하는 것은 여러 어려움이 있음
- 따라서 가장 간단한 방법인 클라우드 컴퓨터를 주로 이용, 강의에서는 AWS를 사용
- 서버용 컴퓨터로 리눅스를 사용하는 이유
    - 무료 오픈소스
    - 우수한 보안성
    - 구조 안정성

## 38. profile과 H2 DB

**설정을 코드 변경 없이 제어하는 방법**

- 개발 시에 속도, 테스트 용도로 가볍고 편리한 데이터베이스 H2를 사용
- 배포 시에는 실제 데이터베이스를 사용
- `@Profile`: 구성의 일부를 분리하고 특정환경에서만 동작하도록 제어하는 방법
- `application.yml`에 기술

## 39. git과 github이란 무엇인가?!

- Git: 버전관리 프로그램
- GitHub: Git으로 작성된 프로그램을 올리는 원격 저장소

## 40. git 기초 사용법

- git init: git 프로젝트 설정
- git remote add origin [저장소 주소]: 원격 저장소 추가
- git add [파일]: stage 파일 올리기
- git status: 상태조회
- git push --set-upstream origin [branch]: push 원격 저장소 설정(최초 1회)

## 41. AWS의 EC2 사용하기

[AWS](https://aws.amazon.com/ko/free/?gclid=CjwKCAjw9IayBhBJEiwAVuc3fqgIeWpeiKJb-8LYPDAozmpNyV92vuBWLxCBvNjY3MZwiq2cfocLHBoCrx4QAvD_BwE&trk=2e777eb1-7c1a-4acc-ae47-724e1cd50096&sc_channel=ps&ef_id=CjwKCAjw9IayBhBJEiwAVuc3fqgIeWpeiKJb-8LYPDAozmpNyV92vuBWLxCBvNjY3MZwiq2cfocLHBoCrx4QAvD_BwE:G:s&s_kwcid=AL!4422!3!444218215904!e!!g!!aws!10287751092!99328587341&all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc&awsf.Free%20Tier%20Types=*all&awsf.Free%20Tier%20Categories=*all)

- 회원가입 -> 로그인 -> Region/Seoul -> EC2 -> 인스턴스(빌리는 컴퓨터) 생성
- 이름, OS(Amazon Linux) -> 키 페어 생성 -> 보안 그룹 생성 -> 인스턴스 시작
- 인스턴스 유형
    - [컴퓨터의 성격, 세대].[성능]: t2.micro

# 7. 생애 최초 배포하기

- EC2에 접속하는 방법과 리눅스 명령어 다루기
- 개발환경 구축 및 배포
- foreground, background의 차이 및 background 제어하기
- 도메인 이름 사용하기

## 43. EC2에 접속해 리눅스 명령어 다뤄보기

- 컴퓨터에 접속하는 2가지 방법
    - key pair: key pair 권한수정 -> `ssh -i/key pair ec2-user@ip`접속
    - AWS Console: AWS 인스턴스 연결
- 기본적인 5가지 리눅스 명령어
    - 디렉터리 만들기
    - 디렉터리, 파일 확인, 자세한 정보 확인
    - 디렉터리 안으로 이동, 상위 디렉터리로 이동
    - 현재위치 확인
    - 디렉터리 삭제
