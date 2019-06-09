package by.gomel.city.test

import android.app.LauncherActivity
import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.tabs.KTabLayout
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.agoda.kakao.text.TextViewActions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ServiceCategoryFragmentTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule<LauncherActivity>(LauncherActivity::class.java)

    private val serviceCategoryScreen = ServiceCategoryScreen()

    @Test
    fun initial_view_property() {
        serviceCategoryScreen {
            clearButton { isVisible() }
            amountTextView { hasText("0.0") }
            tabLayout {
                isTabSelected(0)
            }
        }
    }

    @Test
    fun clear_text_view_by_button_click() {
        serviceCategoryScreen {
            amountTextView { setText("250.0") }
            clearButton { click() }
            amountTextView { hasText("0.0") }
        }
    }
}

class ServiceCategoryScreen : Screen<ServiceCategoryScreen>() {

    val clearButton = KButton { withId(R.id.clear_button) }
    val amountTextView = KTextView { withId(R.id.amount_text_view) }
    val tabLayout = KTabLayout { withId(R.id.tab_layout) }

}

fun TextViewActions.setText(text: String) {
    view.perform(object : ViewAction {
        override fun getDescription() = "Set text: $text"

        override fun getConstraints() = ViewMatchers.isAssignableFrom(TextView::class.java)

        override fun perform(uiController: UiController, view: View) {
            if (view is TextView) {
                view.text = text
            }
        }
    })
}

