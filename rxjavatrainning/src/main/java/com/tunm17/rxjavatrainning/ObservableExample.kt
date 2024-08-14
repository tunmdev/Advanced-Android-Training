package com.tunm17.rxjavatrainning

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Create observable: create
 */
fun main() {
    rangeOp()
}

fun fromOp() {
    Observable.fromArray("A", "B", "C", "D", "E", "F")
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe: called")
            }

            override fun onNext(string: String) {
                println("onNext: $string")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete: called")
            }
        })
}

fun justOp() {
    Observable.just(arrayOf("A", "B", "C", "D", "E", "F"))
        .subscribe(object : Observer<Array<String>> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe: called")
            }

            override fun onNext(strings: Array<String>) {
                println("onNext: ${strings.contentToString()}")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete: called")
            }
        })
}

fun rangeOp() {
    Observable.range(2, 5)
        .repeat(2)
        .subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe: called")
            }

            override fun onNext(integer: Int) {
                println("onNext: $integer")
            }

            override fun onError(e: Throwable) {
                println("onError: ${e.message}")
            }

            override fun onComplete() {
                println("onComplete: called")
            }
        })
}

