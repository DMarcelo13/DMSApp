package com.example.dmsapp.intent

sealed class Intent{
    object GetAutoEvent: Intent()
    object None: Intent()
}
