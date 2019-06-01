package by.gomel.marseille.core.base.utils

import androidx.fragment.app.Fragment


fun <T> Fragment.getArgument(key: String) = arguments?.get(key) as? T