package com.tunm17.rxjavatrainning.operator

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * doOnSubscribe()
 * doOnDispose()
 * doOnNext(), doOnComplete()
 * doOnError(), doOnSuccess()
 *
 */
fun main() {
    runDoOnSubscribe()
}

/**
 * doOnSubscribe(): allows to perform side-effects when an Observer subscribes to an Observable
 *  It can be used to execute actions such as logging, initializing resources, or setting up prerequisites before the subscription happens.
 *
 */
fun runDoOnSubscribe() {
    val observable = Observable.just(1, 2, 3, 4, 5)
        .doOnSubscribe { disposable ->
            println("doOnSubscribe: Preparing to subscribe...")
        }
        .map { it * 2 }

    observable.subscribe(object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
        }

        override fun onNext(integer: Int) {
            println("Received: $integer")
        }

        override fun onError(e: Throwable) {
            println("Received ERROR: ${e.message}")
        }

        override fun onComplete() {
            println("onComplete")
        }
    })
}