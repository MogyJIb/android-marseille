package by.gomel.marseille

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import org.koin.android.ext.android.getKoin


class LauncherActivity : AppCompatActivity() {

    private val navController: NavController
        get() = findNavController(R.id.launcher_nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        getKoin().setProperty("appNavController", navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

}