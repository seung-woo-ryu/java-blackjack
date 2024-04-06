# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 유효성 검사

## 유효성 검사 1

입력 받은 이름에 대한 유효성 검사
(오직 영어로만 받는다고 가정.)

- ex: A,b,C,D
- 쉼표 기준으로 분리
- 빈 값, 공백 불가
- 중복 불가
- 참가 인원은 최대 8명

## 유효성 검사2

입력 받은 베팅 금액에 대한 유효성 검사

- 오직 양의 숫자만 입력
- 0 ~ 최대 금액 max(int)

## 유효성 검사3

카드 베팅 유무에 대한 입력 유효성 검사

- y, n만 입력 가능
- 빈 값, 공백 불가

# ToDo

---

## 입출력

- [ ]  처음 받은 카드 출력하기
    - [ ]  딜러는 첫번째 1장만
    - [ ]  플레이어는 모두 공개
- [ ]  이름 입력 받기
    - [ ]  유효성 검사 1 구현
- [ ]  베팅 금액 받기
    - [ ]  유효성 검사2 구현
- [ ]  유효성 검사용 Validator를 따로 둘지 고민.

## Hand

플레이어, 딜러가 보유하고 있는 패.

List<Card>

- [X]  블랙잭 판단
    - 처음 카드 2장의 합이 21인지 판단.
- [X]  버스트 판단
    - 보유 카드 합 21이 넘어가면 버스트
- [X] countGreedyPoints
    - A 포함되면 total value + 10 <= 21이면 + 10해서 반환



## Deck

52장의 Enum Card List

List<Card> totalCard;

- [X]  Init()
    - [X]  랜덤 순서 52장의 Enum Card List 생성
- [ ]  hit()
    - [ ]  맨 위의 카드 뽑아주기.

## abstract class Participant

- [ ]  hit(): 카드 받기.
- [ ]  countPoints(): 보유하고 있는 카드의 점수 계산하기.
- [ ]  abstract getFirstHand(): 첫 두장 보유하고 있는 카드 문자열로 반환.
  ⇒ 딜러는 1장만
  ⇒ 플레이어는 2장 다

## 딜러

- [ ]  딜러 카드 16이하 확인

## 결과

- [ ]  딜러 vs 플레이어 누가 이겼는지 판단
- [ ]  베팅금액 주고 받기
    - [ ]  승패가 가려지면 베팅 금액만큼 건네줌.
    - [ ]  플레이어는 블랙잭으로 이기면 1.5배해서 받기.

# 끄적끄적
1. 제일 작은 클래스부터 구현.
> Card -> Hand -> Deck -> participant -> croupier -> player -> 결과(?)