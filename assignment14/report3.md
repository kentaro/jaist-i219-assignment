# Assignment 14

* 氏名: 栗林健太郎
* 学生番号: 2030006
* 作成日: 2020年12月4日

## `Deadlock`

3つのスレッドと3つのリソースがある状態で、それぞれのスレッドは隣り合うリソースを確保して処理を行う`Deadlock`クラスについて検討する。

### `Deadclass`クラスの実行

`Deadlock.java`に含まれているコードは、以下の図の通りリソースを循環的に参照しているため、デッドロックが発生する。

![](./deadlock-diagram.png)

`Deadlock`クラスを実行すると、以下の通りデッドロックとなる。

![](./Deadlock.png)

### `Deadclass`クラスの解析

JPFを実行すると、以下の通りデッドロックが検出された。

![](./DeadlockJpf.png)

以下に、デッドロックに関するtransitionを抜粋する。

```
------------------------------------------------------ transition #6 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,1/3,isCascaded:false}
  Deadlock.java:19               : synchronized(resource1) {
  Deadlock.java:20               : System.out.println(name + " acquired the lock of " + resource1.getName());
      [2 insn w/o sources]
  Deadlock.java:20               : System.out.println(name + " acquired the lock of " + resource1.getName());
------------------------------------------------------ transition #10 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/3,isCascaded:false}
  Deadlock.java:21               : synchronized(resource2) {
------------------------------------------------------ transition #11 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,2/3,isCascaded:false}
      [1 insn w/o sources]
  Deadlock.java:1                : /**
  Deadlock.java:19               : synchronized(resource1) {
------------------------------------------------------ transition #17 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_OBJECT" ,1/2,isCascaded:false}
  Deadlock.java:21               : synchronized(resource2) {
------------------------------------------------------ transition #18 thread: 3
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,2/2,isCascaded:false}
      [1 insn w/o sources]
  Deadlock.java:1                : /**
  Deadlock.java:19               : synchronized(resource1) {
------------------------------------------------------ transition #20 thread: 3
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,2/2,isCascaded:false}
  Deadlock.java:21               : synchronized(resource2) {
.run(Deadlock.java:21)
```

上記のtransitionの内容は以下の通りである。

1. Thread1がResource1のロックを確保
2. Thread2がResource2のロックを確保
3. Thread3がResource3のロックを確保
4. Thread1がResource2のロックを待つ
5. Thread2がResource3のロックを待つ
6. Thread3がResource1のロックを待つ

このため、`Deadlock`クラスの実行によってデッドロックが発生する。

ちなみに、下図のように、たとえばThread3のロック確保順を逆にして循環を崩すと、デッドロックせずにプログラムが終了する。

![](./non-deadlock-diagram.png)

実行結果は以下の通りである。

![](./NonDeadlock.png)

JPFを実行しても、デッドロックは検出されない。

![](./NonDeadlockJpf.png)

