package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.repository.OrderModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
public class Order  extends BaseEntity {

    private UUID invoiceId;
    private Client client;
    private List<Product> products;
    private String status;

    public static Order of(OrderModel order) {
        return Order.builder()
                .client(Client.from(order.getClientModel()))
                .invoiceId(order.getInvoiceId())
                .products(order.getProducts().stream().map(Product::from).toList())
                .status(order.getStatus()).build();
    }

    public void approve() {
        this.status = "approved";
    }

//    public BigDecimal total() {
//        return this.products.reduce((total, product) => total + product.price, 0);
//    }
}
