package tk.mwacha.facade;

public interface ProductFacadeInterface {
    void addProduct(final ProductFacadeInput input);
    CheckStockFacadeOutput checkStock(final CheckStockFacadeInput input);
}
