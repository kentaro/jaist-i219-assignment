# Assignment 13

* 氏名: 栗林健太郎
* 学生番号: 2030006
* 作成日: 2020年11月30日

## `SimpInc`

まずは競合の起こらない`SimpInc.java`を実行する。

![](./SimpInc.png)

上記の通り、`count: 1`が表示される（2度めの実行のように`-enableassertions`オプションをつけて実行するとアサーションエラーが起こる）。

次に、`SimpInc`をJPFで検査する。

![](./SimpIncJpf.png)

以下の通り、アサーションエラーで終了する。

```
====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:RUNNING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  call stack:
	at SimpInc.main(SimpInc.java:21)


====================================================== results
error #1: gov.nasa.jpf.vm.NoUncaughtExceptionsProperty "java.lang.AssertionError  at SimpInc.main(SimpInc...."
```

スレッドの実行の様子は以下の通りである（競合に関係する箇所のみ抜粋）。

```
====================================================== trace #1
------------------------------------------------------ transition #1 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  SimpInc.java:12                : count++;
  SimpInc.java:13                : t.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #2 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
      [1 insn w/o sources]
  SimpInc.java:1                 : public class SimpInc extends Thread {
  SimpInc.java:6                 : count2++;
  SimpInc.java:7                 : }
  SimpInc.java:4                 :
```

`count`変数に対する操作は`thread: 0`のみで行われている。そのため、`thread: 0`（メインスレッド）と`thread: 1`の間で`count`変数にたいする競合は起こっていない。

## `SimpConcInc`

次に、競合の起こる`SimpConcInc.java`を実行する。

![](./SimpConcInc.png)

上記の通り、`count: 2`が表示される。`-enableassertions`オプションをつけて実行してもエラーが起こらないため、一見すると正しく実行されているかのように見える。

次に、`SimpConcInc`をJPFで検査する。

![](./SimpConcIncJpf.png)

以下の通り、アサーションエラーで終了する。

```
====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:RUNNING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  call stack:
	at SimpConcInc.main(SimpConcInc.java:20)


====================================================== results
error #1: gov.nasa.jpf.vm.NoUncaughtExceptionsProperty "java.lang.AssertionError  at SimpConcInc.main(Simp..."
```

スレッドの実行の様子は以下の通りである（競合に関係する箇所のみ抜粋）。

```
====================================================== trace #1
------------------------------------------------------ transition #1 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"START" ,2/2,isCascaded:false}
      [1 insn w/o sources]
  SimpConcInc.java:1             : public class SimpConcInc extends Thread {
  SimpConcInc.java:5             : count++;
------------------------------------------------------ transition #2 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
      [2 insn w/o sources]
  SimpConcInc.java:11            : count++;
------------------------------------------------------ transition #3 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  SimpConcInc.java:11            : count++;
------------------------------------------------------ transition #4 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,2/2,isCascaded:false}
  SimpConcInc.java:5             : count++;
------------------------------------------------------ transition #5 thread: 0
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  SimpConcInc.java:11            : count++;
  SimpConcInc.java:12            : t.join();
      [1 insn w/o sources]
------------------------------------------------------ transition #6 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
  SimpConcInc.java:5             : count++;
  SimpConcInc.java:6             : }
  SimpConcInc.java:4             : public void run() {
```

ふたつのスレッドによる各transitionのフローは以下の通りである（競合に関係する箇所のみ抜粋）。

* transition #1: `thread: 1`が`count`から`0`を読み出し
* transition #2: `thread: 0`が`count`から`0`を読み出し
* transition #3: `thread: 0`が`count`をインクリメント
* transition #4: `thread: 1`が`count`をインクリメント
* transition #5: `thread: 0`が`count`に`1`を書き込み
* transition #6: `thread: 1`が`count`に`1`を書き込み

`thread: 0`（メインスレッド）と`thread: 1`との間で`count`変数に対する競合が起こっている。結果としてアサーション時には`count`の値は`1`になるため、エラーが発生する。

## `UnsafeInc`

カウンターのクラス`FCounter`を2つのスレッドで共有する`UnsafeInc`を実行する。

![](./UnsafeInc.png)

上記の通り、`count: 2`が表示される。`-enableassertions`オプションをつけて実行してもエラーが起こらないため、一見すると正しく実行されているかのように見える。

次に、`UnsafeInc`をJPFで検査する。

![](./UnsafeIncJpf.png)

以下の通り、アサーションエラーで終了する。

```
====================================================== snapshot #1
thread java.lang.Thread:{id:0,name:main,status:RUNNING,priority:5,isDaemon:false,lockCount:0,suspendCount:0}
  call stack:
	at UnsafeInc.main(UnsafeInc.java:15)


====================================================== results
error #1: gov.nasa.jpf.vm.NoUncaughtExceptionsProperty "java.lang.AssertionError  at UnsafeInc.main(Unsafe..."
```

ふたつのスレッドによる各transitionのフローは以下の通りである（競合に関係する箇所のみ抜粋）。

```
====================================================== trace #1
------------------------------------------------------ transition #7 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"LOCK" ,2/2,isCascaded:false}
  UnsafeInc.java:3               : (new FCounter()).inc();
  FCounter.java:15               : x++;
------------------------------------------------------ transition #8 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  UnsafeInc.java:3               : (new FCounter()).inc();
  FCounter.java:15               : x++;
------------------------------------------------------ transition #9 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  FCounter.java:15               : x++;
------------------------------------------------------ transition #10 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,2/2,isCascaded:false}
  FCounter.java:15               : x++;
------------------------------------------------------ transition #11 thread: 1
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"SHARED_CLASS" ,1/2,isCascaded:false}
  FCounter.java:15               : x++;
  FCounter.java:16               : }
------------------------------------------------------ transition #13 thread: 2
gov.nasa.jpf.vm.choice.ThreadChoiceFromSet {id:"JOIN" ,1/1,isCascaded:false}
  FCounter.java:15               : x++;
  FCounter.java:16               : }
```

ふたつのスレッドによる各transitionのフローは以下の通りである。

* transition #7: `thread: 2`が`x`から`0`を読み出し
* transition #8: `thread: 1`が`x`から`0`を読み出し
* transition #9: `thread: 1`が`x`をインクリメント
* transition #10: `thread: 2`が`x`をインクリメント
* transition #11: `thread: 1`が`x`に`1`を書き込み
* transition #13: `thread: 2`が`x`に`1`を書き込み

`thread: 1`と`thread: 2`との間で`FCounter`クラスのスタティック変数`x`に対する競合が起こっている。結果としてアサーション時には`count`の値は`1`になるため、エラーが発生する。

`UnsafeInc`では、スレッドが`FCounter`オブジェクトをそれぞれ作り、それぞれのオブジェクトに対してロックを取っているため、`FCounter`のスタティック変数`x`に対してはインクリメント処理が競合してしまうためである。

## `SafeInc`

カウンターのクラス`GCounter`を2つのスレッドで共有する`SafeInc`を実行する。

![](./SafeInc.png)

上記の通り、`count: 2`が表示される。

次に、`SafeInc`をJPFで検査する。

![](./SafeIncJpf.png)

以下の通り、エラーなく終了する。

```
====================================================== results
no errors detected
```

`FCounter`と違い、ふたつのスレッドそれぞれが`GCounter`のスタティック変数`lock`で示されるオブジェクトに対してロックを取った上でインクリメントを実行するため、同期が適切に行われる。

## `SafeInc2`

カウンターのクラス`Counter`を2つのスレッドで共有する`SafeInc2`を実行する。

![](./SafeInc2.png)

上記の通り、`count: 2`が表示される。

次に、`SafeInc2`をJPFで検査する。

![](./SafeInc2Jpf.png)

以下の通り、エラーなく終了する。

```
====================================================== results
no errors detected
```

ふたつのスレッドそれぞれが、スタティック変数`counter`として宣言された`Counter`オブジェクトを共有しているが、`Counter`クラスでは変数`x`がスタティックではなく、かつ、インクリメントする`inc`メソッドが同期されている。それぞれのスレッドは`counter`オブジェクトに対してロックを取った上でインクリメントを実行するため、同期が適切に行われる。
