package by.gomel.marseille.core.base.view

import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity()  {

    protected open val coordinator: BaseContract.Coordinator? = null

    override fun onSupportNavigateUp() = coordinator?.navigateUp() ?: false

}