package com.tunm17.rxjavatrainning.operator

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * filter()
 * take()
 * skip()
 * takeWhile(), skipWhile()
 * distinct()
 * distinctUntilChanged()
 */
fun main() {
//    runFilter()
//    runTake()
//    runTakeWhile()
//    runSkipWhile()
//    runDistinct()
    runDistinctUntilChanged()
}

/**
 * filter(): This operator emits only those items from an Observable that pass a predicate test.
 */
fun runFilter() {
    Observable.just(1, 2, 3, 4, 5)
//        .filter(object : Predicate<Int>{
//            override fun test(item: Int): Boolean {
//                return item % 2 == 0
//            }
//        })
        .filter { item -> item % 2 == 0 }
        .subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: Int) {
                println("onNext: $t");
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
}

/**
 * take(): It emit only the first n items emitted by an Observable.
 */
fun runTake() {
    Observable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
        .take(4)
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(s: String) {
                println("onNext: $s");
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
}

/**
 * skip(): suppresses the first n items emitted by an Observable.
 */
fun runSkip() {

}

/**
 * takeWhile(): nhận các sự kiện từ Observable và dừng lại khi điều kiện không đúng nữa
 * filter: Xử lý tất cả các sự kiện mà thỏa mãn điều kiện, không dừng lại cho đến khi hoàn tất hoặc lỗi.
 * takeWhile: Xử lý sự kiện cho đến khi gặp một sự kiện không thỏa mãn điều kiện, sau đó dừng lại ngay lập tức.
 */
fun runTakeWhile() {
    Observable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
        .takeWhile { s ->
            s != "E" // gặp E không thoả mãn là dừng luôn, kệ những thằng sau.
        }
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(s: String) {
                println("onNext: $s")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
}

fun runSkipWhile() {
    Observable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
        .skipWhile { s -> s != "D" } // Bỏ qua các ký tự từ "A" đến "D"
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(s: String) {
                println("onNext: $s")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
}

/**
 * distinct(): suppresses duplicate items emitted by an Observable
 */
fun runDistinct() {
    Observable.just(10, 20, 20, 10, 30, 40, 70, 60, 70)
        .distinct()
        .subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(integer: Int) {
                println("onNext: $integer")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
}

/**
 * distinctUntilChanged(): remove consecutive duplicate values
 */
fun runDistinctUntilChanged() {
    Observable.just(10, 10, 20, 30, 10, 40, 40, 70, 60, 70)
        .distinctUntilChanged()
        .subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(integer: Int) {
                println("onNext: $integer")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
}