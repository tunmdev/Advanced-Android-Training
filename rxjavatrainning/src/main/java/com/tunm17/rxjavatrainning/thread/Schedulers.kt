package com.tunm17.rxjavatrainning.thread

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * subscribeOn(Scheduler) and observeOn(Scheduler)
 * subscribeOn: decide which thread your Emitter (such as Observable , Flowable , Single , etc) is executed,
 * instruct the source Observable which thread to emit the items on and push the emissions on our Observer.
 *  - Scheduler.io(): Backed by a thread pool.
 *  - Scheduler.computation(): quite similar to IO, however, the number of threads that can be used is fixed to the number of cores present in the device.
 *  - Scheduler.newThread()
 *  - Scheduler.single()
 *
 *  subscribeOn() affects upstream operators (operators above the subscribeOn)
 *  observeOn() affects downstream operators (operators below the observeOn)
 */
fun main() {
    val alphabets: List<String> = getAlphabetList()
    val observable = Observable.create<String> { emitter ->
        println("emitter in: " + Thread.currentThread().name + " thread")
        try {
            for (alphabet in alphabets) {
                emitter.onNext(alphabet)
            }
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    val observer = object : Observer<Any> {

        override fun onSubscribe(d: Disposable) {
//            println("onSubscribe")
        }

        override fun onNext(t: Any) {
            println("Current thread: " + Thread.currentThread().name + " - onSubscribe")
            println("onNext: $t")
        }

        override fun onError(e: Throwable) {
            println("onError: ${e.message}")
        }

        override fun onComplete() {
            println("onComplete")
        }
    }
    runOneOrManySubscribeOn(observable, observer)

    Thread.sleep(1000)
}

/**
 *  If have one subscribeOn() => ALL in same thread
 *  When multiple subscribeOn() are used in succession => Only the first one takes effect
 */
fun runOneOrManySubscribeOn(observable: Observable<String>, observer: Observer<Any>) {
    observable
        .subscribeOn(Schedulers.computation())
        .map {
            println("Current thread: " + Thread.currentThread().name + " - in 1")
            "$it"
        }
        .subscribeOn(Schedulers.newThread())
        .map {
            println("Current thread: " + Thread.currentThread().name + " - in 2")
            "$it "
        }
        .subscribe(observer);
}

/**
 *  If have one observeOn() => dưới mới bị effect
 */
fun runOneObserveOn(observable: Observable<String>, observer: Observer<Any>) {
    observable
        .map {
            println("Current thread: " + Thread.currentThread().name + " - in 1")
            "$it"
        }
        .observeOn(Schedulers.newThread())
        .map {
            println("Current thread: " + Thread.currentThread().name + " - in 2")
            "$it "
        }
        .subscribe(observer);
}


/**
 * On the contrary observeOn is able to change threads in subsequent calls as evident from the output of the logs.
 */
fun runManyObserveOn(observable: Observable<String>, observer: Observer<Any>) {
    observable
        .map {
            System.out.println("Current thread: " + Thread.currentThread().name + " - in 1")
            "$it"
        }
        .observeOn(Schedulers.io())
        .map {
            System.out.println("Current thread: " + Thread.currentThread().name + " - in 2")
            "$it "
        }
        .observeOn(Schedulers.computation())
        .map {
            System.out.println("Current thread: " + Thread.currentThread().name + " - in 3")
            "$it "
        }
        .subscribe(observer);
}

/**
 * Both
 */
fun runBoth(observable: Observable<String>, observer: Observer<Any>) {
    observable
        .map {
            System.out.println("Current thread: " + Thread.currentThread().name + " - in 1")
            "$it"
        }
        .observeOn(Schedulers.io())
        .map {
            System.out.println("Current thread: " + Thread.currentThread().name + " - in 2")
            "$it "
        }
        .observeOn(Schedulers.newThread())
        .subscribeOn(Schedulers.computation())
        .map {
            System.out.println("Current thread: " + Thread.currentThread().name + " - in 3")
            "$it "
        }
        .subscribe(observer);
}

fun getAlphabetList(): List<String> {
    return ('A'..'E').map { it.toString() }
}