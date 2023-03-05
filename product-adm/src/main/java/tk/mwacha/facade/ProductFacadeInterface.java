package tk.mwacha.facade;

public interface ProductFacadeInterface {
    ProductFacadeOutput addProduct(final ProductFacadeInput input);
    CheckStockFacadeOutput checkStock(final CheckStockFacadeInput input);
}
