package com.example.wellingtonasilva.qrcode.core

import io.reactivex.Flowable

/**
 * Created by wellingtonasilva on 12/13/17.
 */
abstract class BasicRepository<T> {
    abstract fun listAll() : Flowable<List<T>>
    abstract fun get(id : Long) : T
    abstract fun delete(entity : T) : Int
    abstract fun insert(entity : T) : Long
    abstract fun update(entity : T) : Int
}