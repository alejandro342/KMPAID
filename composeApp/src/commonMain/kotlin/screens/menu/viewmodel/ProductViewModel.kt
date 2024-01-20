package screens.menu.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import webservices.WebServices

class ProductViewModel : ViewModel() {


    init {
        getProduct()
    }

    private fun getProduct() {
        viewModelScope.launch(Dispatchers.Default) {
            WebServices().getProducts()
        }
    }
}