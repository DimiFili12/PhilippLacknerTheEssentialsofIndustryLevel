package com.example.philipplacknertheessentialsofindustrylevel

// if you have OnClickListener you typically only care about the onClick function
// so an interface like this violates Interface-Segregation Principle
interface onClickListener {
    fun onClick()
    fun onFingerUp()
}


interface onClickListenerSimpleFix {
    fun onClick()
    fun onFingerUp() {}
}