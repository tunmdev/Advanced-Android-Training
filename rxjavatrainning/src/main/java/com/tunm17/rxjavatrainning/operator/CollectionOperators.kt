package com.tunm17.rxjavatrainning.operator

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

/**
 * toList()
 * toSortedList()
 */
fun main() {
//    runToList()
    runToSortedList()
}

data class Person(val name: String, val age: Int)

/**
 * toList(): collects all items emitted by an Observable and emits them as a single List when the source Observable completes.
 *
 */
fun runToList() {
    val observable: Observable<Person> = Observable.just(
        Person("John", 30),
        Person("Jane", 25),
        Person("Tom", 35)
    )
    val listSingle: Single<List<Person>> = observable.toList()
    listSingle.subscribe(object : SingleObserver<List<Person>> {
        override fun onSubscribe(d: Disposable) {
            println("Subscribed")
        }

        override fun onSuccess(list: List<Person>) {
            println("List: $list")
        }

        override fun onError(e: Throwable) {
            println("Error: ${e.message}")
        }
    })
}

/**
 * toSortedList()
 *
 */
fun runToSortedList() {
    val observable: Observable<Int> = Observable.just(3, 1, 4, 1, 5, 9, 2, 6)
    val sortedSingle: Single<List<Int>> = observable.toSortedList()

    sortedSingle.subscribe(object : SingleObserver<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            println("Subscribed")
        }

        override fun onError(e: Throwable) {
            println("onError $e")
        }

        override fun onSuccess(sortedList: List<Int>) {
            println("Sorted list: $sortedList")
        }
    })
}