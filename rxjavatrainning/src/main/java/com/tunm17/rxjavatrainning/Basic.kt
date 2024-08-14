package com.tunm17.rxjavatrainning

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun main() {
    val alphabets: List<String> = getAlphabetList()

    /*
     * Observable.create() -> We will need to call the
     * respective methods of the emitter such as onNext()
     * & onComplete() or onError()
     *
     * */
    val observable = Observable.create<String> { emitter ->
        try {
            /*
             * The emitter can be used to emit each list item
             * to the subscriber.
             *
             * */
            for (alphabet in alphabets) {
                emitter.onNext(alphabet)
            }

            /*
             * Once all the items in the list are emitted,
             * we can call complete stating that no more items
             * are to be emitted.
             *
             * */
            emitter.onComplete()
        } catch (e: Exception) {
            /*
             * If an error occurs in the process,
             * we can call error.
             *
             * */
            emitter.onError(e)
        }
    }

    /*
     * We create an Observer that is subscribed to Observer.
     * The only function of the Observer in this scenario is
     * to print the values emitted by the Observer.
     *
     */
    val observer = object : Observer<Any> {
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
        }

        override fun onNext(t: Any) {
            println("onNext: $t")
        }

        override fun onError(e: Throwable) {
            println("onError: ${e.message}")
        }

        override fun onComplete() {
            println("onComplete")
        }
    }

    /*
        * We can call this method to subscribe
        * the observer to the Observable.
    */
    observable.subscribe(observer);
}

fun getAlphabetList(): List<String> {
    return ('A'..'E').map { it.toString() }
}