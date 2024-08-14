package com.tunm17.rxjavatrainning

import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

fun main() {
    run7()
}

fun run1() {
    // JUST: create observable
    Observable.just("Hello Reactive World") // just converts the string "Hello Reactive World" to an Observable
        .subscribe { value -> println(value) }
}

fun run2() {
    Observable.just("Apple", "Orange", "Banana")
        .map({ input -> throw RuntimeException() } )
        .subscribe(
            { value -> println("Received: $value") }, // onNext
            { error -> println("Error: $error") },  // onError
            { println("Completed!") } // onComplete
        )
}

fun run3() {
    // fromArray: create observable
    Observable.fromArray("Apple", "Orange", "Banana")
        .subscribe { value -> println(value) }
}

fun run4() {
    getObservableFromList(listOf("Apple", "", "Banana"))
        .subscribe(
            { v -> println("Received: $v") },
            { e -> println("Error: $e") }
        )
}

fun getObservableFromList(myList: List<String>) =
    Observable.create { emitter ->
        myList.forEach { kind ->
            if (kind == "") {
                emitter.onError(Exception("There's no value to show"))
            }
            emitter.onNext(kind)
        }
        emitter.onComplete()
    }

fun run5() {
    val observable = PublishSubject.create<Int>()
    observable
        .toFlowable(BackpressureStrategy.DROP)
        .observeOn(Schedulers.computation())
        .subscribe (
            {
                println("The Number Is: $it")
            },
            {t->
                print(t.message)
            }
        )
    for (i in 0..1000000){
        observable.onNext(i)
    }
}

/**
 * Emitter types:
 *  - Flowable: like Observable but it supports Backpressure.
 *  - Maybe
 */

fun run6() {
    // MAYBE
    // If there is an emitted value, it calls onSuccess , => Maybe.just("This is a Maybe")
    // if there’s no value, it calls onComplete => Maybe.empty<String>
    // or if there’s an error, it calls onError => Maybe.error<String>(RuntimeException("This is an error"))
    Maybe.error<String>(RuntimeException("This is an error"))
        .subscribe(
            { value -> println("Received: $value") }, // onSuccess
            { error -> println("Error: $error") }, // onError
            { println("Completed!") } // onComplete
        )
}

fun run7() {
    // SINGLE
    // If there is an emitted value, it calls onSuccess , => Single.just("This is a Maybe")
    // if there’s no value, error it calls onError => Single.error<String>(RuntimeException("This is an error"))
    Single.error<String>(RuntimeException("This is an error"))
        .subscribe(
            { v -> println("Value is: $v") }, // onSuccess
            { e -> println("Error: $e")} // onError
        )
}

fun run8() {
    // Completable
    // Won’t emit any data, It calls onComplete and if it wasn’t it calls onError
    Completable.create { emitter ->
        emitter.onComplete()
        emitter.onError(Exception())
    }
}