package com.andres.ceiba.presentation.ui

sealed class UiEventCeiba {
    data class Navigate(val screen: String) : UiEventCeiba()
}