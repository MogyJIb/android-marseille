package by.gomel.marseille.core.base.utils

import androidx.lifecycle.MutableLiveData


fun MutableLiveData<Boolean>.get(): Boolean = this.value == true