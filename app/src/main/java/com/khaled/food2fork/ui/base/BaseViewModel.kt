package com.khaled.food2fork.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khaled.food2fork.data.utils.ErrorModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<Repository : BaseRepository> : ViewModel() {

    abstract val repository: Repository

    val error = MutableLiveData<ErrorModel>()
    val loading = MutableLiveData<Boolean>()
    val compositeDisposable = CompositeDisposable()

//    fun <T> subscribe(
//        observable: Observable<T>,
//        success: Consumer<T>,
//        error: Consumer<Throwable>,
//        subscribeScheduler: Scheduler = Schedulers.io(),
//        observeOnMainThread: Boolean = true
//    ) {
//
//        val observerScheduler =
//                if (observeOnMainThread) AndroidSchedulers.mainThread()
//            else subscribeScheduler
//
//        compositeDisposable.add(
//            observable
//                .subscribeOn(subscribeScheduler)
//                .observeOn(observerScheduler)
//                .subscribe(success, error)
//        )
//    }
//
//    fun <T> subscribe(
//        observable: Single<T>,
//        success: Consumer<T>,
//        error: Consumer<Throwable> = Consumer { },
//        subscribeScheduler: Scheduler = Schedulers.io(),
//        observeOnMainThread: Boolean = true,
//        showLoading: Boolean = true
//    ) {
//
//        val observerScheduler =
//            if (observeOnMainThread) AndroidSchedulers.mainThread()
//            else subscribeScheduler
//
//        compositeDisposable.add(observable
//            .subscribeOn(subscribeScheduler)
//            .observeOn(observerScheduler)
//            .compose { single ->
//                composeSingle<T>(single, showLoading)
//            }
//            .subscribe(success, error))
//    }
//
//    private fun <T> composeSingle(single: Single<T>, showLoading: Boolean = true): Single<T> {
//        return single
//            .doOnError {
//                //                Timber.e(it)
////                getRetrofitError(it)
//                loading.postValue(false)
//            }
//            .doOnSubscribe {
//                loading.postValue(showLoading)
//            }.doOnSuccess {
//                loading.postValue(false)
//            }
//    }
//
//    fun clearSubscription() {
//        if (compositeDisposable.isDisposed.not()) compositeDisposable.clear()
//    }

}