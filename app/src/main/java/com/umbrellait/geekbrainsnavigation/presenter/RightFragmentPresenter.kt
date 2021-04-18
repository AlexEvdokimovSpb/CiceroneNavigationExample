package com.umbrellait.geekbrainsnavigation.presenter

import com.umbrellait.geekbrainsnavigation.model.TextModel
import com.umbrellait.geekbrainsnavigation.view.IRightFragmentView
import moxy.MvpPresenter

class RightFragmentPresenter(private val model: TextModel) : MvpPresenter<IRightFragmentView>() {

    fun getText() {
        val textFromModel = model.getTextStartModel()
        viewState.setText(textFromModel)
    }
}