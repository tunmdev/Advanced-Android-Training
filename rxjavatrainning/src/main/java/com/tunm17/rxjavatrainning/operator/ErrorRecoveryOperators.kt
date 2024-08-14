package com.tunm17.rxjavatrainning.operator

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.functions.Function

/**
 * onErrorReturn()
 * onErrorReturnItem()
 * onErrorResumeNext() - optional
 * retry() - optional
 */
fun main() {
    runOnErrorReturn()
}

/**
 * onErrorReturn(): provides a fallback value when an error occurs.
 * Instead of propagating the error, it emits a specified value and completes the Observable.
 *
 */
fun runOnErrorReturn() {
    val observable: Observable<Int> = Observable.create { emitter ->
        emitter.onNext(1)
        emitter.onNext(2)
        emitter.onError(Exception("An error occurred"))
        emitter.onNext(3)
    }

    observable
        .onErrorReturn(object : Function<Throwable, Int> {
            override fun apply(throwable: Throwable): Int {
                println("Error: ${throwable.message}")
                return -1
            }
        })
        .subscribe(object : Observer<Int> {
            override fun onSubscribe(d: io.reactivex.rxjava3.disposables.Disposable) {
                println("Subscribed")
            }

            override fun onNext(value: Int) {
                println("Received: $value")
            }

            override fun onError(e: Throwable) {
                println("Error: ${e.message}")
            }

            override fun onComplete() {
                println("Completed")
            }
        })
}

/**
 * onErrorReturnItem(): Directly specifies a single fallback value to emit when any error occurs.
 * onErrorReturn(): Allows to execute custom logic when an error occurs and return a value based on the specific error.
 *
 */
fun runOnErrorReturnItem() {
    val observable: Observable<Int> = Observable.create { emitter ->
        emitter.onNext(1)
        emitter.onNext(2)
        emitter.onError(Exception("An error occurred"))
        emitter.onNext(3)
    }

    observable
        .onErrorReturnItem(-1)
        .subscribe(object : Observer<Int> {
            override fun onSubscribe(d: io.reactivex.rxjava3.disposables.Disposable) {
                println("Subscribed")
            }

            override fun onNext(value: Int) {
                println("Received: $value")
            }

            override fun onError(e: Throwable) {
                println("Error: ${e.message}")
            }

            override fun onComplete() {
                println("Completed")
            }
        })
}