package by.gomel.marseille.feature.goods.presentation.cart

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.core.base.utils.addItemDecoration
import by.gomel.marseille.core.base.utils.hide
import by.gomel.marseille.core.base.utils.show
import by.gomel.marseille.core.base.utils.toast
import by.gomel.marseille.core.base.view.InfoDialog
import by.gomel.marseille.data.models.CartDto
import by.gomel.marseille.feature.goods.R
import by.gomel.marseille.feature.goods.presentation.BaseGoodsFragment
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.android.ext.android.inject


class CartFragment : BaseGoodsFragment(), CartContract.View {

    override val presenter: CartContract.Presenter by inject()

    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_cart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideCart()
        setTitle("Корзина")

        clear_cart_button.setOnClickListener {
            InfoDialog.newInstance(
                title = "Очистка корзины",
                message = "Вы действительно хотите очистить корзину?",
                leftButtonCaption = getString(R.string.cancel),
                rightButtonCaption = getString(R.string.resume)
            ).apply {
                rightButtonListener = DialogInterface.OnClickListener { _, _ ->
                    presenter.onClearButtonClicked()
                }
            }.show(childFragmentManager, InfoDialog::class.java.simpleName)
        }

        /* Init adapter and set up recycler view */
        cartAdapter = CartAdapter()

        cart_recycler_view.apply {
            adapter = cartAdapter
            addItemDecoration(DividerItemDecoration.VERTICAL, R.drawable.list_divider)
        }

        button_buy.setOnClickListener {
            OrderDialogFragment.newInstance().apply {
                rightButtonListener = DialogInterface.OnClickListener { _, _ ->
                    context?.toast("Ваш заказ успешно оформлен, ожидайте обратной связи")
                    coordinator.navigateUp()
                }
            }.show(childFragmentManager, InfoDialog::class.java.simpleName)
        }

        presenter.initData()
    }

    override fun onDestroyView() {
        showCart()
        super.onDestroyView()
    }

    override fun updateCartDtoList(services: List<CartDto>) {
        if (services.isEmpty())
            empty_view.show()
        else
            empty_view.hide()

        cartAdapter.updateItems(services.toMutableList())
    }

    override fun updateTotalAmount(amount: String) { amount_text_view.text = amount }
    override fun isShowBackButton() = true

}