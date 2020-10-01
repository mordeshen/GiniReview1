package com.e.kotlinexample.ui.main.state

sealed class MainStateEvent {

    class GetNumbersEvent : MainStateEvent()

    class None : MainStateEvent()


}