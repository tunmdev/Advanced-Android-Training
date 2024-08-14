package com.tunm17.rxjavatrainning.operator

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function
import java.util.concurrent.TimeUnit

/**
 * map(), flatmap(), concatmap()
 * cast()
 * sorted()
 * delay()
 */
fun main() {
//    runMap()
//    runFlatmap()
//    runConcatMap()
//    runCast()
//    runSorted()
    runDelay()
}

/**
 * map(): transforms each item emitted by an Observable by applying a function to it, emitting the modified item.
 */
fun runMap() {
    Observable.just(1, 2, 3, 4, 5)
        .map(object : Function<Int, String> {
            override fun apply(t: Int): String {
                return "Number $t"
            }
        })
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

            override fun onComplete() {
                println("onComplete")
            }

            override fun onNext(s: String) {
                println("onNext: $s")
            }
        })
}

/**
 * flatmap(): transforms each item emitted by an Observable into another Observable, then flattens and merges the results into a single Observable.
 * It’s useful for handling nested data streams and combining multiple observables into one.
 */
fun runFlatmap() {
    Observable.just(1, 2, 3, 4)
        .flatMap(object : Function<Int, ObservableSource< String>> {
            override fun apply(number: Int): ObservableSource<String> {
                return Observable.just("Item $number-A", "Item $number-B", "Item $number-C").delay(100, TimeUnit.MILLISECONDS)
            }
        })
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(string: String) {
                println("onNext: $string")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
    Thread.sleep(500)
}

/**
 * concatMap(): same flatmap, but flatMap() processes inner Observables concurrently, potentially interleaving their emissions,
 * while concatMap() processes them sequentially, preserving the order.
 */
fun runConcatMap() {
    Observable.just(1, 2, 3, 4)
        .concatMap(object : Function<Int, ObservableSource< String>> {
            override fun apply(number: Int): ObservableSource<String> {
                return Observable.just("Item $number-A", "Item $number-B", "Item $number-C").delay(100, TimeUnit.MILLISECONDS)
            }
        })
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(string: String) {
                println("onNext: $string")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete")
            }
        })
    Thread.sleep(500)
}

/**
 * cast(): cast the items emitted by an Observable to a specified type
 *  If the items cannot be cast to the specified type, it will throw a ClassCastException.
 */
fun runCast() {
    Observable.just(1, 2, 3)
        .cast(Number::class.java)  // Casts the items to Number type
        .subscribe { item ->
            println(item)
        }
}

/**
 * sorted(): sorts the items emitted by an Observable before emitting them.
 */
fun runSorted() {
    Observable.just("banana", "apple", "cherry")
        .sorted { item1, item2 -> item1.length - item2.length }  // Sort by length
        .subscribe { item ->
            println(item)
        }
}

/**
 * delay():  postpones the emissions of items from an Observable by a specified time duration.
 * This delay affects the emissions without affecting the subscription.
 */
fun runDelay() {
    Observable.just(1, 2, 3, 4, 5)
        .delay(2, TimeUnit.SECONDS)
        .subscribe(
            { item: Int -> println("Received: $item") },
            { throwable: Throwable ->
                System.err.println(
                    "Error: $throwable"
                )
            },
            { println("Completed") }
        )
    Thread.sleep(5000)
}