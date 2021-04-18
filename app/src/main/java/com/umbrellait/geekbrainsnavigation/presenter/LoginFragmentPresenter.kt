package com.umbrellait.geekbrainsnavigation.presenter

import com.umbrellait.geekbrainsnavigation.model.TextModel
import com.umbrellait.geekbrainsnavigation.view.ILoginFragmentView
import moxy.MvpPresenter

class LoginFragmentPresenter(private val model: TextModel) : MvpPresenter<ILoginFragmentView>() {

    fun setText(text: String) {
        model.setTextStartModel(text)
    }
}