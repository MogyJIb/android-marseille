package by.gomel.marseille.feature.about.presentation.contacts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.about.R
import kotlinx.android.synthetic.main.fragment_contacts.*


class ContactsFragment : BaseFragment() {

    companion object {
        @JvmStatic fun newInstance() = ContactsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_contacts, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        instagram_button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.instagram.com/marseille_gomel/")))
        }
        vkontakte_button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://vk.com/marseillegomel")))
        }
        odnoklassniki_button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://ok.ru/marseillegomel")))
        }
    }

}